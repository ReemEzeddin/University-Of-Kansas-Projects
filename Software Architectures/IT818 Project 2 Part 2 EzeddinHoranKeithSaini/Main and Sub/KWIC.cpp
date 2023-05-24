#include "KWIC.h"
#include <stdlib.h>
#include <iostream>
#include <fstream>
#include <string>
#include <windows.h>
#include <wchar.h> 
#include <sstream>
#include <vector>
#include<algorithm>

using namespace std;

vector<string> WordsToRemoveList;
vector<string> CompleteFilelist;
vector<string> Singlelist;
vector<string> dictionary;

bool DeleteUnwantedWords(string str1)
{
    std::transform(str1.begin(),
        str1.end(),
        str1.begin(),
        [](unsigned char const& c) {
            return ::tolower(c);
        });
    auto itr = find(WordsToRemoveList.begin(), WordsToRemoveList.end(), str1);
    if (itr != WordsToRemoveList.end())
    {
        return true;
    }
    return false;
}

void CaseInsensitiveSort(vector<string>& strs)
{
    sort(
        begin(strs),
        end(strs),
        [](const string& str1, const string& str2) {
            return lexicographical_compare(
                begin(str1), end(str1),
                begin(str2), end(str2),
                [](const char& char1, const char& char2) {
                    return tolower(char1) < tolower(char2);
                }
            );
        }
    );
}

void ReadRemoveWords()
{
    wchar_t path[1000] = { 0 };
    GetCurrentDirectory(1000, path);
    wchar_t File[1000] = L"\\removewords.txt";
    wcscat_s(path, 1000, File);
    ifstream in(path);
    string word;
    if (!in)
    {
        cout << "No remove file in directory";
        return;
    }
    while (getline(in, word, '\n'))
    {
        WordsToRemoveList.push_back(word);
    }
}

void GetShiftedTexts(vector<string> wordlist)
{
    int last = wordlist.size() - 1;
    int index = 0;
    string strlist = "";
    Singlelist.clear();
    vector<string>::reverse_iterator i = wordlist.rbegin();
    Singlelist.push_back(*i);
    if (wordlist.size() <= 1)
    {
        for (const auto& word : Singlelist)
        {
            strlist += word + " ";
        }
        dictionary.push_back(strlist);
    }
    else
    {
        for (vector<string>::iterator ai = wordlist.begin(); ai != wordlist.end(); ++ai)
        {
            Singlelist.push_back(*ai);
            index++;
            if (index == last)
            {
                for (const auto& word : Singlelist)
                {
                    strlist += word + " ";
                }
                dictionary.push_back(strlist);
                break;
            }
        }
    }
}

void WriteToOutputFile(vector<string> printfile) {
    ofstream file;
    file.open("output.txt");
    for (int i = 0; i < printfile.size(); ++i) {
        file << printfile[i] << endl;
    }
    file.close();
}

void PrintSortedOutput()
{
    for (vector<string>::iterator ai = dictionary.begin(); ai != dictionary.end(); ++ai)
        cout << *ai << endl;
}

int main()
{
    string word;
    // Read the words that need to be eliminated
    ReadRemoveWords();
    // User command key
    char key = char();
    do
    {
        // Print input message
        cout << "Add(A/a), Display(D/d), Quit(q): ";
        // Get input key
        cin >> key;
        cin.get();
        // Do as command
        switch (key)
        {
            // Add text into input
        case 'a':
        case 'A':
        {
            // Print the cursor
            cout << "> ";
            // Keyboard input	
            getline(cin, word);
            if (word != "")
            {
                // Add to storage
                CompleteFilelist.push_back(word);
                // KWIC Algorithm
                int iShiftcount = 0;
                string strWord;
                for (vector<string>::iterator ai = CompleteFilelist.begin(); ai != CompleteFilelist.end(); ++ai)
                {
                    strWord = "";
                    iShiftcount = 0;
                    Singlelist.clear();
                    istringstream ss(*ai);
                    while (ss >> strWord)
                    {
                        // retrieving each line from file and puting into singlelist for shifting
                        if (DeleteUnwantedWords(strWord) == false)
                        {
                            Singlelist.push_back(strWord);
                            iShiftcount++;
                        }
                    }
                    while (iShiftcount >= 1)
                    {
                        GetShiftedTexts(Singlelist);
                        iShiftcount--;
                    }
                }
                //sorting of list
                CaseInsensitiveSort(dictionary);
            }
        }
        break;
        // Print KWIC Result
        case 'D':
        case 'd':
            if (CompleteFilelist.size() == 0)
            {
                cout << "No input values." << endl;
            }
            else
            {
                // Output from KWIC
                PrintSortedOutput();
            }
            break;
            // Quit the app
        case 'q':
        case 'Q':
            WriteToOutputFile(dictionary);
            break;
            // Undefined key
        default:
            cout << "Invalid Key!" << endl;
            break;
        }
    } while (key != 'q' && key != 'Q');
    cout << endl << "[Process Complete]" << endl;
    return 0;
}
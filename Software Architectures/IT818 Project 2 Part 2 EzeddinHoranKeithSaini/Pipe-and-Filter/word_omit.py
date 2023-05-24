#query = 'What is hello'
with open ("input_data.txt", "r", encoding="utf-8", errors="ignore") as myfile:
    stopwords = ['a', 'an', 'the', 'and', 'A', 'An', 'The', 'And']
    for str in myfile:
        querywords = str.split()
        resultwords  = [word for word in querywords if word not in stopwords]
        print (' '.join(resultwords))

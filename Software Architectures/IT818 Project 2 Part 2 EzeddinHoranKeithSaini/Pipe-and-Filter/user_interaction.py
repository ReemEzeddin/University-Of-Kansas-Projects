from signal import signal, SIGPIPE, SIG_DFL
signal(SIGPIPE,SIG_DFL)

myfilea = open("output3.txt", "a")
myfiled = open("output3.txt", "r")

while True:
    try:
        decision = input("Choose one of the options avaliable: Add (A/a), Display (D/d), Quit (Q/q)\n")
    except EOFError:
        print("There was an EOF error")
        break

    if decision == "A" or decision == "a":
        addition = input("What would you like to add?\n")
        #myfilea = open("output3.txt", "a")
        myfilea.write(addition)
        #myfilea.close()
    elif decision == "D" or decision == "d":
        print(myfiled.read())
    elif decision == "Q" or decision == "q":
        break
    else:
        print("not valid option")


myfilea.close()
myfiled.close()

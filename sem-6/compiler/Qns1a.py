#DFA accepting binary string that start with 0 and ends with 1
string = input("Enter a string : ");

def checkString(n):
    for i in range(len(n)):
        if n[i] != '0' and n[i] != '1':
            print("invalid input")
            exit()

    if(n[0] == '0' and n[-1] == '1'):
        print("Accepted")
    else:
        print("Rejected")

checkString(string)


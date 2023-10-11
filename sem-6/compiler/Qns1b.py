#DFA accepting the valid variable names in C program

name = input("Enter variable name : ")

# check first character of the variable name
def checkName(n):
    if (n[0] != '_' and not n[0].isalpha()):
        return False

    for i in range(1, len(name)):
        if (not n[i].isalnum() and n[i] != '_'):
            return False

    return True

if(checkName(name)):
    print("Accepted")
else:
    print("Rejected")

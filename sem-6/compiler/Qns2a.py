#NFA to accept RE (a+b)*a over alphabets {a, b}
string = input('Enter a string : ')

for i in range(len(string)):
        if string[i] != 'a' and string[i] != 'b':
            print("invalid input")
            exit()

if string[-1] == 'a':
    print("Accepted")
else:
    print("Rejected")
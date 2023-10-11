#NFA to accept RE (a+b)(a+b) over alphabets {a, b}
string = input('Enter a string : ')

for i in range(len(string)):
        if string[i] != 'a' and string[i] != 'b':
            print("invalid input")
            exit()

if len(string) != 2:
      print('Rejected')
else: 
      print('Accepted')
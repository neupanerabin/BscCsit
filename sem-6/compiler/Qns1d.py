#DFA accepting the prepaid NTC number
 
number = input("Enter a NTC number : ")

def checkNumber(n):
    if len(n) != 10:
        print('The number must have exactly 10 digits.')
        exit()
    
    code = n[:4]

    if code == '9814' or code == '9841' or code == '9849' or code == '9843' or code == '9860':
        print('The number is a prepaid NTC number.')
    else:
        print('The number is not a prepaid NTC number.')

checkNumber(number)
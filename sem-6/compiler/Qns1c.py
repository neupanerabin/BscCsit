#DFA accepting the valid gmail ID

email = input('Enter a gmail id : ')

def checkGmail(n):
    #splitting the email into prefix and domain
    a = n.split('@')
    prefix = a[0]
    domain = a[1]

    #checking if the domain is "gmail.com"
    if domain != "gmail.com":
        print("The name is not gmail.")
        return False

    #checking if first and last character of prefix is alphanumeric
    if not prefix[0].isalnum() or not prefix[-1].isalnum():
        print("The first and last character of the username must be alphanumeric.")
        return False

    #checking if the prefix only contains letters, numbers and period
    for i in range(len(prefix)):
        if not prefix[i].isalnum() and prefix[i] != '.':
            print("Only letters(a-z), numbers(0-9), and periods(.) are allowed.")
            return False
        
    #checking if consecutive periods are present
    for i in range(len(prefix) - 1):
        if prefix[i] == '.' and prefix[i+1] == '.':
            print("Username cannot contain consecutive periods.")
            return False
        
    return True

if checkGmail(email):
    print("The email is valid.")
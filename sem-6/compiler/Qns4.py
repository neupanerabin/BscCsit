#Program to create a symbol table

import pandas as pd
# Function to create symbol table
def create_symbol_table(variables):
    symbol_table = []
    address = 100
    for var, value in variables.items():
        entry = {}
        entry['Name'] = var
        if(type(value) == int):
            entry['Type'] = 'integer'
        elif(type(value) == str):
            entry['Type'] = 'string'
        elif(type(value) == bool):
            entry['Type'] = 'Boolean'
        else:
            entry['Type'] = 'real number'
        #entry['Type'] = 'integer' if type(value) is int else 'real number'
        entry['Value'] = value
        entry['Address'] = address
        address += 100
        symbol_table.append(entry)
    return symbol_table

# Example usage:
variables = {'a': 2, 'b': 3.5, 'c': '$cott', 'd': True}
symbol_table = create_symbol_table(variables)

# Print symbol table
print(pd.DataFrame(symbol_table))
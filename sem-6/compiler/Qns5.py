# Program to find non-terminals, terminals, productions, and starting symbol from a grammar
def find_grammar_info(grammar):
    # Initialize empty sets for non-terminals and terminals
    non_terminals = set()
    terminals = set()

    # Split the grammar into lines and process each line
    productions = []
    for line in grammar.split('\n'):
        line = line.strip()
        if not line:
            continue  # Skip empty lines
        if '->' in line:
            left, right = line.split('->')
            left = left.strip()
            right = right.strip().split()
            non_terminals.add(left)
            productions.append((left, right))
            for symbol in right:
                if symbol.isalpha() and not symbol.isupper():
                    terminals.add(symbol)

    # Find the starting symbol (first non-terminal found)
    starting_symbol = next(iter(non_terminals))

    return non_terminals, terminals, productions, starting_symbol

# Example grammar
grammar = """
S -> A B
A -> a A | ε
B -> b B | ε
"""

# Find and print grammar information
non_terminals, terminals, productions, starting_symbol = find_grammar_info(grammar)

print("Non-terminals:", non_terminals)
print("Terminals:", terminals)
print("Productions:")
for production in productions:
    print(f"{production[0]} -> {' '.join(production[1])}")
print("Starting Symbol:", starting_symbol)

#program to remove left recursion from a grammar

def remove_immediate_left_recursion(A, productions):
    A_prime = A + "'"
    alpha_productions = []
    beta_productions = []
    for production in productions:
        if production.startswith(A):
            alpha_productions.append(production[len(A):] + A_prime)
        else:
            beta_productions.append(production + A_prime)

    if alpha_productions:
        return {A: beta_productions, A_prime: alpha_productions + ['ε']}
    else:
        return {A: productions}


def remove_left_recursion(grammar):
    non_terminals = list(grammar.keys())
    new_grammar = {}

    for A in non_terminals:
        new_productions = []
        for production in grammar[A]:
            if production[0] in non_terminals:
                B = production[0]
                alpha = production[1:]
                for beta in new_grammar.get(B, [B]):
                    new_productions.append(beta + alpha)
            else:
                new_productions.append(production)

        immediate_left_recursion_removed = remove_immediate_left_recursion(A, new_productions)
        new_grammar.update(immediate_left_recursion_removed)

    return new_grammar


# define the grammar
grammar1 = {
    'S': ['Sab', 'ab', 'a', 'b']
}

grammar2 = {
    'A': ['A0', 'A1', '0']
}

# remove left recursion
new_grammar1 = remove_left_recursion(grammar1)
new_grammar2 = remove_left_recursion(grammar2)
print(new_grammar1)
print(new_grammar2)

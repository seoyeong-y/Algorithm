def solution(my_string):
    char = ['a', 'e', 'i', 'o', 'u']
    for n in char:
        my_string = my_string.replace(n, '')
    return my_string
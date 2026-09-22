def solution(s):
    char = []
    
    for c in s:
        if char and char[-1] == c:
            char.pop()
        else:
            char.append(c)
    
    return 1 if not char else 0
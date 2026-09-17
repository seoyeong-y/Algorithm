from collections import Counter

def solution(clothes):
    counts = Counter([category for _, category in clothes])
    
    answer = 1
    for count in counts.values():
        answer *= (count + 1)
        
    return answer - 1
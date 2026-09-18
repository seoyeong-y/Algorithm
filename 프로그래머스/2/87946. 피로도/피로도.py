from itertools import permutations

def solution(k, dungeons):
    answer = 0
    
    for p in permutations(dungeons, len(dungeons)):
        cur = k
        count = 0
        
        for min_req, fatigue in p:
            if cur >= min_req:
                cur -= fatigue
                count += 1
            else:
                break
        
        answer = max(answer, count)

    return answer
from collections import deque

def solution(people, limit):
    answer = 0
    queue = deque(sorted(people))
    
    while queue:
        now = queue.pop()
    
        if queue and now + queue[0] <= limit:
            queue.popleft()
            
        answer += 1
    
    return answer
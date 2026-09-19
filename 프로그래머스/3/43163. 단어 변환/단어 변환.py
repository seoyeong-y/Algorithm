from collections import deque

def solution(begin, target, words):
    if target not in words:
        return 0
    
    visited = [False] * (len(words))
    
    queue = deque([(begin, 0)])
    
    while queue:
        cur, step = queue.popleft()
        
        if cur == target:
            return step
        
        for nxt in range(len(words)):
            if not visited[nxt]:
                diff = 0
                for c1, c2 in zip(cur, words[nxt]):
                    if c1 != c2:
                        diff += 1
                
                if diff == 1:
                    visited[nxt] = True
                    queue.append((words[nxt], step + 1))
            
    return answer
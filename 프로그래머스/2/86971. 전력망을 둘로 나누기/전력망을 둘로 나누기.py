from collections import deque

def bfs(start, n, graph):
    visited = [False] * (n + 1)
    queue = deque([start])
    visited[start] = True
    count = 1
    
    while queue:
        curr = queue.popleft()
        for nxt in graph[curr]:
            if not visited[nxt]:
                visited[nxt] = True
                queue.append(nxt)
                count += 1
    
    return count

def solution(n, wires):
    min_diff = n
    
    for i in range(len(wires)):
        graph = [[] for _ in range(n+1)]
        for j, (v1, v2) in enumerate(wires):
            if i == j:
                continue
            graph[v1].append(v2)
            graph[v2].append(v1)
            
        cnt = bfs(wires[i][0], n, graph)
        diff = abs(cnt - (n - cnt))
        
        min_diff = min(min_diff, diff)
        
    return min_diff
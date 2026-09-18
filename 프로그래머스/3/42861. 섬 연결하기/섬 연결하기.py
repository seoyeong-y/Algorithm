def solution(n, costs):
    costs.sort(key=lambda x: x[2])
    
    parent = [i for i in range(n)]
    
    def find(x):
        if parent[x] != x:
            parent[x] = find(parent[x])
        return parent[x]
    
    def union(a, b):
        root_a = find(a)
        root_b = find(b)
        if root_a < root_b:
            parent[root_b] = root_a
        else:
            parent[root_a] = root_b
            
    total = 0
    count = 0
    
    for u, v, cost in costs:
        if find(u) != find(v):
            union(u, v)
            total += cost
            count += 1
            if count == n - 1:
                break
        
    return total
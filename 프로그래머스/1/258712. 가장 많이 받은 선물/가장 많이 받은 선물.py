def solution(friends, gifts):
    n = len(friends)
    counts = [[0 for j in range(n)] for i in range(n)]
    points = [0 for j in range(n)]
    result = [0 for j in range(n)]
    
    for i in gifts:
        g1, g2 = i.split()
            
        idx1 = friends.index(g1)
        idx2 = friends.index(g2)
            
        counts[idx1][idx2] += 1
        
    for j in range(n):
        give = sum(counts[j][i] for i in range(n))
        receive = sum(counts[i][j] for i in range(n))
        points[j] = give - receive
        
    for k in range(n):
        for l in range(k+1,n):
            c1 = counts[k][l]
            c2 = counts[l][k]
            
            if c1 > c2:
                result[k] += 1
                
            elif c1 < c2:
                result[l] += 1
                
            elif points[k] > points[l]:
                result[k] += 1
                
            elif points[k] < points[l]:
                result[l] += 1
                
    return max(result)
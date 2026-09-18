def solution(n, lost, reserve):
    real_lost = sorted([l for l in lost if l not in reserve])
    real_reserve = sorted([r for r in reserve if r not in lost])
    
    for r in real_reserve:
        if r-1 in real_lost:
            real_lost.remove(r-1)
            
        elif r+1 in real_lost:
            real_lost.remove(r+1)
        
    return n - len(real_lost)
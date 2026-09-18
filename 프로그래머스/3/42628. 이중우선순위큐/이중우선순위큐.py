import heapq

def solution(operations):
    heap = []
    
    for operation in operations:
        alpha, num = operation.split()
        num = int(num)
        
        if alpha == "I":
            heapq.heappush(heap, num)
            
        elif alpha == "D" and heap:
            if num == 1:
                heap.remove(max(heap))
                heapq.heapify(heap)

            elif num == -1:
                heapq.heappop(heap)
    
    if not heap:
        return [0, 0]
    
    return [max(heap), min(heap)]
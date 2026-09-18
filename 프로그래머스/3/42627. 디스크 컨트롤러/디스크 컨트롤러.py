import heapq

def solution(jobs):
    n = len(jobs)
    jobs.sort(key=lambda x: x[0])
    
    total_response_time = 0
    now = 0
    i = 0
    wait_heap = []
    
    while i < n or wait_heap:
        while i < n and jobs[i][0] <= now:
            heapq.heappush(wait_heap, (jobs[i][1], jobs[i][0]))
            i += 1
            
        if wait_heap:
            job_time, request_time = heapq.heappop(wait_heap)
            now += job_time
            total_response_time += (now - request_time)
        else:
            now = jobs[i][0]
        
    return total_response_time // n
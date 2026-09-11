def solution(array):
    nums = list(set(array))
    counts = [array.count(x) for x in nums]
    
    max_count = max(counts)
    
    if counts.count(max_count) > 1:
        return -1
    
    return nums[counts.index(max_count)]
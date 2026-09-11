def solution(num, total):
    var = sum(range(num+1))
    diff = total - var
    start = diff // num
    return [i+start for i in range(1, num+1)]
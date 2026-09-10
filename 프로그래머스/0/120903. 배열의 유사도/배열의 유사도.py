def solution(s1, s2):
    answer = 0
    for text in s1:
        if text in s2:
            answer += 1
    return answer
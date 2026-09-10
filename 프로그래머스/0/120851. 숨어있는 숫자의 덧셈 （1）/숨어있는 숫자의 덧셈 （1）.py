def solution(my_string):
    answer = 0
    for n in my_string:
        if n.isdigit():
            answer += int(n)
    return answer
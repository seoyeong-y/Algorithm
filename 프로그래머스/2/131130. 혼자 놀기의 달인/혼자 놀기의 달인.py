def solution(cards):
    opened = [0] * len(cards)

    first = 0
    second = 0

    for i in range(len(cards)):
        if opened[i] == 1:
            continue

        cnt = 0
        j = i

        while opened[j] == 0:
            opened[j] = 1
            cnt += 1
            j = cards[j] - 1

        if cnt > first:
            second = first
            first = cnt
        elif cnt > second:
            second = cnt

    return first * second
def solution(common):
    if common[2] - common[1] == common[1] - common[0]:
        d = common[1] - common[0]
        return common[-1] + d
    else:
        r = common[1] // common[0]
        return common[-1] * r
from math import lcm

def solution(signals):
    cycle = 1

    for G, Y, R in signals:
        cycle = lcm(cycle, G + Y + R)

    for t in range(1, cycle + 1):
        all_yellow = True

        for G, Y, R in signals:
            period = G + Y + R
            x = t % period

            if not (G < x <= G + Y):
                all_yellow = False
                break

        if all_yellow:
            return t

    return -1
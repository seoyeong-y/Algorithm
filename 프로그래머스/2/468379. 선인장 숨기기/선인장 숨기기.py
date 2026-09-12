def solution(m, n, h, w, drops):
    l = len(drops)
    arr = [[l + 1] * n for _ in range(m)]

    for i, (x, y) in enumerate(drops):
        arr[x][y] = i + 1

    def check(mid):
        point = [[0] * (n + 1) for _ in range(m + 1)]

        for i in range(m):
            row_sum = 0

            for j in range(n):
                if arr[i][j] < mid:
                    row_sum += 1

                point[i + 1][j + 1] = point[i][j + 1] + row_sum

        for x in range(m - h + 1):
            for y in range(n - w + 1):
                cnt = (
                    point[x + h][y + w]
                    - point[x][y + w]
                    - point[x + h][y]
                    + point[x][y]
                )

                if cnt == 0:
                    return [x, y]

        return None

    left = 1
    right = l + 1

    while left < right:
        mid = (left + right + 1) // 2

        if check(mid) is not None:
            left = mid
        else:
            right = mid - 1

    return check(left)
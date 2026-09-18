def solution(name):
    # 알파벳 변경 (상/하) 횟수
    count = sum(min(ord(c) - ord('A'), ord('Z') - ord(c) + 1) for c in name)
       
    # 커서 이동 (좌/우) 횟수
    n = len(name)
    move = n - 1
    
    for i in range(n):
        # 현재 위치 이후 연속된 A가 끝나는 위치 next_idx 탐색
        next_idx = i + 1
        while next_idx < n and name[next_idx] == 'A':
            next_idx += 1
            
        # i까지 갔다가 next_idx로 돌아가는 거리 비교
        # 1. 오른쪽으로 갔다가 왼쪽으로
        # 2. 왼쪽으로 갔다가 오른쪽으로
        move = min(move, 2 * i + n - next_idx, i + 2 * (n - next_idx))
        
    return count + move
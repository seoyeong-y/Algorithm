def to_seconds(time_str):
    m, s = map(int, time_str.split(':'))
    return m * 60 + s

def to_string(sec):
    m = sec // 60
    s = sec % 60
    return f"{m:02d}:{s:02d}"

def solution(video_len, pos, op_start, op_end, commands):
    video_sec = to_seconds(video_len)
    pos_sec = to_seconds(pos)
    op_s_sec = to_seconds(op_start)
    op_e_sec = to_seconds(op_end)

    if op_s_sec <= pos_sec <= op_e_sec:
        pos_sec = op_e_sec

    for command in commands:
        if command == 'next':
            pos_sec = min(video_sec, pos_sec + 10)
        elif command == 'prev':
            pos_sec = max(0, pos_sec - 10)

        if op_s_sec <= pos_sec <= op_e_sec:
            pos_sec = op_e_sec

    return to_string(pos_sec)
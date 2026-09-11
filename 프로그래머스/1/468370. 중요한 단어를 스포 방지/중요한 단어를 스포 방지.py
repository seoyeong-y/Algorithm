def get_idx(message, index):
    start = index
    end = index
    
    while start > 0 and message[start-1] != ' ':
        start -= 1
        
    while end < len(message)-1 and message[end+1] != ' ':
        end += 1
        
    return start, end


def check_word(message, start, end):
    count = 0
    word = message[start:end+1]

    message = message[:start] + '#' * (end-start+1) + message[end+1:]
    
    if word not in message.split():
        count += 1
    
    return count, message


def solution(message, spoiler_ranges):
    answer = 0

    for i in range(len(spoiler_ranges)-1, -1, -1):
        start = spoiler_ranges[i][0]
        end = spoiler_ranges[i][1]
        
        part = message[start:end+1]
        
        if '#' in part:
            part = part[:part.index('#')]
            end = start + len(part) - 1
            
        if part == '':
            continue 

        spaces = [
            index + start
            for index, char in enumerate(part)
            if char == ' '
        ]
        
        sp_idx = []
        
        if spaces:
            if spaces[0] > start:
                sp_idx.append(spaces[0] - 1)
            
            for j in spaces:
                if j < end:
                    sp_idx.append(j + 1)
        else:
            sp_idx.append(start)

        for idx in reversed(sp_idx):
            w_start, w_end = get_idx(message, idx)

            count, message = check_word(
                message,
                w_start,
                w_end
            )

            answer += count
                    
    return answer
def solution(array, commands):
    answer = []
    
    for command in commands:
        new_arr = array[command[0]-1:command[1]]
        new_arr.sort()
        answer.append(new_arr[command[2]-1])
        
    return answer
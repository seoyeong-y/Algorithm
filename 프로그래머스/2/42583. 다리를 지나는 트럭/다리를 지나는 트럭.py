from collections import deque
def solution(bridge_length, weight, truck_weights):
    
    is_final = False
    
    bridge = deque([0] * bridge_length)
    trucks = deque(truck_weights)
    cur_weight = 0
    time = 0
    
    while trucks or cur_weight > 0:
        time += 1
        
        out = bridge.popleft()
        cur_weight -= out
        
        if trucks:
            if cur_weight + trucks[0] <= weight:
                next_truck = trucks.popleft()
                bridge.append(next_truck)
                cur_weight += next_truck
            else:
                bridge.append(0)
        
    return time
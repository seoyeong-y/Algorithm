def solution(bandage, health, attacks):
    answer = 0
    
    cycle, recovery, add = bandage
    success = 0
    final = attacks[-1][0]
    i = 1
    max_h = health
    
    while i <= final:
        if i == attacks[0][0]:
            success = 0
            health -= attacks[0][1]
            del attacks[0]
            if health <= 0:
                return -1
        else:
            success += 1
            health += recovery
            
            if success == cycle:
                success = 0
                health += add

            if health > max_h:
                health = max_h 

        i += 1        
        
    return health
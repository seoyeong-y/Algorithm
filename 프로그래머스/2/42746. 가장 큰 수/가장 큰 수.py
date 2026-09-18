def solution(numbers):
    numbers = list(map(str, numbers))
    
    # 원소가 최대 1000이므로 3자리 이상으로 맞춰 앞자리 우선순위 비교 ('3' -> '333' vs '30' -> '303030')
    numbers.sort(key=lambda x: x*3, reverse=True)
    
    if numbers[0] == '0':
        return '0'
        
    return ''.join(numbers)
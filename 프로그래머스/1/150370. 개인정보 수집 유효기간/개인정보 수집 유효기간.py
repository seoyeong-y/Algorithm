def solution(today, terms, privacies):
    answer = []
    year, month, day = map(int, today.split('.'))
    term_dict = dict()
    
    for term in terms:
        key, value = term.split()
        term_dict[key] = int(value)
    
    for i, privacy in enumerate(privacies, 1):
        p_date, grade = privacy.split()
        p_year, p_month, p_day = map(int, p_date.split('.'))
        
        due = term_dict[grade]
        p_year += (p_month + due - 1) // 12
        p_month = (p_month + due - 1) % 12 + 1
        
        if year > p_year:
            answer.append(i)
        elif year == p_year:
            if month > p_month:
                answer.append(i)
            elif month == p_month:
                if day >= p_day:
                    answer.append(i)
        
    return answer
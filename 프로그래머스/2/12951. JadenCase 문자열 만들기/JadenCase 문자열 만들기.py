def solution(s):
    text = s.split(' ')
    
    return ' '.join([t.capitalize() for t in text])
def solution(answers):
    result = []
    s1 = [1, 2, 3, 4, 5]
    s2 = [2, 1, 2, 3, 2, 4, 2, 5]
    s3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    scores = [0, 0, 0]
    
    for i, answer in enumerate(answers):
        if answer == s1[i % len(s1)]:
            scores[0] += 1
        if answer == s2[i % len(s2)]:
            scores[1] += 1
        if answer == s3[i % len(s3)]:
            scores[2] += 1
            
    max_score = max(scores)

    for idx, score in enumerate(scores):
        if score == max_score:
            result.append(idx + 1)
        
    return result
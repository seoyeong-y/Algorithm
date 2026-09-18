def solution(word):
    dictionary = []
    vowels = ['A', 'E', 'I', 'O', 'U']
    
    def dfs(current_word):
        if len(current_word) > 5:
            return 
        
        if current_word:
            dictionary.append(current_word)
            
        for char in vowels:
            dfs(current_word + char)
            
    dfs("")
    
    return dictionary.index(word) + 1
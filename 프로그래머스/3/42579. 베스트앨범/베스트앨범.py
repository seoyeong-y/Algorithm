from collections import defaultdict

def solution(genres, plays):
    answer = []
    play_count = defaultdict(int)
    music_dict = defaultdict(list)
    
    for idx, (genre, play) in enumerate(zip(genres, plays)):
        play_count[genre] += play
        music_dict[genre].append((play, idx))
        
    sorted_genres = sorted(play_count.keys(), key=lambda x: play_count[x], reverse=True)
    
    for genre in sorted_genres:
        sorted_songs = sorted(music_dict[genre], key=lambda x: (-x[0], x[1]))
        
        for play, idx in sorted_songs[:2]:
            answer.append(idx)
            
    return answer
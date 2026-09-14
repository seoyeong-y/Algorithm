def solution(id_list, report, k):
    send_to = {name: set() for name in id_list}
    l = len(id_list)
    mail = {name: 0 for name in id_list}
    
    for text in report:
        sender, receiver = text.split()
        send_to[receiver].add(sender)
    
    for receiver, senders in send_to.items():
        if len(senders) >= k:
            for sender in senders:
                mail[sender] += 1
            
    return [mail[name] for name in id_list]
    
        
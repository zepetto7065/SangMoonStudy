participant = ["leo", "kiki", "eden","leo"]
completion = ["eden","leo" ,"kiki"]


def solution(participant, completion) :
    for i in range(len(completion)) :
        if completion[i] in participant :
            participant.remove(completion[i])

    return participant[0]


print(solution(participant, completion))

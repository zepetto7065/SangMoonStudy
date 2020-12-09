participant = ["leo", "kiki", "eden","leo"]
completion = ["eden","leo" ,"kiki"]


def solution(participant, completion) :
    for i in range(len(completion)) :
        if completion[i] in participant :
            participant.remove(completion[i])

    return participant[0]


print(solution(participant, completion))

#
# import collections
# participant = ["leo", "kiki", "eden","leo"]
# completion = ["eden","leo" ,"kiki"]
#
# def solution(participant, completion):
#     answer = collections.Counter(participant) - collections.Counter(completion)
#     print(answer)
#     return list(answer.keys())[0]
#
# print(solution(participant,completion))
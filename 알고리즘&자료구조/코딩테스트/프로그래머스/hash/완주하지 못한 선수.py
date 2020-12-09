participant = ["leo", "kiki", "eden","leo"]
completion = ["eden","leo" ,"kiki"]


def solution(participant, completion) :
    for i in range(len(completion)) :
        if completion[i] in participant :
            participant.remove(completion[i])

    return participant[0]


print(solution(participant, completion))


#include <string>
#include <vector>
#include <algorithm>

# using namespace std;
#
# string solution(vector<string> participant, vector<string> completion) {
#     string answer = "";
#     sort(participant.begin(), participant.end());
#     sort(completion.begin(), completion.end());
#     for(int i=0;i<completion.size();i++)
#     {
#         if(participant[i] != completion[i])
#             return participant[i];
#     }
#     return participant[participant.size() - 1];
#     //return answer;
# }

phoneBook1 = ["119", "9767422", "1195524421"]
phoneBook2 = ["123", "456", "789"]
phoneBook3 = [12, 123, 1235, 567, 88]


def solution(phoneBook) :

    phoneBook = sorted(phoneBook);
    for p1, p2 in zip(phoneBook , phoneBook[1:] ):
        if p2.startswith(p1):
            return False

    return True;


print(solution(phoneBook1))

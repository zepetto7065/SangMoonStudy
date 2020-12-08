# coding=utf-8
# N,M을 공백으로 구분하여 받기
n, m = map(int, input().split())

# 2차원 리스트의 맵 정보 입력 받기
graph = []
for i in range(n):
    graph.append(list(map(int, input())))


def dfs(x, y):
    if x <= -1 or y <= -1 or y >= m or x >= n:
        return False
    # 현재 노드를 방문하지 않았다면
    if graph[x][y] == 0:
        # 해당 노드 방문 처리
        graph[x][y] = 1
        # 상 하 좌 우의 위차도 모두 재귀적 호출
        dfs(x - 1, y)
        dfs(x, y - 1)
        dfs(x + 1, y)
        dfs(x, y + 1)
        return True
    return False


# 모든 노트(위치)에 대하여 음료수 채우기
result = 0
for i in range(n):
    for j in range(m):
        # 현재위치에서 DFS 수행
        if dfs(i, j):
            result += 1

print(result)

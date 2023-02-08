# https://leetcode.com/problems/course-schedule/
from collections import defaultdict
class Solution:
    def canFinish(self, num_courses: int, prerequisites: list[list[int]]) -> bool:
        # using topological sorting as the strategy
        # https://www.interviewcake.com/concept/java/topological-sort
        # the list of prerequisites used as directed graphs
        indegree = defaultdict(int)
        graph = defaultdict(list)
        ordering = []

        # computing indegrees for all nodes (includes encoding the graph in a dictionary format)
        for courses in prerequisites:
            indegree[courses[0]]+=1
            graph[courses[0]].append(courses[1])
            graph[courses[1]].append(courses[0])

        # Identifying any leaf nodes (with no incoming connections)
        nodes_with_no_incoming = []
        for node in graph:
            if indegree[node] == 0:
                nodes_with_no_incoming.append(node)

        # Adding
        while len(nodes_with_no_incoming) > 0:
            node = nodes_with_no_incoming.pop()
            ordering.append(node)

            neighbors = graph[node]
            for neighbor in neighbors:
                indegree[neighbor] -= 1
                if indegree[neighbor] == 0:
                    nodes_with_no_incoming.append(neighbor)

        print(ordering)
        if len(ordering) == len(graph):
            return True
        else:
            return False

if __name__ == '__main__':
    #prerequisites = [[1,0], [2, 1], [4, 0], [3,2]]
    prerequisites = [[1, 0], [0, 1]]
    solution = Solution()
    print(solution.canFinish(2, prerequisites))

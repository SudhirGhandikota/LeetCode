class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        visited = {}
        for idx, num in enumerate(nums):
            diff = target - num
            if diff in visited:
                return [visited[diff], idx]
            visited[num] = idx

if __name__ == '__main__':
    nums = [2, 7, 11, 15]
    target = 9

    solution = Solution()
    print(solution.twoSum(nums, target))
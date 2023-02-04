# https://leetcode.com/problems/maximum-subarray/
class Solution:
    def maxSubArray(self, nums: list[int]) -> int:
        curr_sum = nums[0]
        max_sum = nums[0]
        for num in nums:
            curr_sum = max(num, curr_sum+num) # adding to an existing sequence or restarting a new one
            max_sum = max(max_sum, curr_sum) # maintaining the maximum sub-array sum
        return max_sum

if __name__ == '__main__':
    nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    solution = Solution()
    print(solution.maxSubArray(nums))
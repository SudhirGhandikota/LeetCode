from __future__ import annotations
class Solution:
    def productExceptSelf(self, nums: list[int]) -> list[int]:
        products = [1] * len(nums)
        # prefix (left) products
        for i in range(1, len(nums)):
            products[i] = products[i-1] * nums[i-1]

        # suffix (right) products
        back_prod = 1
        for i in range(len(nums)-2, -1, -1):
            back_prod *= nums[i+1]
            products[i] *= back_prod # forward_product * backward_product
        return products

if __name__ == '__main__':
    nums = [1, 2, 3, 4]
    solution = Solution()
    result = solution.productExceptSelf(nums)
    print(result)
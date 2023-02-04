# https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        min_val = float('inf')
        max_profit = 0
        for price in prices:
            min_val = min(min_val, price) # updating the "best time to buy"
            profit = price - min_val # current profit
            max_profit = max(max_profit, profit) # updating the "best time to sell"
        return max_profit

if __name__ == '__main__':
    prices = [7, 1, 5, 3, 6, 4]

    solution = Solution()
    print(solution.maxProfit(prices))
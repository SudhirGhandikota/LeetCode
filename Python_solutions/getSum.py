# https://leetcode.com/problems/sum-of-two-integers/
# using binary operations (not using + and - operators)
class Solution:
    def getSum(self, a: int, b: int) -> int:
        # using bit-wise operations
        # 1. XOR operations computes the sum between the respective binary numbers
        # 2. bitwise AND + left-shift operator computes the carry
        mask = 0xffffffff # 32-bit mask in hex code. limiting the intgered result to 32-bits
        # the solution is to recursively compute the "sum" and "carry"
        # until carry becomes zero in which case the "sum" variable has the full sum
        while(b & mask > 0):
            carry = (a & b) << 1
            sum = a ^ b
            a = sum
            b = carry
            print(f'Sum: {sum}, Carry: {carry}, exit criteria: {b & mask}')
        return (a & mask) if b >0 else a

if __name__ == '__main__':
    solution = Solution()
    solution.getSum(7, 5)
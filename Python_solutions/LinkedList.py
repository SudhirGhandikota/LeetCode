class Node:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __str__(self):
        return f'Val:{self.val}'

class LL:
    def __init__(self):
        self.root = None

    def add(self, node):
        curr = self.root
        # retrieving the final entry in the list
        while curr.next:
            curr = curr.next
        # adding the new node at the end
        curr.next = Node(val=node)

    def insert(self, nums):
        self.root = Node(val=nums[0])
        for num in nums[1:]:
            self.add(num)

    def print(self):
        curr = self.root
        while curr:
            print(curr.val)
            curr = curr.next

    def reverse(self):
        curr = self.root
        prev, tmp = None, None
        while curr:
            tmp = curr.next
            curr.next = prev
            prev = curr
            curr = tmp
        self.root = prev

    def hasCycle(self):
        if self.root==None or self.root.next==None:
            return False

        slow = self.root # slow pointer
        fast = self.root.next # fast pointer

        while slow and fast:
            # if both the pointers meet, then a cycle exists
            if slow == fast:
                return True

            # updating the slow pointer
            slow = slow.next
            # updating the fast pointer
            if fast.next:
                fast = fast.next.next
            else: # if we have reached the end
                fast = fast.next
        return False




if __name__ == '__main__':
    nums = [1, 2, 3, 4, 5]
    linked_list = LL()
    linked_list.insert(nums)
    linked_list.print()
    linked_list.reverse()
    linked_list.print()
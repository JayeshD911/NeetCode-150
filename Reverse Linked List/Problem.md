# 🔵 206. Reverse Linked List

## 📌 Problem Statement

Given the head of a singly linked list, reverse the list, and return the reversed list.

---

## 🧾 Examples

### Example 1
```
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
```

### Example 2
```
Input: head = [1,2]
Output: [2,1]
```

### Example 3
```
Input: head = []
Output: []
```

---

## 🔒 Constraints

- The number of nodes in the list is in the range `[0, 5000]`
- `-5000 <= Node.val <= 5000`

---

# 🚀 Optimal Approach: Iterative Reversal

## 💡 Key Insight

Reverse pointers one by one:

- Maintain two pointers:
    - `prev` → points to already reversed part
    - `curr` → current node we are processing
- Iterate through the list, reverse links, and move both pointers forward.

---

## 🧑‍💻 Python Code (Iterative)

```python
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev = None
        curr = head
        
        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
        
        return prev
```

---

## ⏱ Complexity

| Metric        | Value |
|--------------|-------|
| Time         | **O(n)** |
| Space        | **O(1)** |

---

# 🚀 Alternative Approach: Recursive

## 💡 Idea

Recursively reverse the rest of the list, and then fix pointers on return.

---

## 🧑‍💻 Python Code (Recursive)

```python
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        
        new_head = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        
        return new_head
```

---

## ⏱ Complexity

| Metric        | Value |
|--------------|-------|
| Time         | **O(n)** |
| Space        | **O(n)** (call stack) |

---

# 📚 Visual Explanation

```
Input:  1 → 2 → 3 → 4 → 5 → None

After Reverse:
5 → 4 → 3 → 2 → 1 → None
```

You reverse each link so that it points backward instead of forward.

---

## 🧠 Common Mistakes

❌ Forgetting to store `next` before changing pointer  
❌ Not setting `head.next = None` in recursive solution  
❌ Not updating pointers in correct order

Always keep track of the next node **before** reversing the current pointer.

---

# 📅 Daily LeetCode Log

- Day: XX
- Topic: Linked List
- Difficulty: Easy
- Language: Python

---


https://neetcode.io/problems/reverse-a-linked-list/question

https://leetcode.com/problems/reverse-linked-list/
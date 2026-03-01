# 🔵 21. Merge Two Sorted Lists

## 📌 Problem Statement

You are given the heads of two sorted linked lists `list1` and `list2`.

Merge the two lists in a **one sorted list**.  
The list should be made by **splicing together the nodes** of the first two lists.

Return the head of the merged linked list.

---

## 🧾 Examples

### Example 1
```
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
```

### Example 2
```
Input: list1 = [], list2 = []
Output: []
```

### Example 3
```
Input: list1 = [], list2 = [0]
Output: [0]
```

---

## 🔒 Constraints

- The number of nodes in both lists is in the range `[0, 50]`
- `-100 <= Node.val <= 100`
- Both `list1` and `list2` are sorted in **non-decreasing order**

---

# 🚀 Optimal Approach: Iterative Merge

## 💡 Key Insight

Since both lists are already sorted, we can:

1. Compare the heads of both lists
2. Append the smaller one to our merged list
3. Move that pointer forward
4. Continue until one list is exhausted
5. Append the remainder of the other list

We use a **dummy node** to simplify handling of the head.

---

## 🧑‍💻 Python Code (Iterative)

```python
class Solution:
    def mergeTwoLists(
        self, list1: Optional[ListNode], list2: Optional[ListNode]
    ) -> Optional[ListNode]:

        dummy = ListNode(-1)
        tail = dummy

        while list1 and list2:
            if list1.val < list2.val:
                tail.next = list1
                list1 = list1.next
            else:
                tail.next = list2
                list2 = list2.next

            tail = tail.next

        # append the rest
        if list1:
            tail.next = list1
        else:
            tail.next = list2

        return dummy.next
```

---

## ⏱ Complexity

| Metric        | Value |
|--------------|-------|
| Time         | **O(n + m)** |
| Space        | **O(1)** |

Where `n` and `m` are the lengths of the two lists.

---

# 🚀 Alternative: Recursive Merge

## 💡 Idea

Recursively set:

- smaller head → current
- next pointer → recursive merge of the rest

---

## 🧑‍💻 Python Code (Recursive)

```python
class Solution:
    def mergeTwoLists(self, l1, l2):
        if not l1:
            return l2
        if not l2:
            return l1

        if l1.val < l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2
```

---

## ⏱ Complexity

| Metric        | Value |
|--------------|-------|
| Time         | **O(n + m)** |
| Space        | **O(n + m)** (recursive stack)

---

# 📚 Visual Example

```
list1: 1 → 2 → 4
list2: 1 → 3 → 4

Merged:
1 → 1 → 2 → 3 → 4 → 4
```

We always take the smaller node and move forward.

---

## 🧠 Common Mistakes

❌ Forgetting to move pointers forward  
❌ Not using a dummy → harder head manipulation  
❌ Incorrectly handling remainder of one list

If list1 or list2 is empty, just return the other.

---

# 📅 Daily LeetCode Log

- Day: XX
- Topic: Linked Lists
- Difficulty: Easy
- Language: Python

---

If you want, I can also generate:

https://neetcode.io/problems/merge-two-sorted-linked-lists/question

https://leetcode.com/problems/merge-two-sorted-lists/description/
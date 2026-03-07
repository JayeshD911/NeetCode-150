# 143. Reorder List

## 🔗 Problem Link
https://leetcode.com/problems/reorder-list/

---

# 📝 Problem Statement

You are given the **head of a singly linked list**.

The list can be represented as:

```
L0 → L1 → L2 → … → Ln
```

Reorder the list to the following form:

```
L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → ...
```

You **may not modify the values** in the nodes.  
Only the **node connections (next pointers)** may be changed.

Example transformations:

```
1 → 2 → 3 → 4
↓
1 → 4 → 2 → 3
```

```
1 → 2 → 3 → 4 → 5
↓
1 → 5 → 2 → 4 → 3
```

The reordering must be done **in-place**. :contentReference[oaicite:0]{index=0}

---

# 📌 Examples

### Example 1
```
Input: head = [1,2,3,4]
Output: [1,4,2,3]
```

### Example 2
```
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
```

### Example 3
```
Input: head = [1]
Output: [1]
```

---

# 📏 Constraints

- Number of nodes: `1 ≤ n ≤ 5 * 10^4`
- `-1000 ≤ Node.val ≤ 1000`

---

# 💡 Intuition

The desired order alternates between:

```
Start of list
End of list
Second from start
Second from end
...
```

Example:

```
Original
1 → 2 → 3 → 4 → 5

Desired
1 → 5 → 2 → 4 → 3
```

We can think of this as **merging two lists**:

```
First half:      1 → 2 → 3
Second half:     5 → 4
```

If we reverse the second half, we can **interleave** the two halves easily.

Therefore the algorithm becomes:

1. **Find the middle of the list**
2. **Reverse the second half**
3. **Merge the two halves alternately**

This approach runs in **O(n) time and O(1) space**. :contentReference[oaicite:1]{index=1}

---

# 🚀 Optimal Approach

### Step 1 — Find the middle of the list

Use the **fast and slow pointer technique**:

- `slow` moves 1 step
- `fast` moves 2 steps

When `fast` reaches the end, `slow` will be at the **middle**.

---

### Step 2 — Reverse the second half

Reverse the list starting from `slow.next`.

Example:

```
1 → 2 → 3 → 4 → 5

Split:

1 → 2 → 3
4 → 5

Reverse second half:

1 → 2 → 3
5 → 4
```

---

### Step 3 — Merge the two halves

Merge alternately:

```
1 → 5 → 2 → 4 → 3
```

---

# 💻 Java Implementation

```java
class Solution {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;

        // Step 1: Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode second = slow.next;
        slow.next = null;

        ListNode prev = null;
        while (second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        // Step 3: Merge two halves
        ListNode first = head;
        second = prev;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}
```

---

# ⏱ Complexity Analysis

### Time Complexity
```
O(n)
```

We traverse the list at most three times:
- find middle
- reverse
- merge

---

### Space Complexity
```
O(1)
```

The solution uses only pointers (no extra data structures).

---

# 🧠 Key Linked List Patterns Used

This problem combines **three fundamental linked list techniques**:

1. Fast & Slow Pointer → Find middle
2. Linked List Reversal
3. Merging Two Lists

If you master these three, many linked list problems become easier.

---

# 🎯 Interview Tip

Interviewers love this problem because it tests:

- Pointer manipulation
- Linked list fundamentals
- Ability to combine multiple algorithms

When you see:

```
Start → End → Start → End pattern
```

Think:

```
Split list
Reverse second half
Merge
```

---

# 🏁 Summary

| Step | Action |
|-----|------|
| 1 | Find middle of list |
| 2 | Reverse second half |
| 3 | Merge two halves alternately |

This produces:

```
L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → ...
```

---


https://neetcode.io/problems/reorder-linked-list/question

https://leetcode.com/problems/reorder-list/
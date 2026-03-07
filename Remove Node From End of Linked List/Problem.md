# 19. Remove Nth Node From End of List

🔗 Problem: https://leetcode.com/problems/remove-nth-node-from-end-of-list/

---

# Problem

Given the head of a **singly linked list**, remove the **nth node from the end** of the list and return the head of the modified list. :contentReference[oaicite:0]{index=0}

### Example

Input
```
head = [1,2,3,4,5], n = 2
```

Output
```
[1,2,3,5]
```

Explanation  
The 2nd node from the end is **4**, so we remove it.

---

# Key Observation

In a singly linked list we **cannot move backward**, so directly accessing the nth node from the end is not possible.

A naive solution:

1. Traverse the list to find length
2. Compute `(length - n)`
3. Traverse again to delete

But this requires **two passes**.

The optimal approach uses **two pointers** and works in **one pass**.

---

# Intuition (Two Pointer Technique)

We maintain **two pointers with a gap of `n` nodes**.

Steps:

1. Move `fast` pointer **n steps ahead**
2. Keep `slow` pointer at start
3. Move **both pointers together**
4. When `fast` reaches the end:
    - `slow` will be **right before the node to remove**

Then we remove it using:

```
slow.next = slow.next.next
```

To simplify edge cases (like deleting the head), we introduce a **dummy node** before the head. :contentReference[oaicite:1]{index=1}

This ensures **every node has a previous node**.

---

# Algorithm

1. Create a dummy node pointing to head
2. Initialize `fast` and `slow` at dummy
3. Move `fast` `n+1` steps forward
4. Move both pointers until `fast == null`
5. Delete the target node
6. Return `dummy.next`

---

# Optimal Java Solution

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Create dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n+1 steps ahead
        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }

        // Move both pointers
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the target node
        slow.next = slow.next.next;

        return dummy.next;
    }
}
```

---

# Dry Run

Input

```
1 → 2 → 3 → 4 → 5
n = 2
```

Step 1 — Add dummy

```
0 → 1 → 2 → 3 → 4 → 5
```

Step 2 — Move `fast` n+1 steps

```
fast → 3
slow → 0
```

Step 3 — Move both pointers

```
fast → 4    slow → 1
fast → 5    slow → 2
fast → null slow → 3
```

Now

```
slow → 3
```

Node to delete

```
slow.next = 4
```

Step 4 — Remove

```
slow.next = slow.next.next
```

Result

```
1 → 2 → 3 → 5
```

---

# Edge Cases

### 1️⃣ Removing the head

```
[1,2], n = 2
```

Result

```
[2]
```

Dummy node handles this cleanly.

---

### 2️⃣ Single node

```
[1], n = 1
```

Result

```
[]
```

---

# Complexity Analysis

Time Complexity

```
O(N)
```

We traverse the list **only once**.

Space Complexity

```
O(1)
```

Only pointer variables are used.

---

# Why This Is Optimal

The two-pointer technique allows us to:

- Find the node in **one pass**
- Avoid computing list length
- Maintain **constant space**

This is why it is the **standard interview solution** for this problem.

---

# Pattern Recognition

This problem belongs to:

```
Linked List
Two Pointers
Sliding Gap Technique
```

Same idea appears in problems like:

- Linked List Cycle
- Middle of Linked List
- Reorder List

---

# Summary

Core Idea

```
Maintain a gap of n between two pointers.
When the front pointer reaches the end,
the second pointer is right before the node to delete.
```

Then simply:

```
slow.next = slow.next.next
```

---

✔ Classic **FAANG linked list question**  
✔ Tests pointer manipulation  
✔ Appears in many interviews
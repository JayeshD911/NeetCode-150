# 2. Add Two Numbers

🔗 Problem: https://leetcode.com/problems/add-two-numbers/

---

# Problem

You are given two **non-empty linked lists** representing two non-negative integers.

- Each node contains **one digit**
- Digits are stored in **reverse order**
- Each list represents a number

Return the **sum as a linked list** in the same reversed format. :contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input

```
l1 = [2,4,3]
l2 = [5,6,4]
```

Output

```
[7,0,8]
```

Explanation

```
342 + 465 = 807
```

Representation:

```
2 → 4 → 3   (342)
5 → 6 → 4   (465)
------------
7 → 0 → 8   (807)
```

---

# Key Observation

Digits are stored in **reverse order**.

Example:

```
342 is stored as

2 → 4 → 3
```

This means the **ones place comes first**, which is perfect for performing addition the same way we do manually from right to left. :contentReference[oaicite:1]{index=1}

---

# Intuition

This problem simulates **element-by-element addition with carry**.

Think of adding numbers manually:

```
  342
+ 465
-----
  807
```

Steps:

```
2 + 5 = 7
4 + 6 = 10 → write 0 carry 1
3 + 4 + 1 = 8
```

Since the linked lists start from the **ones digit**, we can directly perform this process.

---

# Algorithm

1. Create a **dummy node** for the result list
2. Maintain a variable `carry`
3. Traverse both lists simultaneously
4. At each step:
    - add digits
    - add carry
    - create new node with `(sum % 10)`
    - update `carry = sum / 10`
5. Move both pointers forward
6. If carry remains, create a new node
7. Return `dummy.next`

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;

            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }
}
```

---

# Dry Run

Input

```
l1 = 2 → 4 → 3
l2 = 5 → 6 → 4
```

### Iteration 1

```
2 + 5 + 0 = 7
carry = 0
node = 7
```

Result

```
7
```

---

### Iteration 2

```
4 + 6 + 0 = 10
carry = 1
node = 0
```

Result

```
7 → 0
```

---

### Iteration 3

```
3 + 4 + 1 = 8
carry = 0
node = 8
```

Result

```
7 → 0 → 8
```

---

### Final List

```
7 → 0 → 8
```

Which represents:

```
807
```

---

# Edge Cases

### 1️⃣ Both lists contain zero

```
[0] + [0] = [0]
```

---

### 2️⃣ Different length lists

```
l1 = [9,9]
l2 = [1]

99 + 1 = 100

Result:

0 → 0 → 1
```

---

### 3️⃣ Final carry

Example:

```
5 + 5 = 10
```

Need to create extra node:

```
0 → 1
```

---

# Complexity Analysis

### Time Complexity

```
O(max(m,n))
```

We traverse both lists once.

---

### Space Complexity

```
O(max(m,n))
```

A new linked list is created for the result.

---

# Pattern Recognition

This problem belongs to:

```
Linked List
Simulation
Carry Propagation
```

Similar problems:

- Add Two Numbers II
- Multiply Strings
- Plus One Linked List

---

# Summary

Key idea:

```
Traverse both lists
Add digits + carry
Store result digit
Update carry
```

Important tricks:

```
Dummy node
Carry variable
Treat missing nodes as 0
```

---

# Final Takeaway

The problem becomes simple once you notice:

```
Digits are reversed.
```

This allows us to **simulate normal addition directly while traversing the linked lists**.

```
Time:  O(N)
Space: O(N)
```

✔ Classic **Linked List interview question**  
✔ Very common in FAANG interviews


https://neetcode.io/problems/add-two-numbers/question?list=neetcode150

https://leetcode.com/problems/add-two-numbers/description/
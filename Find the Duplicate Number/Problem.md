# 287. Find the Duplicate Number

🔗 Problem: https://leetcode.com/problems/find-the-duplicate-number/

---

# Problem

Given an array `nums` containing `n + 1` integers where each integer is in the range `[1, n]`.

There is **exactly one duplicated number**, but it may appear more than once.

Return the **duplicate number**.

Important constraints:

- You **cannot modify** the array
- You must use **O(1) extra space**
- Runtime should be **better than O(n²)**

These constraints imply that a duplicate **must exist** because there are `n+1` numbers but only `n` possible values (Pigeonhole Principle). :contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input

```
nums = [1,3,4,2,2]
```

Output

```
2
```

---

### Example 2

Input

```
nums = [3,1,3,4,2]
```

Output

```
3
```

---

# Key Insight

The numbers range from:

```
1 → n
```

But the array length is:

```
n + 1
```

Therefore **at least one number must repeat**. :contentReference[oaicite:1]{index=1}

The trick is to interpret the array as a **linked list**.

---

# Intuition

Think of the array like this:

```
index → value → next index
```

Example:

```
nums = [1,3,4,2,2]
```

Index transitions:

```
0 → 1
1 → 3
3 → 2
2 → 4
4 → 2
```

Graphically:

```
0 → 1 → 3 → 2 → 4
            ↑   ↓
            └───┘
```

Because of the duplicate, a **cycle is formed**.

So the problem becomes:

```
Find the cycle start in a linked list
```

This is exactly what **Floyd’s Tortoise and Hare algorithm** solves. :contentReference[oaicite:2]{index=2}

---

# Floyd’s Cycle Detection Algorithm

Two pointers:

```
slow → moves 1 step
fast → moves 2 steps
```

### Step 1 — Find intersection inside cycle

```
slow = nums[slow]
fast = nums[nums[fast]]
```

Eventually they meet.

---

### Step 2 — Find cycle entrance

Reset one pointer to start:

```
slow = nums[0]
```

Move both pointers one step:

```
slow = nums[slow]
fast = nums[fast]
```

Where they meet again is the **duplicate number**.

---

# Optimal Java Solution

```java
class Solution {
    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        // Step 1: find intersection
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Step 2: find cycle entrance
        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
```

---

# Dry Run

Input

```
nums = [3,1,3,4,2]
```

Transitions

```
0 → 3
3 → 4
4 → 2
2 → 3
```

Cycle:

```
3 → 4 → 2 → 3
```

---

### Step 1 — Detect cycle

| Iteration | slow | fast |
|-----------|------|------|
| start | 3 | 3 |
| 1 | 4 | 2 |
| 2 | 2 | 4 |
| 3 | 3 | 3 |

Intersection found.

---

### Step 2 — Find cycle entrance

Reset:

```
slow = nums[0] = 3
fast = 3
```

They already match.

Duplicate number:

```
3
```

---

# Complexity Analysis

### Time Complexity

```
O(n)
```

Both pointers traverse the array at most a few times.

---

### Space Complexity

```
O(1)
```

Only two pointers are used.

---

# Why This Works

Because:

```
n + 1 numbers
range 1 → n
```

This guarantees a **cycle when mapping indices to values**.

Floyd’s algorithm finds that cycle efficiently.

---

# Alternative Approaches

| Approach | Time | Space | Allowed |
|--------|------|------|------|
HashSet | O(n) | O(n) | ❌ |
Sorting | O(n log n) | O(1) | ❌ modifies array |
Binary Search on values | O(n log n) | O(1) | ✔ |
Floyd Cycle Detection | O(n) | O(1) | ⭐ Best |

---

# Pattern Recognition

This problem belongs to:

```
Fast and Slow Pointers
Cycle Detection
Linked List Pattern
```

Related problems:

- Linked List Cycle
- Linked List Cycle II
- Happy Number

---

# Summary

Key idea:

```
Treat the array as a linked list
Duplicate creates a cycle
Use Floyd’s cycle detection to find the cycle start
```

Result:

```
Time:  O(n)
Space: O(1)
```

✔ Classic **NeetCode / Blind 75 problem**  
✔ Frequently asked in FAANG interviews


https://neetcode.io/problems/find-duplicate-integer/question?list=neetcode150

https://leetcode.com/problems/find-the-duplicate-number/description/
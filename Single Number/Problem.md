# 136. Single Number

🔗 Problem: https://leetcode.com/problems/single-number/

---

# Problem

Given a non-empty array of integers `nums`, every element appears **twice** except for **one**.

Return:

```
the element that appears only once
```

Constraints:

```
• Must run in O(n) time
• Must use O(1) extra space
``` 
:contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input
```
nums = [2,2,1]
```

Output
```
1
```

Explanation

```
2 appears twice → cancels out
Only 1 remains
```

---

### Example 2

Input
```
nums = [4,1,2,1,2]
```

Output
```
4
```

Explanation

```
Pairs:
1,1 → cancel
2,2 → cancel

Remaining:
4
```

---

### Example 3

Input
```
nums = [1]
```

Output
```
1
```

---

# Key Idea

We use:

```
Bit Manipulation → XOR
```

Key XOR properties:

```
a ^ a = 0
a ^ 0 = a
XOR is commutative & associative
``` 
:contentReference[oaicite:1]{index=1}

So:

```
All duplicate numbers cancel out
Only the single number remains
```

---

# Intuition

Think of XOR like:

```
a magic cancellation operation
```

Example:

```
nums = [4,1,2,1,2]
```

XOR all:

```
4 ^ 1 ^ 2 ^ 1 ^ 2
= 4 ^ (1^1) ^ (2^2)
= 4 ^ 0 ^ 0
= 4
```

Duplicates disappear automatically. :contentReference[oaicite:2]{index=2}

---

# Strategy (XOR Trick)

Steps:

```
1️⃣ Initialize result = 0

2️⃣ Traverse array

3️⃣ XOR each element:
      result = result ^ num

4️⃣ Return result
```

---

# Optimal Java Solution

```java
class Solution {
    public int singleNumber(int[] nums) {

        int result = 0;

        for(int num : nums){
            result ^= num;
        }

        return result;
    }
}
```

---

# Dry Run

Input

```
nums = [4,1,2,1,2]
```

Steps

```
result = 0

0 ^ 4 = 4
4 ^ 1 = 5
5 ^ 2 = 7
7 ^ 1 = 6   (1 cancels)
6 ^ 2 = 4   (2 cancels)
```

Final:

```
result = 4
```

---

# Complexity Analysis

### Time Complexity

```
O(n)
```

Single pass through array. :contentReference[oaicite:3]{index=3}

---

### Space Complexity

```
O(1)
```

Only one variable used. :contentReference[oaicite:4]{index=4}

---

# Key Tricks

### 1️⃣ XOR cancels duplicates

```
a ^ a = 0
```

---

### 2️⃣ Start with 0

```
0 ^ x = x
```

---

### 3️⃣ Order doesn’t matter

```
XOR is associative & commutative
```

---

# Pattern Recognition

This problem belongs to:

```
Bit Manipulation (XOR Pattern)
```

Similar problems:

```
Single Number II
Missing Number
Find the Duplicate Number
```

---

# Summary

Core idea:

```
XOR all elements
Duplicates cancel out
Unique element remains
```

Final complexity:

```
Time  : O(n)
Space : O(1)
```

---

# Takeaway

Whenever you see:

```
every element appears twice except one
no extra space allowed
```

Think immediately:

```
XOR trick
```

Because:

```
XOR naturally removes duplicates
```

https://neetcode.io/problems/single-number/question?list=neetcode150

https://leetcode.com/problems/single-number/
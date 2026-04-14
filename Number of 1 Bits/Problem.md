# 191. Number of 1 Bits

🔗 Problem: https://leetcode.com/problems/number-of-1-bits/

---

# Problem

Given an integer `n`, return the number of:

```
'1' bits in its binary representation
```

This is also known as the:

```
Hamming Weight
``` 
:contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input
```
n = 11
```

Output
```
3
```

Explanation

```
11 in binary = 1011
There are 3 '1' bits
```

---

### Example 2

Input
```
n = 128
```

Output
```
1
```

Explanation

```
128 in binary = 10000000
Only one '1'
```

---

### Example 3

Input
```
n = 2147483645
```

Output
```
30
```

Explanation

```
Binary representation contains 30 ones
```

---

# Key Idea

We use a powerful bit trick:

```
n & (n - 1)
```

This operation:

```
removes the rightmost '1' bit
``` 
:contentReference[oaicite:1]{index=1}

So:

```
Each iteration removes exactly one '1'
```

---

# Intuition

Example:

```
n = 12 → 1100
n - 1 = 11 → 1011
```

Now:

```
1100 & 1011 = 1000
```

👉 The rightmost `1` is removed.

So if we keep doing this:

```
Number of operations = number of 1s
``` 
:contentReference[oaicite:2]{index=2}

---

# Strategy (Brian Kernighan’s Algorithm)

Steps:

```
1️⃣ Initialize count = 0

2️⃣ While n != 0:
      n = n & (n - 1)
      count++

3️⃣ Return count
```

---

# Optimal Java Solution

```java
public class Solution {
    public int hammingWeight(int n) {

        int count = 0;

        while(n != 0){
            n &= (n - 1);
            count++;
        }

        return count;
    }
}
```

---

# Dry Run

Input

```
n = 11 → binary = 1011
```

Steps

```
Iteration 1:
1011 & 1010 = 1010 → count = 1

Iteration 2:
1010 & 1001 = 1000 → count = 2

Iteration 3:
1000 & 0111 = 0000 → count = 3
```

Final:

```
count = 3
```

---

# Complexity Analysis

### Time Complexity

```
O(k)
```

Where:

```
k = number of 1 bits
```

Because loop runs only for set bits. :contentReference[oaicite:3]{index=3}

---

### Space Complexity

```
O(1)
```

Only variables used.

---

# Key Tricks

### 1️⃣ Use n & (n - 1)

```
Removes one set bit per iteration
```

---

### 2️⃣ Faster than checking all bits

```
Runs only for number of 1s
```

---

### 3️⃣ Works for 32-bit integers

```
At most 32 iterations
```

---

# Pattern Recognition

This problem belongs to:

```
Bit Manipulation (XOR / AND tricks)
```

Similar problems:

```
Single Number
Counting Bits
Power of Two
```

---

# Summary

Core idea:

```
Repeatedly remove rightmost 1 bit
Count how many times it happens
```

---

# Takeaway

Whenever you see:

```
count number of 1 bits
binary manipulation
```

Think immediately:

```
n & (n - 1)
```

Because:

```
It removes one set bit per step efficiently
```

https://neetcode.io/problems/number-of-one-bits/question

https://leetcode.com/problems/number-of-1-bits/description/

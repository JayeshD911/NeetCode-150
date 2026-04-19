# 70. Climbing Stairs

🔗 Problem: https://leetcode.com/problems/climbing-stairs/

---

# Problem

You are climbing a staircase. It takes `n` steps to reach the top.

Each time you can:

```
climb 1 step
OR
climb 2 steps
```

Return:

```
the total number of distinct ways to reach the top
``` 
:contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input
```
n = 2
```

Output
```
2
```

Explanation

```
1 + 1
2
```

---

### Example 2

Input
```
n = 3
```

Output
```
3
```

Explanation

```
1 + 1 + 1
1 + 2
2 + 1
```

---

# Key Idea

At every step, you have two choices:

```
come from previous step (i-1)
come from two steps back (i-2)
```

So:

```
ways[i] = ways[i-1] + ways[i-2]
```

👉 This is exactly:

```
Fibonacci sequence
``` 
:contentReference[oaicite:1]{index=1}

---

# Intuition

To reach step `i`:

```
From step (i-1) → take 1 step
From step (i-2) → take 2 steps
```

So total ways:

```
ways[i] = ways[i-1] + ways[i-2]
```

Example:

```
n = 4

ways[1] = 1
ways[2] = 2
ways[3] = 3
ways[4] = 5
```

---

# Strategy (DP Optimized)

Steps:

```
1️⃣ Handle base cases:
      n = 1 → 1
      n = 2 → 2

2️⃣ Use two variables:
      prev2 → ways[i-2]
      prev1 → ways[i-1]

3️⃣ Iterate:
      curr = prev1 + prev2

4️⃣ Shift values forward

5️⃣ Return result
```

---

# Optimal Java Solution

```java
class Solution {
    public int climbStairs(int n) {

        if(n <= 2) return n;

        int prev2 = 1;
        int prev1 = 2;

        for(int i = 3; i <= n; i++){

            int curr = prev1 + prev2;

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
```

---

# Dry Run

Input

```
n = 5
```

Steps

```
prev2 = 1
prev1 = 2
```

```
i = 3 → 3
i = 4 → 5
i = 5 → 8
```

Final:

```
8
```

---

# Complexity Analysis

### Time Complexity

```
O(n)
```

We iterate once. :contentReference[oaicite:2]{index=2}

---

### Space Complexity

```
O(1)
```

Only two variables used. :contentReference[oaicite:3]{index=3}

---

# Key Tricks

### 1️⃣ Recognize Fibonacci pattern

```
f(n) = f(n-1) + f(n-2)
```

---

### 2️⃣ Use space optimization

```
No need for DP array
```

---

### 3️⃣ Handle base cases early

```
n <= 2 → return n
```

---

# Pattern Recognition

This problem belongs to:

```
Dynamic Programming (Fibonacci Pattern)
```

Similar problems:

```
House Robber
Decode Ways
Fibonacci Number
```

---

# Summary

Core idea:

```
Ways to reach step i =
ways from previous step +
ways from two steps before
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
ways to reach step
choices at each step
```

Think immediately:

```
Fibonacci / DP recurrence
```

Because:

```
Each state depends on previous two states
```


# 746. Min Cost Climbing Stairs

🔗 Problem: https://leetcode.com/problems/min-cost-climbing-stairs/

---

# Problem

You are given an integer array `cost` where:

```
cost[i] = cost of stepping on the ith stair
```

Once you pay the cost, you can:

```
climb 1 step
OR
climb 2 steps
```

You can start from:

```
index 0 OR index 1
```

Goal:

```
Reach the top (beyond last index) with minimum cost
``` 
:contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input
```
cost = [10,15,20]
```

Output
```
15
```

Explanation

```
Option 1:
Start at index 0 → pay 10 → jump to index 2 → pay 20
Total = 30

Option 2:
Start at index 1 → pay 15 → jump to top
Total = 15

Minimum = 15
``` 
:contentReference[oaicite:1]{index=1}

---

### Example 2

Input
```
cost = [1,100,1,1,1,100,1,1,100,1]
```

Output
```
6
```

Explanation

```
Pick cheapest path:
1 → 1 → 1 → 1 → 1 → 1
Total = 6
```

---

# Key Idea

This is a **Dynamic Programming problem**.

Observation:

```
To reach step i,
you must come from:
(i-1) OR (i-2)
```

So:

```
dp[i] = min cost to reach step i
```

Transition:

```
dp[i] = min(dp[i-1] + cost[i-1],
            dp[i-2] + cost[i-2])
``` 
:contentReference[oaicite:2]{index=2}

---

# Intuition

Think backward:

To reach the top:

```
You must come from last step OR second last step
```

So:

```
Answer = min(dp[n-1], dp[n-2])
```

Or better:

```
Build dp up to n (top)
```

Each step:

```
Choose cheaper path:
1-step jump OR 2-step jump
```

---

# Strategy (DP Optimized)

Steps:

```
1️⃣ Initialize:
      prev2 = 0  (cost to reach step 0)
      prev1 = 0  (cost to reach step 1)

2️⃣ Iterate from i = 2 → n

3️⃣ Compute:
      curr = min(prev1 + cost[i-1],
                 prev2 + cost[i-2])

4️⃣ Shift values:
      prev2 = prev1
      prev1 = curr

5️⃣ Return prev1
```

---

# Optimal Java Solution

```java
class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int prev2 = 0;
        int prev1 = 0;

        for(int i = 2; i <= cost.length; i++){

            int curr = Math.min(
                prev1 + cost[i - 1],
                prev2 + cost[i - 2]
            );

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
cost = [10,15,20]
```

Steps

```
prev2 = 0
prev1 = 0
```

```
i = 2:
curr = min(0+15, 0+10) = 10

i = 3:
curr = min(10+20, 0+15) = 15
```

Final:

```
15
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

Only variables used. :contentReference[oaicite:4]{index=4}

---

# Key Tricks

### 1️⃣ Think from destination

```
Top depends on last 2 steps
```

---

### 2️⃣ No need full DP array

```
Only last two states required
```

---

### 3️⃣ Start from index 0 or 1

```
Initialize both as 0
```

---

# Pattern Recognition

This problem belongs to:

```
Dynamic Programming (Fibonacci Variation)
```

Similar problems:

```
Climbing Stairs
House Robber
Decode Ways
```

---

# Summary

Core idea:

```
At each step:
choose minimum cost from previous 2 steps
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
minimum cost to reach end
choices: 1 step or 2 steps
```

Think immediately:

```
DP + Fibonacci-style recurrence
```

Because:

```
Each state depends on previous two states
```

https://neetcode.io/problems/min-cost-climbing-stairs/question?list=neetcode150

https://leetcode.com/problems/min-cost-climbing-stairs/description/

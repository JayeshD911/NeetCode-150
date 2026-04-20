# 198. House Robber

🔗 Problem: https://leetcode.com/problems/house-robber/

---

# Problem

You are a professional robber planning to rob houses along a street.

Each house has some money:

```
nums[i] = money in ith house
```

Constraint:

```
You cannot rob two adjacent houses
```

Return:

```
maximum amount of money you can rob
```

---

# Example

### Example 1

Input
```
nums = [1,2,3,1]
```

Output
```
4
```

Explanation

```
Rob house 0 → 1
Skip house 1
Rob house 2 → 3

Total = 1 + 3 = 4
``` 
:contentReference[oaicite:0]{index=0}

---

### Example 2

Input
```
nums = [2,7,9,3,1]
```

Output
```
12
```

Explanation

```
Rob house 0 → 2
Skip house 1
Rob house 2 → 9
Skip house 3
Rob house 4 → 1

Total = 2 + 9 + 1 = 12
``` 
:contentReference[oaicite:1]{index=1}

---

# Key Idea

At every house, you have **two choices**:

```
1️⃣ Rob this house → skip next house
2️⃣ Skip this house → go to next house
```

So:

```
dp[i] = max money we can rob till index i
```

Transition:

```
dp[i] = max(dp[i-1], nums[i] + dp[i-2])
``` 
:contentReference[oaicite:2]{index=2}

---

# Intuition

For each house:

```
Option 1 → Don’t rob → take previous max
Option 2 → Rob → add current value + dp[i-2]
```

So we choose:

```
maximum of both options
```

Example:

```
nums = [2,7,9,3,1]

i = 2:
max(7, 2+9) = 11
```

---

# Strategy (DP Optimized)

Steps:

```
1️⃣ Use two variables:
      prev2 → dp[i-2]
      prev1 → dp[i-1]

2️⃣ Iterate through houses

3️⃣ Compute:
      curr = max(prev1, prev2 + nums[i])

4️⃣ Shift values:
      prev2 = prev1
      prev1 = curr

5️⃣ Return prev1
```

---

# Optimal Java Solution

```java
class Solution {
    public int rob(int[] nums) {

        int prev2 = 0;
        int prev1 = 0;

        for(int num : nums){

            int curr = Math.max(prev1, prev2 + num);

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
nums = [2,7,9,3,1]
```

Steps

```
prev2 = 0
prev1 = 0
```

```
num = 2 → curr = max(0,0+2) = 2
prev2 = 0, prev1 = 2
```

```
num = 7 → curr = max(2,0+7) = 7
prev2 = 2, prev1 = 7
```

```
num = 9 → curr = max(7,2+9) = 11
prev2 = 7, prev1 = 11
```

```
num = 3 → curr = max(11,7+3) = 11
prev2 = 11, prev1 = 11
```

```
num = 1 → curr = max(11,11+1) = 12
```

Final:

```
12
```

---

# Complexity Analysis

### Time Complexity

```
O(n)
```

Each house processed once. :contentReference[oaicite:3]{index=3}

---

### Space Complexity

```
O(1)
```

Only two variables used. :contentReference[oaicite:4]{index=4}

---

# Key Tricks

### 1️⃣ Choose rob vs skip

```
max(prev1, prev2 + nums[i])
```

---

### 2️⃣ Only last two states matter

```
No need full DP array
```

---

### 3️⃣ Think like Fibonacci variation

```
Depends on previous 2 states
```

---

# Pattern Recognition

This problem belongs to:

```
Dynamic Programming (Fibonacci / Choice DP Pattern)
```

Similar problems:

```
House Robber II
Delete and Earn
Climbing Stairs
```

---

# Summary

Core idea:

```
At each house:
decide rob OR skip
Use DP to store best result
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
cannot take adjacent elements
maximize sum
```

Think immediately:

```
DP → include/exclude pattern
```

Because:

```
Each decision depends on previous two states
```

https://neetcode.io/problems/house-robber/question?list=neetcode150

https://leetcode.com/problems/house-robber/description/
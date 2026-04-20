# 213. House Robber II

🔗 Problem: https://leetcode.com/problems/house-robber-ii/

---

# Problem

You are a professional robber planning to rob houses along a street.

Each house has some money:

```
nums[i] = money in ith house
```

But now the houses are arranged in a:

```
circle
```

That means:

```
first house and last house are adjacent
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
nums = [2,3,2]
```

Output
```
3
```

Explanation

```
If you rob house 0 = 2
you cannot rob house 2 = 2
because first and last are adjacent
```

So best choice is:

```
rob only house 1 → 3
```

---

### Example 2

Input
```
nums = [1,2,3,1]
```

Output
```
4
```

Explanation

Possible good choice:

```
rob house 0 → 1
rob house 2 → 3
total = 4
```

You cannot rob both first and last house together.

---

### Example 3

Input
```
nums = [1,2,3]
```

Output
```
3
```

Explanation

Best choice:

```
rob house 2 → 3
```

---

# Key Idea

This problem is almost the same as **House Robber I**, but with one extra twist:

```
houses are circular
```

So:

```
You cannot rob both first and last house
```

That means every valid answer must come from one of these two cases:

```
1️⃣ Rob from house 0 to n-2
2️⃣ Rob from house 1 to n-1
```

Then take:

```
max(case1, case2)
```

---

# Intuition

Because first and last houses are adjacent, they cannot both be included.

So instead of solving one circular problem directly, we break it into:

```
two linear House Robber problems
```

Case 1:

```
Exclude last house
```

Case 2:

```
Exclude first house
```

Now both cases become the normal **House Robber I** problem.

---

# Strategy

Steps:

```
1️⃣ Handle edge case:
      if only one house → return nums[0]

2️⃣ Solve House Robber I on:
      nums[0 ... n-2]
      nums[1 ... n-1]

3️⃣ Return maximum of the two
```

For each linear case:

```
curr = max(prev1, prev2 + nums[i])
```

---

# Optimal Java Solution

```java
class Solution {
    public int rob(int[] nums) {

        if(nums.length == 1) return nums[0];

        return Math.max(
            robLinear(nums, 0, nums.length - 2),
            robLinear(nums, 1, nums.length - 1)
        );
    }

    public int robLinear(int[] nums, int start, int end) {

        int prev2 = 0;
        int prev1 = 0;

        for(int i = start; i <= end; i++){

            int curr = Math.max(prev1, prev2 + nums[i]);

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
nums = [1,2,3,1]
```

Because circle:

```
cannot take both first and last
```

So solve 2 cases.

### Case 1: Exclude last

```
[1,2,3]
```

House Robber I result:

```
max = 4
```

Take houses:

```
1 + 3 = 4
```

---

### Case 2: Exclude first

```
[2,3,1]
```

House Robber I result:

```
max = 3
```

Take house:

```
3
```

---

### Final Answer

```
max(4, 3) = 4
```

---

# Complexity Analysis

### Time Complexity

```
O(n)
```

We solve two linear House Robber problems, each in O(n).

---

### Space Complexity

```
O(1)
```

Only a few variables are used.

---

# Key Tricks

### 1️⃣ Break circle into two lines

```
exclude first
exclude last
```

---

### 2️⃣ Reuse House Robber I logic

```
same DP recurrence
```

---

### 3️⃣ Handle single house separately

```
if(nums.length == 1)
```

Because both ranges would otherwise become invalid.

---

# Pattern Recognition

This problem belongs to:

```
Dynamic Programming + Circular Array Pattern
```

Similar problems:

```
House Robber I
Delete and Earn
Maximum Sum of Non-Adjacent Elements
```

---

# Summary

Core idea:

```
Circular adjacency prevents taking both first and last house
So solve two linear cases:
exclude first OR exclude last
Take maximum answer
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
house robber
non-adjacent choices
circular arrangement
```

Think immediately:

```
Break circle into two linear DP cases
```

Because:

```
first and last cannot be taken together
```

https://neetcode.io/problems/house-robber-ii/question?list=neetcode150

https://leetcode.com/problems/house-robber-ii/

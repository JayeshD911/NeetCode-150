# 53. Maximum Subarray

🔗 Problem: https://leetcode.com/problems/maximum-subarray/

---

# Problem

Given an integer array `nums`, find the **contiguous subarray** (containing at least one number) which has the **largest sum**, and return that sum. :contentReference[oaicite:0]{index=0}

A subarray must be:

```
continuous (no skipping elements)
```

---

# Example

### Example 1

Input
```
nums = [-2,1,-3,4,-1,2,1,-5,4]
```

Output
```
6
```

Explanation

```
Subarray: [4,-1,2,1]
Sum = 6
```

---

### Example 2

Input
```
nums = [1]
```

Output
```
1
```

Explanation

Only one element exists.

---

### Example 3

Input
```
nums = [5,4,-1,7,8]
```

Output
```
23
```

Explanation

```
Entire array is the best subarray
```

---

# Key Idea

The optimal solution uses:

```
Kadane’s Algorithm
```

Core idea:

```
At each index, decide:
→ extend current subarray
OR
→ start a new subarray
``` 
:contentReference[oaicite:1]{index=1}

---

# Intuition

At every position, we have two choices:

```
1️⃣ Include current element in existing subarray
2️⃣ Start new subarray from current element
```

So we track:

```
currentSum = best subarray ending here
maxSum     = best overall subarray
```

---

# Strategy (Kadane’s Algorithm)

Steps:

```
1️⃣ Initialize:
      currentSum = nums[0]
      maxSum     = nums[0]

2️⃣ Iterate from index 1

3️⃣ Update:
      currentSum = max(nums[i], currentSum + nums[i])

4️⃣ Update global max:
      maxSum = max(maxSum, currentSum)

5️⃣ Return maxSum
```

---

# Optimal Java Solution

```java
class Solution {
    public int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++){

            currentSum = Math.max(nums[i], currentSum + nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
```

---

# Dry Run

Input

```
nums = [-2,1,-3,4,-1,2,1,-5,4]
```

Steps

```
Start:
currentSum = -2
maxSum = -2
```

```
i = 1 → 1
currentSum = max(1, -2+1) = 1
maxSum = 1
```

```
i = 2 → -3
currentSum = max(-3, 1-3) = -2
maxSum = 1
```

```
i = 3 → 4
currentSum = max(4, -2+4) = 4
maxSum = 4
```

```
i = 4 → -1
currentSum = 3
maxSum = 4
```

```
i = 5 → 2
currentSum = 5
maxSum = 5
```

```
i = 6 → 1
currentSum = 6
maxSum = 6
```

Final:

```
maxSum = 6
```

---

# Complexity Analysis

### Time Complexity

```
O(n)
```

We traverse the array once. :contentReference[oaicite:2]{index=2}

---

### Space Complexity

```
O(1)
```

Only variables are used.

---

# Key Tricks

### 1️⃣ Decide extend vs restart

```
currentSum = max(nums[i], currentSum + nums[i])
```

---

### 2️⃣ Track global max

```
maxSum = max(maxSum, currentSum)
```

---

### 3️⃣ Works even with negatives

```
Handles all negative arrays correctly
```

---

# Pattern Recognition

This problem belongs to:

```
Dynamic Programming (Kadane’s Pattern)
```

Similar problems:

```
Maximum Product Subarray
Best Time to Buy and Sell Stock
Maximum Sum Circular Subarray
```

---

# Summary

Core idea:

```
At each index:
choose best subarray ending here
Track global maximum
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
maximum sum subarray
continuous segment optimization
```

Think immediately:

```
Kadane’s Algorithm
```

Because:

```
It converts O(n²) brute force → O(n)
```

https://neetcode.io/problems/maximum-subarray/question?list=neetcode150

https://leetcode.com/problems/maximum-subarray/

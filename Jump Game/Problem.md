# 55. Jump Game

🔗 Problem: https://leetcode.com/problems/jump-game/

---

# Problem

You are given an integer array `nums`, where:

```
nums[i] = maximum jump length from index i
```

You start at index `0`, and your goal is to determine if you can reach the **last index**.

Return:

```
true  → if you can reach the last index
false → otherwise
``` 
:contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input
```
nums = [2,3,1,1,4]
```

Output
```
true
```

Explanation

```
Start at index 0 → value = 2
You can jump to index 1 or 2

From index 1 → value = 3
You can jump to last index
```

Path:

```
0 → 1 → 4
```

---

### Example 2

Input
```
nums = [3,2,1,0,4]
```

Output
```
false
```

Explanation

```
You always reach index 3
nums[3] = 0 → cannot move forward
```

So you are stuck before reaching the last index.

---

# Key Idea

We do NOT need to try all paths.

Key observation:

```
Track the farthest index we can reach at any point
```

If at any index:

```
current index > farthest reachable index
```

Then:

```
we cannot reach this position → return false
``` 
:contentReference[oaicite:1]{index=1}

---

# Intuition

Think of it like expanding a **reachable range**.

Example:

```
nums = [2,3,1,1,4]
```

At index 0:

```
maxReach = 2
```

At index 1:

```
maxReach = max(2, 1+3) = 4
```

Now we can already reach the last index.

---

# Strategy (Greedy)

Steps:

```
1️⃣ Initialize maxReach = 0

2️⃣ Iterate through array

3️⃣ If current index > maxReach
      return false

4️⃣ Update maxReach:
      maxReach = max(maxReach, i + nums[i])

5️⃣ If maxReach reaches last index
      return true
```

---

# Optimal Java Solution

```java
class Solution {
    public boolean canJump(int[] nums) {

        int maxReach = 0;

        for(int i = 0; i < nums.length; i++){

            if(i > maxReach){
                return false;
            }

            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }
}
```

---

# Dry Run

Input

```
nums = [3,2,1,0,4]
```

Steps

```
i = 0 → maxReach = 3
i = 1 → maxReach = 3
i = 2 → maxReach = 3
i = 3 → maxReach = 3
i = 4 → i > maxReach → cannot reach
```

Return

```
false
```

---

# Complexity Analysis

### Time Complexity

```
O(n)
```

Single pass through array. :contentReference[oaicite:2]{index=2}

---

### Space Complexity

```
O(1)
```

No extra space used.

---

# Key Tricks

### 1️⃣ Track farthest reach

```
maxReach = max(maxReach, i + nums[i])
```

---

### 2️⃣ Early failure check

```
if(i > maxReach) → return false
```

---

### 3️⃣ Greedy works

```
We only need best possible reach at each step
```

---

# Pattern Recognition

This problem belongs to:

```
Greedy + Reachability Pattern
```

Similar problems:

```
Jump Game II
Jump Game III
Maximum Reach Problems
```

---

# Summary

Core idea:

```
Track maximum reachable index
If stuck → return false
If reach end → return true
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
array jumps
reachability
can we reach end?
```

Think immediately:

```
Greedy + Track max reachable index
```

Because:

```
You don’t need all paths — just the best reach
```

https://neetcode.io/problems/jump-game/solution

https://leetcode.com/problems/jump-game/description/
# 45. Jump Game II

🔗 Problem: https://leetcode.com/problems/jump-game-ii/

---

# Problem

You are given an integer array `nums`, where:

```
nums[i] = maximum jump length from index i
```

You start at index `0`, and your goal is to reach the **last index** in the **minimum number of jumps**.

It is guaranteed that:

```
You can always reach the last index
```

Return the **minimum number of jumps** required. :contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input
```
nums = [2,3,1,1,4]
```

Output
```
2
```

Explanation

```
Jump from index 0 → 1
Jump from index 1 → 4
```

Minimum jumps:

```
2
```

---

### Example 2

Input
```
nums = [2,3,0,1,4]
```

Output
```
2
```

Explanation

```
0 → 1 → 4
```

---

# Key Idea

This is NOT about reachability (like Jump Game I).

Instead:

```
Minimize number of jumps
```

Key observation:

```
We process the array in "levels" (like BFS)
Each level = one jump
``` 
:contentReference[oaicite:1]{index=1}

---

# Intuition

Think of it like exploring ranges:

```
At index 0:
you can reach indices [1...2]
```

From those positions, you explore further:

```
Next range → indices reachable in 2 jumps
```

So:

```
Each jump expands the reachable range
```

Goal:

```
Reach the last index in minimum expansions
```

---

# Strategy (Greedy / BFS-like)

We track 3 variables:

```
farthest → farthest index we can reach
end      → end of current jump range
jumps    → number of jumps
```

Steps:

```
1️⃣ Iterate from index 0 to n-2

2️⃣ Update farthest:
      farthest = max(farthest, i + nums[i])

3️⃣ If i reaches end:
      we must make a jump
      jumps++
      end = farthest

4️⃣ Continue until end reaches last index
```

Why this works:

```
We always expand the range as far as possible before jumping
``` 
:contentReference[oaicite:2]{index=2}

---

# Optimal Java Solution

```java
class Solution {
    public int jump(int[] nums) {

        int jumps = 0;
        int end = 0;
        int farthest = 0;

        for(int i = 0; i < nums.length - 1; i++){

            farthest = Math.max(farthest, i + nums[i]);

            if(i == end){
                jumps++;
                end = farthest;
            }
        }

        return jumps;
    }
}
```

---

# Dry Run

Input

```
nums = [2,3,1,1,4]
```

Steps

```
i = 0
farthest = 2
i == end → jump → jumps = 1
end = 2
```

```
i = 1
farthest = max(2, 1+3) = 4
```

```
i = 2
farthest = 4
i == end → jump → jumps = 2
end = 4
```

We reached the end.

Result

```
2
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

Only variables used.

---

# Key Tricks

### 1️⃣ Think in ranges (levels)

```
Each range = one jump
```

---

### 2️⃣ Track farthest reach

```
farthest = max(farthest, i + nums[i])
```

---

### 3️⃣ Jump only when needed

```
if(i == end)
```

---

### 4️⃣ Do NOT greedily jump to max index directly

```
Instead, expand full range first
```

---

# Pattern Recognition

This problem belongs to:

```
Greedy + BFS Range Expansion Pattern
```

Similar problems:

```
Jump Game I
Minimum Number of Intervals
Word Ladder (BFS levels)
```

---

# Summary

Core idea:

```
Process array in levels
Each level = one jump
Expand farthest reachable range
Jump when current range ends
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
minimum steps
range expansion
array jumps
```

Think immediately:

```
Greedy + BFS-like levels
```

Because:

```
Each level corresponds to one jump
```


https://neetcode.io/problems/jump-game-ii/question

https://leetcode.com/problems/jump-game-ii/description/
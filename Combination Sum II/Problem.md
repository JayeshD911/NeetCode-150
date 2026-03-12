# 40. Combination Sum II

🔗 Problem: https://leetcode.com/problems/combination-sum-ii/

---

# Problem

Given a collection of candidate numbers `candidates` and a target integer `target`, return **all unique combinations** in `candidates` where the numbers sum to `target`.

Important rules:

- **Each number may be used at most once**
- The solution set **must not contain duplicate combinations**
- The order of combinations does not matter :contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input

```
candidates = [10,1,2,7,6,1,5]
target = 8
```

Output

```
[[1,1,6],[1,2,5],[1,7],[2,6]]
```

---

### Example 2

Input

```
candidates = [2,5,2,1,2]
target = 5
```

Output

```
[[1,2,2],[5]]
```

---

# Key Difference From Combination Sum I

| Problem | Reuse Allowed | Duplicates in Input |
|---|---|---|
| Combination Sum I | YES | NO |
| Combination Sum II | NO | YES |

So the main challenge becomes:

```
Avoid duplicate combinations
```

---

# Core Idea

We solve this using **Backtracking (DFS)**.

Steps:

1. Sort the array.
2. Explore combinations recursively.
3. Skip duplicate numbers during recursion.

Sorting is crucial because it groups duplicate numbers together, allowing us to skip them easily. :contentReference[oaicite:1]{index=1}

---

# Intuition

Example:

```
candidates = [1,1,2]
target = 3
```

Sorted array:

```
[1,1,2]
```

Recursion tree:

```
[]
├── 1
│   ├── 1
│   │   └── [1,1,1] ❌
│   └── 2
│       └── [1,2] ✅
└── skip duplicate 1
    └── 2
```

Skipping duplicates prevents generating:

```
[1,2]
[1,2]
```

twice.

---

# Backtracking Strategy

At each index:

```
choose the number
move to next index
```

Key rule:

```
Each element can be used only once
```

So recursion moves to:

```
i + 1
```

not `i`.

---

# Optimal Java Solution

```java
class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(res, new ArrayList<>(), candidates, target, 0);

        return res;
    }

    private void backtrack(List<List<Integer>> res,
                           List<Integer> temp,
                           int[] nums,
                           int target,
                           int start) {

        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < nums.length; i++) {

            // skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            if (nums[i] > target) break;

            temp.add(nums[i]);

            backtrack(res, temp, nums, target - nums[i], i + 1);

            temp.remove(temp.size() - 1);
        }
    }
}
```

---

# Dry Run

Input:

```
candidates = [1,1,2,5]
target = 3
```

Sorted:

```
[1,1,2,5]
```

Tree:

```
[]
├── 1
│   ├── 1
│   │   └── [1,1,1] ❌
│   └── 2
│       └── [1,2] ✅
└── skip duplicate 1
    └── 2
```

Result:

```
[[1,2]]
```

---

# Complexity Analysis

Worst case:

```
Time Complexity:  O(n * 2^n)
```

Because we explore subsets and copy combinations. :contentReference[oaicite:2]{index=2}

Space complexity:

```
O(n)
```

For recursion stack and temporary path.

---

# Important Tricks

### 1️⃣ Sorting

```
Arrays.sort(candidates)
```

This allows easy duplicate detection.

---

### 2️⃣ Skip duplicates

```
if (i > start && nums[i] == nums[i-1]) continue;
```

This avoids generating duplicate combinations.

---

### 3️⃣ Move index forward

```
i + 1
```

because each number can only be used **once**.

---

# Pattern Recognition

This problem belongs to the **Backtracking / DFS pattern**.

Very similar problems:

```
Subsets
Combination Sum
Combination Sum III
Permutations
N-Queens
```

---

# Summary

Key rules:

```
Sort the array
Skip duplicates
Use each element only once
Backtrack to explore combinations
```

Final complexity:

```
Time:  O(n * 2^n)
Space: O(n)
```

---

# Final Takeaway

Whenever a problem says:

```
unique combinations
numbers may contain duplicates
each element used once
```

You should immediately think:

```
Backtracking + sorting + skip duplicates
```

✔ Classic **Backtracking interview problem**  
✔ Frequently appears in **FAANG / NeetCode / Blind 75**


https://neetcode.io/problems/combination-target-sum-ii/question?list=neetcode150

https://leetcode.com/problems/combination-sum-ii/description/
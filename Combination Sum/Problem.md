# 39. Combination Sum

🔗 Problem: https://leetcode.com/problems/combination-sum/

---

# Problem

You are given an array of **distinct integers** `candidates` and a target integer `target`.

Return a list of all **unique combinations** of `candidates` where the chosen numbers sum to `target`.

Important rules:

- You may use the **same number unlimited times**
- The solution set **must not contain duplicate combinations**
- Order of combinations **does not matter** :contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input

```
candidates = [2,3,6,7]
target = 7
```

Output

```
[[2,2,3],[7]]
```

Explanation

```
2 + 2 + 3 = 7
7 = 7
```

---

### Example 2

Input

```
candidates = [2,3,5]
target = 8
```

Output

```
[[2,2,2,2],[2,3,3],[3,5]]
```

---

# Key Insight

This is a **classic backtracking problem**.

At each step we have two choices:

```
1. Include the current number
2. Skip the current number
```

If we include it:

```
target = target - candidates[i]
```

Since numbers can be reused **unlimited times**, we **stay at the same index**.

If we skip it:

```
move to next index
```

This approach systematically explores all combinations using recursion. :contentReference[oaicite:1]{index=1}

---

# Intuition

Think of this like **making exact change using coins**.

Example:

```
candidates = [2,3,6,7]
target = 7
```

Decision tree:

```
                 []
             /        \
           2           skip 2
        /      \
      2         3
    /   \
   2     3
```

Valid paths that reach **target = 0** become answers.

---

# Backtracking Strategy

At each index:

```
Pick candidate[i]
    ↓
target -= candidate[i]
stay at index i (reuse allowed)

OR

Skip candidate[i]
    ↓
move to index i+1
```

Stop conditions:

```
target == 0 → valid combination
target < 0 → invalid path
index == length → stop
```

---

# Optimal Java Solution

```java
class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    void backtrack(int index, int[] candidates, int target, List<Integer> curr){

        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(index == candidates.length || target < 0){
            return;
        }

        // include current number
        curr.add(candidates[index]);
        backtrack(index, candidates, target - candidates[index], curr);

        // backtrack
        curr.remove(curr.size() - 1);

        // skip current number
        backtrack(index + 1, candidates, target, curr);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        backtrack(0, candidates, target, new ArrayList<>());
        return ans;
    }
}
```

---

# Dry Run

Input

```
candidates = [2,3]
target = 7
```

Recursion tree

```
[]
 ├── [2]
 │    ├── [2,2]
 │    │     ├── [2,2,2]
 │    │     │     ├── [2,2,2,2] → target < 0 ❌
 │    │     │     └── [2,2,2,3] → target < 0 ❌
 │    │     └── [2,2,3] → target = 0 ✅
 │    └── [2,3]
 │          └── [2,3,3] → target < 0 ❌
 └── [3]
      └── [3,3]
```

Valid combination

```
[2,2,3]
```

---

# Complexity Analysis

### Time Complexity

Worst case:

```
O(2^n)
```

We explore combinations recursively.

Copying subsets adds an extra `O(n)` factor.

Overall:

```
O(n * 2^n)
```

---

### Space Complexity

```
O(n)
```

For recursion stack and temporary subset list.

---

# Pattern Recognition

This problem belongs to the **Backtracking / DFS pattern**.

Related problems:

```
Subsets
Subsets II
Permutations
Combination Sum II
Palindrome Partitioning
```

---

# Important Trick

When including the number:

```
backtrack(i, ...)
```

When skipping the number:

```
backtrack(i + 1, ...)
```

This allows **unlimited reuse of the same element**.

---

# Summary

Key idea:

```
Build combinations recursively
Reduce target when picking numbers
Backtrack when target becomes invalid
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
Generate all combinations
Numbers can be reused
Find target sum
```

You should immediately think:

```
Backtracking
```

✔ Classic **NeetCode / Blind 75 backtracking problem**  
✔ Frequently asked in FAANG interviews
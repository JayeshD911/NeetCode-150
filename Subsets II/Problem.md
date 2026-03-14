# 90. Subsets II

🔗 Problem: https://leetcode.com/problems/subsets-ii/

---

# Problem

Given an integer array `nums` that **may contain duplicates**, return **all possible subsets (the power set)**.

The solution set **must not contain duplicate subsets**. You may return the subsets in any order. :contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input
```
nums = [1,2,2]
```

Output
```
[[],[1],[1,2],[1,2,2],[2],[2,2]]
```

---

### Example 2

Input
```
nums = [0]
```

Output
```
[[],[0]]
```

---

# Key Idea

This problem is similar to **Subsets I**, but the array **may contain duplicate values**.

The challenge is to generate **all subsets without duplicates**.

Key observations:

1. Each element has **two choices**
   ```
   include the element
   skip the element
   ```

2. If duplicates exist, we must **avoid generating the same subset twice**.

3. The standard trick is:

```
Sort the array first
Skip duplicate elements during recursion
```

Sorting places duplicate elements together, which makes them easier to skip. :contentReference[oaicite:1]{index=1}

---

# Intuition

For example:

```
nums = [1,2,2]
```

After sorting:

```
[1,2,2]
```

Decision tree:

```
[]
├─ include 1
│  ├─ include 2
│  │  ├─ include 2 → [1,2,2]
│  │  └─ skip 2
│  └─ skip duplicate 2
└─ skip 1
   ├─ include 2
   │  ├─ include 2 → [2,2]
   │  └─ skip 2
   └─ skip duplicate 2
```

Valid subsets:

```
[]
[1]
[1,2]
[1,2,2]
[2]
[2,2]
```

---

# Backtracking Strategy

At each index we decide:

```
1️⃣ include current number
2️⃣ skip current number (skip duplicates)
```

Steps:

```
choose element
recurse
backtrack
skip duplicates
recurse again
```

---

# Optimal Java Solution (Your Style – Include/Skip Recursion)

```java
class Solution {

    public void solve(int[] nums,
                      int index,
                      List<Integer> temp,
                      List<List<Integer>> ans){

        if(index == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        // include current number
        temp.add(nums[index]);
        solve(nums, index + 1, temp, ans);

        // backtrack
        temp.remove(temp.size() - 1);

        // skip duplicates
        while(index + 1 < nums.length &&
              nums[index] == nums[index + 1]){
            index++;
        }

        // skip current number
        solve(nums, index + 1, temp, ans);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        solve(nums, 0, new ArrayList<>(), ans);

        return ans;
    }
}
```

---

# Dry Run

Input

```
nums = [1,2,2]
```

Steps

```
[]
├─ take 1
│  ├─ take 2
│  │  ├─ take 2 → [1,2,2]
│  │  └─ skip
│  └─ skip duplicate 2
└─ skip 1
   ├─ take 2
   │  ├─ take 2 → [2,2]
   │  └─ skip
   └─ skip duplicate
```

Output

```
[]
[1]
[1,2]
[1,2,2]
[2]
[2,2]
```

---

# Complexity Analysis

### Time Complexity

```
O(n × 2^n)
```

Because we generate all possible subsets.

---

### Space Complexity

```
O(n)
```

Used for recursion stack and temporary subset.

---

# Key Tricks

### 1️⃣ Sort the array

```
Arrays.sort(nums)
```

This ensures duplicates appear together.

---

### 2️⃣ Skip duplicates

```
while(nums[i] == nums[i+1]) i++
```

This prevents generating identical subsets.

---

# Pattern Recognition

This problem belongs to the **Backtracking Pattern**.

Similar problems:

```
Subsets
Combination Sum
Combination Sum II
Permutations
N Queens
```

---

# Summary

Core ideas:

```
Generate subsets using recursion
Sort array to group duplicates
Skip duplicate elements
Backtrack to explore all possibilities
```

Final complexity:

```
Time  : O(n × 2^n)
Space : O(n)
```

---

# Takeaway

Whenever a problem asks for:

```
all subsets
power set
unique subsets with duplicates
```

Think immediately:

```
Backtracking + Sorting + Duplicate Skipping
```


https://neetcode.io/problems/subsets-ii/question?list=neetcode150

https://leetcode.com/problems/subsets-ii/description/
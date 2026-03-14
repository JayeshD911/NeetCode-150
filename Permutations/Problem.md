# 46. Permutations

🔗 Problem: https://leetcode.com/problems/permutations/

---

# Problem

Given an array `nums` of **distinct integers**, return **all possible permutations** of the numbers.

You can return the answer in **any order**. :contentReference[oaicite:0]{index=0}

A **permutation** is a rearrangement of all elements of the array. For an array of length `n`, there are exactly `n!` permutations. :contentReference[oaicite:1]{index=1}

---

# Example

### Example 1

Input

```
nums = [1,2,3]
```

Output

```
[
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
]
```

---

### Example 2

Input

```
nums = [0,1]
```

Output

```
[[0,1],[1,0]]
```

---

### Example 3

Input

```
nums = [1]
```

Output

```
[[1]]
```

---

# Key Idea

This is a **classic backtracking problem**.

At each step we choose **one unused number** and add it to the current permutation.

Once the permutation size becomes `n`, we add it to the answer.

Backtracking then **undoes the last choice** and explores the next option.

---

# Intuition

For:

```
nums = [1,2,3]
```

Decision tree:

```
[]
├── 1
│   ├── 2
│   │   └── [1,2,3]
│   └── 3
│       └── [1,3,2]
├── 2
│   ├── 1
│   │   └── [2,1,3]
│   └── 3
│       └── [2,3,1]
└── 3
    ├── 1
    │   └── [3,1,2]
    └── 2
        └── [3,2,1]
```

Each level picks a number that **has not been used yet**.

---

# Backtracking Strategy

Steps:

```
1️⃣ Start with an empty permutation
2️⃣ Choose a number that hasn't been used
3️⃣ Add it to the current permutation
4️⃣ Recurse
5️⃣ Remove it (backtrack)
6️⃣ Try the next number
```

---

# Optimal Java Solution

```java
class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(nums, new ArrayList<>(), ans, new boolean[nums.length]);

        return ans;
    }

    private void backtrack(int[] nums,
                           List<Integer> temp,
                           List<List<Integer>> ans,
                           boolean[] used){

        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++){

            if(used[i]) continue;

            temp.add(nums[i]);
            used[i] = true;

            backtrack(nums, temp, ans, used);

            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}
```

---

# Dry Run

Input:

```
nums = [1,2]
```

Steps:

```
[]
├── add 1
│   └── [1]
│       └── add 2
│           └── [1,2]
└── add 2
    └── [2]
        └── add 1
            └── [2,1]
```

Output:

```
[[1,2],[2,1]]
```

---

# Complexity Analysis

### Time Complexity

```
O(n × n!)
```

Reason:

- There are `n!` permutations.
- Copying each permutation takes `O(n)`. :contentReference[oaicite:2]{index=2}

---

### Space Complexity

```
O(n)
```

Used for recursion stack and tracking visited elements.

---

# Alternative Approach (Swap Method)

Another method uses **in-place swapping**:

```
Fix position 0 → swap with every element
Fix position 1 → swap remaining elements
Repeat
```

Example:

```
[1,2,3]

swap(0,0)
swap(0,1)
swap(0,2)
```

This also generates all permutations.

---

# Pattern Recognition

This problem belongs to the **Backtracking Pattern**.

Similar problems:

```
Subsets
Combination Sum
Combination Sum II
Permutations II
N-Queens
```

---

# Summary

Key ideas:

```
Generate permutations using DFS
Track used elements
Backtrack after exploring a branch
```

Final complexity:

```
Time  : O(n × n!)
Space : O(n)
```

---

# Takeaway

Whenever a problem asks for:

```
All possible arrangements
All permutations
All orderings
```

Think immediately:

```
Backtracking
```


https://neetcode.io/problems/permutations/question

https://leetcode.com/problems/permutations/
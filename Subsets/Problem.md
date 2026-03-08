# 78. Subsets

🔗 Problem: https://leetcode.com/problems/subsets/

---

# Problem

Given an integer array `nums` containing **unique elements**, return **all possible subsets** (the **power set**).

The solution set **must not contain duplicate subsets** and can be returned in **any order**. :contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input

```
nums = [1,2,3]
```

Output

```
[[],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]]
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

# Constraints

```
1 ≤ nums.length ≤ 10
-10 ≤ nums[i] ≤ 10
All elements in nums are unique
```

---

# Key Insight

Each element in the array has **two choices**:

```
1. Include it in the subset
2. Exclude it from the subset
```

Therefore, for an array of size `n`, the total number of subsets is:

```
2^n
```

because each element has two independent choices. :contentReference[oaicite:1]{index=1}

---

# Intuition (Backtracking)

We generate subsets using **Depth-First Search (DFS)** with backtracking.

At every index we decide:

```
take the element
OR
skip the element
```

Example:

```
nums = [1,2,3]
```

Decision tree:

```
                []
          /             \
       [1]               []
      /   \             /   \
   [1,2]  [1]        [2]    []
   /   \   /  \      /  \    / \
[1,2,3][1,2][1,3][1][2,3][2][3][]
```

Every path in this tree represents **one subset**.

---

# Algorithm

1. Create a result list `res`
2. Use a recursive function `backtrack(start)`
3. Add the current subset to the result
4. Iterate from `start` to `nums.length`
5. Include element
6. Recurse to next index
7. Remove element (backtrack)

---

# Optimal Java Solution (Backtracking)

```java
class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int[] nums, List<Integer> curr, List<List<Integer>> res) {

        res.add(new ArrayList<>(curr));

        for(int i = start; i < nums.length; i++){
            curr.add(nums[i]);
            backtrack(i + 1, nums, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
```

---

# Dry Run

Input

```
nums = [1,2]
```

Start

```
curr = []
res = [[]]
```

---

### Include 1

```
curr = [1]
res = [[],[1]]
```

Include 2

```
curr = [1,2]
res = [[],[1],[1,2]]
```

Backtrack

```
curr = [1]
```

---

### Skip 1 → Include 2

```
curr = [2]
res = [[],[1],[1,2],[2]]
```

Final result

```
[[],[1],[1,2],[2]]
```

---

# Complexity Analysis

### Time Complexity

```
O(n * 2^n)
```

Explanation:

- There are `2^n` subsets
- Each subset copy takes up to `O(n)` time

---

### Space Complexity

```
O(n)
```

For the recursion stack and temporary subset list.

---

# Alternative Approach (Bit Manipulation)

Another elegant way is to treat subsets as **binary numbers**.

For an array of length `n`, iterate from:

```
0 → (2^n - 1)
```

Example for `nums = [a,b,c]`

```
000 → []
001 → [c]
010 → [b]
011 → [b,c]
100 → [a]
101 → [a,c]
110 → [a,b]
111 → [a,b,c]
```

Each bit indicates whether to include that element. :contentReference[oaicite:2]{index=2}

---

# Pattern Recognition

This problem is the **foundation of the Backtracking / Subset pattern**.

Common related problems:

```
Subsets II
Permutations
Combination Sum
Palindrome Partitioning
```

---

# Summary

Core idea:

```
Each element → include or exclude
```

Total subsets:

```
2^n
```

Best approach:

```
Backtracking (DFS)
```

Complexity:

```
Time:  O(n * 2^n)
Space: O(n)
```

---

# Final Takeaway

Whenever a problem asks:

```
Generate all subsets
Generate all combinations
Generate all possibilities
```

You should immediately think:

```
Backtracking / DFS
```

✔ Classic **NeetCode Backtracking pattern problem**  
✔ Very common in FAANG interviews


https://neetcode.io/problems/subsets/question?list=neetcode150

https://neetcode.io/problems/invert-a-binary-tree/question?list=neetcode150
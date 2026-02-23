# 15. 3Sum

Given an integer array `nums`, return *all unique triplets* `[nums[i], nums[j], nums[k]]` such that:

- `i`, `j`, and `k` are **distinct indices** (i.e., `i != j`, `i != k`, and `j != k`), and
- `nums[i] + nums[j] + nums[k] == 0`

🏁 **Return the solution set in any order.**

---

## Example 1

**Input:**  
`nums = [-1,0,1,2,-1,-4]`

**Output:**  
`[[-1,-1,2],[-1,0,1]]`

**Explanation:**  
From the array, the triplets satisfying the condition are:
- `(-1, -1, 2)`
- `(-1, 0, 1)`

---

## Example 2

**Input:**  
`nums = []`

**Output:**  
`[]`

---

## Example 3

**Input:**  
`nums = [0]`

**Output:**  
`[]`

---

## Constraints

- `0 <= nums.length <= 3000`
- `-10⁵ <= nums[i] <= 10⁵`

---

## Notes

- The array elements are **not** sorted.
- Expect overlapping triplets, so you must avoid duplicates in the output.
- **Sorting + two pointers** is the common optimized strategy:
    1. Sort the array.
    2. For each number, use two pointers to find two more numbers that sum to its negation.
    3. Skip duplicates to avoid repeated triplets.
- Target complexity: **O(n²)** time.

https://leetcode.com/problems/3sum/

https://neetcode.io/problems/three-integer-sum/question?list=neetcode150
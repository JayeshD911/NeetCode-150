# 217. Contains Duplicate (Easy)

## Problem Statement
Given an integer array `nums`, return `true` if any value appears **at least twice** in the array, and return `false` if every element is distinct.

**Example 1:**
*   **Input:** nums = `[1,2,3,1]`
*   **Output:** `true`

**Example 2:**
*   **Input:** nums = `[1,2,3,4]`
*   **Output:** `false`

**Example 3:**
*   **Input:** nums = `[1,1,1,3,3,4,3,2,4,2]`
*   **Output:** `true`

---

## Solutions

Several approaches can be used to solve this problem, including using a hash set, sorting the array, or a brute-force comparison. The optimal solution uses a hash set, offering a time complexity of $O(n)$.

### 1. Hash Set (Optimal)
*   **Approach:** Iterate through the array and use a hash set to keep track of elements encountered. If an element is already in the set, a duplicate is found.
*   **Time Complexity:** $O(n)$
*   **Space Complexity:** $O(n)$

https://leetcode.com/problems/contains-duplicate/description/

https://neetcode.io/problems/duplicate-integer/question?list=neetcode150


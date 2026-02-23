# 11. Container With Most Water

You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the **two endpoints** of the `i`th line are at `(i, 0)` and `(i, height[i])`. :contentReference[oaicite:0]{index=0}

Find **two lines** that, together with the **x-axis**, form a container such that the container contains the **most water**. Return the **maximum amount of water** the container can store.  
You may **not slant the container** (it must remain upright). :contentReference[oaicite:1]{index=1}

---

## Example 1

**Input:**  
`height = [1,8,6,2,5,4,8,3,7]`

**Output:**  
`49`

**Explanation:**  
Selecting the lines at indices `1` and `8` (0-based), the width is `7` and the height of the container is `min(8,7) = 7`.  
So, the area = `7 × 7 = 49`. :contentReference[oaicite:2]{index=2}

---

## Example 2

**Input:**  
`height = [1,1]`

**Output:**  
`1`

---

## Example 3

**Input:**  
`height = [4,3,2,1,4]`

**Output:**  
`16`

---

## Constraints

- `n == height.length`
- `2 <= n <= 3 × 10⁴`
- `0 <= height[i] <= 3 × 10⁴` :contentReference[oaicite:3]{index=3}

---

## Notes

- The amount of water contained by two lines at positions `i` and `j` is calculated as:  
  `min(height[i], height[j]) × (j − i)`  
  — height limited by the shorter line and width is the horizontal distance between the lines. :contentReference[oaicite:4]{index=4}

- A **brute force solution** would check all pairs of lines in **O(n²)** time.
- The **optimal solution** uses a **two-pointer technique** with **O(n)** time and **O(1)** space:
    1. Initialize two pointers at `l = 0` and `r = n − 1`.
    2. Calculate area, update maximum, then move the pointer pointing to the shorter line inward, since moving the taller line cannot increase area.
    3. Repeat while `l < r`. :contentReference[oaicite:5]{index=5}

- The fact that moving the pointer at the shorter line always leads toward the optimal solution is a key observation for correctness. :contentReference[oaicite:6]{index=6}

https://neetcode.io/problems/max-water-container/question

https://leetcode.com/problems/container-with-most-water/description/
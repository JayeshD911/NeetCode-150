# 42. Trapping Rain Water

Given `n` non-negative integers representing an elevation map where the width of each bar is 1, compute how much **water it can trap after raining**.

---

## Example 1

**Input:**  
`height = [0,1,0,2,1,0,1,3,2,1,2,1]`

**Output:**  
`6`

**Explanation:**  
Water trapped at each position is shown below:

```
   ⏺   
 🟦⏺🟦  
🟦🟦🟦🟦                    
```

Total trapped water = **6 units**.

---

## Example 2

**Input:**  
`height = [4,2,0,3,2,5]`

**Output:**  
`9`

---

## Constraints

- `n == height.length`
- `0 <= n <= 3 × 10⁴`
- `0 <= height[i] <= 10⁵`

---

## Notes

### What the Problem Asks

You are given an array where each element represents the **height of a bar**. After it rains, water gets trapped between the bars. You need to calculate **total trapped water**.

---

## Approaches

### 🧠 Brute Force (O(n²))
For each bar, find:
- **max height to the left**
- **max height to the right**

Then water trapped =  
`min(max_left, max_right) - height[i]`  
Sum up for all `i`.

Too slow for large input.

---

### 🚀 Optimal (Two Pointers — O(n)/O(1) space)

Use two pointers:
- `left` from start
- `right` from end  
  Keep track of:
- `leftMax`: tallest bar from left so far
- `rightMax`: tallest bar from right so far

Move pointers inward:
- Compare `height[left]` and `height[right]`
- Update trapped water based on which side is smaller

This works because trapped water depends on the smaller boundary.

---

### 🧮 Formula

At each position:
```
water_at_i = min(leftMax[i], rightMax[i]) - height[i]
```

---

## Key Idea

Water is trapped where there are boundaries on both sides.  
The shorter boundary controls how much water can be stored.

Typical patterns used:
- prefix/max arrays
- two pointers
- stacks (alternative solution)

---

## Related Topics

- Two Pointers
- Dynamic Programming
- Stack
- Arrays
# 84. Largest Rectangle in Histogram

Given an array of integers `heights` representing the **height of bars in a histogram**, return *the area of the **largest rectangle** that can be formed within the bounds of the histogram*.

Each bar has a **width of 1**, and the rectangle must be fully contained in the histogram.

---

## Example 1

**Input:**  
`heights = [2,1,5,6,2,3]`

**Output:**  
`10`

**Explanation:**  
The largest rectangle has area 10, formed by heights `[5,6]` with width 2.

---

## Example 2

**Input:**  
`heights = [2,4]`

**Output:**  
`4`

**Explanation:**  
The largest rectangle has area 4, formed by height 2 with width 2.

---

## Constraints

- `1 <= heights.length <= 10⁵`
- `0 <= heights[i] <= 10⁵`

---

## Notes

### What the Problem Asks

You are given a histogram represented as an array of bar heights.  
You want to find the *largest rectangular area* that can be formed using one or more consecutive bars.

This rectangle’s:
- **height** is limited by the shortest bar in the range, and
- **width** is the number of consecutive bars used.

---

## Example Walkthrough

Given:

```
heights = [2,1,5,6,2,3]
```

Some candidate rectangles:

```
Area with height 2 across bars 0–5 → 2 × 6 = 12
Area with height 5 across bars 2–3 → 5 × 2 = 10
Area with height 6 at bar 3 → 6 × 1 = 6
```

The maximum among these is **10**.

---

## Common Approaches

### 🧠 Brute Force (O(n²))

Check every pair of left/right indices and compute the minimal height → area.  
Too slow for large n.

---

### 🚀 Optimal: Monotonic Stack (O(n))

Use a stack to track indices of bars in **ascending order**:

1. Traverse heights left to right.
2. Push each index onto the stack **as long as the next bar is taller** than the top of the stack.
3. When you encounter a **shorter bar**, pop bars from the stack until it’s again in ascending order.
    - For each popped bar, compute area:
      ```
      height = height[poppedIndex]
      width  = currentIndex - stack.peek() - 1
      ```
      (the stack now provides the left boundary)
4. After the traversal, pop remaining bars and compute areas using:
   ```
   width = n - stack.peek() - 1
   ```
5. Return the maximum area found.

This works because the stack maintains the **nearest smaller to the left** and scanning finds **nearest smaller to the right**.

---

## Pseudocode (Stack)

```
stack = [-1]                 // sentinel
maxArea = 0

for i in 0..n:
    while stack.top != -1 AND (i == n OR heights[i] < heights[stack.top]):
        h = heights[stack.pop()]
        w = i - stack.top - 1
        maxArea = max(maxArea, h * w)
    stack.push(i)

return maxArea
```

---

## Time & Space Complexity

| Complexity | Value |
|------------|-------|
| Time | O(n) |
| Space | O(n) |

Each bar index enters and exits the stack exactly once.

---

## Related Topics

- Stack
- Monotonic Stack
- Arrays
- Largest Rectangle Problems  
  
https://neetcode.io/problems/largest-rectangle-in-histogram/question?list=neetcode150

https://leetcode.com/problems/largest-rectangle-in-histogram/description/
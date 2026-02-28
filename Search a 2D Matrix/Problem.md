# 74. Search a 2D Matrix

Write an efficient algorithm that searches for a value `target` in an `m x n` integer matrix `matrix`.  
The matrix has the following properties:

1. Integers in each row are sorted in **ascending order** from left to right.
2. The first integer of each row is **greater than** the last integer of the previous row.

Return `true` if `target` exists in the matrix, and `false` otherwise.  
You must write an algorithm with **O(log(m·n))** runtime complexity. [[leetcode.com](https://leetcode.com/problems/search-a-2d-matrix/?utm_source=chatgpt.com)]

---

## Example 1

**Input:**
```
matrix = [
  [1, 3, 5, 7],
  [10, 11, 16, 20],
  [23, 30, 34, 60]
], target = 3
```

**Output:**
```
true
```

---

## Example 2

**Input:**
```
matrix = [
  [1, 3, 5, 7],
  [10, 11, 16, 20],
  [23, 30, 34, 60]
], target = 13
```

**Output:**
```
false
```

---

## Constraints

- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= m, n <= 100`
- `-10⁴ <= matrix[i][j], target <= 10⁴`
- All rows are sorted in ascending order.
- All rows are ordered such that the first element of each row is greater than the last element of the previous row.

---

## Notes

Because of the matrix’s structure, you can treat the entire matrix as a **sorted list** of length `m × n`.  
The element at index `k` in this virtual list corresponds to:

```
row = k / n
col = k % n
```

Using this mapping, you can apply **binary search** in a single pass over the entire matrix.

---

## Algorithm (Binary Search in 2D)

1. Let `m` = number of rows, `n` = number of columns.
2. Initialize:
   ```java
   int low = 0;
   int high = m * n - 1;
   ```
3. While `low <= high`:
    - Compute mid safely:
      ```java
      int mid = low + (high - low) / 2;
      ```
    - Map mid to 2D:
      ```java
      int row = mid / n;
      int col = mid % n;
      ```
    - If `matrix[row][col] == target`: return `true`.
    - Else if `matrix[row][col] < target`: search right half → `low = mid + 1`.
    - Else: search left half → `high = mid - 1`.
4. Return `false` if not found.

---

## Time & Space Complexity

| Complexity | Value |
|------------|-------|
| Time       | O(log(m·n)) |
| Space      | O(1) |

---

## Example Walkthrough

Input:
```
matrix = [
  [1, 3, 5, 7],
  [10, 11, 16, 20],
  [23, 30, 34, 60]
], target = 3
```

- m = 3, n = 4 → total 12 elements
- Binary search over 0..11
- mid → 5 → matrix[1][1] == 11 → adjust range
- Continue until find 3 → return true

---

## Related Topics

- Binary Search
- Arrays
- Matrix  

https://neetcode.io/problems/search-2d-matrix/question?list=neetcode150

https://leetcode.com/problems/search-a-2d-matrix/description/
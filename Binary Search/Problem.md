# 704. Binary Search

Given an integer array `nums` which is **sorted in ascending order**, and an integer `target`, write a function to **search** `target` in `nums`.  
If `target` exists, return *its index*. Otherwise, return `-1`.

You must write an algorithm with **O(log n)** runtime complexity. [[leetcode.com](https://leetcode.com/problems/binary-search/?utm_source=chatgpt.com)]

---

## Example 1

**Input:**
```
nums = [-1,0,3,5,9,12], target = 9
```

**Output:**
```
4
```

**Explanation:**  
9 exists in the array and its index is 4.

---

## Example 2

**Input:**
```
nums = [-1,0,3,5,9,12], target = 2
```

**Output:**
```
-1
```

**Explanation:**  
2 does not exist in the array.

---

## Example 3

**Input:**
```
nums = [5], target = 5
```

**Output:**
```
0
```

---

## Constraints

- `1 <= nums.length <= 10⁴`
- `-10⁴ <= nums[i], target <= 10⁴`
- All elements in `nums` are **unique**.
- `nums` is sorted in **strictly increasing** order.

---

## Notes

- You are required to implement **binary search**, not linear scan.
- Binary search repeatedly halves the search range to achieve **O(log n)** time.

---

## Algorithm (Binary Search)

1. Initialize:
   ```java
   int low = 0, high = nums.length - 1;
   ```
2. While `low <= high`:
    - Compute the middle index **safely**:
      ```java
      int mid = low + (high - low) / 2;
      ```
    - If `nums[mid] == target`: return `mid`.
    - Else if `nums[mid] < target`: search right half → `low = mid + 1`.
    - Else: search left half → `high = mid - 1`.
3. If not found, return `-1`.

---

## Time & Space Complexity

| Complexity | Value |
|------------|-------|
| Time       | O(log n) |
| Space      | O(1) |

---

## Example Walkthrough

Input:
```
nums = [-1,0,3,5,9,12], target = 9
```

- Step 1: low=0, high=5 → mid=2 → nums[mid]=3 → less than 9 → move low
- Step 2: low=3, high=5 → mid=4 → nums[mid]=9 → found → return 4

---

## Related Topics

- Binary Search
- Arrays
- Divide & Conquer  

https://neetcode.io/problems/binary-search/history?submissionIndex=9

https://leetcode.com/problems/binary-search/
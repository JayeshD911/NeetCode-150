# 🔴 33. Search in Rotated Sorted Array

## 📌 Problem Statement

You are given an integer array `nums` sorted in ascending order (with **distinct values**) and an integer `target`.

Suppose that `nums` is **rotated** at some pivot unknown to you beforehand (i.e., the array might look like `[4,5,6,7,0,1,2]`).

Write a function to **search `target` in `nums`**. If `target` exists, return its index. Otherwise, return `-1`.

You must write an algorithm with **O(log n)** runtime complexity.

---

## 🧾 Examples

### Example 1
```
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```

### Example 2
```
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```

### Example 3
```
Input: nums = [1], target = 0
Output: -1
```

---

## 🔒 Constraints

- `1 <= nums.length <= 5000`
- `-10^4 <= nums[i] <= 10^4`
- All values of `nums` are **unique**
- `nums` is sorted and then possibly rotated
- `target` is an integer

---

# 🚀 Optimal Approach: Modified Binary Search

## 💡 Key Insight

Even though the array is rotated, **one half of the array is always sorted** at each step of binary search.

At index `mid`, one of the following must be true:

```
Left half [left..mid] is sorted
OR
Right half [mid..right] is sorted
```

So we can:

1. Find which half is sorted
2. Check if the target is in that half
3. Adjust `left` and `right` accordingly

This still gives **O(log n)** time.

---

## 🧠 Algorithm

1. Initialize `left = 0`, `right = n - 1`
2. While `left <= right`:
    - Compute `mid`
    - If `nums[mid] == target`: return `mid`
    - If left half `[left..mid]` is sorted:
        - If target lies in `[nums[left]..nums[mid]]`: search left → `right = mid - 1`
        - Else search right → `left = mid + 1`
    - Else (right half is sorted):
        - If target lies in `[nums[mid]..nums[right]]`: search right → `left = mid + 1`
        - Else search left → `right = mid - 1`
3. If not found → return `-1`

---

## 🧑‍💻 Python Code

```python
class Solution:
    def search(self, nums: list[int], target: int) -> int:
        left, right = 0, len(nums) - 1

        while left <= right:
            mid = left + (right - left) // 2

            if nums[mid] == target:
                return mid

            # If left half is sorted
            if nums[left] <= nums[mid]:
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                # Right half is sorted
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1

        return -1
```

---

## ⏱ Complexity

| Metric        | Value        |
|--------------|--------------|
| Time         | **O(log n)** |
| Space        | **O(1)**     |

---

# 📚 Visual Example

**Case:**
```
nums = [4,5,6,7,0,1,2], target = 0
```

- left = 0, right = 6
- mid = 3 (nums[3]=7)

Left half `[4,5,6,7]` is sorted  
Target = 0 is NOT in that range  
→ Search right half → `left = mid + 1`

Now:
```
left = 4, nums[left] = 0
right = 6
mid = 5 (nums[5]=1)
```

Right half `[0,1,2]` is sorted  
Target = 0 is in this half  
→ move left/right accordingly
→ eventually find index 4

---

# 📚 Key Takeaways

✅ In a rotated sorted array, one half is always sorted  
✅ Use binary search to narrow down target  
✅ No need to actually find pivot first  
✅ Time complexity remains **O(log n)**

---

# 📅 Daily LeetCode Log

- Day: XX
- Topic: Binary Search
- Difficulty: Medium
- Language: Python

---


https://neetcode.io/problems/find-target-in-rotated-sorted-array/question?list=neetcode150

https://leetcode.com/problems/search-in-rotated-sorted-array/description/
# 🔴 153. Find Minimum in Rotated Sorted Array

## 📌 Problem Statement

Suppose an array of unique integers `nums` sorted in ascending order is **rotated** at some pivot unknown to you beforehand.

For example, the array `nums = [0,1,2,4,5,6,7]` might become:
```
[4,5,6,7,0,1,2]
```

Find the **minimum element** of this array.

You must write an algorithm that runs in **O(log n)** time.

---

## 🧾 Examples

### Example 1
```
Input: nums = [3,4,5,1,2]
Output: 1
```

### Example 2
```
Input: nums = [4,5,6,7,0,1,2]
Output: 0
```

### Example 3
```
Input: nums = [11,13,15,17]
Output: 11
```

---

## 🔒 Constraints

- `1 <= nums.length <= 5000`
- `-5000 <= nums[i] <= 5000`
- All values in `nums` are **unique**
- `nums` is sorted and rotated at some pivot

---

# 🚀 Approach: Binary Search (Optimal) ✅

## 💡 Key Insight

A rotated sorted array looks like:

```
[ higher values ... pivot ... lower values ]
```

But the important properties are:

- The minimum element is the **only element** such that:
```
nums[i] < nums[i - 1]
```

- If the array is **not rotated at all**, then:
```
nums[0] is the minimum
```

---

## 🧠 Binary Search Idea

We compare mid with the rightmost element:

- If `nums[mid] > nums[right]`:  
  → the minimum must be **to the right** of mid

- Otherwise (`nums[mid] <= nums[right]`):  
  → the minimum is at mid or to the **left**

This reduces the search space in half each time.

---

## 🧑‍💻 Python Code

```python
class Solution:
    def findMin(self, nums: list[int]) -> int:
        left, right = 0, len(nums) - 1
        
        while left < right:
            mid = left + (right - left) // 2
            
            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid
        
        return nums[left]
```

---

## ⏱ Complexity

| Complexity | Value |
|------------|--------|
| Time       | **O(log n)** |
| Space      | **O(1)** |

---

# 📚 Visualization

Suppose:
```
nums = [4,5,6,7,0,1,2]
```

- left = 0 → 4
- right = 6 → 2

mid = (0 + 6) // 2 = 3 → `nums[mid] = 7`

Since:
```
nums[mid] > nums[right]
→ Minimum must be on the right
```

Now:
```
left = 4
right = 6
```

mid = 5 → `nums[mid] = 1`

Since:
```
nums[mid] <= nums[right]
→ Minimum is at or before mid
```

Now:
```
left = 4
right = 5
```

mid = 4 → `nums[mid] = 0` → smallest!

---

# 📚 Key Takeaways

- Use binary search to find pivot or minimum
- Compare `nums[mid]` with `nums[right]`
- Keep shrinking the search space to O(log n)

---

# 📅 Daily LeetCode Log

- Day: XX
- Topic: Binary Search
- Difficulty: Medium
- Language: Python

---

https://neetcode.io/problems/find-minimum-in-rotated-sorted-array/question?list=neetcode150

https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/1934571212/

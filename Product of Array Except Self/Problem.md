# Product of Array Except Self

## Problem Statement

Given an integer array `nums` of length `n`, return an array `answer` such that:
answer[i] is equal to the product of all the elements of nums except nums[i].
You must solve the problem **without using division** and in **O(n)** time.

---

## Example 1

**Input:**
nums = [1, 2, 3, 4]

**Output:**
[24, 12, 8, 6]


---

## Example 2

**Input:**
nums = [-1, 1, 0, -3, 3]


**Output:**
[0, 0, 9, 0, 0]


---

## Constraints

- `2 <= nums.length <= 10^5`
- `-30 <= nums[i] <= 30`
- The product of any prefix or suffix of `nums` is guaranteed to fit in a 32-bit integer.

---

## Approach

To solve this efficiently:
- First, compute the **prefix product** for each index.
- Then, compute the **suffix product** and multiply it with the prefix product.
- This avoids division and maintains linear time complexity.

---

## Algorithm

1. Initialize an array `answer` with all elements set to `1`.
2. Traverse from left to right, storing the product of all elements to the left.
3. Traverse from right to left, multiplying the product of all elements to the right.
4. The result at each index will be the product of its left and right values.

---

## Python Implementation

```python
class Solution:
    def productExceptSelf(self, nums):
        n = len(nums)
        answer = [1] * n

        prefix = 1
        for i in range(n):
            answer[i] = prefix
            prefix *= nums[i]

        suffix = 1
        for i in range(n - 1, -1, -1):
            answer[i] *= suffix
            suffix *= nums[i]

        return answer
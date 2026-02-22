# 167. Two Sum II - Input Array Is Sorted

Given a **1-indexed** array of integers `numbers` that is already sorted in **non-decreasing order**, find two numbers such that they add up to a specific `target` number.

Let the two numbers be `numbers[index1]` and `numbers[index2]` where **1 ≤ index1 < index2 ≤ numbers.length**.

Return the indices of the two numbers, **1-indexed**, as an integer array `[index1, index2]` of length 2.

You may assume that each input would have **exactly one solution**, and you may not use the same element twice.

Your solution must use only **constant extra space**.

---

## Example 1

**Input:**  
`numbers = [2,7,11,15], target = 9`

**Output:**  
`[1,2]`

**Explanation:**  
The sum of `numbers[1] + numbers[2]` = `2 + 7` = `9`.  
Therefore, return `[1,2]`.

---

## Example 2

**Input:**  
`numbers = [2,3,4], target = 6`

**Output:**  
`[1,3]`

**Explanation:**  
The sum of `numbers[1] + numbers[3]` = `2 + 4` = `6`.  
Therefore, return `[1,3]`.

---

## Example 3

**Input:**  
`numbers = [-1,0], target = -1`

**Output:**  
`[1,2]`

**Explanation:**  
The sum of `numbers[1] + numbers[2]` = `-1 + 0` = `-1`.  
Therefore, return `[1,2]`.

---

## Constraints

- `2 <= numbers.length <= 3 * 10⁴`
- `-1000 <= numbers[i] <= 1000`
- `numbers` is sorted in non-decreasing order.
- `-1000 <= target <= 1000`

---

## Notes

- The array is **sorted**, so a **two-pointer** approach is ideal.
- Use **1-based indexing**.
- Exactly **one solution** exists.
- Only **constant extra space** is allowed (O(1)).
  
- https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
- https://neetcode.io/problems/two-integer-sum-ii/question?list=neetcode150
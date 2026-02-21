# 128. Longest Consecutive Sequence

Given an unsorted array of integers `nums`, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in **O(n)** time.

---

## Example 1

Input:  
`nums = [100,4,200,1,3,2]`

Output:  
`4`

Explanation:  
The longest consecutive sequence is `[1,2,3,4]`.  
Therefore, its length is `4`.

---

## Example 2

Input:  
`nums = [0,3,7,2,5,8,4,6,0,1]`

Output:  
`9`

Explanation:  
The longest consecutive sequence is `[0,1,2,3,4,5,6,7,8]`.  
Therefore, its length is `9`.

---

## Example 3

Input:  
`nums = [1,0,1,2]`

Output:  
`3`

Explanation:  
The longest consecutive sequence is `[0,1,2]`.  
Therefore, its length is `3`.

---

## Constraints

- `0 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`

---

## Notes

- The array is not necessarily sorted.
- Duplicate values may exist.
- The required time complexity is **O(n)**, which typically suggests using a **HashSet**.
- Sorting the array would result in **O(n log n)** time, which does not satisfy the problem constraint.
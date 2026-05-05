# 268. Missing Number

## 🟢 Difficulty
Easy

## 🔗 Problem Link
https://leetcode.com/problems/missing-number/

---------------------

## 📝 Problem Statement

Given an array `nums` containing `n` distinct numbers in the range `[0, n]`, return the **only number in the range that is missing from the array**.

---------------------

## 📥 Examples

### Example 1
Input: nums = [3,0,1]  
Output: 2

### Example 2
Input: nums = [0,1]  
Output: 2

### Example 3
Input: nums = [9,6,4,2,3,5,7,0,1]  
Output: 8

---------------------

## ⚙️ Constraints

- n == nums.length
- 1 ≤ n ≤ 10⁴
- 0 ≤ nums[i] ≤ n
- All numbers in `nums` are unique

---------------------

## 💡 Key Idea

- Numbers range from **0 to n**
- Exactly **one number is missing**
- Use math or bit manipulation for O(n) time and O(1) space

---------------------

## 🧠 Approach 1: Sum Formula (Best for Interviews)

- Expected sum = n * (n + 1) / 2
- Actual sum = sum(nums)
- Missing = expected - actual

---------------------

## 🚀 Code (Sum Approach - Java)

class Solution {
public int missingNumber(int[] nums) {
int n = nums.length;

        int expected = n * (n + 1) / 2;
        int actual = 0;
        
        for (int num : nums) {
            actual += num;
        }
        
        return expected - actual;
    }
}

---------------------

## 🧠 Approach 2: XOR Trick (Optimal & Elegant)

- a ^ a = 0, a ^ 0 = a
- XOR all indices and values → remaining is missing

---------------------

## 🚀 Code (XOR Approach - Java)

class Solution {
public int missingNumber(int[] nums) {
int n = nums.length;
int xor = n;

        for (int i = 0; i < n; i++) {
            xor ^= i ^ nums[i];
        }
        
        return xor;
    }
}

---------------------

## 🧠 Approach 3: Sorting

- Sort array
- First index where nums[i] != i is the answer

---------------------

## 🚀 Code (Sorting - Java)

import java.util.Arrays;

class Solution {
public int missingNumber(int[] nums) {
Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        
        return nums.length;
    }
}

---------------------

## ⏱️ Complexity

| Approach | Time | Space |
|---------|------|------|
| Sum     | O(n) | O(1) |
| XOR     | O(n) | O(1) |
| Sorting | O(n log n) | O(1) |

---------------------

## ⚠️ Edge Cases

- Missing number is `0`
- Missing number is `n`
- Single element array

---------------------

## 🧩 Tags

- Array
- Math
- Bit Manipulation

---------------------

## 🏁 Summary

- Best solutions: **Sum or XOR (O(n), O(1))**
- XOR is more elegant and avoids overflow concerns
- Sorting works but is not optimal

---------------------


https://neetcode.io/problems/missing-number/question

https://leetcode.com/problems/missing-number/
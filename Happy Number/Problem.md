# 202. Happy Number

## 🧩 Problem

Write an algorithm to determine if a number `n` is happy.

A **happy number** is defined by the following process:

- Starting with any positive integer, replace the number by the **sum of the squares of its digits**.
- Repeat the process until:
    - The number becomes **1** (happy), OR
    - It **loops endlessly in a cycle** that does not include 1.
- Numbers that end in `1` are called **happy numbers**.

Return `true` if `n` is a happy number, otherwise return `false`.

-----------------------------

## 🔍 Examples

### Example 1

Input: n = 19  
Output: true

Explanation:

1² + 9² = 82  
8² + 2² = 68  
6² + 8² = 100  
1² + 0² + 0² = 1

-----------------------------

### Example 2

Input: n = 2  
Output: false

-----------------------------

## 💡 Intuition

- Each step transforms the number into the **sum of squares of its digits**
- Two possibilities:
    1. It reaches **1 → Happy Number**
    2. It falls into a **cycle → Not Happy**

👉 So the real problem is **cycle detection**

-----------------------------

## 🚀 Optimal Approach (Floyd’s Cycle Detection)

Use the **Tortoise & Hare algorithm**:

- `slow` moves 1 step
- `fast` moves 2 steps
- If there is a cycle → they will meet
- If they meet at `1` → number is happy

-----------------------------

## ⏱ Complexity

Time: O(log n) per transformation  
Space: O(1)

-----------------------------

## ✅ Java Solution (Optimal)

class Solution {
public boolean isHappy(int n) {
int slow = n;
int fast = n;

        do {
            slow = next(slow);
            fast = next(next(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private int next(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
}

-----------------------------

## 🧠 Explanation of Code

- `next(num)` → computes sum of squares of digits
- `slow` advances by 1 step
- `fast` advances by 2 steps
- If a cycle exists → they meet
- If meeting point is `1` → return true

-----------------------------

## ⚡ Alternative Approach (HashSet)

import java.util.*;

class Solution {
public boolean isHappy(int n) {
Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = next(n);
        }

        return n == 1;
    }

    private int next(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
}

-----------------------------

## 🏁 Summary

Approach        | Time   | Space | Notes
--------------- | ------ | ----- | ----------------
HashSet         | O(n)   | O(n)  | Simple
Floyd Cycle     | O(n)   | O(1)  | Optimal

-----------------------------

## 🔑 Key Takeaways

- This is a **cycle detection problem**
- Use **Floyd’s algorithm** for optimal space
- Think: repeated transformation → possible loop

-----------------------------


https://neetcode.io/problems/non-cyclical-number/question

https://leetcode.com/problems/happy-number/description/
# 🔗 Plus One

Problem: https://leetcode.com/problems/plus-one/

---

# Problem

You are given a **large integer** represented as an integer array `digits`, where:

```
digits[i] = ith digit of the number
```

👉 The digits are ordered from **most significant → least significant**
👉 The number does **not contain leading zeros**

Return the array after **adding one to the integer**

---

# Example

### Example 1

```
Input: digits = [1,2,3]
Output: [1,2,4]
```

### Explanation

```
123 + 1 = 124
```

---

### Example 2

```
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
```

### Explanation

```
4321 + 1 = 4322
```

---

### Example 3

```
Input: digits = [9]
Output: [1,0]
```

### Explanation

```
9 + 1 = 10
```

---

# Key Idea 💡

👉 This is a **carry handling problem**

Just like normal addition:

```
9 + 1 = 10 → carry = 1
```

👉 Start from the **last digit (rightmost)**
👉 Handle carry and move left

---

# Intuition 🧠 (Baby Words)

Think like adding numbers on paper:

```
  129
+   1
-----
  130
```

👉 If digit ≠ 9 → just add 1 and stop
👉 If digit = 9 → becomes 0 and carry moves left

---

# Strategy 🚀

1. Start from last index `n-1`
2. If digit < 9:

    * increment and return
3. If digit == 9:

    * set to 0 and continue
4. If all digits were 9:

    * create new array of size `n+1`
    * first element = 1

---

# Optimal Java Solution 💻

```java
class Solution {
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        // If all digits were 9
        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }
}
```

---

# Dry Run 🧪

### Input:

```
digits = [9,9,9]
```

### Steps:

```
i = 2 → 9 → becomes 0
i = 1 → 9 → becomes 0
i = 0 → 9 → becomes 0
```

All digits became 0 → need new array

```
result = [1,0,0,0]
```

---

# Complexity ⏱️

| Type  | Value                |
| ----- | -------------------- |
| Time  | O(n)                 |
| Space | O(1) (except output) |

---

# Key Tricks 🎯

* Stop early when digit < 9 ✅
* Only create new array when **all digits are 9**
* Traverse from **right to left**

---

# Pattern Recognition 🔍

👉 This is a:

```
Array Traversal + Carry Simulation
```

Similar problems:

* Add Binary
* Add Strings
* Increment large numbers

---

# Summary 🧾

* Traverse from end
* Handle carry properly
* Most cases → return early
* Edge case → all 9’s

---

# Takeaway 🚀

👉 Whenever you see:

```
"Add 1 to number represented as array"
```

Think:

```
RIGHT → LEFT traversal + carry
```

---


https://neetcode.io/problems/plus-one/question

https://leetcode.com/problems/plus-one/
# 🔗 Palindromic Substrings

Problem: https://leetcode.com/problems/palindromic-substrings/

---

# Problem

Given a string `s`, return **the number of palindromic substrings** in it.

### Definition:

* A **palindrome** = reads same forward & backward
* A **substring** = contiguous sequence of characters

👉 Important:
Substrings with **different start/end indexes are counted separately** even if they look the same

---

# Example

### Example 1

```
Input: s = "abc"
Output: 3
```

### Explanation

```
"a", "b", "c"
```

Each character is a palindrome → total = 3

---

### Example 2

```
Input: s = "aaa"
Output: 6
```

### Explanation

```
"a", "a", "a"   → 3
"aa", "aa"      → 2
"aaa"           → 1
```

Total = **6**

---

# Key Idea 💡

👉 Instead of checking all substrings (O(n³)),
we use **Expand Around Center**

Every palindrome has a **center**:

* Odd length → center is a character (`aba`)
* Even length → center is between characters (`abba`)

👉 Expand from center outward while characters match
👉 Count all valid expansions

This gives **O(n²)** time and **O(1)** space

---

# Intuition 🧠

Think of palindrome like a **mirror**

```
aba → center = b
abba → center = between b and b
```

From each center:

* expand left & right
* if same → palindrome
* keep going

👉 Every successful expansion = 1 palindrome

---

# Strategy 🚀

1. Loop through every index `i`
2. Treat `i` as:

    * center for odd palindrome `(i, i)`
    * center for even palindrome `(i, i+1)`
3. Expand both sides
4. Count matches

---

# Optimal Java Solution 💻

```java
class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            // Odd length palindromes
            count += expand(s, i, i);

            // Even length palindromes
            count += expand(s, i, i + 1);
        }

        return count;
    }

    private int expand(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length() && 
               s.charAt(left) == s.charAt(right)) {

            count++;   // Found a palindrome
            left--;
            right++;
        }

        return count;
    }
}
```

---

# Dry Run 🧪

### Input:

```
s = "aaa"
```

### Iteration:

#### i = 0

* odd → "a" → +1
* even → "aa" → +1

#### i = 1

* odd → "a", "aaa" → +2
* even → "aa" → +1

#### i = 2

* odd → "a" → +1
* even → none

### Total:

```
1 + 1 + 2 + 1 + 1 = 6
```

---

# Complexity ⏱️

| Type  | Value |
| ----- | ----- |
| Time  | O(n²) |
| Space | O(1)  |

---

# Key Tricks 🎯

* Always check **both centers**:

  ```
  (i, i)     → odd
  (i, i + 1) → even
  ```
* Every expansion = 1 palindrome
* No need to store substrings → just count

---

# Pattern Recognition 🔍

👉 Expand Around Center Pattern

Used in:

* Longest Palindromic Substring
* Palindrome Partitioning
* Count Palindromes

---

# Summary 🧾

* Brute force → O(n³) ❌
* Expand center → O(n²) ✅
* Count palindromes while expanding
* Handle both odd & even cases

---

# Takeaway 🚀

👉 Whenever you see:

```
"Palindrome + substring"
```

Think:

```
CENTER EXPANSION
```

https://neetcode.io/problems/palindromic-substrings/question?list=neetcode150

https://leetcode.com/problems/palindromic-substrings/description/

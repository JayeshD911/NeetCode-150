# 🔗 Decode Ways

Problem: https://leetcode.com/problems/decode-ways/

---

# Problem

A message containing letters from **A–Z** is encoded as:

```
'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
```

Given a string `s` containing only digits, return the **total number of ways to decode it**.

👉 Important Rules:

* `"1" → "9"` are valid single digits
* `"10" → "26"` are valid two-digit numbers
* `"0"` **cannot be decoded alone** ([AlgoMonster][1])
* Leading zero → invalid

---

# Example

### Example 1

```
Input: s = "12"
Output: 2
```

### Explanation

```
"1 2" → "AB"
"12"  → "L"
```

---

### Example 2

```
Input: s = "226"
Output: 3
```

### Explanation

```
"2 2 6" → "BBF"
"22 6"  → "VF"
"2 26"  → "BZ"
```

---

### Example 3

```
Input: s = "06"
Output: 0
```

### Explanation

```
"06" is invalid (leading zero)
```

---

# Key Idea 💡

👉 At every index, you have **2 choices**:

1. Take **1 digit** (if valid)
2. Take **2 digits** (if between 10–26)

👉 So this becomes a **Dynamic Programming problem**

We build:

```
dp[i] = number of ways to decode substring starting at i
```

👉 Final answer = `dp[0]`

This works because the problem has **overlapping subproblems** ([AlgoMonster][1])

---

# Intuition 🧠 (Baby Words)

Think like climbing stairs:

```
At each step:
→ take 1 step
→ OR take 2 steps
```

BUT:

* Step “0” is broken ❌
* Step “27+” doesn’t exist ❌

👉 Count all valid paths

---

# Strategy 🚀

1. Use DP array `dp[n+1]`
2. Base case:

   ```
   dp[n] = 1  // empty string
   ```
3. Traverse from right → left
4. For each index `i`:

    * If `s[i] != '0'` → add `dp[i+1]`
    * If valid 2-digit → add `dp[i+2]`
5. Return `dp[0]`

---

# Optimal Java Solution 💻

```java
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        dp[n] = 1; // empty string

        for (int i = n - 1; i >= 0; i--) {

            // Case 1: single digit
            if (s.charAt(i) != '0') {
                dp[i] = dp[i + 1];
            }

            // Case 2: two digits
            if (i + 1 < n) {
                int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');

                if (num >= 10 && num <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }
}
```

---

# Dry Run 🧪

### Input:

```
s = "226"
```

### DP Table:

| i | s[i] | dp[i] |
| - | ---- | ----- |
| 3 | -    | 1     |
| 2 | '6'  | 1     |
| 1 | '2'  | 2     |
| 0 | '2'  | 3     |

### Result:

```
3 ways
```

---

# Complexity ⏱️

| Type  | Value |
| ----- | ----- |
| Time  | O(n)  |
| Space | O(n)  |

👉 Can be optimized to O(1)

---

# Key Tricks 🎯

* `"0"` alone → invalid ❌
* `"10"` and `"20"` → valid ✔️
* Always check:

  ```
  1-digit valid?
  2-digit valid?
  ```
* Work **right → left**

---

# Pattern Recognition 🔍

👉 Classic:

```
1D Dynamic Programming
```

Similar to:

* Climbing Stairs
* Fibonacci pattern

---

# Summary 🧾

* Each index → 2 choices
* Use DP to avoid recomputation
* Handle zeros carefully
* Build from end → start

---

# Takeaway 🚀

👉 Whenever you see:

```
"Count number of ways"
```

Think:

```
DP + choices at each step
```

---

If you want next level 🚀
I can also give:

* Space optimized DP (O(1))
* Recursive + Memo version
* Visualization for interviews


https://neetcode.io/problems/decode-ways/question?list=neetcode150

https://leetcode.com/problems/decode-ways/description/
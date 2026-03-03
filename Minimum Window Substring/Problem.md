# 76. Minimum Window Substring

## 📌 Problem Statement

Given two strings `s` and `t`, return the **minimum window substring** of `s` such that **every character in `t` (including duplicates)** is included in the substring.  
If there is no such substring, return the empty string `""`. :contentReference[oaicite:0]{index=0}

The answer is **guaranteed to be unique** for the given test cases. :contentReference[oaicite:1]{index=1}

---

## 🧪 Examples

### Example 1
```
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: "BANC" is the smallest substring in s that contains all characters 'A', 'B', and 'C'. 
```
📌 Contains all characters of `t` with their required frequencies. :contentReference[oaicite:2]{index=2}

### Example 2
```
Input: s = "a", t = "a"
Output: "a"
Explanation: Entire string s is the answer.
```
📌 Only one character to match. :contentReference[oaicite:3]{index=3}

### Example 3
```
Input: s = "a", t = "aa"
Output: ""
Explanation: s does not contain two 'a's, so no valid window exists.
```
📌 Need to include duplicates correctly. :contentReference[oaicite:4]{index=4}

---

## 📏 Constraints

- `m == s.length`
- `n == t.length`
- `1 <= m, n <= 10^5`
- `s` and `t` consist of uppercase and lowercase English letters. :contentReference[oaicite:5]{index=5}

---

## 🧠 Intuition

You are asked to find **the shortest contiguous substring** of `s` that contains **all characters of `t` (including duplicates)**.  
This is a classic **variable-size sliding window** problem:

1. Expand the window to include enough characters to satisfy the condition.
2. Once valid, try shrinking to minimize the window.
3. Repeat until the end of `s` is reached. :contentReference[oaicite:6]{index=6}

---

## 🚀 Optimal Approach (Sliding Window + HashMap)

1. Use a hash map (or array) to store character counts for `t`.
2. Use two pointers `left` and `right` for the window on `s`.
3. Expand `right` until the window contains all characters from `t`.
4. Shrink `left` to remove extra characters while the window is still valid.
5. Track the minimum window length and indices.
6. Return the substring using the minimum indices found.

Time: **O(m + n)**  
Space: **O(k)** (k = number of unique characters) :contentReference[oaicite:7]{index=7}

---

## 💻 Java Solution

```java
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] targetCount = new int[128];
        for (char c : t.toCharArray()) {
            targetCount[c]++;
        }

        int required = t.length();
        int left = 0, minLen = Integer.MAX_VALUE, minStart = 0;

        for (int right = 0; right < s.length(); right++) {
            if (targetCount[s.charAt(right)] > 0) {
                required--;
            }
            targetCount[s.charAt(right)]--;

            while (required == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                targetCount[s.charAt(left)]++;
                if (targetCount[s.charAt(left)] > 0) {
                    required++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
```

---

## 🧠 How It Works

- We track how many characters of `t` are still needed in the window with `required`.
- We expand `right` until all required characters are covered.
- Then we contract from `left` to minimize the window while keeping it valid.
- We update the minimum window length whenever a valid window is found. :contentReference[oaicite:8]{index=8}

---

## 📌 Notes

- The order of characters in the window doesn’t need to match the order in `t`, only the frequencies matter. :contentReference[oaicite:9]{index=9}
- This is a **classic sliding window template** useful in many substring problems. :contentReference[oaicite:10]{index=10}

---

## 📊 Complexity

| Approach | Time | Space |
|----------|------|--------|
| Brute Force | O(m·n) | O(1) |
| Sliding Window (optimal) | **O(m + n)** | **O(1)** |

---

## 🧩 Additional Examples

```
s = "aaflslflsldkalskaaa", t = "aaa"
Output: "aaa"
Explanation: The smallest window with three 'a's is "aaa".
```
📌 Must count duplicates correctly. :contentReference[oaicite:11]{index=11}

---

## 🧠 Interview Tip

Whenever a question asks for a substring that **must contain something with minimum/maximum length**, think:

👉 **Sliding Window + frequency counts**  
(not brute force). :contentReference[oaicite:12]{index=12}

---

https://neetcode.io/problems/minimum-window-with-characters/question?list=neetcode150

https://leetcode.com/problems/minimum-window-substring/description/
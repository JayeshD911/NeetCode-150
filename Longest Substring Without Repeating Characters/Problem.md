# 🔐 3. Longest Substring Without Repeating Characters

## 📌 Problem Statement

Given a string `s`, find the **length of the longest substring** without repeating characters.

---

## 🧾 Examples

### Example 1
```
Input: s = "abcabcbb"
Output: 3
Explanation: The longest substring without repeating characters is "abc".
```

### Example 2
```
Input: s = "bbbbb"
Output: 1
Explanation: The longest substring without repeating characters is "b".
```

### Example 3
```
Input: s = "pwwkew"
Output: 3
Explanation: The longest substring without repeating characters is "wke".
```

---

## 🔒 Constraints

- `0 <= s.length <= 5 * 10^4`
- `s` consists of English letters, digits, symbols, and spaces.

---

# 🚀 Optimal Approach: Sliding Window + HashMap

## 💡 Key Insight

We want a dynamic window that:

- Expands when the next character is unique
- Shrinks when duplication occurs
- Tracks the **maximum window length**

We maintain:

- Two pointers: `left`, `right`
- A map from character → latest index

---

## 🧑‍💻 Java Code (Sliding Window)

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
```

---

## ⏱ Complexity

| Metric | Value |
|--------|-------|
| Time   | **O(n)** |
| Space  | **O(min(n, charset))** |

- Each character is visited once
- Map keeps latest indices

---

# 🧠 Sliding Window Intuition

```
String: "abcabcbb"
         ↑
         left
             ↑
             right
Window expands until duplicate → then shrink left
Track max window size at each step
```

---

# 📚 Step-by-Step Dry Run

```
Input: "abba"

right=0 → 'a'
map = {a:0}
maxLen = 1

right=1 → 'b'
map = {a:0, b:1}
maxLen = 2

right=2 → 'b' (duplicate)
map.get('b') = 1 → left = max(0, 1+1) = 2
map = {a:0, b:2}
maxLen still 2

right=3 → 'a'
map contains 'a'
map.get('a') = 0 → left = max(2, 0+1) = 2
map = {a:3, b:2}
window size = 2 (from 2 to 3)
```

Final answer = 2

---

# 🧠 Why We Use `Math.max(left, map.get(c)+1)`

We ensure that:

- The `left` pointer never moves backward
- We only shrink the window forward
- Duplicate detection moves left only when necessary

---

## 🧠 Key Pattern

This problem is a classic:

**Sliding Window + Hash Map / Index Tracking**

It reappears in:

- Longest Substring with at Most K Distinct Characters
- Minimum Window Substring
- Subarrays with K Unique Elements

---

# 📅 Daily LeetCode Log

- Topic: Strings / Sliding Window
- Difficulty: Medium
- Language: Java

---


https://neetcode.io/problems/longest-substring-without-duplicates/question

https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
# 🔠 424. Longest Repeating Character Replacement

## 📌 Problem Statement

Given a string `s` consisting of uppercase English letters, you can replace up to `k` characters with any uppercase letters.

Find the **length of the longest substring** containing the same letter you can get after performing **at most `k` replacements**.

---

## 🧾 Examples

### Example 1
```
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace two ‘A’s with ‘B’s → "BBBB" or two ‘B’s with ‘A’s → "AAAA"
```

### Example 2
```
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one ‘A’ in "BAAA" or one ‘B’ in "AABB"
```

---

## 🔒 Constraints

- `1 <= s.length <= 10^5`
- `s` consists only of **uppercase English letters** (`A–Z`)
- `0 <= k <= s.length`

---

# 🚀 Optimal Approach: Sliding Window + Frequency Count

## 💡 Key Insight

Within any window, if you know:

- `window length` = `right - left + 1`
- `max count of a single character` = `maxFreq`

Then the number of replacements needed to make the whole window the same character is:

```
replacements = windowLength - maxFreq
```

If replacements ≤ `k`, window is valid.  
Otherwise, shrink from the left.

---

## 🧠 Algorithm

1. Expand the window (`right`)
2. Track frequency of characters
3. Maintain the count of the most frequent character in the window
4. If window needs more replacements than `k`, shrink it from the left
5. Track maximum window length

---

## 🧑‍💻 Java Code

```java
class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];
        int maxFreq = 0;
        int left = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            maxFreq = Math.max(maxFreq, ++freq[c - 'A']);

            // if window needs more than k replacements
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
```

---

## ⏱ Complexity

| Metric | Value |
|--------|-------|
| Time   | **O(n)** |
| Space  | **O(26)** → constant |

This runs in linear time with small fixed extra space.

---

# 📚 Detailed Explanation

We keep a sliding window that represents the current substring.

In each iteration:

- We update the count of the current character
- We update `maxFreq` = the frequency of the most common character in the current window
- We check if we need more than `k` replacements:
  ```
  windowLength - maxFreq > k
  ```
  → If yes, shrink window
- Otherwise update answer with current window size

---

## 🧠 Why This Works

The idea is:

- Within a window, to make all characters the same, you must replace every character **except** the most frequent one.
- `windowSize - maxFreq` = number of characters that must be replaced.
- We only allow up to `k` replacements.

This pattern is extremely common in substring problems.

---

# 🧠 Example Walkthrough

```
Input: s = "AABABBA", k = 1
```

Window variations and counts:

| Window | maxFreq | replacements | Valid? |
|--------|----------|--------------|---------|
| "A" | 1 | 0 | Yes |
| "AA" | 2 | 0 | Yes |
| "AAB" | 2 | 1 | Yes |
| "AABA" | 3 | 1 | Yes |
| "AABAB" | 3 | 2 | ❌ |
| (Shrink window) |
| "ABAB" | 2 | 2 | ❌ |
| (Continue shrink) |
| "BABB" | 3 | 1 | Yes → length 4 |

Final answer = 4

---

# 📅 Daily LeetCode Log

- Topic: Sliding Window + Frequency Count
- Difficulty: Medium
- Language: Java

---

https://neetcode.io/problems/longest-repeating-substring-with-replacement/question

https://leetcode.com/problems/longest-repeating-character-replacement/
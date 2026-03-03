# 567. Permutation in String

## 📝 Problem Statement

Given two strings `s1` and `s2`, return `true` if `s2` contains a permutation of `s1`, or `false` otherwise.

In other words, return `true` if one of `s1`’s permutations exists as a **substring** of `s2`.

A permutation is a rearrangement of all the characters of a string.

---

## 📌 Examples

### Example 1
```
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains "ba", which is a permutation of "ab".
```

### Example 2
```
Input: s1 = "ab", s2 = "eidboaoo"
Output: false
```

---

## 📏 Constraints

- `1 <= s1.length, s2.length <= 10^4`
- `s1` and `s2` consist of lowercase English letters only.

---

# 🚀 Optimal Approach — Sliding Window + Frequency Array

## 🧠 Intuition

Instead of generating all permutations of `s1` (which is factorial time ❌), we:

1. Count character frequencies of `s1`
2. Use a sliding window of size `len(s1)` over `s2`
3. Compare frequency counts

If at any point the window frequencies match `s1` frequencies → permutation exists.

Since only lowercase letters are used, we use a fixed array of size 26.

---

# 🔥 Algorithm

1. If `len(s1) > len(s2)` → return `false`
2. Create two frequency arrays of size 26:
    - `freq1` for `s1`
    - `freq2` for sliding window in `s2`
3. Fill both for first `len(s1)` characters
4. Slide the window:
    - Add new character
    - Remove left character
    - Compare arrays
5. If match found → return `true`
6. If no match → return `false`

---

# 💻 Java Solution (Optimal)

```java
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Build frequency for first window
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        // Check initial window
        if (matches(freq1, freq2)) return true;

        // Slide window
        for (int i = s1.length(); i < s2.length(); i++) {

            // Add new character
            freq2[s2.charAt(i) - 'a']++;

            // Remove left character
            freq2[s2.charAt(i - s1.length()) - 'a']--;

            if (matches(freq1, freq2)) return true;
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
```

---

# 🧪 Dry Run

### Input:
```
s1 = "ab"
s2 = "eidbaooo"
```

Window size = 2

Step-by-step:

```
Window "ei" → no
Window "id" → no
Window "db" → no
Window "ba" → MATCH ✅
```

Return `true`

---

# ⏱ Complexity Analysis

### Time Complexity
```
O(n)
```
We traverse `s2` once.

### Space Complexity
```
O(1)
```
Only 26-length arrays used.

---

# 🧠 Why This Is Optimal

- No sorting
- No generating permutations
- Single pass sliding window
- Constant space

This is a classic **fixed-size sliding window + frequency count** problem.

---

# 🏆 Key Pattern

This problem belongs to:

✔ Sliding Window  
✔ String Frequency Counting  
✔ Anagram Detection

---

# 🎯 Interview Tip

Whenever you see:

- "Permutation"
- "Anagram"
- "Substring"
- Lowercase letters only

Think immediately:

> Frequency Array + Sliding Window

---

# 🚀 Summary

| Approach | Time | Space | Recommended |
|----------|------|-------|-------------|
| Generate permutations | O(n!) | High | ❌ |
| Sort every window | O(n log n) | Medium | ❌ |
| Sliding window + freq | O(n) | O(1) | ✅ |

---

https://neetcode.io/problems/permutation-string/question?list=neetcode150

https://leetcode.com/problems/permutation-in-string/description/
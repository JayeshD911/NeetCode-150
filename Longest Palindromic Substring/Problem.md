# 5. Longest Palindromic Substring

🔗 Problem: https://leetcode.com/problems/longest-palindromic-substring/

---

# Problem

Given a string `s`, return the **longest palindromic substring** in `s`.

A palindrome is a string that reads the same forward and backward.

Example:

```
"aba" → palindrome
"abba" → palindrome
"abc" → not palindrome
```

---

# Example

### Example 1

Input
```
s = "babad"
```

Output
```
"bab"
```

Explanation

```
"bab" is a palindrome.
"aba" is also a valid answer.
```

Both have length:

```
3
```

So either answer is accepted.

---

### Example 2

Input
```
s = "cbbd"
```

Output
```
"bb"
```

Explanation

```
"bb" is the longest palindrome substring.
```

---

# Key Idea

A palindrome expands around its center.

There are two possible types of centers:

```
1️⃣ Odd length palindrome
   center = one character

2️⃣ Even length palindrome
   center = gap between two characters
```

Example:

```
"aba"  → center is 'b'
"abba" → center is between 'b' and 'b'
```

So for every index, we check both possibilities.

---

# Intuition

Instead of checking every substring, we expand from the middle.

For each character:

```
treat it as center
expand left and right while characters match
```

Example:

```
s = "babad"
```

At center `a`:

```
b a b
```

Expand:

```
left = b
right = b
```

They match, so:

```
"bab"
```

is a palindrome.

---

# Strategy

Steps:

```
1️⃣ Initialize result string as ""

2️⃣ For each index i:
      check odd palindrome centered at i
      check even palindrome centered at i and i+1

3️⃣ Expand while:
      left >= 0
      right < s.length()
      s.charAt(left) == s.charAt(right)

4️⃣ Update result if current palindrome is longer

5️⃣ Return result
```

---

# Optimal Java Solution

```java
class Solution {
    public String longestPalindrome(String s) {

        String result = "";

        for(int i = 0; i < s.length(); i++){

            String odd = expandFromCenter(s, i, i);

            if(odd.length() > result.length()){
                result = odd;
            }

            String even = expandFromCenter(s, i, i + 1);

            if(even.length() > result.length()){
                result = even;
            }
        }

        return result;
    }

    public String expandFromCenter(String s, int left, int right){

        while(left >= 0 &&
              right < s.length() &&
              s.charAt(left) == s.charAt(right)){

            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}
```

---

# Dry Run

Input

```
s = "babad"
```

Steps

```
i = 0
Odd center = "b"
result = "b"
```

```
i = 1
Odd center around 'a'

Expand:
left = 0 → 'b'
right = 2 → 'b'

They match → palindrome = "bab"

result = "bab"
```

```
i = 2
Odd center around 'b'

Expand:
left = 1 → 'a'
right = 3 → 'a'

They match → palindrome = "aba"

"aba" length = 3
result already length = 3
```

Final result:

```
"bab"
```

Note:

```
"aba" is also valid
```

---

# Complexity Analysis

### Time Complexity

```
O(n²)
```

For each index, we may expand across the string.

---

### Space Complexity

```
O(1)
```

Ignoring the output string.

---

# Key Tricks

### 1️⃣ Expand around center

```
Palindrome grows outward from middle
```

---

### 2️⃣ Check both odd and even lengths

```
(i, i)     → odd palindrome
(i, i + 1) → even palindrome
```

---

### 3️⃣ Return after over-expansion

When loop stops, `left` and `right` are one step too far.

So valid substring is:

```
s.substring(left + 1, right)
```

---

# Pattern Recognition

This problem belongs to:

```
String + Two Pointers + Expand Around Center Pattern
```

Similar problems:

```
Palindromic Substrings
Valid Palindrome
Longest Palindromic Subsequence
```

---

# Summary

Core idea:

```
Every palindrome has a center
Expand around every possible center
Track the longest palindrome found
```

Final complexity:

```
Time  : O(n²)
Space : O(1)
```

---

# Takeaway

Whenever you see:

```
longest palindromic substring
count palindromic substrings
palindrome inside string
```

Think immediately:

```
Expand Around Center
```

Because:

```
A palindrome is defined by matching characters outward from the center
```
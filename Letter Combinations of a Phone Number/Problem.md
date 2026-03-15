# 17. Letter Combinations of a Phone Number

🔗 Problem: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

---

# Problem

Given a string containing digits from **2–9 inclusive**, return **all possible letter combinations** that the number could represent.

The mapping is the same as on a **telephone keypad**.

Example mapping:

```
2 → abc
3 → def
4 → ghi
5 → jkl
6 → mno
7 → pqrs
8 → tuv
9 → wxyz
```

Return the combinations in **any order**. :contentReference[oaicite:1]{index=1}

---

# Example

### Example 1

Input

```
digits = "23"
```

Output

```
["ad","ae","af","bd","be","bf","cd","ce","cf"]
```

Explanation

```
2 → abc
3 → def
```

Combine each letter from `2` with each letter from `3`.

---

### Example 2

Input

```
digits = ""
```

Output

```
[]
```

---

# Key Idea

This is a **Backtracking / DFS combination problem**.

At each digit we choose one of its mapped letters and move to the next digit.

Example:

```
digits = "23"

2 → abc
3 → def
```

Recursion tree:

```
[]
├─ a
│  ├─ ad
│  ├─ ae
│  └─ af
├─ b
│  ├─ bd
│  ├─ be
│  └─ bf
└─ c
   ├─ cd
   ├─ ce
   └─ cf
```

We build combinations **character by character**.

---

# Backtracking Strategy

Steps:

```
1. Map digits → letters
2. Start from index = 0
3. For each letter of current digit
4. Add the letter
5. Recurse to next digit
6. Backtrack (remove letter)
```

---

# Java Solution (Backtracking)

```java
class Solution {

    String[] map = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public void solve(String digits,
                      int index,
                      StringBuilder temp,
                      List<String> ans){

        if(index == digits.length()){
            ans.add(temp.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for(char c : letters.toCharArray()){

            temp.append(c);

            solve(digits, index + 1, temp, ans);

            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if(digits.length() == 0)
            return ans;

        solve(digits, 0, new StringBuilder(), ans);

        return ans;
    }
}
```

---

# Dry Run

Input

```
digits = "23"
```

Steps

```
index = 0 → digit = 2 → abc

a
 ├─ ad
 ├─ ae
 └─ af

b
 ├─ bd
 ├─ be
 └─ bf

c
 ├─ cd
 ├─ ce
 └─ cf
```

Output

```
["ad","ae","af","bd","be","bf","cd","ce","cf"]
```

---

# Complexity Analysis

### Time Complexity

```
O(4^n)
```

Each digit maps to at most **4 letters**, so total combinations can be up to `4^n`. :contentReference[oaicite:2]{index=2}

If we include string construction cost:

```
O(n × 4^n)
```

---

### Space Complexity

```
O(n)
```

For recursion stack depth (excluding result storage).

---

# Key Insights

Important ideas:

```
Map digits to characters
Generate combinations recursively
Backtrack after exploring each branch
```

---

# Pattern Recognition

This problem belongs to the **Backtracking / Combination generation** pattern.

Similar problems:

```
Subsets
Permutations
Combination Sum
Generate Parentheses
Palindrome Partitioning
```

---

# Summary

Core idea:

```
Pick a letter for each digit
Recurse to build full string
Backtrack to explore other possibilities
```

---

# Takeaway

Whenever a problem asks for:

```
all possible combinations
mapping of digits → letters
generate sequences
```

Think immediately:

```
Backtracking
```
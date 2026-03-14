# 22. Generate Parentheses

🔗 Problem: https://leetcode.com/problems/generate-parentheses/

---

# Problem

Given `n` pairs of parentheses, generate **all combinations of well-formed parentheses**. :contentReference[oaicite:0]{index=0}

A parentheses string is **valid** if:

```
Every '(' has a matching ')'
At no point do closing parentheses exceed opening ones
```

Example of valid parentheses:

```
(())
()()
(()())
```

Example of invalid parentheses:

```
)(()
())(
```

---

# Example

### Example 1

Input

```
n = 3
```

Output

```
["((()))","(()())","(())()","()(())","()()()"]
```

---

### Example 2

Input

```
n = 1
```

Output

```
["()"]
```

---

# Key Idea

This is a **Backtracking problem**.

We build the string step-by-step while maintaining two counts:

```
open  → number of '(' used
close → number of ')' used
```

Rules:

```
1️⃣ open < n        → we can add '('
2️⃣ close < open    → we can add ')'
```

The second rule ensures the parentheses **never become invalid**. :contentReference[oaicite:1]{index=1}

---

# Intuition

For `n = 3`, we build the sequence recursively.

Recursion tree:

```
""
├── "("
│   ├── "(("
│   │   ├── "((("
│   │   │   └── "((()))"
│   │   └── "(()"
│   │       └── "(()())"
│   └── "()"
│       ├── "()(("
│       │   └── "()(())"
│       └── "()()"
│           └── "()()()"
```

We stop when the string length becomes:

```
2 * n
```

because every pair has two characters.

---

# Backtracking Strategy

At every step we decide:

```
1️⃣ Add '(' if open < n
2️⃣ Add ')' if close < open
```

Steps:

```
choose '(' or ')'
recurse
backtrack
```

---

# Java Solution (Backtracking)

```java
class Solution {

    public void solve(int n,
                      int open,
                      int close,
                      StringBuilder temp,
                      List<String> ans){

        if(temp.length() == 2 * n){
            ans.add(temp.toString());
            return;
        }

        // add '('
        if(open < n){
            temp.append('(');
            solve(n, open + 1, close, temp, ans);
            temp.deleteCharAt(temp.length() - 1);
        }

        // add ')'
        if(close < open){
            temp.append(')');
            solve(n, open, close + 1, temp, ans);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        solve(n, 0, 0, new StringBuilder(), ans);

        return ans;
    }
}
```

---

# Dry Run

Input

```
n = 2
```

Steps

```
""
├── "("
│   ├── "(("
│   │   └── "(())"
│   └── "()"
│       └── "()()"
```

Output

```
["(())","()()"]
```

---

# Complexity Analysis

### Time Complexity

The number of valid parentheses combinations equals the **nth Catalan number**, approximately:

```
O(4^n / √n)
```

because the algorithm explores valid backtracking paths. :contentReference[oaicite:2]{index=2}

---

### Space Complexity

```
O(n)
```

for recursion stack and building the string.

---

# Key Insight

The critical constraint:

```
close ≤ open
```

ensures we **never generate invalid parentheses**, which prunes many branches early.

---

# Pattern Recognition

This problem belongs to the **Backtracking / Recursion pattern**.

Similar problems:

```
Subsets
Permutations
Combination Sum
N Queens
Letter Combinations of Phone Number
```

---

# Summary

Core ideas:

```
Build parentheses step-by-step
Track number of open and close parentheses
Only add ')' when valid
Use backtracking to explore all possibilities
```

Final complexity:

```
Time  ≈ O(4^n / √n)
Space = O(n)
```

---

# Takeaway

Whenever a problem asks for:

```
generate all valid sequences
balanced parentheses
all possible combinations with constraints
```

Think immediately:

```
Backtracking
```


https://neetcode.io/problems/generate-parentheses/question?list=neetcode150

https://leetcode.com/problems/generate-parentheses/description/
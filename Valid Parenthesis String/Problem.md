# 678. Valid Parenthesis String

🔗 Problem: https://leetcode.com/problems/valid-parenthesis-string/

---

# Problem

You are given a string `s` containing only:

```
'(' , ')' , '*'
```

Return:

```
true  → if the string is valid
false → otherwise
```

Rules for validity:

```
1. Every '(' must have a matching ')'
2. Every ')' must have a matching '('
3. '(' must come before ')'
4. '*' can be:
      '(' OR ')' OR empty string ""
``` 
:contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input
```
s = "()"
```

Output
```
true
```

---

### Example 2

Input
```
s = "(*)"
```

Output
```
true
```

Explanation

```
* can be treated as empty
→ "()"
```

---

### Example 3

Input
```
s = "(*))"
```

Output
```
true
```

Explanation

```
* can act as '('
→ "(())"
```

---

### Example 4

Input
```
s = "(*("
```

Output
```
false
```

Explanation

```
Unmatched '(' remains
```

---

# Key Idea

The tricky part:

```
'*' has 3 possibilities
```

Instead of trying all combinations (exponential), we use:

```
Greedy range tracking
```

We maintain:

```
low  → minimum possible open brackets
high → maximum possible open brackets
``` 
:contentReference[oaicite:1]{index=1}

---

# Intuition

At every character:

```
We track a RANGE of possible open parentheses
```

Example:

```
s = "*("
```

At `*`:

```
low = -1 → treat as ')'
high = +1 → treat as '('
```

So range:

```
[0,1]   (we clamp low to 0)
```

This means:

```
We might have 0 OR 1 open brackets
```

We don't commit — we keep possibilities.

---

# Strategy (Greedy Range)

Steps:

```
1️⃣ Initialize:
      low = 0
      high = 0

2️⃣ Traverse string

3️⃣ For each character:

   if '(':
        low++
        high++

   if ')':
        low--
        high--

   if '*':
        low--     (treat as ')')
        high++    (treat as '(')

4️⃣ If high < 0:
      return false

5️⃣ Clamp low:
      low = max(low, 0)

6️⃣ At end:
      return low == 0
```

---

# Optimal Java Solution

```java
class Solution {
    public boolean checkValidString(String s) {

        int low = 0;
        int high = 0;

        for(char c : s.toCharArray()){

            if(c == '('){
                low++;
                high++;
            }
            else if(c == ')'){
                low--;
                high--;
            }
            else{ // '*'
                low--;
                high++;
            }

            if(high < 0){
                return false;
            }

            if(low < 0){
                low = 0;
            }
        }

        return low == 0;
    }
}
```

---

# Dry Run

Input

```
s = "(*))"
```

Steps

```
c = '(' → low=1, high=1

c = '*' → low=0, high=2

c = ')' → low=-1 → 0, high=1

c = ')' → low=-1 → 0, high=0
```

Final:

```
low = 0 → valid
```

Return

```
true
```

---

# Complexity Analysis

### Time Complexity

```
O(n)
```

Single pass through string. :contentReference[oaicite:2]{index=2}

---

### Space Complexity

```
O(1)
```

Only variables used.

---

# Key Tricks

### 1️⃣ Track range instead of exact count

```
low  → minimum possible '('
high → maximum possible '('
```

---

### 2️⃣ Handle '*' flexibly

```
low--  (treat as ')')
high++ (treat as '(')
```

---

### 3️⃣ Early invalid check

```
if(high < 0) → too many ')'
```

---

### 4️⃣ Clamp low

```
low = max(low, 0)
```

Because we cannot have negative open brackets.

---

# Pattern Recognition

This problem belongs to:

```
Greedy + Range Tracking Pattern
```

Similar problems:

```
Valid Parentheses
Minimum Remove to Make Valid Parentheses
Jump Game (range thinking)
```

---

# Summary

Core idea:

```
Track range of possible open brackets
Update range based on character
Fail early if invalid
Ensure final range includes 0
```

---

# Takeaway

Whenever you see:

```
wildcards + multiple possibilities
valid parentheses with flexibility
```

Think immediately:

```
Greedy Range (low, high)
```

Because:

```
You don't need all possibilities — just valid bounds
```



https://neetcode.io/problems/valid-parenthesis-string/question?list=neetcode150

https://leetcode.com/problems/valid-parenthesis-string/
# 131. Palindrome Partitioning

🔗 Problem: https://leetcode.com/problems/palindrome-partitioning/

---

# Problem

Given a string `s`, partition `s` such that **every substring of the partition is a palindrome**.

Return **all possible palindrome partitionings** of `s`. :contentReference[oaicite:0]{index=0}

A palindrome is a string that reads the same **forward and backward**.

---

# Example

### Example 1

Input

```
s = "aab"
```

Output

```
[
 ["a","a","b"],
 ["aa","b"]
]
```

Explanation

```
"a"  → palindrome
"a"  → palindrome
"b"  → palindrome

"aa" → palindrome
"b"  → palindrome
```

---

### Example 2

Input

```
s = "a"
```

Output

```
[["a"]]
```

---

# Key Idea

This is a **Backtracking problem**.

At each index we decide:

```
Where should we cut the string next?
```

We try all possible substrings starting from the current index.

If a substring is a **palindrome**, we:

```
add it to the partition
recursively process the remaining string
backtrack
```

Backtracking systematically explores all valid partitions. :contentReference[oaicite:1]{index=1}

---

# Intuition

Example

```
s = "aab"
```

Possible substring choices:

```
a | a | b
aa | b
```

Recursion tree:

```
[]
├── "a"
│   ├── "a"
│   │   └── "b"
│   │       → ["a","a","b"]
│
└── "aa"
    └── "b"
        → ["aa","b"]
```

---

# Backtracking Strategy

Steps:

```
1️⃣ Start from index = 0
2️⃣ Try every substring starting at index
3️⃣ Check if substring is palindrome
4️⃣ If yes → add to current partition
5️⃣ Recursively explore remaining string
6️⃣ Backtrack (remove substring)
```

---

# Java Solution

```java
class Solution {

    public void solve(String s,
                      int start,
                      List<String> temp,
                      List<List<String>> ans){

        if(start == s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int end = start; end < s.length(); end++){

            if(isPalindrome(s, start, end)){

                temp.add(s.substring(start, end + 1));

                solve(s, end + 1, temp, ans);

                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int left, int right){

        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();

        solve(s, 0, new ArrayList<>(), ans);

        return ans;
    }
}
```

---

# Dry Run

Input

```
s = "aab"
```

Steps

```
start = 0

"a" → palindrome
partition = ["a"]

start = 1

"a" → palindrome
partition = ["a","a"]

start = 2

"b" → palindrome
partition = ["a","a","b"]

✔ add result
```

Backtrack

```
partition = ["a"]

"ab" → not palindrome
```

Try:

```
"aa" → palindrome
partition = ["aa"]
```

Then

```
"b"
```

Result

```
["aa","b"]
```

Final Output

```
[["a","a","b"],["aa","b"]]
```

---

# Complexity Analysis

### Time Complexity

```
O(2^n × n)
```

Because:

```
2^(n-1) possible partitions
checking palindrome takes O(n)
```

Worst case occurs when **every substring is a palindrome** (like `"aaaa"`). :contentReference[oaicite:2]{index=2}

---

### Space Complexity

```
O(n)
```

Used for recursion stack and temporary partition.

---

# Key Insights

Important tricks:

```
Only explore palindrome substrings
Use backtracking to try all partition points
Restore state after recursion
```

---

# Pattern Recognition

This belongs to the **Backtracking / Partitioning pattern**.

Similar problems:

```
Generate Parentheses
Word Search
Combination Sum
N Queens
Subsets
```

---

# Summary

Core idea:

```
Choose substring
Check palindrome
Recurse on remaining string
Backtrack
```

This systematically explores **all valid palindrome partitions** of the string.

---

# Takeaway

Whenever a problem asks for:

```
all ways to split
all valid partitions
all segmentations
```

Think immediately:

```
Backtracking on partition points
```


https://neetcode.io/problems/palindrome-partitioning/question?list=neetcode150

https://leetcode.com/problems/palindrome-partitioning/description/
# 763. Partition Labels

🔗 Problem: https://leetcode.com/problems/partition-labels/

---

# Problem

You are given a string `s`.

You want to partition the string into as many parts as possible such that:

```
Each letter appears in at most one part
```

Return a list of integers representing the **size of these parts**.

The partitions must:

```
Maintain original order
Concatenate back to the original string
``` 
:contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input
```
s = "ababcbacadefegdehijhklij"
```

Output
```
[9,7,8]
```

Explanation

```
Partition 1 → "ababcbaca" → size = 9
Partition 2 → "defegde"   → size = 7
Partition 3 → "hijhklij"  → size = 8
```

Each character appears in only one partition.

---

### Example 2

Input
```
s = "eccbbbbdec"
```

Output
```
[10]
```

Explanation

```
All characters overlap → entire string is one partition
```

---

# Key Idea

The most important observation:

```
Each character must stay within one partition
```

So:

```
We must include ALL occurrences of a character in the same partition
```

👉 This means:

```
Partition must extend to the LAST occurrence of every character inside it
``` 
:contentReference[oaicite:1]{index=1}

---

# Intuition

Example:

```
s = "ababcbaca"
```

Last occurrences:

```
a → 8
b → 5
c → 7
```

While scanning:

```
We keep extending partition to the farthest last occurrence
```

When we reach that boundary:

```
We can safely cut the partition
```

---

# Strategy (Greedy)

Steps:

```
1️⃣ Create array/map to store last occurrence of each character

2️⃣ Initialize:
      start = 0
      end = 0

3️⃣ Traverse string:

      end = max(end, lastIndex[s[i]])

4️⃣ If i == end:
      partition complete
      add size = end - start + 1
      update start = i + 1
```

---

# Optimal Java Solution

```java
class Solution {
    public List<Integer> partitionLabels(String s) {

        int[] last = new int[26];

        for(int i = 0; i < s.length(); i++){
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();

        int start = 0;
        int end = 0;

        for(int i = 0; i < s.length(); i++){

            end = Math.max(end, last[s.charAt(i) - 'a']);

            if(i == end){
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}
```

---

# Dry Run

Input

```
s = "ababcbacadefegdehijhklij"
```

Steps

```
i = 0 → end = 8
i = 1 → end = 8
...
i = 8 → i == end → partition size = 9
```

Next:

```
start = 9
i = 9 → end = 15
...
i = 15 → partition size = 7
```

Next:

```
start = 16
i = 16 → end = 23
...
i = 23 → partition size = 8
```

Result

```
[9,7,8]
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

Fixed array of size 26.

---

# Key Tricks

### 1️⃣ Track last occurrence

```
last[c] = last index of character c
```

---

### 2️⃣ Expand partition greedily

```
end = max(end, last[c])
```

---

### 3️⃣ Cut partition only when safe

```
if(i == end)
```

---

# Pattern Recognition

This problem belongs to:

```
Greedy + Interval Expansion Pattern
```

Similar problems:

```
Merge Intervals
Jump Game
Task Scheduler
```

---

# Summary

Core idea:

```
Find last occurrence of each character
Expand partition to farthest last index
Cut partition when boundary reached
```

---

# Takeaway

Whenever you see:

```
partition string
characters must not overlap across parts
maximize partitions
```

Think immediately:

```
Greedy + Last Occurrence Tracking
```

Because:

```
You must include all occurrences of a character before cutting
```

https://neetcode.io/problems/partition-labels/question?list=neetcode150

https://leetcode.com/problems/partition-labels/
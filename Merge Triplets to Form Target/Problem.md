# 1899. Merge Triplets to Form Target Triplet

🔗 Problem: https://leetcode.com/problems/merge-triplets-to-form-target-triplet/

---

# Problem

You are given a 2D array:

```
triplets[i] = [ai, bi, ci]
```

and a target triplet:

```
target = [x, y, z]
```

You can perform the following operation any number of times:

```
Pick two triplets i and j
Update triplets[j] = [
    max(ai, aj),
    max(bi, bj),
    max(ci, cj)
]
``` 
:contentReference[oaicite:0]{index=0}

Return:

```
true  → if you can obtain target
false → otherwise
```

---

# Example

### Example 1

Input
```
triplets = [[2,5,3],[1,8,4],[1,7,5]]
target = [2,7,5]
```

Output
```
true
```

Explanation

```
Pick [2,5,3] and [1,7,5]

Merge:
[max(2,1), max(5,7), max(3,5)]
→ [2,7,5]
```

Target achieved.

---

### Example 2

Input
```
triplets = [[3,4,5],[4,5,6]]
target = [3,2,5]
```

Output
```
false
```

Explanation

```
No triplet has value 2 at second position
→ impossible
```

---

# Key Idea

Critical observation:

```
Merging always takes maximum → values only increase
```

So:

```
We must NEVER exceed target at any index
```

👉 If any triplet has:

```
triplet[i] > target[i]
```

it is useless and must be ignored. :contentReference[oaicite:1]{index=1}

---

# Intuition

We don't need to simulate merging.

Instead, think:

```
Can we build target using valid triplets?
```

We need to check:

```
Is there at least one triplet that contributes each target value?
```

For example:

```
target = [2,7,5]
```

We need:

```
some triplet with 2 at index 0
some triplet with 7 at index 1
some triplet with 5 at index 2
```

AND:

```
all values ≤ target
```

---

# Strategy (Greedy)

Steps:

```
1️⃣ Initialize 3 booleans:
      foundX, foundY, foundZ

2️⃣ Iterate through all triplets

3️⃣ Skip invalid triplets:
      if any value > target → ignore

4️⃣ For valid triplets:
      if triplet[0] == target[0] → foundX = true
      if triplet[1] == target[1] → foundY = true
      if triplet[2] == target[2] → foundZ = true

5️⃣ Return:
      foundX && foundY && foundZ
```

---

# Optimal Java Solution

```java
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        boolean foundX = false;
        boolean foundY = false;
        boolean foundZ = false;

        for(int[] t : triplets){

            // skip invalid triplets
            if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2]){
                continue;
            }

            if(t[0] == target[0]) foundX = true;
            if(t[1] == target[1]) foundY = true;
            if(t[2] == target[2]) foundZ = true;
        }

        return foundX && foundY && foundZ;
    }
}
```

---

# Dry Run

Input

```
triplets = [[2,5,3],[1,8,4],[1,7,5]]
target = [2,7,5]
```

Steps

```
[2,5,3] → valid → matches x → foundX = true

[1,8,4] → invalid (8 > 7) → skip

[1,7,5] → valid → matches y and z
           foundY = true
           foundZ = true
```

Final

```
foundX = true
foundY = true
foundZ = true
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

Single pass through triplets. :contentReference[oaicite:2]{index=2}

---

### Space Complexity

```
O(1)
```

Only 3 boolean variables used.

---

# Key Tricks

### 1️⃣ Ignore invalid triplets

```
if any value > target → skip
```

---

### 2️⃣ No need to simulate merging

```
Just check coverage of each index
```

---

### 3️⃣ Track matches independently

```
x, y, z separately
```

---

# Pattern Recognition

This problem belongs to:

```
Greedy + Filtering Pattern
```

Similar problems:

```
Hand of Straights
Gas Station
Task Scheduler
```

---

# Summary

Core idea:

```
Ignore triplets exceeding target
Check if each target index can be matched
Return true only if all matched
```

---

# Takeaway

Whenever you see:

```
merge with max operation
values only increase
target formation
```

Think immediately:

```
Greedy + Filter invalid elements + Track coverage
```

Because:

```
You don't need to simulate — just verify possibility
```

https://neetcode.io/problems/merge-triplets-to-form-target/question?list=neetcode150

https://leetcode.com/problems/merge-triplets-to-form-target-triplet/description/
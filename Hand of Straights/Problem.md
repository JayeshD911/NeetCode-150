# 846. Hand of Straights

🔗 Problem: https://leetcode.com/problems/hand-of-straights/

---

# Problem

You are given an array `hand` where:

```
hand[i] = value of the ith card
```

and an integer `groupSize`.

Return:

```
true  → if you can rearrange the cards into groups of size groupSize
false → otherwise
```

Each group must:

```
1. Have exactly groupSize cards
2. Contain consecutive numbers
```

All cards must be used exactly once. :contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input
```
hand = [1,2,3,6,2,3,4,7,8]
groupSize = 3
```

Output
```
true
```

Explanation

```
Possible groups:
[1,2,3], [2,3,4], [6,7,8]
```

All groups are:

```
size = 3
consecutive numbers
```

---

### Example 2

Input
```
hand = [1,2,3,4,5]
groupSize = 4
```

Output
```
false
```

Explanation

```
Total cards = 5
Cannot divide into groups of size 4
```

---

# Key Idea

Two important observations:

### 1️⃣ Feasibility check

```
If hand.length % groupSize != 0 → return false
```

Because we must use all cards. :contentReference[oaicite:1]{index=1}

---

### 2️⃣ Greedy strategy

```
Always start forming groups from the smallest available card
```

Why?

```
Smallest card must be the start of a group
```

Otherwise it cannot be placed anywhere. :contentReference[oaicite:2]{index=2}

---

# Intuition

Example:

```
hand = [1,2,2,3,3,4]
groupSize = 3
```

Sorted:

```
[1,2,2,3,3,4]
```

Start from smallest:

```
Group 1 → [1,2,3]
Group 2 → [2,3,4]
```

At each step:

```
Pick smallest available number
Try forming consecutive group
```

---

# Strategy (Greedy + HashMap)

Steps:

```
1️⃣ If n % groupSize != 0 → return false

2️⃣ Count frequency using HashMap

3️⃣ Sort the hand

4️⃣ For each number:
      if count[num] > 0:
          try to build group:
              num → num+groupSize-1

5️⃣ If any number missing → return false
```

---

# Optimal Java Solution

```java
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length % groupSize != 0){
            return false;
        }

        Map<Integer, Integer> count = new HashMap<>();

        for(int num : hand){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(hand);

        for(int num : hand){

            if(count.get(num) == 0) continue;

            for(int i = 0; i < groupSize; i++){

                int curr = num + i;

                if(count.getOrDefault(curr, 0) == 0){
                    return false;
                }

                count.put(curr, count.get(curr) - 1);
            }
        }

        return true;
    }
}
```

---

# Dry Run

Input

```
hand = [1,2,3,6,2,3,4,7,8]
groupSize = 3
```

Sorted

```
[1,2,2,3,3,4,6,7,8]
```

Steps

```
Start at 1 → form [1,2,3]
Counts updated

Next unused → 2 → form [2,3,4]

Next unused → 6 → form [6,7,8]
```

All cards used successfully

```
Return true
```

---

# Complexity Analysis

### Time Complexity

```
O(n log n)
```

Sorting dominates. :contentReference[oaicite:3]{index=3}

---

### Space Complexity

```
O(n)
```

For frequency map.

---

# Key Tricks

### 1️⃣ Always start from smallest

```
Greedy ensures correctness
```

---

### 2️⃣ Use frequency map

```
Track remaining cards
```

---

### 3️⃣ Build consecutive sequence

```
num → num + groupSize - 1
```

---

# Pattern Recognition

This problem belongs to:

```
Greedy + Sorting + HashMap Pattern
```

Similar problems:

```
Task Scheduler
Top K Frequent Elements
Reorganize String
```

---

# Summary

Core idea:

```
Sort the cards
Always start from smallest unused card
Try forming consecutive groups
Fail early if missing element
```

---

# Takeaway

Whenever you see:

```
grouping + consecutive elements
use all elements
```

Think immediately:

```
Greedy + Frequency Map
```

Because:

```
Smallest element must start a group
```

http://neetcode.io/problems/hand-of-straights/question?list=neetcode150

https://leetcode.com/problems/hand-of-straights/

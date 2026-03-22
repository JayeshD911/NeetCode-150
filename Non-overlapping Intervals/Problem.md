# 435. Non-overlapping Intervals

🔗 Problem: https://leetcode.com/problems/non-overlapping-intervals/

---

# Problem

Given an array of intervals where:

```
intervals[i] = [start, end]
```

Return the **minimum number of intervals you need to remove** to make the rest of the intervals **non-overlapping**.

Note:

```
Intervals that touch at endpoints are NOT overlapping
```

Example:

```
[1,2] and [2,3] → valid (no overlap)
```

---

# Example

### Example 1

Input
```
intervals = [[1,2],[2,3],[3,4],[1,3]]
```

Output
```
1
```

Explanation

```
[1,3] overlaps with others
Remove it
```

Remaining:

```
[[1,2],[2,3],[3,4]] → non-overlapping
```

---

### Example 2

Input
```
intervals = [[1,2],[1,2],[1,2]]
```

Output
```
2
```

Explanation

```
All intervals overlap
Keep only one
Remove 2
```

---

### Example 3

Input
```
intervals = [[1,2],[2,3]]
```

Output
```
0
```

Explanation

```
Already non-overlapping
```

---

# Key Idea

Instead of directly removing intervals, think:

```
Keep maximum number of non-overlapping intervals
```

Then:

```
minimum removals = total intervals - intervals kept
```

Greedy insight:

```
Always keep the interval that ends earliest
```

Why?

```
It leaves more space for future intervals
``` 
:contentReference[oaicite:0]{index=0}

---

# Intuition

Consider:

```
[1,100] and [2,3]
```

If we keep:

```
[1,100]
```

We block many future intervals.

But if we keep:

```
[2,3]
```

We allow more intervals later.

So:

```
Always pick interval with smaller end
```

---

# Strategy (Greedy + Sorting)

Steps:

```
1️⃣ Sort intervals by end time

2️⃣ Initialize:
      prevEnd = end of first interval
      count = 0 (number of removals)

3️⃣ Traverse intervals

4️⃣ If overlap:
      increment count (remove one interval)

5️⃣ Else:
      update prevEnd = current end
```

Overlap condition:

```
current.start < prevEnd
```

---

# Optimal Java Solution

```java
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int prevEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){

            if(intervals[i][0] < prevEnd){
                count++; // remove interval
            }
            else{
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
}
```

---

# Dry Run

Input

```
intervals = [[1,2],[2,3],[3,4],[1,3]]
```

Step 1: Sort by end

```
[[1,2],[2,3],[1,3],[3,4]]
```

Steps

```
Start → [1,2], prevEnd = 2

Next → [2,3]
No overlap → prevEnd = 3

Next → [1,3]
Overlap → remove → count = 1

Next → [3,4]
No overlap → prevEnd = 4
```

Result

```
count = 1
```

---

# Complexity Analysis

### Time Complexity

```
O(n log n)
```

Due to sorting. :contentReference[oaicite:1]{index=1}

---

### Space Complexity

```
O(1)
```

No extra space required.

---

# Key Tricks

### 1️⃣ Sort by end time (NOT start)

```
End time greedy gives optimal result
```

---

### 2️⃣ Keep smallest ending interval

```
Minimize overlap with future intervals
```

---

### 3️⃣ Count removals

```
Overlap → increment count
```

---

# Pattern Recognition

This problem belongs to:

```
Greedy + Interval Scheduling Pattern
```

Similar problems:

```
Merge Intervals
Insert Interval
Meeting Rooms
Activity Selection Problem
```

---

# Summary

Core idea:

```
Sort intervals by end time
Keep earliest ending intervals
Remove overlapping ones
```

Final complexity:

```
Time  : O(n log n)
Space : O(1)
```

---

# Takeaway

Whenever you see:

```
minimum removals
maximum non-overlapping intervals
interval conflicts
```

Think immediately:

```
Greedy → sort by end time
```

Because:

```
Earliest ending interval maximizes future possibilities
```


https://neetcode.io/problems/non-overlapping-intervals/question?list=neetcode150

https://leetcode.com/problems/non-overlapping-intervals/description/
# Meeting Schedule (Meeting Rooms)

🔗 Problem: https://neetcode.io/problems/meeting-schedule/question?list=neetcode150

---

# Problem

Given an array of meeting time intervals:

```
intervals = [[start1, end1], [start2, end2], ...]
```

Determine if a person can attend **all meetings** without conflicts.

Return:

```
true  → if no meetings overlap
false → if any meetings overlap
```

Important:

```
(start, end) where start < end
[1,2] and [2,3] → NOT overlapping
``` 
:contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input
```
intervals = [[0,30],[5,10],[15,20]]
```

Output
```
false
```

Explanation

```
[0,30] overlaps with [5,10]
[0,30] overlaps with [15,20]
```

So all meetings cannot be attended.

---

### Example 2

Input
```
intervals = [[5,8],[9,15]]
```

Output
```
true
```

Explanation

```
No intervals overlap
```

So all meetings can be attended.

---

# Key Idea

The key observation:

```
Overlapping intervals prevent attending all meetings
```

If we sort intervals:

```
overlapping intervals will be adjacent
```

So we only need to check:

```
current.start < previous.end
``` 
:contentReference[oaicite:1]{index=1}

---

# Intuition

Imagine intervals on a number line:

```
[0,30]
   [5,10]
      [15,20]
```

Clearly overlapping.

If sorted:

```
[0,30], [5,10], [15,20]
```

We just compare adjacent intervals:

```
5 < 30 → overlap
```

---

# Strategy (Greedy + Sorting)

Steps:

```
1️⃣ Sort intervals by start time

2️⃣ Traverse intervals

3️⃣ If current.start < previous.end
      return false

4️⃣ If no conflicts found → return true
```

---

# Optimal Java Solution

```java
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for(int i = 1; i < intervals.length; i++){

            if(intervals[i][0] < intervals[i-1][1]){
                return false;
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
intervals = [[0,30],[5,10],[15,20]]
```

Step 1: Sort

```
[[0,30],[5,10],[15,20]]
```

Steps

```
Compare [0,30] and [5,10]
5 < 30 → overlap → return false
```

---

# Complexity Analysis

### Time Complexity

```
O(n log n)
```

Due to sorting. :contentReference[oaicite:2]{index=2}

---

### Space Complexity

```
O(1)
```

No extra space required.

---

# Key Tricks

### 1️⃣ Sort first

```
Makes overlap detection easy
```

---

### 2️⃣ Only compare neighbors

```
No need to check all pairs
```

---

### 3️⃣ Overlap condition

```
current.start < previous.end
```

---

# Pattern Recognition

This problem belongs to:

```
Intervals + Greedy Pattern
```

Similar problems:

```
Merge Intervals
Insert Interval
Non-overlapping Intervals
Meeting Rooms II
```

---

# Summary

Core idea:

```
Sort intervals
Check adjacent overlaps
Return false if conflict found
Else return true
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
meeting conflicts
schedule feasibility
interval overlaps
```

Think immediately:

```
Sort + Check Adjacent Intervals
```

Because sorting simplifies overlap detection drastically.


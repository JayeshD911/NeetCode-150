# 57. Insert Interval

🔗 Problem: https://leetcode.com/problems/insert-interval/

---

# Problem

You are given a list of **non-overlapping intervals** sorted by their start time, where:

```
intervals[i] = [start, end]
```

You are also given a new interval:

```
newInterval = [start, end]
```

Insert `newInterval` into `intervals` such that:

```
1. The list remains sorted
2. No overlapping intervals remain (merge if necessary)
```

Return the updated list of intervals. :contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input
```
intervals = [[1,3],[6,9]]
newInterval = [2,5]
```

Output
```
[[1,5],[6,9]]
```

Explanation

```
[1,3] overlaps with [2,5]
→ merge into [1,5]
```

Final result:

```
[[1,5],[6,9]]
```

---

### Example 2

Input
```
intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]]
newInterval = [4,8]
```

Output
```
[[1,2],[3,10],[12,16]]
```

Explanation

```
[4,8] overlaps with:
[3,5], [6,7], [8,10]

Merged interval:
[3,10]
```

---

# Key Idea

We process intervals in **3 phases**:

```
1. Add intervals before newInterval (no overlap)
2. Merge overlapping intervals
3. Add remaining intervals
```

Because intervals are already **sorted and non-overlapping**, all overlapping intervals appear **together**. :contentReference[oaicite:1]{index=1}

---

# Intuition

Visualize intervals like a number line:

```
[1,2]   [3,5]   [6,7]   [8,10]
          ↑
      newInterval = [4,8]
```

Steps:

```
1. Add [1,2] → no overlap

2. Merge overlapping intervals:
   [3,5], [6,7], [8,10]

   → merged into [3,10]

3. Add remaining intervals
```

---

# Strategy (Greedy Sweep)

Steps:

```
1️⃣ Traverse intervals

2️⃣ Add all intervals that end before newInterval starts

3️⃣ Merge overlapping intervals:
      update newInterval.start = min(...)
      update newInterval.end   = max(...)

4️⃣ Add merged interval

5️⃣ Add remaining intervals
```

---

# Optimal Java Solution

```java
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // 1. Add intervals before newInterval
        while(i < n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        // 2. Merge overlapping intervals
        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        // 3. Add remaining intervals
        while(i < n){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
```

---

# Dry Run

Input

```
intervals = [[1,2],[3,5],[6,7],[8,10]]
newInterval = [4,8]
```

Steps

```
Add non-overlapping:
[1,2]

Merge:
[3,5], [6,7], [8,10]
→ newInterval becomes [3,10]

Add remaining:
none
```

Result

```
[[1,2],[3,10]]
```

---

# Complexity Analysis

### Time Complexity

```
O(n)
```

We traverse the array once. :contentReference[oaicite:2]{index=2}

---

### Space Complexity

```
O(n)
```

For storing the result.

---

# Key Tricks

### 1️⃣ Use sorted property

```
Intervals are already sorted
```

---

### 2️⃣ Merge only when needed

```
while intervals[i][0] <= newInterval[1]
```

---

### 3️⃣ Expand interval

```
start = min(start)
end   = max(end)
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
Meeting Rooms
Non-overlapping Intervals
Interval Intersection
```

---

# Summary

Core idea:

```
Process intervals in 3 parts:
before, overlap, after
Merge overlaps into one interval
Return updated list
```

Final complexity:

```
Time  : O(n)
Space : O(n)
```

---

# Takeaway

Whenever you see:

```
interval insertion
merge intervals
overlapping ranges
```

Think immediately:

```
Greedy + Single Pass + Merge Logic
```

Because sorted intervals allow a **clean linear solution**.

https://neetcode.io/problems/insert-new-interval/question

https://leetcode.com/problems/insert-interval/
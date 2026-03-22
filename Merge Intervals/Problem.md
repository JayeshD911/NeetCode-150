# 56. Merge Intervals

🔗 Problem: https://leetcode.com/problems/merge-intervals/

---

# Problem

Given an array of intervals where:

```
intervals[i] = [start, end]
```

Merge all **overlapping intervals** and return an array of **non-overlapping intervals** that cover all the original intervals. :contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input
```
intervals = [[1,3],[2,6],[8,10],[15,18]]
```

Output
```
[[1,6],[8,10],[15,18]]
```

Explanation

```
[1,3] and [2,6] overlap
→ merge into [1,6]
```

Remaining intervals do not overlap:

```
[[1,6],[8,10],[15,18]]
```

---

### Example 2

Input
```
intervals = [[1,4],[4,5]]
```

Output
```
[[1,5]]
```

Explanation

```
[1,4] and [4,5] overlap (touching counts)
→ merge into [1,5]
```

---

# Key Idea

The key observation:

```
If intervals are sorted,
overlapping intervals will be adjacent
```

So the solution is:

```
Sort + Merge in one pass
``` 
:contentReference[oaicite:1]{index=1}

---

# Intuition

Visualize intervals on a number line:

```
[1,3]   [2,6]   [8,10]
```

After sorting:

```
[1,3], [2,6], [8,10]
```

Process:

```
Start with [1,3]
Next [2,6] overlaps → merge → [1,6]
Next [8,10] does not overlap → add new
```

---

# Strategy (Greedy + Sorting)

Steps:

```
1️⃣ Sort intervals by start time

2️⃣ Initialize result list

3️⃣ Iterate through intervals

4️⃣ If no overlap:
      add interval

5️⃣ If overlap:
      merge by updating end = max(end, current.end)
```

Overlap condition:

```
current.start <= previous.end
```

---

# Optimal Java Solution

```java
class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        for(int[] interval : intervals){

            if(result.isEmpty() || result.get(result.size()-1)[1] < interval[0]){
                result.add(interval);
            }
            else{
                result.get(result.size()-1)[1] =
                    Math.max(result.get(result.size()-1)[1], interval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
```

---

# Dry Run

Input

```
intervals = [[1,3],[2,6],[8,10],[15,18]]
```

Step 1: Sort

```
[[1,3],[2,6],[8,10],[15,18]]
```

Steps

```
Start → [1,3]

Next → [2,6]
Overlap → merge → [1,6]

Next → [8,10]
No overlap → add

Next → [15,18]
No overlap → add
```

Result

```
[[1,6],[8,10],[15,18]]
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
O(n)
```

For storing the result.

---

# Key Tricks

### 1️⃣ Sort first

```
Ensures overlapping intervals are adjacent
```

---

### 2️⃣ Compare with last merged interval

```
Only need to check previous interval
```

---

### 3️⃣ Merge by extending end

```
end = max(end, current.end)
```

---

# Pattern Recognition

This problem belongs to:

```
Intervals + Greedy Pattern
```

Similar problems:

```
Insert Interval
Meeting Rooms
Non-overlapping Intervals
Interval Intersection
```

---

# Summary

Core idea:

```
Sort intervals
Traverse once
Merge overlapping intervals
Add non-overlapping intervals directly
```

Final complexity:

```
Time  : O(n log n)
Space : O(n)
```

---

# Takeaway

Whenever you see:

```
merge intervals
overlapping ranges
schedule merging
```

Think immediately:

```
Sort + Greedy Merge
```

Because sorting reduces complexity from:

```
O(n²) → O(n log n)
```

https://neetcode.io/problems/merge-intervals/question

https://leetcode.com/problems/merge-intervals/description/
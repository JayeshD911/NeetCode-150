# Meeting Schedule II (Meeting Rooms II)

🔗 Problem: https://neetcode.io/problems/meeting-schedule-ii/question?list=neetcode150

---

# Problem

Given an array of meeting intervals:

```
intervals[i] = [start, end]
```

Return the **minimum number of conference rooms required** so that all meetings can be scheduled without conflicts.

Important:

```
If meetings overlap → need separate rooms
If one meeting ends exactly when another starts → same room can be reused
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
2
```

Explanation

```
[0,30] overlaps with [5,10]
[0,30] overlaps with [15,20]
```

At one point, 2 meetings happen simultaneously → need 2 rooms.

---

### Example 2

Input
```
intervals = [[7,10],[2,4]]
```

Output
```
1
```

Explanation

```
No overlapping meetings
```

Only 1 room is enough.

---

# Key Idea

The core observation:

```
Number of rooms needed = maximum number of overlapping meetings at any time
``` 
:contentReference[oaicite:1]{index=1}

So instead of scheduling explicitly, we track:

```
How many meetings are happening simultaneously
```

---

# Intuition

Visualize meetings on a timeline:

```
[0,30]
   [5,10]
      [15,20]
```

At time = 5:

```
2 meetings overlap → need 2 rooms
```

At time = 15:

```
2 meetings overlap → need 2 rooms
```

Maximum overlap = 2 → answer

---

# Strategy (Min Heap Approach)

Steps:

```
1️⃣ Sort intervals by start time

2️⃣ Use a min heap to store end times

3️⃣ For each meeting:
      if earliest ending meeting is finished
            reuse that room (remove from heap)

4️⃣ Add current meeting's end time

5️⃣ Heap size = number of rooms needed
```

Why this works:

```
Heap tracks currently active meetings
Size of heap = rooms in use
``` 
:contentReference[oaicite:2]{index=2}

---

# Optimal Java Solution

```java
class Solution {
    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int[] interval : intervals){

            if(!minHeap.isEmpty() && interval[0] >= minHeap.peek()){
                minHeap.poll(); // reuse room
            }

            minHeap.offer(interval[1]);
        }

        return minHeap.size();
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
Add [0,30] → heap = [30]

Next [5,10]
5 < 30 → overlap → need new room
heap = [10,30]

Next [15,20]
15 >= 10 → reuse room
remove 10
add 20 → heap = [20,30]
```

Final heap size:

```
2
```

Answer:

```
2
```

---

# Complexity Analysis

### Time Complexity

```
O(n log n)
```

Sorting + heap operations. :contentReference[oaicite:3]{index=3}

---

### Space Complexity

```
O(n)
```

Heap stores active meetings. :contentReference[oaicite:4]{index=4}

---

# Key Tricks

### 1️⃣ Sort by start time

```
Ensures chronological processing
```

---

### 2️⃣ Use min heap for end times

```
Track earliest ending meeting
```

---

### 3️⃣ Reuse rooms

```
if start >= earliest end → reuse
```

---

# Pattern Recognition

This problem belongs to:

```
Intervals + Heap + Greedy Pattern
```

Similar problems:

```
Meeting Rooms I
Merge Intervals
Insert Interval
Task Scheduler
```

---

# Summary

Core idea:

```
Track overlapping meetings
Use min heap for active meetings
Reuse room if possible
Heap size = minimum rooms required
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
minimum resources needed
overlapping intervals
room scheduling
```

Think immediately:

```
Min Heap + Track active intervals
```

Because:

```
Maximum overlap = minimum resources needed
```

https://neetcode.io/problems/meeting-schedule-ii/question?list=neetcode150
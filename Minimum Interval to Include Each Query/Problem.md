# 1851. Minimum Interval to Include Each Query

🔗 Problem: https://leetcode.com/problems/minimum-interval-to-include-each-query/

---

# Problem

You are given:

```
intervals[i] = [left, right]
queries[j]
```

For each query, find the **size of the smallest interval** such that:

```
left ≤ query ≤ right
```

If no interval contains the query:

```
return -1
```

Interval size is defined as:

```
right - left + 1
``` 
:contentReference[oaicite:0]{index=0}

Return the result for all queries in the **original order**.

---

# Example

### Example 1

Input
```
intervals = [[1,4],[2,4],[3,6],[4,4]]
queries = [2,3,4,5]
```

Output
```
[3,3,1,4]
```

Explanation

```
Query = 2 → intervals containing 2: [1,4], [2,4]
Smallest = [2,4] → size = 3

Query = 3 → intervals: [1,4], [2,4], [3,6]
Smallest = [2,4] → size = 3

Query = 4 → intervals: [1,4], [2,4], [3,6], [4,4]
Smallest = [4,4] → size = 1

Query = 5 → intervals: [3,6]
Size = 4
``` 
:contentReference[oaicite:1]{index=1}

---

### Example 2

Input
```
intervals = [[2,3],[2,5],[1,8],[20,25]]
queries = [2,19,5,22]
```

Output
```
[2,-1,4,6]
```

Explanation

```
Query = 19 → no interval contains it → -1
```

---

# Key Idea

Brute force would be:

```
For each query → check all intervals → O(n * q)
```

Too slow.

Key observation:

```
Order of queries doesn't matter
```

So we:

```
Sort queries
Process them in increasing order
```

This allows us to **reuse work efficiently**. :contentReference[oaicite:2]{index=2}

---

# Intuition

We process queries from smallest → largest.

For each query `q`:

```
Add all intervals where start ≤ q
Remove intervals where end < q
```

So remaining intervals:

```
are valid intervals that contain q
```

Now we just need:

```
smallest interval among them
```

So we use:

```
Min Heap (based on interval size)
```

---

# Strategy (Sorting + Min Heap)

Steps:

```
1️⃣ Sort intervals by start

2️⃣ Sort queries (store original index)

3️⃣ Use min heap:
      stores (interval size, end)

4️⃣ For each query:
      add intervals with start ≤ query

      remove intervals where end < query

      top of heap = smallest valid interval
```

---

# Optimal Java Solution

```java
class Solution {

    public int[] minInterval(int[][] intervals, int[] queries) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int n = queries.length;
        int[][] q = new int[n][2];

        for(int i = 0; i < n; i++){
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(q, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        int[] result = new int[n];
        Arrays.fill(result, -1);

        int i = 0;

        for(int[] query : q){

            int val = query[0];
            int idx = query[1];

            // add valid intervals
            while(i < intervals.length && intervals[i][0] <= val){
                int start = intervals[i][0];
                int end = intervals[i][1];
                int size = end - start + 1;

                minHeap.offer(new int[]{size, end});
                i++;
            }

            // remove invalid intervals
            while(!minHeap.isEmpty() && minHeap.peek()[1] < val){
                minHeap.poll();
            }

            if(!minHeap.isEmpty()){
                result[idx] = minHeap.peek()[0];
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
intervals = [[1,4],[2,4],[3,6],[4,4]]
queries = [2,3,4,5]
```

Sorted queries:

```
[2,3,4,5]
```

Steps

```
Query = 2
Add intervals → [1,4], [2,4]
Heap → sizes [4,3]
Answer → 3
```

```
Query = 3
Add interval [3,6]
Heap → [3,4,4]
Answer → 3
```

```
Query = 4
Add [4,4]
Heap → [1,3,4,4]
Answer → 1
```

```
Query = 5
Remove intervals ending < 5
Remaining → [3,6]
Answer → 4
```

---

# Complexity Analysis

### Time Complexity

```
O(n log n + q log q + (n + q) log n)
```

Simplified:

```
O((n + q) log n)
``` 
:contentReference[oaicite:3]{index=3}

---

### Space Complexity

```
O(n + q)
```

For heap and result arrays. :contentReference[oaicite:4]{index=4}

---

# Key Tricks

### 1️⃣ Sort queries

```
Allows incremental processing
```

---

### 2️⃣ Use min heap

```
Stores smallest interval first
```

---

### 3️⃣ Store (size, end)

```
size → priority
end  → validity check
```

---

### 4️⃣ Remove invalid intervals

```
if end < query → discard
```

---

# Pattern Recognition

This problem belongs to:

```
Intervals + Heap + Offline Query Pattern
```

Similar problems:

```
Meeting Rooms II
K Closest Points
Merge Intervals
Task Scheduler
```

---

# Summary

Core idea:

```
Sort queries
Add valid intervals dynamically
Remove expired intervals
Use heap to track smallest interval
```

---

# Takeaway

Whenever you see:

```
queries + intervals
smallest / optimal interval per query
```

Think immediately:

```
Offline queries + Sorting + Heap
```

Because:

```
Sorting allows reuse of computation
Heap gives optimal choice instantly
```


https://neetcode.io/problems/minimum-interval-including-query/question?list=neetcode150

https://leetcode.com/problems/minimum-interval-to-include-each-query/description/
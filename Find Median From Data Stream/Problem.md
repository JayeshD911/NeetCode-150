# 295. Find Median from Data Stream

🔗 Problem: https://leetcode.com/problems/find-median-from-data-stream/

---

# Problem

The **median** is the middle value in an ordered list of integers.

If the size of the list is even:

```
median = average of the two middle values
```

If the size is odd:

```
median = middle value
``` 
:contentReference[oaicite:0]{index=0}

Design a data structure that supports:

```
MedianFinder()
void addNum(int num)
double findMedian()
```

---

# Example

### Example 1

Input
```
["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
[[],[1],[2],[],[3],[]]
```

Output
```
[null,null,null,1.5,null,2.0]
```

Explanation

```
addNum(1) → [1]
addNum(2) → [1,2]
median → (1 + 2) / 2 = 1.5

addNum(3) → [1,2,3]
median → 2
```

---

# Key Idea

We need to efficiently:

```
Insert numbers dynamically
Find median quickly
```

Sorting every time is too slow.

Optimal approach:

```
Use TWO HEAPS
```

```
Max Heap → stores smaller half
Min Heap → stores larger half
``` 
:contentReference[oaicite:1]{index=1}

---

# Intuition

We divide numbers into two parts:

```
Left side  → smaller numbers
Right side → larger numbers
```

Example:

```
[1,2,3,4,5]
```

Split into:

```
Max Heap → [1,2]
Min Heap → [3,4,5]
```

Median:

```
Top of larger heap → 3
```

---

# Strategy (Two Heaps)

Maintain two heaps:

```
maxHeap → stores smaller half
minHeap → stores larger half
```

Rules:

```
1️⃣ Size difference ≤ 1

2️⃣ maxHeap top ≤ minHeap top

3️⃣ Median:
      if sizes equal → average of both tops
      else → top of larger heap
``` 
:contentReference[oaicite:2]{index=2}

---

# Optimal Java Solution

```java
class MedianFinder {

    PriorityQueue<Integer> maxHeap; // left half (max heap)
    PriorityQueue<Integer> minHeap; // right half (min heap)

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Step 1: Add to maxHeap
        maxHeap.offer(num);

        // Step 2: Balance → move largest from maxHeap to minHeap
        minHeap.offer(maxHeap.poll());

        // Step 3: Maintain size property
        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }

        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
```

---

# Dry Run

Input

```
addNum(1)
addNum(2)
findMedian()
addNum(3)
findMedian()
```

Steps

```
addNum(1)
maxHeap = [1]
minHeap = []

addNum(2)
maxHeap = [1]
minHeap = [2]

Median → (1 + 2) / 2 = 1.5
```

```
addNum(3)
maxHeap = [2,1]
minHeap = [3]

Median → 2
```

---

# Complexity Analysis

### Time Complexity

```
addNum()     → O(log n)
findMedian() → O(1)
```

Efficient because heaps maintain order dynamically. :contentReference[oaicite:3]{index=3}

---

### Space Complexity

```
O(n)
```

We store all elements.

---

# Key Tricks

### 1️⃣ Two Heaps

```
Max heap → smaller half
Min heap → larger half
```

---

### 2️⃣ Balance heaps

```
Size difference should never exceed 1
```

---

### 3️⃣ Median logic

```
If equal size → average
Else → top of larger heap
```

---

# Pattern Recognition

This problem belongs to:

```
Heap / Two Heaps Pattern
```

Similar problems:

```
Kth Largest Element
Sliding Window Median
Merge K Sorted Lists
```

---

# Summary

Core idea:

```
Split data into two halves
Maintain order using heaps
Balance heaps after every insertion
Compute median from heap tops
```

Final complexity:

```
Time  : O(log n) insert
Space : O(n)
```

---

# Takeaway

Whenever you see:

```
median in stream
dynamic data
continuous insertion
```

Think immediately:

```
Two Heaps (Max + Min)
```

Because it gives:

```
Fast insertion
Instant median calculation
```


https://neetcode.io/problems/find-median-in-a-data-stream/question?list=neetcode150

https://leetcode.com/problems/find-median-from-data-stream/description/
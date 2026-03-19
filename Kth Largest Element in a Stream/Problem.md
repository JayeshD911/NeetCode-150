# 703. Kth Largest Element in a Stream

🔗 Problem: https://leetcode.com/problems/kth-largest-element-in-a-stream/

---

# Problem

Design a class to find the **kth largest element in a stream** of numbers.

Implement the `KthLargest` class:

```
KthLargest(int k, int[] nums)
```
Initializes the object with integer `k` and initial stream `nums`.

```
int add(int val)
```
Adds a new value to the stream and returns the **kth largest element**. :contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input
```
["KthLargest","add","add","add","add","add"]
[[3,[4,5,8,2]],[3],[5],[10],[9],[4]]
```

Output
```
[null,4,5,5,8,8]
```

Explanation

```
k = 3
Initial nums = [4,5,8,2]
```

Sorted:

```
[2,4,5,8]
```

3rd largest:

```
4
```

Now operations:

```
add(3)  → [2,3,4,5,8] → 3rd largest = 4
add(5)  → [2,3,4,5,5,8] → 3rd largest = 5
add(10) → [2,3,4,5,5,8,10] → 3rd largest = 5
add(9)  → [2,3,4,5,5,8,9,10] → 3rd largest = 8
add(4)  → [2,3,4,4,5,5,8,9,10] → 3rd largest = 8
```

---

# Key Idea

We do **NOT need to store all elements**.

We only care about:

```
k largest elements
```

Key observation:

```
The kth largest element = smallest element among top k elements
```

So we maintain:

```
Min Heap of size k
```

The root of this heap is always the answer. :contentReference[oaicite:1]{index=1}

---

# Intuition

Think of it like a leaderboard:

```
k = 3
Top 3 scores only matter
```

Example:

```
[100, 95, 90, 80, 70]
```

We only keep:

```
[90, 95, 100]
```

Here:

```
smallest of top 3 = 90
```

That is the **3rd largest**.

When a new value comes:

```
Add it
If size > k → remove smallest
```

So heap always stores **top k elements only**.

---

# Strategy (Min Heap)

Steps:

```
1️⃣ Create min heap

2️⃣ Add all initial elements

3️⃣ If heap size > k → remove smallest

4️⃣ For each add(val)
      push val
      if size > k → pop smallest

5️⃣ Return heap.peek()
```

---

# Optimal Java Solution

```java
class KthLargest {

    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for(int num : nums){
            add(num);
        }
    }

    public int add(int val) {

        minHeap.offer(val);

        if(minHeap.size() > k){
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
```

---

# Dry Run

Input

```
k = 3
nums = [4,5,8,2]
```

Initialization

```
Heap = [4,5,8]
(we remove 2 since we only keep top 3)
```

Operations

```
add(3)
Heap = [3,4,5,8] → remove 3 → [4,5,8]
Answer = 4
```

```
add(10)
Heap = [4,5,8,10] → remove 4 → [5,8,10]
Answer = 5
```

```
add(9)
Heap = [5,8,9,10] → remove 5 → [8,9,10]
Answer = 8
```

---

# Complexity Analysis

### Time Complexity

```
Initialization : O(n log k)
add()          : O(log k)
```

Because heap size is always at most `k`. :contentReference[oaicite:2]{index=2}

---

### Space Complexity

```
O(k)
```

We store only `k` elements in the heap. :contentReference[oaicite:3]{index=3}

---

# Key Tricks

### 1️⃣ Use Min Heap (NOT Max Heap)

```
Min heap root = kth largest
```

---

### 2️⃣ Maintain size k

```
if size > k → remove smallest
```

---

### 3️⃣ Answer is always at top

```
heap.peek()
```

---

# Pattern Recognition

This problem belongs to the **Heap / Priority Queue Pattern**.

Similar problems:

```
Kth Largest Element in Array
Top K Frequent Elements
Find Median from Data Stream
Merge K Sorted Lists
```

---

# Summary

Core idea:

```
Maintain a min heap of size k
Keep only k largest elements
Root of heap = kth largest element
```

Final complexity:

```
Time  : O(log k) per operation
Space : O(k)
```

---

# Takeaway

Whenever you see:

```
kth largest in stream
top k elements
dynamic input
```

Think immediately:

```
Min Heap of size k
```

Because it gives:

```
Efficient insertion
Constant time access to kth largest
```


https://neetcode.io/problems/kth-largest-integer-in-a-stream/question

https://leetcode.com/problems/kth-largest-element-in-a-stream/
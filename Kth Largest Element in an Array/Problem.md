# 215. Kth Largest Element in an Array

🔗 Problem: https://leetcode.com/problems/kth-largest-element-in-an-array/

---

# Problem

Given an integer array `nums` and an integer `k`, return the **kth largest element in the array**.

Important:

```
It is the kth largest element in sorted order,
NOT the kth distinct element.
``` 
:contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input
```
nums = [3,2,1,5,6,4]
k = 2
```

Output
```
5
```

Explanation

Sorted (descending):

```
[6,5,4,3,2,1]
```

2nd largest element:

```
5
```

---

### Example 2

Input
```
nums = [3,2,3,1,2,4,5,5,6]
k = 4
```

Output
```
4
```

Explanation

Sorted (descending):

```
[6,5,5,4,3,3,2,2,1]
```

4th largest element:

```
4
```

Note:

```
Duplicates are counted separately
```

---

# Key Idea

We only need:

```
k largest elements
```

Key observation:

```
The kth largest element = smallest among the top k elements
``` 
:contentReference[oaicite:1]{index=1}

So we maintain:

```
Min Heap of size k
```

---

# Intuition

Instead of sorting the entire array:

```
O(n log n)
```

We can do better by keeping only:

```
top k largest elements
```

Example:

```
nums = [3,2,1,5,6,4]
k = 2
```

We maintain heap:

```
[5,6]
```

The smallest among them:

```
5 → kth largest
```

---

# Strategy (Min Heap)

Steps:

```
1️⃣ Create a min heap

2️⃣ Iterate over all elements

3️⃣ Add element to heap

4️⃣ If heap size > k
      remove smallest element

5️⃣ After processing all elements
      heap.peek() = kth largest
```

This avoids sorting the entire array. :contentReference[oaicite:2]{index=2}

---

# Optimal Java Solution

```java
class Solution {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums){

            minHeap.offer(num);

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
```

---

# Dry Run

Input

```
nums = [3,2,1,5,6,4]
k = 2
```

Steps

```
Insert 3 → [3]
Insert 2 → [2,3]
Insert 1 → [1,3,2] → remove 1 → [2,3]
Insert 5 → [2,3,5] → remove 2 → [3,5]
Insert 6 → [3,5,6] → remove 3 → [5,6]
Insert 4 → [4,6,5] → remove 4 → [5,6]
```

Final heap

```
[5,6]
```

Answer

```
5
```

---

# Complexity Analysis

### Time Complexity

```
O(n log k)
```

Each insertion/removal takes `O(log k)`. :contentReference[oaicite:3]{index=3}

---

### Space Complexity

```
O(k)
```

Heap stores only `k` elements. :contentReference[oaicite:4]{index=4}

---

# Key Tricks

### 1️⃣ Use Min Heap (not max heap)

```
Min heap keeps smallest among top k elements
```

---

### 2️⃣ Maintain size k

```
if size > k → remove smallest
```

---

### 3️⃣ Answer is at heap top

```
heap.peek()
```

---

# Pattern Recognition

This problem belongs to the **Heap / Top K Pattern**.

Similar problems:

```
Kth Largest Element in a Stream
Top K Frequent Elements
K Closest Points to Origin
Find Median from Data Stream
```

Also can be solved using:

```
Quickselect (Average O(n))
``` 
:contentReference[oaicite:5]{index=5}

---

# Summary

Core idea:

```
Maintain a min heap of size k
Keep only k largest elements
Smallest in heap = kth largest
```

Final complexity:

```
Time  : O(n log k)
Space : O(k)
```

---

# Takeaway

Whenever you see:

```
kth largest / kth smallest
top k elements
```

Think immediately:

```
Heap OR Quickselect
```

For interviews:

```
Min Heap → easiest and safest
Quickselect → optimal but trickier
```

https://neetcode.io/problems/kth-largest-element-in-an-array/question?list=neetcode150

https://leetcode.com/problems/kth-largest-element-in-an-array/
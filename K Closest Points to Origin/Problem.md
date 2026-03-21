# 973. K Closest Points to Origin

🔗 Problem: https://leetcode.com/problems/k-closest-points-to-origin/

---

# Problem

Given an array of points `points` where:

```
points[i] = [xi, yi]
```

represents a point on a 2D plane, and an integer `k`, return the **k closest points to the origin (0, 0)**.

The distance between two points is:

```
√(x² + y²)
```

You may return the answer in **any order**. :contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input
```
points = [[1,3],[-2,2]]
k = 1
```

Output
```
[[-2,2]]
```

Explanation

```
Distance of (1,3)  → 1² + 3² = 10
Distance of (-2,2) → (-2)² + 2² = 8
```

Since:

```
8 < 10
```

Point `[-2,2]` is closer to the origin, so it is the answer. :contentReference[oaicite:1]{index=1}

---

### Example 2

Input
```
points = [[3,3],[5,-1],[-2,4]]
k = 2
```

Output
```
[[3,3],[-2,4]]
```

Explanation

```
Distance(3,3)   = 18
Distance(-2,4)  = 20
Distance(5,-1)  = 26
```

Closest 2 points:

```
[3,3], [-2,4]
```

---

# Key Idea

We don’t need the exact distance:

```
√(x² + y²)
```

Instead, we can compare:

```
x² + y²
```

because square root is **monotonic**, so ordering remains the same. :contentReference[oaicite:2]{index=2}

---

# Intuition

This is a classic:

```
Top K elements problem
```

We want:

```
k smallest distances
```

Instead of sorting everything, we can maintain:

```
Max Heap of size k
```

Why max heap?

```
Top of heap = farthest among k closest
```

If a new point is closer:

```
remove the farthest
add the new one
```

---

# Strategy (Max Heap)

Steps:

```
1️⃣ Create max heap (based on distance)

2️⃣ Iterate over all points

3️⃣ Push point into heap

4️⃣ If heap size > k
      remove the farthest point

5️⃣ Return all elements in heap
```

This ensures we only store **k closest points at any time**.

---

# Optimal Java Solution

```java
class Solution {

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );

        for(int[] point : points){

            maxHeap.offer(point);

            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];

        for(int i = 0; i < k; i++){
            result[i] = maxHeap.poll();
        }

        return result;
    }
}
```

---

# Dry Run

Input

```
points = [[3,3],[5,-1],[-2,4]]
k = 2
```

Steps

```
Insert [3,3] → heap = [[3,3]]

Insert [5,-1] → heap = [[5,-1],[3,3]]

Insert [-2,4]
heap = [[5,-1],[3,3],[-2,4]]
size > k → remove farthest → remove [5,-1]

Remaining:
[[3,3],[-2,4]]
```

Result

```
[[3,3],[-2,4]]
```

---

# Complexity Analysis

### Time Complexity

```
O(n log k)
```

Where:

```
n = number of points
```

Each insertion/removal takes `O(log k)`. :contentReference[oaicite:3]{index=3}

---

### Space Complexity

```
O(k)
```

We store only `k` elements in the heap. :contentReference[oaicite:4]{index=4}

---

# Key Tricks

### 1️⃣ Use squared distance

```
x² + y²
```

Avoids unnecessary `sqrt`.

---

### 2️⃣ Use max heap of size k

```
Keep only k closest points
```

---

### 3️⃣ Remove farthest when size exceeds k

```
if size > k → poll()
```

---

# Pattern Recognition

This problem belongs to the **Heap / Top K Pattern**.

Similar problems:

```
Kth Largest Element in Array
Top K Frequent Elements
K Closest Elements
Find Median from Data Stream
```

---

# Summary

Core idea:

```
Compute distance
Maintain k closest using max heap
Remove farthest when needed
Return heap elements
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
k closest / k smallest / top k
```

Think immediately:

```
Heap (Priority Queue)
```

And choose:

```
Max heap → when tracking smallest k elements
Min heap → when tracking largest k elements
```

https://neetcode.io/problems/k-closest-points-to-origin/question?list=neetcode150

https://leetcode.com/problems/k-closest-points-to-origin/description/
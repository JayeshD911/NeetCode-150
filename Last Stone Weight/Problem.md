# 1046. Last Stone Weight

🔗 Problem: https://leetcode.com/problems/last-stone-weight/

---

# Problem

You are given an array of integers `stones`, where each element represents the weight of a stone.

You play a game with the following rules:

```
1. Choose the two heaviest stones
2. Smash them together
```

Let the weights be `x` and `y` where `x ≤ y`:

```
If x == y → both stones are destroyed
If x != y → the stone with weight x is destroyed
             and the stone with weight y becomes (y - x)
```

Repeat this process until at most one stone remains.

Return the weight of the last remaining stone, or return `0` if none remain. :contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input
```
stones = [2,7,4,1,8,1]
```

Output
```
1
```

Explanation

```
Initial: [2,7,4,1,8,1]

Step 1:
8 and 7 → 1
[2,4,1,1,1]

Step 2:
4 and 2 → 2
[2,1,1,1]

Step 3:
2 and 1 → 1
[1,1,1]

Step 4:
1 and 1 → 0
[1]

Final:
1
``` 
:contentReference[oaicite:1]{index=1}

---

### Example 2

Input
```
stones = [1]
```

Output
```
1
```

Explanation

Only one stone exists, so return its weight.

---

# Key Idea

At every step, we need:

```
the two largest elements
```

Instead of sorting repeatedly, we use a:

```
Max Heap (Priority Queue)
```

This allows us to:

```
extract largest elements efficiently
```

The heap ensures we always access the two heaviest stones in:

```
O(log n)
```

---

# Intuition

Think of it like repeatedly removing the top 2 elements:

```
[2,7,4,1,8,1]

→ pick 8,7
→ insert 1
→ repeat
```

We only care about:

```
largest two stones each time
```

So a heap is perfect for this simulation.

---

# Strategy (Max Heap)

Steps:

```
1️⃣ Insert all stones into max heap

2️⃣ While heap size > 1
      remove top two stones

3️⃣ If they are not equal
      insert (difference)

4️⃣ If equal
      do nothing

5️⃣ Return remaining stone or 0
```

---

# Optimal Java Solution

```java
class Solution {

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones){
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1){

            int y = maxHeap.poll(); // largest
            int x = maxHeap.poll(); // second largest

            if(y != x){
                maxHeap.offer(y - x);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
```

---

# Dry Run

Input

```
stones = [2,7,4,1,8,1]
```

Heap state

```
[8,7,4,2,1,1]
```

Steps

```
Pop 8,7 → push 1
[4,2,1,1,1]

Pop 4,2 → push 2
[2,1,1,1]

Pop 2,1 → push 1
[1,1,1]

Pop 1,1 → destroyed
[1]
```

Final result

```
1
```

---

# Complexity Analysis

### Time Complexity

```
O(n log n)
```

Each insertion and removal from heap takes `O(log n)`, and we perform it multiple times. :contentReference[oaicite:2]{index=2}

---

### Space Complexity

```
O(n)
```

For storing elements in the heap. :contentReference[oaicite:3]{index=3}

---

# Key Tricks

### 1️⃣ Always pick two largest

```
Use max heap
```

---

### 2️⃣ Only push difference

```
if(y != x)
    push(y - x)
```

---

### 3️⃣ Ignore equal stones

```
both destroyed
```

---

# Pattern Recognition

This problem belongs to the **Heap / Priority Queue Pattern**.

Similar problems:

```
Kth Largest Element
Top K Frequent Elements
Find Median from Data Stream
K Closest Points to Origin
```

---

# Summary

Core idea:

```
Use max heap
Always pick top 2 elements
Simulate the process
Insert difference back
```

Final complexity:

```
Time  : O(n log n)
Space : O(n)
```

---

# Takeaway

Whenever a problem involves:

```
repeatedly removing largest elements
processing top k elements
dynamic ordering
```

Think immediately:

```
Heap (Priority Queue)
```

This makes such problems efficient and easy to simulate.


https://neetcode.io/problems/last-stone-weight/question?list=neetcode150

https://leetcode.com/problems/last-stone-weight/description/
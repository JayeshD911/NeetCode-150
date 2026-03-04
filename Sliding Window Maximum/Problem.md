# 239. Sliding Window Maximum

## 📌 Problem Statement

You are given an array of integers `nums` and an integer `k`.  
There is a sliding window of size `k` which moves from the very left of the array to the very right.  
At each step, the sliding window **moves one position to the right**.

Return an array of the **maximum values in each sliding window** as it moves. :contentReference[oaicite:0]{index=0}

---

## 🧪 Examples

### Example 1
```
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window positions and their maxima:
[1 3 -1] → 3
[3 -1 -3] → 3
[-1 -3 5] → 5
[-3 5 3] → 5
[5 3 6] → 6
[3 6 7] → 7
```
📌 Each sliding window has size 3 and we slide one step at a time. :contentReference[oaicite:1]{index=1}

### Example 2
```
Input: nums = [1], k = 1
Output: [1]
```
📌 Only one window possible. :contentReference[oaicite:2]{index=2}

---

## 📏 Constraints

- `1 <= nums.length <= 10^5`
- `-10^4 <= nums[i] <= 10^4`
- `1 <= k <= nums.length` :contentReference[oaicite:3]{index=3}

---

## 💡 Intuition

We need the **maximum element** for every contiguous subarray of length `k`.  
A naive approach checks every window and recomputes the maximum → **too slow** for large `n`. :contentReference[oaicite:4]{index=4}

To achieve **efficient performance**, use a data structure that:

- Tracks potential maximum candidates
- Allows removal of expired elements (no longer in the window)
- Retrieves the largest element quickly

A **deque (double-ended queue)** can be used to maintain elements in **decreasing order**, enabling O(n) time. :contentReference[oaicite:5]{index=5}

---

## 🚀 Optimal Approach — Monotonic Deque (O(n) time)

### 🧠 Key Idea

Maintain a **deque of indices** such that:

1. The values corresponding to these indices are in **decreasing order**.
2. The **front** of the deque is always the index of the maximum element in the current window.
3. Before adding a new index:
    - Remove indices from back whose values are smaller than the new element.
    - Remove the index at front if it is outside the current window (`i - k`). :contentReference[oaicite:6]{index=6}

This ensures each element enters and leaves the deque **at most once** → O(n) total. :contentReference[oaicite:7]{index=7}

---

## 💻 Java Implementation

```java
import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            // 1) Remove indices out of this window
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }

            // 2) Pop smaller elements from back
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // 3) Add current index
            dq.offerLast(i);

            // 4) Start adding to result once window has k elements
            if (i >= k - 1) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return result;
    }
}
```

---

## 🧠 Why This Works

- The deque maintains candidates **in descending order** of their values.
- The **front** is always the maximum for the current window.
- Out-of-bounds indices (older than `i-k+1`) are removed from the front.
- Smaller values than the current are removed from the back — they can never be max while larger values remain. :contentReference[oaicite:8]{index=8}

---

## 🧪 Example Walk-Through

Given `nums = [1,3,-1,-3,5,3,6,7]`, `k = 3`:

| i | dq (indices w/ values) | max |
|---|------------------------|-----|
| 0 | [0:1]                  | —   |
| 1 | [1:3]                  | —   |
| 2 | [1:3,2:-1]             | 3   |
| 3 | [1:3,2:-1,3:-3]        | 3   |
| 4 | [4:5]                  | 5   |
| 5 | [4:5,5:3]              | 5   |
| 6 | [6:6]                  | 6   |
| 7 | [7:7]                  | 7   |

Result: `[3,3,5,5,6,7]` — the maximum at each window position. :contentReference[oaicite:9]{index=9}

---

## 📊 Complexity

| Approach | Time | Space |
|----------|------|-------|
| Brute Force | O(n * k) | O(1) |
| Max-Heap / Priority Queue | O(n log k) | O(k) |
| Monotonic Deque | **O(n)** | **O(k)** |

The deque method is optimal when both time and space are considered. :contentReference[oaicite:10]{index=10}

---

## 🤔 Interview Tips

1. Recognize this as a **fixed sliding-window** problem.
2. Understand why **deque** maintains a maximum in O(1) per operation.
3. Always remove **out-of-range indices** (older than `i-k+1`) from the front.
4. To optimize, always discard smaller values from the back — they can never be future maxima.

---

https://neetcode.io/problems/sliding-window-maximum/question?list=neetcode150

https://leetcode.com/problems/sliding-window-maximum/description/
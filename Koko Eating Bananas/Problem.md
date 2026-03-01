# 🟡 875. Koko Eating Bananas

## 📌 Problem Statement

Koko loves eating bananas. There are `n` piles of bananas, where the `i`-th pile contains `piles[i]` bananas. The guards will return in `h` hours, and Koko wants to finish eating all the bananas **before that time**.:contentReference[oaicite:0]{index=0}

Each hour, Koko chooses a pile and eats up to `k` bananas from it:
- If the pile has at least `k` bananas, she eats **exactly `k`** bananas.
- If the pile has fewer than `k` bananas, she eats the entire pile in that hour.:contentReference[oaicite:1]{index=1}

Return the **minimum integer `k`** (bananas per hour) such that Koko can finish all the piles within `h` hours.:contentReference[oaicite:2]{index=2}

---

## 🧾 Examples

### Example 1
```
Input:  piles = [3,6,7,11], h = 8
Output: 4
```

### Example 2
```
Input:  piles = [30,11,23,4,20], h = 5
Output: 30
```

### Example 3
```
Input:  piles = [30,11,23,4,20], h = 6
Output: 23
```

---

## 🔒 Constraints

- `1 <= piles.length <= 10^4`
- `piles.length <= h <= 10^9`
- `1 <= piles[i] <= 10^9`:contentReference[oaicite:3]{index=3}

---

# 🚀 Approach 1: Brute Force (Try Every Speed)

## 💡 Idea

Try every possible eating speed `k` from `1` up to the size of the largest pile.  
For each `k`, simulate eating all piles and compute the total hours required.

The first `k` that allows finishing within `h` hours is the answer.

---

## 🧑‍💻 Python Code

```python
class Solution:
    def minEatingSpeed(self, piles: list[int], h: int) -> int:
        max_pile = max(piles)
        
        for k in range(1, max_pile + 1):
            hours = 0
            for pile in piles:
                hours += (pile + k - 1) // k  # ceil(pile/k)
            
            if hours <= h:
                return k
```

---

## ⏱ Complexity

- Time: **O(n * m)** where `m = max(piles)`
- Space: **O(1)**

⚠️ Too slow for large values of `piles[i]` (up to 10⁹).:contentReference[oaicite:4]{index=4}

---

# 🚀 Approach 2: Optimal Solution (Binary Search) ✅

## 💡 Key Insight

If Koko can finish all bananas with speed `k`, then she can definitely finish with any speed **greater than `k`**.  
This is a **monotonic property** → Binary Search applies.:contentReference[oaicite:5]{index=5}

- Lower bound of speed = `1`
- Upper bound = `max(piles)` (no benefit to faster than largest pile):contentReference[oaicite:6]{index=6}

---

## 🧠 Algorithm

1. Set `left = 1`, `right = max(piles)`.
2. While `left < right`:
    - Compute `mid = (left + right) // 2`
    - Check if Koko can finish in time at speed `mid`
    - If yes → move `right = mid`
    - Otherwise → `left = mid + 1`
3. Return `left` (minimum valid speed).

Helper (`can_finish`) calculates total hours needed:
```
hours += (pile + k - 1) // k
```
This is the ceiling of `pile / k`.:contentReference[oaicite:7]{index=7}

---

## 🧑‍💻 Python Code

```python
class Solution:
    def minEatingSpeed(self, piles: list[int], h: int) -> int:
        
        def can_finish(k: int) -> bool:
            hours = 0
            for pile in piles:
                # Ceil division: (pile + k - 1) // k
                hours += (pile + k - 1) // k
            return hours <= h
        
        left, right = 1, max(piles)
        
        while left < right:
            mid = (left + right) // 2
            if can_finish(mid):
                right = mid
            else:
                left = mid + 1
        
        return left
```

---

## ⏱ Complexity (Optimal)

| Metric        | Value |
|---------------|-------|
| **Time**      | O(n · log m) |
| **Space**     | O(1) |

Where `n = number of piles`, `m = max(piles)`.:contentReference[oaicite:8]{index=8}

---

# 📚 Key Takeaways

- Brute force tries all speeds → too slow for large values.
- Binary search efficiently finds minimum valid eating speed.
- Use ceiling division for hours needed: `(pile + k - 1) // k`.

---

# 📅 Daily LeetCode Log

- Day: XX
- Topic: Binary Search on Answer
- Difficulty: Medium
- Language: Python

---

If you’d like, I can also generate a **visual walkthrough**, **best commit message**, or a **folder template** for your repository! 🚀
::contentReference[oaicite:9]{index=9}


https://neetcode.io/problems/eating-bananas/question

https://leetcode.com/problems/koko-eating-bananas/
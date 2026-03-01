# 📈 121. Best Time to Buy and Sell Stock

## 📌 Problem Statement

You are given an array `prices` where `prices[i]` is the price of a given stock on the *i-th* day.

You want to maximize your profit by choosing a **single day to buy one stock** and a **different future day to sell that stock**.

Return *the maximum profit you can achieve from this transaction*.  
If you cannot achieve any profit, return `0`.

---

## 🧾 Examples

### Example 1
```
Input: prices = [7,1,5,3,6,4]
Output: 5
```
**Explanation:**  
Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6 − 1 = 5.

---

### Example 2
```
Input: prices = [7,6,4,3,1]
Output: 0
```
**Explanation:**  
Prices keep falling, so no profitable trade is possible.

---

### Example 3
```
Input: prices = [1,2,3,4,5]
Output: 4
```
**Explanation:**  
Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5 − 1 = 4.

---

## 🔒 Constraints

- `1 <= prices.length <= 10^5`
- `0 <= prices[i] <= 10^4`

---

# 🚀 Optimal Approach: One Pass (Sliding Window)

## 💡 Key Insight

To maximize profit:
- We want to **buy at the lowest price before a higher selling price**.
- We only need to track the **minimum price so far** and compute profit as we go.

So at each day:
1. Update the lowest price seen
2. Compute profit if we sold today
3. Update maximum profit

No need for nested loops.

---

## 🧑‍💻 Python Code

```python
class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        min_price = float("inf")
        max_profit = 0

        for price in prices:
            if price < min_price:
                min_price = price
            elif price - min_price > max_profit:
                max_profit = price - min_price

        return max_profit
```

---

## ⏱ Complexity

| Metric | Value |
|--------|-------|
| Time   | **O(n)** |
| Space  | **O(1)** |

You process the list only once using constant extra space.

---

# 🧠 Visual Example

```
Prices: [7, 1, 5, 3, 6, 4]

min_price = +∞
max_profit = 0

Day 1 → price = 7
min_price = 7
profit = 0

Day 2 → price = 1
min_price = 1

Day 3 → price = 5
profit = 5 − 1 = 4
max_profit = 4

Day 4 → price = 3
profit = 3 − 1 = 2

Day 5 → price = 6
profit = 6 − 1 = 5
max_profit = 5

Day 6 → price = 4
profit < max_profit
```

Final answer = 5

---

# 🧠 Why This Works

- You never go back in time — future prices can only be compared to the lowest price so far.
- Since profit is only realized when selling after buying, we ensure `sell_index > buy_index`.

---

# 📅 Variation & Follow-Up

This approach is also foundational for:

- 🐂 Best Time to Buy & Sell Stock II (multiple transactions)
- 🎯 Best Time to Buy & Sell Stock with Cooldown
- 💰 With Transaction Fee
- 📅 With K Transactions

Once you master this one, the others build on it.

---

## 📅 Daily LeetCode Log

- Day: XX
- Topic: Array / Sliding Window
- Difficulty: Easy
- Language: Python

---


https://neetcode.io/problems/buy-and-sell-crypto/question

https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
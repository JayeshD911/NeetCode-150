# 322. Coin Change

## 🟡 Difficulty
Medium

## 🔗 Problem Link
https://leetcode.com/problems/coin-change/

---------------------

## 📝 Problem Statement

You are given an integer array `coins` representing different coin denominations and an integer `amount`.

Return the **fewest number of coins** needed to make up that amount. If it is not possible, return `-1`.

You may assume that you have an **infinite number of each coin**. :contentReference[oaicite:0]{index=0}

---------------------

## 📥 Examples

### Example 1
Input: coins = [1,2,5], amount = 11  
Output: 3  
Explanation: 11 = 5 + 5 + 1

### Example 2
Input: coins = [2], amount = 3  
Output: -1

### Example 3
Input: coins = [1], amount = 0  
Output: 0

---------------------

## ⚙️ Constraints

- 1 ≤ coins.length ≤ 12
- 1 ≤ coins[i] ≤ 2³¹ - 1
- 0 ≤ amount ≤ 10⁴ :contentReference[oaicite:1]{index=1}

---------------------

## 💡 Key Idea

- This is a **Dynamic Programming (Unbounded Knapsack)** problem
- We want the **minimum number of coins** to reach a target
- Greedy does **not always work** for arbitrary coin systems

---------------------

## 🧠 Approach 1: Bottom-Up DP (Most Important)

- Let `dp[i]` = minimum coins needed to make amount `i`
- Initialize:
    - `dp[0] = 0`
    - rest = `amount + 1` (infinity)
- Transition:
    - For each coin:
        - `dp[i] = min(dp[i], dp[i - coin] + 1)`

---------------------

## 🚀 Code (Bottom-Up DP - Java)

class Solution {
public int coinChange(int[] coins, int amount) {
int[] dp = new int[amount + 1];

        // Initialize with max value
        for (int i = 0; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        
        dp[0] = 0;
        
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

---------------------

## 🧠 Approach 2: Top-Down (Memoization)

- Recursively try all coins
- Store results to avoid recomputation

---------------------

## 🚀 Code (Top-Down DP - Java)

import java.util.Arrays;

class Solution {
public int coinChange(int[] coins, int amount) {
int[] memo = new int[amount + 1];
Arrays.fill(memo, -2); // -2 means unvisited

        return dfs(coins, amount, memo);
    }
    
    private int dfs(int[] coins, int amount, int[] memo) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        
        if (memo[amount] != -2) return memo[amount];
        
        int min = Integer.MAX_VALUE;
        
        for (int coin : coins) {
            int res = dfs(coins, amount - coin, memo);
            if (res >= 0) {
                min = Math.min(min, res + 1);
            }
        }
        
        memo[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return memo[amount];
    }
}

---------------------

## 🧠 Approach 3: BFS (Level = Coins Used)

- Treat amount as node
- Each step subtract coin → new node
- First time reaching 0 → answer

---------------------

## 🚀 Code (BFS - Java)

import java.util.*;

class Solution {
public int coinChange(int[] coins, int amount) {
Queue<Integer> queue = new LinkedList<>();
boolean[] visited = new boolean[amount + 1];

        queue.add(amount);
        visited[amount] = true;
        
        int level = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                
                for (int coin : coins) {
                    int next = curr - coin;
                    
                    if (next == 0) return level;
                    if (next < 0 || visited[next]) continue;
                    
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        
        return -1;
    }
}

---------------------

## ⏱️ Complexity

| Approach | Time | Space |
|---------|------|------|
| Bottom-Up DP | O(n × amount) | O(amount) |
| Top-Down DP | O(n × amount) | O(amount) |
| BFS | O(n × amount) | O(amount) |

---------------------

## ⚠️ Edge Cases

- amount = 0 → return 0
- No combination possible → return -1
- coins = [1] → always possible
- Large amount → DP required (greedy fails)

---------------------

## 🧩 Tags

- Dynamic Programming
- Array
- BFS
- Unbounded Knapsack

---------------------

## 🏁 Summary

- Classic **DP problem**
- Best approach: **Bottom-Up DP**
- State: `dp[i] = min coins for amount i`
- Transition: try every coin

---------------------

https://neetcode.io/problems/coin-change/

https://leetcode.com/problems/coin-change/
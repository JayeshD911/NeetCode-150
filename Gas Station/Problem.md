# 134. Gas Station

🔗 Problem: https://leetcode.com/problems/gas-station/

---

# Problem

There are `n` gas stations along a circular route.

You are given two arrays:

```
gas[i]  → amount of gas at station i
cost[i] → gas required to travel from i to (i+1)
```

You have:

```
infinite gas tank (initially empty)
```

Return:

```
Starting index if you can travel around the circuit once
Otherwise return -1
```

If a solution exists, it is **guaranteed to be unique**.

---

# Example

### Example 1

Input
```
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]
```

Output
```
3
```

Explanation

```
Start at index 3:

Tank = 0

Station 3 → +4 -1 = 3
Station 4 → +5 -2 = 6
Station 0 → +1 -3 = 4
Station 1 → +2 -4 = 2
Station 2 → +3 -5 = 0

Completed full circle → valid
```

---

### Example 2

Input
```
gas  = [2,3,4]
cost = [3,4,3]
```

Output
```
-1
```

Explanation

```
Total gas < total cost → impossible
```

---

# Key Idea

Two key observations:

### 1️⃣ Feasibility condition

```
If total gas < total cost → answer = -1
```

---

### 2️⃣ Greedy insight

If starting at index `i` fails at `j`, then:

```
Any index between i and j cannot be a valid start
```

So we can:

```
Skip all those indices
```

---

# Intuition

We track:

```
tank = current gas
```

While iterating:

```
If tank becomes negative
→ we cannot start from current start
→ move start to next index
→ reset tank
```

---

# Strategy (Greedy)

Steps:

```
1️⃣ Track totalGas and totalCost

2️⃣ If totalGas < totalCost → return -1

3️⃣ Initialize:
      tank = 0
      start = 0

4️⃣ Traverse all stations:

      tank += gas[i] - cost[i]

      If tank < 0:
            start = i + 1
            tank = 0

5️⃣ Return start
```

---

# Optimal Java Solution

```java
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;
        int totalCost = 0;

        for(int i = 0; i < gas.length; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if(totalGas < totalCost){
            return -1;
        }

        int tank = 0;
        int start = 0;

        for(int i = 0; i < gas.length; i++){

            tank += gas[i] - cost[i];

            if(tank < 0){
                start = i + 1;
                tank = 0;
            }
        }

        return start;
    }
}
```

---

# Dry Run

Input

```
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]
```

Steps

```
i = 0 → tank = 1-3 = -2 → reset start = 1

i = 1 → tank = 2-4 = -2 → reset start = 2

i = 2 → tank = 3-5 = -2 → reset start = 3

i = 3 → tank = 4-1 = 3

i = 4 → tank = 3 + (5-2) = 6

Continue circular → valid
```

Result

```
start = 3
```

---

# Complexity Analysis

### Time Complexity

```
O(n)
```

Single pass through array.

---

### Space Complexity

```
O(1)
```

No extra space used.

---

# Key Tricks

### 1️⃣ Check feasibility first

```
totalGas >= totalCost
```

---

### 2️⃣ Reset when tank < 0

```
start = i + 1
tank = 0
```

---

### 3️⃣ Skip invalid starting points

```
No need to recheck them
```

---

# Pattern Recognition

This problem belongs to:

```
Greedy + Circular Array Pattern
```

Similar problems:

```
Jump Game
Kadane’s Algorithm (prefix reasoning)
Maximum Subarray
```

---

# Summary

Core idea:

```
Check if solution exists
Track current tank
Reset start when tank becomes negative
Return final start index
```

Final complexity:

```
Time  : O(n)
Space : O(1)
```

---

# Takeaway

Whenever you see:

```
circular traversal
minimum starting point
feasibility with prefix sums
```

Think immediately:

```
Greedy + Reset on failure
```

Because:

```
Failure eliminates multiple starting points at once
```


https://neetcode.io/problems/gas-station/question

https://leetcode.com/problems/gas-station/
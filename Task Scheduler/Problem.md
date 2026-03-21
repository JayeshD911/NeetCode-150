# 621. Task Scheduler

🔗 Problem: https://leetcode.com/problems/task-scheduler/

---

# Problem

You are given an array of CPU tasks, where each task is represented by a character from `'A'` to `'Z'`, and an integer `n` representing the **cooldown period**.

Rules:

```
1. Each task takes 1 unit of time
2. Same tasks must be separated by at least n intervals
3. CPU can either execute a task or stay idle
```

Return the **minimum number of intervals** required to complete all tasks. :contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input
```
tasks = ["A","A","A","B","B","B"]
n = 2
```

Output
```
8
```

Explanation

```
We must keep at least 2 intervals between same tasks.
```

One optimal schedule:

```
A → B → idle → A → B → idle → A → B
```

Total intervals:

```
8
```

---

### Example 2

Input
```
tasks = ["A","C","A","B","D","B"]
n = 1
```

Output
```
6
```

Explanation

```
A → B → C → D → A → B
```

No idle time needed.

---

### Example 3

Input
```
tasks = ["A","A","A","B","B","B"]
n = 3
```

Output
```
10
```

Explanation

```
A → B → idle → idle → A → B → idle → idle → A → B
```

---

# Key Idea

The most important observation:

```
The task with highest frequency determines the schedule.
```

Because:

```
It creates the maximum number of required gaps (cooldown spaces)
``` 
:contentReference[oaicite:1]{index=1}

---

# Intuition

Example:

```
tasks = [A,A,A,B,B,C]
n = 2
```

Count frequencies:

```
A → 3
B → 2
C → 1
```

Place most frequent task first:

```
A _ _ A _ _ A
```

Now fill the gaps:

```
A B C A B _ A
```

Remaining empty slot → idle

Final length:

```
7
```

---

# Strategy (Greedy + Math)

Steps:

```
1️⃣ Count frequency of all tasks

2️⃣ Find:
      maxFreq = maximum frequency
      countMax = number of tasks with maxFreq

3️⃣ Apply formula:
```

```
(min intervals) = (maxFreq - 1) * (n + 1) + countMax
```

```
4️⃣ Final answer:
      max(total tasks, formula result)
```

Why max?

```
If enough tasks exist → no idle needed
Otherwise → idle slots required
``` 
:contentReference[oaicite:2]{index=2}

---

# Optimal Java Solution

```java
class Solution {

    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for(char c : tasks){
            freq[c - 'A']++;
        }

        int maxFreq = 0;

        for(int f : freq){
            maxFreq = Math.max(maxFreq, f);
        }

        int countMax = 0;

        for(int f : freq){
            if(f == maxFreq) countMax++;
        }

        int result = (maxFreq - 1) * (n + 1) + countMax;

        return Math.max(tasks.length, result);
    }
}
```

---

# Dry Run

Input

```
tasks = ["A","A","A","B","B","C"]
n = 2
```

Step 1: Frequency

```
A = 3
B = 2
C = 1
```

Step 2:

```
maxFreq = 3
countMax = 1
```

Step 3:

```
(3 - 1) * (2 + 1) + 1
= 2 * 3 + 1
= 7
```

Step 4:

```
max(6, 7) = 7
```

Final Answer

```
7
```

---

# Complexity Analysis

### Time Complexity

```
O(n)
```

Where:

```
n = number of tasks
```

Only counting and iteration over fixed 26 letters. :contentReference[oaicite:3]{index=3}

---

### Space Complexity

```
O(1)
```

Frequency array size is constant (26 letters).

---

# Key Tricks

### 1️⃣ Focus on most frequent task

```
It dictates idle slots
```

---

### 2️⃣ Use formula instead of simulation

```
Avoid complex scheduling
```

---

### 3️⃣ Handle multiple max frequency tasks

```
+ countMax at end
```

---

# Pattern Recognition

This problem belongs to:

```
Greedy + Frequency Counting + Math Pattern
```

Similar problems:

```
Reorganize String
Top K Frequent Elements
Task Scheduling Variants
```

---

# Summary

Core idea:

```
Most frequent task creates structure
Fill remaining slots with other tasks
Use formula to compute minimum intervals
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
cooldown constraints
task scheduling
minimum time
```

Think immediately:

```
Greedy + Frequency + Formula
```

Because simulation is slow, but math gives direct answer.


https://neetcode.io/problems/task-scheduling/question?list=neetcode150

https://leetcode.com/problems/task-scheduler/description/
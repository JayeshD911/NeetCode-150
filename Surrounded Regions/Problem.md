# 130. Surrounded Regions

🔗 Problem: https://leetcode.com/problems/surrounded-regions/

---

# Problem

You are given an `m x n` board containing:

```
'X' and 'O'
```

Capture all regions surrounded by `'X'`.

A region is captured if:

```
All 'O's in that region are completely surrounded by 'X'
```

Rules:

```
• Connected = up, down, left, right
• Border-connected 'O' → cannot be captured
• Modify board in-place
``` 
:contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input
```
board = [
  ["X","X","X","X"],
  ["X","O","O","X"],
  ["X","X","O","X"],
  ["X","O","X","X"]
]
```

Output
```
[
  ["X","X","X","X"],
  ["X","X","X","X"],
  ["X","X","X","X"],
  ["X","O","X","X"]
]
```

Explanation

```
Middle region of 'O's is surrounded → convert to 'X'
Bottom 'O' touches border → remains 'O'
```

---

### Example 2

Input
```
board = [["X"]]
```

Output
```
[["X"]]
```

---

# Key Idea

Instead of finding surrounded regions directly:

```
Find NON-surrounded regions
```

Observation:

```
Any 'O' connected to border cannot be surrounded
```

So:

```
Start from border 'O's → mark all reachable 'O's
```

Remaining `'O'`:

```
must be surrounded → convert to 'X'
``` 
:contentReference[oaicite:1]{index=1}

---

# Intuition

Think of water flowing from the border:

```
All 'O's reachable from border are safe
```

Everything else:

```
is enclosed → should be flipped
```

So:

```
Mark safe regions first
Then flip the rest
```

---

# Strategy (DFS from Boundary)

Steps:

```
1️⃣ Traverse all border cells

2️⃣ If border cell == 'O':
      run DFS and mark as 'T' (temporary safe)

3️⃣ After DFS:
      • Convert remaining 'O' → 'X'
      • Convert 'T' → 'O'
```

---

# Optimal Java Solution

```java
class Solution {
    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        // Step 1: mark border-connected 'O's
        for(int i = 0; i < m; i++){
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        for(int j = 0; j < n; j++){
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }

        // Step 2: flip and restore
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int r, int c){

        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O'){
            return;
        }

        board[r][c] = 'T';

        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}
```

---

# Dry Run

Input

```
X X X X
X O O X
X X O X
X O X X
```

### Step 1: Mark border-connected 'O'

```
Only (3,1) is border-connected
→ mark as 'T'
```

Board becomes:

```
X X X X
X O O X
X X O X
X T X X
```

---

### Step 2: Flip remaining 'O'

```
All middle 'O's → 'X'
'T' → 'O'
```

Final:

```
X X X X
X X X X
X X X X
X O X X
```

---

# Complexity Analysis

### Time Complexity

```
O(m * n)
```

Each cell is visited once. :contentReference[oaicite:2]{index=2}

---

### Space Complexity

```
O(m * n)
```

Due to recursion stack (DFS).

---

# Key Tricks

### 1️⃣ Reverse thinking

```
Mark what to keep, not what to remove
```

---

### 2️⃣ Start from borders

```
Only border-connected 'O' survive
```

---

### 3️⃣ Use temporary marker

```
'O' → 'T' → 'O'
```

---

# Pattern Recognition

This problem belongs to:

```
Grid DFS + Boundary Traversal Pattern
```

Similar problems:

```
Number of Islands
Pacific Atlantic Water Flow
Flood Fill
Rotting Oranges
```

---

# Summary

Core idea:

```
Mark all border-connected 'O's
Flip remaining 'O's to 'X'
Restore safe cells
```

---

# Takeaway

Whenever you see:

```
capture surrounded region
boundary condition matters
```

Think immediately:

```
Reverse DFS from boundary
```

Because:

```
It's easier to find safe cells than surrounded ones
```

https://neetcode.io/problems/surrounded-regions/question

https://leetcode.com/problems/surrounded-regions/
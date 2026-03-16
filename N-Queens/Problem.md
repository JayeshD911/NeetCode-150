# 51. N-Queens

🔗 Problem: https://leetcode.com/problems/n-queens/

---

# Problem

The **N-Queens puzzle** asks us to place `n` queens on an `n × n` chessboard such that **no two queens attack each other**. A queen attacks along its **row, column, and diagonals**, so no two queens can share any of those lines. :contentReference[oaicite:0]{index=0}

Given an integer `n`, return **all distinct solutions** to the puzzle.

Each solution represents a board configuration using:

```
'Q' → queen
'.' → empty space
```

---

# Example

### Example 1

Input

```
n = 4
```

Output

```
[
 [".Q..",
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",
  "Q...",
  "...Q",
  ".Q.."]
]
```

---

### Example 2

Input

```
n = 1
```

Output

```
[["Q"]]
```

---

# Key Idea

This is a **Backtracking problem**.

We place queens **row by row**.

For each row we try placing a queen in every column that is **not attacked by previous queens**. If a position is valid, we place the queen and move to the next row. If we reach a row where no column works, we **backtrack and try another placement**. :contentReference[oaicite:1]{index=1}

---

# Constraints

A queen cannot attack another queen:

```
Same column
Same main diagonal
Same anti-diagonal
```

So we track three arrays:

```
column[j]        → column used
diag[row+col]    → main diagonal used
antiDiag[row-col+n]
```

---

# Intuition

Example:

```
n = 4
```

Board exploration:

```
Row 0
├─ place queen col 0
│
Row 1
├─ col 0 ❌
├─ col 1 ❌
├─ col 2 ✔
│
Row 2
├─ try placements...
```

Recursion tree explores **all valid placements**.

---

# Backtracking Strategy

Steps:

```
1. Place queens row by row
2. For each row try all columns
3. Check if column and diagonals are safe
4. Place queen
5. Recurse to next row
6. Remove queen (backtrack)
```

---

# Java Solution

```java
class Solution {

    public void solve(int row,
                      int n,
                      char[][] board,
                      List<List<String>> ans,
                      boolean[] col,
                      boolean[] diag,
                      boolean[] antiDiag){

        if(row == n){

            List<String> solution = new ArrayList<>();

            for(char[] r : board)
                solution.add(new String(r));

            ans.add(solution);

            return;
        }

        for(int c = 0; c < n; c++){

            if(col[c] || diag[row + c] || antiDiag[row - c + n])
                continue;

            board[row][c] = 'Q';
            col[c] = true;
            diag[row + c] = true;
            antiDiag[row - c + n] = true;

            solve(row + 1, n, board, ans, col, diag, antiDiag);

            board[row][c] = '.';
            col[c] = false;
            diag[row + c] = false;
            antiDiag[row - c + n] = false;
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        for(char[] row : board)
            Arrays.fill(row, '.');

        solve(0,
              n,
              board,
              ans,
              new boolean[n],
              new boolean[2*n],
              new boolean[2*n]);

        return ans;
    }
}
```

---

# Dry Run

For `n = 4`

Board starts empty:

```
....
....
....
....
```

First solution:

```
.Q..
...Q
Q...
..Q.
```

Second solution:

```
..Q.
Q...
...Q
.Q..
```

---

# Complexity Analysis

### Time Complexity

```
O(N!)
```

In the worst case we try placing queens in different columns across rows, producing a factorial search tree.

---

### Space Complexity

```
O(N)
```

For recursion stack and helper arrays.

---

# Pattern Recognition

This problem belongs to the **Backtracking / Constraint Satisfaction** category. Backtracking incrementally builds candidate solutions and abandons partial configurations that violate constraints. :contentReference[oaicite:2]{index=2}

Similar problems:

```
Generate Parentheses
Combination Sum
Palindrome Partitioning
Word Search
Sudoku Solver
```

---

# Summary

Core idea:

```
Place queens row by row
Ensure column and diagonals are safe
Use backtracking to explore placements
Store valid boards
```

---

# Takeaway

Whenever a problem asks for:

```
placing objects with constraints
all valid board configurations
```

Think:

```
Backtracking + pruning
```
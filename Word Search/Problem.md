# 79. Word Search

🔗 Problem: https://leetcode.com/problems/word-search/

---

# Problem

Given an `m x n` grid of characters `board` and a string `word`, return **true** if the word exists in the grid. :contentReference[oaicite:0]{index=0}

The word can be constructed from letters of **sequentially adjacent cells**, where adjacent cells are **horizontally or vertically neighboring**.  
The **same cell cannot be used more than once** in the same path. :contentReference[oaicite:1]{index=1}

---

# Example

### Example 1

Input

```
board =
[
["A","B","C","E"],
["S","F","C","S"],
["A","D","E","E"]
]

word = "ABCCED"
```

Output

```
true
```

---

### Example 2

Input

```
board =
[
["A","B","C","E"],
["S","F","C","S"],
["A","D","E","E"]
]

word = "SEE"
```

Output

```
true
```

---

### Example 3

Input

```
board =
[
["A","B","C","E"],
["S","F","C","S"],
["A","D","E","E"]
]

word = "ABCB"
```

Output

```
false
```

---

# Key Idea

This is a **DFS + Backtracking** problem.

Strategy:

```
Start DFS from every cell
Try to match characters sequentially
Move in 4 directions
Mark cell as visited
Backtrack if path fails
```

We explore the board **depth-first**, and when a path doesn't match the word, we **backtrack and try another path**. :contentReference[oaicite:2]{index=2}

---

# Intuition

For example:

```
board =
A B C
D E F
G H I

word = "ABE"
```

Possible path:

```
A → B → E
```

Recursion tree:

```
A
├─ B
│  ├─ C
│  └─ E
└─ D
```

If a path fails, we **restore the cell and try another direction**.

---

# Backtracking Strategy

Steps:

```
1️⃣ Start DFS from each cell
2️⃣ Check if board[i][j] matches word[index]
3️⃣ Mark cell as visited
4️⃣ Explore 4 directions
5️⃣ Restore the cell (backtrack)
```

---

# Java Solution

```java
class Solution {

    public boolean dfs(char[][] board,
                       int r,
                       int c,
                       String word,
                       int index){

        if(index == word.length()) return true;

        if(r < 0 || c < 0 ||
           r >= board.length ||
           c >= board[0].length ||
           board[r][c] != word.charAt(index))
            return false;

        char temp = board[r][c];
        board[r][c] = '#';

        boolean found =
                dfs(board, r+1, c, word, index+1) ||
                dfs(board, r-1, c, word, index+1) ||
                dfs(board, r, c+1, word, index+1) ||
                dfs(board, r, c-1, word, index+1);

        board[r][c] = temp;

        return found;
    }

    public boolean exist(char[][] board, String word) {

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){

                if(dfs(board, i, j, word, 0))
                    return true;

            }
        }

        return false;
    }
}
```

---

# Dry Run

Input

```
board =
A B C E
S F C S
A D E E

word = "ABCCED"
```

Path explored:

```
A → B → C → C → E → D
```

Steps:

```
start (0,0) = A
→ (0,1) = B
→ (0,2) = C
→ (1,2) = C
→ (2,2) = E
→ (2,1) = D
```

Word found → return **true**

---

# Complexity Analysis

### Time Complexity

```
O(M × N × 4^L)
```

Where:

```
M = rows
N = columns
L = length of word
```

Each cell can start a DFS and explore up to 4 directions.

---

### Space Complexity

```
O(L)
```

For recursion stack depth.

---

# Key Tricks

### 1️⃣ Mark visited cells

```
board[r][c] = '#'
```

Prevents reusing the same cell.

---

### 2️⃣ Restore during backtracking

```
board[r][c] = original value
```

Allows other paths to reuse the cell.

---

### 3️⃣ Explore 4 directions

```
up
down
left
right
```

---

# Pattern Recognition

This problem belongs to the **DFS / Backtracking on Grid** pattern.

Similar problems:

```
Word Search II
Number of Islands
Surrounded Regions
Pacific Atlantic Water Flow
N-Queens
```

---

# Summary

Core ideas:

```
DFS from each cell
Match characters sequentially
Mark cells visited
Backtrack when path fails
```

Final complexity:

```
Time  : O(M × N × 4^L)
Space : O(L)
```

---

# Takeaway

Whenever a problem asks for:

```
search word in grid
path in matrix
explore neighbors
```

Think immediately:

```
DFS + Backtracking
```

https://neetcode.io/problems/search-for-word/question?list=neetcode150

https://leetcode.com/problems/word-search/description/
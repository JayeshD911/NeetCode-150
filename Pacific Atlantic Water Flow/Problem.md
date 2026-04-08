# 417. Pacific Atlantic Water Flow

🔗 Problem: https://leetcode.com/problems/pacific-atlantic-water-flow/

---

# Problem

There is an `m x n` rectangular island that borders:

```
Pacific Ocean  → touches top and left edges
Atlantic Ocean → touches bottom and right edges
```

You are given an integer matrix `heights` where:

```
heights[r][c] = height of cell (r, c)
```

Water can flow from a cell to a neighboring cell if:

```
neighbor height <= current height
```

That means water flows:

```
from higher or equal height → lower or equal height
```

Return a list of grid coordinates where water can flow to:

```
both the Pacific and Atlantic oceans
```

You may return the answer in any order.

---

# Example

### Example 1

Input
```
heights = [
  [1,2,2,3,5],
  [3,2,3,4,4],
  [2,4,5,3,1],
  [6,7,1,4,5],
  [5,1,1,2,4]
]
```

Output
```
[[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
```

Explanation

A cell is valid if water from that cell can eventually reach:

```
Pacific  → top or left edge
Atlantic → bottom or right edge
```

Example:

```
Cell (0,4) = 5
It already touches top edge → Pacific
It already touches right edge → Atlantic
So it can reach both oceans
```

Another example:

```
Cell (2,2) = 5

Water can flow:
5 → 4 → 3 → ... toward Pacific
and
5 → 3 → 1 → ... toward Atlantic
```

So `(2,2)` is also included.

---

### Example 2

Input
```
heights = [[1]]
```

Output
```
[[0,0]]
```

Explanation

There is only one cell, and it touches all borders:

```
top, left, bottom, right
```

So it can reach both oceans.

---

# Key Idea

Brute force approach would be:

```
Start DFS/BFS from every cell
Check if it can reach Pacific
Check if it can reach Atlantic
```

That would be expensive.

Better idea:

```
Reverse the flow
```

Instead of asking:

```
Can this cell flow to ocean?
```

Ask:

```
From the ocean, which cells can reach inward?
```

This is the trick.

If water normally flows:

```
high → low
```

Then reverse traversal goes:

```
low → high
```

So from ocean borders, we move to neighbors with:

```
neighbor height >= current height
```

---

# Intuition

Think backward.

For Pacific:

```
Start from all cells on top row and left column
Move inward only if next cell is higher or equal
```

Why?

Because if ocean can reach that cell in reverse, then that cell can flow to the ocean in forward direction.

Do the same for Atlantic:

```
Start from bottom row and right column
```

At the end:

```
Cells visited by both searches are the answer
```

---

# Strategy (Reverse DFS / BFS)

Steps:

```
1️⃣ Create two visited sets / matrices:
      pacific
      atlantic

2️⃣ Start DFS/BFS from Pacific borders:
      top row + left column

3️⃣ Start DFS/BFS from Atlantic borders:
      bottom row + right column

4️⃣ During traversal:
      move only if next cell height >= current height

5️⃣ Find cells reachable in both visited matrices
```

This is much faster than starting from every cell.

---

# Optimal Java Solution

```java
class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int c = 0; c < n; c++){
            dfs(heights, 0, c, pacific, heights[0][c]);
            dfs(heights, m - 1, c, atlantic, heights[m - 1][c]);
        }

        for(int r = 0; r < m; r++){
            dfs(heights, r, 0, pacific, heights[r][0]);
            dfs(heights, r, n - 1, atlantic, heights[r][n - 1]);
        }

        List<List<Integer>> result = new ArrayList<>();

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(pacific[r][c] && atlantic[r][c]){
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    public void dfs(int[][] heights, int r, int c, boolean[][] visited, int prevHeight){

        int m = heights.length;
        int n = heights[0].length;

        if(r < 0 || c < 0 || r >= m || c >= n) return;
        if(visited[r][c]) return;
        if(heights[r][c] < prevHeight) return;

        visited[r][c] = true;

        dfs(heights, r + 1, c, visited, heights[r][c]);
        dfs(heights, r - 1, c, visited, heights[r][c]);
        dfs(heights, r, c + 1, visited, heights[r][c]);
        dfs(heights, r, c - 1, visited, heights[r][c]);
    }
}
```

---

# Dry Run

Input

```
heights = [
  [1,2,2],
  [3,2,3],
  [2,4,5]
]
```

### Pacific traversal starts from:

```
top row    → (0,0), (0,1), (0,2)
left col   → (0,0), (1,0), (2,0)
```

From these cells, we move only to:

```
same or higher heights
```

So Pacific-reachable cells become some set.

---

### Atlantic traversal starts from:

```
bottom row  → (2,0), (2,1), (2,2)
right col   → (0,2), (1,2), (2,2)
```

Again move only to:

```
same or higher heights
```

---

### Intersection

Cells visited by both Pacific and Atlantic:

```
those are the answer
```

For this smaller grid, cells like:

```
(0,2), (1,2), (2,1), (2,2)
```

can often appear in both reachable sets.

---

# Complexity Analysis

### Time Complexity

```
O(m * n)
```

Because each cell is visited at most once for Pacific and once for Atlantic.

So overall still:

```
O(m * n)
```

---

### Space Complexity

```
O(m * n)
```

For the two visited matrices and recursion stack in worst case.

---

# Key Tricks

### 1️⃣ Reverse the thinking

Instead of:

```
cell → ocean
```

do:

```
ocean → cell
```

---

### 2️⃣ Traverse from borders

Pacific starts from:

```
top row + left column
```

Atlantic starts from:

```
bottom row + right column
```

---

### 3️⃣ Reverse flow rule

Normal water flow:

```
high → low
```

Reverse traversal condition:

```
next height >= current height
```

---

### 4️⃣ Take intersection

A cell is valid only if:

```
reachable from Pacific
AND
reachable from Atlantic
```

---

# Pattern Recognition

This problem belongs to:

```
Grid DFS / BFS + Reverse Reachability Pattern
```

Similar problems:

```
Number of Islands
Walls and Gates
Rotting Oranges
Surrounded Regions
```

Also related idea:

```
Multi-source DFS/BFS from borders
```

---

# Summary

Core idea:

```
Run DFS/BFS from Pacific borders
Run DFS/BFS from Atlantic borders
Move only to equal or higher cells
Find intersection of reachable cells
```

Final complexity:

```
Time  : O(m * n)
Space : O(m * n)
```

---

# Takeaway

Whenever you see:

```
Can a cell reach boundary / ocean / exit?
```

Think immediately:

```
Reverse the traversal
Start from the boundary
Move inward
```

Because often:

```
boundary-to-cell is much easier than cell-to-boundary
```


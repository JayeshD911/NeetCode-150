# 138. Copy List with Random Pointer

🔗 Problem: https://leetcode.com/problems/copy-list-with-random-pointer/

---

# Problem

You are given a linked list where each node contains:

- `val` → the value of the node
- `next` → pointer to the next node
- `random` → pointer to any node in the list, or `null`

Your task is to create a **deep copy** of the list.

A **deep copy** means:

- every node in the new list must be a **new node**
- values should match the original list
- `next` and `random` relationships should be preserved
- no pointer in the copied list should point to any node in the original list

---

# Example

Input:

```text
head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
```

Output:

```text
[[7,null],[13,0],[11,4],[10,2],[1,0]]
```

Explanation:

- Node `13` points randomly to node `7`
- Node `11` points randomly to node `1`
- Node `10` points randomly to node `11`
- Node `1` points randomly to node `7`

The copied list must preserve the exact same structure.

---

# Intuition

The main challenge is the `random` pointer.

In a normal linked list copy, we only care about `next`.
Here, each node can also randomly point anywhere in the list.

So for every original node, we need to know:

```text
What is the copied version of this node?
```

That is why we use a **HashMap**:

- key   → original node
- value → copied node

This lets us connect:

- copied `next`
- copied `random`

correctly.

---

# Brute Force Thought

A bad approach would be:

- for each node,
- search the whole list to find where its random pointer points,
- then connect that node in the copied list

That would become very slow:

```text
O(N^2)
```

We need something better.

---

# Optimal Approach: HashMap

We do this in **two passes**.

### Pass 1
Create a copy of each node and store mapping:

```text
original node -> copied node
```

### Pass 2
Use the map to connect:

- `copy.next = map.get(original.next)`
- `copy.random = map.get(original.random)`

This works because by the second pass, every original node already has a copied version in the map.

---

# Step-by-Step Algorithm

1. If `head == null`, return `null`
2. Create a `HashMap<Node, Node>`
3. Traverse the original list
    - create a copy node for each original node
    - store it in the map
4. Traverse the original list again
    - set `next` pointer using map
    - set `random` pointer using map
5. Return the copied version of `head`

---

# Optimal Java Code

```java
/*
 // Definition for a Node.
 class Node {
     int val;
     Node next;
     Node random;

     public Node(int val) {
         this.val = val;
         this.next = null;
         this.random = null;
     }
 }
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node curr = head;

        // Pass 1: create all copied nodes
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;

        // Pass 2: connect next and random pointers
        while (curr != null) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}
```

---

# Dry Run

Let the original list be:

```text
A(7) -> B(13) -> C(11)
```

Random pointers:

```text
A.random = null
B.random = A
C.random = B
```

---

## Pass 1: Create copy nodes

We build the map:

```text
A -> A'
B -> B'
C -> C'
```

At this point:

```text
A', B', C'
```

exist, but their `next` and `random` are not connected yet.

---

## Pass 2: Connect pointers

### For A
```text
copy = A'
A'.next = B'
A'.random = null
```

### For B
```text
copy = B'
B'.next = C'
B'.random = A'
```

### For C
```text
copy = C'
C'.next = null
C'.random = B'
```

Final copied list:

```text
A'(7) -> B'(13) -> C'(11)
```

with correct random pointers.

---

# Why `map.get(null)` Works

In Java `HashMap`, if a key is not present, it returns `null`.

So these lines are safe:

```java
copy.next = map.get(curr.next);
copy.random = map.get(curr.random);
```

If `curr.next == null`, then:

```text
map.get(null) -> null
```

So the copied pointer becomes `null`, which is exactly what we want.

---

# Time Complexity

### Pass 1:
```text
O(N)
```

### Pass 2:
```text
O(N)
```

Total:

```text
O(N)
```

---

# Space Complexity

We use a HashMap storing one copied node for each original node:

```text
O(N)
```

---

# Why This Is Optimal

This is the standard optimal solution when using extra space because:

- every node is created once
- every pointer is assigned once
- random pointer lookup becomes constant time using the map

So overall:

```text
Time:  O(N)
Space: O(N)
```

---

# Common Mistakes

## 1. Forgetting deep copy
Wrong:
```text
newHead.random = oldHead.random
```

This points into the original list, which is not allowed.

---

## 2. Trying to handle random in one pass without mapping
You may not yet know whether the target random node’s copy exists.

That is why the map is useful.

---

## 3. Returning original head
You must return:

```java
map.get(head)
```

not `head`.

---

# Interview Explanation

A clean way to explain this:

> I use a HashMap to store the mapping between each original node and its copied node.  
> In the first pass, I create all copied nodes.  
> In the second pass, I connect each copied node’s `next` and `random` pointers using the map.  
> This gives an O(N) time and O(N) space deep copy.

---

# Pattern Recognition

This problem is a classic:

```text
Linked List + HashMap
```

The key pattern is:

```text
Old node -> New node mapping
```

This same idea appears in problems where:

- objects reference other objects
- graph nodes must be cloned
- random/cross pointers exist

Very similar conceptually to:

- Clone Graph
- Deep Copy structures with references

---

# Summary

### Core idea

```text
Create a copy node for every original node first.
Then use a map to connect next and random pointers.
```

### Best approach

```text
Two passes + HashMap
```

### Complexity

```text
Time:  O(N)
Space: O(N)
```

---

# Final Takeaway

This problem looks tricky because of the `random` pointer, but the trick is simple:

```text
Whenever one node can point to any other node,
store a mapping from original -> copy.
```

That makes pointer reconstruction easy and clean.

---
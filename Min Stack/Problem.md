# 155. Min Stack

Design a stack that supports the following operations in **constant time**:

- `push(val)` — push element `val` onto the stack.
- `pop()` — removes the element on top of the stack.
- `top()` — gets the top element of the stack.
- `getMin()` — retrieves the **minimum element** in the stack.

---

## Example 1

**Input:**
```
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
```

**Output:**
```
[null,null,null,null,-3,null,0,-2]
```

**Explanation:**
```
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // returns -3
minStack.pop();
minStack.top();    // returns 0
minStack.getMin(); // returns -2
```

---

## Constraints

- Methods `push`, `pop`, `top`, and `getMin` will be called at most **30,000** times.
- `-2³¹ <= val <= 2³¹ - 1`
- `pop`, `top`, and `getMin` operations will always be called on **non-empty** stacks.

---

## Notes

### Goal

Implement a stack that, in addition to the usual operations, can return the **smallest element currently in the stack** in **O(1)** time.

---

## Common Approaches

### 🧠 Using Two Stacks

- One stack to store all values (`mainStack`).
- Another stack to track minimums (`minStack`).
- When pushing a value:
    - Push it to `mainStack`.
    - Push to `minStack` the smaller value between the new value and the current minimum.

---

### 🧠 Using a Single Stack with Stored Mins

- Store pairs `(value, currentMin)` in the same stack.
- Each element knows the minimum at the time it was added.

---

## Interface Summary

| Operation | Description |
|-----------|-------------|
| `push(val)` | Pushes `val` onto the stack |
| `pop()` | Removes the top element |
| `top()` | Returns the top element |
| `getMin()` | Returns the smallest element in the stack |
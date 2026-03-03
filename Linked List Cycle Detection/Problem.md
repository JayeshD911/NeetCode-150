# 141. Linked List Cycle

## 📌 Problem Statement

Given the head of a linked list, determine if the linked list has a **cycle** in it.

A cycle occurs if there is a node in the list that can be reached again by continuously following the `next` pointer.  
Return `true` if there is a cycle in the linked list. Otherwise, return `false`.  
**Do not modify the linked list.**

---

## 📌 Visualization

A linked list has a cycle if some node’s `next` pointer points to a *previous node* in the list, creating a loop.  
Example:

```
1 → 2 → 3 → 4
         ↑    |
         └────┘
```

This list contains a cycle.

---

## 📏 Constraints

- The number of nodes in the list is in the range `[0, 10⁴]`.
- `-10⁵ <= Node.val <= 10⁵`
- `head` is a reference to the first node in the list.
- The list might contain a cycle. (Linked list structure supports cycles.)

---

## 🧪 Examples

### Example 1
```
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation:
There is a cycle because the tail connects to the node at index 1.
```

### Example 2
```
Input: head = [1,2], pos = 0
Output: true
Explanation: Cycle connects tail to head.
```

### Example 3
```
Input: head = [1], pos = -1
Output: false
Explanation: No cycle in the list.
```

---

## 💡 Intuition

To detect a cycle in a linked list, you need to determine if you can revisit a node by following `.next` pointers indefinitely.  
A common and efficient technique uses **two pointers moving at different speeds**, often called **Floyd’s Tortoise and Hare**.

---

## 🚀 Optimal Approach — Two Pointers (Floyd’s Cycle Detection)

### 🧠 Idea

- Use two pointers:
    - **Slow pointer** moves one step at a time.
    - **Fast pointer** moves two steps at a time.
- If there is a cycle, the fast pointer will eventually “lap” the slow pointer (catch up).
- If the fast pointer reaches the end (`null`), the list has no cycle.

This runs in **O(n)** time and **O(1)** space.

---

## 📌 Java Solution

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {

            if (slow == fast) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
```

---

## 🧠 Explanation

1. **Base check:**
    - If the head is `null` or only one node, then there’s no cycle — return `false`.
2. **Initialize pointers:**
    - `slow` starts at the head.
    - `fast` starts one step ahead.
3. **Iterate while `fast` and `fast.next` are valid:**
    - If `slow == fast`, a cycle exists → return `true`.
    - Otherwise:
        - `slow` moves one step (`slow = slow.next`).
        - `fast` moves two steps (`fast = fast.next.next`).
4. **If loop ends normally:**
    - Fast pointer hit the end (`null`) → no cycle → return `false`.

---

## ⏱ Complexity

| Approach | Time | Space |
|----------|------|-------|
| Hash Set | O(n) | O(n)  |
| Two Pointers (optimal) | **O(n)** | **O(1)** |

The two-pointer method is optimal in both time and space.

---

## 💡 Alternate Approach (Using Hash Set)

Store visited nodes in a HashSet. If a node repeats → cycle exists.  
But this uses extra memory.

```java
public boolean hasCycle(ListNode head) {
    Set<ListNode> seen = new HashSet<>();
    while (head != null) {
        if (seen.contains(head)) return true;
        seen.add(head);
        head = head.next;
    }
    return false;
}
```

---

## 🧠 Key Takeaways

- Use slow and fast pointers to detect cycles without extra space.
- If pointers ever meet → cycle exists.
- If end of list is reached → no cycle.

---

## 🧩 Interview Tip

This **Tortoise & Hare** technique is not just for cycle detection — it’s a powerful concept that appears in many linked list problems.

---

End of problem.
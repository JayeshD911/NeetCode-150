# 20. Valid Parentheses

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine **if the input string is valid**.

An input string is valid if:

- Open brackets must be **closed by the same type** of brackets.
- Open brackets must be **closed in the correct order**.
- Every closing bracket has a corresponding **previous** open bracket.

---

## Example 1

**Input:**  
`s = "()"`

**Output:**  
`true`

---

## Example 2

**Input:**  
`s = "()[]{}"`

**Output:**  
`true`

---

## Example 3

**Input:**  
`s = "(]"`

**Output:**  
`false`

---

## Constraints

- `1 <= s.length <= 10⁴`
- `s[i]` is one of `'()[]{}'`

---

## Notes

- Use a **stack** to keep track of open brackets.
- When encountering a **closing bracket**, check whether the **top of the stack** matches the corresponding opening bracket.
- If it doesn’t match or the stack is empty → return `false`.
- In the end, the stack must be **empty** for the string to be valid.

---

## Approach Summary

### 🧠 Stack

1. Traverse each character in the string.
2. When you see `'('`, `'['`, or `'{'`, **push** it onto the stack.
3. When you see `')'`, `']'`, or `'}'`:
    - If stack is empty → invalid.
    - Otherwise, check if top of stack is the matching open bracket.
    - If it matches → **pop** the stack.
    - If not → invalid.
4. At the end:
    - If stack is empty → valid.
    - If not → invalid.

---

## Related Topics

- Stack
- String
- Brackets

https://neetcode.io/problems/validate-parentheses/question?list=neetcode150

http://leetcode.com/problems/valid-parentheses/description/
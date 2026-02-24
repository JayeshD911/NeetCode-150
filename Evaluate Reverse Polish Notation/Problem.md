# 150. Evaluate Reverse Polish Notation

Evaluate the value of an arithmetic expression in **Reverse Polish Notation (RPN)**.

Valid operators are:  
`+`, `-`, `*`, and `/`.  
Each operand may be an integer or another expression.

---

## Example 1

**Input:**  
`tokens = ["2","1","+","3","*"]`

**Output:**  
`9`

**Explanation:**  
RPN expression is evaluated as:  
`((2 + 1) * 3) = 9`

---

## Example 2

**Input:**  
`tokens = ["4","13","5","/","+"]`

**Output:**  
`6`

**Explanation:**  
Evaluate division first:  
`13 / 5 = 2` (truncate toward zero)  
Then addition:  
`4 + 2 = 6`

---

## Example 3

**Input:**  
`tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]`

**Output:**  
`22`

**Explanation:**  
Complex RPN expression that evaluates step by step using a stack.

---

## Constraints

- `1 <= tokens.length <= 10⁴`
- `tokens[i]` is either:
    - an operator: `"+"`, `"-"`, `"*"`, `"/"`
    - or an integer in string form (possibly negative)
- Intermediate results fit in a 32-bit signed integer.

---

## Notes

- Reverse Polish Notation (postfix) means the operator follows its operands.
- Use a **stack** to evaluate:
    1. Traverse tokens from left to right.
    2. When token is a number → push to stack.
    3. When token is an operator → pop two values, apply operator, push result.
    4. At the end, the stack’s top is the result.
- Division should truncate toward zero.

---

## Example Stack Process (Quick)

Given: `["2","1","+","3","*"]`

Stack changes:
```
push 2 → [2]
push 1 → [2, 1]
operator + → pop 1 & 2 → push (2 + 1) = 3 → [3]
push 3 → [3, 3]
operator * → pop 3 & 3 → push (3 * 3) = 9 → [9]
```

---

## Related Topics

- Stack
- Array
- Parsing

https://leetcode.com/problems/evaluate-reverse-polish-notation/

https://neetcode.io/problems/evaluate-reverse-polish-notation/question?list=neetcode150
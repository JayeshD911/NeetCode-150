# 739. Daily Temperatures

Given an array of integers `temperatures` representing the daily temperatures, return an array `answer` such that `answer[i]` is the **number of days** you have to wait after the `i`th day to get a **warmer temperature**.  
If there is **no future day** for which this is possible, set `answer[i] = 0` instead. :contentReference[oaicite:0]{index=0}

---

## Example 1

Input:  
`temperatures = [73,74,75,71,69,72,76,73]`

Output:  
`[1,1,4,2,1,1,0,0]`

Explanation:
- For day 0 (73), the next warmer day is day 1 → wait **1 day**
- For day 1 (74), next warmer day is day 2 → wait **1 day**
- For day 2 (75), next warmer day is day 6 → wait **4 days**
- And so on… :contentReference[oaicite:1]{index=1}

---

## Example 2

Input:  
`temperatures = [30,40,50,60]`

Output:  
`[1,1,1,0]` :contentReference[oaicite:2]{index=2}

---

## Example 3

Input:  
`temperatures = [30,60,90]`

Output:  
`[1,1,0]` :contentReference[oaicite:3]{index=3}

---

## Constraints

- `1 <= temperatures.length <= 10⁵`
- `30 <= temperatures[i] <= 100` :contentReference[oaicite:4]{index=4}

---

## Notes

- The goal is to find the **next day with a warmer temperature** for each day.
- A naive approach (checking all future days) is **O(n²)** and too slow for large inputs.
- An **optimal solution uses a monotonic stack** to process this in linear time **O(n)**. :contentReference[oaicite:5]{index=5}

---

## Common Approach (Monotonic Stack)

Use a stack to keep indices of days whose warmer future temperature has not yet been found:

1. Initialize an empty stack to store indices of the `temperatures` array.
2. Initialize the result array `answer` with all zeros.
3. Iterate through temperatures with index `i`:
    - While the stack is not empty **and** the current temperature is greater than the temperature at the index on the top of the stack:
        - Pop the index `prev` from stack.
        - Set `answer[prev] = i - prev` (number of days waited).
    - Push the current index `i` onto the stack.
4. Remaining indices in the stack have no future warmer days, so their values stay `0`.
5. Return `answer`. :contentReference[oaicite:6]{index=6}

---

## Time & Space Complexity

| Complexity | Value |
|------------|-------|
| Time       | O(n) |
| Space      | O(n) |

Each day’s index is pushed and popped **at most once** from the stack. :contentReference[oaicite:7]{index=7}

---

## Related Topics

- Stack
- Monotonic Stack
- Array
- Next Greater Element  
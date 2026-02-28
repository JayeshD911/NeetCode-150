# 853. Car Fleet

There are `n` cars traveling towards the same destination along a one-lane highway. You are given:
- an integer `target` representing the destination position in miles,
- an integer array `position` where `position[i]` is the starting position of the **iᵗʰ car**, and
- an integer array `speed` where `speed[i]` is the speed of that car (in miles per hour). :contentReference[oaicite:0]{index=0}

Each car drives **towards the target**. A car **cannot pass** another car ahead of it. If a faster car catches up to a slower car, they form a **car fleet** and travel together at the slower car’s speed. A single car not joined with another by the time it reaches the target counts as a fleet. If a car catches up to a fleet exactly at the target, it is still considered part of that fleet. :contentReference[oaicite:1]{index=1}

Return the **number of car fleets** that will arrive at the destination. :contentReference[oaicite:2]{index=2}

---

## Example 1

**Input:**  
`target = 12`  
`position = [10,8,0,5,3]`  
`speed = [2,4,1,1,3]`

**Output:**  
`3`

**Explanation:**
- The cars at positions 10 (`speed=2`) and 8 (`speed=4`) both take 1 hour to reach the target → they form a fleet.
- The car at position 5 (`speed=1`) and position 3 (`speed=3`) take 7 and 3 hours respectively; the one behind catches up → they form another fleet.
- The car at position 0 never catches up with others → alone. :contentReference[oaicite:3]{index=3}

---

## Example 2

**Input:**  
`target = 10`  
`position = [3]`  
`speed = [3]`

**Output:**  
`1`

**Explanation:**  
Only one car → one fleet. :contentReference[oaicite:4]{index=4}

---

## Example 3

**Input:**  
`target = 100`  
`position = [0,2,4]`  
`speed = [4,2,1]`

**Output:**  
`1`

**Explanation:**  
Each car eventually catches up → a single fleet arrives. :contentReference[oaicite:5]{index=5}

---

## Constraints

- `n == position.length == speed.length`
- `1 <= n <= 10⁵`
- `0 < target <= 10⁶`
- `0 <= position[i] < target`
- All values in `position` are **unique**
- `0 < speed[i] <= 10⁶` :contentReference[oaicite:6]{index=6}

---

## Notes

### What Is a Car Fleet?

A **car fleet** is a group of cars that arrive at the target at the same time and travel together. Cars that never catch up to others before the destination form their own fleet (even if alone). :contentReference[oaicite:7]{index=7}

---

## Common Approach

### 🧠 Greedy with Sorting

1. **Compute time to reach target:**  
   For each car, calculate
   ```
   time[i] = (target - position[i]) / speed[i]
   ```  
   which is how long car `i` would take to reach the destination if unimpeded. :contentReference[oaicite:8]{index=8}

2. **Sort cars by starting position descending** (cars closer to the target first). :contentReference[oaicite:9]{index=9}

3. **Sweep from closest to farthest:**
    - Initialize `fleetCount = 0` and `slowestTimeSeen = 0`.
    - For each car in sorted order:
        - If its time > `slowestTimeSeen`, it forms a **new fleet** → increment `fleetCount` and update `slowestTimeSeen`.
        - Otherwise, it will **catch up** to the fleet ahead (no new fleet). :contentReference[oaicite:10]{index=10}

4. Return `fleetCount`. :contentReference[oaicite:11]{index=11}

This works because a car with a **larger arrival time** after sorting cannot catch any previously seen car arriving sooner, thus starts a new fleet. :contentReference[oaicite:12]{index=12}

---

## Time & Space Complexity

| Complexity | Value |
|------------|--------|
| Time       | `O(n log n)` — sorting the cars |
| Space      | `O(n)`     — storing times or indices |

---

## Related Topics

- Arrays
- Sorting
- Greedy
- Monotonic stack  


https://neetcode.io/problems/car-fleet/question
https://leetcode.com/problems/car-fleet/
# 📌 981. Time Based Key-Value Store

## 📌 Problem Statement

Design a time-based key-value data structure that can store multiple values for the same key at different times and return the value associated with a key at a particular timestamp.

Implement the `TimeMap` class:

- `TimeMap()` Initializes the object of the data structure.
- `void set(String key, String value, int timestamp)` Stores the key and value, along with the given timestamp.
- `String get(String key, int timestamp)` Returns the value such that `set(key, value, timestamp_prev)` was called previously with `timestamp_prev <= timestamp`.  
  If there are multiple such values, it returns the one with the **largest timestamp_prev** ≤ timestamp.  
  If there are no values, it returns `""`.

---

## 🧾 Examples

### Example 1
```
Input
["TimeMap", "set", "get", "get", "set", "get", "get"]
[[], ["foo","bar",1], ["foo",1], ["foo",3], ["foo","bar2",4], ["foo",4], ["foo",5]]

Output
[null, null, "bar", "bar", null, "bar2", "bar2"]
```

### Example 2
```
Input
["TimeMap", "set", "set", "get", "get", "get", "get", "get"]
[[], ["foo","bar",1], ["foo","bar2",2], ["foo",1], ["foo",2], ["foo",3], ["foo",4], ["foo",5]]

Output
[null, null, null, "bar", "bar2", "bar2", "bar2", "bar2"]
```

---

## 🔒 Constraints

- Keys and values are lowercase strings.
- `1 <= key.length, value.length <= 100`
- `1 <= timestamp <= 10^7`
- All `timestamp` values are **strictly increasing** per key in `set`.

---

# 🚀 Approach: HashMap + Binary Search

## 💡 Key Insight

For each key, we need to store:
✔ all values, and  
✔ the sorted timestamps corresponding to them.

Then for `get`, find the largest timestamp ≤ given timestamp.

---

## 🧠 Data Structure

Use:

```text
Map<String, List<Integer>> times
Map<String, List<String>> values
```

- `times.get(key)` stores sorted timestamps
- `values.get(key)` stores corresponding values

Once stored, we use **binary search** on the timestamps to find the correct index quickly.

---

## 🧑‍💻 Python Code

```python
class TimeMap:

    def __init__(self):
        self.times = {}
        self.values = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.times:
            self.times[key] = []
            self.values[key] = []
        
        self.times[key].append(timestamp)
        self.values[key].append(value)

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.times:
            return ""
        
        arr_t = self.times[key]
        arr_v = self.values[key]
        
        # Binary search for largest timestamp <= given timestamp
        left, right = 0, len(arr_t) - 1
        ans = ""
        
        while left <= right:
            mid = left + (right - left) // 2
            if arr_t[mid] <= timestamp:
                ans = arr_v[mid]
                left = mid + 1
            else:
                right = mid - 1
        
        return ans
```

---

## ⏱ Complexity

| Operation | Time | Space |
|-----------|------|-------|
| `set()`   | **O(1)** | O(1) |
| `get()`   | **O(log n)** | O(1) |

Where `n` is the number of timestamps stored for a key.

---

## 👇 How Binary Search Works Here

For a list of timestamps:

```
[1, 3, 5, 7, 10]
```

If timestamp = `6`, we want the largest ≤ 6 → `5`.

Binary search navigates left/right to find this efficiently.

---

## 📚 Key Takeaways

✔ Use HashMap to store chronological data  
✔ Binary search for fast retrieval  
✔ Works because timestamps for each key are strictly increasing

---

## 📅 Daily LeetCode Log

- Day: XX
- Topic: HashMap + Binary Search
- Difficulty: Medium
- Language: Python

---


https://neetcode.io/problems/time-based-key-value-store/question?list=neetcode150

https://leetcode.com/problems/time-based-key-value-store/description/
# Top K Frequent Elements

## Problem Statement

Given an integer array `nums` and an integer `k`, return the **k most frequent elements**.

You may return the answer in **any order**.

---

## Examples

### Example 1
**Input:**
```
nums = [1,1,1,2,2,3], k = 2
```

**Output:**
```
[1,2]
```

### Example 2
**Input:**
```
nums = [1], k = 1
```

**Output:**
```
[1]
```

---

## Constraints

- `1 <= nums.length <= 10^5`
- `-10^4 <= nums[i] <= 10^4`
- `k` is in the range `[1, number of unique elements in nums]`
- The answer is guaranteed to be unique

---

## Follow-up

Can you solve the problem in **better than O(n log n)** time complexity?

---

## Approach Overview

1. Count the frequency of each element using a hashmap.
2. Use a bucket array where index represents frequency.
3. Traverse the bucket from highest frequency to lowest.
4. Collect elements until `k` elements are obtained.

---

## Python Solution (Bucket Sort)

```python
from collections import defaultdict
from typing import List

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq_map = defaultdict(int)

        # Count frequencies
        for num in nums:
            freq_map[num] += 1

        # Bucket sort by frequency
        buckets = [[] for _ in range(len(nums) + 1)]
        for num, freq in freq_map.items():
            buckets[freq].append(num)

        # Gather top k elements
        result = []
        for freq in range(len(buckets) - 1, 0, -1):
            for num in buckets[freq]:
                result.append(num)
                if len(result) == k:
                    return result
```

---

## Time and Space Complexity

- **Time Complexity:** O(n)
- **Space Complexity:** O(n)

---

## Key Takeaways

- HashMaps help count frequencies efficiently.
- Bucket sort avoids unnecessary sorting.
- Traversing buckets from high to low gives top frequent elements in linear time.

---

## Related Problems

- K Closest Points to Origin
- Sort Characters by Frequency
- Find All Anagrams in a String

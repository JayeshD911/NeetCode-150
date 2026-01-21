# 49. Group Anagrams

## Problem Statement

Given an array of strings `strs`, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once [6].

## Examples

**Example 1:**
Input: `strs = ["eat","tea","tan","ate","nat","bat"]`
Output: `[["bat"],["nat","tan"],["ate","eat","tea"]]`

**Example 2:**
Input: `strs = [""]`
Output: `[[""]]`

**Example 3:**
Input: `strs = ["a"]`
Output: `[["a"]]`

## Constraints

*   `1 <= strs.length <= 10^4`
*   `0 <= strs[i].length <= 100`
*   `strs[i]` consists of lowercase English letters [2].

## Solution Approach

The key insight is that all anagrams, when sorted alphabetically, will result in the *same* string (e.g., "eat", "tea", "ate" all become "aet") [3, 14]. We can use this sorted string as a unique identifier (key) in a hash map (or dictionary) to group the original words [3, 4].

1.  **Initialize a Hash Map**: Create a dictionary/hash map (e.g., `anagram_groups`) to store `sorted_string -> [original_words]` [4].
2.  **Iterate Through Strings**: For each `word` in the input `strs` array:
    *   Sort the characters of the `word` to get the `sorted_word` [3, 4].
    *   Use `sorted_word` as the key and append the original `word` to the list associated with that key in the `anagram_groups` map [4].
3.  **Return Groups**: The values (lists of words) from the `anagram_groups` map form the final grouped anagrams [1, 4].


https://neetcode.io/problems/anagram-groups/question

https://leetcode.com/problems/group-anagrams/description/

## Code (Python Example)

```python
from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagram_map = defaultdict(list)
        for s in strs:
            # Sort the string to create a unique key for anagrams
            key = "".join(sorted(s)) 
            anagram_map[key].append(s)
        
        # Return the values (the lists of anagrams)
        return list(anagram_map.values())

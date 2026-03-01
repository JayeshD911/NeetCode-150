# NeetCode-150 (Java) — Solutions (WIP)

My **Java** solutions for the **NeetCode 150** coding interview roadmap.

NeetCode 150 is a curated set of 150 essential LeetCode-style problems organized by topic/pattern (Arrays & Hashing, Two Pointers, Sliding Window, Stack, Binary Search, Linked List, Trees, Graphs, DP, etc.). This repo is my personal practice log + reference as I work through the list.

> Status: **Work in progress** — solutions will be added gradually, with improvements (notes/tests/refactors) over time.

---

## Goals

- Build strong pattern recognition across common interview topics
- Maintain clean, readable Java solutions (with good variable naming + comments where helpful)
- Keep a simple folder layout so it’s easy to find any problem quickly
- Optionally add:
    - explanations/intuition notes
    - time/space complexity notes
    - small local test harness per problem
    - CI checks (format/lint/tests)

---

## Repo Structure

This repository uses a **one-folder-per-problem** layout:

```
NeetCode-150/
  <Problem Name>/
    (Java solution file(s))
  README.md
```

Examples you’ll see in the repo:
- `Contains Duplicate/`
- `3Sum/`
- `Binary Search/`
- `Valid Parentheses/`
- ...and more.

> Folder names intentionally match the problem titles for easy searching.

---

## How to Use This Repo

### Option A — Using on LeetCode (recommended)
Most solutions are written in the standard LeetCode format (typically a `class Solution` with the required method).
1. Open the problem on LeetCode
2. Copy the Java code from this repo
3. Paste into the LeetCode editor and run/submit

### Option B — Run locally (optional)
If you want to run locally:
- Install **JDK 11+** (or whatever your environment supports)
- Open in IntelliJ / VS Code
- Add a tiny `main()` or JUnit test for the method (LeetCode-style solutions don’t always include a runnable entrypoint)

> Tip: If you plan to run locally often, create a `/utils` folder with helpers (printing arrays, building linked lists/trees, etc.) and reuse them.

---

## Progress Tracker (Current)

✅ = folder/solution present in this repo right now.

### Arrays & Hashing
- ✅ Contains Duplicate
- ✅ Valid Anagram
- ✅ Two Sum
- ✅ Group Anagrams
- ✅ Top K Frequent Elements
- ✅ Product of Array Except Self
- ✅ Encode and Decode Strings
- ✅ Longest Consecutive Sequence

### Two Pointers
- ✅ Valid Palindrome
- ✅ Two Sum II - Input Array Is Sorted
- ✅ 3Sum
- ✅ Container With Most Water
- ✅ Trapping Rain Water

### Stack
- ✅ Valid Parentheses
- ✅ Min Stack
- ✅ Evaluate Reverse Polish Notation
- ✅ Daily Temperatures
- ✅ Car Fleet
- ✅ Largest Rectangle In Histogram

### Binary Search
- ✅ Binary Search
- ✅ Search a 2D Matrix
- ✅ Koko Eating Bananas
- ✅ Search in Rotated Sorted Array
- ✅ Find Minimum in Rotated Sorted Array
- ✅ Time Based Key-Value Store

### Linked List
- ✅ Reverse Linked List
- ✅ Merge Two Sorted Lists

> As more solutions are added, this checklist will be expanded to match the full NeetCode 150 roadmap.

My LeetCode profile: https://leetcode.com/u/jaydec1997/
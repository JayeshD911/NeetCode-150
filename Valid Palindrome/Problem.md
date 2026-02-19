
# 125. Valid Palindrome

Given a string `s`, return `true` if it is a palindrome, or `false` otherwise.

A **palindrome** is a string that reads the same forward and backward after:

- Converting all uppercase letters into lowercase letters, and  
- Removing all non-alphanumeric characters.

Alphanumeric characters include only letters and numbers.

---

## Example 1

Input:  
`s = "A man, a plan, a canal: Panama"`

Output:  
`true`

Explanation:  
After removing non-alphanumeric characters and converting to lowercase,  
`"amanaplanacanalpanama"` is a palindrome.

---

## Example 2

Input:  
`s = "race a car"`

Output:  
`false`

Explanation:  
After cleaning, `"raceacar"` is not a palindrome.

---

## Example 3

Input:  
`s = " "`

Output:  
`true`

Explanation:  
After removing non-alphanumeric characters, the string becomes empty `""`.  
An empty string is considered a palindrome.

---

## Constraints

- `1 <= s.length <= 2 * 10^5`
- `s` consists only of printable ASCII characters.

---

## Notes

- Ignore case differences.
- Ignore non-alphanumeric characters.
- A two-pointer approach is commonly used to solve this problem efficiently.


https://neetcode.io/problems/products-of-array-discluding-self/question?list=neetcode150

https://leetcode.com/problems/valid-palindrome/



# 50. Pow(x, n)

## 🟡 Difficulty
Medium

## 🔗 Problem Link
https://leetcode.com/problems/powx-n/

---------------------

## 📝 Problem Statement

Implement a function `pow(x, n)`, which calculates **x raised to the power n (i.e., xⁿ)**.

---------------------

## 📥 Examples

### Example 1
Input: x = 2.00000, n = 10  
Output: 1024.00000

### Example 2
Input: x = 2.10000, n = 3  
Output: 9.26100

### Example 3
Input: x = 2.00000, n = -2  
Output: 0.25000  
Explanation: 2⁻² = 1 / (2²) = 1/4 = 0.25

---------------------

## ⚙️ Constraints

- -100.0 < x < 100.0
- -2³¹ ≤ n ≤ 2³¹ - 1
- n is an integer
- -10⁴ ≤ xⁿ ≤ 10⁴

---------------------

## 💡 Key Idea

Use **Binary Exponentiation (Fast Power)**:

- Reduce exponent by half each step
- Handle negative exponent using reciprocal
- Achieves **O(log n)** time instead of O(n)

---------------------

## 🧠 Approach

1. If n == 0 → return 1
2. If n < 0:
    - x = 1 / x
    - n = -n
3. Use binary exponentiation:
    - If n is even → xⁿ = (x²)^(n/2)
    - If n is odd → xⁿ = x * (x²)^(n/2)

---------------------

## 🚀 Code (Iterative - Optimal)

    class Solution {
        public double myPow(double x, int n) {
        long N = n;
    
            if (N < 0) {
                x = 1 / x;
                N = -N;
            }
            
            double result = 1;
            
            while (N > 0) {
                if (N % 2 == 1) {
                    result *= x;
                }
                x *= x;
                N /= 2;
            }
            
            return result;
        }
    };

---------------------

## 🔁 Alternative (Recursive)

    class Solution {
        public:
        double fastPow(double x, long long n) {
        if (n == 0) return 1;
    
            double half = fastPow(x, n / 2);
            
            if (n % 2 == 0)
                return half * half;
            else
                return half * half * x;
        }
        
        double myPow(double x, int n) {
            long long N = n;
            
            if (N < 0) {
                x = 1 / x;
                N = -N;
            }
            
            return fastPow(x, N);
        }
    };

---------------------

## ⏱️ Complexity

Time: O(log n)  
Space: O(1) (iterative), O(log n) (recursive)

---------------------

## ⚠️ Edge Cases

- n = 0 → return 1
- n < 0 → handle reciprocal
- n = INT_MIN → use long long to avoid overflow
- x = 0 → valid only if n > 0

---------------------

## 🧩 Tags

- Math
- Binary Exponentiation
- Recursion

---------------------

## 🏁 Summary

- Naive approach is too slow (O(n))
- Optimal solution uses divide & conquer
- Core trick: square the base, halve the exponent

---------------------
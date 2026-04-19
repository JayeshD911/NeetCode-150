class Solution {
    private int solve(int A, int[] dp) {

        if (A==1 || A==2) return A;
        if (dp[A] != -1) return dp[A];
        dp[A] = (solve(A-1,dp) + solve(A-2,dp));
        return dp[A];
    }

    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }
}

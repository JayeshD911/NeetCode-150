class Solution {
    public int solve ( int A, int dp[] , int[] cost){
        if(A == 0 ) return cost[0];
        if(A == 1 ) return cost[1];

        if(dp[A] != -1) return dp[A];

        return dp[A] = cost[A] + Math.min(solve(A-1, dp , cost) , solve(A-2, dp , cost) );
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return Math.min(solve(n-1, dp , cost) , solve(n-2, dp , cost) );
    }
}

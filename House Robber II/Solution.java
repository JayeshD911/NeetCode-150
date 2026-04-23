// Easy to understand
class Solution {
    public int Solve(int start, int end, int[] nums, int[] dp){

        if(start > end) return 0;

        if (dp[start] != -1) return dp[start];

        int n = nums.length;
        int pick = nums[start] + Solve(start + 2, end, nums, dp);
        int notPick = Solve(start + 1, end, nums, dp);

        return dp[start] = Math.max(pick, notPick);

    }
    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.max(Solve(0, n-2, nums, dp1), Solve(1, n-1, nums, dp2));
    }
}



// O(1) Space
public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];
    return Math.max(
            getMax(nums, 0, nums.length - 2),
            getMax(nums, 1, nums.length - 1)
    );
}

private int getMax(int[] nums, int start, int end) {
    int prevRob = 0, maxRob = 0;

    for (int i = start; i <= end; i++) {
        int temp = Math.max(maxRob, prevRob + nums[i]);
        prevRob = maxRob;
        maxRob = temp;
    }

    return maxRob;
}
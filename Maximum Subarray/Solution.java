class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;

        int sum = 0;
        for (int i= 0; i< nums.length ; i++){
            // sum = sum + nums[i];
            sum += nums[i];
            // ans = Math.max(ans, sum);
            ans = sum < ans ? ans : sum;
            // if(sum < 0) sum = 0;
            sum = sum < 0 ? 0 : sum;
        }

        return ans;
    }
}
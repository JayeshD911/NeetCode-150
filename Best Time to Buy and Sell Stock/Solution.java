class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int l = 0;
        int r = 0;
        int ans = 0;

        while(r < N){
            if (prices[l] > prices[r]){
                l = r;
                r++;
            }
            else{
                ans = Math.max(ans, prices[r] - prices[l]);
                r++;
            }
        }
        return ans;

    }
}

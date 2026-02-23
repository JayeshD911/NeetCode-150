class Solution {
    public int maxArea(int[] heights) {
        int N = heights.length ;
        int l = 0;
        int r = N-1;
        int lower_height = 0;

        int ans = 0;

        while(l<r){

            lower_height = Math.min(heights[r], heights[l]);

            ans = Math.max(ans, (r-l) * lower_height);

            if (heights[r] > heights[l]) l++;
            else r--;
        }
        return ans;
    }
}

class Solution {
    public int trap(int[] height) {
        int N = height.length;
        int ans = 0;
        int[] prefix = new int[N];
        int[] postfix = new int[N];

        prefix[0] = height[0];
        for (int i = 1 ; i < N; i++ ){
            prefix[i] = Math.max(prefix[i-1], height[i]);
        }

        postfix[N-1] = height[N-1];
        for (int i = N-2 ; i >= 0; i-- ){
            postfix[i] = Math.max(postfix[i+1], height[i]);
        }

        for (int i = 1 ; i < N - 1 ; i++ ){
            ans = ans + Math.min(prefix[i], postfix[i]) - height[i];
        }
        return ans;
    }
}
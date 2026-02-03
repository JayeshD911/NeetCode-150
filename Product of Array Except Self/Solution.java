class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int [] prefix_array = new int [N];
        int [] postfix_array = new int [N];
        int [] ans = new int [N];

        
        prefix_array[0] = nums[0];
        for(int i = 1; i< N ;i++){
            prefix_array[i] = prefix_array[i-1] * nums[i];
        }

        postfix_array[N-1] = nums[N-1];
        for(int i = N-2; i>= 0 ;i--){
            postfix_array[i] = postfix_array[i + 1] * nums[i];
        }

        for(int i = 1; i< N-1 ; i++){
            ans[i] = prefix_array[i-1] * postfix_array[i+1];
        }

        ans[0] = postfix_array[1];
        ans[N-1] = prefix_array[N-2];

        return ans;

    }
}
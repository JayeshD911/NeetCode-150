class Solution {
    public int findMin(int[] nums) {
        int N = nums.length;

        int low = 0 ;
        int high = N-1;
        int mid = 0;

        while(low < high){
            mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }

        return nums[low];
    }
}
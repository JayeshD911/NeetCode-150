class Solution {
    public int search(int[] nums, int target) {
        int N = nums.length;

        int low = 0 ;
        int high = N-1;
        int mid = 0;

        while(low <= high){
            mid = low + (high - low) / 2;
            if (nums[mid] == target){
                return mid;
            }

            if (nums[mid] >= nums[low]){
                if (target >= nums[low] && target < nums[mid]){
                    high = mid -1;
                }
                else low = mid + 1;
            }
            else{
                if (target <= nums[high] && target > nums[mid]){
                    low = mid + 1;
                }
                else high = mid -1;
            }

        }

        return -1;
    }
}
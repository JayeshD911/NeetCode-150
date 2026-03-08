class Solution {
    public int findDuplicate(int[] nums) {

        for(int i = 0 ; i< nums.length ; i++){
            int absI = Math.abs(nums[i]);
            if(nums[absI - 1] < 0) return absI;
            else nums[absI - 1] = nums[absI - 1] * -1;
        }
        return -1;
    }
}
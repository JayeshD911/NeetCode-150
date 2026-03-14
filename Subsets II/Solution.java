class Solution {
    public void solve(int[] nums, List<List<Integer>> ans , ArrayList<Integer> temp , int currIndex){
        if (currIndex == nums.length){
            ans.add( new ArrayList<Integer>(temp));
            return;
        }

        temp.add(nums[currIndex]);
        solve(nums, ans, temp , currIndex + 1);

        temp.remove(temp.size() -1);
        while(currIndex + 1 < nums.length && nums[currIndex] == nums[currIndex + 1]) currIndex++;
        solve(nums, ans, temp , currIndex + 1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        solve(nums, ans, new ArrayList<>() , 0);

        return ans;
    }
}
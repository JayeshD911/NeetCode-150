class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    void solve (int currPosition, int[] nums, List<Integer> currSubset){
        if(currPosition == nums.length){
            ans.add( new ArrayList<>(currSubset));
            return;
        }

        currSubset.add(nums[currPosition]);
        solve(currPosition + 1, nums, currSubset);

        // currSubset.removeLast();
        currSubset.remove(currSubset.size() - 1);
        solve(currPosition + 1, nums, currSubset);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> currSubset = new ArrayList<Integer>();

        solve(0, nums, currSubset);

        return ans;

    }
}
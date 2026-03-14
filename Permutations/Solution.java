class Solution {

    public void solve(int[] nums, List<List<Integer>> ans, ArrayList<Integer> temp, boolean[] used, int currIndex) {
        if(nums.length == temp.size()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(currIndex == nums.length) return;
        if(used[currIndex] == false){

            used[currIndex] = true;
            temp.add(nums[currIndex]);
            solve(nums, ans, temp, used, 0);

            temp.remove(temp.size() -1);
            used[currIndex] = false;
        }
        solve(nums, ans, temp, used, currIndex + 1);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>> ();


        solve(nums, ans, new ArrayList<>(), new boolean[nums.length]);

        return ans;

    }
}
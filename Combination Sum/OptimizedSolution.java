class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] <= target) {
                temp.add(nums[i]);
                backtrack(res, temp, nums, target - nums[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
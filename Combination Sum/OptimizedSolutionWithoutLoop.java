class Solution {
    public void solve(int[]candidates, int target,List<List<Integer>> ans, List<Integer> temp, int position){
        if (target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        if(position == candidates.length) return;

        if (target >= candidates[position]){

            //include the same value again
            temp.add(candidates[position]);
            solve(candidates, target - candidates[position], ans, temp, position);

            //remove the added value to backtrack
            temp.remove(temp.size() -1);
        }
        solve(candidates, target , ans, temp, position + 1);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates, target, ans, new ArrayList<>() , 0);
        return ans;
    }
}
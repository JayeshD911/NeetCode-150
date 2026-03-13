class Solution {

    public void solve(int[] candidates,int target, ArrayList<Integer> temp,List<List<Integer>> ans, int index){
        if ( target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(index == candidates.length) return;

        if(candidates[index] <= target ){
            //include the number at index
            temp.add(candidates[index]);
            solve(candidates, target - candidates[index] ,temp , ans, index + 1);

            //backtrack
            temp.remove(temp.size() -1);
        }
        while(index + 1 < candidates.length && candidates[index] == candidates[index + 1]) index++;
        solve(candidates,target ,temp , ans, index + 1);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        Arrays.sort(candidates);
        solve(candidates, target , new ArrayList<Integer>(), ans, 0);
        return ans;
    }
}
class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public void solve (int[] candidates, int target, List<Integer> currentList, int position, int currSum){

        if(currSum > target )return;

        if(position == candidates.length) return;

        if (currSum == target){
            ans.add( new ArrayList<>(currentList));
            return;
        }

        // take current element
        currentList.add(candidates[position]);
        solve (candidates, target, currentList, position , currSum + candidates[position]);

        // backtrack
        currentList.remove(currentList.size() - 1);

        // skip current element
        position++;
        solve (candidates, target, currentList, position , currSum);
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> currentList = new ArrayList<Integer>();
        int currSum = 0;

        solve (candidates, target, currentList, 0 , currSum);

        return ans;

    }
}
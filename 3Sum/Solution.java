class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int N = nums.length;
        int a = 0;
        int b = 0;
        int c = 0;
        int i = 0;
        int j = 0;

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for(int x = 0 ; x < N-2 ; x++){ //stop at N-3
            a = nums[x];
            i = x+1;
            j = N-1;

            if (a > 0) break; //no negative numbers left to create 0
            if (x > 0 && nums[x] == nums[x - 1]) continue;  //check for duplicates. Check x>0 becuse we are comparing with x-1 index
            while(i<j){
                b = nums[i];
                c = nums[j];

                if(a + b + c== 0 ){
                    List<Integer> temp = new ArrayList<Integer>(Arrays.asList(a,b,c));
                    ans.add(temp);
                    while ( i < j && nums[i] == b) i++; //skip same b
                    while ( i < j && nums[j] == c) j--; //skip same c
                }

                else if(a + b + c < 0 ) i++;
                else j--;
            }
        }
        return ans;
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int ans = 0;
        int length = 1;

        for (int i : nums){
            hs.add(i);
        }

        for(Integer i : hs){
            if(hs.contains(i-1)) continue;
            else{
                length = 1;
                while(hs.contains(i + length)){
                    length += 1;
                }
                ans = Math.max(ans, length);
            }
        }
        return ans;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<Character>(); //store the characters
        int ans = 0;
        int N = s.length();
        int l = 0;
        int r = 0;

        if (N == 0) return 0;

        while(r < N ){
            while (hs.contains(s.charAt(r))){
                hs.remove(s.charAt(l));
                l++;
            }
            hs.add(s.charAt(r));
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
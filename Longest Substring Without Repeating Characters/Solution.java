class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Using HashMap
        Map<Character,Integer> hm = new HashMap<Character,Integer>(); //store the characters
        int ans = 0;
        int N = s.length();
        int lastRepeatedPosition = 0;
        int i = 0;

        while (i<N ){

            char charAtPositionI = s.charAt(i);

            if (hm.containsKey(charAtPositionI)){
                //max between last repeated character and the current repeated position
                lastRepeatedPosition = Math.max(lastRepeatedPosition, hm.get(charAtPositionI) + 1 );
            }

            hm.put(charAtPositionI , i);
            ans = Math.max(ans, i - lastRepeatedPosition + 1);
            i++;
        }
        return ans;


        //Using HashSet
        // HashSet<Character> hs = new HashSet<Character>(); //store the characters
        // int ans = 0;
        // int N = s.length();
        // int l = 0;
        // int r = 0;

        // // if (N == 0) return 0;

        // while(r < N ){
        //     while (hs.contains(s.charAt(r))){
        //         hs.remove(s.charAt(l));
        //         l++;
        //     }
        //     hs.add(s.charAt(r));
        //     ans = Math.max(ans, r - l + 1);
        //     r++;
        // }
        // return ans;
    }
}
class Solution {
    public int characterReplacement(String s, int k) {
        int N = s.length();
        int ans = 0;
        int left = 0;
        int right = 0;
        int maxFreq = 0;                    // highest frequency in window
        int[] charCounter = new int[26];    // store counts of A-Z

        while(right < N){
            char currentChar = s.charAt(right);
            // increase count
            charCounter[currentChar - 'A']++;

            // update max frequency
            maxFreq = Math.max(maxFreq , charCounter[currentChar - 'A'] );

            // if too many replacements needed → shrink window
            while(right-left+1 - maxFreq  > k){
                charCounter[s.charAt(left) - 'A']--;
                left++;
            }

            // update answer
            ans = Math.max(ans, right-left+1);

            right++;
        }
        return ans;



    }
}


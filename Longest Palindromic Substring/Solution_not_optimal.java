class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String result = "";

        for(int i = 0 ; i< n ; i++){

            String oddString = maxPalindromeLength(i, i, s);
            if(result.length() < oddString.length()){
                result = oddString;
            }

            String evenString = maxPalindromeLength(i, i + 1, s);
            if(result.length() < evenString.length()){
                result = evenString;
            }
        }
        return result;
    }

    public String maxPalindromeLength(int left, int right, String s){
        while( left >= 0 &&
                right < s.length() &&
                s.charAt(left) == s.charAt(right) ){
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }

}
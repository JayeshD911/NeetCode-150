class Solution {
    public boolean isPalindrome(String s) {
        int N = s.length();
        int i = 0;
        int j = N-1;

        if (i==j) return true;

        while(i<j){
            while(!((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) && i < j){
                i++;
            }
            while(!((s.charAt(j) >= 'a' && s.charAt(j) <= 'z') || (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') || (s.charAt(j) >= '0' && s.charAt(j) <= '9')) && i < j){
                j--;
            }
            //check i < j  if crossed due to invalid characters

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;

        }

        return true;

    }
}
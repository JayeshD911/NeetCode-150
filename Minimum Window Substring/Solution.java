class Solution {
    public String minWindow(String s, String t) {
        int Ns = s.length();
        int Nt = t.length();

        if(Nt > Ns) return "";

        int[] tCounter = new int[128];      //to handle ASCII values of a-z and A-Z
        int required = Nt;

        for (int i = 0 ; i< Nt ; i++){
            tCounter[t.charAt(i)]++;
        }

        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;


        while (right < Ns){
            char cRight = s.charAt(right);

            if(tCounter[cRight] > 0){
                required--;
            }
            tCounter[cRight]--;
            right++;

            while(required == 0){
                if(minLength > right - left){
                    minLength = right - left;
                    start = left;
                }
                char cLeft = s.charAt(left);
                tCounter[cLeft]++;

                if(tCounter[cLeft] > 0){
                    required++;
                }
                left++;
            }

        }
        if( minLength == Integer.MAX_VALUE) return "";
        return s.substring(start,start + minLength);

    }
}
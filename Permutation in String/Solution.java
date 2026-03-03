class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int N1 = s1.length();
        int N2 = s2.length();

        if( N1 > N2) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i< N1 ; i++){
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        int l = 0;
        int r = N1; //N1 and not N1 -1!

        if(Arrays.equals(freq1,freq2)) return true;

        while(r < N2){

            freq2[s2.charAt(l) - 'a']--;
            l++;
            freq2[s2.charAt(r) - 'a']++;        //the first iteration will add the N1th position
            r++;
            if(Arrays.equals(freq1,freq2)) return true;
        }

        return false;
    }
}
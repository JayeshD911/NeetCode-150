class Solution {
    public boolean isValid(int[] piles, int h, int k ){
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += (pile + k - 1) / k;  // ceil(pile / k)
        }
        return totalHours <= h;

    }

    public int minEatingSpeed(int[] piles, int h) {
        int N = piles.length;

        int l = 1;
        int r = Integer.MIN_VALUE;
        int mid = 0;

        for (int pile : piles){
            r = Math.max(r, pile);
        }

        while(l < r){
            mid = l + (r - l) / 2;
            if (isValid(piles, h, mid)){
                r = mid;         // this mid is valid and we are not sure if this is the last so no mid-1
            }
            else{
                l = mid + 1;
            }
        }

        return l; //stops at l=r and mid holds older value so thats why return l
    }
}
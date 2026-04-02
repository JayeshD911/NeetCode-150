class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean xFound = false , yFound = false, zFound = false;

        for(int[] triplet : triplets){
            if(triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2] ) continue;

            if(triplet[0] == target[0]) xFound = true;
            if(triplet[1] == target[1]) yFound = true;
            if(triplet[2] == target[2]) zFound = true;

            if(xFound && yFound && zFound == true) return true;
        }

        return false;
    }
}
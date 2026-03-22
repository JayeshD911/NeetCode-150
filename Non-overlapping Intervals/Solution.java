class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        //sort by end
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int prevEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){

            if(intervals[i][0] < prevEnd){
                count++; // remove interval
            }
            else{
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
}



// A little less optimal
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int ans = 0;
        int n = intervals.length;
        int i = 1;
        int lastEnd =  intervals[0][1];
        while (i < n){
            if( intervals[i][0] < lastEnd ){
                ans++;
            }
            else{
                lastEnd =  intervals[i][1];
            }
            i++;
        }
        return ans;
    }
}
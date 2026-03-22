class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();

        // Add the smaller ones by comparing the 'end' of intervals. If intervals[i][end] is greater than or equal to newInterval[start], break the loop
        int i = 0;
        while(i < n && intervals[i][1] < newInterval[0]){
            ans.add(intervals[i]);
            i++;
        }

        // check if merged by comparing intervals[i][start] and newInterval[end]
        while(i < n && intervals[i][0] <= newInterval[1] ){
            newInterval[0] = Math.min(newInterval[0] , intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1] , intervals[i][1]);
            i++;
        }
        ans.add(newInterval);

        // Add the larger ones by comparing the 'end' of intervals.
        while(i<n){
            ans.add(intervals[i]);
            i++;
        }

        return ans.toArray(new int[ans.size()] []);
    }
}
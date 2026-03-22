class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;

        int tempStart = intervals[0][0];
        int tempEnd = intervals[0][1];

        int i = 1;
        while(i< n){
            // OVERLAP -> merge
            if(intervals[i][0] <= tempEnd ){
                tempEnd = Math.max(tempEnd , intervals[i][1]);
            }
            // NO OVERLAP -> store & reset
            else{
                ans.add(new int[]{tempStart,tempEnd});
                tempStart = intervals[i][0];
                tempEnd = intervals[i][1];
            }
            i++;
        }

        // Last interval
        ans.add(new int[]{tempStart,tempEnd});

        return ans.toArray(new int[ans.size()][]);
    }
}
/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        intervals.sort((a, b) -> a.start - b.start);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(Interval interval : intervals){

            if(!minHeap.isEmpty() && interval.start >= minHeap.peek()){
                minHeap.poll(); // reuse room
            }

            minHeap.offer(interval.end);
        }

        return minHeap.size();
    }
}


//TWO POINTER APPROACH

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int ans = 0;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i< n ;i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int start_position = 0;
        int end_position = 0;
        int count = 0;
        while(start_position < n && end_position < n){
            if(start[start_position] < end[end_position]){
                count++;
                ans = Math.max(ans, count);
                start_position++;
            }
            else{
                count--;
                end_position++;
            }
        }

        return ans;

    }
}

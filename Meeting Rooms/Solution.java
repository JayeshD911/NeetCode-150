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
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a,b) -> Integer.compare(a.start, b.start));

        for(int i = 0 ; i< intervals.size() - 1; i++){
            int endI1 = intervals.get(i).end;
            int startI2 = intervals.get(i+1).start;

            if(startI2 < endI1) return false;
        }
        return true;
    }
}
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        // without using stack
        int N = position.length;
        int[][] cars = new int [N][2];

        for( int i = 0 ; i< N ; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a,b) -> a[0] - b[0]);

        double time_taken_by_last_slowest = (double)(target - cars[N-1][0]) / cars[N-1][1];
        int ans = 1;

        for(int i = N-2 ; i >= 0  ; i--){
            double time_to_reach_target =  (double)(target - cars[i][0]) / cars[i][1] ;

            if(time_taken_by_last_slowest < time_to_reach_target){
                ans++;
                time_taken_by_last_slowest = time_to_reach_target;
            }

        }

        return ans;

        //Using stack
        // Deque<Double> stack = new ArrayDeque<>(); //store -> (target - position) / speed

        // for(int i = N-1 ; i >= 0  ; i--){
        //     double time_to_reach_target =  (double)(target - cars[i][0]) / cars[i][1] ;

        //     if(stack.isEmpty() || stack.peek() < time_to_reach_target){
        //         stack.push(time_to_reach_target);
        //     }

        // }

        // return stack.size();
    }
}
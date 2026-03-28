class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int total = 0;
        int currSum = 0;
        int start = 0;
        for (int i = 0 ; i < gas.length ; i++){
            int gain = gas[i] - cost[i];
            currSum = currSum + gain;
            total = total + gain;
            if(currSum < 0){
                currSum = 0;
                start = i+1;
            }
        }

        if (total < 0) return -1;
        else return start;
    }
}


//Easy to understand

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int total_gas = 0;
        int total_cost = 0;

        for (int i = 0 ; i < gas.length ; i++){
            total_gas += gas[i];
            total_cost += cost[i];
        }

        if(total_gas < total_cost) return -1;

        int start = 0;
        int tank = 0;

        for (int i = 0 ; i < gas.length ; i++){
            tank = tank + gas[i] - cost[i];
            if(tank < 0){
                start = i + 1;
                tank = 0;
            }
        }

        return start;
    }
}
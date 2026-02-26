class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int N = temperatures.length;
        Deque<Integer> stack = new ArrayDeque<Integer>();

        int[] ans = new int[N];

        for (int  i = 0 ; i< N ; i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()] ){
                int previous_index = stack.pop();
                ans[previous_index] = i - previous_index;
            }
            stack.push(i);
        }
        return ans;
    }
}
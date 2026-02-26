class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int N = temperatures.length;
        Stack<Integer> stack = new Stack<Integer>();

        int[] ans = new int[N];

        for (int  i = 0 ; i< N ; i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()] ){
                ans[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}
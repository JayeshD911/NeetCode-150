class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack_main  = new Stack<>();
        int a = 0;
        int b = 0;
        int ans = 0;

        for (String token : tokens){
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") ){
                a = stack_main.pop();
                b = stack_main.pop();

                if (token.equals("+")) stack_main.push(b + a);
                if (token.equals("-")) stack_main.push(b - a);
                if (token.equals("*")) stack_main.push(b * a);
                if (token.equals("/")) stack_main.push(b / a);
            }
            else stack_main.push(Integer.parseInt(token));
        }
        return stack_main.pop();
    }
}
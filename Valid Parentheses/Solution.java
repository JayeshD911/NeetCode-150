class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char top;
        char current;

        for(int i = 0 ; i< s.length() ; i++){
            current = s.charAt(i);
            if (current == '(' || current == '{' || current == '['){
                stack.push(current);
            }
            else{
                if (stack.isEmpty()){
                    return false;
                }
                else{
                    top = stack.peek();
                    if ((current == ')' && top == '(' ) ||
                            (current == '}' && top == '{' ) ||
                            (current == ']' && top == '[' ) ){
                        stack.pop();
                    }
                    else return false;

                }
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        else return false;
    }
}
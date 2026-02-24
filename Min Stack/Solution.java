class MinStack {
    Stack<Integer> stack_main ;
    Stack<Integer> stack_min ;

    public MinStack() {
        stack_main = new Stack<>();
        stack_min = new Stack<>();
    }

    public void push(int val) {
        stack_main.push(val);
        if (!stack_min.isEmpty()){
            int stack_min_peek = stack_min.peek();
            if (stack_min_peek > val) stack_min.push(val);
            else stack_min.push(stack_min_peek);
        }
        else stack_min.push(val);

    }

    public void pop() {
        stack_main.pop();
        stack_min.pop();
    }

    public int top() {
        return stack_main.peek();
    }

    public int getMin() {
        return stack_min.peek();

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
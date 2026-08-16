

class MinStack {
    private Stack<Integer> stack; // Main stack to store values
    private Stack<Integer> minStack; // Auxiliary stack to store minimum values

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        // Update the minStack with the new minimum value
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return; // Handle empty stack case
        int poppedValue = stack.pop();
        // If the popped value is the current minimum, remove it from minStack
        if (poppedValue == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.peek(); // Return the top element of the main stack
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return minStack.peek(); // Return the current minimum value
    }
}
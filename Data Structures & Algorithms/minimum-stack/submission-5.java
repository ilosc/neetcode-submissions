class MinStack {

    private final ArrayList<Integer> stack = new ArrayList<>();
    private final ArrayList<Integer> min = new ArrayList<>();

    public MinStack() {
    }
    
    public void push(int val) {
        stack.add(val);
        if (min.isEmpty() || (val <= min.getLast())) {
            min.add(val);
        }
    }
    
    public void pop() {
        int val = stack.removeLast();
        if (val == min.getLast()) {
            min.removeLast();
        }
    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return min.getLast();
    }
}

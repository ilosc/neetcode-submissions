class Solution {
    public int evalRPN(String[] tokens) {
        int[] operands = new int[32];
        int size = 0;
        
        for (String t: tokens) {
            switch(t) {
                case "+":
                    operands[size - 2] = operands[size - 2] + operands[size - 1];
                    size--;
                    break;
                case "-":
                    operands[size - 2] = operands[size - 2] - operands[size - 1];
                    size--;
                    break;
                case "*":
                    operands[size - 2] = operands[size - 2] * operands[size - 1];
                    size--;
                    break;
                case "/":
                    operands[size - 2] = operands[size - 2] / operands[size - 1];
                    size--;
                    break;
                default:
                    if (size == operands.length) {
                        var new_operands = new int[(int)(operands.length * 1.5) + 1];
                        System.arraycopy(operands, 0, new_operands, 0, operands.length);
                        operands = new_operands;
                    }
                    operands[size++] = Integer.parseInt(t);
            
            }

        }
        return operands[0];        
    }
}

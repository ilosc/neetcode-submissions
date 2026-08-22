class Solution {
    public int evalRPN(String[] tokens) {
        int[] operands = new int[32];
        int size = 0;
        
        var operators = new HashSet<String>();
        operators.add("+");
        operators.add("-");
        operators.add("/");
        operators.add("*");

        for (String t: tokens) {
            if (operators.contains(t)) {
                var op1 = operands[size - 1];
                var op2 = operands[size - 2];
                if (t.equals("+")) {
                    operands[size - 2] = op1 + op2;
                } else if (t.equals("-")) {
                    operands[size - 2] = op2 - op1;
                } else if (t.equals("*")) {
                    operands[size - 2] = op1 * op2;
                } else if (t.equals("/")) {
                    operands[size -2 ] = op2 / op1;
                }
                size--;
            } else {
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

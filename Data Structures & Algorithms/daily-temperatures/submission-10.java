class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        var stack = new ArrayList<int[]>();
        var result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            int[] top = null;
            while (!stack.isEmpty() && ((top = stack.getLast())[0] < t)) {
                result[top[1]] = i - top[1];
                stack.removeLast();
            }
            stack.add(new int[] {t, i});
        }

        return result;
    }
}

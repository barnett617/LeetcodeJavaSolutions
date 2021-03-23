package other_problems.checkIn03;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                // 如果栈顶元素没有当前元素大，则出栈
                stack.pop();
            }
            // 如果栈内没有元素，则意味着后面没有大过当前的数
            // 如果栈不空，则栈顶所存索引距离当前索引之间的距离则是距离当前值最近的一个更大数的位置
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            // 栈顶只存当前最大数的索引
            stack.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
        int[] arr = {89,62,70,58,47,47,46,76,100,70};
        int[] ans = dt.dailyTemperatures(arr);
        System.out.println(ans);
    }
}

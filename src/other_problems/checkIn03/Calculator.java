package other_problems.checkIn03;

import java.util.Stack;

public class Calculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char opt = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                if (opt == '+') {
                    stack.push(num);
                } else if (opt == '-') {
                    stack.push(-num);
                } else if (opt == '*') {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                opt = ch;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "14-3/2";
        // String s = "14/3*2";
        // String s = "42";
        // String s = " 3/2 ";
        // String s = "3+2*2";
        Calculator calc = new Calculator();
        int res = calc.calculate(s);
        System.out.println(res);
    }
}

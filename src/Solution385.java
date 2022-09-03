import java.util.ArrayDeque;
import java.util.Deque;

public class Solution385 {
    int index = 0;

    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new MyNestedInteger(Integer.parseInt(s));
        }
        Deque<NestedInteger> stack = new ArrayDeque<>();
        int num = 0;
        boolean negative = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-') {
                negative = true;
            } else if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                stack.push(new MyNestedInteger());
            } else if (c == ',' || c == ']') {
                if (Character.isDigit(s.charAt(i - 1))) {
                    if (negative) {
                        num *= -1;
                    }
                    stack.peek().add(new MyNestedInteger(num));
                }
                num = 0;
                negative = false;
                if (c == ']' && stack.size() > 1) {
                    NestedInteger ni = stack.pop();
                    stack.peek().add((MyNestedInteger) ni);
                }
            }
        }
        return stack.pop();
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {
        void add(MyNestedInteger myNestedInteger);
    }

    public class MyNestedInteger implements NestedInteger {
        public MyNestedInteger() {

        }

        public MyNestedInteger(int i) {

        }

        public void add(int i) {

        }

        @Override
        public void add(MyNestedInteger myNestedInteger) {

        }
    }
}

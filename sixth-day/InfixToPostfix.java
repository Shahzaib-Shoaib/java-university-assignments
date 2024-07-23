import java.util.LinkedList;

public class InfixToPostfix {

    static class LinkedListStack<T> {
        private LinkedList<T> list = new LinkedList<>();

        public void push(T value) {
            list.addFirst(value);
        }

        public T pop() {
            return list.removeFirst();
        }

        public T peek() {
            return list.getFirst();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }
    }

    public static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '|':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String infixToPostfix(String expression) {
        String result = new String("");

        LinkedListStack<Character> stack = new LinkedListStack<>();

        for (int i = 0; i < expression.length(); ++i) {
            char c = expression.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Expression";
                } else {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    if (stack.peek() == '(') {
                        return "Invalid Expression";
                    }
                    result += stack.pop();
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression";
            }
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        String expression = "A+(B*C-(D/E|F)*G)*H";
        System.out.println("Infix Expression: " + expression);
        System.out.println("Postfix Expression: " + infixToPostfix(expression));
    }
}

// Write a program that evaluates the following postfix expression using a stack implemented with an array.

public class PostfixEvaluation {

    static class ArrayStack {
        private int[] arr;
        private int top;
        private int capacity;

        public ArrayStack(int size) {
            arr = new int[size];
            capacity = size;
            top = -1;
        }

        public void push(int x) {
            if (isFull()) {
                System.out.println("Overflow");
                System.exit(1);
            }

            arr[++top] = x;
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Underflow");
                System.exit(1);
            }

            return arr[top--];
        }

        public int peek() {
            if (!isEmpty()) {
                return arr[top];
            } else {
                System.exit(1);
            }

            return -1;
        }

        public int size() {
            return top + 1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == capacity - 1;
        }
    }

    public static int evaluatePostfix(String expression) {
        ArrayStack stack = new ArrayStack(expression.length());

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;

                    case '-':
                        stack.push(val2 - val1);
                        break;

                    case '*':
                        stack.push(val2 * val1);
                        break;

                    case '/':
                        stack.push(val2 / val1);
                        break;
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String expression = "231*+9-";
        System.out.println("Postfix Expression: " + expression);
        System.out.println("Evaluation Result: " + evaluatePostfix(expression));
    }
}

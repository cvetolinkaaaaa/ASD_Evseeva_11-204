public class MyStack {
    private int[] stackArray;
    private int top;
    public MyStack(int size) {
        stackArray = new int[size];
        top = -1;
    }
    public boolean isEmpty() {
        return (top == -1);
    }
    public int size() {
        return top + 1;
    }
    public void push(int elem) {
        if (top == stackArray.length - 1) {
            System.out.println("Stack is full");
        } else {
            stackArray[++top] = elem;
        }
    }
    public int pop() {
        if (top == -1) {
            return -1;
        } else {
            return stackArray[top--];
        }
    }
    public int peek() {
        if (top == -1) {
            return -1;
        } else {
            return stackArray[top];
        }
    }
}

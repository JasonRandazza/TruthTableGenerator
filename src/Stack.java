public class Stack {
    //Node class
    public class Node {
        char data;
        Node next;

        public Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    public Stack() {
        this.top = null;
    }

    public void push(char data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public char pop() {
        if (isEmpty()) {
            return '\0';
        }
        char data = top.data;
        top = top.next;
        return data;
    }

    public char peek() {
        if (isEmpty()) {
            return '\0';
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

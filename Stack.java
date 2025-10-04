package ift2015_a25_tp1;

public class Stack {
	private int maxSize;
    private String[] stackArray;
    private int top;

    public Stack(int size) {
        maxSize = size;
        stackArray = new String[maxSize];
        top = -1;
    }
    
    public int size() {
		return top + 1; // car on commence à 0
    }
   
    public void push(String s) {
        if (size() == maxSize) {
            System.out.println("Cannot complete the operation. Stack is full");
        } else {
            this.stackArray[++top] = s;
        }
    }

    public String pop() {
		if (isEmpty()) {
            return null;
        }else {
            String elementPopped = stackArray[top];
            this.stackArray[top] = null;
            top--;
            return elementPopped;
        }

   }
    
    public String peek() {
        if (isEmpty()) {
            return null;
        }else {
            return this.stackArray[top];
        }
   }

    public boolean isEmpty() {
		return this.top == -1;
    }
    
    // Print stack elements from top to bottom
    public void print_stack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack:");
            System.out.println("---------");
            for (int i = top; i >= 0; i--) {
                System.out.println(stackArray[i]);
                System.out.println("---------");
            }
        }
    }

    
    // some tests
    public static void main(String[] args) {
        Stack stack = new Stack(5); 

        
        stack.push("A");
        stack.push("B");
        stack.print_stack();
        
        System.out.println("Top element of the stack: " + stack.peek());

        
        stack.pop();
        stack.pop();
        stack.pop(); 

        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}

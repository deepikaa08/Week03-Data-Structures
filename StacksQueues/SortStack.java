import java.util.Stack;

public class SortStack{

    // Main function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            sortStack(stack); // Sort the remaining stack
            insertInSortedOrder(stack, top); // Insert the popped item in sorted order
        }
    }

    // Helper function to insert an element in sorted order
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        // Base condition: either stack is empty or top of stack is smaller than element
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        int top = stack.pop();
        insertInSortedOrder(stack, element);
        stack.push(top); // Put the held element back on stack
    }

    // Helper function to print the stack
    public static void printStack(Stack<Integer> stack) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);

        System.out.println("Original Stack:");
        printStack(stack);

        sortStack(stack);

        System.out.println("Sorted Stack:");
        printStack(stack);
    }
}

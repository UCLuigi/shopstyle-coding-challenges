package shopstyle.example;

import java.util.Optional;

/**
 * An {@link Integer} implementation of {@link Stack}.
 *
 * <p>Instances of this class are not thread-safe.</p>
 */
final class IntegerStack implements Stack<Integer> {

    // The default size of stack
    private static final int DEFAULT_SIZE = 10;

    // Stack represented as an integer array
    private int[] stack;

    // Total number of integers in stack
    private int total;

    /** Constructor of IntegerStack with initial size. */
    public IntegerStack(int size) {
        stack = new int[size];
        total = 0;
    }

    /** Constuctor of IntegerStack with Default_size. */
    public IntegerStack() {
        this(DEFAULT_SIZE);
    }

    /** Return boolean whether stack is empty. */
    public boolean isEmpty() {
        return total == 0;
    }

    /** Returns Integer at top of stack and removes it from stack. */
    public Optional<Integer> pop() {
        if (total != 0) {
            Optional item = Optional.of(stack[total - 1]);
            stack[total - 1] = -1;
            total -= 1;
            return item;
        } else {
            System.out.println("No more integers in stack");
            return Optional.empty();
        }
    }

    /** Returns Integer at top of stack without modifying stack. */
    public Optional<Integer> peek() {
        if (total != 0) {
            return Optional.of(stack[total - 1]);
        } else {
            System.out.println("No integers in stack");
            return Optional.empty();
        }
    }

    /** Puts Integer at top of stack. If stack is full, will double stack capacity. */
    public void push(Integer num) {
        if (total + 1 < stack.length) {
            stack[total + 1] = num;
            total += 1;
        } else {
            int[] temp = new int[stack.length * 2];
            for (int i = 0; i < stack.length; i++) {
                temp[i] = stack[i];
            }
            stack = temp;
            stack[total + 1] = num;
            total += 1;
        }
    }
}

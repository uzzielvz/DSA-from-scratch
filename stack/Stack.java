import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A generic LIFO stack implementation based on a resizing array.
 *
 * @param <Item> the generic type of an item in this stack
 */
public class Stack<Item> implements Iterable<Item> {

    private Item[] a; // array of items
    private int n = 0; // number of elements on stack

    /**
     * Initializes an empty stack.
     */
    public Stack() {
        a = (Item[]) new Object[2];
    }

    /**
     * Is this stack empty?
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of items in this stack.
     * @return the number of items in this stack
     */
    public int size() {
        return n;
    }

    /**
     * Resizes the underlying array holding the stack elements.
     * @param capacity the new capacity
     */
    private void resize(int capacity) {
        assert capacity >= n;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    /**
     * Adds the item to this stack.
     * @param item the item to add
     */
    public void push(Item item) {
        if (n == a.length) {
            resize(2 * a.length); // Double array size if it's full
        }
        a[n++] = item;
    }

    /**
     * Removes and returns the item most recently added to this stack.
     * @return the item most recently added
     * @throws NoSuchElementException if this stack is empty
     */
    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        Item item = a[n-1];
        a[n-1] = null; // to avoid loitering
        n--;
        // Shrink size of array if it is one-quarter full
        if (n > 0 && n == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     * @return an iterator to this stack that iterates through the items in LIFO order
     */
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // An iterator, doesn't implement remove() since it's optional
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;

        public ReverseArrayIterator() {
            i = n - 1;
        }

        public boolean hasNext() {
            return i >= 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return a[i--];
        }
    }
}

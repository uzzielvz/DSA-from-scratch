import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A generic bag or multiset, implemented using a singly linked list.
 * This implementation is based on Algorithm 1.4 from the book.
 *
 * @param <Item> the generic type of an item in this bag
 */
public class Bag<Item> implements Iterable<Item> {

    // Helper nested class for the linked list nodes
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    private Node<Item> first; // Head of the linked list (first node in the bag)
    private int n;            // Number of items in the bag

    /**
     * Initializes an empty bag.
     */
    public Bag() {
        first = null;
        n = 0;
    }

    /**
     * Is this bag empty?
     * @return true if this bag is empty; false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this bag.
     * @return the number of items in this bag
     */
    public int size() {
        return n;
    }

    /**
     * Adds the item to this bag.
     * @param item the item to add to this bag
     */
    public void add(Item item) {
        // Same logic as push() in Stack
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    /**
     * Returns an iterator that iterates over the items in this bag in an unspecified order.
     * @return an iterator that iterates over the items in this bag
     */
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator(first);
    }

    // The iterator implementation
    private class ListIterator implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
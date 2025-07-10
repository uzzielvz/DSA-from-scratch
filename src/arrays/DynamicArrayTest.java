package arrays;

import arrays.DynamicArray;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DynamicArrayTest {
    private DynamicArray array;

    @Before
    public void setUp() {
        array = new DynamicArray();
    }

    @Test
    public void testAddAndGet() {
        array.add(10);
        array.add(20);
        assertEquals(10, array.get(0));
        assertEquals(20, array.get(1));
        assertEquals(2, array.size());
    }

    @Test
    public void testAddAtIndex() {
        array.add(10);
        array.add(30);
        array.add(1, 20);
        assertEquals(10, array.get(0));
        assertEquals(20, array.get(1));
        assertEquals(30, array.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtInvalidIndex() {
        array.add(5, 99);
    }

    @Test
    public void testRemoveAt() {
        array.add(1);
        array.add(2);
        array.add(3);
        int removed = array.removeAt(1);
        assertEquals(2, removed);
        assertEquals(2, array.size());
        assertEquals(3, array.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveAtInvalidIndex() {
        array.removeAt(0);
    }

    @Test
    public void testIsEmpty() {
        assertTrue(array.isEmpty());
        array.add(1);
        assertFalse(array.isEmpty());
    }

    @Test
    public void testClear() {
        array.add(1);
        array.add(2);
        array.clear();
        assertEquals(0, array.size());
        assertTrue(array.isEmpty());
    }

    @Test
    public void testResizeGrow() {
        for (int i = 0; i < 15; i++) {
            array.add(i);
        }
        assertTrue(array.capacity() >= 15);
    }

    @Test
    public void testResizeShrink() {
        for (int i = 0; i < 20; i++) {
            array.add(i);
        }
        for (int i = 0; i < 18; i++) {
            array.removeAt(0);
        }
        assertTrue(array.capacity() < 40); // Should shrink
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetInvalidIndex() {
        array.get(0);
    }
}

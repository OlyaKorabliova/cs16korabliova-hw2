package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    
    @Test
    public void testPopObj() {
        Stack st = new Stack();
        st.pop(5);
        st.pop(3);
        Object expected = "[5, 3]";
        Object actual = st.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testPop() {
        Stack st = new Stack();
        st.pop(5);
        st.pop(3);
        Object expected = 3;
        Object actual = st.pop();
        assertEquals(expected, actual);
    }

    @Test
    public void testPeek() {
        Stack st = new Stack();
        st.pop(5);
        st.pop(3);
        Object expected = 3;
        Object actual = st.peek();
        assertEquals(expected, actual);
    }
}

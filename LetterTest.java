

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LetterTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LetterTest
{
    /**
     * Default constructor for test class DigitTest
     */
    public LetterTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testLetterIncrement()
    {
        Letter l = new Letter();
        l.init();
        assertEquals("a", l.getCurrent());
        l.increment();
        assertEquals("b", l.getCurrent());
        l.increment();
        assertEquals("c", l.getCurrent());
        for (int i = 0; i < 23; i++)
        {
            l.increment();
        }

        assertEquals("z", l.getCurrent());
        l.increment();
        assertEquals("a", l.getCurrent());
    }
    
    @Test
    public void testLetterAtEndSingle()
    {
        Letter l = new Letter();
        // a
        assertFalse(l.atEnd());
        for (int i = 0; i < 24; i++)
            l.increment();
        // y
        assertFalse(l.atEnd());
        l.increment();
        // z
        assertTrue(l.atEnd());
        l.increment();
        // a
        assertFalse(l.atEnd());
    }
    
    @Test
    public void testLetterAtEndDouble()
    {
        Letter l = new Letter();
        l.next = new Letter();
        
        // aa
        assertFalse(l.atEnd());
        for (int i = 0; i < 24; i++)
            l.increment();
        // ay
        assertFalse(l.atEnd());
        l.increment();
        // az
        assertFalse(l.atEnd());
        l.increment();
        // ba
        assertFalse(l.atEnd());
        for (int i = 0; i < 26*25-1; i++)
            l.increment();
        // zz
        assertTrue(l.atEnd());
        l.increment();
        // aa
        assertFalse(l.atEnd());
    }
}

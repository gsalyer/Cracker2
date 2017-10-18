

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DigitTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DigitTest
{
    /**
     * Default constructor for test class DigitTest
     */
    public DigitTest()
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
    public void testDigitIncrement()
    {
        Digit d = new Digit();
        d.init();
        assertEquals("0", d.getCurrent());
        d.increment();
        assertEquals("1", d.getCurrent());
        d.increment();
        assertEquals("2", d.getCurrent());
        d.increment();
        d.increment();
        d.increment();
        d.increment();
        d.increment();
        d.increment();
        d.increment();
        assertEquals("9", d.getCurrent());
        d.increment();
        assertEquals("0", d.getCurrent());
    }
    
    @Test
    public void testDigitAtEndSingle()
    {
        Digit d = new Digit();
        // 0
        assertFalse(d.atEnd());
        for (int i = 0; i < 8; i++)
            d.increment();
        // 8
        assertFalse(d.atEnd());
        d.increment();
        // 9
        assertTrue(d.atEnd());
        d.increment();
        // 0
        assertFalse(d.atEnd());
    }
    
    @Test
    public void testDigitAtEndDouble()
    {
        Digit d = new Digit();
        d.next = new Digit();
        
        // 00
        assertFalse(d.atEnd());
        for (int i = 0; i < 8; i++)
            d.increment();
        // 08
        assertFalse(d.atEnd());
        d.increment();
        // 09
        assertFalse(d.atEnd());
        d.increment();
        // 10
        assertFalse(d.atEnd());
        for (int i = 0; i < 10*9-1; i++)
            d.increment();
        // 99
        assertTrue(d.atEnd());
        d.increment();
        // 00
        assertFalse(d.atEnd());
    }
}

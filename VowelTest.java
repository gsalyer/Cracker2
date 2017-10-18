

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VowelTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class VowelTest
{
    /**
     * Default constructor for test class VowelTest
     */
    public VowelTest()
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
    public void testIncrement()
    {
        Vowel v = new Vowel();
        v.init();
        assertEquals("a", v.getCurrent());
        v.increment();
        assertEquals("e", v.getCurrent());
        v.increment();
        assertEquals("i", v.getCurrent());
        v.increment();
        assertEquals("o", v.getCurrent());
        v.increment();
        assertEquals("u", v.getCurrent());
        v.increment();
        assertEquals("a", v.getCurrent());
    }
    
    @Test
    public void testVowelAtEndSingle()
    {
        Vowel v = new Vowel();
        // a
        assertFalse(v.atEnd());
        for (int i = 0; i < 3; i++)
            v.increment();
        // o
        assertFalse(v.atEnd());
        v.increment();
        // u
        assertTrue(v.atEnd());
        v.increment();
        // a
        assertFalse(v.atEnd());
    }
    
    @Test
    public void testVowelAtEndDouble()
    {
        Vowel v = new Vowel();
        v.next = new Vowel();
        
        // aa
        assertFalse(v.atEnd());
        for (int i = 0; i < 3; i++)
            v.increment();
        // ao
        assertFalse(v.atEnd());
        v.increment();
        // au
        assertFalse(v.atEnd());
        v.increment();
        // ea
        assertFalse(v.atEnd());
        for (int i = 0; i < 5*4-1; i++)
            v.increment();
        // uu
        assertTrue(v.atEnd());
        v.increment();
        // aa
        assertFalse(v.atEnd());
    }
}

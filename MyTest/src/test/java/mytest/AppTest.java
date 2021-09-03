package mytest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private App app = new App();
	
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test
    public void testValue() {
    	int val = app.getValue();
    	assertEquals(10, val);
    }
    
    @Test
    public void testValue2() {
    	int val = app.getValue();
    	assertEquals(9, val);
    }

}

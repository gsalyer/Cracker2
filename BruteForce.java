import java.util.ArrayList;

public class BruteForce
{
    Dial first;
    
    // Initialize the word to the first value (eg, "aaaaa")
    public void init(int length)
    {
        if(length == 0)
		{
			first = null;
			return;
		}
		
		// Create first dial
        Dial newDial = new Letter();   
        first = newDial;
        
        // Create (length-1) more dials, each connected
        // to the next one
        for (int i = 0; i < length - 1; i++)
        {
            newDial.setNext(new Letter());
            newDial = newDial.getNext();
        }
        
        // The last dial is connected to nothing
        newDial.setNext(null);
    }
    
  
    // Initialize the dials using a pattern.
    // This does not work as-is. Needs to be gutted
    // and modified to use the linked list of dials.
    public void init(String pattern)
    {
		Dial newDial = null;if (pattern.charAt(pattern.length() - 1) == 'l')
		{
			newDial = new Letter();   
			first = newDial;
		}
		else if (pattern.charAt(pattern.length() - 1) == 'd')
		{
			newDial = new Digit();   
			first = newDial;
		}
		else if (pattern.charAt(pattern.length() - 1) == 'v')
		{
			newDial = new Vowel();   
			first = newDial;
		}
		else if(pattern.charAt(pattern.length() - 1) == 's')
		{
			newDial = new Symbol();   
			first = newDial;
		}
		
        for (int i = pattern.length() - 2; i >= 0; i--)
        {
            if (pattern.charAt(i) == 'l')
            {
				newDial.setNext(new Letter());
				newDial = newDial.getNext();
            }
            else if (pattern.charAt(i) == 'd')
            {
				newDial.setNext(new Digit());
				newDial = newDial.getNext();
            }
            else if (pattern.charAt(i) == 'v')
            {
				newDial.setNext(new Vowel());
				newDial = newDial.getNext();
            }
			else if(pattern.charAt(i) == 's')
			{
				newDial.setNext(new Symbol());
				newDial = newDial.getNext();
			}
        }
    }
   
    
    // Return the current word
    public String getCurrent()
    {
        if(first == null)
			return "";
		else
			return first.getCurrent();
    }
    
    // Increment to the next word
    
    public void increment()
    {
        first.increment();
    }
    
    // Is this the last word?
    public boolean atEnd()
    {
        if(first == null)
			return true;
		
		// return whatever the first dial says
        
        return first.atEnd();
    }
    
}
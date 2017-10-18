public class Letter implements Dial
{
    char value;
    Dial next;
    
    public Letter()
    {
        init();
    }
    
    /**
     * Initialize this dial
     */
    public void init()
    {
        value = 'a';
    }
    
    /**
     * Return true if this dial and all the next
     * ones are at the end.
     */
    public boolean atEnd()
    {
        // If my value is not the last one, return false
        // Else return whatever the next dial says,
        //    if there is one
        if(value != 'z')
			return false;
		else if(next != null)
			return next.atEnd();
		else
			return true;
    }
    
    /**
     * Increment this dial.
     * If there is a rollover, increment the next one.
     */
    public void increment()
    {
        if (value == 'z') 
        {
            value = 'a';
            if (next != null)
                next.increment();
        }
        else value++;
    }
    
    /**
     * Get the value of this dial plus all the
     * next ones.
     */
    public String getCurrent()
    {
        if (next == null)   // Hey, I'm the last dial!
        {
            return "" + value;
        }
        else            // I'm NOT the last dial
        {
            return next.getCurrent() + value;
        }
    }
    
    /**
     * Getter
     */
    public Dial getNext()
    {
        return next;
    }
    
    /**
     * Setter
     */
    public void setNext(Dial n)
    {
        next = n;
    }
}
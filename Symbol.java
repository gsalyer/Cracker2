public class Symbol implements Dial
{
    char value;
    Dial next;
	final char[] SYMBOLS = new char[]{'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '\\', '/'};
    
    public Symbol()
    {
        init();
    }
    
    public void init()
    {
        value = '!';
    }
    
    public boolean atEnd()
    {
        if(value != '/')
			return false;
		else if(next != null)
			return next.atEnd();
		else
			return true;
    }
    
    public void increment()
    {
        if (value == '/')
		{
			value = '!';
			if(next != null)
				next.increment();
		}
        else
			value = SYMBOLS[(new String(SYMBOLS).indexOf(value)) + 1];
    }
    
    public String getCurrent()
    {
        if (next == null)
        {
            return "" + value;
        }
        else
        {
            return next.getCurrent() + value;
        }
    }
    
    public Dial getNext()
    {
        return next;
    }
    
    public void setNext(Dial n)
    {
        next = n;
    }
}
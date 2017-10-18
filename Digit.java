public class Digit implements Dial
{
    char value;
    Dial next;
    
    public Digit()
    {
        init();
    }
    
    public void init()
    {
        value = '0';
    }
    
    public boolean atEnd()
    {
        if(value != '9')
			return false;
		else if(next != null)
			return next.atEnd();
		else
			return true;
    }
    
    public void increment()
    {
        if (value == '9') 
        {
            value = '0';
            if (next != null)
                next.increment();
        }
        else value++;
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
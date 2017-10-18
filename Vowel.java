public class Vowel implements Dial
{
    char value;
    Dial next;
	final char[] VOWELS = new char[]{'a', 'e', 'i', 'o', 'u'};
    
    public Vowel()
    {
        init();
    }
    
    public void init()
    {
        value = 'a';
    }
    
    public boolean atEnd()
    {
        if(value != 'u')
			return false;
		else if(next != null)
			return next.atEnd();
		else
			return true;
    }
    
    public void increment()
    {
        if (value == 'u')
		{
			value = 'a';
			if(next != null)
				next.increment();
		}			
        else
			value = VOWELS[(new String(VOWELS).indexOf(value)) + 1];
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
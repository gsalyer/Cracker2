public interface Dial
{
    public String getCurrent();
    public void increment();
    public boolean atEnd();
    public void init();
    public Dial getNext();
    public void setNext(Dial n);
}
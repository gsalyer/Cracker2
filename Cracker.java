import java.util.ArrayList;
import java.util.HashSet;
import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class Cracker
{
    HashSet<String> words;
    ArrayList<String> hashes;
    private MessageDigest md;
    
    public Cracker()
    {
        words = new HashSet<String>();
        hashes = new ArrayList<String>();
        try
        {
            md = MessageDigest.getInstance("MD5");
        }
        catch (java.security.NoSuchAlgorithmException e)
        {
            md = null;
        }
    }
    
    public String makeHash(String str)
    {
        if (md != null)
        {
            md.reset();
            md.update(str.getBytes());
            return DatatypeConverter.printHexBinary(md.digest());
        }
        else
        {
            return str;
        }
    }
    
    /**
     * Read a file into a HashSet
     */
    public void readFile(String filename, HashSet<String> dest)
    {
        BufferedReader br;
        
        if (dest == null)
            dest = new HashSet<String>();
        
        try {
            File f = new File(filename);
            FileReader fr = new FileReader(f);
            br = new BufferedReader(fr);
        }
        catch (java.io.FileNotFoundException fnfe)
        {
            return;
        }
    
        String line;
        try {
            while ((line = br.readLine()) != null)
            {
                dest.add(line);
            }
        }
        catch (java.io.IOException ioe)
        {
            return;
        }
    }
    
    /**
     * Crack a single hash using the dictionary
     * stored in the "words" list.
     */
    public String crackHash(String target)
    {
        for (String word : words)
        {
            String wordHash = makeHash(word);
            if (wordHash.equals(target)) return word;
        }
        return null;
    }
    
    /**
     * Crack a file of hashes using brute force with a pattern.
     * Example:
     *     Cracker c = new Cracker();
     *     c.crackFileBruteForce("mixhash.txt", "llldl");
     */
    public void crackFileBruteForce(String filename, String pattern)
    {
        HashSet<String> hashes = new HashSet<String>();
        readFile(filename, hashes);
        
        BruteForce b = new BruteForce();
        b.init(pattern);
        while (!b.atEnd())
        {
            String hash = makeHash(b.getCurrent());
            if (words.contains(hash))
            {
                System.out.println(hash + " " + b.getCurrent());
            }
            b.increment();
        }
    }
    
    /**
     * Crack a single hash using brute force with a pattern.
     * Example:
     *     Cracker c = new Cracker();
     *     c.crackHashBruteForce("BC6E229421C77A4C011B0B360EE1D03E", "llldl");
     */
    public void crackHashBruteForce(String target, String pattern)
    {
        BruteForce b = new BruteForce();
        b.init(pattern);
        while (!b.atEnd())
        {
            String hash = makeHash(b.getCurrent());
            if (target.equals(hash))
            {
                System.out.println(hash + " " + b.getCurrent());
                break;
            }
            b.increment();
        }
    }
    
 
}
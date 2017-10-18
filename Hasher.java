import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

public class Hasher
{
    // Read in a file containting words to hash
    // Randomly pick 10 of them
    // hash them
    // Write those to a file
    
    ArrayList<String> arr;
    
    public Hasher()
    {
        arr = new ArrayList<String>();
    }
    
    public Hasher(String inFile, String outFile)
    {
        arr = new ArrayList<String>();
        readFile(inFile);
        writeFile(hashem(pick10()), outFile);
    }
    
    public void readFile(String filename)
    {
        BufferedReader br;
        
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
                arr.add(line);
            }
        }
        catch (java.io.IOException ioe)
        {
            return;
        }
        //System.out.println(arr.size());
    }
    
    public String pick()
    {
        Random r = new Random();
        int index = r.nextInt(arr.size());
        return arr.get(index);
    }
    
    public ArrayList<String> pick10()
    {
        // TODO: Make sure there are no duplicates
        ArrayList<String> a = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            a.add(pick());
        }
        return a;
    }
    
    
    public ArrayList<String> hashem(ArrayList<String> words)
    {
        ArrayList<String> hashes = new ArrayList<String>();
        
        for (String word : words)
        {
            MessageDigest md;
            try
            {
                md = MessageDigest.getInstance("MD5");
            } catch (java.security.NoSuchAlgorithmException e)
            {   
                return null;
            }
            md.reset();
            md.update(word.getBytes());
            String hash = DatatypeConverter.printHexBinary(md.digest());
            
            hashes.add(hash);
        }
        return hashes;
    }
    
    public void writeFile(ArrayList<String> hashes, String filename)
    {
        BufferedWriter bw;
        
        try
        {
            File f = new File(filename);
            FileWriter fw = new FileWriter(f);
            bw = new BufferedWriter(fw);
        }
        catch (java.io.FileNotFoundException fnfe)
        {
            System.out.println("File didn't exist.");
            return;
        }
        catch (java.io.IOException ioe)
        {
            return;
        }
        
        for (String hash : hashes)
        {
            try
            {
                bw.write(hash);
                bw.newLine();
            }
            catch (java.io.IOException ioe)
            {
                return;
            }
        }
        
        try
        {
            bw.close();
        }
        catch(java.io.IOException ioe)
        {
            return;
        }
    }
}
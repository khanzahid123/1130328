package Client;
import java.math.BigInteger; 
import java.util.Random;
import java.io.*;
import java.net.*;
import java.security.*;
import javax.crypto.*;
public class Client { 

    private BigInteger p; 
    private BigInteger q; 
    private BigInteger N; 
    private BigInteger phi; 
    private BigInteger e; 
    private BigInteger d; 
    private int bitlength = 1024; 
    private int blocksize = 256; //blocksize in byte 
     
    private Random r; 
     public Client() { 
        r = new Random(); 
        p = BigInteger.probablePrime(bitlength, r); 
        q = BigInteger.probablePrime(bitlength, r); 
        N = p.multiply(q); 
           
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)); 
        e = BigInteger.probablePrime(bitlength/2, r); 
         
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0 ) { 
            e.add(BigInteger.ONE); 
        } 
 d = e.modInverse(phi);  
    } 
     
    public Client(BigInteger e, BigInteger d, BigInteger N) { 
        this.e = e; 
        this.d = d; 
        this.N = N; 
    } 
     
    public static void main (String[] args) throws IOException
{ 
        Client rsa = new Client(); 
        //DataInputStream in=new DataInputStream(System.in);  
        		int port=2000;
        File f1=new File("C:\\Users\\install\\Desktop\\rsa\\Client\\input.txt");
        FileReader fr=new FileReader(f1);
        BufferedReader br=new BufferedReader(fr);
        Socket s2=new Socket("127.0.0.1",port);
        DataInputStream di;
        di = new DataInputStream(s2.getInputStream());
        String teststring=br.readLine();
         File file2=new File("C:\\Users\\install\\Desktop\\rsa\\Client\\Decrypt.txt");
        FileWriter fw=new FileWriter(file2);
        BufferedWriter bw=new BufferedWriter(fw);
        
        
        //System.out.println("Encrypting String: " + teststring); 
        
        //System.out.println("String in Bytes: " + bytesToString(teststring.getBytes())); 
     
        // encrypt 
        byte[] encrypted = rsa.encrypt(teststring.getBytes());                   
       // System.out.println("Encrypted String in Bytes: " + bytesToString(encrypted)); 
         PrintStream p=new PrintStream(s2.getOutputStream());
        p.println(encrypted);
        
        
        // decrypt 
        byte[] decrypted = rsa.decrypt(encrypted);       
        //System.out.println("Decrypted String in Bytes: " +  bytesToString(decrypted)); 
         bw.write(teststring);
         bw.close();
        //System.out.println("Decrypted String: " + new String(decrypted)); 
         
    } 

   private static String bytesToString(byte[] encrypted) { 
        String test = ""; 
        for (byte b : encrypted) { 
            test += Byte.toString(b); 
        } 
        return test; 
    } 
     
 //Encrypt message
     public byte[] encrypt(byte[] message) {      
        return (new BigInteger(message)).modPow(e, N).toByteArray(); 
    } 
       
// Decrypt message
    public byte[] decrypt(byte[] message) { 
        return (new BigInteger(message)).modPow(d, N).toByteArray(); 
    }  
}

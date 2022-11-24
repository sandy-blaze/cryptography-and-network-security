import java.util.*;
import java.math.*;
import java.security.*;

public class MD5 {
    final public static String algo = "MD5";
    public static String getHashCode(String message) throws Exception {
        MessageDigest md = MessageDigest.getInstance(algo);
        byte[] hashCode = md.digest(message.getBytes());
        BigInteger number = new BigInteger(1, hashCode);
        String hashText = number.toString(16);
        return hashText;
    }
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String message = input.nextLine();
        String hashCode = getHashCode(message);
        System.out.println(hashCode);
        input.close();
    }
}

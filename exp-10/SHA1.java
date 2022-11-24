import java.util.*;
import java.math.*;
import java.security.*;

public class SHA1 {
    final public static String algo = "SHA-1";
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

import java.util.*;
import javax.crypto.*;

public class DES {
    final static String algo = "DES";
    static SecretKey key;
    public static void generateKey() throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance(algo);
        kg.init(56);
        SecretKey sk = kg.generateKey();
        key = sk;
    }
    public static byte[] encrypt(String message) throws Exception {
        Cipher myCipher = Cipher.getInstance(algo);
        myCipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherText = myCipher.doFinal(message.getBytes());
        return cipherText;
    }
    public static String decrypt(byte[] cipherBytes) throws Exception {
        Cipher myCipher = Cipher.getInstance(algo);
        myCipher.init(Cipher.DECRYPT_MODE, key);
        byte[] planeBytes = myCipher.doFinal(cipherBytes);
        String msg = "";
        for (int i = 0; i < planeBytes.length; ++i) {
            msg += (char)planeBytes[i];
        }
        return msg;
    }
    public static void printCipher(byte[] cipherText) {
        for (byte x : cipherText) {
            System.out.print(String.format("%02X", x));
        }
        System.out.println();
    }
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        generateKey();
        String message = input.nextLine();
        byte[] cipherText = encrypt(message);
        printCipher(cipherText);
        String originalMsg = decrypt(cipherText);
        System.out.println(originalMsg);
        input.close();
    }
}

import java.util.*;

public class RC4 {
    public static void main(String[] args) {
        int temp, j, MOD = 256;
        int[] k = new int[10];
        int[] s = new int[MOD];
        int[] t = new int[MOD];
        Random random = new Random();
        for (int i = 0; i < k.length; ++i) {
            k[i] = random.nextInt(MOD);
        }
        for (int i = 0; i < MOD; ++i) {
            s[i] = i;
            t[i] = k[i % k.length];
        }
        j = 0;
        for (int i = 0; i < MOD; ++i) {
            j = (j + s[i] + t[i]) % MOD;
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        String plainText = "Hello world";
        System.out.println(plainText);
        int n = plainText.length();
        int[] cipher = new int[n];
        j = 0;
        for (int i = 0; i < n; ++i) {
            cipher[i] = (int)plainText.charAt(i);
            j = (j + s[i]) % MOD;
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            cipher[i] ^= (s[i] + s[j]) % MOD;
            System.out.print(String.format("%02x", cipher[i]));
        }
        System.out.println();
    }
}

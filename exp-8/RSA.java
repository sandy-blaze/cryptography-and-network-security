import java.util.*;

public class RSA {
    public static int n, pn, e, d;
    public static int gcd(int a, int b) {
        if (a == 0 || b == 0) 
            return a > b ? a : b;
        return gcd(b, a % b); 
    }
    public static int pow(int n, int k, int MOD) {
        if (k == 0)
            return 1;
        long t = pow(n, k / 2, MOD);
        t = (t * t) % MOD;
        if (k % 2 == 1)
            t = (t * n) % MOD;
        return (int)t;
    }
    public static int encode(int m) {
        return pow(m, e, n);
    }
    public static int decode(int c) {
        return pow(c, d, n);
    }
    public static void init(int p, int q) {
        e = 2;
        n = p * q;
        pn = (p - 1) * (q - 1);
        while (gcd(e, pn) != 1) 
            e++;
        d = 0;
        while ((e * d) % pn != 1)
            d++;
    }
    public static int[] encrypt(String message) {
        byte[] msg = message.getBytes();
        int[] cipher = new int[msg.length];
        for (int i = 0; i < msg.length; ++i) {
            cipher[i] = encode(msg[i]);
        }
        return cipher;
    }
    public static String decrypt(int[] cipher) {
        String msg = "";
        for (int x : cipher) {
            msg += (char)decode(x);
        }
        return msg;
    }
    public static void printHex(int[] cipher) {
        for (int x : cipher) {
            System.out.print(String.format("%04X", x));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        init(257, 263);
        Scanner input = new Scanner(System.in);
        String message = input.nextLine();
        int[] cipher = encrypt(message);
        printHex(cipher);
        String original = decrypt(cipher);
        System.out.println(original);
        input.close();
    }
}

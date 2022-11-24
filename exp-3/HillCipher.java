import java.util.*;

public class HillCipher {
    public static int[][] encryptKey;
    public static int[][] decryptKey;
    public static void init() {
        encryptKey = new int[][]{
            {6, 24, 1},
            {13, 16, 10},
            {20, 17, 15}
        };
        decryptKey = new int[][]{
            {118, 113, 224},
            {173, 118, 217},
            {5, 74, 104}
        };
    }
    public static void convert(int[] arr, int[][] key) {
        int n = key.length;
        int[] c = new int[key.length];
        for (int i = 0; i < arr.length; i += n) {
            for (int j = 0; j < key.length; ++j) {
                c[j] = 0;
                for (int k = 0; k < key.length; ++k) {
                    c[j] += key[j][k] * arr[i + k];
                }
                c[j] %= 256;
            }
            for (int j = 0; j < key.length; ++j) {
                arr[i + j] = c[j] % 256;
            }
        }
    }
    public static int[] getArray(String text) {
        int n = text.length();
        int size = n;
        if (n % encryptKey.length != 0) 
            n += encryptKey.length - n % encryptKey.length;
        int[] a = new int[n];
        for (int i = 0; i < size; ++i) {
            a[i] = (int)text.charAt(i);
        }
        return a;
    }
    public static void printHex(int[] cipher) {
        for (int x : cipher) {
            System.out.print(String.format("%04X", x));
        }
        System.out.println();
    }
    public static String getString(int[] arr) {
        String msg = "";
        for (int x : arr) {
            msg += (char)x;
        }
        return msg;
    }
    public static void main(String[] args) {
        init();
        Scanner input = new Scanner(System.in);
        String message = input.nextLine();
        int[] arr = getArray(message);
        convert(arr, encryptKey);
        printHex(arr);
        convert(arr, decryptKey);
        String original = getString(arr);
        System.out.println(original);
        input.close();
    }
}

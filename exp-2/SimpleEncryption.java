import java.util.*;

class SimpleEncryption {
    public static void main(String[] args) {
        final int number = 127;
        Scanner scanner = new Scanner(System.in);
        char[] plainText = scanner.nextLine().toCharArray();
        ArrayList<Integer> cipherTextAND = new ArrayList<>(plainText.length);
        ArrayList<Integer> cipherTextOR = new ArrayList<>(plainText.length);
        ArrayList<Integer> cipherTextXOR = new ArrayList<>(plainText.length);
        for (char character : plainText) {
            cipherTextAND.add((int)character & number);
            cipherTextOR.add((int)character | number);
            cipherTextXOR.add((int)character ^ number);
        }
        System.out.println(cipherTextAND);
        System.out.println(cipherTextOR);
        System.out.println(cipherTextXOR);
        scanner.close();
    }
}

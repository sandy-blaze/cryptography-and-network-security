import java.util.*;

class DummyEncrypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] plainText = scanner.nextLine().toCharArray();
        ArrayList<Integer> cipherText = new ArrayList<>(plainText.length);
        for (char character : plainText) {
            cipherText.add((int)character ^ 0);
        }
        System.out.println(cipherText);
        scanner.close();
    }
}

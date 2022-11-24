import java.util.*;

class CeaserCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String plainText = scanner.nextLine();
        int shift = scanner.nextInt();
        String cipherText = encypt(plainText, shift); 
        System.out.println(cipherText);
        System.out.println(decypt(cipherText, shift));
        scanner.close();
    }
    public static String encypt(String plainText, int shift) {
        shift %= 26;
        char[] plainTextArray = plainText.toCharArray();
        StringBuilder cipherTextArray = new StringBuilder(plainTextArray.length);
        for (char character : plainTextArray) {
            if (character == ' ') cipherTextArray.append(' ');
            else cipherTextArray.append((char)((((int)character - 97 + shift) % 26 + 26) % 26 + 97));
        }
        return cipherTextArray.toString();
    }
    public static String decypt(String plainText, int shift) {
        shift %= 26;
        char[] plainTextArray = plainText.toCharArray();
        StringBuilder cipherTextArray = new StringBuilder(plainTextArray.length);
        for (char character : plainTextArray) {
            if (character == ' ') cipherTextArray.append(' ');
            else cipherTextArray.append((char)((((int)character - 97 - shift) % 26 + 26) % 26 + 97));
        }
        return cipherTextArray.toString();
    }
}

import java.util.*;

class SubstitutionCipher {
    public static int[] rKey = new int[256];
    public static ArrayList<Integer> key = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 256; ++i) {
            key.add(i);
        }
        Collections.shuffle(key);
        for (int i = 0; i < 256; ++i) {
            rKey[key.get(i)] = i;
        }
        String plainText = scanner.nextLine();
        String cipherText = encypt(plainText);
        System.out.println(cipherText);
        System.out.println(decypt(cipherText));
        scanner.close();
    }
    public static String encypt(String plainText) {
        char[] plainTextArray = plainText.toCharArray();
        StringBuilder cipherTextArray = new StringBuilder(plainTextArray.length);
        for (char character : plainTextArray) {
            cipherTextArray.append((char)(int)key.get(character));
        }
        return cipherTextArray.toString();
    }
    public static String decypt(String plainText) {
        int shift = 3;
        char[] plainTextArray = plainText.toCharArray();
        StringBuilder cipherTextArray = new StringBuilder(plainTextArray.length);
        for (char character : plainTextArray) {
            cipherTextArray.append((char)rKey[character]);
        }
        return cipherTextArray.toString();
    }
}

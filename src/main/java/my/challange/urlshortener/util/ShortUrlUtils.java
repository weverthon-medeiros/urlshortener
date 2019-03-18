package my.challange.urlshortener.util;

/**
 * @author weverthonmedeiros
 */
public class ShortUrlUtils {
    private static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int BASE = ALPHABET.length();

    public static String encode(Integer id) {
        StringBuilder str = new StringBuilder();
        while (id > 0) {
            str.insert(0, ALPHABET.charAt(id % BASE));
            id = id / BASE;
        }
        return str.toString();
    }

    public static int decode(String shortCode) {
        int num = 0;
        for (int i = 0; i < shortCode.length(); i++) {
            num = num * BASE + ALPHABET.indexOf(shortCode.charAt(i));
        }
        return num;
    }
}

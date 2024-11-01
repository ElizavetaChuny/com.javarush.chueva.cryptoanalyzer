import java.util.Arrays;
import java.util.HashMap;

public class DecryptionBruteForce {
    public HashMap<Integer, String> bruteForce (char[] text) {
        int key = 1;
        char[] brut = new char[text.length];
        HashMap<Integer, String> resultBruteForce = new HashMap();

        for (int i = 0; i < CaesarCipher.ALPHABET.length; i++) {
            for (int j = 0; j < text.length; j++){
                int index = Arrays.binarySearch(CaesarCipher.ALPHABET, text[j]);
                if (key > index){
                    brut[j] = CaesarCipher.ALPHABET[CaesarCipher.ALPHABET.length - Math.abs(index - key)];
                } else {
                    brut[j] = CaesarCipher.ALPHABET[index - key];
                }
            }

            String value = new String(brut);
            resultBruteForce.put(key, value);
            key ++;

        }
        return resultBruteForce;
    }

    public String resultBruteForce (char[] bruteForce, int kyeBruteForce) {
        DecryptionBruteForce decryptionBruteForce = new DecryptionBruteForce();

        HashMap<Integer, String> brute = decryptionBruteForce.bruteForce(bruteForce);

        String result  = brute.get(kyeBruteForce);

        return result;
    }
}

import java.util.Arrays;
public class Encryption {

    public String encryption(char[] text, int valueKey) {
        int key = 0;
        char[] encrypted = new char[text.length];
        if (Math.abs(valueKey) <= CaesarCipher.ALPHABET.length && valueKey >= 0){
            key = Math.abs(valueKey);
        }else if (Math.abs(valueKey) > CaesarCipher.ALPHABET.length){
            key = Math.abs(valueKey % CaesarCipher.ALPHABET.length);
        }

        for (int i = 0; i < text.length; i++){
            int index = Arrays.binarySearch(CaesarCipher.ALPHABET, text[i]);
            if ((index + key) > CaesarCipher.ALPHABET.length){
                encrypted[i] = CaesarCipher.ALPHABET[(index + key)-CaesarCipher.ALPHABET.length];
            } else {
                encrypted[i] = CaesarCipher.ALPHABET[index + key];
            }
        }
        String encryption = Arrays.toString(encrypted);

        return encryption;
    }
}

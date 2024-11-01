import java.util.Arrays;

public class DecryptionKye {
    public String decryptionKey(char[] text, int valueKey) {
        int key = 0;
        char[] decryption = new char[text.length];
        if (Math.abs(valueKey) <= CaesarCipher.ALPHABET.length && valueKey >= 0){
            key = Math.abs(valueKey);
        }else if (Math.abs(valueKey) > CaesarCipher.ALPHABET.length){
            key = Math.abs(valueKey%CaesarCipher.ALPHABET.length);
        }

        for (int i = 0; i < text.length; i++){
            int index = Arrays.binarySearch(CaesarCipher.ALPHABET, text[i]);
            if (key > index){
                decryption[i] = CaesarCipher.ALPHABET[CaesarCipher.ALPHABET.length - Math.abs(index - key)];
            } else {
                decryption[i] = CaesarCipher.ALPHABET[index - key];
            }
        }
        String decrypt = Arrays.toString(decryption);

        return decrypt;
    }
}

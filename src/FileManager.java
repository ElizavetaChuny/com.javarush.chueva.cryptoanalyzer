import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.io.IOException;
import java.util.Arrays;

public class FileManager {
    public char[] readFile(String filePath) throws IOException, NotElementException {
        String text = null;

        try (BufferedReader reader = Files.newBufferedReader(Path.of(filePath))){
            String line;
            while ((line = reader.readLine()) != null) {
                text = line;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            System.exit(0);
        } catch (NoSuchFileException ex) {
            System.out.println("Файл не найден или ошибка открытия файла");
            System.exit(0);
        }

        char[] readFile = null;
        try {
            readFile = text.toCharArray();
            for (int i = 0; i < readFile.length; i++) {
                if(Arrays.binarySearch(CaesarCipher.ALPHABET, readFile[i]) == -1){
                    throw new NotElementException("Элемент отсутсвует");
                }
            }
        } catch (NotElementException ex){
            System.out.println(ex.getMessage());
            System.exit(0);
        }

        return readFile;
    }

    public void writeFile(String pathFile, String resultCipher) throws IOException {
        Path newFile = Path.of(pathFile);
        try {
            Files.writeString(newFile, resultCipher);
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
        }
    }
}

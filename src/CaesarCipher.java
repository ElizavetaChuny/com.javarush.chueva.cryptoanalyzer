import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;

public class CaesarCipher {
    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public static void main(String[] args) throws IOException, NotElementException {
        Scanner scanner = new Scanner(System.in);
        Encryption encryption = new Encryption();
        DecryptionKye decryptionKey = new DecryptionKye();
        DecryptionBruteForce decryptionBruteForce = new DecryptionBruteForce();
        FileManager fileManager = new FileManager();

        System.out.println("Доброго времени суток!");
        System.out.println("Работаем с шифром цезаря.");

        System.out.println("Введите путь к файлу с которым небходимо будет произвести работу:");
        String pathFile = scanner.nextLine();
        char[] readFile = fileManager.readFile(pathFile);

        System.out.println("Введите путь к файлу, в который будет занесена полученная информация:");
        String path = scanner.nextLine();

        System.out.println("1 - Зашифровать текст");
        System.out.println("2 - Рассшифровать текст, используя ключ");
        System.out.println("3 - Рассшифровать текст, не имея ключа");
        System.out.println("Введите цифру задачи, которую необходимо будет совершить с текстом в файле");
        int task = 0;
        try {
            task = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Введите целое чило (от 1 до 3 включитльно)");
            System.exit(0);
        }


        if (task == 1) {
            System.out.println("Введите значение ключа:");
            int key = 0;
            try {
                key = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Неверное значение ключа.");
            }
            System.out.println("Проведм шивровку данных (Encryption)");
            String encryp = encryption.encryption(readFile, key);
            System.out.println("Результат шифровки данных: " + encryp);

            System.out.println("Записываем полученную ранее информацию в файл");
            fileManager.writeFile(path, encryp);
        } else if (task == 2) {
            System.out.println("Введите значение ключа:");
            int key = 0;
            try {
                key = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Неверное значение ключа.");
            }
            System.out.println("Теперь расшифровку с помощью ключа");
            String decrKye = decryptionKey.decryptionKey(readFile, key);
            System.out.println("Резальтат расшифровки данных с ключом: " + decrKye);

            System.out.println("Записываем полученную ранее информацию в файл");
            fileManager.writeFile(path, decrKye);
        } else if (task == 3) {
            System.out.println("Для расшифровки данных без ключа мне необходима ваша помощь");
            System.out.println("Выберите ключ значение которого является наиболле похожим на русские слова");
            HashMap<Integer, String> brute = decryptionBruteForce.bruteForce(readFile);
            brute.forEach((cod, value) -> System.out.println(cod + ": " + value));

            System.out.println("Введите значение этого ключа");
            int codBruteForce = 0;
            try {
                codBruteForce = scanner.nextInt();
            } catch (NoSuchElementException e) {
                System.out.println("Неверное значение ключа.");
            }
            String bruteForceStr = decryptionBruteForce.resultBruteForce(readFile, codBruteForce);
            System.out.println("Результат расшифровки методом Brute Force: " + bruteForceStr);

            System.out.println("Записываем полученную ранее информацию в файл");
            fileManager.writeFile(path, bruteForceStr);
        } else {
            System.out.println("Не верное значение задачи!");
        }

    }
}

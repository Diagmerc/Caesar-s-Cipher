import java.io.IOException;
import java.util.Scanner;

public class Choise {
    public static void choiser() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerNums = new Scanner(System.in);
        System.out.println("Выбирите цифру: \n 1. Закодировать тесктовый файл. \n 2. Раскодировать файл с помощью ключа. \n 3. Раскодировать файл, если забыли ключ. \n 4. Выйти");
        int choise = scannerNums.nextInt();
        if (choise == 1) {
            System.out.println("Введите путь к текстовому файлу.");
            String path = scanner.nextLine();
            String text = ReadWrite.read(path);
            System.out.println("Введите ключ для кодирования текста от 1 до 127");
            byte key = scannerNums.nextByte();
            String encryptText = Encrypt.encrypt(text, key);
            ReadWrite.writeEncrypt(path, encryptText, key);
        } else if (choise == 2) {
            System.out.println("Введите путь к текстовому файлу.");
            String path = scanner.nextLine();
            String text = ReadWrite.read(path);
            System.out.println("Введите ключ для раскодировки текста");
            byte key = scannerNums.nextByte();
            String decryptText = Encrypt.decrypt(text, key);
            ReadWrite.writeEncrypt(path, decryptText, key);
        } else if (choise == 3) {
            System.out.println("Введите путь к текстовому файлу.");
            String path = scanner.nextLine();
            String text = ReadWrite.read(path);
            byte key = BruteForce.decrypt(text);
            String decryptText = Encrypt.decrypt(text, key);
            ReadWrite.writeEncrypt(path, decryptText, key);
            System.out.println("Тест расшифрован, ключ: " + key);
        } else if (choise == 4) {
            System.exit(1);
        } else {
            System.out.println("Выберите цифру от 1 до 4");
            choiser();
        }
    }
}


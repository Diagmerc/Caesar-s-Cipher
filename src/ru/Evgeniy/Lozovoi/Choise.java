package ru.Evgeniy.Lozovoi;

import java.io.IOException;
import java.util.Scanner;

public class Choise {
    private static String pathText = "Введите путь к текстовому файлу.";
    private static String path = " ";
    private static String text = " ";

    // метод предалагает кодировать или раскодировать текст
    public  void choiser() throws IOException {
        StaticAnalyse staticAnalyse = new StaticAnalyse();
        BruteForce bruteForce = new BruteForce();
        Encrypt encrypt = new Encrypt();
        Scanner scanner = new Scanner(System.in);
        Scanner scannerNums = new Scanner(System.in);
        System.out.println("Выбирите цифру: \n 1. Закодировать тесктовый файл. \n 2. Раскодировать файл с помощью ключа. \n 3. Раскодировать файл, если забыли ключ. \n 4. Раскодировать методом статистического анализа.\n 5. Выйти");
        int choise = scannerNums.nextInt();
        if (choise == 1) {
            System.out.println(pathText);
            path = scanner.nextLine();
            text = ReadWrite.read(path);
            System.out.println("Введите ключ для кодирования текста от 1 до 127");
            byte key = scannerNums.nextByte();
            String encryptText = encrypt.encrypt(text, key);
            ReadWrite.writeEncrypt(path, encryptText, key);
        } else if (choise == 2) {
            System.out.println(pathText);
            path = scanner.nextLine();
            text = ReadWrite.read(path);
            System.out.println("Введите ключ для раскодировки текста");
            byte key = scannerNums.nextByte();
            String decryptText = encrypt.decrypt(text, key);
            ReadWrite.writeEncrypt(path, decryptText, key);
        } else if (choise == 3) {
            System.out.println(pathText);
            path = scanner.nextLine();
            text = ReadWrite.read(path);
            byte key = bruteForce.decrypt(text);
            String decryptText = encrypt.decrypt(text, key);
            ReadWrite.writeEncrypt(path, decryptText, key);
            System.out.println("Текст расшифрован, ключ: " + key);
        } else if (choise == 4) {
            System.out.println(pathText);
            path = scanner.nextLine();
            text = ReadWrite.read(path);
            String decryptText = encrypt.decrypt(text, (byte) staticAnalyse.staticAnalyseResult(text));
            ReadWrite.writeEncrypt(path, decryptText);
            System.out.println("Текст расшифрован");
        } else if (choise == 5) {
            System.exit(1);
        } else {
            System.out.println("Выберите цифру от 1 до 5");
            choiser();
        }
    }
}


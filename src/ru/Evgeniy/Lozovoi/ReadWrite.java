package ru.Evgeniy.Lozovoi;

import java.io.*;

public class ReadWrite {
    //читаем текст из файла
    public static String read(String path) throws IOException {
        String s = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            while(reader.ready()){
                s += reader.readLine() + "\n";
            }
        }
        return s;
    }
    //пишем зашифрованный текст в файл.
    public static void writeEncrypt (String path, String text, byte key) throws  IOException {
        FileWriter writer = new FileWriter(path);
        writer.write(text);
        writer.flush();
        writer.close();
    }
    public static void writeEncrypt (String path, String text) throws  IOException {
        FileWriter writer = new FileWriter(path);
        writer.write(text);
        writer.flush();
        writer.close();
    }
}

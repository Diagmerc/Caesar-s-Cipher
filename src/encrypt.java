

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;

/*
Шифр
*/

public class encrypt {
    private static String symbols = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,””:-!? ";
    public static void main(String[] args) throws IOException {
        String s = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("text.txt")))) {
            s = reader.readLine();
        }
        byte key = 44;
        String temp = encrypt(s, key);
        System.out.println(temp);
        System.out.println(decrypt(temp, (byte) 2));
        System.out.println(BruteForce.decrypt(temp));
        FileWriter writer = new FileWriter("text2.txt");
        writer.write(temp);
        writer.flush();
        writer.close();
    }
    private static char encryptSymbol (char symb, byte key){
        if(symbols.indexOf(symb) != -1){
            return symbols.charAt((symbols.indexOf(symb) + key) % symbols.length());
        }else {
            return symb;
        }
    }
    private static String encrypt (String text, byte key){
        String result = "";
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            result += encryptSymbol(text.charAt(i), key);
        }
        return result;
    }
    public static String decrypt (String text, byte key){
        return encrypt(text, (byte)(symbols.length() - (key % symbols.length())));
    }


}
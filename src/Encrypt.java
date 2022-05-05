/*
Шифр
*/

public class Encrypt {
    private static String symbols = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,””:-!? ";
    private static char encryptSymbol (char symb, byte key){
        if(symbols.indexOf(symb) != -1){
            return symbols.charAt((symbols.indexOf(symb) + key) % symbols.length());
        }else {
            return symb;
        }
    }
    protected static String encrypt(String text, byte key){
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
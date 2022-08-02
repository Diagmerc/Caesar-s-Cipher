package ru.Evgeniy.Lozovoi;/*
Шифр
*/

public class Encrypt {
    //создаем пачку символов с которыми будем работать
    protected static final String symbols = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,””:-!? ";

    // метод который возвращает символ со смещением указанным key
    protected char encryptSymbol (char symb, byte key){
        if(symbols.indexOf(symb) != -1){
            return symbols.charAt((symbols.indexOf(symb) + key) % symbols.length());
        }else {
            return symb;
        }
    }
    // метод шифрует текст использую заменяя каждый символ символом полученным методом encryptSymbol
    protected String encrypt(String text, byte key){
        String result = "";
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            result += encryptSymbol(text.charAt(i), key);
        }
        return result;
    }
    protected String decrypt (String text, byte key){
        return encrypt(text, (byte)(symbols.length() - (key % symbols.length())));
    }


}
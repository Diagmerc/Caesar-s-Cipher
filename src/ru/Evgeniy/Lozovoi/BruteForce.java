package ru.Evgeniy.Lozovoi;

public class BruteForce {
    // метод ищет подходящий ключ перебирая все ключи, верным будет считатся ключ с большим количеством пробелов в тексте
    public byte decrypt(String message) {
        Encrypt encrypt = new Encrypt();
        byte key = 127;
        int k = 0;
        int temp = 0;
        byte result = 0;
        for (byte i = 0; i < key; i++) {
            k = 0;
            String s = encrypt.decrypt(message, i);
            for (int i1 = 0; i1 < s.length(); i1++) {
                if (s.charAt(i1) == ' ') {
                    k++;
                }
            }
            if (k > temp) {
                temp = k;
                result = i;
            }
        }
        if (result == 0){
            System.out.println("Невозможно рашифровать текст");
            System.exit(-1);
        }
        return result;
    }
}

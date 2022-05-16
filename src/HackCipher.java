public class HackCipher {
    public static char hackCipher(String message){
        byte result = 0;
        char word = ' ';
        for (int i = 0; i < Encrypt.symbols.length(); i++) {
            byte temp = 0;
            for (int j = 0; j < message.length(); j++) {
                if(Encrypt.symbols.charAt(i) == message.charAt(j)){
                    temp++;
                }
                if (temp > result) {
                    result = temp;
                    word = message.charAt(j);
                }
            }
        }
        return word;
    }
}

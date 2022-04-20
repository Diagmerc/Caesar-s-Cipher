

import java.io.*;
import java.nio.charset.StandardCharsets;

/*
Шифр
*/

public class encrypt {

    public static void main(String[] args) throws IOException {
        String s = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("text.txt")))) {
            s = reader.readLine();
        }
        byte[] temp = s.getBytes(StandardCharsets.UTF_16LE);
        char[] temp2 = new char[temp.length];
        for (int i = 0; i < temp.length; i++) {
            byte a = temp[i];
            temp2[i] = (char) a;
        }
        FileWriter fw = new FileWriter("text2.txt");
        fw.write(temp2);
        fw.flush();
        fw.close();
    }
}
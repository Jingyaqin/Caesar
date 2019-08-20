package cipher;

import java.io.*;

public class Caesar {

    public String encipher(int shift, String plainText) {
        String res = "";
        if (shift < 0) {
            res = decipher(-shift, plainText);
            return res;
        }


        shift = shift % 26;

        for (char c : plainText.toCharArray()) {
            if (Character.isLetter(c)) {
                if (Character.isLowerCase(c) && c + shift - 'z' > 26 || Character.isUpperCase(c) && c + shift - 'Z' > 26) {
                    c = (char) (c + shift - 26);
                } else {
                    c = (char) (c + shift);
                }
            }
            res += c;
        }
        return res;
    }

    public String decipher(int shift, String cipheredText) {
        String res = "";
        if (shift < 0) {
            res = encipher(-shift, cipheredText);
            return res;
        }


        shift = shift % 26;

        for (char c : cipheredText.toCharArray()) {
            if (Character.isLetter(c)) {
                if (Character.isLowerCase(c) && c - shift - 'a' < 0 || Character.isUpperCase(c) && c - shift - 'A' < 0) {
                    c = (char) (c - shift + 26);
                } else {
                    c = (char) (c - shift);
                }
            }
            res += c;
        }
        return res;
    }

    public boolean diff(String originalFile, String encDecFile) {
        try {
            FileReader fileReader1 = new FileReader(originalFile);
            FileReader fileReader2 = new FileReader(encDecFile);
            BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
            String line1 = bufferedReader1.readLine();
            String line2 = bufferedReader2.readLine();

            while (line1 != null || line2 != null) {
                if (!line1.equals(line2)) {
                    bufferedReader1.close();
                    bufferedReader2.close();
                    return false;
                }
                line1 = bufferedReader1.readLine();
                line2 = bufferedReader2.readLine();
            }
            bufferedReader1.close();
            bufferedReader2.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void main(String[] args) {
        Caesar c = new Caesar();
        int shift = -20;
        String encipher;
        String decipher;

        try {
            FileReader fileReader = new FileReader("myBook.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            FileOutputStream fos1 = new FileOutputStream("encBook.text");
            PrintWriter pw1 = new PrintWriter(fos1);
            FileOutputStream fos2 = new FileOutputStream("decBook.text");
            PrintWriter pw2 = new PrintWriter(fos2);

            while (line != null) {
                encipher = c.encipher(shift, line);
                pw1.println(encipher);
                decipher = c.decipher(shift, encipher);
                pw2.println(decipher);
                line = bufferedReader.readLine();

            }
            bufferedReader.close();
            pw1.flush();
            pw1.close();
            pw2.flush();
            pw2.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("originalFile and encDecFile have the same contents: " + c.diff("myBook.txt", "decBook.txt"));
    }
}




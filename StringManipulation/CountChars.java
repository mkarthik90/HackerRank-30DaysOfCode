import java.io.IOException;

public class CountChars
{
    /**
     * The input for the method should only be characters. Should not contain
     * any numbers. In case numbers are present, this method will count numbers
     * too.
     * 
     * @param ch
     */
    public static void coundCharactersInString(String ch) {
        int len = ch.length();
        do {
            int count = 0;
            for (int j = 0; j < ch.length(); j++) {
                if (ch.charAt(j) == ch.charAt(0)) {
                    count++;
                }
            }
            System.out.println("Character count for " + ch.charAt(0) + " is " + count);
            ch = ch.replace(ch.charAt(0) + "", "");
            len = ch.length();
        } while (len > 0);
    }

    public static void main(String[] args) throws IOException {
        coundCharactersInString("CHECKNUMBEROFCHARACTERS");
    }

}
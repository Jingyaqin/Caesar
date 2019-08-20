

import static org.junit.Assert.*;

public class CaesarTest {

    cipher.Caesar c = new cipher.Caesar();

    @org.junit.Before
    public void setUp() throws Exception {
        c = new cipher.Caesar();
    }

    @org.junit.Test
    public void encipher() {
        int[] shift = {1, 3, 53, -2, -27};

        String test = "aA, hello zZ! ";

        assertEquals("aA, hello zZ! ", c.encipher(shift[0], test));
        assertEquals("dD, khoor cC! ", c.encipher(shift[1], test));
        assertEquals("bB, ifmmp aA! ", c.encipher(shift[2], test));
        assertEquals("yY, fcjjm xX! ", c.encipher(shift[3], test));
        assertEquals("zZ, gdkkn yY! ", c.encipher(shift[4], test));
    }


    @org.junit.Test
    public void decipher() {
        int[] shift = {1, 3, 53, -2, -27};

        // assign string values based on enciphered strings in test method above
        String test = "aA, hello zZ! ";
        assertEquals("aA, hello zZ! ", c.decipher(shift[0], test));
        test = "dD, khoor cC! ";
        assertEquals("aA, hello zZ! ", c.decipher(shift[1], test));
        test = "bB, ifmmp aA! ";
        assertEquals("aA, hello zZ! ", c.decipher(shift[2], test));
        test = "yY, fcjjm xX! ";
        assertEquals("aA, hello zZ! ", c.decipher(shift[3], test));
        test = "zZ, gdkkn yY! ";
        assertEquals("aA, hello zZ! ", c.decipher(shift[4], test));
    }
}
package eu.szestkam.cryptotraining.vigenere;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VigenereTest {

    Vigenere vigenere;
    Vigenere vigenereNoArg;
    private final String SIMPLE_TEXT = "simple";
    private final String KEY = "key";

    @BeforeEach
    public void setUp(){
        vigenere = new Vigenere(SIMPLE_TEXT,KEY);
        vigenereNoArg = new Vigenere();
    }

    @Test
    public void testEmptyConstructor(){
        Vigenere cipher = vigenereNoArg;
        assertNotNull(cipher);
    }

    @Test
    public void testPhraseInConstructor(){
        Vigenere cipher = vigenere;
        assertNotNull(cipher);
    }

    @Test
    public void testEncodeThePhrase(){
        Vigenere vin = new Vigenere("PiotreK","LESSON");
        String encoded = vin.encode();
        assertEquals("AmglfrV", encoded);
    }

    @Test
    public void testDecodeThePhrase(){
        Vigenere vin = new Vigenere("AmglfrV","LESSON");
        String encoded = vin.decrypt();
        assertEquals("PiotreK", encoded);
    }

}
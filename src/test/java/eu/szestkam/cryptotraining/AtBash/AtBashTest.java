package eu.szestkam.cryptotraining.AtBash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.*;
class AtBashTest {

    private static final String SAMPLE_PHRASE = "simple";
    private AtBash atBashNoArg;
    private AtBash atBash;

    @BeforeEach
    public void setUp() {
        atBash = new AtBash(SAMPLE_PHRASE);
        atBashNoArg = new AtBash();
    }

    @Test
    public void testIfPhraseIsEmpty() {
        assertNotNull(atBashNoArg);
    }

    @Test
    public void testIfPhraseIsNotEmpty() {
        assertNotNull(atBash);
    }

    @Test
    public void testEncrypWhenPhraseIsEmpty() {
        AtBash atBashNoArg = new AtBash();
        String encoded = atBashNoArg.encode();
        assertEquals("", encoded);
    }

    @ParameterizedTest
    @CsvSource({"abc,zyx", "AbC, ZyX", "asdbASDB, zhwyZHWY"})
    public void testEncrtpWhenPhraseIsNoEmpty(String input, String expected){
        AtBash atBash = new AtBash(input);
        String encode = atBash.encode();
        assertEquals(expected,encode);
    }

    @Test
    public void testDecodeWhenPhraseIsEmpty() {
        AtBash atBashNoArg = new AtBash();
        String decode = atBashNoArg.decrypt();
        assertEquals("", decode);
    }

    @ParameterizedTest
    @CsvSource({"zyx,abc", "ZyX, AbC", "zhwyZHWY, asdbASDB"})
    public void testDecodeWhenPhraseIsNoEmpty(String input, String expected){
        AtBash atBash = new AtBash(input);
        String encode = atBash.encode();
        assertEquals(expected,encode);
    }

}
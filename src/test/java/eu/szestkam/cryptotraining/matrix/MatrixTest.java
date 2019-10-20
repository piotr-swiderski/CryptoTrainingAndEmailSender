package eu.szestkam.cryptotraining.matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    private static final String SAMPLE_STRING = "sample";
    private Matrix matrixNoArg;
    private Matrix matrix;

    @BeforeEach
    public void setUp() {
        matrixNoArg = new Matrix();
        matrix = new Matrix(SAMPLE_STRING);
    }

    @Test
    public void testPassEmptyTextToConstructor() {
        assertNotNull(matrixNoArg);
    }

    @Test
    public void testPassTextToConstructor() {
        assertNotNull(matrix);
    }

    @Test
    public void testEncodeEmptyText() {
        matrix = new Matrix("");
        assertEquals("", matrix.encode());
    }

    @Test
    public void testDecodeEmptyText() {
        matrix = new Matrix("");
        assertEquals("", matrix.decrypt());
    }

    @ParameterizedTest
    @CsvSource({"Piotre, 'Pt ir oe '", "Java, Jvaa", "abcde, 'ad be c  '"})
    public void testEncodeShortText(String phrase, String expected){
        matrix = new Matrix(phrase);
        String encode = matrix.encode();
        assertEquals(expected,encode);
    }

    @Test
    public void testEncodeLongText() {
        matrix = new Matrix("AlgorytmyiStrukturyDanych");
        String expected = "AyStalttungmrryoyuycrikDh";
        assertEquals(expected, matrix.encode());
    }

    @Test
    public void testDecodeLongText() {
        matrix = new Matrix("AyStalttungmrryoyuycrikDh");
        String expected = "AlgorytmyiStrukturyDanych";
        assertEquals(expected, matrix.decrypt());
    }

}
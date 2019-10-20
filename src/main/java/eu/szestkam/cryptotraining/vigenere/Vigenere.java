package eu.szestkam.cryptotraining.vigenere;

import eu.szestkam.cryptotraining.Cipher;

public class Vigenere implements Cipher {

    private String key;
    private String phrase;
    private char[][] vigenereAarray;
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public Vigenere(String phrase, String key) {
        this.phrase = phrase;
        this.key = key.toUpperCase();
    }

    public Vigenere() {
    }

    public void setKey(String key) {
        this.key = key.toUpperCase();
    }


    public String encode() {
        vigenereAarray = generateVignereArray();
        char[] phraseChar = phrase.toCharArray();
        char[] keyChar = key.toCharArray();
        int indexKey = 0;
        String encoded = "";
        for (int i = 0; i < phrase.length(); i++) {
            int[] index = indexOfLetter(phraseChar[i], keyChar[indexKey++]);
            boolean isLower = Character.isLowerCase(phraseChar[i]);
            encoded += getLetter(index, isLower);
            if (indexKey >= keyChar.length) {
                indexKey = 0;
            }
        }
        return encoded;
    }


    @Override
    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String decrypt() {
        vigenereAarray = generateVignereArray();
        char[] phraseChar = phrase.toCharArray();
        char[] keyChar = key.toCharArray();
        int indexKey = 0;
        String decode = "";
        for (int i = 0; i < phrase.length(); i++) {
            int[] index = indexDecode(phraseChar[i], keyChar[indexKey++]);
            boolean isLower = Character.isLowerCase(phraseChar[i]);
            decode += getLetter(index,isLower);
            if(indexKey >= keyChar.length){
                indexKey=0;
            }
        }

        return decode;
    }

    private int[] indexDecode(char phraseLetter, char keyLetter) {
        int[] index = new int[2];
        char phraseUp = Character.toUpperCase(phraseLetter);
        char keyUp = Character.toUpperCase(keyLetter);
        int indexKey = ALPHABET.indexOf(keyUp);
        for (int i = 0; i < vigenereAarray.length; i++) {
            if(phraseUp == vigenereAarray[i][indexKey]){
                index[0] = i;
                index[1] = 0;
                break;
            }
        }
        return index;
    }


    private int[] indexOfLetter(char phraseLetter, char keyLetter) {
        int[] index = new int[2];
        char phraseUp = Character.toUpperCase(phraseLetter);
        char keyUp = Character.toUpperCase(keyLetter);
        index[0] = ALPHABET.indexOf(phraseUp);
        index[1] = ALPHABET.indexOf(keyUp);
        return index;
    }

    private String getLetter(int[] index, boolean isLower) {
        String letter = String.valueOf(vigenereAarray[index[0]][index[1]]);
        return (isLower) ? letter.toLowerCase() : letter;
    }

    private char[][] generateVignereArray() {
        int alphabetLength = ALPHABET.length();
        char[] alphabetChar = ALPHABET.toCharArray();
        int indexAlpha = 0;

        vigenereAarray = new char[alphabetLength][alphabetLength];
        for (int i = 0; i < alphabetLength; i++) {
            for (int j = 0; j < alphabetLength; j++) {
                if (indexAlpha < alphabetChar.length) {
                    vigenereAarray[i][j] = alphabetChar[indexAlpha];
                    indexAlpha++;
                } else {
                    indexAlpha = 0;
                    vigenereAarray[i][j] = alphabetChar[indexAlpha];
                    indexAlpha++;
                }
            }
            indexAlpha = i + 1;
        }
        return vigenereAarray;
    }

    private void printArray(char[][] array) {
        System.out.println(array.length);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}

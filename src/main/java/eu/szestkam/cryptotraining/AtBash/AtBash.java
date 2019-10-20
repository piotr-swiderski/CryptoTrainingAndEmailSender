package eu.szestkam.cryptotraining.AtBash;

import eu.szestkam.cryptotraining.Cipher;

import static java.lang.Character.*;

public class AtBash implements Cipher {

    private String phrase;
    private final String ALPHABET_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public AtBash(String phrase) {
        this.phrase = phrase;
    }

    public AtBash() {
        this.phrase = "";
    }

    @Override
    public String decrypt() {
        return encode();
    }

    @Override
    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    @Override
    public String encode() {
        char[] charPhrase = phrase.toCharArray();
        String phraseEncoded = "";
        boolean lowerCase;

        for (char _char : charPhrase) {
            if (_char >= 48 && _char <= 57) {
                phraseEncoded += _char;
            } else {
                lowerCase = isLower(_char);
                int index = indexOfChar(toUpperCase(_char));
                phraseEncoded += newLetter(lowerCase, index);
            }
        }

        return phraseEncoded;
    }

    private String newLetter(boolean lowerCase, int index) {
        String returned = String.valueOf(ALPHABET_UPPER.charAt(25 - index));
        return (lowerCase) ? returned.toLowerCase() : returned;
    }

    private int indexOfChar(char _char) {
        return ALPHABET_UPPER.indexOf(_char);

    }

    private boolean isLower(char character) {
        return isLowerCase(character);
    }


}

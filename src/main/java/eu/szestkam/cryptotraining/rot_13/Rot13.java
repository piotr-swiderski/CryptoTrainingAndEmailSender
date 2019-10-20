package eu.szestkam.cryptotraining.rot_13;

import eu.szestkam.cryptotraining.Cipher;

public class Rot13 implements Cipher {
    private String phrase;
    private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Rot13(String text) {
        this.phrase = text;
    }

    public Rot13() {
        this.phrase = "";
    }

    public String encode() {
        StringBuilder sb = new StringBuilder();
        for (char ch : phrase.toCharArray()) {
            if(ALPHABET.contains((ch + "").toUpperCase())) {
                int index = (ALPHABET.indexOf(Character.toUpperCase(ch)) + 13) % 26;
                sb.append(Character.isUpperCase(ch) ? ALPHABET.charAt(index) : ALPHABET.toLowerCase().charAt(index));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    @Override
    public String decrypt() {
        return null;
    }

    @Override
    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}

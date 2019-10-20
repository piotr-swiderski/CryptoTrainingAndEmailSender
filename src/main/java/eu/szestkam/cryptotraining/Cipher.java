package eu.szestkam.cryptotraining;

public interface Cipher {

    String encode();
    String decrypt();
    void setPhrase(String phrase);
}

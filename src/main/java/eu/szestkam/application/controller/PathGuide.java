package eu.szestkam.application.controller;

public enum PathGuide {

    ADBASH("D:\\SDA_Academy\\CryptoTrainnig\\CryptoTraining-master\\src\\main\\java\\eu\\szestkam\\cryptotraining\\AtBash\\AtBashGuide.html"),
    CESAR("D:\\SDA_Academy\\CryptoTrainnig\\CryptoTraining-master\\src\\main\\java\\eu\\szestkam\\cryptotraining\\cesar\\CesarCipher.html"),
    ROT13("D:\\SDA_Academy\\CryptoTrainnig\\CryptoTraining-master\\src\\main\\java\\eu\\szestkam\\cryptotraining\\rot_13\\Rot13Guide.html"),
    VIGENERE("D:\\SDA_Academy\\CryptoTrainnig\\CryptoTraining-master\\src\\main\\java\\eu\\szestkam\\cryptotraining\\vigenere\\VigenereGuide.html"),
    MATRIX("D:\\SDA_Academy\\CryptoTrainnig\\CryptoTraining-master\\src\\main\\java\\eu\\szestkam\\cryptotraining\\matrix\\MatrixGuide.html");

    private String path;

    PathGuide(String s) {
        this.path = s;
    }

    public String getPathGuide(){
        return path;
    }
}

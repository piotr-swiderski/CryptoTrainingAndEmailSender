package eu.szestkam.cryptotraining.matrix;

import eu.szestkam.cryptotraining.Cipher;

public class Matrix implements Cipher {

    private char[][] array;
    private String phrase;
    private String encoded;

    public Matrix(String phrase) {
        this.phrase = phrase;
    }

    public Matrix() {
        this.phrase = "";
    }

    public String decrypt(){
        return encode();
    }

    @Override
    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String encode() {
        int sizeMatrix = sizeOfMatrix(phrase);
        if (sizeMatrix == 0) {
            return "";
        }
        array = initialMatrix(sizeMatrix);
        matrixFill();
        String encoded = "";
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                encoded += array[j][i];
            }
        }
        return encoded;
    }

    private void printMatrix() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[1].length; j++) {
                System.out.print(array[i][j] + ", ");
            }
            System.out.println();
        }
    }


    private char[][] matrixFill() {
        char[] charText = phrase.toCharArray();
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (index < charText.length) {
                    array[i][j] = charText[index];
                    index++;
                }
            }
        }
        printMatrix();
        return array;
    }

    private char[][] initialMatrix(int sizeMatrix) {
        char[][] returnedArray = new char[sizeMatrix][sizeMatrix];
        for (int i = 0; i < returnedArray.length; i++) {
            for (int j = 0; j < returnedArray[1].length; j++) {
                returnedArray[i][j] = ' ';
            }
        }
        return returnedArray;
    }

    private int sizeOfMatrix(String text) {
        double val = Math.sqrt(text.length());
        long roundVal = Math.round(val);
        double decimalPlaces = val - roundVal;

        if (decimalPlaces > 0) {
            return (int) ++roundVal;
        } else {
            return (int) roundVal;
        }
    }
}

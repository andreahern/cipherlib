package cipherlib;

import java.math.BigInteger;

public class hill_cipher extends cipher {
    private int[][] matrixKey;
    private int trailingZ, determinant;

    public hill_cipher(String plainText) {
        super(plainText);
        matrixKey = new int[2][2];
        trailingZ = 0;
        determinant = 0;
    }
    
    public hill_cipher() {
        matrixKey = new int[2][2];
        trailingZ = 0;
        determinant = 0;
    }

    public void encryption(String key) {
        StringBuilder builder = new StringBuilder();
        builder.append(getPlainText().toLowerCase());
        removeSpaces(builder);
        if(builder.length() % 2 != 0) {builder.append('z'); setTrailingZ(1);}

        keyToMatrixKey(key);
        replaceBlocks(matrixKey, builder);
        setCipherText(builder.toString());
    }

    public void decryption(String key) {
        StringBuilder builder = new StringBuilder();
        builder.append(getCipherText());
        removeSpaces(builder);

        keyToMatrixKey(key);
        invertMatrixKey(matrixKey);
        replaceBlocks(matrixKey, builder);
        if(getTrailingZ() == 1) builder.deleteCharAt(builder.length() - 1);
        setPlainText(builder.toString());
    }

    private String matrixMult(int[][] matrixKey, String text) {
        int[][] textMatrix = new int[1][2];
        textMatrix[0][0] = text.charAt(0) - 97;
        textMatrix[0][1] = text.charAt(1) - 97;
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < 2; i++) {
            int product = (matrixKey[i][0] * textMatrix[0][0] + matrixKey[i][1] * textMatrix[0][1]) % getLETTER_SIZE() + 97;
            result.append((char) product);
        }
        return result.toString();
    }

    private void keyToMatrixKey(String key) {
        int charCount = 0;

        for(int i = 0; i < matrixKey.length; i++) {
            for(int j = 0; j < matrixKey[i].length; j++) {
                matrixKey[i][j] = key.charAt(charCount) - 97;
                charCount++;
            }
        }
        setMatrixKey(matrixKey);
    }
    
    private void invertMatrixKey(int[][] matrixKey) {
    	setDeterminant(matrixKey);
    	int product = findInverse(getDeterminant(), getLETTER_SIZE());
        int temp = matrixKey[0][0];

        matrixKey[0][0] = matrixKey[1][1];
        matrixKey[1][1] = temp;
        matrixKey[0][1] *= -1;
        matrixKey[1][0] *= -1;

        for(int i = 0; i < matrixKey.length; i++) {
            for(int j = 0; j < matrixKey[i].length; j++) {
                matrixKey[i][j] = Math.floorMod(matrixKey[i][j] * product, getLETTER_SIZE());
            }
        }
        setMatrixKey(matrixKey);
    }
    
    private void replaceBlocks(int[][] matrixKey, StringBuilder builder) {
        int startIndex = 0, endIndex = 2;
        for(int i = 0; i < builder.length() / 2; i ++) {
            builder.replace(startIndex, endIndex, matrixMult(matrixKey, builder.substring(startIndex, endIndex)));
            startIndex = endIndex;
            endIndex += 2;
        }
    }

    private void removeSpaces(StringBuilder builder) {
        for(int i = 0; i < builder.length(); i++) {
            if(builder.charAt(i) == ' ') builder.deleteCharAt(i);
        }
    }
    
    private int findInverse(int a, int mod) {return (BigInteger.valueOf(a).modInverse(BigInteger.valueOf(mod)).intValue());}
    
    private void setDeterminant(int[][] matrixKey) {this.determinant = (matrixKey[0][0] * matrixKey[1][1] - matrixKey[0][1] * matrixKey[1][0]) % getLETTER_SIZE();}
    
    private void setMatrixKey(int[][] matrixKey) {this.matrixKey = matrixKey;}
    
    private void setTrailingZ(int value) {this.trailingZ = value;}
    
    private int getDeterminant() {return this.determinant;}

    private int getTrailingZ() {return this.trailingZ;}
}

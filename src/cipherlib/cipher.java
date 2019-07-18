package cipherlib;

public abstract class cipher {
    private String plainText;
    private String cipherText;
    private final int LETTER_SIZE = 26;

    public cipher(String plainText) {this.plainText = plainText;}

    public cipher(){}

    public void setPlainText(String plainText) {this.plainText = plainText; this.cipherText = "";}

    public void setCipherText(String cipherText) {this.cipherText = cipherText; this.plainText = "";}

    public String getPlainText() {return this.plainText;}

    public String getCipherText() {return this.cipherText;}
    
    public int getLETTER_SIZE() {return this.LETTER_SIZE;}
}

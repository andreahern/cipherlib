package cipherlib;

public class rot13_cipher extends cipher {

    public rot13_cipher(String plainText) {super(plainText);}
    public rot13_cipher() {}

    public void encryption() {
        StringBuilder builder = new StringBuilder();
        builder.append(getPlainText().toLowerCase());
        rotate13(builder);
        setCipherText(builder.toString());
    }

    public void decryption() {
        StringBuilder builder = new StringBuilder();
        builder.append(getCipherText().toLowerCase());
        rotate13(builder);
        setPlainText(builder.toString());
    }

    private void rotate13(StringBuilder builder) {
        for(int i = 0; i < builder.length(); i++) {
            if(builder.charAt(i) < 97 || builder.charAt(i) > 122) continue;
            char c = (char) (((builder.charAt(i) - 97) + 13) % getLETTER_SIZE() + 97);
            builder.setCharAt(i, c);
        }
    }
}

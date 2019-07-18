package cipherlib;

public class caesar_cipher extends cipher {

    public caesar_cipher(String plainText) {super(plainText);}
    public caesar_cipher() {}

    public void encryption(int shift) {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getPlainText().toLowerCase());
        for(int i = 0; i < builder.length(); i++) {
            if(builder.charAt(i) < 97 || builder.charAt(i) > 122 ) continue;
            char c = (char) (((builder.charAt(i) - 97) + shift) % getLETTER_SIZE() + 97);
            builder.setCharAt(i, c);
        }
        setCipherText(builder.toString());
    }

    public void decryption(int shift) {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getCipherText().toLowerCase());
        for(int i = 0; i < builder.length(); i++) {
            if(builder.charAt(i) < 97 || builder.charAt(i) > 122 ) continue;
            char c = (char) (Math.floorMod((builder.charAt(i) - 97) - shift, getLETTER_SIZE()) + 97);
            if (c < 97) c = (char)(122 % c + 96);
            builder.setCharAt(i, c);
        }
        setPlainText(builder.toString());
    }
}

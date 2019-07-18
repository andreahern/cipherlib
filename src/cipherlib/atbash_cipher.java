package cipherlib;

public class atbash_cipher extends cipher {

    public atbash_cipher(String plainText) {super(plainText);}
    public atbash_cipher() {}

    public void encryption() {
        StringBuilder builder = new StringBuilder();
        builder.append(getPlainText().toLowerCase());
        for(int i = 0; i < builder.length(); i++) {
            if(builder.charAt(i) < 97 || builder.charAt(i) > 122 ) continue;
            char c = (char)('z' -  (builder.charAt(i) - 'a'));
            builder.setCharAt(i, c);
        }
        setCipherText(builder.toString());
    }

    public void decryption() {
        StringBuilder builder = new StringBuilder();
        builder.append(getCipherText().toLowerCase());
        for(int i = 0; i < builder.length(); i++) {
            if(builder.charAt(i) < 97 || builder.charAt(i) > 122 ) continue;
            char c = (char)('a' +  ('z' - builder.charAt(i)));
            builder.setCharAt(i, c);
        }
        setPlainText(builder.toString());
    }
}

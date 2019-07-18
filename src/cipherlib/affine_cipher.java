package cipherlib;

import java.math.BigInteger;

public class affine_cipher extends cipher {

    public affine_cipher(String plainText) {super(plainText);}
    public affine_cipher() {}

    public void encryption(int a, int b) {
    	if(gcd(a, getLETTER_SIZE()) != 1) throw new IllegalArgumentException("The value of a has to be a coprime of LETTER_SIZE (26)"); 
        StringBuilder builder =  new StringBuilder();
        builder.append(getPlainText().toLowerCase());
        for(int i = 0; i < builder.length(); i++) {
            if(builder.charAt(i) == ' ') builder.deleteCharAt(i);
            if(builder.charAt(i) < 97 || builder.charAt(i) > 122) continue;
            char c = (char) ((a * (builder.charAt(i) - 97) + b) % 26 + 97);
            builder.setCharAt(i, c);
        }
        setCipherText(builder.toString());
    }

    public void decryption(int a, int b) {
    	if(gcd(a, getLETTER_SIZE()) != 1) throw new IllegalArgumentException("The value of a has to be a coprime of LETTER_SIZE (26)"); 
        StringBuilder builder = new StringBuilder();
        builder.append(getCipherText());
        for(int i = 0; i < builder.length(); i++) {
            if(builder.charAt(i) < 97 || builder.charAt(i) > 122) continue;
            char c = (char) (Math.floorMod(findInverse(a, getLETTER_SIZE()) * ((builder.charAt(i) - 97) - b), 26) + 97);
            builder.setCharAt(i, c);
        }
        setPlainText(builder.toString());
    }

    private int gcd(int a, int mod) {
    	if(a == 0 || mod == 0) return 0;
    	if(a == mod) return a;
    	if(a > mod) return gcd(a- mod, mod);
    	return gcd(a, mod - a);
    }
    
    private int findInverse(int a, int mod) {
        return (BigInteger.valueOf(a).modInverse(BigInteger.valueOf(mod)).intValue());
    }
}

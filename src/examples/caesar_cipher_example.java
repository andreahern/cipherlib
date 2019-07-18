package examples;

import cipherlib.caesar_cipher;

public class caesar_cipher_example {
	public static void main(String[] args) {
		caesar_cipher cipher1 = new caesar_cipher("Hello World");
		System.out.println("PlainText: " + cipher1.getPlainText());
		
		cipher1.encryption(3);
		System.out.println("CipherText: " + cipher1.getCipherText());
		
		cipher1.decryption(3);
		System.out.println("PlainText: " + cipher1.getPlainText());
		
		System.out.println("\n");
		
		caesar_cipher cipher2 = new caesar_cipher();
		cipher2.setPlainText("Hello Again");
		System.out.println("PlainText: " + cipher2.getPlainText());
		
		cipher2.encryption(7);
		System.out.println("CipherText: " + cipher2.getCipherText());
		
		cipher2.decryption(7);
		System.out.println("PlainText: " + cipher2.getPlainText());
		
		System.out.println("\n");
		
		caesar_cipher cipher3 = new caesar_cipher();
		cipher3.setCipherText("guvf zrffntr jnf nyernql rapelcgrq");
		System.out.println("CipherText: " + cipher3.getCipherText());
		
		cipher3.decryption(13);
		System.out.println("PlainText: " + cipher3.getPlainText());
	}
}

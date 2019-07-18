package examples;

import cipherlib.rot13_cipher;

public class rot13_cipher_example {
	public static void main(String[] args) {
		rot13_cipher cipher1 = new rot13_cipher("Hello World");
		System.out.println("PlainText: " + cipher1.getPlainText());
		
		cipher1.encryption();
		System.out.println("CipherText: " + cipher1.getCipherText());
		
		cipher1.decryption();
		System.out.println("PlainText: " + cipher1.getPlainText());
		
		System.out.println("\n");
		
		rot13_cipher cipher2 = new rot13_cipher();
		cipher2.setPlainText("Hello Again");
		System.out.println("PlainText: " + cipher2.getPlainText());		
		
		cipher2.encryption();
		System.out.println("CipherText: " + cipher2.getCipherText());
		
		cipher2.decryption();
		System.out.println("PlainText: " + cipher2.getPlainText());
		
		System.out.println("\n");
		
		rot13_cipher cipher3 = new rot13_cipher();
		cipher3.setCipherText("guvf zrffntr jnf nyernql rapelcgrq");
		System.out.println("CipherText: " + cipher3.getCipherText());		
		
		cipher3.decryption();
		System.out.println("PlainText: " + cipher3.getPlainText());
	}
}

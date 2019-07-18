package examples;

import cipherlib.hill_cipher;

public class hill_cipher_example {
	public static void main(String[] args) {
		hill_cipher cipher1 = new hill_cipher("Hello World");
		System.out.println("PlainText: " + cipher1.getPlainText());
		cipher1.encryption("cdfh");
		System.out.println("CipherText: " + cipher1.getCipherText());
		cipher1.decryption("cdfh");
		System.out.println("PlainText: " + cipher1.getPlainText());
		
		System.out.println("\n");
		
		hill_cipher cipher2 = new hill_cipher();
		cipher2.setPlainText("Hello Again");
		System.out.println("PlainText: " + cipher2.getPlainText());
		cipher2.encryption("ddcf");
		System.out.println("CipherText: " + cipher2.getCipherText());
		cipher2.decryption("ddcf");
		System.out.println("PlainText: " + cipher2.getPlainText());
		
		System.out.println("\n");
		
		hill_cipher cipher3 = new hill_cipher();
		cipher3.setCipherText("tmiqooquegeimsdlsdpdiykpoxdmnp");
		System.out.println("CipherText: " + cipher3.getCipherText());
		cipher3.decryption("gfdb");
		System.out.println("PlainText: " + cipher3.getPlainText());
	}
}

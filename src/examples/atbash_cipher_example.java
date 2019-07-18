package examples;

import cipherlib.atbash_cipher;

public class atbash_cipher_example {
	public static void main(String[] args) {
		atbash_cipher cipher1 = new atbash_cipher("Hello World");
		System.out.println("PlainText: " + cipher1.getPlainText());
		
		cipher1.encryption();
		System.out.println("CipherText: " + cipher1.getCipherText());
		
		cipher1.decryption();
		System.out.println("PlainText: " + cipher1.getPlainText());
		
		System.out.println("\n");
		
		atbash_cipher cipher2 = new atbash_cipher();
		cipher2.setPlainText("Hello Again");
		System.out.println("PlainText: " + cipher2.getPlainText());		
		
		cipher2.encryption();
		System.out.println("CipherText: " + cipher2.getCipherText());
		
		cipher2.decryption();
		System.out.println("PlainText: " + cipher2.getPlainText());
		
		System.out.println("\n");
		
		atbash_cipher cipher3 = new atbash_cipher();
		cipher3.setCipherText("gsrh hgirmt dzh zoivzwb vmxibkgvw");
		System.out.println("CipherText: " + cipher3.getCipherText());		
		
		cipher3.decryption();
		System.out.println("PlainText: " + cipher3.getPlainText());
	}
}

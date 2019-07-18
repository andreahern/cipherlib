package examples;

import cipherlib.affine_cipher;

public class affine_cipher_example {
	public static void main(String[] args) {
		affine_cipher cipher1 = new affine_cipher("Hello World");
		System.out.println("PlainText: " + cipher1.getPlainText());
		
		cipher1.encryption(5, 7);
		System.out.println("CipherText: " + cipher1.getCipherText());
		
		cipher1.decryption(5, 7);
		System.out.println("PlainText: " + cipher1.getPlainText());
		
		System.out.println("\n");
		
		affine_cipher cipher2 = new affine_cipher();
		cipher2.setPlainText("Hello Again");
		System.out.println("PlainText: " +cipher2.getPlainText());
		
		cipher2.encryption(7, 7);
		System.out.println("CipherText: " + cipher2.getCipherText());
		
		cipher2.decryption(7, 7);
		System.out.println("PlainText: " +cipher2.getPlainText());
		
		System.out.println("\n");
		
		affine_cipher cipher3 = new affine_cipher();
		cipher3.setCipherText("bdsmakmmcokucmclxkcvykpgxytbkv");
		System.out.println("CipherText: " + cipher3.getCipherText());
		
		cipher3.decryption(15, 2);
		System.out.println("PlainText: " +cipher3.getPlainText());
	}
}

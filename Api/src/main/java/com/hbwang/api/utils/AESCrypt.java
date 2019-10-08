package com.hbwang.api.utils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class AESCrypt {

	private final Cipher cipher;
	private final SecretKeySpec key;
	private AlgorithmParameterSpec spec;

	public AESCrypt(String keyString) throws NoSuchAlgorithmException,
            UnsupportedEncodingException, NoSuchPaddingException {
		super();
//		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		// hash password with SHA-256 and crop the output to 128-bit for key
		//MessageDigest digest = MessageDigest.getInstance("SHA-256");
		//digest.update(keyString.getBytes("UTF-8"));
		byte[] keyBytes = new byte[16];
		//System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);

		System.arraycopy(keyString.getBytes("UTF-8"), 0, keyBytes, 0, keyBytes.length);
		cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		key = new SecretKeySpec(keyBytes, "AES");
		spec = getIV();
	}

	public String encrypt(String plainText) throws Exception {
		cipher.init(Cipher.ENCRYPT_MODE, key, spec);
		byte[] encrypted = cipher.doFinal(plainText.getBytes("UTF-8"));
		String encryptedText = Base64.encode(encrypted);
		return encryptedText;
	}

	public AlgorithmParameterSpec getIV() {
		byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, };
		IvParameterSpec ivParameterSpec;
		ivParameterSpec = new IvParameterSpec(iv);
		return ivParameterSpec;
	}

	public static void main(String[] args) throws Exception, UnsupportedEncodingException, NoSuchPaddingException, Exception {
		System.out.println(new AESCrypt("1234567890123456").encrypt("test"));
	}
}

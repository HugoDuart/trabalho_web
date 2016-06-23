package br.ufc.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Criptografia 
{
	public String criptografar(String senha)
	{
		MessageDigest algorithm = null;
		try{
			algorithm = MessageDigest.getInstance("SHA-256");
		}catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		byte messageDigest[] = null;
		try{
			messageDigest = algorithm.digest(senha.getBytes("UTF-8"));
		}catch (UnsupportedEncodingException e){
			e.printStackTrace();
		}
		
		StringBuilder hexString = new StringBuilder();
		for(byte b : messageDigest){
			hexString.append(String.format("%02X", 0xFF & b));
		}
		String senhaFinal = hexString.toString();
		return senhaFinal;
		
	}
}

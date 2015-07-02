package org.sangharsh;


import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class Test {
  public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
	 WaClient waClient = new WaClient();	
    waClient.codeRequest("7786092600");
	}
}

package org.sangharsh;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

import org.hamcrest.MatcherAssert;
import org.junit.Ignore;
import org.junit.Test;

public class WaClientTest {

	
	private WaClient waClient = new WaClient();
	
	@Test
	@Ignore
	public void shouldRequestCode() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		waClient.codeRequest("12345678");
	}
	
	
	@Test
	public void shouldGenerateToken() throws NoSuchAlgorithmException {
		String token = waClient.generateToken("12345678");
		MatcherAssert.assertThat("Token is generated", token, is(equalTo("ede2a033dde233aacf8989ff60ada2aa")));
	}
	
	@Test
	public void testIdentityConversion() throws UnsupportedEncodingException{
		String str = waClient.generateId("12345678");
		System.out.println(Arrays.toString(str.getBytes(StandardCharsets.ISO_8859_1)));
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] bytes = new byte[20];
		new Random().nextBytes(bytes);
		System.out.println("RAW:"+ Arrays.toString(bytes));
		String iso88591 = new String(bytes, StandardCharsets.ISO_8859_1);
		
		System.out.println("ISO_8859_1:"+iso88591);
		System.out.println("ISO_8859_1 LC :"+iso88591.toLowerCase());
		String encoded = URLEncoder.encode(iso88591, StandardCharsets.UTF_8.toString());
		System.out.println("ENCODED:"+encoded);
		System.out.println("DECODED:"+URLDecoder.decode(encoded, StandardCharsets.UTF_8.toString()));
		
	}
}



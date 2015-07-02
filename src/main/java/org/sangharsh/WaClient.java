package org.sangharsh;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.sangharsh.wa.QueryParam.COUNTRY_CODE;
import static org.sangharsh.wa.QueryParam.ID;
import static org.sangharsh.wa.QueryParam.INCOMING_NO;
import static org.sangharsh.wa.QueryParam.LANGUAGE;
import static org.sangharsh.wa.QueryParam.LOCALE;
import static org.sangharsh.wa.QueryParam.METHOD;
import static org.sangharsh.wa.QueryParam.SIM_MCC;
import static org.sangharsh.wa.QueryParam.SIM_MNC;
import static org.sangharsh.wa.QueryParam.TOKEN;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.sangharsh.wa.Header;
import org.sangharsh.wa.MethodCode;
import org.sangharsh.wa.WaPath;

import com.neovisionaries.i18n.CountryCode;
import com.neovisionaries.i18n.LanguageCode;

public class WaClient {
	
//	private static final String HOST = "https://v.whatsapp.net";
	private static final String HOST = "https://v.whatsapp.net";
	
	private Client client;
	
	public WaClient(){
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(LoggingFilter.class);
		this.client = ClientBuilder.newClient(clientConfig);
	}
	
	public void codeRequest(String phone) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		MultivaluedMap<String, String> params = new MultivaluedHashMap<String, String>();
		params.add("user", "Anc".toUpperCase()); 
		String response = client.target(HOST).path(WaPath.REQUEST_CODE)
			.queryParam(COUNTRY_CODE, "44")
			.queryParam(INCOMING_NO, phone)
			.queryParam(LANGUAGE, LanguageCode.en)
			.queryParam(LOCALE, CountryCode.GB)
			.queryParam(METHOD, MethodCode.SMS)
			.queryParam(SIM_MCC, "234")
			.queryParam(SIM_MNC, "000")
			.queryParam(TOKEN, generateToken(phone))
			.queryParam(ID, generateId(phone))
			.request(APPLICATION_JSON)
			.header(Header.USER_AGENT, Header.UA_VALUE).get(String.class);
			;
	}
	
	public void codeRegister(){
		
	}
	
	public void connect(){
		
	}
	
	public void disconnect(){
		
	}
	
	public String generateId(String phone) throws UnsupportedEncodingException{
		byte[] bytes = new byte[20];
		new Random().nextBytes(bytes);
		System.out.println(Arrays.toString(bytes));
		String identity = new String(bytes, StandardCharsets.ISO_8859_1);
		String encoded = URLEncoder.encode(identity, StandardCharsets.UTF_8.toString());
		System.out.println("ID--> "+encoded);
		return identity;
	}
	
	private static final String RELEASE_TOKEN_CONST = "PdA2DJyKoUrwLw1Bg6EIhzh502dF9noR9uFCllGk";
	private static final String RELEASE_TIME = "1431039885607";
	
	public String generateToken(String phone) throws NoSuchAlgorithmException{
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		String filepath = RELEASE_TOKEN_CONST+RELEASE_TIME+phone;
		byte[] digest = md5.digest(filepath.getBytes());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< digest.length ;i++)
        {
            sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
	}
}

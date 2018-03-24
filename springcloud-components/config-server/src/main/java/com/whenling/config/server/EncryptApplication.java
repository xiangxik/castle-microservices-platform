package com.whenling.config.server;

import java.nio.charset.Charset;
import java.util.Base64;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class EncryptApplication {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://localhost:8888/encrypt");

		HttpEntity entity = new StringEntity("asd123", Consts.UTF_8);
		post.setEntity(entity);
		post.addHeader("Authorization", getHeader("root", "qwe123"));

		HttpResponse response = client.execute(post);
		System.out.println(EntityUtils.toString(response.getEntity()));
	}

	private static String getHeader(String username, String password) {
		String auth = username + ":" + password;
		byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);
		return authHeader;
	}
}

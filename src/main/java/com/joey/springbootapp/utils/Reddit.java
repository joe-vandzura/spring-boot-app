package com.joey.springbootapp.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Reddit {
    private String username = "joe-the-patriot";
    private String password = "Killerbeast67$";
    private String client_id = "NlVr95TtZUD5jqbz5G6uxQ";
    private String secret_key = "0ronCDpLQejgHFiVRpHtNmujKTAKDw";
    private String url = "https://www.reddit.com/api/v1/access_token";
    private static HttpClient httpClient = null;
    private static String accessToken = null;

    public String getAccessToken() {
        if (accessToken == null) {
            CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(
                    AuthScope.ANY,
                    new UsernamePasswordCredentials(client_id, secret_key)
            );
            if (httpClient == null) {
                httpClient = HttpClientBuilder
                        .create().setDefaultCredentialsProvider(credentialsProvider)
                        .build();
            }
                HttpPost httpPost = new HttpPost(url);
                List<NameValuePair> params = new ArrayList<NameValuePair>(3);
                params.add(new BasicNameValuePair("grant_type", "password"));
                params.add(new BasicNameValuePair("username", username));
                params.add(new BasicNameValuePair("password", password));

            try {
                httpPost.setEntity(new UrlEncodedFormEntity(params));
                httpPost.setHeader("User-Agent", "/u/ user v1.0");
                HttpResponse httpResponse;

                try {
                    httpResponse = httpClient.execute(httpPost);
                    HttpEntity response = null;
                    try {
                        response = httpResponse.getEntity();
                        System.out.println(response);
                        String responseString = EntityUtils.toString(response);
                        JSONObject json = (JSONObject) new JSONParser().parse(responseString);
                        accessToken = json.get("access_token").toString();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return accessToken;
    }

    public void createRedditPost() {
        
    }
}

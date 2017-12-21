package org.throwable.main;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/12/21 15:53
 */
public class HelloMainPost {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:9099/hello/post");
        URLConnection urlConnection = url.openConnection();
        if (!HttpURLConnection.class.isInstance(urlConnection)) {
            throw new IllegalStateException("HttpURLConnection required for [" + url + "] but got: " + urlConnection);
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        PrintWriter writer = new PrintWriter(outputStream);
        String param = "name=doge";
        writer.print(param);
        writer.flush();
        int responseCode = httpURLConnection.getResponseCode();
        String responseMessage = httpURLConnection.getResponseMessage();
        System.out.println("code --> " + responseCode);
        System.out.println("message --> " + responseMessage);
        InputStream inputStream = httpURLConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            result.append(line).append("\n");
        }
        String lastResult = "";
        if (result.length() > 0) {
            lastResult = result.substring(0, result.lastIndexOf("\n"));
        }
        System.out.println("result --> " + lastResult);
    }
}

package com.example.cy123.booklist.Utils;

import java.io.IOException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by cy123 on 2016/6/29.
 */
public class StringLoader {
    private static OkHttpClient client = new OkHttpClient();

    public static String load(String sUrl) throws IOException{
        URL url = new URL(sUrl);
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }
}

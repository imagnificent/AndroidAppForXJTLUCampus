package com.example.tonyyoung.find;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// for http connection
public class WebService {
    private static String IP = "106.15.227.148:8080";

    public static String executeHttpGet(String url,String username, String password ) {
        HttpURLConnection conn = null;
        InputStream is = null;
        String path = null;

        try {
            if (url == "LoginServlet") {
                path = "http://" + IP + "/MyFirstWebApp/";
                path = path + url + "?Email=" + username + "&Password=" + password;
            } else if (url == "RegisterServlet") {
                path = "http://" + IP + "/MyFirstWebApp/";
                String AccountNumber = username.split(",")[0];
                String Email = username.split(",")[1];
                path = path + url + "?AccountNumber=" + AccountNumber + "&Password=" + password + "&Email=" + Email;
            } else if (url == "SearchServlet") {
                path = "http://" + IP + "/MyFirstWebApp/";
                path = path + url + "?title=" + username;
            } else if (url == "MessageServlet") {
                path = "http://" + IP + "/MyFirstWebApp/";
                path = path + url + "?location=" + username;
            }

            conn = (HttpURLConnection) new URL(path).openConnection();
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Charset", "UTF-8");

            if (conn.getResponseCode() == 200) {
                is = conn.getInputStream();
                return parseInfo(is);
            }
            return null;

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return path;
    }

    public static String executeSearch(String url,String username ) {
        HttpURLConnection conn = null;
        InputStream is = null;
        String path = null;

        try {
                path = "http://" + IP + "/MyFirstWebApp/";
                path = path + url + "?title=" + username;

            conn = (HttpURLConnection) new URL(path).openConnection();
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Charset", "UTF-8");

            if (conn.getResponseCode() == 200) {
                is = conn.getInputStream();
                return parseInfo(is);
            }
            return null;

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return "timeout...";
    }



    private static String parseInfo(InputStream inStream) throws Exception {
        byte[] data = read(inStream);
        return new String(data, "UTF-8");
    }

    public static byte[] read(InputStream inStream) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        inStream.close();
        return outputStream.toByteArray();
    }
}
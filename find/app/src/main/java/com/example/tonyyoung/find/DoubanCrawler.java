package com.example.tonyyoung.find;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoubanCrawler {
    //Get image link from Douban API
    public static String ParseImgLink(String ISBN) {
        String page = getDoubanPage(ISBN);
        String imgLink = null;
        if(page == null) {
            return "no link";
        } else {
            try {
                Pattern patternItem = Pattern.compile("<link href=(.*?)rel=\"image\"/>");
                Matcher matchItem = patternItem.matcher(page);
                while (matchItem.find()){
                    String paraGroup = matchItem.group();
                    StringBuffer preParaBuffer = new StringBuffer();
                    StringBuffer postParaBuffer = new StringBuffer();
                    preParaBuffer.append("<link href=\"");
                    postParaBuffer.append("\" rel=\"image\"/>");
                    imgLink = (paraGroup.replaceAll(preParaBuffer.toString(), "")).replaceAll(postParaBuffer.toString(), "");
                }
                return imgLink;
            }catch (NullPointerException e) {
                return "no link";
            }

        }
    }

    //Get content summary from Douban API
    public static String ParseContent(String ISBN) {
        String page = getDoubanPage(ISBN);
        String content = null;
        if (page == null) {
            return "no content";
        } else {
            try {
                Pattern patternItem = Pattern.compile("<summary>(?s)(.*?)</summary>");
                Matcher matchItem = patternItem.matcher(page);
                while (matchItem.find()){
                    String paraGroup = matchItem.group();
                    StringBuffer preParaBuffer = new StringBuffer();
                    StringBuffer postParaBuffer = new StringBuffer();
                    preParaBuffer.append("<summary>");
                    postParaBuffer.append("</summary>");
                    content = (paraGroup.replaceAll(preParaBuffer.toString(), "")).replaceAll(postParaBuffer.toString(), "");
                }
                return content;
            } catch (NullPointerException e) {
                return "no content";
            }
        }
    }

    //Get Book detail HTML on Douban API
    private static String getDoubanPage(String ISBN) {
        URL url = null;
        URLConnection urlconn = null;
        BufferedReader br = null;
        String result = null;
        String imgLink = null;
        try{
            url = new URL("http://api.douban.com/book/subject/isbn/" + ISBN);
            urlconn = url.openConnection();
            urlconn.connect();
            br = new BufferedReader(new InputStreamReader(urlconn.getInputStream(),"utf-8"));
            String line;
            while((line = br.readLine()) != null) {
                result += line + "\r\n";
            }
            //System.out.println(result);
        }catch (FileNotFoundException e) {
            result = null;
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if (br != null) {
                    br.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
}
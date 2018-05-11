package com.liser.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 桐木木 on 2017/2/8.
 * 发送Http请求，获取Controller返回的数据
 *
 */

public class HttpPostUtils {
    public static String doPostRequest(String path,Object content){
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            System.out.println("要发送的信息是："+content);
            String address = "http://localhost:8080/api/httpService/"+path;
            URL url = new URL(address);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            //这两个参数必须加
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            //设置超时时间
            httpURLConnection.setReadTimeout(10*1000);
            httpURLConnection.setConnectTimeout(10*1000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.connect();

            out = new PrintWriter(httpURLConnection.getOutputStream());
            //在输出流中写入参数
            out.print(content);
            out.flush();

            if(httpURLConnection.getResponseCode() == 200){
                in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(),"utf-8"));
                String line;
                while((line = in.readLine()) != null){
                    result += line;
                }
            }
            System.out.println("服务器返回的结果是："+result);
            return result;
        } catch (MalformedURLException e) {
            System.out.println("URL异常");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO异常");
            e.printStackTrace();
        }finally {
            try{
                if(out!=null)
                    out.close();
                if(in!=null)
                    in.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

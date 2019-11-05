package bw.com.weekone.utils;


import android.os.Handler;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Time:2019/11/4
 * Author:周盟棋
 * Description:
 */
public class OkHttp {

    Handler handler = new Handler();

    private static OkHttp okHttp;

    private final OkHttpClient okHttpClient;

    private OkHttp(){
        //创建拦截器对象
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        //设置拦截器的请求级别,4个级别
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //日志拦截器,应用拦截器
        //网络拦截器
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)//日志拦截器,应用拦截器
                .addNetworkInterceptor(httpLoggingInterceptor)//网络拦截器
                .build();
    }

    /**
     * 双重校验锁
     * @return
     */
    public static OkHttp getOkHttp(){
        if (okHttp==null){//第一重
            synchronized (OkHttp.class){
                if (okHttp==null){
                    okHttp = new OkHttp();
                }
            }
        }
        return okHttp;
    }

    /**
     * get方式
     */
    public void doGet(String url){
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("userId","2018")
                .addHeader("sessionId","20191103")
                .build();

        callData(request);
    }

    /**
     * 核心请求方法
     */
    private String callData(Request request) {
        String result="";
        okHttpClient.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result="";
                if (200 == response.code()){
                    result = response.body().string();
                }
            }
        });
        return result;
    }
}

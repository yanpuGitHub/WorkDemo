package com.piaoshen.common.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author senrsl
 * @ClassName: RetrofitUtils
 * @Package: com.piaos.common.net
 * @CreateTime: 2018/5/16 下午6:09
 */
public class RetrofitInstance {

    Retrofit retrofit;


    private RetrofitInstance() {
    }

    private static final RetrofitInstance instance = new RetrofitInstance();

    public static RetrofitInstance getInstance() {
        return instance;
    }


    public void init(String baseUrl, OkHttpClient client) {
//        this.ctx = ctx;
//        sp = new SharePreferencesUtils(ctx);
//        syncUri();
//        list = new ArrayList<>();
        //对象初始化
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl) // 设置 网络请求 Url
                .addConverterFactory(ScalarsConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .client(client)
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }


}

package com.piaoshen.common.net.client;

import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import com.piaoshen.common.net.NetContext;
import com.piaoshen.common.net.interceptor.CookieGetInterceptor;
import com.piaoshen.common.net.interceptor.CookieSetInterceptor;
import com.piaoshen.common.net.interceptor.HttpHeaderInterceptor;
import com.piaoshen.common.net.interceptor.LoggerInterceptor;
import com.piaoshen.common.net.interceptor.StethoInterceptor;

import okhttp3.OkHttpClient;

import static com.piaoshen.common.net.NetContext.TIMEOUT_CONNECT;
import static com.piaoshen.common.net.NetContext.TIMEOUT_READ;
import static com.piaoshen.common.net.NetContext.TIMEOUT_WRITE;

/**
 * @author senrsl
 * @ClassName: TokenClient
 * @Package: com.piaos.common.net.client
 * @CreateTime: 2019/7/31 7:46 PM
 */
public class TokenClient {


    public OkHttpClient getTokenClient() {
        return customBuilder(getBuilder()).build();
    }

    public OkHttpClient.Builder customBuilder(OkHttpClient.Builder builder) {
        return builder;
    }

    private OkHttpClient.Builder getBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT_CONNECT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_WRITE, TimeUnit.SECONDS)
                .addInterceptor(new HttpHeaderInterceptor())
                .addInterceptor(new LoggerInterceptor())
//                .addInterceptor(new TokenInterceptor())
//                .addInterceptor(new StatInterceptor())
//                .addInterceptor(new RobustCacheInterceptor())
                .addNetworkInterceptor(new StethoInterceptor())
//                .addInterceptor(new CookieGetInterceptor())
//                .addInterceptor(new CookieSetInterceptor())
//                .addInterceptor(new CacheInterceptor())
//                .cache(new Cache(new File(CandyContext.DIR_STORAGE, CandyContext.NAME_COMP), CandyContext.CACHE_MAX))
//                .authenticator(new TokenAuthenticator())
                ;
        if (!NetContext.isDebug) builder.proxy(Proxy.NO_PROXY);
        return builder;
    }

}

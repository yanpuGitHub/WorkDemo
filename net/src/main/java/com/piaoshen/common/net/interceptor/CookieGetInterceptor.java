package com.piaoshen.common.net.interceptor;

import java.io.IOException;
import java.util.Map;

import com.piaoshen.common.net.NetContext;

import android.content.Context;
import android.content.SharedPreferences;
//import dc.android.common.BaseApplication;
import okhttp3.Cookie;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 读取本地缓存cookie使用
 *
 * @author senrsl
 * @ClassName: CookieGetInterceptor
 * @Package: com.piaoshen.common.net.interceptor
 * @CreateTime: 2019/8/2 7:38 PM
 */
public class CookieGetInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();

        /**
         * 没有导入相关包暂时注释
         SharedPreferences sp = BaseApplication.getContext().getSharedPreferences(NetContext.NAME_PREFERCE, Context.MODE_PRIVATE);
         Map<String, ?> mapCookies = sp.getAll();

         for (String key : mapCookies.keySet()) {
         Cookie cookie = Cookie.parse(chain.request().url(), String.valueOf(mapCookies.get(key)));
         if (null != cookie) builder.addHeader(NetContext.KEY_COOKIE, cookie.toString());
         }
         */
        return chain.proceed(builder.build());
    }
}

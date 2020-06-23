package com.piaoshen.common.net.interceptor;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;


/**
 * @author senrsl
 * @ClassName: StethoInterceptor
 * @Package: com.piaos.common.net
 * @CreateTime: 2018/10/24 上午10:53
 */
public class StethoInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(chain.request());
    }
}

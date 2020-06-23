package com.piaoshen.common.net.cache;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author senrsl
 * @ClassName: RobustCacheInterceptor
 * @Package: com.piaos.common.net.cache
 * @CreateTime: 2018/10/19 上午10:54
 */
public class RobustCacheInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);

        return response;
    }
}

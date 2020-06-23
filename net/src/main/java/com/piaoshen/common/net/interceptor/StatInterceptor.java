package com.piaoshen.common.net.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 三方统计
 *
 * @author senrsl
 * @ClassName: StatInterceptor
 * @Package: com.piaos.common.net.interceptor
 * @CreateTime: 2019/8/1 10:54 AM
 */
public class StatInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originRequest = chain.request();
        Response response = chain.proceed(originRequest);

        return response;
    }
}

package com.piaoshen.common.net.interceptor;

import java.io.IOException;
import java.util.logging.Logger;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 日志抓取
 *
 * @author senrsl
 * @ClassName: LoggerInterceptor
 * @Package: com.piaos.common.net.interceptor
 * @CreateTime: 2019/7/31 7:59 PM
 */
public class LoggerInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Logger.w(String.format("%s on %s%n%s", request.url(), chain.connection(), request.headers()));
        return chain.proceed(request);
    }
}

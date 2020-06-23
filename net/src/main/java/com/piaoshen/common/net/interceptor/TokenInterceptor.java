package com.piaoshen.common.net.interceptor;

import java.io.IOException;
import java.net.HttpURLConnection;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 自定义token验证
 *
 * @author senrsl
 * @ClassName: TokenInterceptor
 * @Package: com.piaos.common.net.interceptor
 * @CreateTime: 2019/8/1 10:52 AM
 */
public class TokenInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originRequest = chain.request();
        Response response = chain.proceed(originRequest);

        if (response.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
            unauthorized();
        }
        return response;
    }

    protected void unauthorized() {
//        new TokenManager(ctx).removeToken();
//        //关闭所有activity，打开登录页
//        new TaskUtils().startLogin(ctx, NetContext.LOGOUT_TIMEOUT);
    }
}

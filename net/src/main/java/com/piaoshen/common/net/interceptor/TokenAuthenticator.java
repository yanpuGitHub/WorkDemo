package com.piaoshen.common.net.interceptor;

import java.io.IOException;

import javax.annotation.Nullable;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/**
 * 内置token验证，推荐使用 TokenInterceptor
 *
 * @author senrsl
 * @ClassName: TokenAuthenticator
 * @Package: com.piaos.common.net.interceptor
 * @CreateTime: 2019/8/1 10:51 AM
 */
public class TokenAuthenticator implements Authenticator {
    @Nullable
    @Override
    public Request authenticate(Route route, Response response) throws IOException {
        return response.request();
    }
}

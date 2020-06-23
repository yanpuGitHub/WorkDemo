package com.piaoshen.common.net.interceptor;

import java.io.IOException;
import java.util.List;

import com.piaoshen.common.net.NetContext;

import android.content.Context;
import android.content.SharedPreferences;
import dc.android.common.BaseApplication;
import dc.common.Logger;
import dc.common.utils.StringUtils;
import okhttp3.Cookie;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static com.piaoshen.common.net.NetContext.HEADER_COOKIE_SET;

/**
 * 读取服务端cookie，存入sp
 *
 * @author senrsl
 * @ClassName: CookieSetInterceptor
 * @Package: com.piaoshen.common.net.interceptor
 * @CreateTime: 2019/8/2 7:36 PM
 */
public class CookieSetInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response originalResponse = chain.proceed(request);

        if (!originalResponse.headers(HEADER_COOKIE_SET).isEmpty()) {
            List<Cookie> listCookie = Cookie.parseAll(request.url(), originalResponse.headers());

            Logger.w(getClass().getSimpleName(), listCookie);

            for (Cookie cookie : listCookie) {
                if (null == cookie) continue;
                SharedPreferences.Editor editor = BaseApplication.getContext().getSharedPreferences(NetContext.NAME_PREFERCE, Context.MODE_PRIVATE).edit();
                Logger.w(getClass().getSimpleName(), cookie, cookie.domain(), cookie.name(), cookie.path(), cookie.value());
                editor.putString(StringUtils.sub(cookie.domain(), "|", cookie.name()), cookie.toString());
                editor.apply();
            }
        }

        return originalResponse;
    }

}

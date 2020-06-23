package com.piaoshen.common.net;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.piaoshen.common.net.client.TokenClient;
import com.piaoshen.common.net.interceptor.HttpHeaderInterceptor;
import com.piaoshen.common.utils.JsonInstance;
import com.piaoshen.service.IStringService;

import android.content.Context;
import android.content.Intent;
import dc.android.base.activity.BridgeActivity;
import dc.android.common.domain.BaseBean;
import dc.android.common.utils.EncryptUtils;
import dc.common.Logger;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * @author senrsl
 * @ClassName: TestActivity
 * @Package: com.piaos.common.net.interceptor
 * @CreateTime: 2019/8/1 10:40 AM
 */
public class TestActivity extends BridgeActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, TestActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void initData() {
        super.initData();

        RetrofitInstance.getInstance().init(NetContext.DOMAIN_BASE, new TokenClient() {

            @Override
            public OkHttpClient.Builder customBuilder(OkHttpClient.Builder builder) {
                builder.addInterceptor(new TestInterceptor())
                        .addInterceptor(new TestHttpHeaderInterceptor());
                return super.customBuilder(builder);
            }
        }.getTokenClient());

    }

    @Override
    protected void onResume() {
        super.onResume();

        get();
        post();
//        getVerifyCode();
//        login();
    }

    private void get() {
        String url = "https://cinema-api.piaoshen.com/movie/hot_show.api";
        IStringService service = RetrofitInstance.getInstance().getRetrofit().create(IStringService.class);
        Map<String, Object> map = new HashMap<>();
        map.put("cityId", 290);
        Call<String> call = service.get(url, map);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                Logger.w(call.request(), call.request().method(), call.request().headers(), call.request().body(), response, response.headers(), response.body());
                TestBean bean = JsonInstance.getInstance().parse(response.body(), TestBean.class);
                Logger.w(getClass().getName(), bean);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Logger.w(call, t.getMessage());
            }
        });
    }

    private void post() {
        String url = "https://user-api.piaoshen.com/user/want_see.api";
        IStringService service = RetrofitInstance.getInstance().getRetrofit().create(IStringService.class);
        Map<String, Object> map = new HashMap<>();
        map.put("pageIndex", 1);
        map.put("pageSize", 10);
//        map.put("sample*", "!('*')");

        Call<String> call = service.post(url, map);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                Logger.w(call.request(), call.request().method(), call.request().headers(), call.request().body(), response, response.headers(), response.body());
                TestBean bean = JsonInstance.getInstance().parse(response.body(), TestBean.class);
                Logger.w(getClass().getName(), bean);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Logger.w(call, t.getMessage());
            }
        });

    }

    private void getVerifyCode() {
        String url = "https://user-api.piaoshen.com/user/login_verify_code.api";
        IStringService service = RetrofitInstance.getInstance().getRetrofit().create(IStringService.class);
        Map<String, Object> map = new HashMap<>();
        map.put("phone", "13290244718");
        map.put("aLiDeviceToken", "MfFzscQOSRQFSkcER1RFo5RWykYEj7ZW57SRoRREjcoVR7JQ5cyWj7gVRKZ_RRDRyRyERoYEy5RRR1DQR1Jjy_Mo5_RQj1DQoc_yo1REycgno5SvRt_fV_KSVy5SQnsSn5ksF5cFg7kgV_7_VoQoRZDFZ5g-j1JWQ5QOW7piF7L-VygCW7onR1JSy_1F-zL4jt_nnlej5lRFylo-57BZnkpQo5BCZ_pVy7oiQZZ_QZQGjcLFRcDFRkQjQZDFR100");

        Call<String> call = service.post(url, map);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                Logger.w(call.request(), call.request().method(), call.request().headers(), call.request().body(), response, response.headers(), response.body());
                TestBean bean = JsonInstance.getInstance().parse(response.body(), TestBean.class);
                Logger.w(getClass().getName(), bean);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Logger.w(call, t.getMessage());
            }
        });
    }

    private void login() {
        String url = "https://user-api.piaoshen.com/user/login.api";
        IStringService service = RetrofitInstance.getInstance().getRetrofit().create(IStringService.class);
        Map<String, Object> map = new HashMap<>();
        map.put("phone", "13290244718");
        map.put("requestId", "a8e6179682cb4314bae1ed9fe8aa23ba");
        map.put("vcode", "562885");

        Call<String> call = service.post(url, map);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                Logger.w(call.request(), call.request().method(), call.request().headers(), call.request().body(), response, response.headers(), response.body());
                TestBean bean = JsonInstance.getInstance().parse(response.body(), TestBean.class);
                Logger.w(getClass().getName(), bean);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Logger.w(call, t.getMessage());
            }
        });
    }

//    interface IBaseBeanService{
//        @GET
//        Call<PiaosBean> get(@Url String url, @QueryMap Map<String, Object> map);
//
//        @FormUrlEncoded
//        @POST
//        Call<PiaosBean> post(@Url String url, @FieldMap Map<String, Object> map);
//    }
//
//    class PiaosBean<T> extends BaseBean{
//        private int code;
//        private String msg;
//        private DataBean data;
//        class DataBean<T>{
//            private int bizCode;
//            private String bizMsg;
//            private T t;
//        }
//    }

    class TestBean extends BaseBean {
        private int code;
        private String msg;
        //private String data;

        @Override
        public String toString() {
            return "TestBean{" +
                    "code=" + code +
                    ", msg='" + msg + '\'' +
//                    ", data='" + data + '\'' +
                    '}';
        }
    }

    class TestInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Logger.w(getClass().getName(), request);
            return chain.proceed(request);
        }
    }

    class TestHttpHeaderInterceptor extends HttpHeaderInterceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();

            Logger.w(getClass().getName(), originalRequest, originalRequest.method(), originalRequest.headers(), originalRequest.body());


            long currentTime = System.currentTimeMillis();

            Request authorised = originalRequest.newBuilder()
                    .addHeader("X-PS-ChannelCode", "android")
                    .addHeader("X-PS-TS", String.valueOf(currentTime))
                    .addHeader("X-PS-Version", "1.6.0")
                    .addHeader("X-PS-Check", generateCheckCode(currentTime, originalRequest.url().toString(), getBody(originalRequest.body())))
                    .addHeader("X-PS-UDID", "a-4e2664c8-a456-44d5-a041-319fa1b1d2b0")
                    .addHeader("X-PS-AppInstallTS", String.valueOf(currentTime - 10000))
                    .addHeader("X-PS-Device", "Mi80")
                    .addHeader("X-PS-DownloadChannel", "df")
                    .addHeader("X-PS-CID", UUID.randomUUID().toString().replace("-", ""))
                    .addHeader(getClass().getName(), new Date().toString())
                    .build();


            return chain.proceed(authorised);
        }
    }

    private String getBody(RequestBody body) {
        StringBuffer sb = new StringBuffer();
        if (null != body)
            if (body instanceof FormBody) {
                FormBody bs = (FormBody) body;
                int size = bs.size();
                for (int i = 0; i < size; i++) {
                    if (i > 0) sb.append("&");
                    sb.append(bs.encodedName(i)).append("=").append(bs.encodedValue(i));
                }
            }
        return sb.toString();
    }

    final String KEY_CHECK = "388C4D156924C9C20E335A888CBBEBCBFB08C08A1A499415FD46D18DD706E866";

    private String generateCheckCode(long currentTime, String url, String params) {
        StringBuffer sb = new StringBuffer();
        sb.append("android").append(KEY_CHECK).append(currentTime).append(url).append(params);
        try {
            return EncryptUtils.md5(sb.toString().getBytes(NetContext.ENCODE_UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }


}

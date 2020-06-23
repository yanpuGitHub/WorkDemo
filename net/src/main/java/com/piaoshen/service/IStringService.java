package com.piaoshen.service;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * @author senrsl
 * @ClassName: IStringService
 * @Package: com.piaos.service
 * @CreateTime: 2019/8/1 5:37 PM
 */
public interface IStringService {

    @GET
    Call<String> get(@Url String url, @QueryMap Map<String, Object> map);

    @FormUrlEncoded
    @POST
    Call<String> post(@Url String url, @FieldMap Map<String, Object> map);

    @POST
    Call<String> post(@HeaderMap Map<String, Object> mapHeader, @Url String url, @Body String str);

}

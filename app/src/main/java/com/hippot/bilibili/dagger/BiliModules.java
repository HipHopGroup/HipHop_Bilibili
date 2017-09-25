package com.hippot.bilibili.dagger;

import com.hippot.bilibili.function.api.ApiConstant;
import com.hippot.bilibili.function.service.BiliAppService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by teng on 17/9/25.
 */
@Module
public class BiliModules {

    @Singleton
    @Provides
    public BiliAppService getService(RxJavaCallAdapterFactory callAdapterFactory,
                                     GsonConverterFactory gsonConverterFactory,
                                     OkHttpClient client){

        return new Retrofit.Builder().addCallAdapterFactory(callAdapterFactory)
                .addConverterFactory(gsonConverterFactory).baseUrl(ApiConstant.API_BASE_URL)
                .client(client).build().create(BiliAppService.class);
    }

    @Singleton
    @Provides
    public RxJavaCallAdapterFactory getCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Singleton
    @Provides
    public GsonConverterFactory getGsonConvertFactory() {
        return GsonConverterFactory.create();
    }

    @Singleton
    @Provides
    public OkHttpClient getClient() {
        return new OkHttpClient.Builder().connectTimeout(5000, TimeUnit.MILLISECONDS)
                        .addInterceptor(new UserAgentInterceptor())
                        .readTimeout(5000, TimeUnit.MILLISECONDS)
                        .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY)).build();
    }

    /**
     * 添加UA拦截器，B站请求API需要加上UA才能正常使用
     */
    private static class UserAgentInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            Request requestWithUserAgent = originalRequest.newBuilder()
                    .removeHeader("User-Agent")
                    .addHeader("User-Agent", ApiConstant.COMMON_UA_STR)
                    .build();
            return chain.proceed(requestWithUserAgent);
        }
    }


}

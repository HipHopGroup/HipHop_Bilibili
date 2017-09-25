package com.hippot.bilibili.function.service;

import com.hippot.bilibili.function.model.RecommendInfo;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by teng on 17/9/25.
 */

public interface BiliAppService {

    /**
     * 首页推荐数据
     */
    @GET("x/show/old?platform=android&device=&build=412001")
    Observable<RecommendInfo> getRecommendedInfo();


}

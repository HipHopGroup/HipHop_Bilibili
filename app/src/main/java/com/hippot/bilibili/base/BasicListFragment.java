package com.hippot.bilibili.base;

import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by teng on 17/9/22.
 */

public abstract class BasicListFragment extends BasicFragment {

    protected int PAGE = 1;

    protected Map<String, String> params = new HashMap<>();;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    protected Map<String , String> getRequestParams(){
        return params;
    }

    protected void onLoadMore(){
        PAGE += 1;
    }



}

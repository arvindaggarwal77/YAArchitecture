package com.yaarchitectures.yamodel.yaserviceapi.yawebserviceapi;

import android.content.Context;

import com.yaarchitectures.yamodel.yaserviceapi.YAServiceApi;

/**
 * Created by yapapp on 25/11/16.
 */
public class YAWebServiceApi extends YAServiceApi {

    private static YAWebServiceApi instance;

    public static YAWebServiceApi initServiceAPIWithClient(YAWebServiceApi client){
        return client;
    }

    public void call(Context context, YAWebServiceRequest request, YAServiceApiInterface yaServiceApiInterface){

    }
}

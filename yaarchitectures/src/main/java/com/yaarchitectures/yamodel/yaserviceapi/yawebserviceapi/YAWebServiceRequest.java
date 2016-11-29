package com.yaarchitectures.yamodel.yaserviceapi.yawebserviceapi;

import com.yaarchitectures.yamodel.yaconfiguration.YAWebServerConfiguration;

import java.util.HashMap;

/**
 * Created by yapapp on 25/11/16.
 */
public class YAWebServiceRequest {
    public enum MethodType {
         GET,
         POST,
         PUT,
         DELETE
    }

   public enum ContentEncodingType{
         JSON,
         FormData,
         Base64
    }


    public MethodType selectedMethodType=MethodType.GET;
    public ContentEncodingType selectedContentEncodingType=ContentEncodingType.JSON;
    public String url;
    public HashMap<String, String> params;
    public HashMap<String,String> headers;


    public static YAWebServiceRequest createRequest(YAWebServerConfiguration configuration, String api, MethodType methodType, ContentEncodingType contentEncodingType, HashMap<String, String> params, HashMap<String,String> headers){
       if(configuration.webServerHost().length()<=0){
           throw new RuntimeException("NO server host defined, please define server host in "+(configuration)+"class. In order to define server host, create concrete class of YAWebServerConfiguration class");
       }

        YAWebServiceRequest serviceRequest=new YAWebServiceRequest();
        serviceRequest.url=configuration.webServerHost()+api;
        serviceRequest.selectedMethodType=methodType;
        serviceRequest.selectedContentEncodingType=contentEncodingType;
        serviceRequest.params=params;
        serviceRequest.headers=headers;

        return serviceRequest;
    }
}

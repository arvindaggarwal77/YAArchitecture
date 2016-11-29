package com.yaarchitectures.yamodel.yaserviceapi.yadbserviceapi;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by yapapp on 26/11/16.
 */
public class YADBServiceRequest {

    public enum MethodType{
        FETCH,
        INSERT,
        UPDATE,
        DELETE,
        CLEAR
    }


    public MethodType selectedMethodType=MethodType.FETCH;
    public HashMap<String, Object> params;
    public String query;

  public static YADBServiceRequest createRequest(String query,MethodType methodType, HashMap<String, Object> parameters){
      YADBServiceRequest serviceRequest=new YADBServiceRequest();
      serviceRequest.query=query;
      serviceRequest.selectedMethodType=methodType;
      serviceRequest.params=parameters;
      return serviceRequest;

  }


}

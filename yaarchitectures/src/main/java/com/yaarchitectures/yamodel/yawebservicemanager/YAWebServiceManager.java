package com.yaarchitectures.yamodel.yawebservicemanager;

import android.content.Context;

import com.yaarchitectures.yamodel.yadatamodel.YAError;

/**
 * Created by yapapp on 25/11/16.
 */
public class YAWebServiceManager {

    public interface YAWebServiceManagerInterface{
        public void didCompleteWebService(Object object);
        public void failedToCompleteWebService(YAError error);
    }

    public Context context;
    public Object result;
    public YAError error;
    public YAWebServiceManagerInterface  yaWebServiceManagerInterface;
}

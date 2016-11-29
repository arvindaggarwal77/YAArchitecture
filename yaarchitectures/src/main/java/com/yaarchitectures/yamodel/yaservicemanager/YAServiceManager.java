package com.yaarchitectures.yamodel.yaservicemanager;

import android.content.Context;

import com.yaarchitectures.yamodel.yadatamodel.YAError;

/**
 * Created by yapapp on 25/11/16.
 */
public class YAServiceManager {

    public interface YAServiceManagerInterface {
        public void didCompleteService(Object object);

        public void failedToCompleteService(YAError error);
    }

    public Object result;
    public YAError error;
    public YAServiceManagerInterface yaServiceManagerInterface;
    public Context context;

}

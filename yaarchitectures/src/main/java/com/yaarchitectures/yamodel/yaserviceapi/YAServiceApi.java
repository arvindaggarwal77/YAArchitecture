package com.yaarchitectures.yamodel.yaserviceapi;

import android.content.Context;

import com.yaarchitectures.yamodel.yadatamodel.YAError;

/**
 * Created by yapapp on 25/11/16.
 */
public class YAServiceApi {

    public Object result;
    public YAError error;
    public Context context;
    public YAServiceApiInterface yaServiceApiInterface;

    public interface YAServiceApiInterface {
        public void didCompleteApi(Object result);

        public void failedToCompleteApi(YAError error);
    }
}

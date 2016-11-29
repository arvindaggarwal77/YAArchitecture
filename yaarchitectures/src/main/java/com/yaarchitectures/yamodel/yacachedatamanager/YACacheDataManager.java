package com.yaarchitectures.yamodel.yacachedatamanager;

import com.yaarchitectures.yamodel.yadatamodel.YAError;

/**
 * Created by yapapp on 25/11/16.
 */
public class YACacheDataManager {
    public interface YACacheDataManagerInterface{
        public void didCompleteService(Object object);
        public void failedToCompleteService(YAError error);
    }

    Object result;
    YAError error;
    YACacheDataManagerInterface  yaCacheDataManagerInterface;
}

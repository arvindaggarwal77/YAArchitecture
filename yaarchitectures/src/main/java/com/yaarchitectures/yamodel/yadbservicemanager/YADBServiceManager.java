package com.yaarchitectures.yamodel.yadbservicemanager;

import com.yaarchitectures.yamodel.yadatamodel.YAError;

/**
 * Created by yapapp on 25/11/16.
 */
public class YADBServiceManager {
    public interface YADBServiceManagerInterface{
        public void didCompleteDBService(Object object);
        public void failedToCompleteDBService(YAError error);
    }

   public Object result;
   public YAError error;
   public YADBServiceManagerInterface  yaDBServiceManagerInterface;

}

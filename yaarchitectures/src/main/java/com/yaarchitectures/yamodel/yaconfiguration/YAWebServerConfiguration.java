package com.yaarchitectures.yamodel.yaconfiguration;

/**
 * Created by yapapp on 29/11/16.
 */
public class YAWebServerConfiguration extends YAConfiguration {

    @Override
    public YAConfiguration initConfigurationWithClient(YAConfiguration client) {
         super.initConfigurationWithClient(client);

        return client;
    }

    public String webServerHost() {

        throw  new RuntimeException("This function should can only be called by its concrete class");

    }
}

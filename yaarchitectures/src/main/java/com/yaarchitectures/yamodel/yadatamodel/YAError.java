package com.yaarchitectures.yamodel.yadatamodel;

/**
 * Created by yapapp on 25/11/16.
 */
public class YAError {

    public enum  CodeType{
        NETWORK_ERROR,
        WEBSERVICE_ERROR,
        DB_ERROR
    }
    String localizedDescription;
    String description;

    public CodeType getCodeType() {
        return codeType;
    }

    public void setCodeType(CodeType codeType) {
        this.codeType = codeType;
    }

    int    code;
    CodeType codeType;

    public String getLocalizedDescription() {
        return localizedDescription;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public void setLocalizedDescription(String localizedDescription) {
        this.localizedDescription = localizedDescription;
    }



    public void setCode(int code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public static YAError generateError(String description,String localizedDescription,String debugDescription,int code,CodeType codeType){
        YAError yaError=new YAError();
        yaError.setCode(code);
        yaError.setDescription(description);
        yaError.setLocalizedDescription(localizedDescription);
        yaError.setCodeType(codeType);

        return yaError;

    }

}

package com.yaarchitectures.yaview;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.yaarchitectures.utils.ActivityUtils;


/**
 * Created by yapapp on 24/11/16.
 */
public class YAView extends RelativeLayout {


    public interface YAViewInterface{

    }


    private Context context;
    private YAViewInterface yaViewInterface;

    public YAView(Context context) {
        super(context);
        this.context=context;
    }



    public YAView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
    }

    public YAView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
    }

    public YAView(Context context,YAViewInterface yaViewInterface){
        super(context);
        this.context=context;
        this.yaViewInterface=yaViewInterface;
    }


    public void showAlert(String message){
        ActivityUtils.showAlert(context,message);
    }

    public void showAlert(String message,DialogInterface.OnClickListener clickListner){

        ActivityUtils.showAlert(context,message,clickListner);
    }

    public void showSnackAlert(String message){


    }

}

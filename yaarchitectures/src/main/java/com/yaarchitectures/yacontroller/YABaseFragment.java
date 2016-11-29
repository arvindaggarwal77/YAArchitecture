package com.yaarchitectures.yacontroller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

/**
 * Created by yapapp on 24/11/16.
 */
public class YABaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();

        ((YABaseActivity)getActivity()).showHideAppBar(showAppBar());
        ((YABaseActivity)getActivity()).enableDisableDrawer(showDrawer());
    }

    public void replaceFragment(YABaseFragment fragment, boolean add) {
        try {
            ((YABaseActivity)getActivity()).replaceFragment(fragment, add);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showSnackAlert(String message){
        ((YABaseActivity)getActivity()).showAlert(message);
    }

    public boolean showAppBar(){
        return false;
    }


    public TabLayout getTabs(){
        return   ((YABaseActivity)getActivity()).tablayout;
    }

    public void setTitle(String title){
        ((YABaseActivity)getActivity()).getToolBar().setTitle(title);
    }

    public boolean showDrawer(){
        return false;
    }
}

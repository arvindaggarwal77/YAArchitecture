package com.yaarchitectures.yacontroller;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.yaarchitectures.R;

/**
 * Created by yapapp on 24/11/16.
 */
public class YABaseActivity extends AppCompatActivity {

    public  CoordinatorLayout coordinatorLayout;
    public AppBarLayout appBarLayout;
    public FrameLayout container;
    public TabLayout tablayout;
    public Toolbar toolBar;
    public DrawerLayout mDrawerLayout;
    public NavigationView navigationView;
    public ActionBar supportActionBar;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


/*
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBoolean("isAppBar",((FragmentBase)getCurrentFragment()).showAppBar());
        outState.putBoolean("isDrawer",((FragmentBase)getCurrentFragment()).showDrawer());

    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        showHideAppBar(savedInstanceState.getBoolean("isAppBar"));
        enableDisableDrawer(savedInstanceState.getBoolean("isDrawer"));
    }*/

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ya_base);
        initializeView();
    }

    public void initializeView() {
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        container = (FrameLayout) findViewById(R.id.container);
        tablayout = (TabLayout) findViewById(R.id.tabs);
        toolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        appBarLayout.setVisibility(View.GONE);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer); // Adding menu icon to Toolbar
        supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            VectorDrawableCompat indicator
                    = VectorDrawableCompat.create(getResources(), R.drawable.ic_menu, getTheme());
            indicator.setTint(ResourcesCompat.getColor(getResources(), R.color.white, getTheme()));
            supportActionBar.setHomeAsUpIndicator(indicator);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    public Toolbar getToolBar() {
        return toolBar;
    }

    public void showAlert(String message) {
        Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_SHORT).show();
    }


    public void replaceFragment(Fragment fragment, boolean addToBackStack) {
        String tag = Integer.toString(getFragmentCount()); //fragment.getClass().getSimpleName();
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (addToBackStack) {
            transaction.replace(R.id.container, fragment, tag);
            transaction.addToBackStack(tag);
        } else {
            transaction.replace(R.id.container, fragment, null);
        }

        transaction.commitAllowingStateLoss();
    }


    public int getFragmentCount() {
        return getSupportFragmentManager().getBackStackEntryCount();
    }

    public void showHideAppBar(boolean bool) {
        if (bool) {
            appBarLayout.setVisibility(View.VISIBLE);
            return;
        }
        appBarLayout.setVisibility(View.GONE);
    }


    @Override
    public void onBackPressed() {
        //

        if (getFragmentCount() == 1) {
            finish();
            return;
        }
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //     getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void enableDisableDrawer(boolean bool) {

        if (!bool) {
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        } else {
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        }
    }

    public void pop() {
        FragmentManager fm = getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
    }

    public Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentById(R.id.container);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement/*
        if (id == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

}

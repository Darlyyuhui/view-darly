package com.darly.darlyview.ui.grav;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.darly.darlyview.R;
import com.darly.dview.framework.ContentBinder;

/**GravActivity粒子动画效果
 * @author Darly/张宇辉/2018/3/13 15:04
 * @version 1.0/com.darly.darlyview.ui.grav
 */
@ContentBinder(R.layout.activity_grav)
public class GravActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grav);
        initView();
    }

    protected void initView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (NavigationView) findViewById(R.id.nav);
        showView(R.layout.fragment_grav);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle =
                new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name,
                        R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        actionBarDrawerToggle.syncState();
        initNavigationView();
    }

    private void showView( int view){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, GravSampleFragment.newInstance(view))
                .commit();
    }

    private void initNavigationView() {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override public boolean onNavigationItemSelected(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.ball_wave:
                                showView(R.layout.fragment_ball_wave);
                                return true;
                            case R.id.grav:
                                showView(R.layout.fragment_grav);
                                return true;
                            case R.id.robot:
                                showView(R.layout.fragment_robot);
                                return true;
                            case R.id.falcon:
                                showView(R.layout.fragment_falcon);
                                return true;
                            case R.id.bubble:
                                showView(R.layout.fragment_bubble);
                                return true;
                            case R.id.path:
                                showView(R.layout.fragment_path);
                                return true;
                        }
                        return false;
                    }
                });
    }
}

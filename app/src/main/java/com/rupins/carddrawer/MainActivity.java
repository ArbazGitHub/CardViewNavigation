package com.rupins.carddrawer;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.design.widget.NavigationView;

import com.rupins.carddrawer.Adapter.LeftMenuAdapter;
import com.rupins.carddrawer.Fragment.TestFragment;
import com.rupins.carddrawer.Model.MenuMain;
import com.rupins.drawercardbehaviour.CardDrawerLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private CardDrawerLayout drawer;

    private RecyclerView rvMenu;
    private ArrayList<MenuMain> menuMainArrayList;
    LeftMenuAdapter leftMenuAdapter;
    MenuMain menuMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (CardDrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawer.setViewScale(Gravity.START, 0.9f);
        drawer.setRadius(Gravity.START, 35);
        drawer.setViewElevation(Gravity.START, 20);

        rvMenu = findViewById(R.id.rvMenu);
        rvMenu.setLayoutManager(new LinearLayoutManager(this));
        menuMainArrayList = new ArrayList<>();
        menuMainArrayList.add(new MenuMain("Testing Data"));
        menuMainArrayList.add(new MenuMain("Testing Data"));
        menuMainArrayList.add(new MenuMain("Testing Data"));
        menuMainArrayList.add(new MenuMain("Testing Data"));
        menuMainArrayList.add(new MenuMain("Testing Data"));
        menuMainArrayList.add(new MenuMain("Testing Data"));
        menuMainArrayList.add(new MenuMain("Testing Data"));
        menuMainArrayList.add(new MenuMain("Testing Data"));
        menuMainArrayList.add(new MenuMain("Testing Data"));
        menuMainArrayList.add(new MenuMain("Testing Data"));
        leftMenuAdapter = new LeftMenuAdapter(menuMainArrayList, this);
        rvMenu.setAdapter(leftMenuAdapter);

        rvMenu.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this,rvMenu, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                try {
                    menuMain = menuMainArrayList.get(position);
                        if (menuMain.getItemName().equalsIgnoreCase("Testing Data")) {
                            changeFragment(new TestFragment());
                            drawer.closeDrawer(GravityCompat.START);
                        }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onItemLongClick(View view, int position) {
            }
        }));
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_right_drawer:
                drawer.openDrawer(Gravity.END);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    void changeFragment(Fragment fragment) {
        try {
            String backStateName = fragment.getClass().getName();
            String fragmentTag = backStateName;

            FragmentManager manager = getSupportFragmentManager();
            boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);


            if (!fragmentPopped && manager.findFragmentByTag(fragmentTag) == null) {
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                fragmentTransaction.replace(R.id.test_container, fragment, fragmentTag);
                fragmentTransaction.addToBackStack(backStateName);
                fragmentTransaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

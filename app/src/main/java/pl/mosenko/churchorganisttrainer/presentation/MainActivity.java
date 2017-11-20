package pl.mosenko.churchorganisttrainer.presentation;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;
import pl.mosenko.churchorganisttrainer.R;
import pl.mosenko.churchorganisttrainer.presentation.common.view.BaseActivity;
import pl.mosenko.churchorganisttrainer.presentation.invocation.InvocationFragment;
import pl.mosenko.churchorganisttrainer.utils.ActivityUtil;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener/*, HasFragmentInjector*/ {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawer;
    @BindView(R.id.navView)
    NavigationView navigationView;
/*    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        syncDrawerMenuWithToolbar();
        addListenerToNavigationView();
        addDefaultFragmentInvocationsList();
    }

    private void addDefaultFragmentInvocationsList() {
        InvocationFragment invocationFragment = InvocationFragment.newInstance();
        ActivityUtil.addFragmentToActivity(getSupportFragmentManager(), invocationFragment,
                R.id.fragmentContainer);
    }

    private void addListenerToNavigationView() {
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void syncDrawerMenuWithToolbar() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
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
        int id = item.getItemId();

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

/*    @Override
    public AndroidInjector<Fragment> fragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }*/
}

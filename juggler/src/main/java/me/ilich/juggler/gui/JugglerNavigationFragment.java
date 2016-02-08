package me.ilich.juggler.gui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;

import me.ilich.juggler.R;

public abstract class JugglerNavigationFragment extends JugglerFragment {

    private static final String ARG_SELECTED_ITEM = "selected_item";

    protected static Bundle addSelectedItemToBundle(@Nullable Bundle bundle, int itemIndex) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt(ARG_SELECTED_ITEM, itemIndex);
        return bundle;
    }

    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        drawerLayout = (DrawerLayout) getActivity().findViewById(getDrawerLayoutId());
        drawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, getOpen(), getClose());
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
        int selectItem = getArguments().getInt(ARG_SELECTED_ITEM);
        onNavigationItemSelect(selectItem);
    }

    @IdRes
    protected int getDrawerLayoutId() {
        return R.id.drawer_layout;
    }

    @StringRes
    protected int getOpen() {
        return R.string.drawer_open;
    }

    @StringRes
    protected int getClose() {
        return R.string.drawer_close;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean b = drawerToggle.onOptionsItemSelected(menuItem);
        if (!b) {
            b = super.onOptionsItemSelected(menuItem);
        }
        return b;
    }

    protected abstract void onNavigationItemSelect(int id);

    public void close(){
        drawerLayout.closeDrawer(GravityCompat.START);
    }

}
package me.ilich.juggler.staticjuggler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.ilich.juggler.usage.R;

public class ToolbarFragment extends Fragment {

    public static ToolbarFragment create() {
        return new ToolbarFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_stub_toolbar, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Juggler.tools(this).toolbar(view, R.id.toolbar);
        Juggler.callback(this).onToolbar((Toolbar) view.findViewById(R.id.toolbar));
    }

    @Override
    public void onStart() {
        super.onStart();
        //Juggler.callback(this).onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        //Juggler.callback(this).onStop();
    }

}
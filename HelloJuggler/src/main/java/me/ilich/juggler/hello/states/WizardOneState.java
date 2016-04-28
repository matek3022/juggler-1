package me.ilich.juggler.hello.states;

import android.content.Context;
import android.graphics.drawable.Drawable;

import me.ilich.juggler.gui.JugglerFragment;
import me.ilich.juggler.hello.gui.fragments.StandardToolbarFragment;
import me.ilich.juggler.hello.gui.fragments.WizardOneFragment;
import me.ilich.juggler.states.ContentBelowToolbarState;
import me.ilich.juggler.states.VoidParams;

public class WizardOneState extends ContentBelowToolbarState<VoidParams> {

    public WizardOneState() {
        super(VoidParams.instance());
    }

    @Override
    public String getTitle(Context context, VoidParams params) {
        return "Wizard One";
    }

    @Override
    protected JugglerFragment onCreateContent(VoidParams params) {
        return new WizardOneFragment();
    }

    @Override
    protected JugglerFragment onCreateToolbar(VoidParams params) {
        return StandardToolbarFragment.createTitleBack();
    }

    @Override
    public Drawable getUpNavigationIcon(Context context, VoidParams params) {
        return context.getResources().getDrawable(android.R.drawable.ic_media_next);
    }

}

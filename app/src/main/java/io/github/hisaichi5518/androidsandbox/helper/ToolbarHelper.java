package io.github.hisaichi5518.androidsandbox.helper;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class ToolbarHelper {
    public static void init(AppCompatActivity activity, Toolbar toolbar, int resId) {
        activity.setSupportActionBar(toolbar);
        toolbar.setTitle(resId);
    }
}

package io.github.hisaichi5518.androidsandbox.helper;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class ActivityHelper {
    public static boolean onOptionsItemSelected(AppCompatActivity activity, MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                activity.finish();

                return true;
        }

        return false;
    }
}

package io.github.hisaichi5518.androidsandbox.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.hisaichi5518.androidsandbox.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.activity_main__recycler_button)
    void onClickedRecyclerViewButton() {
        startActivity(new GridRecyclerViewActivityIntentBuilder().build(this));
    }
}

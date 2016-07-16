package io.github.hisaichi5518.androidsandbox.ui.activity;

import android.databinding.DataBindingUtil;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.github.hisaichi5518.androidsandbox.R;
import io.github.hisaichi5518.androidsandbox.databinding.ActivityRecyclerViewBinding;
import io.github.hisaichi5518.androidsandbox.helper.ActivityHelper;
import se.emilsjolander.intentbuilder.IntentBuilder;

@IntentBuilder
public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRecyclerViewBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);

        binding.activityRecyclerViewToolbar.setTitle(R.string.title_activity_recycler_view);
        setSupportActionBar(binding.activityRecyclerViewToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        binding.activityRecyclerViewList.setAdapter(new ItemAdapter());
        binding.activityRecyclerViewList.setLayoutManager(new GridLayoutManager(this, 2));

        int margin = getResources().getDimensionPixelSize(R.dimen.recycler_view_margin);
        binding.activityRecyclerViewList.addItemDecoration(new ItemDecoration(margin, margin, margin, margin));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean result = ActivityHelper.onOptionsItemSelected(this, item);
        return result || super.onOptionsItemSelected(item);
    }

    private class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {
        private static final int ITEM_COUNT = 20;

        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ItemViewHolder(new TextView(RecyclerViewActivity.this));
        }

        @Override
        public void onBindViewHolder(ItemViewHolder holder, int position) {
            holder.render();
        }

        @Override
        public int getItemCount() {
            return ITEM_COUNT;
        }
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {
        ItemViewHolder(View itemView) {
            super(itemView);
        }

        void render() {
            ((TextView) itemView).setText("こんにちはこんにちは");
            itemView.setBackgroundColor(ContextCompat.getColor(RecyclerViewActivity.this, R.color.colorAccent));
        }
    }

    private class ItemDecoration extends RecyclerView.ItemDecoration {
        private int left, top, right, bottom;

        ItemDecoration(int left, int top, int right, int bottom) {
            this.left = left;
            this.top = top;
            this.right = right;
            this.bottom = bottom;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();

            int position = layoutParams.getViewAdapterPosition();
            if (position == RecyclerView.NO_POSITION) {
                outRect.set(0, 0, 0, 0);
                return;
            }

            outRect.left = left;
            outRect.top = top;
            outRect.right = right;
            outRect.bottom = bottom;
        }
    }
}

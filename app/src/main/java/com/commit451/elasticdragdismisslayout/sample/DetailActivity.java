package com.commit451.elasticdragdismisslayout.sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.commit451.elasticdragdismisslayout.ElasticDragDismissFrameLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Sample detail activity
 */
public class DetailActivity extends AppCompatActivity {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, DetailActivity.class);
        return intent;
    }

    @Bind(R.id.draggable_frame) ElasticDragDismissFrameLayout mDraggableFrame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        mDraggableFrame.addListener(
                new SystemChromeFader(getWindow()) {
                    @Override
                    public void onDragDismissed() {
                        // if we drag dismiss downward then the default reversal of the enter
                        // transition would slide content upward which looks weird. So reverse it.
                        if (mDraggableFrame.getTranslationY() > 0) {
                            //TODO
//                            getWindow().setReturnTransition(
//                                    TransitionInflater.from(AboutActivity.this)
//                                            .inflateTransition(R.transition.about_return_downward));
                        }
                        finishAfterTransition();
                    }
                });
    }
}

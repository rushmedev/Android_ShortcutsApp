package com.company.app.elements.appleactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.content.Intent;
import com.company.app.activities.ASleepActivity;
import com.company.app.activities.AppleActivity;
import com.company.app.elements.appleactivity.ScrollView1;
import com.company.app.elements.appleactivity.StaticList1;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import com.company.app.R;

public class StaticListTile2 extends PercentRelativeLayout {
  public AppCompatImageView imageView2;

  public AppCompatImageButton imageButton2;

  public AppCompatTextView textView2;

  public StaticListTile2(Context context) {
    super(context);
  }

  public StaticListTile2(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public StaticListTile2(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    StaticListTile2.this.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            AppleActivity activity =
                ((AppleActivity)
                    ((ScrollView1) ((StaticList1) getParent().getParent()).getParent().getParent())
                        .getContext());
            Intent transitionIntent = new Intent(activity, ASleepActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    imageView2 = (AppCompatImageView) findViewById(R.id.image_view22);

    imageButton2 = (AppCompatImageButton) findViewById(R.id.image_button23);

    textView2 = (AppCompatTextView) findViewById(R.id.text_view2);
  }
}
package com.company.app.elements.windowsactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.content.Intent;
import com.company.app.activities.WindowsWindowsKeyActivity;
import com.company.app.activities.WindowsActivity;
import com.company.app.elements.windowsactivity.ScrollView1;
import com.company.app.elements.windowsactivity.StaticList1;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.AppCompatImageView;
import com.company.app.R;

public class StaticListTile2 extends PercentRelativeLayout {
  public AppCompatTextView textView2;

  public AppCompatImageView imageView3;

  public AppCompatImageView imageView4;

  public StaticListTile2(Context context) {
    super(context);
  }

  public StaticListTile2(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public StaticListTile2(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    StaticListTile2.this.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            WindowsActivity activity =
                ((WindowsActivity)
                    ((ScrollView1) ((StaticList1) getParent().getParent()).getParent().getParent())
                        .getContext());
            Intent transitionIntent = new Intent(activity, WindowsWindowsKeyActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    textView2 = (AppCompatTextView) findViewById(R.id.text_view23);

    imageView3 = (AppCompatImageView) findViewById(R.id.image_view3);

    imageView4 = (AppCompatImageView) findViewById(R.id.image_view4);
  }
}
package com.company.app.elements.appleactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.content.Intent;
import com.company.app.activities.ACutAndOtherCommonShortcutsActivity;
import com.company.app.activities.AppleActivity;
import com.company.app.elements.appleactivity.ScrollView1;
import com.company.app.elements.appleactivity.StaticList1;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import com.company.app.R;

public class StaticListTile1 extends PercentRelativeLayout {
  public AppCompatTextView textView1;

  public AppCompatImageButton imageButton1;

  public AppCompatImageView imageView1;

  public StaticListTile1(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public StaticListTile1(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public StaticListTile1(Context context) {
    super(context);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    StaticListTile1.this.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            AppleActivity activity =
                ((AppleActivity)
                    ((ScrollView1) ((StaticList1) getParent().getParent()).getParent().getParent())
                        .getContext());
            Intent transitionIntent =
                new Intent(activity, ACutAndOtherCommonShortcutsActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    textView1 = (AppCompatTextView) findViewById(R.id.text_view12);

    imageButton1 = (AppCompatImageButton) findViewById(R.id.image_button12);

    imageView1 = (AppCompatImageView) findViewById(R.id.image_view1);
  }
}
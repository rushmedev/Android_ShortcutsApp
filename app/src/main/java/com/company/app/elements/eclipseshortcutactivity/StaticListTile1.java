package com.company.app.elements.eclipseshortcutactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.content.Intent;
import com.company.app.activities.EclipseWindowsActivity;
import com.company.app.activities.EclipseShortcutActivity;
import com.company.app.elements.eclipseshortcutactivity.ScrollView1;
import com.company.app.elements.eclipseshortcutactivity.StaticList1;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import com.company.app.R;

public class StaticListTile1 extends PercentRelativeLayout {
  public AppCompatImageView imageView1;

  public AppCompatImageButton imageButton1;

  public AppCompatTextView textView1;

  public StaticListTile1(Context context) {
    super(context);
  }

  public StaticListTile1(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public StaticListTile1(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    StaticListTile1.this.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            EclipseShortcutActivity activity =
                ((EclipseShortcutActivity)
                    ((ScrollView1) ((StaticList1) getParent().getParent()).getParent().getParent())
                        .getContext());
            Intent transitionIntent = new Intent(activity, EclipseWindowsActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    imageView1 = (AppCompatImageView) findViewById(R.id.image_view14);

    imageButton1 = (AppCompatImageButton) findViewById(R.id.image_button11);

    textView1 = (AppCompatTextView) findViewById(R.id.text_view14);
  }
}
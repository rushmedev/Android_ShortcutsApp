package com.company.app.elements.eclipseshortcutactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.content.Intent;
import com.company.app.activities.EclipseMacOSShortcutsActivity;
import com.company.app.activities.EclipseShortcutActivity;
import com.company.app.elements.eclipseshortcutactivity.ScrollView1;
import com.company.app.elements.eclipseshortcutactivity.StaticList1;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.AppCompatImageView;
import com.company.app.R;

public class StaticListTile2 extends PercentRelativeLayout {
  public AppCompatImageButton imageButton2;

  public AppCompatTextView textView2;

  public AppCompatImageView imageView2;

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
            EclipseShortcutActivity activity =
                ((EclipseShortcutActivity)
                    ((ScrollView1) ((StaticList1) getParent().getParent()).getParent().getParent())
                        .getContext());
            Intent transitionIntent = new Intent(activity, EclipseMacOSShortcutsActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    imageButton2 = (AppCompatImageButton) findViewById(R.id.image_button21);

    textView2 = (AppCompatTextView) findViewById(R.id.text_view21);

    imageView2 = (AppCompatImageView) findViewById(R.id.image_view23);
  }
}
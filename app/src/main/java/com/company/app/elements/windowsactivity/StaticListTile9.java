package com.company.app.elements.windowsactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.content.Intent;
import com.company.app.activities.WindowsNarratorShortcutsActivity;
import com.company.app.activities.WindowsActivity;
import com.company.app.elements.windowsactivity.ScrollView1;
import com.company.app.elements.windowsactivity.StaticList1;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.AppCompatImageView;
import com.company.app.R;

public class StaticListTile9 extends PercentRelativeLayout {
  public AppCompatImageView imageView17;

  public AppCompatTextView textView9;

  public AppCompatImageView imageView18;

  public StaticListTile9(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public StaticListTile9(Context context) {
    super(context);
  }

  public StaticListTile9(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    StaticListTile9.this.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            WindowsActivity activity =
                ((WindowsActivity)
                    ((ScrollView1) ((StaticList1) getParent().getParent()).getParent().getParent())
                        .getContext());
            Intent transitionIntent = new Intent(activity, WindowsNarratorShortcutsActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    imageView17 = (AppCompatImageView) findViewById(R.id.image_view17);

    textView9 = (AppCompatTextView) findViewById(R.id.text_view9);

    imageView18 = (AppCompatImageView) findViewById(R.id.image_view18);
  }
}
package com.company.app.elements.windowsactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.content.Intent;
import com.company.app.activities.WindowsOtherShortcutsActivity;
import com.company.app.activities.WindowsActivity;
import com.company.app.elements.windowsactivity.ScrollView1;
import com.company.app.elements.windowsactivity.StaticList1;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.AppCompatImageView;
import com.company.app.R;

public class StaticListTile10 extends PercentRelativeLayout {
  public AppCompatTextView textView10;

  public AppCompatImageView imageView19;

  public AppCompatImageView imageView20;

  public StaticListTile10(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public StaticListTile10(Context context) {
    super(context);
  }

  public StaticListTile10(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    StaticListTile10.this.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            WindowsActivity activity =
                ((WindowsActivity)
                    ((ScrollView1) ((StaticList1) getParent().getParent()).getParent().getParent())
                        .getContext());
            Intent transitionIntent = new Intent(activity, WindowsOtherShortcutsActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    textView10 = (AppCompatTextView) findViewById(R.id.text_view10);

    imageView19 = (AppCompatImageView) findViewById(R.id.image_view19);

    imageView20 = (AppCompatImageView) findViewById(R.id.image_view20);
  }
}
package com.company.app.elements.windowsactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.content.Intent;
import com.company.app.activities.WindowsGeneralShortcutsActivity;
import com.company.app.activities.WindowsActivity;
import com.company.app.elements.windowsactivity.ScrollView1;
import com.company.app.elements.windowsactivity.StaticList1;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.AppCompatImageView;
import com.company.app.R;

public class StaticListTile1 extends PercentRelativeLayout {
  public AppCompatTextView textView1;

  public AppCompatImageView imageView2;

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
            WindowsActivity activity =
                ((WindowsActivity)
                    ((ScrollView1) ((StaticList1) getParent().getParent()).getParent().getParent())
                        .getContext());
            Intent transitionIntent = new Intent(activity, WindowsGeneralShortcutsActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    textView1 = (AppCompatTextView) findViewById(R.id.text_view1);

    imageView2 = (AppCompatImageView) findViewById(R.id.image_view2);

    imageView1 = (AppCompatImageView) findViewById(R.id.image_view111);
  }
}
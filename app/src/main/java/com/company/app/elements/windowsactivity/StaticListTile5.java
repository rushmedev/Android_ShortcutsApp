package com.company.app.elements.windowsactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.content.Intent;
import com.company.app.activities.WindowsTaskbarShortcutsActivity;
import com.company.app.activities.WindowsActivity;
import com.company.app.elements.windowsactivity.ScrollView1;
import com.company.app.elements.windowsactivity.StaticList1;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.AppCompatImageView;
import com.company.app.R;

public class StaticListTile5 extends PercentRelativeLayout {
  public AppCompatImageView imageView9;

  public AppCompatTextView textView5;

  public AppCompatImageView imageView10;

  public StaticListTile5(Context context) {
    super(context);
  }

  public StaticListTile5(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public StaticListTile5(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    StaticListTile5.this.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            WindowsActivity activity =
                ((WindowsActivity)
                    ((ScrollView1) ((StaticList1) getParent().getParent()).getParent().getParent())
                        .getContext());
            Intent transitionIntent = new Intent(activity, WindowsTaskbarShortcutsActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    imageView9 = (AppCompatImageView) findViewById(R.id.image_view9);

    textView5 = (AppCompatTextView) findViewById(R.id.text_view51);

    imageView10 = (AppCompatImageView) findViewById(R.id.image_view10);
  }
}
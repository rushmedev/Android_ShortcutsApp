package com.company.app.elements.windowsactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.content.Intent;
import com.company.app.activities.WindowsFileExplorerActivity;
import com.company.app.activities.WindowsActivity;
import com.company.app.elements.windowsactivity.ScrollView1;
import com.company.app.elements.windowsactivity.StaticList1;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import com.company.app.R;

public class StaticListTile4 extends PercentRelativeLayout {
  public AppCompatImageView imageView8;

  public AppCompatImageView imageView7;

  public AppCompatTextView textView4;

  public StaticListTile4(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public StaticListTile4(Context context) {
    super(context);
  }

  public StaticListTile4(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    StaticListTile4.this.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            WindowsActivity activity =
                ((WindowsActivity)
                    ((ScrollView1) ((StaticList1) getParent().getParent()).getParent().getParent())
                        .getContext());
            Intent transitionIntent = new Intent(activity, WindowsFileExplorerActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    imageView8 = (AppCompatImageView) findViewById(R.id.image_view8);

    imageView7 = (AppCompatImageView) findViewById(R.id.image_view7);

    textView4 = (AppCompatTextView) findViewById(R.id.text_view42);
  }
}
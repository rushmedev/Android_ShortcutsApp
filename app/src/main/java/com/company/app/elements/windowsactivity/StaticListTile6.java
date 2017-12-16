package com.company.app.elements.windowsactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.content.Intent;
import com.company.app.activities.WindowsEaseOfAccessActivity;
import com.company.app.activities.WindowsActivity;
import com.company.app.elements.windowsactivity.ScrollView1;
import com.company.app.elements.windowsactivity.StaticList1;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import com.company.app.R;

public class StaticListTile6 extends PercentRelativeLayout {
  public AppCompatImageView imageView12;

  public AppCompatImageView imageView11;

  public AppCompatTextView textView6;

  public StaticListTile6(Context context) {
    super(context);
  }

  public StaticListTile6(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public StaticListTile6(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    StaticListTile6.this.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            WindowsActivity activity =
                ((WindowsActivity)
                    ((ScrollView1) ((StaticList1) getParent().getParent()).getParent().getParent())
                        .getContext());
            Intent transitionIntent = new Intent(activity, WindowsEaseOfAccessActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    imageView12 = (AppCompatImageView) findViewById(R.id.image_view12);

    imageView11 = (AppCompatImageView) findViewById(R.id.image_view11);

    textView6 = (AppCompatTextView) findViewById(R.id.text_view6);
  }
}
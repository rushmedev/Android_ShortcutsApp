package com.company.app.elements.mainactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.content.Intent;
import com.company.app.activities.WindowsActivity;
import com.company.app.activities.MainActivity;
import com.company.app.elements.mainactivity.ViewPager1;
import com.company.app.elements.mainactivity.PagerView1;
import com.company.app.elements.mainactivity.StaticList1;
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

  public StaticListTile1(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public StaticListTile1(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    StaticListTile1.this.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            MainActivity activity =
                ((MainActivity)
                    ((ViewPager1)
                            ((PagerView1) ((StaticList1) getParent().getParent()).getParent())
                                .getParent())
                        .getContext());
            Intent transitionIntent = new Intent(activity, WindowsActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    imageView1 = (AppCompatImageView) findViewById(R.id.image_view16);

    imageButton1 = (AppCompatImageButton) findViewById(R.id.image_button1);

    textView1 = (AppCompatTextView) findViewById(R.id.text_view11);
  }
}
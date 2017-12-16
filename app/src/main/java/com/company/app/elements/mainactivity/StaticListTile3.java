package com.company.app.elements.mainactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.content.Intent;
import com.company.app.activities.AppleActivity;
import com.company.app.activities.MainActivity;
import com.company.app.elements.mainactivity.ViewPager1;
import com.company.app.elements.mainactivity.PagerView1;
import com.company.app.elements.mainactivity.StaticList1;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import com.company.app.R;

public class StaticListTile3 extends PercentRelativeLayout {
  public AppCompatTextView textView3;

  public AppCompatImageButton imageButton3;

  public AppCompatImageView imageView3;

  public StaticListTile3(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public StaticListTile3(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public StaticListTile3(Context context) {
    super(context);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    StaticListTile3.this.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            MainActivity activity =
                ((MainActivity)
                    ((ViewPager1)
                            ((PagerView1) ((StaticList1) getParent().getParent()).getParent())
                                .getParent())
                        .getContext());
            Intent transitionIntent = new Intent(activity, AppleActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    textView3 = (AppCompatTextView) findViewById(R.id.text_view32);

    imageButton3 = (AppCompatImageButton) findViewById(R.id.image_button31);

    imageView3 = (AppCompatImageView) findViewById(R.id.image_view32);
  }
}
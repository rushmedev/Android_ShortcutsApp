package com.company.app.elements.mainactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.content.Intent;
import com.company.app.activities.UbuntuActivity;
import com.company.app.activities.MainActivity;
import com.company.app.elements.mainactivity.ViewPager1;
import com.company.app.elements.mainactivity.PagerView1;
import com.company.app.elements.mainactivity.StaticList1;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.AppCompatImageButton;
import com.company.app.R;

public class StaticListTile2 extends PercentRelativeLayout {
  public AppCompatImageView imageView2;

  public AppCompatTextView textView2;

  public AppCompatImageButton imageButton2;

  public StaticListTile2(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public StaticListTile2(Context context) {
    super(context);
  }

  public StaticListTile2(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    StaticListTile2.this.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            MainActivity activity =
                ((MainActivity)
                    ((ViewPager1)
                            ((PagerView1) ((StaticList1) getParent().getParent()).getParent())
                                .getParent())
                        .getContext());
            Intent transitionIntent = new Intent(activity, UbuntuActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    imageView2 = (AppCompatImageView) findViewById(R.id.image_view21);

    textView2 = (AppCompatTextView) findViewById(R.id.text_view22);

    imageButton2 = (AppCompatImageButton) findViewById(R.id.image_button22);
  }
}
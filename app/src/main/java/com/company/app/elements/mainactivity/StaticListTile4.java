package com.company.app.elements.mainactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.content.Intent;
import com.company.app.activities.EclipseShortcutActivity;
import com.company.app.activities.MainActivity;
import com.company.app.elements.mainactivity.ViewPager1;
import com.company.app.elements.mainactivity.PagerView1;
import com.company.app.elements.mainactivity.StaticList1;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import com.company.app.R;

public class StaticListTile4 extends PercentRelativeLayout {
  public AppCompatImageView imageView4;

  public AppCompatImageButton imageButton4;

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
            MainActivity activity =
                ((MainActivity)
                    ((ViewPager1)
                            ((PagerView1) ((StaticList1) getParent().getParent()).getParent())
                                .getParent())
                        .getContext());
            Intent transitionIntent = new Intent(activity, EclipseShortcutActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    imageView4 = (AppCompatImageView) findViewById(R.id.image_view41);

    imageButton4 = (AppCompatImageButton) findViewById(R.id.image_button4);

    textView4 = (AppCompatTextView) findViewById(R.id.text_view41);
  }
}
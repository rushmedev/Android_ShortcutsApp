package com.company.app.elements.appleactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.content.Intent;
import com.company.app.activities.AFinderShortcutsActivity;
import com.company.app.activities.AppleActivity;
import com.company.app.elements.appleactivity.ScrollView1;
import com.company.app.elements.appleactivity.StaticList1;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.AppCompatImageView;
import com.company.app.R;

public class StaticListTile4 extends PercentRelativeLayout {
  public AppCompatImageButton imageButton4;

  public AppCompatTextView textView4;

  public AppCompatImageView imageView4;

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
            AppleActivity activity =
                ((AppleActivity)
                    ((ScrollView1) ((StaticList1) getParent().getParent()).getParent().getParent())
                        .getContext());
            Intent transitionIntent = new Intent(activity, AFinderShortcutsActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    imageButton4 = (AppCompatImageButton) findViewById(R.id.image_button41);

    textView4 = (AppCompatTextView) findViewById(R.id.text_view43);

    imageView4 = (AppCompatImageView) findViewById(R.id.image_view43);
  }
}
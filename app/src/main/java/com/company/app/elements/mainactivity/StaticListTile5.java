package com.company.app.elements.mainactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import com.company.app.R;

public class StaticListTile5 extends PercentRelativeLayout {
  public AppCompatTextView textView5;

  public AppCompatImageButton imageButton5;

  public AppCompatImageView imageView5;

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

    textView5 = (AppCompatTextView) findViewById(R.id.text_view52);

    imageButton5 = (AppCompatImageButton) findViewById(R.id.image_button51);

    imageView5 = (AppCompatImageView) findViewById(R.id.image_view51);
  }
}
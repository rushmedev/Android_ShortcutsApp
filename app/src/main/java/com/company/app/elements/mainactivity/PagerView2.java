package com.company.app.elements.mainactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.support.v4.app.FragmentManager;

public class PagerView2 extends PercentRelativeLayout {
  private FragmentManager fragmentManager;

  public PagerView2(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  public PagerView2(Context context) {
    super(context);
  }

  public PagerView2(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
  }

  public void onPageVisible() {}
}
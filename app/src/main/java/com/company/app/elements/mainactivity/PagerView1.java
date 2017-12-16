package com.company.app.elements.mainactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.support.v4.app.FragmentManager;
import com.company.app.elements.mainactivity.StaticList1;
import com.google.android.gms.ads.AdView;
import com.company.app.R;
import com.google.android.gms.ads.AdRequest;

public class PagerView1 extends PercentRelativeLayout {
  private FragmentManager fragmentManager;

  public StaticList1 staticList1;

  public AdView adMobBannerAd1;

  public PagerView1(Context context) {
    super(context);
  }

  public PagerView1(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  public PagerView1(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public void onPageVisible() {}

  @Override
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();

    this.staticList1 = (StaticList1) findViewById(R.id.static_list1);

    adMobBannerAd1 = (AdView) findViewById(R.id.ad_mob_banner_ad123);

    adMobBannerAd1.loadAd(new AdRequest.Builder().build());
  }
}
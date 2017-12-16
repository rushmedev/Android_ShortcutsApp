package com.company.app.activities;

import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.os.Bundle;
import android.os.Build;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import com.company.app.R;
import android.view.View;
import android.widget.TextView;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.graphics.PorterDuff;
import com.company.app.activities.EclipseMacOSShortcutsActivity;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdRequest;
import com.company.app.elements.eclipsemacosshortcutsactivity.ScrollView1;

public class EclipseMacOSShortcutsActivity extends AppCompatActivity {
  public LinearLayout mMainLayout;

  public Toolbar appBar;

  public AdView adMobBannerAd1;

  public ScrollView1 scrollView1;

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
  }

  public EclipseMacOSShortcutsActivity getContext() {
    return this;
  }

  @Override
  protected void onResume() {
    super.onResume();

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      getWindow().setStatusBarColor(Color.parseColor("#FF155AEE"));
    }
  }

  @Override
  protected void onStart() {
    super.onStart();
  }

  @Override
  protected void onPause() {
    super.onPause();
  }

  @Override
  protected void onStop() {
    super.onStop();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.eclipse_mac_os_shortcuts);

    mMainLayout = (LinearLayout) findViewById(R.id.eclipse_mac_os_shortcuts);

    this.setup();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }

  private void setup() {
    appBar = (Toolbar) findViewById(R.id.app_bar13);

    EclipseMacOSShortcutsActivity.this.setSupportActionBar(appBar);

    for (int i = 0; i < appBar.getChildCount(); ++i) {
      View child = appBar.getChildAt(i);
      if (child instanceof TextView) {
        child.setBackgroundColor(Color.TRANSPARENT);
        break;
      }
    }

    appBar.setNavigationIcon(
        ContextCompat.getDrawable(getContext(), R.drawable.icons8_left_24px_ffffffff));

    appBar
        .getNavigationIcon()
        .mutate()
        .setColorFilter(Color.parseColor("#FFFFFFFF"), PorterDuff.Mode.SRC_ATOP);

    appBar.setNavigationOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            EclipseMacOSShortcutsActivity.this.finish();
          }
        });

    adMobBannerAd1 = (AdView) findViewById(R.id.ad_mob_banner_ad119);

    adMobBannerAd1.loadAd(new AdRequest.Builder().build());

    this.scrollView1 = (ScrollView1) findViewById(R.id.scroll_view14);
  }
}
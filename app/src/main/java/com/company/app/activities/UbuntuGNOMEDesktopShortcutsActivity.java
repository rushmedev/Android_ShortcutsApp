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
import com.company.app.activities.UbuntuGNOMEDesktopShortcutsActivity;
import com.company.app.elements.ubuntugnomedesktopshortcutsactivity.ScrollView1;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdRequest;

public class UbuntuGNOMEDesktopShortcutsActivity extends AppCompatActivity {
  public LinearLayout mMainLayout;

  public Toolbar appBar;

  public ScrollView1 scrollView1;

  public AdView adMobBannerAd1;

  public UbuntuGNOMEDesktopShortcutsActivity getContext() {
    return this;
  }

  @Override
  protected void onStop() {
    super.onStop();
  }

  @Override
  protected void onStart() {
    super.onStart();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
  }

  @Override
  protected void onResume() {
    super.onResume();

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      getWindow().setStatusBarColor(Color.parseColor("#FF14B165"));
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.ubuntu_gnome_desktopshortcuts);

    mMainLayout = (LinearLayout) findViewById(R.id.ubuntu_gnome_desktopshortcuts);

    this.setup();
  }

  @Override
  protected void onPause() {
    super.onPause();
  }

  private void setup() {
    appBar = (Toolbar) findViewById(R.id.app_bar);

    UbuntuGNOMEDesktopShortcutsActivity.this.setSupportActionBar(appBar);

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
            UbuntuGNOMEDesktopShortcutsActivity.this.finish();
          }
        });

    this.scrollView1 = (ScrollView1) findViewById(R.id.scroll_view17);

    adMobBannerAd1 = (AdView) findViewById(R.id.ad_mob_banner_ad11);

    adMobBannerAd1.loadAd(new AdRequest.Builder().build());
  }
}
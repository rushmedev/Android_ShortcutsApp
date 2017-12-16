package com.company.app.activities;

import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.os.Bundle;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.graphics.Color;
import android.content.Intent;
import com.company.app.elements.mainactivity.ViewPager1;
import com.company.app.R;

public class MainActivity extends AppCompatActivity {
  public LinearLayout mMainLayout;

  public ViewPager1 viewPager1;

  @Override
  protected void onStart() {
    super.onStart();
  }

  @Override
  protected void onStop() {
    super.onStop();
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
  }

  public MainActivity getContext() {
    return this;
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }

  @Override
  protected void onPause() {
    super.onPause();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.main);

    mMainLayout = (LinearLayout) findViewById(R.id.main);

    this.setup();
  }

  @Override
  protected void onResume() {
    super.onResume();

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      getWindow().setStatusBarColor(Color.parseColor("#FF673AB7"));
    }
  }

  private void setup() {
    viewPager1 = (ViewPager1) findViewById(R.id.view_pager1);
  }
}
package com.company.app.elements.mainactivity;

import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentManager;
import com.company.app.R;
import android.util.AttributeSet;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.support.design.widget.TabLayout;
import com.company.app.elements.mainactivity.PagerView1;
import com.company.app.fragments.PagerView1Page;
import com.company.app.elements.mainactivity.PagerView2;
import com.company.app.fragments.PagerView2Page;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.Fragment;

public class ViewPager1 extends ViewPager {
  private int lastPageIndex = 0;

  TabLayout tabs;

  ViewPager1 self = this;

  public Adapter adapter;

  Integer[] titles;

  public ViewPager1(Context context, AttributeSet attrs) {
    super(context, attrs);

    this.setOffscreenPageLimit(1);

    titles = new Integer[] {R.string.pager_view1_title, R.string.pager_view2_title};

    setupAdapter(((FragmentActivity) getContext()).getSupportFragmentManager());
  }

  public ViewPager1(Context context) {
    this(context, null);
  }

  public void setupAdapter(FragmentManager fragmentManager) {
    adapter = new Adapter(fragmentManager);

    this.setAdapter(adapter);
  }

  private void setupTabs() {
    for (int i = 0; i < titles.length; i++) {
      if (titles[i] != null && tabs.getTabAt(i) != null) tabs.getTabAt(i).setText(titles[i]);
    }
  }

  @Override
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();

    tabs = (TabLayout) (((View) getParent()).findViewById(R.id.view_pager1_tabs));

    tabs.setupWithViewPager(this);

    setupTabs();

    this.setOnPageChangeListener(
        new ViewPager.OnPageChangeListener() {
          @Override
          public void onPageScrollStateChanged(int state) {}

          @Override
          public void onPageScrolled(
              int position, float positionOffset, int positionOffsetPixels) {}

          @Override
          public void onPageSelected(int position) {
            Boolean wasSwipedLeft = position > lastPageIndex;
            lastPageIndex = position;
            switch (position) {
              case 0:
                ((PagerView1)
                        ((PagerView1Page)
                                ViewPager1.this.adapter.instantiateItem(ViewPager1.this, position))
                            .getView()
                            .findViewById(R.id.pager_view1))
                    .onPageVisible();
                break;
              case 1:
                ((PagerView2)
                        ((PagerView2Page)
                                ViewPager1.this.adapter.instantiateItem(ViewPager1.this, position))
                            .getView()
                            .findViewById(R.id.pager_view2))
                    .onPageVisible();
                break;
            }
          }
        });
  }

  public class Adapter extends FragmentPagerAdapter {
    private final int NUM_ITEMS = 2;

    public Adapter(FragmentManager fragmentManager) {
      super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
      switch (position) {
        case 0:
          return new PagerView1Page();
        case 1:
          return new PagerView2Page();
        default:
          return null;
      }
    }

    @Override
    public int getCount() {
      return NUM_ITEMS;
    }
  }
}
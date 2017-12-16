package com.company.app.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import com.company.app.R;
import com.company.app.elements.mainactivity.ViewPager1;
import com.company.app.elements.mainactivity.PagerView1;

public class PagerView1Page extends Fragment {
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
    super.onCreateView(inflater, container, bundle);

    View view = inflater.inflate(R.layout.pager_view1_page, container, false);

    return view;
  }
}
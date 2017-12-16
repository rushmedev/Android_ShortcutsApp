package com.company.app.elements.eclipseshortcutactivity;

import android.widget.ScrollView;
import android.content.Context;
import android.util.AttributeSet;
import com.company.app.elements.eclipseshortcutactivity.StaticList1;
import com.company.app.R;

public class ScrollView1 extends ScrollView {
  public StaticList1 staticList1;

  public ScrollView1(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public ScrollView1(Context context) {
    super(context);
  }

  public ScrollView1(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    this.staticList1 = (StaticList1) findViewById(R.id.static_list11);
  }
}
package com.company.app.elements.eclipseshortcutactivity;

import android.widget.ScrollView;
import android.content.Context;
import android.util.AttributeSet;
import com.company.app.elements.eclipseshortcutactivity.StaticListTile1;
import com.company.app.elements.eclipseshortcutactivity.StaticListTile2;
import com.company.app.R;

public class StaticList1 extends ScrollView {
  public StaticListTile1 staticListTile1;

  public StaticListTile2 staticListTile2;

  public StaticList1(Context context) {
    super(context);
  }

  public StaticList1(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public StaticList1(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    this.staticListTile1 = (StaticListTile1) findViewById(R.id.static_list_tile11);

    this.staticListTile2 = (StaticListTile2) findViewById(R.id.static_list_tile22);
  }
}
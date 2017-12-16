package com.company.app.elements.appleactivity;

import android.widget.ScrollView;
import android.content.Context;
import android.util.AttributeSet;
import com.company.app.elements.appleactivity.StaticListTile1;
import com.company.app.elements.appleactivity.StaticListTile4;
import com.company.app.elements.appleactivity.StaticListTile3;
import com.company.app.elements.appleactivity.StaticListTile2;
import com.company.app.R;

public class StaticList1 extends ScrollView {
  public StaticListTile1 staticListTile1;

  public StaticListTile4 staticListTile4;

  public StaticListTile3 staticListTile3;

  public StaticListTile2 staticListTile2;

  public StaticList1(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public StaticList1(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public StaticList1(Context context) {
    super(context);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    this.staticListTile1 = (StaticListTile1) findViewById(R.id.static_list_tile14);

    this.staticListTile4 = (StaticListTile4) findViewById(R.id.static_list_tile41);

    this.staticListTile3 = (StaticListTile3) findViewById(R.id.static_list_tile33);

    this.staticListTile2 = (StaticListTile2) findViewById(R.id.static_list_tile24);
  }
}
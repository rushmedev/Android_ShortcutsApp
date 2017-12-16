package com.company.app.elements.mainactivity;

import android.widget.ScrollView;
import android.content.Context;
import android.util.AttributeSet;
import com.company.app.elements.mainactivity.StaticListTile5;
import com.company.app.elements.mainactivity.StaticListTile4;
import com.company.app.elements.mainactivity.StaticListTile1;
import com.company.app.elements.mainactivity.StaticListTile3;
import com.company.app.elements.mainactivity.StaticListTile2;
import com.company.app.R;

public class StaticList1 extends ScrollView {
  public StaticListTile5 staticListTile5;

  public StaticListTile4 staticListTile4;

  public StaticListTile1 staticListTile1;

  public StaticListTile3 staticListTile3;

  public StaticListTile2 staticListTile2;

  public StaticList1(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public StaticList1(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public StaticList1(Context context) {
    super(context);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    this.staticListTile5 = (StaticListTile5) findViewById(R.id.static_list_tile51);

    this.staticListTile4 = (StaticListTile4) findViewById(R.id.static_list_tile4);

    this.staticListTile1 = (StaticListTile1) findViewById(R.id.static_list_tile13);

    this.staticListTile3 = (StaticListTile3) findViewById(R.id.static_list_tile31);

    this.staticListTile2 = (StaticListTile2) findViewById(R.id.static_list_tile2);
  }
}
package com.company.app.elements.windowsactivity;

import android.widget.ScrollView;
import android.content.Context;
import android.util.AttributeSet;
import com.company.app.elements.windowsactivity.StaticListTile10;
import com.company.app.elements.windowsactivity.StaticListTile6;
import com.company.app.elements.windowsactivity.StaticListTile9;
import com.company.app.elements.windowsactivity.StaticListTile5;
import com.company.app.elements.windowsactivity.StaticListTile7;
import com.company.app.elements.windowsactivity.StaticListTile8;
import com.company.app.elements.windowsactivity.StaticListTile3;
import com.company.app.elements.windowsactivity.StaticListTile1;
import com.company.app.elements.windowsactivity.StaticListTile2;
import com.company.app.elements.windowsactivity.StaticListTile4;
import com.company.app.R;

public class StaticList1 extends ScrollView {
  public StaticListTile10 staticListTile10;

  public StaticListTile6 staticListTile6;

  public StaticListTile9 staticListTile9;

  public StaticListTile5 staticListTile5;

  public StaticListTile7 staticListTile7;

  public StaticListTile8 staticListTile8;

  public StaticListTile3 staticListTile3;

  public StaticListTile1 staticListTile1;

  public StaticListTile2 staticListTile2;

  public StaticListTile4 staticListTile4;

  public StaticList1(Context context) {
    super(context);
  }

  public StaticList1(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public StaticList1(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    this.staticListTile10 = (StaticListTile10) findViewById(R.id.static_list_tile10);

    this.staticListTile6 = (StaticListTile6) findViewById(R.id.static_list_tile6);

    this.staticListTile9 = (StaticListTile9) findViewById(R.id.static_list_tile9);

    this.staticListTile5 = (StaticListTile5) findViewById(R.id.static_list_tile5);

    this.staticListTile7 = (StaticListTile7) findViewById(R.id.static_list_tile7);

    this.staticListTile8 = (StaticListTile8) findViewById(R.id.static_list_tile8);

    this.staticListTile3 = (StaticListTile3) findViewById(R.id.static_list_tile32);

    this.staticListTile1 = (StaticListTile1) findViewById(R.id.static_list_tile1);

    this.staticListTile2 = (StaticListTile2) findViewById(R.id.static_list_tile23);

    this.staticListTile4 = (StaticListTile4) findViewById(R.id.static_list_tile42);
  }
}
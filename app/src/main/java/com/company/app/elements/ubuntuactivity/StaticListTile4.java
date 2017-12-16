package com.company.app.elements.ubuntuactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.content.Intent;
import com.company.app.activities.UbuntuShortcutsForCompizActivity;
import com.company.app.activities.UbuntuActivity;
import com.company.app.elements.ubuntuactivity.ScrollView1;
import com.company.app.elements.ubuntuactivity.StaticList1;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatImageButton;
import com.company.app.R;

public class StaticListTile4 extends PercentRelativeLayout {
  public AppCompatTextView textView4;

  public AppCompatImageView imageView4;

  public AppCompatImageButton imageButton4;

  public StaticListTile4(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public StaticListTile4(Context context) {
    super(context);
  }

  public StaticListTile4(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    StaticListTile4.this.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            UbuntuActivity activity =
                ((UbuntuActivity)
                    ((ScrollView1) ((StaticList1) getParent().getParent()).getParent().getParent())
                        .getContext());
            Intent transitionIntent = new Intent(activity, UbuntuShortcutsForCompizActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    textView4 = (AppCompatTextView) findViewById(R.id.text_view4);

    imageView4 = (AppCompatImageView) findViewById(R.id.image_view42);

    imageButton4 = (AppCompatImageButton) findViewById(R.id.image_button42);
  }
}
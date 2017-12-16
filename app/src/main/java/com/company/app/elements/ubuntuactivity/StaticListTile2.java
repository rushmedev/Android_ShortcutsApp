package com.company.app.elements.ubuntuactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.content.Intent;
import com.company.app.activities.UbuntuGNOMEDesktopShortcutsActivity;
import com.company.app.activities.UbuntuActivity;
import com.company.app.elements.ubuntuactivity.ScrollView1;
import com.company.app.elements.ubuntuactivity.StaticList1;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatImageButton;
import com.company.app.R;

public class StaticListTile2 extends PercentRelativeLayout {
  public AppCompatTextView textView2;

  public AppCompatImageView imageView2;

  public AppCompatImageButton imageButton2;

  public StaticListTile2(Context context) {
    super(context);
  }

  public StaticListTile2(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public StaticListTile2(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    StaticListTile2.this.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            UbuntuActivity activity =
                ((UbuntuActivity)
                    ((ScrollView1) ((StaticList1) getParent().getParent()).getParent().getParent())
                        .getContext());
            Intent transitionIntent =
                new Intent(activity, UbuntuGNOMEDesktopShortcutsActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    textView2 = (AppCompatTextView) findViewById(R.id.text_view24);

    imageView2 = (AppCompatImageView) findViewById(R.id.image_view24);

    imageButton2 = (AppCompatImageButton) findViewById(R.id.image_button2);
  }
}
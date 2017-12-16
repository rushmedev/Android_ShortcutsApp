package com.company.app.elements.ubuntuactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.content.Intent;
import com.company.app.activities.UbuntuGeneralKeyBoardActivity;
import com.company.app.activities.UbuntuActivity;
import com.company.app.elements.ubuntuactivity.ScrollView1;
import com.company.app.elements.ubuntuactivity.StaticList1;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatImageButton;
import com.company.app.R;

public class StaticListTile1 extends PercentRelativeLayout {
  public AppCompatTextView textView1;

  public AppCompatImageView imageView1;

  public AppCompatImageButton imageButton1;

  public StaticListTile1(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public StaticListTile1(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public StaticListTile1(Context context) {
    super(context);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    StaticListTile1.this.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            UbuntuActivity activity =
                ((UbuntuActivity)
                    ((ScrollView1) ((StaticList1) getParent().getParent()).getParent().getParent())
                        .getContext());
            Intent transitionIntent = new Intent(activity, UbuntuGeneralKeyBoardActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    textView1 = (AppCompatTextView) findViewById(R.id.text_view13);

    imageView1 = (AppCompatImageView) findViewById(R.id.image_view110);

    imageButton1 = (AppCompatImageButton) findViewById(R.id.image_button13);
  }
}
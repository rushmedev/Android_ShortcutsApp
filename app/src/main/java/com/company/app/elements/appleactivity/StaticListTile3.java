package com.company.app.elements.appleactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.content.Intent;
import com.company.app.activities.ADocumentShortcutsActivity;
import com.company.app.activities.AppleActivity;
import com.company.app.elements.appleactivity.ScrollView1;
import com.company.app.elements.appleactivity.StaticList1;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import com.company.app.R;

public class StaticListTile3 extends PercentRelativeLayout {
  public AppCompatImageButton imageButton3;

  public AppCompatImageView imageView3;

  public AppCompatTextView textView3;

  public StaticListTile3(Context context) {
    super(context);
  }

  public StaticListTile3(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public StaticListTile3(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    StaticListTile3.this.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            AppleActivity activity =
                ((AppleActivity)
                    ((ScrollView1) ((StaticList1) getParent().getParent()).getParent().getParent())
                        .getContext());
            Intent transitionIntent = new Intent(activity, ADocumentShortcutsActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    imageButton3 = (AppCompatImageButton) findViewById(R.id.image_button32);

    imageView3 = (AppCompatImageView) findViewById(R.id.image_view31);

    textView3 = (AppCompatTextView) findViewById(R.id.text_view33);
  }
}
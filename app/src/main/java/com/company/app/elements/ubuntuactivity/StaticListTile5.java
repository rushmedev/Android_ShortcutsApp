package com.company.app.elements.ubuntuactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.content.Intent;
import com.company.app.activities.UbuntuShortcutForNautilusActivity;
import com.company.app.activities.UbuntuActivity;
import com.company.app.elements.ubuntuactivity.ScrollView1;
import com.company.app.elements.ubuntuactivity.StaticList1;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatImageButton;
import com.company.app.R;

public class StaticListTile5 extends PercentRelativeLayout {
  public AppCompatTextView textView5;

  public AppCompatImageView imageView5;

  public AppCompatImageButton imageButton5;

  public StaticListTile5(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public StaticListTile5(Context context) {
    super(context);
  }

  public StaticListTile5(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    StaticListTile5.this.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            UbuntuActivity activity =
                ((UbuntuActivity)
                    ((ScrollView1) ((StaticList1) getParent().getParent()).getParent().getParent())
                        .getContext());
            Intent transitionIntent = new Intent(activity, UbuntuShortcutForNautilusActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    textView5 = (AppCompatTextView) findViewById(R.id.text_view5);

    imageView5 = (AppCompatImageView) findViewById(R.id.image_view52);

    imageButton5 = (AppCompatImageButton) findViewById(R.id.image_button5);
  }
}
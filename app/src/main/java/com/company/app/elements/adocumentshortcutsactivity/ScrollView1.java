package com.company.app.elements.adocumentshortcutsactivity;

import android.widget.ScrollView;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.company.app.R;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.annotation.TargetApi;
import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.URLUtil;
import android.content.Intent;
import android.net.Uri;
import com.company.app.activities.ADocumentShortcutsActivity;
import com.company.app.elements.adocumentshortcutsactivity.ScrollView1;
import android.webkit.WebResourceError;

public class ScrollView1 extends ScrollView {
  public WebView webView1;

  public ScrollView1(Context context) {
    super(context);
  }

  public ScrollView1(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public ScrollView1(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    webView1 = (WebView) findViewById(R.id.web_view13);

    webView1.setWebChromeClient(new WebChromeClient());

    webView1.getSettings().setDomStorageEnabled(true);

    webView1.setWebViewClient(
        new WebViewClient() {
          @TargetApi(Build.VERSION_CODES.LOLLIPOP)
          @Override
          public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            String url = request.getUrl().toString();
            if (URLUtil.isNetworkUrl(url)) {
              return false;
            }
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            ((ADocumentShortcutsActivity) ((ScrollView1) getParent().getParent()).getContext())
                .startActivity(intent);
            return true;
          }

          @SuppressWarnings("deprecation")
          @Override
          public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (URLUtil.isNetworkUrl(url)) {
              return false;
            }
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            ((ADocumentShortcutsActivity) ((ScrollView1) getParent().getParent()).getContext())
                .startActivity(intent);
            return true;
          }

          @Override
          public void onReceivedError(
              WebView webView,
              WebResourceRequest webResourceRequest,
              WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            ScrollView1.this.webView1.reload();
          }
        });

    webView1.loadUrl("https://farm5.staticflickr.com/4568/37630200945_6d0e95e485_o.png");

    webView1.getSettings().setUseWideViewPort(true);

    webView1.getSettings().setLoadWithOverviewMode(true);

    webView1.getSettings().setSupportZoom(true);

    webView1.getSettings().setJavaScriptEnabled(true);
  }
}
package rkr.binatestation.shopping.activities;

import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import rkr.binatestation.shopping.R;

public class HomeActivity extends AppCompatActivity {

    public static final String URL_SHOP_GROCERY = "http://shopgrocery.co.in/";
    private static final String TAG = "HomeActivity";
    private WebView mWebView;
    private ContentLoadingProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mWebView = (WebView) findViewById(R.id.AH_web_view);
        mProgressBar = (ContentLoadingProgressBar) findViewById(R.id.AH_progress_bar);

        if (mWebView != null) {
            mWebView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageFinished(WebView view, String url) {
                    Log.d(TAG, "onPageFinished() called with: view = [" + view + "], url = [" + url + "]");
                    super.onPageFinished(view, url);
                    mProgressBar.hide();
                }

                @Override
                public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                    Log.d(TAG, "onReceivedError() called with: view = [" + view + "], request = [" + request + "], error = [" + error + "]");
                    super.onReceivedError(view, request, error);
                    mProgressBar.hide();
                }
            });
            mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            mWebView.loadUrl(URL_SHOP_GROCERY);
        }

    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

}

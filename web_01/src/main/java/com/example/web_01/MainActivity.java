package com.example.web_01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    private Button back;
    private Button refresh;

    private TextView titleView;

    private TextView mTextView_Error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webView);
        // 默认调用系统浏览器打开网页
//        webView.loadUrl("http://www.baidu.com");
        webView.loadUrl("http://apk.hiapk.com/");

        back = (Button) findViewById(R.id.back);
        refresh = (Button) findViewById(R.id.refresh);
        titleView = (TextView) findViewById(R.id.title);

        mTextView_Error = (TextView) findViewById(R.id.textView_error);

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                titleView.setText(title);
                super.onReceivedTitle(view, title);
            }
        });

        // 直接打开网页 而不是去调用系统的浏览器打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);

                return super.shouldOverrideUrlLoading(view, url);
            }

//            @Override
//            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
//                super.onReceivedError(view, errorCode, description, failingUrl);
//            }


            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
//                view.loadUrl("file:///android_asset/error.html");
                mTextView_Error.setText("404 error");
                webView.setVisibility(View.GONE);
            }

        });

        webView.setDownloadListener(new MyDownload());

        refresh.setOnClickListener(new MyListener());
        back.setOnClickListener(new MyListener());

    }

    class MyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.refresh:
                    webView.reload();
                    break;
                case R.id.back:
                    finish();
                    break;
            }
        }
    }

    class MyDownload implements DownloadListener {

        @Override
        public void onDownloadStart(String url, String userAgent, String contentDisposition,
                                    String mimetype, long contentLength) {

            System.out.println("url------------>" + url);
            if (url.endsWith(".apk")) {
                new HttpThread(url).start();
            }

        }
    }

}

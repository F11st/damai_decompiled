package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baseproject.ui.R$id;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class PullToRefreshWebView extends PullToRefreshBase<WebView> {
    private static final PullToRefreshBase.OnRefreshListener<WebView> defaultOnRefreshListener = new a();
    private final WebChromeClient defaultWebChromeClient;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    @TargetApi(9)
    /* loaded from: classes10.dex */
    public final class InternalWebViewSDK9 extends WebView {
        static final int OVERSCROLL_FUZZY_THRESHOLD = 2;
        static final float OVERSCROLL_SCALE_FACTOR = 1.5f;

        public InternalWebViewSDK9(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private int getScrollRange() {
            return (int) Math.max(0.0f, ((float) Math.floor(((WebView) PullToRefreshWebView.this.mRefreshableView).getContentHeight() * ((WebView) PullToRefreshWebView.this.mRefreshableView).getScale())) - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }

        @Override // android.view.View
        protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            com.handmark.pulltorefresh.library.a.b(PullToRefreshWebView.this, i2, i4, getScrollRange(), 2, 1.5f, z);
            return overScrollBy;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class a implements PullToRefreshBase.OnRefreshListener<WebView> {
        a() {
        }

        @Override // com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener
        public void onRefresh(PullToRefreshBase<WebView> pullToRefreshBase) {
            pullToRefreshBase.getRefreshableView().reload();
        }
    }

    public PullToRefreshWebView(Context context) {
        super(context);
        WebChromeClient webChromeClient = new WebChromeClient() { // from class: com.handmark.pulltorefresh.library.PullToRefreshWebView.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                if (i == 100) {
                    PullToRefreshWebView.this.onRefreshComplete();
                }
            }
        };
        this.defaultWebChromeClient = webChromeClient;
        setOnRefreshListener(defaultOnRefreshListener);
        ((WebView) this.mRefreshableView).setWebChromeClient(webChromeClient);
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    protected boolean isReadyForPullDown() {
        return ((WebView) this.mRefreshableView).getScrollY() == 0;
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    protected boolean isReadyForPullUp() {
        return ((float) ((WebView) this.mRefreshableView).getScrollY()) >= ((float) Math.floor((double) (((float) ((WebView) this.mRefreshableView).getContentHeight()) * ((WebView) this.mRefreshableView).getScale()))) - ((float) ((WebView) this.mRefreshableView).getHeight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public WebView createRefreshableView(Context context, AttributeSet attributeSet) {
        WebView webView;
        if (Build.VERSION.SDK_INT >= 9) {
            webView = new InternalWebViewSDK9(context, attributeSet);
        } else {
            webView = new WebView(context, attributeSet);
        }
        webView.setId(R$id.webview);
        return webView;
    }

    public PullToRefreshWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        WebChromeClient webChromeClient = new WebChromeClient() { // from class: com.handmark.pulltorefresh.library.PullToRefreshWebView.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                if (i == 100) {
                    PullToRefreshWebView.this.onRefreshComplete();
                }
            }
        };
        this.defaultWebChromeClient = webChromeClient;
        setOnRefreshListener(defaultOnRefreshListener);
        ((WebView) this.mRefreshableView).setWebChromeClient(webChromeClient);
    }

    public PullToRefreshWebView(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
        WebChromeClient webChromeClient = new WebChromeClient() { // from class: com.handmark.pulltorefresh.library.PullToRefreshWebView.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                if (i == 100) {
                    PullToRefreshWebView.this.onRefreshComplete();
                }
            }
        };
        this.defaultWebChromeClient = webChromeClient;
        setOnRefreshListener(defaultOnRefreshListener);
        ((WebView) this.mRefreshableView).setWebChromeClient(webChromeClient);
    }
}

package cn.damai.uikit.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import cn.damai.uikit.R$id;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshBase;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PullToRefreshWebView extends PullToRefreshBase<WebView> {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final PullToRefreshBase.OnRefreshListener<WebView> defaultOnRefreshListener = new a();
    private final WebChromeClient defaultWebChromeClient;

    /* compiled from: Taobao */
    @TargetApi(9)
    /* loaded from: classes8.dex */
    public final class InternalWebViewSDK9 extends WebView {
        private static transient /* synthetic */ IpChange $ipChange = null;
        static final int OVERSCROLL_FUZZY_THRESHOLD = 2;
        static final float OVERSCROLL_SCALE_FACTOR = 1.5f;

        public InternalWebViewSDK9(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private int getScrollRange() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "22040795") ? ((Integer) ipChange.ipc$dispatch("22040795", new Object[]{this})).intValue() : (int) Math.max(0.0d, Math.floor(((WebView) PullToRefreshWebView.this.mRefreshableView).getContentHeight() * ((WebView) PullToRefreshWebView.this.mRefreshableView).getScale()) - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }

        @Override // android.view.View
        protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1078893330")) {
                return ((Boolean) ipChange.ipc$dispatch("-1078893330", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z)})).booleanValue();
            }
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            b.b(PullToRefreshWebView.this, i, i3, i2, i4, getScrollRange(), 2, 1.5f, z);
            return overScrollBy;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class a implements PullToRefreshBase.OnRefreshListener<WebView> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase.OnRefreshListener
        public void onRefresh(PullToRefreshBase<WebView> pullToRefreshBase) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-371408599")) {
                ipChange.ipc$dispatch("-371408599", new Object[]{this, pullToRefreshBase});
            } else {
                pullToRefreshBase.getRefreshableView().reload();
            }
        }
    }

    public PullToRefreshWebView(Context context) {
        super(context);
        WebChromeClient webChromeClient = new WebChromeClient() { // from class: cn.damai.uikit.pulltorefresh.library.PullToRefreshWebView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-117123561")) {
                    ipChange.ipc$dispatch("-117123561", new Object[]{this, webView, Integer.valueOf(i)});
                } else if (i == 100) {
                    PullToRefreshWebView.this.onRefreshComplete();
                }
            }
        };
        this.defaultWebChromeClient = webChromeClient;
        setOnRefreshListener(defaultOnRefreshListener);
        ((WebView) this.mRefreshableView).setWebChromeClient(webChromeClient);
    }

    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-305330165") ? (PullToRefreshBase.Orientation) ipChange.ipc$dispatch("-305330165", new Object[]{this}) : PullToRefreshBase.Orientation.VERTICAL;
    }

    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    protected boolean isReadyForPullEnd() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-554422019") ? ((Boolean) ipChange.ipc$dispatch("-554422019", new Object[]{this})).booleanValue() : ((float) ((WebView) this.mRefreshableView).getScrollY()) >= ((float) Math.floor((double) (((float) ((WebView) this.mRefreshableView).getContentHeight()) * ((WebView) this.mRefreshableView).getScale()))) - ((float) ((WebView) this.mRefreshableView).getHeight());
    }

    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    protected boolean isReadyForPullStart() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-579379114") ? ((Boolean) ipChange.ipc$dispatch("-579379114", new Object[]{this})).booleanValue() : ((WebView) this.mRefreshableView).getScrollY() == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public void onPtrRestoreInstanceState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1783606130")) {
            ipChange.ipc$dispatch("1783606130", new Object[]{this, bundle});
            return;
        }
        super.onPtrRestoreInstanceState(bundle);
        ((WebView) this.mRefreshableView).restoreState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public void onPtrSaveInstanceState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1076998919")) {
            ipChange.ipc$dispatch("-1076998919", new Object[]{this, bundle});
            return;
        }
        super.onPtrSaveInstanceState(bundle);
        ((WebView) this.mRefreshableView).saveState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public WebView createRefreshableView(Context context, AttributeSet attributeSet) {
        WebView webView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1242649230")) {
            return (WebView) ipChange.ipc$dispatch("-1242649230", new Object[]{this, context, attributeSet});
        }
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
        WebChromeClient webChromeClient = new WebChromeClient() { // from class: cn.damai.uikit.pulltorefresh.library.PullToRefreshWebView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-117123561")) {
                    ipChange.ipc$dispatch("-117123561", new Object[]{this, webView, Integer.valueOf(i)});
                } else if (i == 100) {
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
        WebChromeClient webChromeClient = new WebChromeClient() { // from class: cn.damai.uikit.pulltorefresh.library.PullToRefreshWebView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-117123561")) {
                    ipChange.ipc$dispatch("-117123561", new Object[]{this, webView, Integer.valueOf(i)});
                } else if (i == 100) {
                    PullToRefreshWebView.this.onRefreshComplete();
                }
            }
        };
        this.defaultWebChromeClient = webChromeClient;
        setOnRefreshListener(defaultOnRefreshListener);
        ((WebView) this.mRefreshableView).setWebChromeClient(webChromeClient);
    }

    public PullToRefreshWebView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
        WebChromeClient webChromeClient = new WebChromeClient() { // from class: cn.damai.uikit.pulltorefresh.library.PullToRefreshWebView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-117123561")) {
                    ipChange.ipc$dispatch("-117123561", new Object[]{this, webView, Integer.valueOf(i)});
                } else if (i == 100) {
                    PullToRefreshWebView.this.onRefreshComplete();
                }
            }
        };
        this.defaultWebChromeClient = webChromeClient;
        setOnRefreshListener(defaultOnRefreshListener);
        ((WebView) this.mRefreshableView).setWebChromeClient(webChromeClient);
    }
}

package android.taobao.windvane.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.taobao.windvane.view.AbstractNaviBar;
import android.taobao.windvane.view.WebNaviBar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes12.dex */
public class WVViewController extends LinearLayout {
    protected boolean isInited;
    protected Context mContext;
    protected WVWebView mWebView;

    @SuppressLint({"NewApi"})
    public WVViewController(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isInited = false;
        this.mContext = context;
    }

    private void initView(ParamsParcelable paramsParcelable) {
        setOrientation(1);
        if (paramsParcelable == null) {
            paramsParcelable = new ParamsParcelable();
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        WVWebView wVWebView = new WVWebView(this.mContext);
        this.mWebView = wVWebView;
        relativeLayout.addView(wVWebView, new RelativeLayout.LayoutParams(-1, -1));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        relativeLayout.setLayoutParams(layoutParams);
        addView(relativeLayout);
        initWithParams(paramsParcelable);
        this.isInited = true;
    }

    public void destroy() {
        if (this.isInited) {
            removeAllViews();
            this.mWebView.destroy();
            this.mWebView = null;
        }
        this.mContext = null;
    }

    public WVWebView getWebview() {
        if (!this.isInited) {
            initView(null);
        }
        return this.mWebView;
    }

    public void init(ParamsParcelable paramsParcelable) {
        if (this.isInited) {
            return;
        }
        initView(paramsParcelable);
    }

    protected void initWithParams(ParamsParcelable paramsParcelable) {
        if (paramsParcelable.isNavBarEnabled()) {
            WebNaviBar webNaviBar = new WebNaviBar(this.mContext, this.mWebView);
            addView(webNaviBar);
            this.mWebView.getWvUIModel().setNaviBar(webNaviBar);
        }
        if (paramsParcelable.isShowLoading()) {
            this.mWebView.getWvUIModel().enableShowLoading();
        }
        if (paramsParcelable.isJsbridgeEnabled()) {
            return;
        }
        WVJsBridge.getInstance().setEnabled(false);
    }

    public void loadUrl(String str) {
        if (!this.isInited) {
            initView(null);
        }
        this.mWebView.loadUrl(str);
    }

    public void setErrorView(View view) {
        if (!this.isInited) {
            initView(null);
        }
        this.mWebView.getWvUIModel().setErrorView(view);
    }

    public void setLoadingView(View view) {
        if (!this.isInited) {
            initView(null);
        }
        this.mWebView.getWvUIModel().setLoadingView(view);
    }

    public void setNaviBar(AbstractNaviBar abstractNaviBar) {
        if (!this.isInited) {
            initView(null);
        }
        addView(abstractNaviBar);
        this.mWebView.getWvUIModel().setNaviBar(abstractNaviBar);
    }

    public WVViewController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isInited = false;
        this.mContext = context;
    }

    public void loadUrl(String str, byte[] bArr) {
        if (!this.isInited) {
            initView(null);
        }
        if (bArr != null && bArr.length != 0) {
            this.mWebView.postUrl(str, bArr);
        } else {
            this.mWebView.loadUrl(str);
        }
    }

    public WVViewController(Context context) {
        super(context);
        this.isInited = false;
        this.mContext = context;
    }
}

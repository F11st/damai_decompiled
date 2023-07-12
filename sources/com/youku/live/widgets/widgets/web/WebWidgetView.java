package com.youku.live.widgets.widgets.web;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class WebWidgetView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private WebView mWebView;

    public WebWidgetView(@NonNull Context context) {
        super(context);
    }

    private WebView getWebView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1296372468")) {
            return (WebView) ipChange.ipc$dispatch("1296372468", new Object[]{this});
        }
        if (this.mWebView == null) {
            synchronized (this) {
                if (this.mWebView == null) {
                    this.mWebView = new WebView(getContext());
                }
            }
            setInstanceConfig();
        }
        return this.mWebView;
    }

    private void setInstanceConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1364849143")) {
            ipChange.ipc$dispatch("-1364849143", new Object[]{this});
            return;
        }
        WebView webView = this.mWebView;
        if (webView == null || webView.getParent() != null) {
            return;
        }
        addView(webView, new FrameLayout.LayoutParams(-1, -1));
    }

    public void render(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-952998116")) {
            ipChange.ipc$dispatch("-952998116", new Object[]{this, str});
        } else {
            getWebView().loadUrl(str);
        }
    }

    public WebWidgetView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WebWidgetView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

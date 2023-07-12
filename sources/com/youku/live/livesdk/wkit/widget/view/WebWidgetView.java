package com.youku.live.livesdk.wkit.widget.view;

import android.content.Context;
import android.content.Intent;
import android.taobao.windvane.webview.WVWebView;
import android.util.AttributeSet;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.utils.ILaifengWebViewBinderInterface;
import com.youku.live.widgets.protocol.IDestroyable;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.activity.IActivityResultListener;
import com.youku.live.widgets.protocol.activity.IActivityResumeStateChangedListener;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class WebWidgetView extends FrameLayout implements IDestroyable, IActivityResultListener, IActivityResumeStateChangedListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private CommonJsBridge mCommonJsBridge;
    private IEngineInstance mEngineInstance;
    private WVWebView mWebView;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class CommonJsBridge {
        public Runnable mCloseAction;

        @JavascriptInterface
        public void webViewClose() throws IllegalArgumentException, IllegalStateException, IOException {
            Runnable runnable = this.mCloseAction;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public WebWidgetView(@NonNull Context context) {
        super(context);
    }

    private WebView getWebView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1605059167")) {
            return (WebView) ipChange.ipc$dispatch("-1605059167", new Object[]{this});
        }
        if (this.mWebView == null) {
            synchronized (this) {
                if (this.mWebView == null) {
                    this.mWebView = new WVWebView(getContext());
                }
            }
            setInstanceConfig();
        }
        return this.mWebView;
    }

    private void setInstanceConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1152561846")) {
            ipChange.ipc$dispatch("1152561846", new Object[]{this});
            return;
        }
        WVWebView wVWebView = this.mWebView;
        if (wVWebView != null && wVWebView.getParent() == null) {
            addView(wVWebView, new FrameLayout.LayoutParams(-1, -1));
        }
        if (wVWebView != null) {
            CommonJsBridge commonJsBridge = new CommonJsBridge();
            this.mCommonJsBridge = commonJsBridge;
            commonJsBridge.mCloseAction = new Runnable() { // from class: com.youku.live.livesdk.wkit.widget.view.WebWidgetView.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-455946185")) {
                        ipChange2.ipc$dispatch("-455946185", new Object[]{this});
                        return;
                    }
                    final IEngineInstance iEngineInstance = WebWidgetView.this.mEngineInstance;
                    if (iEngineInstance != null) {
                        iEngineInstance.runOnMainThread(new Runnable() { // from class: com.youku.live.livesdk.wkit.widget.view.WebWidgetView.1.1
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public void run() {
                                IpChange ipChange3 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange3, "1563647498")) {
                                    ipChange3.ipc$dispatch("1563647498", new Object[]{this});
                                } else {
                                    iEngineInstance.closeDialog(null);
                                }
                            }
                        });
                    }
                }
            };
            try {
                wVWebView.addJavascriptInterface(this.mCommonJsBridge, "lfJsObj");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        try {
            ((ILaifengWebViewBinderInterface) Dsl.getService(ILaifengWebViewBinderInterface.class)).bindWebView(wVWebView, null, null);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void bindEngineInstance(IEngineInstance iEngineInstance) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-871347166")) {
            ipChange.ipc$dispatch("-871347166", new Object[]{this, iEngineInstance});
        } else {
            this.mEngineInstance = iEngineInstance;
        }
    }

    @Override // com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1494973653")) {
            ipChange.ipc$dispatch("1494973653", new Object[]{this});
            return;
        }
        WVWebView wVWebView = this.mWebView;
        if (wVWebView != null) {
            wVWebView.destroy();
            this.mWebView = null;
        }
        removeAllViews();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.livesdk.wkit.widget.view.WebWidgetView.$ipChange
            java.lang.String r1 = "295620447"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L1e
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r3] = r6
            r2[r5] = r7
            java.lang.Object r7 = r0.ipc$dispatch(r1, r2)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            return r7
        L1e:
            int r0 = r7.getAction()
            if (r0 == 0) goto L34
            if (r0 == r5) goto L2c
            if (r0 == r4) goto L34
            r1 = 3
            if (r0 == r1) goto L2c
            goto L3b
        L2c:
            android.view.ViewParent r0 = r6.getParent()
            r0.requestDisallowInterceptTouchEvent(r3)
            goto L3b
        L34:
            android.view.ViewParent r0 = r6.getParent()
            r0.requestDisallowInterceptTouchEvent(r5)
        L3b:
            boolean r7 = super.dispatchTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.livesdk.wkit.widget.view.WebWidgetView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResumeStateChangedListener
    public void onActivityPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-582502521")) {
            ipChange.ipc$dispatch("-582502521", new Object[]{this});
        } else {
            getWebView().onPause();
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResultListener
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "985485")) {
            ipChange.ipc$dispatch("985485", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        WVWebView wVWebView = this.mWebView;
        if (wVWebView != null) {
            wVWebView.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResumeStateChangedListener
    public void onActivityResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "770077536")) {
            ipChange.ipc$dispatch("770077536", new Object[]{this});
        } else {
            getWebView().onResume();
        }
    }

    public void render(String str) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-7301681")) {
            ipChange.ipc$dispatch("-7301681", new Object[]{this, str});
            return;
        }
        try {
            z = ((ILaifengWebViewBinderInterface) Dsl.getService(ILaifengWebViewBinderInterface.class)).loadWebView(getWebView(), str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (z) {
            return;
        }
        getWebView().loadUrl(str);
    }

    public WebWidgetView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WebWidgetView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

package com.taobao.weex.ui.view;

import android.view.View;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IWebView {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface OnErrorListener {
        void onError(String str, Object obj);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface OnMessageListener {
        void onMessage(Map<String, Object> map);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface OnPageListener {
        void onPageFinish(String str, boolean z, boolean z2);

        void onPageStart(String str);

        void onReceivedTitle(String str);
    }

    void destroy();

    View getView();

    void goBack();

    void goForward();

    void loadDataWithBaseURL(String str);

    void loadUrl(String str);

    void postMessage(Object obj);

    void reload();

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnMessageListener(OnMessageListener onMessageListener);

    void setOnPageListener(OnPageListener onPageListener);

    void setShowLoading(boolean z);
}

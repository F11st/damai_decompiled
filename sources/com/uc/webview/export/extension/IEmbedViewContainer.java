package com.uc.webview.export.extension;

import android.view.Surface;
import android.webkit.ValueCallback;
import com.uc.webview.export.annotations.Interface;

/* compiled from: Taobao */
@Interface
/* loaded from: classes11.dex */
public interface IEmbedViewContainer {

    /* compiled from: Taobao */
    @Interface
    /* loaded from: classes11.dex */
    public interface OnParamChangedListener {
        void onParamChanged(String[] strArr, String[] strArr2);
    }

    /* compiled from: Taobao */
    @Interface
    /* loaded from: classes11.dex */
    public interface OnStateChangedListener {
        void onAttachedToWebView();

        void onDestroy();

        void onDetachedFromWebView();
    }

    /* compiled from: Taobao */
    @Interface
    /* loaded from: classes11.dex */
    public interface OnVisibilityChangedListener {
        void onVisibilityChanged(int i);
    }

    /* compiled from: Taobao */
    @Interface
    /* loaded from: classes11.dex */
    public interface SurfaceListener {
        void onSurfaceAvailable(Surface surface, int i, int i2, ValueCallback<Integer> valueCallback);

        boolean onSurfaceDestroyed(Surface surface);

        void onSurfaceSizeChanged(Surface surface, int i, int i2);
    }

    void changeViewSize(int i, int i2);

    void notifyEnterFullScreen();

    void notifyExitFullScreen();

    void sendViewData(String str);

    void setOnParamChangedListener(OnParamChangedListener onParamChangedListener);

    void setOnStateChangedListener(OnStateChangedListener onStateChangedListener);

    void setOnVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener);

    void setPosterUrl(String str);

    void setSurfaceListener(SurfaceListener surfaceListener);
}

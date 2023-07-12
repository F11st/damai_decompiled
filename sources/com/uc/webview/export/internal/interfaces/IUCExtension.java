package com.uc.webview.export.internal.interfaces;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.webkit.ValueCallback;
import com.uc.webview.export.annotations.Interface;
import com.uc.webview.export.extension.UCClient;
import com.uc.webview.export.extension.UCExtension;
import com.uc.webview.export.extension.UCSettings;

/* compiled from: Taobao */
@Interface
/* loaded from: classes11.dex */
public interface IUCExtension extends InvokeObject {
    void getCoreStatus(int i, ValueCallback<Object> valueCallback);

    boolean getCurrentPageSnapshot(Rect rect, Rect rect2, Bitmap bitmap, boolean z, int i);

    UCSettings getUCSettings();

    void setClient(UCClient uCClient);

    void setInjectJSProvider(UCExtension.InjectJSProvider injectJSProvider, int i);

    void setIsPreRender(boolean z);

    void setSoftKeyboardListener(UCExtension.OnSoftKeyboardListener onSoftKeyboardListener);

    @Deprecated
    void setTextSelectionClient(UCExtension.TextSelectionClient textSelectionClient);
}

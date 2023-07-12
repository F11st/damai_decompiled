package com.uc.webview.export.internal.interfaces;

import android.webkit.ValueCallback;
import com.uc.webview.export.annotations.Interface;
import java.util.Set;

/* compiled from: Taobao */
@Interface
/* loaded from: classes11.dex */
public interface IGeolocationPermissions {
    void allow(String str);

    void clear(String str);

    void clearAll();

    void getAllowed(String str, ValueCallback<Boolean> valueCallback);

    void getOrigins(ValueCallback<Set<String>> valueCallback);
}

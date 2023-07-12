package com.uc.webview.export.internal.android;

import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import com.uc.webview.export.internal.interfaces.IGeolocationPermissions;
import java.util.Set;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.android.b */
/* loaded from: classes11.dex */
public final class C7217b implements IGeolocationPermissions {
    private GeolocationPermissions a = GeolocationPermissions.getInstance();

    @Override // com.uc.webview.export.internal.interfaces.IGeolocationPermissions
    public final void allow(String str) {
        this.a.allow(str);
    }

    @Override // com.uc.webview.export.internal.interfaces.IGeolocationPermissions
    public final void clear(String str) {
        this.a.clear(str);
    }

    @Override // com.uc.webview.export.internal.interfaces.IGeolocationPermissions
    public final void clearAll() {
        this.a.clearAll();
    }

    @Override // com.uc.webview.export.internal.interfaces.IGeolocationPermissions
    public final void getAllowed(String str, ValueCallback<Boolean> valueCallback) {
        this.a.getAllowed(str, valueCallback);
    }

    @Override // com.uc.webview.export.internal.interfaces.IGeolocationPermissions
    public final void getOrigins(ValueCallback<Set<String>> valueCallback) {
        this.a.getOrigins(valueCallback);
    }
}

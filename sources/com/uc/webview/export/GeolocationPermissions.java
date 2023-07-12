package com.uc.webview.export;

import android.webkit.ValueCallback;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IGeolocationPermissions;
import java.util.HashMap;
import java.util.Set;
import tb.jn1;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public class GeolocationPermissions implements IGeolocationPermissions {
    private static HashMap<Integer, GeolocationPermissions> b;
    private IGeolocationPermissions a;

    /* compiled from: Taobao */
    @Api
    /* loaded from: classes11.dex */
    public interface Callback {
        void invoke(String str, boolean z, boolean z2);
    }

    private GeolocationPermissions(IGeolocationPermissions iGeolocationPermissions) {
        this.a = iGeolocationPermissions;
    }

    private static synchronized GeolocationPermissions a(int i) throws RuntimeException {
        GeolocationPermissions geolocationPermissions;
        synchronized (GeolocationPermissions.class) {
            if (b == null) {
                b = new HashMap<>();
            }
            geolocationPermissions = b.get(Integer.valueOf(i));
            if (geolocationPermissions == null) {
                geolocationPermissions = new GeolocationPermissions(SDKFactory.d(i));
                b.put(Integer.valueOf(i), geolocationPermissions);
            }
        }
        return geolocationPermissions;
    }

    public static GeolocationPermissions getInstance() throws RuntimeException {
        return a(SDKFactory.e());
    }

    @Override // com.uc.webview.export.internal.interfaces.IGeolocationPermissions
    public void allow(String str) {
        this.a.allow(str);
    }

    @Override // com.uc.webview.export.internal.interfaces.IGeolocationPermissions
    public void clear(String str) {
        this.a.clear(str);
    }

    @Override // com.uc.webview.export.internal.interfaces.IGeolocationPermissions
    public void clearAll() {
        this.a.clearAll();
    }

    @Override // com.uc.webview.export.internal.interfaces.IGeolocationPermissions
    public void getAllowed(String str, ValueCallback<Boolean> valueCallback) {
        this.a.getAllowed(str, valueCallback);
    }

    @Override // com.uc.webview.export.internal.interfaces.IGeolocationPermissions
    public void getOrigins(ValueCallback<Set<String>> valueCallback) {
        this.a.getOrigins(valueCallback);
    }

    public String toString() {
        return "GeolocationPermissions@" + hashCode() + jn1.ARRAY_START_STR + this.a + jn1.ARRAY_END_STR;
    }

    public static GeolocationPermissions getInstance(WebView webView) throws RuntimeException {
        return a(webView.getCurrentViewCoreType());
    }
}

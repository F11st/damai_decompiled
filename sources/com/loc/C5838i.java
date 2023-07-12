package com.loc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.district.DistrictSearchQuery;
import com.taobao.weex.common.Constants;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.loc.i */
/* loaded from: classes10.dex */
public final class C5838i {
    private Context b;
    private WebView d;
    C5839a h;
    Object a = new Object();
    private AMapLocationClient c = null;
    private String e = "AMap.Geolocation.cbk";
    AMapLocationClientOption f = null;
    private volatile boolean g = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.loc.i$a */
    /* loaded from: classes10.dex */
    public class C5839a implements AMapLocationListener {
        C5839a() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            if (C5838i.this.g) {
                C5838i.this.i(C5838i.g(aMapLocation));
            }
        }
    }

    public C5838i(Context context, WebView webView) {
        this.d = null;
        this.h = null;
        this.b = context.getApplicationContext();
        this.d = webView;
        this.h = new C5839a();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0053 A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:21:0x004c, B:23:0x0053, B:24:0x0057, B:26:0x0060, B:30:0x0066, B:32:0x006b, B:25:0x005b), top: B:37:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005b A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:21:0x004c, B:23:0x0053, B:24:0x0057, B:26:0x0060, B:30:0x0066, B:32:0x006b, B:25:0x005b), top: B:37:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006b A[Catch: all -> 0x0073, TRY_LEAVE, TryCatch #0 {all -> 0x0073, blocks: (B:21:0x004c, B:23:0x0053, B:24:0x0057, B:26:0x0060, B:30:0x0066, B:32:0x006b, B:25:0x005b), top: B:37:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(java.lang.String r10) {
        /*
            r9 = this;
            com.amap.api.location.AMapLocationClientOption r0 = r9.f
            if (r0 != 0) goto Lb
            com.amap.api.location.AMapLocationClientOption r0 = new com.amap.api.location.AMapLocationClientOption
            r0.<init>()
            r9.f = r0
        Lb:
            r0 = 5
            r1 = 30000(0x7530, double:1.4822E-319)
            r3 = 1
            r4 = 0
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4a
            r5.<init>(r10)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r10 = "to"
            long r1 = r5.optLong(r10, r1)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r10 = "useGPS"
            int r10 = r5.optInt(r10, r3)     // Catch: java.lang.Throwable -> L4a
            if (r10 != r3) goto L25
            r10 = 1
            goto L26
        L25:
            r10 = 0
        L26:
            java.lang.String r6 = "watch"
            int r6 = r5.optInt(r6, r4)     // Catch: java.lang.Throwable -> L4b
            if (r6 != r3) goto L30
            r6 = 1
            goto L31
        L30:
            r6 = 0
        L31:
            java.lang.String r7 = "interval"
            int r0 = r5.optInt(r7, r0)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r7 = "callback"
            r8 = 0
            java.lang.String r5 = r5.optString(r7, r8)     // Catch: java.lang.Throwable -> L4c
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L4c
            if (r7 != 0) goto L47
        L44:
            r9.e = r5     // Catch: java.lang.Throwable -> L4c
            goto L4c
        L47:
            java.lang.String r5 = "AMap.Geolocation.cbk"
            goto L44
        L4a:
            r10 = 0
        L4b:
            r6 = 0
        L4c:
            com.amap.api.location.AMapLocationClientOption r5 = r9.f     // Catch: java.lang.Throwable -> L73
            r5.setHttpTimeOut(r1)     // Catch: java.lang.Throwable -> L73
            if (r10 == 0) goto L5b
            com.amap.api.location.AMapLocationClientOption r10 = r9.f     // Catch: java.lang.Throwable -> L73
            com.amap.api.location.AMapLocationClientOption$AMapLocationMode r1 = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Hight_Accuracy     // Catch: java.lang.Throwable -> L73
        L57:
            r10.setLocationMode(r1)     // Catch: java.lang.Throwable -> L73
            goto L60
        L5b:
            com.amap.api.location.AMapLocationClientOption r10 = r9.f     // Catch: java.lang.Throwable -> L73
            com.amap.api.location.AMapLocationClientOption$AMapLocationMode r1 = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Battery_Saving     // Catch: java.lang.Throwable -> L73
            goto L57
        L60:
            com.amap.api.location.AMapLocationClientOption r10 = r9.f     // Catch: java.lang.Throwable -> L73
            if (r6 != 0) goto L65
            goto L66
        L65:
            r3 = 0
        L66:
            r10.setOnceLocation(r3)     // Catch: java.lang.Throwable -> L73
            if (r6 == 0) goto L73
            com.amap.api.location.AMapLocationClientOption r10 = r9.f     // Catch: java.lang.Throwable -> L73
            int r0 = r0 * 1000
            long r0 = (long) r0     // Catch: java.lang.Throwable -> L73
            r10.setInterval(r0)     // Catch: java.lang.Throwable -> L73
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.C5838i.e(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(AMapLocation aMapLocation) {
        String locationDetail;
        JSONObject jSONObject = new JSONObject();
        String str = MyLocationStyle.ERROR_INFO;
        if (aMapLocation == null) {
            jSONObject.put("errorCode", -1);
            locationDetail = "unknownError";
        } else if (aMapLocation.getErrorCode() == 0) {
            jSONObject.put("errorCode", 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(Constants.Name.X, aMapLocation.getLongitude());
            jSONObject2.put(Constants.Name.Y, aMapLocation.getLatitude());
            jSONObject2.put("precision", aMapLocation.getAccuracy());
            jSONObject2.put("type", aMapLocation.getLocationType());
            jSONObject2.put(DistrictSearchQuery.KEYWORDS_COUNTRY, aMapLocation.getCountry());
            jSONObject2.put(DistrictSearchQuery.KEYWORDS_PROVINCE, aMapLocation.getProvince());
            jSONObject2.put("city", aMapLocation.getCity());
            jSONObject2.put("cityCode", aMapLocation.getCityCode());
            jSONObject2.put(DistrictSearchQuery.KEYWORDS_DISTRICT, aMapLocation.getDistrict());
            jSONObject2.put("adCode", aMapLocation.getAdCode());
            jSONObject2.put("street", aMapLocation.getStreet());
            jSONObject2.put("streetNum", aMapLocation.getStreetNum());
            jSONObject2.put("floor", aMapLocation.getFloor());
            jSONObject2.put(ILocatable.ADDRESS, aMapLocation.getAddress());
            jSONObject.put("result", jSONObject2);
            return jSONObject.toString();
        } else {
            jSONObject.put("errorCode", aMapLocation.getErrorCode());
            jSONObject.put(MyLocationStyle.ERROR_INFO, aMapLocation.getErrorInfo());
            str = "locationDetail";
            locationDetail = aMapLocation.getLocationDetail();
        }
        jSONObject.put(str, locationDetail);
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void i(final String str) {
        try {
            WebView webView = this.d;
            if (webView != null) {
                if (Build.VERSION.SDK_INT < 19) {
                    webView.post(new Runnable() { // from class: com.loc.i.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            WebView webView2 = C5838i.this.d;
                            webView2.loadUrl("javascript:" + C5838i.this.e + "('" + str + "')");
                        }
                    });
                    return;
                }
                webView.evaluateJavascript("javascript:" + this.e + "('" + str + "')", new ValueCallback<String>() { // from class: com.loc.i.1
                    @Override // android.webkit.ValueCallback
                    public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                    }
                });
            }
        } catch (Throwable th) {
            j1.h(th, "H5LocationClient", "callbackJs()");
        }
    }

    public final void c() {
        if (this.d == null || this.b == null || Build.VERSION.SDK_INT < 17 || this.g) {
            return;
        }
        try {
            this.d.getSettings().setJavaScriptEnabled(true);
            this.d.addJavascriptInterface(this, "AMapAndroidLoc");
            if (!TextUtils.isEmpty(this.d.getUrl())) {
                this.d.reload();
            }
            if (this.c == null) {
                AMapLocationClient aMapLocationClient = new AMapLocationClient(this.b);
                this.c = aMapLocationClient;
                aMapLocationClient.setLocationListener(this.h);
            }
            this.g = true;
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public final void getLocation(String str) {
        synchronized (this.a) {
            if (this.g) {
                e(str);
                AMapLocationClient aMapLocationClient = this.c;
                if (aMapLocationClient != null) {
                    aMapLocationClient.setLocationOption(this.f);
                    this.c.stopLocation();
                    this.c.startLocation();
                }
            }
        }
    }

    public final void h() {
        synchronized (this.a) {
            this.g = false;
            AMapLocationClient aMapLocationClient = this.c;
            if (aMapLocationClient != null) {
                aMapLocationClient.unRegisterLocationListener(this.h);
                this.c.stopLocation();
                this.c.onDestroy();
                this.c = null;
            }
            this.f = null;
        }
    }

    @JavascriptInterface
    public final void stopLocation() {
        AMapLocationClient aMapLocationClient;
        if (this.g && (aMapLocationClient = this.c) != null) {
            aMapLocationClient.stopLocation();
        }
    }
}

package com.amap.api.location;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.loc.C5812d;
import com.loc.C5861o;
import com.loc.C5879t;
import com.loc.bg;
import com.loc.j1;
import com.loc.l1;
import com.loc.s1;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AMapLocationClient {
    Context a;
    C5812d b;

    public AMapLocationClient(Context context) throws Exception {
        a(context);
        try {
            if (context == null) {
                throw new IllegalArgumentException("Context参数不能为null");
            }
            this.a = context.getApplicationContext();
            this.b = new C5812d(context, null, null);
        } catch (Throwable th) {
            j1.h(th, "AMClt", "ne1");
        }
    }

    public AMapLocationClient(Context context, Intent intent) throws Exception {
        a(context);
        try {
            if (context == null) {
                throw new IllegalArgumentException("Context参数不能为null");
            }
            this.a = context.getApplicationContext();
            this.b = new C5812d(this.a, intent, null);
        } catch (Throwable th) {
            j1.h(th, "AMClt", "ne2");
        }
    }

    public AMapLocationClient(Looper looper, Context context) throws Exception {
        a(context);
        try {
            if (context == null) {
                throw new IllegalArgumentException("Context参数不能为null");
            }
            this.a = context.getApplicationContext();
            this.b = new C5812d(this.a, null, looper);
        } catch (Throwable th) {
            j1.h(th, "AMClt", "ne3");
        }
    }

    private static void a(Context context) throws Exception {
        s1 a = C5879t.a(context, j1.q());
        if (a.a == C5879t.EnumC5882c.SuccessCode) {
            return;
        }
        Log.e("AMapLocationClient", a.b);
        throw new Exception(a.b);
    }

    public static String getDeviceId(Context context) {
        return C5861o.i0(context);
    }

    public static void setApiKey(String str) {
        try {
            AMapLocationClientOption.a = str;
        } catch (Throwable th) {
            j1.h(th, "AMClt", "sKey");
        }
    }

    public static void setHost(String str) {
        if (TextUtils.isEmpty(str)) {
            bg.a = -1;
            str = "";
        } else {
            bg.a = 1;
        }
        bg.b = str;
    }

    public static void updatePrivacyAgree(Context context, boolean z) {
        C5879t.i(context, z, j1.q());
    }

    public static void updatePrivacyShow(Context context, boolean z, boolean z2) {
        C5879t.j(context, z, z2, j1.q());
    }

    public void disableBackgroundLocation(boolean z) {
        try {
            C5812d c5812d = this.b;
            if (c5812d != null) {
                c5812d.B(z);
            }
        } catch (Throwable th) {
            j1.h(th, "AMClt", "dBackL");
        }
    }

    public void enableBackgroundLocation(int i, Notification notification) {
        try {
            C5812d c5812d = this.b;
            if (c5812d != null) {
                c5812d.e(i, notification);
            }
        } catch (Throwable th) {
            j1.h(th, "AMClt", "eBackL");
        }
    }

    public AMapLocation getLastKnownLocation() {
        try {
            C5812d c5812d = this.b;
            if (c5812d != null) {
                return c5812d.c0();
            }
            return null;
        } catch (Throwable th) {
            j1.h(th, "AMClt", "gLastL");
            return null;
        }
    }

    public String getVersion() {
        return "6.1.0";
    }

    public boolean isStarted() {
        try {
            C5812d c5812d = this.b;
            if (c5812d != null) {
                return c5812d.C();
            }
            return false;
        } catch (Throwable th) {
            j1.h(th, "AMClt", "isS");
            return false;
        }
    }

    public void onDestroy() {
        try {
            C5812d c5812d = this.b;
            if (c5812d != null) {
                c5812d.W();
            }
        } catch (Throwable th) {
            j1.h(th, "AMClt", "onDy");
        }
    }

    public void setLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            if (aMapLocationListener == null) {
                throw new IllegalArgumentException("listener参数不能为null");
            }
            C5812d c5812d = this.b;
            if (c5812d != null) {
                c5812d.r(aMapLocationListener);
            }
        } catch (Throwable th) {
            j1.h(th, "AMClt", "sLocL");
        }
    }

    public void setLocationOption(AMapLocationClientOption aMapLocationClientOption) {
        try {
            if (aMapLocationClientOption == null) {
                throw new IllegalArgumentException("LocationManagerOption参数不能为null");
            }
            C5812d c5812d = this.b;
            if (c5812d != null) {
                c5812d.q(aMapLocationClientOption);
            }
            if (aMapLocationClientOption.b) {
                aMapLocationClientOption.b = false;
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(aMapLocationClientOption.c)) {
                    jSONObject.put("amap_loc_scenes_type", aMapLocationClientOption.c);
                }
                l1.n(this.a, "O019", jSONObject);
            }
        } catch (Throwable th) {
            j1.h(th, "AMClt", "sLocnO");
        }
    }

    public void startAssistantLocation(WebView webView) {
        try {
            C5812d c5812d = this.b;
            if (c5812d != null) {
                c5812d.m(webView);
            }
        } catch (Throwable th) {
            j1.h(th, "AMClt", "sttAssL1");
        }
    }

    public void startLocation() {
        try {
            C5812d c5812d = this.b;
            if (c5812d != null) {
                c5812d.G();
            }
        } catch (Throwable th) {
            j1.h(th, "AMClt", "stl");
        }
    }

    public void stopAssistantLocation() {
        try {
            C5812d c5812d = this.b;
            if (c5812d != null) {
                c5812d.f0();
            }
        } catch (Throwable th) {
            j1.h(th, "AMClt", "stAssL");
        }
    }

    public void stopLocation() {
        try {
            C5812d c5812d = this.b;
            if (c5812d != null) {
                c5812d.R();
            }
        } catch (Throwable th) {
            j1.h(th, "AMClt", "stl");
        }
    }

    public void unRegisterLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            C5812d c5812d = this.b;
            if (c5812d != null) {
                c5812d.K(aMapLocationListener);
            }
        } catch (Throwable th) {
            j1.h(th, "AMClt", "unRL");
        }
    }
}

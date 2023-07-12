package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.mapcore.util.gd;
import com.amap.api.mapcore.util.l;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class k extends Thread {
    WeakReference<IAMapDelegate> a;
    private Context b;

    public k(Context context, IAMapDelegate iAMapDelegate) {
        this.a = null;
        this.b = context;
        this.a = new WeakReference<>(iAMapDelegate);
    }

    @Override // java.lang.Thread
    public void interrupt() {
        super.interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        WeakReference<IAMapDelegate> weakReference;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject optJSONObject;
        JSONObject jSONObject3;
        JSONObject optJSONObject2;
        JSONObject jSONObject4;
        JSONObject optJSONObject3;
        JSONObject jSONObject5;
        JSONObject optJSONObject4;
        WeakReference<IAMapDelegate> weakReference2;
        gm e;
        JSONObject jSONObject6;
        JSONObject optJSONObject5;
        WeakReference<IAMapDelegate> weakReference3;
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                gi.a().a(this.b);
                StringBuilder sb = new StringBuilder();
                sb.append("14S");
                sb.append(";");
                sb.append("11K");
                sb.append(";");
                sb.append("001");
                sb.append(";");
                sb.append("14M");
                sb.append(";");
                sb.append("14L");
                sb.append(";");
                sb.append("16V");
                sb.append(";");
                sb.append("14Z");
                sb.append(";");
                sb.append("154");
                sb.append(";");
                sb.append("156");
                sb.append(";");
                sb.append("15C");
                sb.append(";");
                sb.append("16G");
                try {
                    WeakReference<IAMapDelegate> weakReference4 = this.a;
                    if (weakReference4 != null && weakReference4.get() != null) {
                        IAMapDelegate iAMapDelegate = this.a.get();
                        if (iAMapDelegate.getAMapExtraInterfaceManager() != null) {
                            sb.append(iAMapDelegate.getAMapExtraInterfaceManager().b());
                        }
                    }
                } catch (Throwable unused) {
                }
                gd.a a = gd.a(this.b, eq.e(), sb.toString(), (Map<String, String>) null);
                boolean z = true;
                if (gd.a != 1 && a != null && (weakReference3 = this.a) != null && weakReference3.get() != null) {
                    Message obtainMessage = this.a.get().getMainHandler().obtainMessage();
                    obtainMessage.what = 2;
                    String str = a.a;
                    if (str != null) {
                        obtainMessage.obj = str;
                    }
                    this.a.get().getMainHandler().sendMessage(obtainMessage);
                }
                if (a != null && (jSONObject6 = a.w) != null && (optJSONObject5 = jSONObject6.optJSONObject("154")) != null && gd.a(optJSONObject5.getString("able"), true)) {
                    String optString = optJSONObject5.optString("mc");
                    String optString2 = optJSONObject5.optString("si");
                    if (!TextUtils.isEmpty(optString)) {
                        eg.a(this.b, "approval_number", "mc", (Object) optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        eg.a(this.b, "approval_number", "si", (Object) optString2);
                    }
                }
                if (a != null && a.x != null && (e = eq.e()) != null) {
                    e.a(a.x.a);
                }
                if (a != null) {
                    a(a);
                }
                if (a != null && (jSONObject5 = a.w) != null && (optJSONObject4 = jSONObject5.optJSONObject("14M")) != null && optJSONObject4.has("able") && gd.a(optJSONObject4.getString("able"), true)) {
                    if (System.currentTimeMillis() - eg.a(this.b, "Map3DCache", "time", (Long) 0L).longValue() > (optJSONObject4.has("time") ? Math.max(60, optJSONObject4.getInt("time")) : 2592000) * 1000 && (weakReference2 = this.a) != null && weakReference2.get() != null) {
                        this.a.get().clearTileCache();
                    }
                }
                if (a != null && (jSONObject4 = a.w) != null && (optJSONObject3 = jSONObject4.optJSONObject("14L")) != null && optJSONObject3.has("able")) {
                    boolean a2 = gd.a(optJSONObject3.getString("able"), false);
                    WeakReference<IAMapDelegate> weakReference5 = this.a;
                    if (weakReference5 != null && weakReference5.get() != null) {
                        IAMapDelegate iAMapDelegate2 = this.a.get();
                        if (a2) {
                            z = false;
                        }
                        iAMapDelegate2.setHideLogoEnble(z);
                    }
                }
                if (a != null && (jSONObject3 = a.w) != null && (optJSONObject2 = jSONObject3.optJSONObject("156")) != null) {
                    ea.a(gd.a(optJSONObject2.optString("able"), false));
                }
                if (a != null && a.w != null) {
                    a(this.b, eq.e(), a);
                }
                if (a != null && (jSONObject2 = a.w) != null && (optJSONObject = jSONObject2.optJSONObject("15C")) != null) {
                    final boolean a3 = gd.a(optJSONObject.optString("able"), false);
                    final String optString3 = optJSONObject.optString("logo_day_url");
                    final String optString4 = optJSONObject.optString("logo_day_md5");
                    final String optString5 = optJSONObject.optString("logo_night_url");
                    final String optString6 = optJSONObject.optString("logo_night_md5");
                    final String optString7 = optJSONObject.optString("logo_day_ipv6_url");
                    final String optString8 = optJSONObject.optString("logo_night_ipv6_url");
                    ep.a().a(new Runnable() { // from class: com.amap.api.mapcore.util.k.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString3)) {
                                boolean z2 = a3;
                                String str2 = AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME;
                                String str3 = optString3;
                                String str4 = optString4;
                                String str5 = optString7;
                                if (z2) {
                                    l.d dVar = new l.d(str3, str4, str5, str2);
                                    dVar.a("amap_web_logo", "md5_day");
                                    new l(k.this.b, dVar, eq.e()).a();
                                }
                                WeakReference<IAMapDelegate> weakReference6 = k.this.a;
                                if (weakReference6 != null && weakReference6.get() != null) {
                                    k.this.a.get().changeLogoIconStyle(str2, z2, 0);
                                }
                            }
                            if (TextUtils.isEmpty(optString6) || TextUtils.isEmpty(optString5)) {
                                return;
                            }
                            boolean z3 = a3;
                            String str6 = AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME;
                            String str7 = optString5;
                            String str8 = optString6;
                            String str9 = optString8;
                            if (z3) {
                                l.d dVar2 = new l.d(str7, str8, str9, str6);
                                dVar2.a("amap_web_logo", "md5_night");
                                new l(k.this.b, dVar2, eq.e()).a();
                            }
                            WeakReference<IAMapDelegate> weakReference7 = k.this.a;
                            if (weakReference7 == null || weakReference7.get() == null) {
                                return;
                            }
                            k.this.a.get().changeLogoIconStyle(str6, z3, 1);
                        }
                    });
                }
                if (a != null) {
                    try {
                        if (a.w != null && (weakReference = this.a) != null && weakReference.get() != null) {
                            IAMapDelegate iAMapDelegate3 = this.a.get();
                            if (iAMapDelegate3.getAMapExtraInterfaceManager() != null) {
                                iAMapDelegate3.getAMapExtraInterfaceManager().a(a.w);
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                }
                if (a != null && (jSONObject = a.w) != null) {
                    a(jSONObject);
                }
                hd.a(this.b, eq.e());
                interrupt();
                WeakReference<IAMapDelegate> weakReference6 = this.a;
                if (weakReference6 == null || weakReference6.get() == null) {
                    return;
                }
                this.a.get().setRunLowFrame(false);
            }
        } catch (Throwable th) {
            interrupt();
            hd.c(th, "AMapDelegateImpGLSurfaceView", "mVerfy");
            th.printStackTrace();
        }
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("16G");
            boolean a = gd.a(optJSONObject.optString("able", ""), false);
            boolean a2 = gd.a(optJSONObject.optString("removeCache", ""), false);
            boolean a3 = gd.a(optJSONObject.optString("uploadInfo", ""), false);
            eh.a(a);
            eh.b(a2);
            eh.c(a3);
        } catch (Throwable unused) {
        }
    }

    private void a(Context context, gm gmVar, gd.a aVar) {
        JSONObject jSONObject;
        if (aVar != null && (jSONObject = aVar.w) != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("16V");
                boolean a = gd.a(optJSONObject.optString(AppIconSetting.DEFAULT_LARGE_ICON, ""), false);
                String optString = optJSONObject.optString("dis", "");
                boolean a2 = gd.a(optJSONObject.optString("able", ""), false);
                boolean a3 = gd.a(optJSONObject.optString("isFilter", ""), true);
                if (a && !gn.f(optString)) {
                    return;
                }
                hm.a(gmVar).a(context, a2, a3);
            } catch (Throwable unused) {
            }
        }
    }

    private void a(gd.a aVar) {
        try {
            gd.a.C0215a c0215a = aVar.x;
            if (c0215a != null) {
                en.a(this.b, "maploc", "ue", Boolean.valueOf(c0215a.a));
                JSONObject jSONObject = c0215a.c;
                int optInt = jSONObject.optInt("fn", 1000);
                int optInt2 = jSONObject.optInt("mpn", 0);
                int i = 30;
                if (optInt2 > 500) {
                    optInt2 = 500;
                }
                if (optInt2 >= 30) {
                    i = optInt2;
                }
                ir.a(optInt, gd.a(jSONObject.optString("igu"), false));
                en.a(this.b, "maploc", "opn", Integer.valueOf(i));
            }
        } catch (Throwable th) {
            hd.c(th, "AuthUtil", "loadConfigDataUploadException");
        }
    }
}

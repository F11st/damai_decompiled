package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.aliweex.adapter.module.audio.IWXAudio;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.taobao.weex.common.WXConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class b {
    private static volatile b a;

    /* renamed from: a  reason: collision with other field name */
    private Context f60a;

    /* renamed from: a  reason: collision with other field name */
    private a f61a;

    /* renamed from: a  reason: collision with other field name */
    String f62a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, a> f63a;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a  reason: collision with other field name */
        private Context f64a;

        /* renamed from: a  reason: collision with other field name */
        public String f65a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        /* renamed from: a  reason: collision with other field name */
        public boolean f66a = true;

        /* renamed from: b  reason: collision with other field name */
        public boolean f67b = false;
        public int a = 1;

        public a(Context context) {
            this.f64a = context;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f65a = jSONObject.getString(ALBiometricsKeys.KEY_APP_ID);
                aVar.b = jSONObject.getString("appToken");
                aVar.c = jSONObject.getString("regId");
                aVar.d = jSONObject.getString("regSec");
                aVar.f = jSONObject.getString(WXConfig.devId);
                aVar.e = jSONObject.getString("vName");
                aVar.f66a = jSONObject.getBoolean("valid");
                aVar.f67b = jSONObject.getBoolean(IWXAudio.KEY_PAUSED);
                aVar.a = jSONObject.getInt("envType");
                aVar.g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        private String a() {
            Context context = this.f64a;
            return com.xiaomi.push.h.m941a(context, context.getPackageName());
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ALBiometricsKeys.KEY_APP_ID, aVar.f65a);
                jSONObject.put("appToken", aVar.b);
                jSONObject.put("regId", aVar.c);
                jSONObject.put("regSec", aVar.d);
                jSONObject.put(WXConfig.devId, aVar.f);
                jSONObject.put("vName", aVar.e);
                jSONObject.put("valid", aVar.f66a);
                jSONObject.put(IWXAudio.KEY_PAUSED, aVar.f67b);
                jSONObject.put("envType", aVar.a);
                jSONObject.put("regResource", aVar.g);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m642a() {
            b.a(this.f64a).edit().clear().commit();
            this.f65a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.f = null;
            this.e = null;
            this.f66a = false;
            this.f67b = false;
            this.h = null;
            this.a = 1;
        }

        public void a(int i) {
            this.a = i;
        }

        public void a(String str, String str2) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.j.j(this.f64a);
            this.e = a();
            this.f66a = true;
        }

        public void a(String str, String str2, String str3) {
            this.f65a = str;
            this.b = str2;
            this.g = str3;
            SharedPreferences.Editor edit = b.a(this.f64a).edit();
            edit.putString(ALBiometricsKeys.KEY_APP_ID, this.f65a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void a(boolean z) {
            this.f67b = z;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m643a() {
            return m644a(this.f65a, this.b);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m644a(String str, String str2) {
            boolean equals = TextUtils.equals(this.f65a, str);
            boolean equals2 = TextUtils.equals(this.b, str2);
            boolean z = !TextUtils.isEmpty(this.c);
            boolean z2 = !TextUtils.isEmpty(this.d);
            boolean z3 = TextUtils.equals(this.f, com.xiaomi.push.j.j(this.f64a)) || TextUtils.equals(this.f, com.xiaomi.push.j.i(this.f64a));
            boolean z4 = equals && equals2 && z && z2 && z3;
            if (!z4) {
                com.xiaomi.channel.commonutils.logger.b.e(String.format("register invalid, aid=%s;atn=%s;rid=%s;rse=%s;did=%s", Boolean.valueOf(equals), Boolean.valueOf(equals2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)));
            }
            return z4;
        }

        public void b() {
            this.f66a = false;
            b.a(this.f64a).edit().putBoolean("valid", this.f66a).commit();
        }

        public void b(String str, String str2, String str3) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.j.j(this.f64a);
            this.e = a();
            this.f66a = true;
            this.h = str3;
            SharedPreferences.Editor edit = b.a(this.f64a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString(WXConfig.devId, this.f);
            edit.putString("vName", a());
            edit.putBoolean("valid", true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f65a = str;
            this.b = str2;
            this.g = str3;
        }
    }

    private b(Context context) {
        this.f60a = context;
        c();
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static b m629a(Context context) {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b(context);
                }
            }
        }
        return a;
    }

    private void c() {
        this.f61a = new a(this.f60a);
        this.f63a = new HashMap();
        SharedPreferences a2 = a(this.f60a);
        this.f61a.f65a = a2.getString(ALBiometricsKeys.KEY_APP_ID, null);
        this.f61a.b = a2.getString("appToken", null);
        this.f61a.c = a2.getString("regId", null);
        this.f61a.d = a2.getString("regSec", null);
        this.f61a.f = a2.getString(WXConfig.devId, null);
        if (!TextUtils.isEmpty(this.f61a.f) && com.xiaomi.push.j.a(this.f61a.f)) {
            this.f61a.f = com.xiaomi.push.j.j(this.f60a);
            a2.edit().putString(WXConfig.devId, this.f61a.f).commit();
        }
        this.f61a.e = a2.getString("vName", null);
        this.f61a.f66a = a2.getBoolean("valid", true);
        this.f61a.f67b = a2.getBoolean(IWXAudio.KEY_PAUSED, false);
        this.f61a.a = a2.getInt("envType", 1);
        this.f61a.g = a2.getString("regResource", null);
        this.f61a.h = a2.getString("appRegion", null);
    }

    public int a() {
        return this.f61a.a;
    }

    public a a(String str) {
        if (this.f63a.containsKey(str)) {
            return this.f63a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences a2 = a(this.f60a);
        if (a2.contains(str2)) {
            a a3 = a.a(this.f60a, a2.getString(str2, ""));
            this.f63a.put(str2, a3);
            return a3;
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m630a() {
        return this.f61a.f65a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m631a() {
        this.f61a.m642a();
    }

    public void a(int i) {
        this.f61a.a(i);
        a(this.f60a).edit().putInt("envType", i).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m632a(String str) {
        SharedPreferences.Editor edit = a(this.f60a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f61a.e = str;
    }

    public void a(String str, a aVar) {
        this.f63a.put(str, aVar);
        String a2 = a.a(aVar);
        a(this.f60a).edit().putString("hybrid_app_info_" + str, a2).commit();
    }

    public void a(String str, String str2, String str3) {
        this.f61a.a(str, str2, str3);
    }

    public void a(boolean z) {
        this.f61a.a(z);
        a(this.f60a).edit().putBoolean(IWXAudio.KEY_PAUSED, z).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m633a() {
        Context context = this.f60a;
        return !TextUtils.equals(com.xiaomi.push.h.m941a(context, context.getPackageName()), this.f61a.e);
    }

    public boolean a(String str, String str2) {
        return this.f61a.m644a(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m634a(String str, String str2, String str3) {
        a a2 = a(str3);
        return a2 != null && TextUtils.equals(str, a2.f65a) && TextUtils.equals(str2, a2.b);
    }

    public String b() {
        return this.f61a.b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m635b() {
        this.f61a.b();
    }

    public void b(String str) {
        this.f63a.remove(str);
        a(this.f60a).edit().remove("hybrid_app_info_" + str).commit();
    }

    public void b(String str, String str2, String str3) {
        this.f61a.b(str, str2, str3);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m636b() {
        if (this.f61a.m643a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.m586a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m637c() {
        return this.f61a.c;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m638c() {
        return this.f61a.m643a();
    }

    public String d() {
        return this.f61a.d;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m639d() {
        return (TextUtils.isEmpty(this.f61a.f65a) || TextUtils.isEmpty(this.f61a.b) || TextUtils.isEmpty(this.f61a.c) || TextUtils.isEmpty(this.f61a.d)) ? false : true;
    }

    public String e() {
        return this.f61a.g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m640e() {
        return this.f61a.f67b;
    }

    public String f() {
        return this.f61a.h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m641f() {
        return !this.f61a.f66a;
    }
}

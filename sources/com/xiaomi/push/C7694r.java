package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.r */
/* loaded from: classes11.dex */
public class C7694r {
    private static volatile C7694r a;

    /* renamed from: a  reason: collision with other field name */
    private Context f818a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f819a = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with other field name */
    private Map<String, Map<String, String>> f820a = new HashMap();

    private C7694r(Context context) {
        this.f818a = context;
    }

    public static C7694r a(Context context) {
        if (a == null) {
            synchronized (C7694r.class) {
                if (a == null) {
                    a = new C7694r(context);
                }
            }
        }
        return a;
    }

    private synchronized String a(String str, String str2) {
        if (this.f820a != null && !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    Map<String, String> map = this.f820a.get(str);
                    if (map != null) {
                        return map.get(str2);
                    }
                    return "";
                } catch (Throwable unused) {
                    return "";
                }
            }
        }
        return "";
    }

    private synchronized void b(String str, String str2, String str3) {
        if (this.f820a == null) {
            this.f820a = new HashMap();
        }
        Map<String, String> map = this.f820a.get(str);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str2, str3);
        this.f820a.put(str, map);
    }

    public synchronized String a(String str, String str2, String str3) {
        String a2 = a(str, str2);
        if (TextUtils.isEmpty(a2)) {
            return this.f818a.getSharedPreferences(str, 4).getString(str2, str3);
        }
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m1127a(String str, String str2, String str3) {
        b(str, str2, str3);
        this.f819a.post(new RunnableC7695s(this, str, str2, str3));
    }
}

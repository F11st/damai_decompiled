package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ed {
    private static volatile ed a;

    /* renamed from: a  reason: collision with other field name */
    private int f294a;

    /* renamed from: a  reason: collision with other field name */
    private Context f295a;

    /* renamed from: a  reason: collision with other field name */
    private eh f296a;

    /* renamed from: a  reason: collision with other field name */
    private String f297a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<ef, eg> f298a;
    private String b;

    private ed(Context context) {
        HashMap<ef, eg> hashMap = new HashMap<>();
        this.f298a = hashMap;
        this.f295a = context;
        hashMap.put(ef.SERVICE_ACTION, new ej());
        this.f298a.put(ef.SERVICE_COMPONENT, new ek());
        this.f298a.put(ef.ACTIVITY, new eb());
        this.f298a.put(ef.PROVIDER, new ei());
    }

    public static ed a(Context context) {
        if (a == null) {
            synchronized (ed.class) {
                if (a == null) {
                    a = new ed(context);
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ef efVar, Context context, ec ecVar) {
        this.f298a.get(efVar).a(context, ecVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m854a(Context context) {
        return com.xiaomi.push.service.al.m1165a(context, context.getPackageName());
    }

    public int a() {
        return this.f294a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public eh m855a() {
        return this.f296a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m856a() {
        return this.f297a;
    }

    public void a(int i) {
        this.f294a = i;
    }

    public void a(Context context, String str, int i, String str2, String str3) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            a(i);
            al.a(this.f295a).a(new ee(this, str, context, str2, str3));
            return;
        }
        dz.a(context, "" + str, 1008, "A receive a incorrect message");
    }

    public void a(ef efVar, Context context, Intent intent, String str) {
        if (efVar != null) {
            this.f298a.get(efVar).a(context, intent, str);
        } else {
            dz.a(context, "null", 1008, "A receive a incorrect message with empty type");
        }
    }

    public void a(eh ehVar) {
        this.f296a = ehVar;
    }

    public void a(String str) {
        this.f297a = str;
    }

    public void a(String str, String str2, int i, eh ehVar) {
        a(str);
        b(str2);
        a(i);
        a(ehVar);
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }
}

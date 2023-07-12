package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class hg {
    private static volatile hg a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f457a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, hh> f458a = new HashMap();

    private hg(Context context) {
        this.f457a = context;
    }

    public static hg a(Context context) {
        if (context == null) {
            AbstractC7535b.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (a == null) {
            synchronized (hg.class) {
                if (a == null) {
                    a = new hg(context);
                }
            }
        }
        return a;
    }

    private boolean a(String str, String str2, String str3, String str4, long j, String str5) {
        C7672hn c7672hn = new C7672hn();
        c7672hn.d(str3);
        c7672hn.c(str4);
        c7672hn.a(j);
        c7672hn.b(str5);
        c7672hn.a(true);
        c7672hn.a("push_sdk_channel");
        c7672hn.e(str2);
        return a(c7672hn, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public hh a() {
        hh hhVar = this.f458a.get("UPLOADER_PUSH_CHANNEL");
        if (hhVar != null) {
            return hhVar;
        }
        hh hhVar2 = this.f458a.get("UPLOADER_HTTP");
        if (hhVar2 != null) {
            return hhVar2;
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    Map<String, hh> m952a() {
        return this.f458a;
    }

    public void a(hh hhVar, String str) {
        if (hhVar == null) {
            AbstractC7535b.d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            AbstractC7535b.d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            m952a().put(str, hhVar);
        }
    }

    public boolean a(C7672hn c7672hn, String str) {
        if (TextUtils.isEmpty(str)) {
            AbstractC7535b.m586a("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        } else if (com.xiaomi.push.service.bz.a(c7672hn, false)) {
            return false;
        } else {
            if (TextUtils.isEmpty(c7672hn.d())) {
                c7672hn.f(com.xiaomi.push.service.bz.a());
            }
            c7672hn.g(str);
            com.xiaomi.push.service.ca.a(this.f457a, c7672hn);
            return true;
        }
    }

    public boolean a(String str, String str2, long j, String str3) {
        return a(this.f457a.getPackageName(), this.f457a.getPackageName(), str, str2, j, str3);
    }
}

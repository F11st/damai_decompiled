package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.dx;
import com.xiaomi.push.service.bg;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class fk {
    public static void a(bg.C7737b c7737b, String str, fw fwVar) {
        String a;
        dx.C7637c c7637c = new dx.C7637c();
        if (!TextUtils.isEmpty(c7737b.c)) {
            c7637c.a(c7737b.c);
        }
        if (!TextUtils.isEmpty(c7737b.e)) {
            c7637c.d(c7737b.e);
        }
        if (!TextUtils.isEmpty(c7737b.f)) {
            c7637c.e(c7737b.f);
        }
        c7637c.b(c7737b.f927a ? "1" : "0");
        if (TextUtils.isEmpty(c7737b.d)) {
            c7637c.c("XIAOMI-SASL");
        } else {
            c7637c.c(c7737b.d);
        }
        fl flVar = new fl();
        flVar.c(c7737b.f928b);
        flVar.a(Integer.parseInt(c7737b.g));
        flVar.b(c7737b.f925a);
        flVar.a("BIND", (String) null);
        flVar.a(flVar.e());
        AbstractC7535b.m586a("[Slim]: bind id=" + flVar.e());
        HashMap hashMap = new HashMap();
        hashMap.put("challenge", str);
        hashMap.put("token", c7737b.c);
        hashMap.put("chid", c7737b.g);
        hashMap.put("from", c7737b.f928b);
        hashMap.put("id", flVar.e());
        hashMap.put("to", "xiaomi.com");
        if (c7737b.f927a) {
            hashMap.put("kick", "1");
        } else {
            hashMap.put("kick", "0");
        }
        if (TextUtils.isEmpty(c7737b.e)) {
            hashMap.put("client_attrs", "");
        } else {
            hashMap.put("client_attrs", c7737b.e);
        }
        if (TextUtils.isEmpty(c7737b.f)) {
            hashMap.put("cloud_attrs", "");
        } else {
            hashMap.put("cloud_attrs", c7737b.f);
        }
        if (c7737b.d.equals("XIAOMI-PASS") || c7737b.d.equals("XMPUSH-PASS")) {
            a = bn.a(c7737b.d, null, hashMap, c7737b.h);
        } else {
            c7737b.d.equals("XIAOMI-SASL");
            a = null;
        }
        c7637c.f(a);
        flVar.a(c7637c.m852a(), (String) null);
        fwVar.b(flVar);
    }

    public static void a(String str, String str2, fw fwVar) {
        fl flVar = new fl();
        flVar.c(str2);
        flVar.a(Integer.parseInt(str));
        flVar.a("UBND", (String) null);
        fwVar.b(flVar);
    }
}

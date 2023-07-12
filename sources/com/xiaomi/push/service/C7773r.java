package com.xiaomi.push.service;

import com.xiaomi.push.C7672hn;
import com.xiaomi.push.hh;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.service.r */
/* loaded from: classes11.dex */
public class C7773r implements hh {
    private final XMPushService a;

    public C7773r(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    @Override // com.xiaomi.push.hh
    public void a(List<C7672hn> list, String str, String str2) {
        this.a.a(new C7775s(this, 4, str, list, str2));
    }
}

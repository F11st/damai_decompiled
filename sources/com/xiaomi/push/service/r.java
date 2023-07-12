package com.xiaomi.push.service;

import com.xiaomi.push.hh;
import com.xiaomi.push.hn;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class r implements hh {
    private final XMPushService a;

    public r(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    @Override // com.xiaomi.push.hh
    public void a(List<hn> list, String str, String str2) {
        this.a.a(new s(this, 4, str, list, str2));
    }
}

package com.vivo.push.d;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.d.r;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class t implements r.a {
    final /* synthetic */ s a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.a = sVar;
    }

    @Override // com.vivo.push.d.r.a
    public final void a() {
        Context context;
        Context context2;
        long l = com.vivo.push.e.a().l();
        if (l < 1400 && l != 1340) {
            com.vivo.push.util.p.b("OnNotificationArrivedTask", "引擎版本太低，不支持正向展示功能，pushEngineSDKVersion：".concat(String.valueOf(l)));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("srt", "1");
        hashMap.put("message_id", String.valueOf(this.a.b.f()));
        context = ((com.vivo.push.l) this.a.c).a;
        context2 = ((com.vivo.push.l) this.a.c).a;
        String b = com.vivo.push.util.z.b(context, context2.getPackageName());
        if (!TextUtils.isEmpty(b)) {
            hashMap.put("app_id", b);
        }
        hashMap.put("type", "1");
        hashMap.put("dtp", "1");
        com.vivo.push.util.e.a(6L, hashMap);
    }

    @Override // com.vivo.push.d.r.a
    public final void b() {
        Context context;
        Context context2;
        HashMap hashMap = new HashMap();
        hashMap.put("messageID", String.valueOf(this.a.b.f()));
        context = ((com.vivo.push.l) this.a.c).a;
        context2 = ((com.vivo.push.l) this.a.c).a;
        String b = com.vivo.push.util.z.b(context, context2.getPackageName());
        if (!TextUtils.isEmpty(b)) {
            hashMap.put("remoteAppId", b);
        }
        com.vivo.push.util.e.a(2122L, hashMap);
    }
}

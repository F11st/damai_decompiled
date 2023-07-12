package com.vivo.push.d;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.AbstractRunnableC7491l;
import com.vivo.push.C7481e;
import com.vivo.push.d.C7471r;
import com.vivo.push.util.C7512e;
import com.vivo.push.util.C7523p;
import com.vivo.push.util.C7533z;
import java.util.HashMap;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.d.t */
/* loaded from: classes11.dex */
final class C7474t implements C7471r.InterfaceC7472a {
    final /* synthetic */ RunnableC7473s a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7474t(RunnableC7473s runnableC7473s) {
        this.a = runnableC7473s;
    }

    @Override // com.vivo.push.d.C7471r.InterfaceC7472a
    public final void a() {
        Context context;
        Context context2;
        long l = C7481e.a().l();
        if (l < 1400 && l != 1340) {
            C7523p.b("OnNotificationArrivedTask", "引擎版本太低，不支持正向展示功能，pushEngineSDKVersion：".concat(String.valueOf(l)));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("srt", "1");
        hashMap.put("message_id", String.valueOf(this.a.b.f()));
        context = ((AbstractRunnableC7491l) this.a.c).a;
        context2 = ((AbstractRunnableC7491l) this.a.c).a;
        String b = C7533z.b(context, context2.getPackageName());
        if (!TextUtils.isEmpty(b)) {
            hashMap.put("app_id", b);
        }
        hashMap.put("type", "1");
        hashMap.put("dtp", "1");
        C7512e.a(6L, hashMap);
    }

    @Override // com.vivo.push.d.C7471r.InterfaceC7472a
    public final void b() {
        Context context;
        Context context2;
        HashMap hashMap = new HashMap();
        hashMap.put("messageID", String.valueOf(this.a.b.f()));
        context = ((AbstractRunnableC7491l) this.a.c).a;
        context2 = ((AbstractRunnableC7491l) this.a.c).a;
        String b = C7533z.b(context, context2.getPackageName());
        if (!TextUtils.isEmpty(b)) {
            hashMap.put("remoteAppId", b);
        }
        C7512e.a(2122L, hashMap);
    }
}

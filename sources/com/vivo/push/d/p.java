package com.vivo.push.d;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.UnvarnishedMessage;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class p extends z {
    /* JADX INFO: Access modifiers changed from: package-private */
    public p(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    protected final void a(com.vivo.push.o oVar) {
        com.vivo.push.b.o oVar2 = (com.vivo.push.b.o) oVar;
        com.vivo.push.e.a().a(new com.vivo.push.b.h(String.valueOf(oVar2.f())));
        if (!ClientConfigManagerImpl.getInstance(this.a).isEnablePush()) {
            com.vivo.push.util.p.d("OnMessageTask", "command  " + oVar + " is ignore by disable push ");
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(1020L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(oVar2.f()));
            Context context = this.a;
            String b = com.vivo.push.util.z.b(context, context.getPackageName());
            if (!TextUtils.isEmpty(b)) {
                hashMap.put("remoteAppId", b);
            }
            xVar.a(hashMap);
            com.vivo.push.e.a().a(xVar);
        } else if (com.vivo.push.e.a().g() && !a(com.vivo.push.util.z.c(this.a), oVar2.d(), oVar2.i())) {
            com.vivo.push.b.x xVar2 = new com.vivo.push.b.x(1021L);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("messageID", String.valueOf(oVar2.f()));
            Context context2 = this.a;
            String b2 = com.vivo.push.util.z.b(context2, context2.getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap2.put("remoteAppId", b2);
            }
            xVar2.a(hashMap2);
            com.vivo.push.e.a().a(xVar2);
        } else {
            UnvarnishedMessage e = oVar2.e();
            if (e != null) {
                int targetType = e.getTargetType();
                String tragetContent = e.getTragetContent();
                com.vivo.push.util.p.d("OnMessageTask", "tragetType is " + targetType + " ; target is " + tragetContent);
                com.vivo.push.m.b(new q(this, e));
                return;
            }
            com.vivo.push.util.p.a("OnMessageTask", " message is null");
        }
    }
}

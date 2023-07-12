package com.vivo.push.d;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.InsideNotificationItem;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class r extends z {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface a {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    protected final void a(com.vivo.push.o oVar) {
        if (oVar == null) {
            com.vivo.push.util.p.a("OnNotificationArrivedTask", "command is null");
            return;
        }
        boolean isEnablePush = ClientConfigManagerImpl.getInstance(this.a).isEnablePush();
        com.vivo.push.b.q qVar = (com.vivo.push.b.q) oVar;
        Context context = this.a;
        if (!com.vivo.push.util.t.d(context, context.getPackageName())) {
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(2101L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(qVar.f()));
            Context context2 = this.a;
            String b = com.vivo.push.util.z.b(context2, context2.getPackageName());
            if (!TextUtils.isEmpty(b)) {
                hashMap.put("remoteAppId", b);
            }
            xVar.a(hashMap);
            com.vivo.push.e.a().a(xVar);
            return;
        }
        com.vivo.push.e.a().a(new com.vivo.push.b.h(String.valueOf(qVar.f())));
        com.vivo.push.util.p.d("OnNotificationArrivedTask", "PushMessageReceiver " + this.a.getPackageName() + " isEnablePush :" + isEnablePush);
        if (!isEnablePush) {
            com.vivo.push.b.x xVar2 = new com.vivo.push.b.x(1020L);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("messageID", String.valueOf(qVar.f()));
            Context context3 = this.a;
            String b2 = com.vivo.push.util.z.b(context3, context3.getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap2.put("remoteAppId", b2);
            }
            xVar2.a(hashMap2);
            com.vivo.push.e.a().a(xVar2);
        } else if (com.vivo.push.e.a().g() && !a(com.vivo.push.util.z.c(this.a), qVar.e(), qVar.i())) {
            com.vivo.push.b.x xVar3 = new com.vivo.push.b.x(1021L);
            HashMap<String, String> hashMap3 = new HashMap<>();
            hashMap3.put("messageID", String.valueOf(qVar.f()));
            Context context4 = this.a;
            String b3 = com.vivo.push.util.z.b(context4, context4.getPackageName());
            if (!TextUtils.isEmpty(b3)) {
                hashMap3.put("remoteAppId", b3);
            }
            xVar3.a(hashMap3);
            com.vivo.push.e.a().a(xVar3);
        } else {
            InsideNotificationItem d = qVar.d();
            if (d != null) {
                int targetType = d.getTargetType();
                String tragetContent = d.getTragetContent();
                com.vivo.push.util.p.d("OnNotificationArrivedTask", "tragetType is " + targetType + " ; target is " + tragetContent);
                com.vivo.push.m.c(new s(this, d, qVar));
                return;
            }
            com.vivo.push.util.p.a("OnNotificationArrivedTask", "notify is null");
            Context context5 = this.a;
            com.vivo.push.util.p.c(context5, "通知内容为空，" + qVar.f());
            com.vivo.push.util.e.a(this.a, qVar.f(), 1027L);
        }
    }
}

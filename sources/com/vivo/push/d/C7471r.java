package com.vivo.push.d;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.AbstractC7496o;
import com.vivo.push.C7481e;
import com.vivo.push.C7492m;
import com.vivo.push.b.C7420h;
import com.vivo.push.b.C7429q;
import com.vivo.push.b.C7436x;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.util.C7512e;
import com.vivo.push.util.C7523p;
import com.vivo.push.util.C7527t;
import com.vivo.push.util.C7533z;
import java.util.HashMap;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.d.r */
/* loaded from: classes11.dex */
public final class C7471r extends AbstractC7480z {

    /* compiled from: Taobao */
    /* renamed from: com.vivo.push.d.r$a */
    /* loaded from: classes11.dex */
    public interface InterfaceC7472a {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7471r(AbstractC7496o abstractC7496o) {
        super(abstractC7496o);
    }

    @Override // com.vivo.push.AbstractRunnableC7491l
    protected final void a(AbstractC7496o abstractC7496o) {
        if (abstractC7496o == null) {
            C7523p.a("OnNotificationArrivedTask", "command is null");
            return;
        }
        boolean isEnablePush = ClientConfigManagerImpl.getInstance(this.a).isEnablePush();
        C7429q c7429q = (C7429q) abstractC7496o;
        Context context = this.a;
        if (!C7527t.d(context, context.getPackageName())) {
            C7436x c7436x = new C7436x(2101L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(c7429q.f()));
            Context context2 = this.a;
            String b = C7533z.b(context2, context2.getPackageName());
            if (!TextUtils.isEmpty(b)) {
                hashMap.put("remoteAppId", b);
            }
            c7436x.a(hashMap);
            C7481e.a().a(c7436x);
            return;
        }
        C7481e.a().a(new C7420h(String.valueOf(c7429q.f())));
        C7523p.d("OnNotificationArrivedTask", "PushMessageReceiver " + this.a.getPackageName() + " isEnablePush :" + isEnablePush);
        if (!isEnablePush) {
            C7436x c7436x2 = new C7436x(1020L);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("messageID", String.valueOf(c7429q.f()));
            Context context3 = this.a;
            String b2 = C7533z.b(context3, context3.getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap2.put("remoteAppId", b2);
            }
            c7436x2.a(hashMap2);
            C7481e.a().a(c7436x2);
        } else if (C7481e.a().g() && !a(C7533z.c(this.a), c7429q.e(), c7429q.i())) {
            C7436x c7436x3 = new C7436x(1021L);
            HashMap<String, String> hashMap3 = new HashMap<>();
            hashMap3.put("messageID", String.valueOf(c7429q.f()));
            Context context4 = this.a;
            String b3 = C7533z.b(context4, context4.getPackageName());
            if (!TextUtils.isEmpty(b3)) {
                hashMap3.put("remoteAppId", b3);
            }
            c7436x3.a(hashMap3);
            C7481e.a().a(c7436x3);
        } else {
            InsideNotificationItem d = c7429q.d();
            if (d != null) {
                int targetType = d.getTargetType();
                String tragetContent = d.getTragetContent();
                C7523p.d("OnNotificationArrivedTask", "tragetType is " + targetType + " ; target is " + tragetContent);
                C7492m.c(new RunnableC7473s(this, d, c7429q));
                return;
            }
            C7523p.a("OnNotificationArrivedTask", "notify is null");
            Context context5 = this.a;
            C7523p.c(context5, "通知内容为空，" + c7429q.f());
            C7512e.a(this.a, c7429q.f(), 1027L);
        }
    }
}

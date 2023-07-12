package com.vivo.push.d;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.AbstractC7496o;
import com.vivo.push.C7481e;
import com.vivo.push.C7492m;
import com.vivo.push.b.C7420h;
import com.vivo.push.b.C7427o;
import com.vivo.push.b.C7436x;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.util.C7523p;
import com.vivo.push.util.C7533z;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.vivo.push.d.p */
/* loaded from: classes11.dex */
public final class C7469p extends AbstractC7480z {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C7469p(AbstractC7496o abstractC7496o) {
        super(abstractC7496o);
    }

    @Override // com.vivo.push.AbstractRunnableC7491l
    protected final void a(AbstractC7496o abstractC7496o) {
        C7427o c7427o = (C7427o) abstractC7496o;
        C7481e.a().a(new C7420h(String.valueOf(c7427o.f())));
        if (!ClientConfigManagerImpl.getInstance(this.a).isEnablePush()) {
            C7523p.d("OnMessageTask", "command  " + abstractC7496o + " is ignore by disable push ");
            C7436x c7436x = new C7436x(1020L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(c7427o.f()));
            Context context = this.a;
            String b = C7533z.b(context, context.getPackageName());
            if (!TextUtils.isEmpty(b)) {
                hashMap.put("remoteAppId", b);
            }
            c7436x.a(hashMap);
            C7481e.a().a(c7436x);
        } else if (C7481e.a().g() && !a(C7533z.c(this.a), c7427o.d(), c7427o.i())) {
            C7436x c7436x2 = new C7436x(1021L);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("messageID", String.valueOf(c7427o.f()));
            Context context2 = this.a;
            String b2 = C7533z.b(context2, context2.getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap2.put("remoteAppId", b2);
            }
            c7436x2.a(hashMap2);
            C7481e.a().a(c7436x2);
        } else {
            UnvarnishedMessage e = c7427o.e();
            if (e != null) {
                int targetType = e.getTargetType();
                String tragetContent = e.getTragetContent();
                C7523p.d("OnMessageTask", "tragetType is " + targetType + " ; target is " + tragetContent);
                C7492m.b(new RunnableC7470q(this, e));
                return;
            }
            C7523p.a("OnMessageTask", " message is null");
        }
    }
}

package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.AbstractC7496o;
import com.vivo.push.AbstractRunnableC7491l;
import com.vivo.push.C7481e;
import com.vivo.push.a.C7411a;
import com.vivo.push.b.C7415c;
import com.vivo.push.b.C7417e;
import com.vivo.push.b.C7435w;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.C7494b;
import com.vivo.push.util.C7509b;
import com.vivo.push.util.C7523p;
import com.vivo.push.util.C7526s;
import com.vivo.push.util.C7527t;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ah extends AbstractRunnableC7491l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(AbstractC7496o abstractC7496o) {
        super(abstractC7496o);
    }

    @Override // com.vivo.push.AbstractRunnableC7491l
    protected final void a(AbstractC7496o abstractC7496o) {
        Context context = this.a;
        if (context == null) {
            C7523p.d("SendCommandTask", "SendCommandTask " + abstractC7496o + " ; mContext is Null");
        } else if (abstractC7496o == null) {
            C7523p.d("SendCommandTask", "SendCommandTask pushCommand is Null");
        } else {
            C7494b a = C7527t.a(context);
            int b = abstractC7496o.b();
            if (b == 2009) {
                C7523p.a(ClientConfigManagerImpl.getInstance(this.a).isDebug());
                if (C7523p.a()) {
                    C7481e.a().i();
                    C7509b c7509b = new C7509b();
                    c7509b.a(this.a, "com.vivo.push_preferences.hybridapptoken_v1");
                    c7509b.a();
                    C7509b c7509b2 = new C7509b();
                    c7509b2.a(this.a, "com.vivo.push_preferences.appconfig_v1");
                    c7509b2.a();
                    if (!C7481e.a().e()) {
                        ClientConfigManagerImpl.getInstance(this.a).clearPush();
                    }
                }
            } else if (b != 2011) {
                switch (b) {
                    case 2002:
                    case 2003:
                    case 2004:
                    case 2005:
                        if (a != null && !a.c()) {
                            C7415c c7415c = (C7415c) abstractC7496o;
                            int a2 = C7526s.a(c7415c);
                            if (a2 != 0) {
                                C7481e.a().a(c7415c.h(), a2);
                                return;
                            }
                        } else {
                            C7481e.a().a(((C7415c) abstractC7496o).h(), 1005);
                            break;
                        }
                        break;
                }
            } else {
                C7523p.a(ClientConfigManagerImpl.getInstance(this.a).isDebug(((C7435w) abstractC7496o).d()));
            }
            if (a == null) {
                C7523p.d("SendCommandTask", "SendCommandTask " + abstractC7496o + " ; pushPkgInfo is Null");
                return;
            }
            String a3 = a.a();
            if (a.c()) {
                try {
                    C7481e.a().a(((C7415c) abstractC7496o).h(), 1004);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                abstractC7496o = new C7417e();
                C7523p.d("SendCommandTask", "SendCommandTask " + abstractC7496o + " ; pkgName is InBlackList ");
            }
            C7411a.a(this.a, a3, abstractC7496o);
        }
    }
}

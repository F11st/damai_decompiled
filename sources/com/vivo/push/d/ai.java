package com.vivo.push.d;

import com.vivo.push.AbstractC7496o;
import com.vivo.push.AbstractRunnableC7491l;
import com.vivo.push.C7481e;
import com.vivo.push.a.C7411a;
import com.vivo.push.b.C7415c;
import com.vivo.push.b.C7417e;
import com.vivo.push.model.C7494b;
import com.vivo.push.util.C7526s;
import com.vivo.push.util.C7527t;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ai extends AbstractRunnableC7491l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(AbstractC7496o abstractC7496o) {
        super(abstractC7496o);
    }

    @Override // com.vivo.push.AbstractRunnableC7491l
    protected final void a(AbstractC7496o abstractC7496o) {
        C7415c c7415c = (C7415c) abstractC7496o;
        C7494b a = C7527t.a(this.a);
        if (a == null) {
            C7481e.a().a(c7415c.h(), 1005, new Object[0]);
            return;
        }
        String a2 = a.a();
        if (a.c()) {
            C7481e.a().a(c7415c.h(), 1004, new Object[0]);
            abstractC7496o = new C7417e();
        } else {
            int a3 = C7526s.a(c7415c);
            if (a3 != 0) {
                C7481e.a().a(c7415c.h(), a3, new Object[0]);
                return;
            }
        }
        C7411a.a(this.a, a2, abstractC7496o);
    }
}

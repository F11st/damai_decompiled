package com.vivo.push.d;

import com.vivo.push.AbstractC7496o;
import com.vivo.push.b.C7424l;
import com.vivo.push.util.C7530w;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.d.k */
/* loaded from: classes11.dex */
public final class C7464k extends AbstractC7480z {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C7464k(AbstractC7496o abstractC7496o) {
        super(abstractC7496o);
    }

    @Override // com.vivo.push.AbstractRunnableC7491l
    protected final void a(AbstractC7496o abstractC7496o) {
        C7424l c7424l = (C7424l) abstractC7496o;
        int d = c7424l.d();
        int e = c7424l.e();
        C7530w.b().a("key_dispatch_environment", d);
        C7530w.b().a("key_dispatch_area", e);
    }
}

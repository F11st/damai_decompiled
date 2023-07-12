package com.vivo.push.d;

import com.vivo.push.AbstractC7496o;
import com.vivo.push.util.C7523p;
import com.vivo.push.util.C7532y;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.vivo.push.d.g */
/* loaded from: classes11.dex */
public final class C7460g extends AbstractC7480z {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C7460g(AbstractC7496o abstractC7496o) {
        super(abstractC7496o);
    }

    @Override // com.vivo.push.AbstractRunnableC7491l
    protected final void a(AbstractC7496o abstractC7496o) {
        C7523p.d("OnClearCacheTask", "delete push info " + this.a.getPackageName());
        C7532y.b(this.a).a();
    }
}

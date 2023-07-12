package com.vivo.push.d;

import com.vivo.push.AbstractC7496o;
import com.vivo.push.AbstractRunnableC7491l;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.util.C7523p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.vivo.push.d.c */
/* loaded from: classes11.dex */
public final class C7456c extends AbstractRunnableC7491l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C7456c(AbstractC7496o abstractC7496o) {
        super(abstractC7496o);
    }

    @Override // com.vivo.push.AbstractRunnableC7491l
    protected final void a(AbstractC7496o abstractC7496o) {
        C7523p.a(ClientConfigManagerImpl.getInstance(this.a).isDebug());
    }
}

package com.vivo.push.d;

import com.vivo.push.cache.ClientConfigManagerImpl;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class c extends com.vivo.push.l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    protected final void a(com.vivo.push.o oVar) {
        com.vivo.push.util.p.a(ClientConfigManagerImpl.getInstance(this.a).isDebug());
    }
}

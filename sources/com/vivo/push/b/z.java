package com.vivo.push.b;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class z extends c {
    private ArrayList<String> a;

    public z(boolean z, String str, ArrayList<String> arrayList) {
        super(z ? 2004 : 2005, str);
        this.a = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a(IRequestConst.TAGS, (Serializable) this.a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.c(IRequestConst.TAGS);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final String toString() {
        return "TagCommand";
    }
}

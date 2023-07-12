package com.vivo.push.b;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class a extends c {
    private ArrayList<String> a;

    public a(boolean z, String str, ArrayList<String> arrayList) {
        super(z ? 2002 : 2003, str);
        this.a = arrayList;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a(IRequestConst.TAGS, this.a);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.c(IRequestConst.TAGS);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final String toString() {
        return "AliasCommand:" + b();
    }
}

package com.vivo.push.b;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.vivo.push.C7410a;
import java.util.ArrayList;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.b.a */
/* loaded from: classes11.dex */
public final class C7413a extends C7415c {
    private ArrayList<String> a;

    public C7413a(boolean z, String str, ArrayList<String> arrayList) {
        super(z ? 2002 : 2003, str);
        this.a = arrayList;
    }

    @Override // com.vivo.push.b.C7415c, com.vivo.push.AbstractC7496o
    public final void c(C7410a c7410a) {
        super.c(c7410a);
        c7410a.a(IRequestConst.TAGS, this.a);
    }

    @Override // com.vivo.push.b.C7415c, com.vivo.push.AbstractC7496o
    public final void d(C7410a c7410a) {
        super.d(c7410a);
        this.a = c7410a.c(IRequestConst.TAGS);
    }

    @Override // com.vivo.push.b.C7415c, com.vivo.push.AbstractC7496o
    public final String toString() {
        return "AliasCommand:" + b();
    }
}

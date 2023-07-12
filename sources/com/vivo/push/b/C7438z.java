package com.vivo.push.b;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.vivo.push.C7410a;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.b.z */
/* loaded from: classes11.dex */
public final class C7438z extends C7415c {
    private ArrayList<String> a;

    public C7438z(boolean z, String str, ArrayList<String> arrayList) {
        super(z ? 2004 : 2005, str);
        this.a = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.C7415c, com.vivo.push.AbstractC7496o
    public final void c(C7410a c7410a) {
        super.c(c7410a);
        c7410a.a(IRequestConst.TAGS, (Serializable) this.a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.C7415c, com.vivo.push.AbstractC7496o
    public final void d(C7410a c7410a) {
        super.d(c7410a);
        this.a = c7410a.c(IRequestConst.TAGS);
    }

    @Override // com.vivo.push.b.C7415c, com.vivo.push.AbstractC7496o
    public final String toString() {
        return "TagCommand";
    }
}

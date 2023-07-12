package com.vivo.push.b;

import com.vivo.push.C7410a;
import java.util.ArrayList;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.b.m */
/* loaded from: classes11.dex */
public final class C7425m extends C7431s {
    private ArrayList<String> a;

    public C7425m() {
        super(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.C7431s, com.vivo.push.AbstractC7496o
    public final void c(C7410a c7410a) {
        super.c(c7410a);
        c7410a.a("tags_list", this.a);
    }

    public final ArrayList<String> d() {
        return this.a;
    }

    @Override // com.vivo.push.b.C7431s, com.vivo.push.AbstractC7496o
    public final String toString() {
        return "OnListTagCommand";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.C7431s, com.vivo.push.AbstractC7496o
    public final void d(C7410a c7410a) {
        super.d(c7410a);
        this.a = c7410a.c("tags_list");
    }
}

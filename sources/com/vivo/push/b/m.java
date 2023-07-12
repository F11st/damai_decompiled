package com.vivo.push.b;

import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class m extends s {
    private ArrayList<String> a;

    public m() {
        super(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("tags_list", this.a);
    }

    public final ArrayList<String> d() {
        return this.a;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnListTagCommand";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.c("tags_list");
    }
}

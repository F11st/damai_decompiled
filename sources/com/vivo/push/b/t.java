package com.vivo.push.b;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class t extends s {
    private ArrayList<String> a;
    private ArrayList<String> b;

    public t(int i) {
        super(i);
        this.a = null;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.a);
        aVar.a("error_msg", this.b);
    }

    public final ArrayList<String> d() {
        return this.a;
    }

    public final List<String> e() {
        return this.b;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnSetTagsCommand";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.c("content");
        this.b = aVar.c("error_msg");
    }
}

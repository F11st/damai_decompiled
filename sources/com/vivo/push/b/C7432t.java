package com.vivo.push.b;

import com.vivo.push.C7410a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.b.t */
/* loaded from: classes11.dex */
public final class C7432t extends C7431s {
    private ArrayList<String> a;
    private ArrayList<String> b;

    public C7432t(int i) {
        super(i);
        this.a = null;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.C7431s, com.vivo.push.AbstractC7496o
    public final void c(C7410a c7410a) {
        super.c(c7410a);
        c7410a.a("content", this.a);
        c7410a.a("error_msg", this.b);
    }

    public final ArrayList<String> d() {
        return this.a;
    }

    public final List<String> e() {
        return this.b;
    }

    @Override // com.vivo.push.b.C7431s, com.vivo.push.AbstractC7496o
    public final String toString() {
        return "OnSetTagsCommand";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.C7431s, com.vivo.push.AbstractC7496o
    public final void d(C7410a c7410a) {
        super.d(c7410a);
        this.a = c7410a.c("content");
        this.b = c7410a.c("error_msg");
    }
}

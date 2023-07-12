package com.vivo.push.b;

import com.vivo.push.AbstractC7496o;
import com.vivo.push.C7410a;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.b.h */
/* loaded from: classes11.dex */
public final class C7420h extends AbstractC7496o {
    private String a;

    public C7420h() {
        super(2013);
    }

    @Override // com.vivo.push.AbstractC7496o
    protected final void c(C7410a c7410a) {
        c7410a.a("MsgArriveCommand.MSG_TAG", this.a);
    }

    @Override // com.vivo.push.AbstractC7496o
    protected final void d(C7410a c7410a) {
        this.a = c7410a.a("MsgArriveCommand.MSG_TAG");
    }

    public C7420h(String str) {
        this();
        this.a = str;
    }
}

package com.vivo.push.b;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class h extends com.vivo.push.o {
    private String a;

    public h() {
        super(2013);
    }

    @Override // com.vivo.push.o
    protected final void c(com.vivo.push.a aVar) {
        aVar.a("MsgArriveCommand.MSG_TAG", this.a);
    }

    @Override // com.vivo.push.o
    protected final void d(com.vivo.push.a aVar) {
        this.a = aVar.a("MsgArriveCommand.MSG_TAG");
    }

    public h(String str) {
        this();
        this.a = str;
    }
}

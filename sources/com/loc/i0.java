package com.loc;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class i0 extends m0 {
    private StringBuilder c;
    private boolean d;

    public i0(m0 m0Var) {
        super(m0Var);
        this.c = new StringBuilder();
        this.d = true;
    }

    @Override // com.loc.m0
    protected final byte[] b(byte[] bArr) {
        byte[] p = v1.p(this.c.toString());
        this.b = p;
        this.d = true;
        StringBuilder sb = this.c;
        sb.delete(0, sb.length());
        return p;
    }

    @Override // com.loc.m0
    public final void c(byte[] bArr) {
        String g = v1.g(bArr);
        if (this.d) {
            this.d = false;
        } else {
            this.c.append(",");
        }
        StringBuilder sb = this.c;
        sb.append("{\"log\":\"");
        sb.append(g);
        sb.append("\"}");
    }
}

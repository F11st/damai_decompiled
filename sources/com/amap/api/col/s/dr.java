package com.amap.api.col.s;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class dr extends du {
    private StringBuilder a;
    private boolean b;

    public dr() {
        this.a = new StringBuilder();
        this.b = true;
    }

    @Override // com.amap.api.col.s.du
    protected final byte[] a(byte[] bArr) {
        byte[] a = bw.a(this.a.toString());
        this.d = a;
        this.b = true;
        StringBuilder sb = this.a;
        sb.delete(0, sb.length());
        return a;
    }

    @Override // com.amap.api.col.s.du
    public final void b(byte[] bArr) {
        String a = bw.a(bArr);
        if (this.b) {
            this.b = false;
        } else {
            this.a.append(",");
        }
        StringBuilder sb = this.a;
        sb.append("{\"log\":\"");
        sb.append(a);
        sb.append("\"}");
    }

    public dr(du duVar) {
        super(duVar);
        this.a = new StringBuilder();
        this.b = true;
    }
}

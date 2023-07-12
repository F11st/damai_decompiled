package com.loc;

/* compiled from: Taobao */
/* renamed from: com.loc.i0 */
/* loaded from: classes10.dex */
public final class C5840i0 extends AbstractC5858m0 {
    private StringBuilder c;
    private boolean d;

    public C5840i0(AbstractC5858m0 abstractC5858m0) {
        super(abstractC5858m0);
        this.c = new StringBuilder();
        this.d = true;
    }

    @Override // com.loc.AbstractC5858m0
    protected final byte[] b(byte[] bArr) {
        byte[] p = v1.p(this.c.toString());
        this.b = p;
        this.d = true;
        StringBuilder sb = this.c;
        sb.delete(0, sb.length());
        return p;
    }

    @Override // com.loc.AbstractC5858m0
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

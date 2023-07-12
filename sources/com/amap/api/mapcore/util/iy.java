package com.amap.api.mapcore.util;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class iy extends jb {
    private StringBuilder a;
    private boolean b;

    public iy() {
        this.a = new StringBuilder();
        this.b = true;
    }

    @Override // com.amap.api.mapcore.util.jb
    protected byte[] a(byte[] bArr) {
        byte[] a = gn.a(this.a.toString());
        c(a);
        this.b = true;
        StringBuilder sb = this.a;
        sb.delete(0, sb.length());
        return a;
    }

    @Override // com.amap.api.mapcore.util.jb
    public void b(byte[] bArr) {
        String a = gn.a(bArr);
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

    public iy(jb jbVar) {
        super(jbVar);
        this.a = new StringBuilder();
        this.b = true;
    }
}

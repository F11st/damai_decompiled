package com.amap.api.col.s;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: Taobao */
/* renamed from: com.amap.api.col.s.do  reason: invalid class name */
/* loaded from: classes10.dex */
public final class Cdo extends du {
    ByteArrayOutputStream a;

    public Cdo() {
        this.a = new ByteArrayOutputStream();
    }

    @Override // com.amap.api.col.s.du
    protected final byte[] a(byte[] bArr) {
        byte[] byteArray = this.a.toByteArray();
        try {
            this.a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.a = new ByteArrayOutputStream();
        return byteArray;
    }

    @Override // com.amap.api.col.s.du
    public final void b(byte[] bArr) {
        try {
            this.a.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Cdo(du duVar) {
        super(duVar);
        this.a = new ByteArrayOutputStream();
    }
}

package com.loc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class f0 extends m0 {
    ByteArrayOutputStream c;

    public f0(m0 m0Var) {
        super(m0Var);
        this.c = new ByteArrayOutputStream();
    }

    @Override // com.loc.m0
    protected final byte[] b(byte[] bArr) {
        byte[] byteArray = this.c.toByteArray();
        try {
            this.c.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.c = new ByteArrayOutputStream();
        return byteArray;
    }

    @Override // com.loc.m0
    public final void c(byte[] bArr) {
        try {
            this.c.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

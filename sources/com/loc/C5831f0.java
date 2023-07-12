package com.loc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: Taobao */
/* renamed from: com.loc.f0 */
/* loaded from: classes10.dex */
public final class C5831f0 extends AbstractC5858m0 {
    ByteArrayOutputStream c;

    public C5831f0(AbstractC5858m0 abstractC5858m0) {
        super(abstractC5858m0);
        this.c = new ByteArrayOutputStream();
    }

    @Override // com.loc.AbstractC5858m0
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

    @Override // com.loc.AbstractC5858m0
    public final void c(byte[] bArr) {
        try {
            this.c.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

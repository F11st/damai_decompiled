package com.loc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class k0 extends m0 {
    public k0(m0 m0Var) {
        super(m0Var);
    }

    @Override // com.loc.m0
    protected final byte[] b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
        stringBuffer.append(" ");
        stringBuffer.append(UUID.randomUUID().toString());
        stringBuffer.append(" ");
        if (stringBuffer.length() != 53) {
            return new byte[0];
        }
        byte[] p = v1.p(stringBuffer.toString());
        byte[] bArr2 = new byte[p.length + bArr.length];
        System.arraycopy(p, 0, bArr2, 0, p.length);
        System.arraycopy(bArr, 0, bArr2, p.length, bArr.length);
        return bArr2;
    }
}

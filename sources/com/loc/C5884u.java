package com.loc;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: Taobao */
/* renamed from: com.loc.u */
/* loaded from: classes10.dex */
public final class C5884u extends AbstractC5875r {
    public C5884u() {
    }

    public C5884u(AbstractC5875r abstractC5875r) {
        super(abstractC5875r);
    }

    @Override // com.loc.AbstractC5875r
    protected final byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return p1.b(bArr);
    }
}

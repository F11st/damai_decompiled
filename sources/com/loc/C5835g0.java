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
/* renamed from: com.loc.g0 */
/* loaded from: classes10.dex */
public final class C5835g0 extends AbstractC5858m0 {
    private AbstractC5875r c;

    public C5835g0(AbstractC5858m0 abstractC5858m0) {
        super(abstractC5858m0);
        this.c = new C5884u();
    }

    @Override // com.loc.AbstractC5858m0
    protected final byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return this.c.b(bArr);
    }
}

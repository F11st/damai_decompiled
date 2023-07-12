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
/* renamed from: com.loc.m0 */
/* loaded from: classes10.dex */
public abstract class AbstractC5858m0 {
    AbstractC5858m0 a;
    byte[] b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC5858m0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC5858m0(AbstractC5858m0 abstractC5858m0) {
        this.a = abstractC5858m0;
    }

    public final byte[] a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        byte[] b = b(this.b);
        AbstractC5858m0 abstractC5858m0 = this.a;
        if (abstractC5858m0 != null) {
            abstractC5858m0.b = b;
            return abstractC5858m0.a();
        }
        return b;
    }

    protected abstract byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public void c(byte[] bArr) {
    }
}

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
/* renamed from: com.loc.r */
/* loaded from: classes10.dex */
public abstract class AbstractC5875r {
    AbstractC5875r a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC5875r() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC5875r(AbstractC5875r abstractC5875r) {
        this.a = abstractC5875r;
    }

    protected abstract byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public final byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        AbstractC5875r abstractC5875r = this.a;
        if (abstractC5875r != null) {
            bArr = abstractC5875r.b(bArr);
        }
        return a(bArr);
    }
}

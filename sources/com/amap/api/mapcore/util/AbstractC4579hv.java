package com.amap.api.mapcore.util;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: Taobao */
/* renamed from: com.amap.api.mapcore.util.hv */
/* loaded from: classes10.dex */
public abstract class AbstractC4579hv {
    AbstractC4579hv a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC4579hv() {
    }

    private byte[] c(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        AbstractC4579hv abstractC4579hv = this.a;
        return abstractC4579hv != null ? abstractC4579hv.b(bArr) : bArr;
    }

    protected abstract byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return a(c(bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC4579hv(AbstractC4579hv abstractC4579hv) {
        this.a = abstractC4579hv;
    }
}

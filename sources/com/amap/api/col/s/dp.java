package com.amap.api.col.s;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class dp extends du {
    private cs a;

    public dp() {
        this.a = new cu();
    }

    @Override // com.amap.api.col.s.du
    protected final byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return this.a.b(bArr);
    }

    public dp(du duVar) {
        super(duVar);
        this.a = new cu();
    }
}

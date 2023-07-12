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
/* loaded from: classes10.dex */
public abstract class m0 {
    m0 a;
    byte[] b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m0(m0 m0Var) {
        this.a = m0Var;
    }

    public final byte[] a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        byte[] b = b(this.b);
        m0 m0Var = this.a;
        if (m0Var != null) {
            m0Var.b = b;
            return m0Var.a();
        }
        return b;
    }

    protected abstract byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public void c(byte[] bArr) {
    }
}

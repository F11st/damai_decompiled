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
/* loaded from: classes10.dex */
public abstract class jb {
    jb c;
    byte[] d = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jb() {
    }

    public byte[] a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        byte[] a = a(this.d);
        jb jbVar = this.c;
        if (jbVar != null) {
            jbVar.c(a);
            return this.c.a();
        }
        return a;
    }

    protected abstract byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public void b(byte[] bArr) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(byte[] bArr) {
        this.d = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public jb(jb jbVar) {
        this.c = jbVar;
    }
}

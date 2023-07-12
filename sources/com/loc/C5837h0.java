package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: Taobao */
/* renamed from: com.loc.h0 */
/* loaded from: classes10.dex */
public final class C5837h0 extends AbstractC5858m0 {
    private String c;
    private AbstractC5875r d;
    private Object[] e;

    public C5837h0(Context context, AbstractC5858m0 abstractC5858m0, AbstractC5875r abstractC5875r, String str, Object... objArr) {
        super(abstractC5858m0);
        this.c = str;
        this.d = abstractC5875r;
        this.e = objArr;
    }

    private String d() {
        try {
            return String.format(v1.v(this.c), this.e);
        } catch (Throwable th) {
            th.printStackTrace();
            an.m(th, "ofm", "gpj");
            return "";
        }
    }

    @Override // com.loc.AbstractC5858m0
    protected final byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String g = v1.g(bArr);
        if (TextUtils.isEmpty(g)) {
            return null;
        }
        String g2 = v1.g(this.d.b(v1.p(d())));
        return v1.p("{\"pinfo\":\"" + g2 + "\",\"els\":[" + g + "]}");
    }
}

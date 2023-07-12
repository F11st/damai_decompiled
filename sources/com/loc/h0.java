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
/* loaded from: classes10.dex */
public final class h0 extends m0 {
    private String c;
    private r d;
    private Object[] e;

    public h0(Context context, m0 m0Var, r rVar, String str, Object... objArr) {
        super(m0Var);
        this.c = str;
        this.d = rVar;
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

    @Override // com.loc.m0
    protected final byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String g = v1.g(bArr);
        if (TextUtils.isEmpty(g)) {
            return null;
        }
        String g2 = v1.g(this.d.b(v1.p(d())));
        return v1.p("{\"pinfo\":\"" + g2 + "\",\"els\":[" + g + "]}");
    }
}

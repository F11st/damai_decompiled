package com.amap.api.mapcore.util;

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
public class ix extends jb {
    private Context a;
    private String b;
    private hv e;
    private Object[] f;

    public ix(Context context, jb jbVar, hv hvVar, String str, Object... objArr) {
        super(jbVar);
        this.a = context;
        this.b = str;
        this.e = hvVar;
        this.f = objArr;
    }

    private String b(Context context) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return gn.a(this.e.b(gn.a(a(context))));
    }

    @Override // com.amap.api.mapcore.util.jb
    protected byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String a = gn.a(bArr);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        String b = b(this.a);
        return gn.a("{\"pinfo\":\"" + b + "\",\"els\":[" + a + "]}");
    }

    private String a(Context context) {
        try {
            return String.format(gn.c(this.b), this.f);
        } catch (Throwable th) {
            th.printStackTrace();
            hd.c(th, "ofm", "gpj");
            return "";
        }
    }
}

package com.loc;

import android.content.Context;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.io.ByteArrayOutputStream;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class j0 extends m0 {
    public static int d = 13;
    public static int e = 6;
    private Context c;

    public j0(Context context, m0 m0Var) {
        super(m0Var);
        this.c = context;
    }

    private static byte[] d(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            v1.l(byteArrayOutputStream, "1.2." + d + "." + e);
            v1.l(byteArrayOutputStream, "Android");
            v1.l(byteArrayOutputStream, o.h0(context));
            v1.l(byteArrayOutputStream, o.W(context));
            v1.l(byteArrayOutputStream, o.R(context));
            v1.l(byteArrayOutputStream, Build.getMANUFACTURER());
            v1.l(byteArrayOutputStream, Build.getMODEL());
            v1.l(byteArrayOutputStream, android.os.Build.DEVICE);
            v1.l(byteArrayOutputStream, o.k0(context));
            v1.l(byteArrayOutputStream, l.g(context));
            v1.l(byteArrayOutputStream, l.h(context));
            v1.l(byteArrayOutputStream, l.j(context));
            byteArrayOutputStream.write(new byte[]{0});
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return bArr;
    }

    @Override // com.loc.m0
    protected final byte[] b(byte[] bArr) {
        byte[] d2 = d(this.c);
        byte[] bArr2 = new byte[d2.length + bArr.length];
        System.arraycopy(d2, 0, bArr2, 0, d2.length);
        System.arraycopy(bArr, 0, bArr2, d2.length, bArr.length);
        return bArr2;
    }
}

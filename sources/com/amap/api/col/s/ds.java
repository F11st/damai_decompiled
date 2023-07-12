package com.amap.api.col.s;

import android.content.Context;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.io.ByteArrayOutputStream;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class ds extends du {
    public static int a = 13;
    public static int b = 6;
    private Context e;

    public ds(Context context, du duVar) {
        super(duVar);
        this.e = context;
    }

    @Override // com.amap.api.col.s.du
    protected final byte[] a(byte[] bArr) {
        byte[] a2 = a(this.e);
        byte[] bArr2 = new byte[a2.length + bArr.length];
        System.arraycopy(a2, 0, bArr2, 0, a2.length);
        System.arraycopy(bArr, 0, bArr2, a2.length, bArr.length);
        return bArr2;
    }

    private static byte[] a(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            bw.a(byteArrayOutputStream, "1.2." + a + "." + b);
            bw.a(byteArrayOutputStream, "Android");
            bw.a(byteArrayOutputStream, bo.r(context));
            bw.a(byteArrayOutputStream, bo.k(context));
            bw.a(byteArrayOutputStream, bo.h(context));
            bw.a(byteArrayOutputStream, Build.getMANUFACTURER());
            bw.a(byteArrayOutputStream, Build.getMODEL());
            bw.a(byteArrayOutputStream, android.os.Build.DEVICE);
            bw.a(byteArrayOutputStream, bo.t(context));
            bw.a(byteArrayOutputStream, bk.c(context));
            bw.a(byteArrayOutputStream, bk.d(context));
            bw.a(byteArrayOutputStream, bk.f(context));
            byteArrayOutputStream.write(new byte[]{0});
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return bArr;
    }
}

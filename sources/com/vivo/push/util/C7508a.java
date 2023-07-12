package com.vivo.push.util;

import android.content.Context;
import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.util.a */
/* loaded from: classes11.dex */
public class C7508a {
    private static volatile C7508a c;
    private byte[] a;
    private byte[] b;

    private C7508a(Context context) {
        C7530w.b().a(ContextDelegate.getContext(context));
        C7530w b = C7530w.b();
        this.a = b.c();
        this.b = b.d();
    }

    public static C7508a a(Context context) {
        if (c == null) {
            synchronized (C7508a.class) {
                if (c == null) {
                    c = new C7508a(context.getApplicationContext());
                }
            }
        }
        return c;
    }

    public final String b(String str) throws Exception {
        return new String(C7513f.a(C7513f.a(a()), C7513f.a(b()), Base64.decode(str, 2)), "utf-8");
    }

    private byte[] b() {
        byte[] bArr = this.b;
        return (bArr == null || bArr.length <= 0) ? C7530w.b().d() : bArr;
    }

    public final String a(String str) throws Exception {
        String a = C7513f.a(a());
        String a2 = C7513f.a(b());
        byte[] bytes = str.getBytes("utf-8");
        SecretKeySpec secretKeySpec = new SecretKeySpec(a2.getBytes("utf-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(a.getBytes("utf-8")));
        return Base64.encodeToString(cipher.doFinal(bytes), 2);
    }

    private byte[] a() {
        byte[] bArr = this.a;
        return (bArr == null || bArr.length <= 0) ? C7530w.b().c() : bArr;
    }
}

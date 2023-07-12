package com.loc;

import android.content.Context;
import com.loc.C5887v;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import tb.u43;

/* compiled from: Taobao */
/* renamed from: com.loc.e0 */
/* loaded from: classes10.dex */
public final class C5822e0 {
    public static String a() {
        return v1.b(System.currentTimeMillis());
    }

    public static String b(Context context, u1 u1Var) {
        StringBuilder sb = new StringBuilder();
        try {
            String O = C5861o.O(context);
            sb.append("\"sim\":\"");
            sb.append(O);
            sb.append("\",\"sdkversion\":\"");
            sb.append(u1Var.f());
            sb.append("\",\"product\":\"");
            sb.append(u1Var.a());
            sb.append("\",\"ed\":\"");
            sb.append(u1Var.g());
            sb.append("\",\"nt\":\"");
            sb.append(C5861o.J(context));
            sb.append("\",\"np\":\"");
            sb.append(C5861o.D(context));
            sb.append("\",\"mnc\":\"");
            sb.append(C5861o.H(context));
            sb.append("\",\"ant\":\"");
            sb.append(C5861o.L(context));
            sb.append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    public static String c(String str, String str2, int i, String str3, String str4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    public static u43 d(WeakReference<u43> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new u43());
        }
        return weakReference.get();
    }

    public static void e(Context context, u43 u43Var, String str, int i, int i2, String str2) {
        u43Var.a = al.i(context, str);
        u43Var.d = i;
        u43Var.b = i2;
        u43Var.c = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] f(C5887v c5887v, String str) {
        C5887v.C5893e c5893e;
        byte[] bArr = new byte[0];
        InputStream inputStream = null;
        try {
            c5893e = c5887v.a(str);
            if (c5893e == null) {
                if (c5893e != null) {
                    try {
                        c5893e.close();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                return bArr;
            }
            try {
                InputStream a = c5893e.a();
                if (a == null) {
                    if (a != null) {
                        try {
                            a.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    try {
                        c5893e.close();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                    return bArr;
                }
                bArr = new byte[a.available()];
                a.read(bArr);
                try {
                    a.close();
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
                try {
                    c5893e.close();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                return bArr;
            } catch (Throwable th6) {
                th = th6;
                try {
                    an.m(th, "sui", "rdS");
                    return bArr;
                } finally {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Throwable th7) {
                            th7.printStackTrace();
                        }
                    }
                    if (c5893e != null) {
                        try {
                            c5893e.close();
                        } catch (Throwable th8) {
                            th8.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th9) {
            th = th9;
            c5893e = null;
        }
    }
}

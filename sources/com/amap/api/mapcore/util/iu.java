package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.hy;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class iu {
    public static void a(Context context, C4593in c4593in, String str, int i, int i2, String str2) {
        c4593in.a = hb.c(context, str);
        c4593in.d = i;
        c4593in.b = i2;
        c4593in.c = str2;
    }

    public static C4593in a(WeakReference<C4593in> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new C4593in());
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(hy hyVar, String str, boolean z) {
        hy.C4582b c4582b;
        byte[] bArr = new byte[0];
        InputStream inputStream = null;
        try {
            c4582b = hyVar.a(str);
            if (c4582b == null) {
                if (c4582b != null) {
                    try {
                        c4582b.close();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                return bArr;
            }
            try {
                InputStream a = c4582b.a(0);
                if (a == null) {
                    if (a != null) {
                        try {
                            a.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    try {
                        c4582b.close();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                    return bArr;
                }
                bArr = new byte[a.available()];
                a.read(bArr);
                if (z) {
                    hyVar.c(str);
                }
                try {
                    a.close();
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
                try {
                    c4582b.close();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                return bArr;
            } catch (Throwable th6) {
                th = th6;
                try {
                    hd.c(th, "sui", "rdS");
                    return bArr;
                } finally {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Throwable th7) {
                            th7.printStackTrace();
                        }
                    }
                    if (c4582b != null) {
                        try {
                            c4582b.close();
                        } catch (Throwable th8) {
                            th8.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th9) {
            th = th9;
            c4582b = null;
        }
    }

    public static String a() {
        return gn.a(System.currentTimeMillis());
    }

    public static String a(Context context, gm gmVar) {
        StringBuilder sb = new StringBuilder();
        try {
            String g = gg.g(context);
            sb.append("\"sim\":\"");
            sb.append(g);
            sb.append("\",\"sdkversion\":\"");
            sb.append(gmVar.c());
            sb.append("\",\"product\":\"");
            sb.append(gmVar.a());
            sb.append("\",\"ed\":\"");
            sb.append(gmVar.e());
            sb.append("\",\"nt\":\"");
            sb.append(gg.e(context));
            sb.append("\",\"np\":\"");
            sb.append(gg.c(context));
            sb.append("\",\"mnc\":\"");
            sb.append(gg.d(context));
            sb.append("\",\"ant\":\"");
            sb.append(gg.f(context));
            sb.append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    public static String a(String str, String str2, String str3, int i, String str4, String str5) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2);
        stringBuffer.append(",");
        stringBuffer.append("\"timestamp\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str5);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }
}

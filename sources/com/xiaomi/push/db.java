package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class db {
    public static int a(Context context, int i) {
        int a = hb.a(context);
        if (-1 == a) {
            return -1;
        }
        return (i * (a == 0 ? 13 : 11)) / 10;
    }

    public static int a(hj hjVar) {
        return en.a(hjVar.a());
    }

    public static int a(iu iuVar, hj hjVar) {
        int a;
        switch (dc.a[hjVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return en.a(hjVar.a());
            case 11:
                a = en.a(hjVar.a());
                if (iuVar != null) {
                    try {
                        if (iuVar instanceof ia) {
                            String str = ((ia) iuVar).f582d;
                            if (!TextUtils.isEmpty(str) && en.a(en.m857a(str)) != -1) {
                                a = en.a(en.m857a(str));
                                break;
                            }
                        } else if (iuVar instanceof ii) {
                            String str2 = ((ii) iuVar).f641d;
                            if (!TextUtils.isEmpty(str2)) {
                                if (en.a(en.m857a(str2)) != -1) {
                                    a = en.a(en.m857a(str2));
                                }
                                if (ht.UploadTinyData.equals(en.m857a(str2))) {
                                    return -1;
                                }
                            }
                        }
                    } catch (Exception unused) {
                        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Notification type error");
                        return a;
                    }
                }
                break;
            case 12:
                a = en.a(hjVar.a());
                if (iuVar != null) {
                    try {
                        if (iuVar instanceof ie) {
                            String b = ((ie) iuVar).b();
                            if (!TextUtils.isEmpty(b) && ey.a(b) != -1) {
                                a = ey.a(b);
                                break;
                            }
                        } else if (iuVar instanceof id) {
                            String a2 = ((id) iuVar).a();
                            if (!TextUtils.isEmpty(a2) && ey.a(a2) != -1) {
                                return ey.a(a2);
                            }
                        }
                    } catch (Exception unused2) {
                        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Command type error");
                        break;
                    }
                }
                break;
            default:
                return -1;
        }
        return a;
    }

    public static void a(String str, Context context, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        int a = a(context, i2);
        if (i != en.a(ht.UploadTinyData)) {
            eo.a(context.getApplicationContext()).a(str, i, 1L, a);
        }
    }

    public static void a(String str, Context context, Cif cif, int i) {
        hj a;
        if (context == null || cif == null || (a = cif.a()) == null) {
            return;
        }
        int a2 = a(a);
        if (i <= 0) {
            byte[] a3 = it.a(cif);
            i = a3 != null ? a3.length : 0;
        }
        a(str, context, a2, i);
    }

    public static void a(String str, Context context, iu iuVar, hj hjVar, int i) {
        a(str, context, a(iuVar, hjVar), i);
    }

    public static void a(String str, Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        Cif cif = new Cif();
        try {
            it.a(cif, bArr);
            a(str, context, cif, bArr.length);
        } catch (iz unused) {
            com.xiaomi.channel.commonutils.logger.b.m586a("fail to convert bytes to container");
        }
    }
}

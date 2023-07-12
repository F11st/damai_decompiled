package com.alipay.apmobilesecuritysdk.a;

import android.content.Context;
import android.os.Environment;
import com.alipay.apmobilesecuritysdk.b.C4096a;
import com.alipay.apmobilesecuritysdk.c.C4097a;
import com.alipay.apmobilesecuritysdk.d.C4104e;
import com.alipay.apmobilesecuritysdk.e.C4105a;
import com.alipay.apmobilesecuritysdk.e.C4106b;
import com.alipay.apmobilesecuritysdk.e.C4107c;
import com.alipay.apmobilesecuritysdk.e.C4108d;
import com.alipay.apmobilesecuritysdk.e.C4111g;
import com.alipay.apmobilesecuritysdk.e.C4112h;
import com.alipay.apmobilesecuritysdk.e.C4113i;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.sdk.m.d0.C4173d;
import com.alipay.sdk.m.f0.C4190c;
import com.alipay.sdk.m.f0.C4191d;
import com.alipay.sdk.m.z.C4368a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.alipay.apmobilesecuritysdk.a.a */
/* loaded from: classes12.dex */
public final class C4095a {
    public Context a;
    public C4096a b = C4096a.a();
    public int c = 4;

    public C4095a(Context context) {
        this.a = context;
    }

    public static String a(Context context) {
        String b = b(context);
        return C4368a.a(b) ? C4112h.f(context) : b;
    }

    public static String a(Context context, String str) {
        try {
            b();
            String a = C4113i.a(str);
            if (C4368a.a(a)) {
                String a2 = C4111g.a(context, str);
                C4113i.a(str, a2);
                return !C4368a.a(a2) ? a2 : "";
            }
            return a;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] strArr = {"2017-01-27 2017-01-28", "2017-11-10 2017-11-11", "2017-12-11 2017-12-12"};
        int random = ((int) (Math.random() * 24.0d * 60.0d * 60.0d)) * 1;
        for (int i = 0; i < 3; i++) {
            try {
                String[] split = strArr[i].split(" ");
                if (split != null && split.length == 2) {
                    Date date = new Date();
                    Date parse = simpleDateFormat.parse(split[0] + " 00:00:00");
                    Date parse2 = simpleDateFormat.parse(split[1] + " 23:59:59");
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(parse2);
                    calendar.add(13, random);
                    Date time = calendar.getTime();
                    if (date.after(parse) && date.before(time)) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private C4190c b(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        C4106b b;
        C4106b c;
        String str4 = "";
        try {
            Context context = this.a;
            C4191d c4191d = new C4191d();
            String a = C4368a.a(map, "appName", "");
            String a2 = C4368a.a(map, "sessionId", "");
            String a3 = C4368a.a(map, "rpcVersion", "");
            String a4 = a(context, a);
            String securityToken = UmidSdkWrapper.getSecurityToken(context);
            String d = C4112h.d(context);
            if (C4368a.b(a2)) {
                c4191d.c = a2;
            } else {
                c4191d.c = a4;
            }
            c4191d.d = securityToken;
            c4191d.e = d;
            c4191d.a = "android";
            C4107c c2 = C4108d.c(context);
            if (c2 != null) {
                str2 = c2.a;
                str = c2.c;
            } else {
                str = "";
                str2 = str;
            }
            if (C4368a.a(str2) && (c = C4105a.c(context)) != null) {
                str2 = c.a;
                str = c.c;
            }
            C4107c b2 = C4108d.b();
            if (b2 != null) {
                str4 = b2.a;
                str3 = b2.c;
            } else {
                str3 = "";
            }
            if (C4368a.a(str4) && (b = C4105a.b()) != null) {
                str4 = b.a;
                str3 = b.c;
            }
            c4191d.h = str2;
            c4191d.g = str4;
            c4191d.j = a3;
            if (C4368a.a(str2)) {
                c4191d.b = str4;
                str = str3;
            } else {
                c4191d.b = str2;
            }
            c4191d.i = str;
            c4191d.f = C4104e.a(context, map);
            return C4173d.b(this.a, this.b.c()).a(c4191d);
        } catch (Throwable th) {
            th.printStackTrace();
            C4097a.a(th);
            return null;
        }
    }

    public static String b(Context context) {
        try {
            String b = C4113i.b();
            if (C4368a.a(b)) {
                C4107c b2 = C4108d.b(context);
                if (b2 != null) {
                    C4113i.a(b2);
                    String str = b2.a;
                    if (C4368a.b(str)) {
                        return str;
                    }
                }
                C4106b b3 = C4105a.b(context);
                if (b3 != null) {
                    C4113i.a(b3);
                    String str2 = b3.a;
                    return C4368a.b(str2) ? str2 : "";
                }
                return "";
            }
            return b;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void b() {
        try {
            String[] strArr = {"device_feature_file_name", "wallet_times", "wxcasxx_v3", "wxcasxx_v4", "wxxzyy_v1"};
            for (int i = 0; i < 5; i++) {
                String str = strArr[i];
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                File file = new File(externalStorageDirectory, ".SystemConfig/" + str);
                if (file.exists() && file.canWrite()) {
                    file.delete();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b9, code lost:
        if (com.alipay.sdk.m.z.C4368a.a(b(r9.a)) != false) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d2 A[Catch: Exception -> 0x023a, TryCatch #0 {Exception -> 0x023a, blocks: (B:3:0x0006, B:5:0x0037, B:8:0x0040, B:37:0x00be, B:69:0x01e2, B:71:0x01fd, B:73:0x0203, B:75:0x0209, B:79:0x0212, B:81:0x0218, B:40:0x00d2, B:42:0x00ea, B:48:0x00f7, B:49:0x0107, B:51:0x010e, B:55:0x0120, B:57:0x0170, B:59:0x017a, B:61:0x0182, B:63:0x018f, B:65:0x0199, B:67:0x01a1, B:66:0x019d, B:60:0x017e, B:11:0x0055, B:13:0x0063, B:16:0x006e, B:18:0x0074, B:21:0x007f, B:24:0x0088, B:27:0x0095, B:30:0x00a2, B:33:0x00af), top: B:87:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01fd A[Catch: Exception -> 0x023a, TryCatch #0 {Exception -> 0x023a, blocks: (B:3:0x0006, B:5:0x0037, B:8:0x0040, B:37:0x00be, B:69:0x01e2, B:71:0x01fd, B:73:0x0203, B:75:0x0209, B:79:0x0212, B:81:0x0218, B:40:0x00d2, B:42:0x00ea, B:48:0x00f7, B:49:0x0107, B:51:0x010e, B:55:0x0120, B:57:0x0170, B:59:0x017a, B:61:0x0182, B:63:0x018f, B:65:0x0199, B:67:0x01a1, B:66:0x019d, B:60:0x017e, B:11:0x0055, B:13:0x0063, B:16:0x006e, B:18:0x0074, B:21:0x007f, B:24:0x0088, B:27:0x0095, B:30:0x00a2, B:33:0x00af), top: B:87:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0203 A[Catch: Exception -> 0x023a, TryCatch #0 {Exception -> 0x023a, blocks: (B:3:0x0006, B:5:0x0037, B:8:0x0040, B:37:0x00be, B:69:0x01e2, B:71:0x01fd, B:73:0x0203, B:75:0x0209, B:79:0x0212, B:81:0x0218, B:40:0x00d2, B:42:0x00ea, B:48:0x00f7, B:49:0x0107, B:51:0x010e, B:55:0x0120, B:57:0x0170, B:59:0x017a, B:61:0x0182, B:63:0x018f, B:65:0x0199, B:67:0x01a1, B:66:0x019d, B:60:0x017e, B:11:0x0055, B:13:0x0063, B:16:0x006e, B:18:0x0074, B:21:0x007f, B:24:0x0088, B:27:0x0095, B:30:0x00a2, B:33:0x00af), top: B:87:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0212 A[Catch: Exception -> 0x023a, TryCatch #0 {Exception -> 0x023a, blocks: (B:3:0x0006, B:5:0x0037, B:8:0x0040, B:37:0x00be, B:69:0x01e2, B:71:0x01fd, B:73:0x0203, B:75:0x0209, B:79:0x0212, B:81:0x0218, B:40:0x00d2, B:42:0x00ea, B:48:0x00f7, B:49:0x0107, B:51:0x010e, B:55:0x0120, B:57:0x0170, B:59:0x017a, B:61:0x0182, B:63:0x018f, B:65:0x0199, B:67:0x01a1, B:66:0x019d, B:60:0x017e, B:11:0x0055, B:13:0x0063, B:16:0x006e, B:18:0x0074, B:21:0x007f, B:24:0x0088, B:27:0x0095, B:30:0x00a2, B:33:0x00af), top: B:87:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
            Method dump skipped, instructions count: 577
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.a.C4095a.a(java.util.Map):int");
    }
}

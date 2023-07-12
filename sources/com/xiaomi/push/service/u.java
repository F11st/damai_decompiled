package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.push.fx;
import tb.m80;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class u {
    private static t a;

    /* renamed from: a  reason: collision with other field name */
    private static a f997a;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface a {
        void a();
    }

    private static int a(Context context) {
        return context.getSharedPreferences("mipush_account", 0).getInt("enc_req_fail_count", 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized t m1238a(Context context) {
        synchronized (u.class) {
            t tVar = a;
            if (tVar != null) {
                return tVar;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
            String string = sharedPreferences.getString("uuid", null);
            String string2 = sharedPreferences.getString("token", null);
            String string3 = sharedPreferences.getString("security", null);
            String string4 = sharedPreferences.getString("app_id", null);
            String string5 = sharedPreferences.getString("app_token", null);
            String string6 = sharedPreferences.getString("package_name", null);
            String string7 = sharedPreferences.getString(PushConstants.DEVICE_ID, null);
            int i = sharedPreferences.getInt("env_type", 1);
            if (!TextUtils.isEmpty(string7) && com.xiaomi.push.j.a(string7)) {
                string7 = com.xiaomi.push.j.i(context);
                sharedPreferences.edit().putString(PushConstants.DEVICE_ID, string7).commit();
            }
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                return null;
            }
            String i2 = com.xiaomi.push.j.i(context);
            if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !TextUtils.isEmpty(i2) && !TextUtils.isEmpty(string7) && !string7.equals(i2)) {
                com.xiaomi.channel.commonutils.logger.b.m586a("read_phone_state permission changes.");
            }
            t tVar2 = new t(string, string2, string3, string4, string5, string6, i);
            a = tVar2;
            return tVar2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(37:3|4|(2:8|(34:10|11|(1:13)|14|(1:16)(1:119)|17|(1:19)(1:118)|20|(1:22)(1:117)|23|24|25|26|(1:28)(1:113)|29|(6:31|(1:33)|34|(1:38)|39|(1:41))|42|(1:44)|45|(6:48|49|50|52|53|46)|57|58|(11:63|64|(1:66)|67|68|(2:72|(4:74|75|76|(7:78|(1:80)|81|82|83|84|85)(6:88|89|(1:93)|94|95|96)))|107|(2:91|93)|94|95|96)|112|64|(0)|67|68|(3:70|72|(0))|107|(0)|94|95|96))|120|11|(0)|14|(0)(0)|17|(0)(0)|20|(0)(0)|23|24|25|26|(0)(0)|29|(0)|42|(0)|45|(1:46)|57|58|(12:60|63|64|(0)|67|68|(0)|107|(0)|94|95|96)|112|64|(0)|67|68|(0)|107|(0)|94|95|96) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0093, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0094, code lost:
        com.xiaomi.channel.commonutils.logger.b.a(r0);
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x021b, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x021d, code lost:
        com.xiaomi.channel.commonutils.logger.b.d("device registration request failed. " + r0);
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x031f A[Catch: all -> 0x0334, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:12:0x0044, B:14:0x0055, B:15:0x005a, B:19:0x0066, B:23:0x0072, B:27:0x007e, B:28:0x0088, B:34:0x009c, B:36:0x00a5, B:38:0x00cf, B:40:0x00db, B:41:0x00ee, B:43:0x00f8, B:45:0x00fe, B:46:0x0112, B:48:0x0118, B:49:0x011d, B:51:0x0142, B:52:0x014b, B:53:0x0184, B:55:0x018a, B:56:0x0191, B:59:0x01a0, B:60:0x01d1, B:62:0x01f1, B:65:0x01f8, B:67:0x020f, B:70:0x0216, B:74:0x021d, B:76:0x0234, B:78:0x023a, B:99:0x02f1, B:100:0x0302, B:106:0x031f, B:108:0x0325, B:109:0x032d, B:103:0x0309, B:31:0x0094), top: B:115:0x0005, inners: #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0244 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0055 A[Catch: all -> 0x0334, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:12:0x0044, B:14:0x0055, B:15:0x005a, B:19:0x0066, B:23:0x0072, B:27:0x007e, B:28:0x0088, B:34:0x009c, B:36:0x00a5, B:38:0x00cf, B:40:0x00db, B:41:0x00ee, B:43:0x00f8, B:45:0x00fe, B:46:0x0112, B:48:0x0118, B:49:0x011d, B:51:0x0142, B:52:0x014b, B:53:0x0184, B:55:0x018a, B:56:0x0191, B:59:0x01a0, B:60:0x01d1, B:62:0x01f1, B:65:0x01f8, B:67:0x020f, B:70:0x0216, B:74:0x021d, B:76:0x0234, B:78:0x023a, B:99:0x02f1, B:100:0x0302, B:106:0x031f, B:108:0x0325, B:109:0x032d, B:103:0x0309, B:31:0x0094), top: B:115:0x0005, inners: #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009c A[Catch: all -> 0x0334, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:12:0x0044, B:14:0x0055, B:15:0x005a, B:19:0x0066, B:23:0x0072, B:27:0x007e, B:28:0x0088, B:34:0x009c, B:36:0x00a5, B:38:0x00cf, B:40:0x00db, B:41:0x00ee, B:43:0x00f8, B:45:0x00fe, B:46:0x0112, B:48:0x0118, B:49:0x011d, B:51:0x0142, B:52:0x014b, B:53:0x0184, B:55:0x018a, B:56:0x0191, B:59:0x01a0, B:60:0x01d1, B:62:0x01f1, B:65:0x01f8, B:67:0x020f, B:70:0x0216, B:74:0x021d, B:76:0x0234, B:78:0x023a, B:99:0x02f1, B:100:0x0302, B:106:0x031f, B:108:0x0325, B:109:0x032d, B:103:0x0309, B:31:0x0094), top: B:115:0x0005, inners: #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cf A[Catch: all -> 0x0334, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:12:0x0044, B:14:0x0055, B:15:0x005a, B:19:0x0066, B:23:0x0072, B:27:0x007e, B:28:0x0088, B:34:0x009c, B:36:0x00a5, B:38:0x00cf, B:40:0x00db, B:41:0x00ee, B:43:0x00f8, B:45:0x00fe, B:46:0x0112, B:48:0x0118, B:49:0x011d, B:51:0x0142, B:52:0x014b, B:53:0x0184, B:55:0x018a, B:56:0x0191, B:59:0x01a0, B:60:0x01d1, B:62:0x01f1, B:65:0x01f8, B:67:0x020f, B:70:0x0216, B:74:0x021d, B:76:0x0234, B:78:0x023a, B:99:0x02f1, B:100:0x0302, B:106:0x031f, B:108:0x0325, B:109:0x032d, B:103:0x0309, B:31:0x0094), top: B:115:0x0005, inners: #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0142 A[Catch: all -> 0x0334, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:12:0x0044, B:14:0x0055, B:15:0x005a, B:19:0x0066, B:23:0x0072, B:27:0x007e, B:28:0x0088, B:34:0x009c, B:36:0x00a5, B:38:0x00cf, B:40:0x00db, B:41:0x00ee, B:43:0x00f8, B:45:0x00fe, B:46:0x0112, B:48:0x0118, B:49:0x011d, B:51:0x0142, B:52:0x014b, B:53:0x0184, B:55:0x018a, B:56:0x0191, B:59:0x01a0, B:60:0x01d1, B:62:0x01f1, B:65:0x01f8, B:67:0x020f, B:70:0x0216, B:74:0x021d, B:76:0x0234, B:78:0x023a, B:99:0x02f1, B:100:0x0302, B:106:0x031f, B:108:0x0325, B:109:0x032d, B:103:0x0309, B:31:0x0094), top: B:115:0x0005, inners: #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x018a A[Catch: all -> 0x0334, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:12:0x0044, B:14:0x0055, B:15:0x005a, B:19:0x0066, B:23:0x0072, B:27:0x007e, B:28:0x0088, B:34:0x009c, B:36:0x00a5, B:38:0x00cf, B:40:0x00db, B:41:0x00ee, B:43:0x00f8, B:45:0x00fe, B:46:0x0112, B:48:0x0118, B:49:0x011d, B:51:0x0142, B:52:0x014b, B:53:0x0184, B:55:0x018a, B:56:0x0191, B:59:0x01a0, B:60:0x01d1, B:62:0x01f1, B:65:0x01f8, B:67:0x020f, B:70:0x0216, B:74:0x021d, B:76:0x0234, B:78:0x023a, B:99:0x02f1, B:100:0x0302, B:106:0x031f, B:108:0x0325, B:109:0x032d, B:103:0x0309, B:31:0x0094), top: B:115:0x0005, inners: #4, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0234 A[Catch: all -> 0x0334, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:12:0x0044, B:14:0x0055, B:15:0x005a, B:19:0x0066, B:23:0x0072, B:27:0x007e, B:28:0x0088, B:34:0x009c, B:36:0x00a5, B:38:0x00cf, B:40:0x00db, B:41:0x00ee, B:43:0x00f8, B:45:0x00fe, B:46:0x0112, B:48:0x0118, B:49:0x011d, B:51:0x0142, B:52:0x014b, B:53:0x0184, B:55:0x018a, B:56:0x0191, B:59:0x01a0, B:60:0x01d1, B:62:0x01f1, B:65:0x01f8, B:67:0x020f, B:70:0x0216, B:74:0x021d, B:76:0x0234, B:78:0x023a, B:99:0x02f1, B:100:0x0302, B:106:0x031f, B:108:0x0325, B:109:0x032d, B:103:0x0309, B:31:0x0094), top: B:115:0x0005, inners: #4, #6, #7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized com.xiaomi.push.service.t a(android.content.Context r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 823
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.u.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):com.xiaomi.push.service.t");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m1239a(Context context) {
        t m1238a = m1238a(context);
        if (m1238a != null && !TextUtils.isEmpty(m1238a.f996a)) {
            String[] split = m1238a.f996a.split(m80.DINAMIC_PREFIX_AT);
            if (split.length > 0) {
                return split[0];
            }
        }
        return null;
    }

    private static String a(Context context, boolean z) {
        StringBuilder sb;
        String str;
        String a2 = com.xiaomi.push.service.a.a(context).a();
        String str2 = z ? "/pass/v2/register/encrypt" : "/pass/v2/register";
        if (com.xiaomi.push.ae.b()) {
            sb = new StringBuilder();
            sb.append("http://");
            sb.append(fx.b);
            str = ":9085";
        } else if (com.xiaomi.push.q.China.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://cn.register.xmpush.xiaomi.com";
        } else if (com.xiaomi.push.q.Global.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://register.xmpush.global.xiaomi.com";
        } else if (com.xiaomi.push.q.Europe.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://fr.register.xmpush.global.xiaomi.com";
        } else if (com.xiaomi.push.q.Russia.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://ru.register.xmpush.global.xiaomi.com";
        } else if (com.xiaomi.push.q.India.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://idmb.register.xmpush.global.xiaomi.com";
        } else {
            sb = new StringBuilder();
            sb.append("https://");
            str = com.xiaomi.push.ae.m661a() ? "sandbox.xmpush.xiaomi.com" : "register.xmpush.xiaomi.com";
        }
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static void a() {
        a aVar = f997a;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m1240a(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        a = null;
        a();
    }

    private static void a(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putInt("enc_req_fail_count", i);
        edit.commit();
    }

    public static void a(Context context, t tVar) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString("uuid", tVar.f996a);
        edit.putString("security", tVar.c);
        edit.putString("token", tVar.b);
        edit.putString("app_id", tVar.d);
        edit.putString("package_name", tVar.f);
        edit.putString("app_token", tVar.e);
        edit.putString(PushConstants.DEVICE_ID, com.xiaomi.push.j.i(context));
        edit.putInt("env_type", tVar.a);
        edit.commit();
        a();
    }

    public static void a(a aVar) {
        f997a = aVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m1241a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }
}

package com.vivo.push.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.text.TextUtils;
import com.vivo.push.C7497p;
import com.vivo.push.cache.C7446b;
import com.vivo.push.cache.InterfaceC7448d;
import com.vivo.push.model.C7494b;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.util.t */
/* loaded from: classes11.dex */
public final class C7527t {
    private static Boolean a;
    private static String b;

    public static C7494b a(Context context) {
        C7494b f;
        Context applicationContext = ContextDelegate.getContext(context).getApplicationContext();
        C7494b d = d(applicationContext);
        if (d != null) {
            C7523p.d("PushPackageUtils", "get system push info :".concat(String.valueOf(d)));
            return d;
        }
        List<String> e = e(applicationContext);
        C7494b f2 = f(applicationContext, applicationContext.getPackageName());
        if (e.size() <= 0) {
            if (f2 != null && f2.d()) {
                d = f2;
            }
            C7523p.a("PushPackageUtils", "findAllPushPackages error: find no package!");
        } else {
            C7494b c7494b = null;
            String a2 = C7532y.b(applicationContext).a("com.vivo.push.cur_pkg", null);
            C7494b c7494b2 = (TextUtils.isEmpty(a2) || !a(applicationContext, a2, "com.vivo.pushservice.action.METHOD") || (c7494b2 = f(applicationContext, a2)) == null || !c7494b2.d()) ? null : null;
            f2 = (f2 == null || !f2.d()) ? null : null;
            if (c7494b2 == null) {
                c7494b2 = null;
            }
            if (f2 == null || (c7494b2 != null && (!f2.c() ? !(c7494b2.c() || f2.b() > c7494b2.b()) : !(c7494b2.c() && f2.b() > c7494b2.b())))) {
                f2 = c7494b2;
            }
            HashMap hashMap = new HashMap();
            if (f2 == null) {
                f2 = null;
            } else if (f2.c()) {
                c7494b = f2;
                f2 = null;
            }
            int size = e.size();
            for (int i = 0; i < size; i++) {
                String str = e.get(i);
                if (!TextUtils.isEmpty(str) && (f = f(applicationContext, str)) != null) {
                    hashMap.put(str, f);
                    if (f.d()) {
                        if (f.c()) {
                            if (c7494b == null || f.b() > c7494b.b()) {
                                c7494b = f;
                            }
                        } else if (f2 == null || f.b() > f2.b()) {
                            f2 = f;
                        }
                    }
                }
            }
            if (f2 != null) {
                d = f2;
            } else {
                C7523p.d("PushPackageUtils", "findSuitablePushPackage, all push app in balck list.");
                d = c7494b;
            }
        }
        if (d != null) {
            if (d.c()) {
                C7523p.a(applicationContext, "查找最优包为:" + d.a() + jn1.BRACKET_START_STR + d.b() + ", Black)");
                C7523p.d("PushPackageUtils", "finSuitablePushPackage" + d.a() + jn1.BRACKET_START_STR + d.b() + ", Black)");
            } else {
                C7523p.a(applicationContext, "查找最优包为:" + d.a() + jn1.BRACKET_START_STR + d.b() + jn1.BRACKET_END_STR);
                C7523p.d("PushPackageUtils", "finSuitablePushPackage" + d.a() + jn1.BRACKET_START_STR + d.b() + jn1.BRACKET_END_STR);
            }
        } else {
            C7523p.b(applicationContext, "查找最优包为空!");
            C7523p.d("PushPackageUtils", "finSuitablePushPackage is null");
        }
        return d;
    }

    public static String b(Context context) {
        String str;
        Cursor query;
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        Cursor cursor = null;
        try {
        } catch (Exception e) {
            C7523p.a("PushPackageUtils", "close", e);
        }
        try {
            try {
                query = context.getContentResolver().query(C7497p.a, null, null, null, null);
            } catch (Exception e2) {
                e = e2;
                str = null;
            }
            try {
                if (query == null) {
                    try {
                        C7523p.a("PushPackageUtils", "cursor is null");
                        if (query != null) {
                            try {
                                query.close();
                            } catch (Exception e3) {
                                C7523p.a("PushPackageUtils", "close", e3);
                            }
                        }
                        return null;
                    } catch (Exception e4) {
                        e = e4;
                        str = null;
                    }
                } else {
                    boolean z = false;
                    str = null;
                    while (query.moveToNext()) {
                        try {
                            if ("pushPkgName".equals(query.getString(query.getColumnIndex("name")))) {
                                str = query.getString(query.getColumnIndex("value"));
                            } else if ("pushEnable".equals(query.getString(query.getColumnIndex("name")))) {
                                z = Boolean.parseBoolean(query.getString(query.getColumnIndex("value")));
                            }
                        } catch (Exception e5) {
                            e = e5;
                        }
                    }
                    b = str;
                    if (TextUtils.isEmpty(str)) {
                        try {
                            query.close();
                        } catch (Exception e6) {
                            C7523p.a("PushPackageUtils", "close", e6);
                        }
                        return null;
                    } else if (!z) {
                        try {
                            query.close();
                        } catch (Exception e7) {
                            C7523p.a("PushPackageUtils", "close", e7);
                        }
                        return null;
                    } else {
                        query.close();
                        return str;
                    }
                }
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                return str;
            } catch (Throwable th) {
                th = th;
                cursor = query;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e8) {
                        C7523p.a("PushPackageUtils", "close", e8);
                    }
                }
                throw th;
            }
            C7523p.a("PushPackageUtils", "getSystemPush", e);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean c(Context context, String str) {
        return a(context, str, "com.vivo.pushclient.action.RECEIVE");
    }

    private static C7494b d(Context context) {
        String b2 = b(context);
        ApplicationInfo applicationInfo = null;
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        C7494b c7494b = new C7494b(b2);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(b2, 128);
            if (packageInfo != null) {
                c7494b.a(packageInfo.versionCode);
                c7494b.a(packageInfo.versionName);
                applicationInfo = packageInfo.applicationInfo;
            }
            if (applicationInfo != null) {
                c7494b.a(C7533z.a(context, b2));
            }
            c7494b.a(a(context, c7494b.b()));
            c7494b.b(a(context, b2));
            return c7494b;
        } catch (Exception e) {
            e.printStackTrace();
            C7523p.b("PushPackageUtils", "PackageManager NameNotFoundException is null", e);
            return null;
        }
    }

    public static boolean e(Context context, String str) {
        return a(context, str, "com.vivo.pushservice.action.METHOD");
    }

    private static C7494b f(Context context, String str) {
        ApplicationInfo applicationInfo;
        if (!TextUtils.isEmpty(str)) {
            if (a(context, str, "com.vivo.pushservice.action.METHOD") || a(context, str, "com.vivo.pushservice.action.RECEIVE")) {
                C7494b c7494b = new C7494b(str);
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
                    if (packageInfo != null) {
                        c7494b.a(packageInfo.versionCode);
                        c7494b.a(packageInfo.versionName);
                        applicationInfo = packageInfo.applicationInfo;
                    } else {
                        applicationInfo = null;
                    }
                    if (applicationInfo != null) {
                        c7494b.a(C7533z.a(context, str));
                    }
                    c7494b.b(a(context, str));
                    c7494b.a(a(context, c7494b.b()));
                    return c7494b;
                } catch (Exception e) {
                    C7523p.a("PushPackageUtils", "getPushPackageInfo exception: ", e);
                }
            }
        }
        return null;
    }

    private static String g(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                byte[] digest = MessageDigest.getInstance("SHA256").digest(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray());
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b2 : digest) {
                    String upperCase = Integer.toHexString(b2 & 255).toUpperCase(Locale.US);
                    if (upperCase.length() == 1) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(upperCase);
                }
                return stringBuffer.toString();
            } catch (Exception e) {
                C7523p.a("PushPackageUtils", " getSignatureSHA exception ".concat(String.valueOf(e)));
            }
        }
        return null;
    }

    public static boolean c(Context context) {
        ProviderInfo resolveContentProvider;
        Boolean bool = a;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = null;
        if (context != null && !TextUtils.isEmpty("com.vivo.push.sdk.service.SystemPushConfig") && (resolveContentProvider = context.getPackageManager().resolveContentProvider("com.vivo.push.sdk.service.SystemPushConfig", 128)) != null) {
            str = resolveContentProvider.packageName;
        }
        Boolean valueOf = Boolean.valueOf("BCC35D4D3606F154F0402AB7634E8490C0B244C2675C3C6238986987024F0C02".equals(g(context, str)));
        a = valueOf;
        return valueOf.booleanValue();
    }

    private static List<String> e(Context context) {
        List<ResolveInfo> list;
        C7514g.a("findAllCoreClientPush");
        ArrayList arrayList = new ArrayList();
        try {
            list = context.getPackageManager().queryIntentServices(new Intent("com.vivo.pushservice.action.PUSH_SERVICE"), 576);
        } catch (Exception unused) {
            list = null;
        }
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ResolveInfo resolveInfo = list.get(i);
                if (resolveInfo != null) {
                    String str = resolveInfo.serviceInfo.packageName;
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                    }
                }
            }
        }
        if (arrayList.size() <= 0) {
            C7523p.d("PushPackageUtils", "get all push packages is null");
        }
        return arrayList;
    }

    public static boolean d(Context context, String str) {
        return a(context, str, "com.vivo.pushservice.action.RECEIVE");
    }

    public static int b(Context context, String str) {
        int i = a(context, str, "com.vivo.pushservice.action.RECEIVE") ? 0 : -1;
        if (a(context, str, "com.vivo.pushclient.action.RECEIVE")) {
            return 1;
        }
        return i;
    }

    public static boolean a(Context context, String str) {
        ServiceInfo serviceInfo;
        if (!TextUtils.isEmpty(str) && context != null) {
            Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent.setPackage(str);
            PackageManager packageManager = context.getPackageManager();
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 576);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                int size = queryIntentServices.size();
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    ResolveInfo resolveInfo = queryIntentServices.get(i);
                    if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null) {
                        String str2 = serviceInfo.name;
                        boolean z2 = serviceInfo.exported;
                        if ("com.vivo.push.sdk.service.PushService".equals(str2) && z2) {
                            boolean z3 = resolveInfo.serviceInfo.enabled;
                            int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(str, "com.vivo.push.sdk.service.PushService"));
                            z = componentEnabledSetting == 1 || (componentEnabledSetting == 0 && z3);
                        }
                    }
                }
                return z;
            }
            C7523p.a("PushPackageUtils", "isEnablePush error: can not find push service.");
        }
        return false;
    }

    private static boolean a(Context context, long j) {
        InterfaceC7448d a2 = C7446b.a().a(context);
        if (a2 != null) {
            return a2.isInBlackList(j);
        }
        return false;
    }

    private static boolean a(Context context, String str, String str2) {
        List<ResolveInfo> list;
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            list = context.getPackageManager().queryBroadcastReceivers(intent, 576);
        } catch (Exception unused) {
            list = null;
        }
        return list != null && list.size() > 0;
    }
}

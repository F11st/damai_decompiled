package com.vivo.push.util;

import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tb.gn1;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.util.j */
/* loaded from: classes11.dex */
public final class C7517j {
    private static Method e;
    public static final boolean a = b("rom_1.0");
    public static final boolean b = b("rom_2.0");
    public static final boolean c = b("rom_2.5");
    public static final boolean d = b("rom_3.0");
    private static String f = null;
    private static String g = null;

    public static String a(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    private static boolean b(String str) {
        String b2 = C7533z.b("ro.vivo.rom", "");
        String b3 = C7533z.b("ro.vivo.rom.version", "");
        C7523p.d("Device", "ro.vivo.rom = " + b2 + " ; ro.vivo.rom.version = " + b3);
        if (b2 == null || !b2.contains(str)) {
            return b3 != null && b3.contains(str);
        }
        return true;
    }

    public static synchronized String a() {
        synchronized (C7517j.class) {
            if (f == null && g == null) {
                try {
                    Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class);
                    e = declaredMethod;
                    declaredMethod.setAccessible(true);
                    f = (String) e.invoke(null, "ro.vivo.rom", "@><@");
                    g = (String) e.invoke(null, "ro.vivo.rom.version", "@><@");
                } catch (Exception unused) {
                    C7523p.b("Device", "getRomCode error");
                }
            }
            C7523p.d("Device", "sRomProperty1 : " + f + " ; sRomProperty2 : " + g);
            String a2 = a(f);
            if (TextUtils.isEmpty(a2)) {
                String a3 = a(g);
                if (TextUtils.isEmpty(a3)) {
                    return null;
                }
                return a3;
            }
            return a2;
        }
    }

    public static boolean b() {
        String manufacturer = Build.getMANUFACTURER();
        if (TextUtils.isEmpty(manufacturer)) {
            C7523p.d("Device", "Build.MANUFACTURER is null");
            return false;
        }
        C7523p.d("Device", "Build.MANUFACTURER is " + manufacturer);
        return manufacturer.toLowerCase().contains("bbk") || manufacturer.toLowerCase().startsWith("vivo");
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("rom_([\\d]*).?([\\d]*)", 2).matcher(str);
        if (matcher.find()) {
            StringBuilder sb = new StringBuilder();
            sb.append(matcher.group(1));
            sb.append(TextUtils.isEmpty(matcher.group(2)) ? "0" : matcher.group(2).substring(0, 1));
            return sb.toString();
        }
        return null;
    }
}

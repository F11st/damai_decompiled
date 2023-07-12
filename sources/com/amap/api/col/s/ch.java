package com.amap.api.col.s;

import android.os.Build;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class ch {
    private static volatile cg a;
    private static Properties b = b();

    private ch() {
    }

    public static cg a() {
        if (a == null) {
            synchronized (ch.class) {
                if (a == null) {
                    try {
                        cg a2 = a(Build.getMANUFACTURER());
                        if ("".equals(a2.a())) {
                            Iterator it = Arrays.asList(cg.MIUI.a(), cg.Flyme.a(), cg.EMUI.a(), cg.ColorOS.a(), cg.FuntouchOS.a(), cg.SmartisanOS.a(), cg.AmigoOS.a(), cg.Sense.a(), cg.LG.a(), cg.Google.a(), cg.NubiaUI.a()).iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    cg a3 = a((String) it.next());
                                    if (!"".equals(a3.a())) {
                                        a2 = a3;
                                        break;
                                    }
                                } else {
                                    a2 = cg.Other;
                                    break;
                                }
                            }
                        }
                        a = a2;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return a;
    }

    private static String b(String str) {
        Properties properties = b;
        String property = properties.getProperty(jn1.ARRAY_START_STR + str + jn1.ARRAY_END_STR, null);
        if (TextUtils.isEmpty(property)) {
            return c(str);
        }
        return property.replace(jn1.ARRAY_START_STR, "").replace(jn1.ARRAY_END_STR, "");
    }

    private static String c(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
        } catch (IOException unused) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
            }
            return readLine;
        } catch (IOException unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    private static boolean d(cg cgVar) {
        String b2 = b("ro.build.version.opporom");
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        a(cgVar, b2);
        cgVar.b(b2);
        return true;
    }

    private static boolean e(cg cgVar) {
        String b2 = b("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        a(cgVar, b2);
        cgVar.b(b2);
        return true;
    }

    private static boolean f(cg cgVar) {
        String b2 = b("ro.smartisan.version");
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        a(cgVar, b2);
        cgVar.b(b2);
        return true;
    }

    private static boolean g(cg cgVar) {
        String b2 = b("ro.build.display.id");
        if (TextUtils.isEmpty(b2) || !b2.matches("amigo([\\d.]+)[a-zA-Z]*")) {
            return false;
        }
        a(cgVar, b2);
        cgVar.b(b2);
        return true;
    }

    private static boolean h(cg cgVar) {
        String b2 = b("ro.letv.release.version");
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        a(cgVar, b2);
        cgVar.b(b2);
        return true;
    }

    private static boolean i(cg cgVar) {
        String b2 = b("ro.build.sense.version");
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        a(cgVar, b2);
        cgVar.b(b2);
        return true;
    }

    private static boolean j(cg cgVar) {
        String b2 = b("sys.lge.lgmdm_version");
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        a(cgVar, b2);
        cgVar.b(b2);
        return true;
    }

    private static boolean k(cg cgVar) {
        if ("android-google".equals(b("ro.com.google.clientidbase"))) {
            String b2 = b("ro.build.version.release");
            cgVar.a(Build.VERSION.SDK_INT);
            cgVar.b(b2);
            return true;
        }
        return false;
    }

    private static boolean l(cg cgVar) {
        String b2 = b("ro.build.nubia.rom.code");
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        a(cgVar, b2);
        cgVar.b(b2);
        return true;
    }

    private static Properties b() {
        Properties properties = new Properties();
        try {
            properties.load(Runtime.getRuntime().exec("getprop").getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    private static boolean c(cg cgVar) {
        String b2 = b(com.alipay.sdk.m.c.a.a);
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        a(cgVar, b2);
        cgVar.b(b2);
        return true;
    }

    private static boolean b(cg cgVar) {
        String b2 = b("ro.flyme.published");
        String b3 = b("ro.meizu.setupwizard.flyme");
        if (TextUtils.isEmpty(b2) && TextUtils.isEmpty(b3)) {
            return false;
        }
        String b4 = b("ro.build.display.id");
        a(cgVar, b4);
        cgVar.b(b4);
        return true;
    }

    private static cg a(String str) {
        if (str != null && str.length() > 0) {
            cg cgVar = cg.MIUI;
            if (str.equals(cgVar.a())) {
                if (a(cgVar)) {
                    return cgVar;
                }
            } else {
                cg cgVar2 = cg.Flyme;
                if (str.equals(cgVar2.a())) {
                    if (b(cgVar2)) {
                        return cgVar2;
                    }
                } else {
                    cg cgVar3 = cg.EMUI;
                    if (str.equals(cgVar3.a())) {
                        if (c(cgVar3)) {
                            return cgVar3;
                        }
                    } else {
                        cg cgVar4 = cg.ColorOS;
                        if (str.equals(cgVar4.a())) {
                            if (d(cgVar4)) {
                                return cgVar4;
                            }
                        } else {
                            cg cgVar5 = cg.FuntouchOS;
                            if (str.equals(cgVar5.a())) {
                                if (e(cgVar5)) {
                                    return cgVar5;
                                }
                            } else {
                                cg cgVar6 = cg.SmartisanOS;
                                if (str.equals(cgVar6.a())) {
                                    if (f(cgVar6)) {
                                        return cgVar6;
                                    }
                                } else {
                                    cg cgVar7 = cg.AmigoOS;
                                    if (str.equals(cgVar7.a())) {
                                        if (g(cgVar7)) {
                                            return cgVar7;
                                        }
                                    } else {
                                        cg cgVar8 = cg.EUI;
                                        if (str.equals(cgVar8.a())) {
                                            if (h(cgVar8)) {
                                                return cgVar8;
                                            }
                                        } else {
                                            cg cgVar9 = cg.Sense;
                                            if (str.equals(cgVar9.a())) {
                                                if (i(cgVar9)) {
                                                    return cgVar9;
                                                }
                                            } else {
                                                cg cgVar10 = cg.LG;
                                                if (str.equals(cgVar10.a())) {
                                                    if (j(cgVar10)) {
                                                        return cgVar10;
                                                    }
                                                } else {
                                                    cg cgVar11 = cg.Google;
                                                    if (str.equals(cgVar11.a())) {
                                                        if (k(cgVar11)) {
                                                            return cgVar11;
                                                        }
                                                    } else {
                                                        cg cgVar12 = cg.NubiaUI;
                                                        if (str.equals(cgVar12.a()) && l(cgVar12)) {
                                                            return cgVar12;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return cg.Other;
        }
        return cg.Other;
    }

    private static void a(cg cgVar, String str) {
        Matcher matcher = Pattern.compile("([\\d.]+)[^\\d]*").matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group(1);
                cgVar.a(group);
                cgVar.a(Integer.parseInt(group.split("\\.")[0]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean a(cg cgVar) {
        if (TextUtils.isEmpty(b("ro.miui.ui.version.name"))) {
            return false;
        }
        String b2 = b("ro.build.version.incremental");
        a(cgVar, b2);
        cgVar.b(b2);
        return true;
    }
}

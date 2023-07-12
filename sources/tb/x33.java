package tb;

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

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class x33 {
    private static volatile com.loc.ah a;
    private static Properties b = f();

    private x33() {
    }

    public static com.loc.ah a() {
        if (a == null) {
            synchronized (x33.class) {
                if (a == null) {
                    try {
                        com.loc.ah b2 = b(Build.getMANUFACTURER());
                        if ("".equals(b2.a())) {
                            Iterator it = Arrays.asList(com.loc.ah.MIUI.a(), com.loc.ah.Flyme.a(), com.loc.ah.EMUI.a(), com.loc.ah.ColorOS.a(), com.loc.ah.FuntouchOS.a(), com.loc.ah.SmartisanOS.a(), com.loc.ah.AmigoOS.a(), com.loc.ah.Sense.a(), com.loc.ah.LG.a(), com.loc.ah.Google.a(), com.loc.ah.NubiaUI.a()).iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    b2 = com.loc.ah.Other;
                                    break;
                                }
                                com.loc.ah b3 = b((String) it.next());
                                if (!"".equals(b3.a())) {
                                    b2 = b3;
                                    break;
                                }
                            }
                        }
                        a = b2;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return a;
    }

    private static com.loc.ah b(String str) {
        if (str == null || str.length() <= 0) {
            return com.loc.ah.Other;
        }
        com.loc.ah ahVar = com.loc.ah.MIUI;
        if (!str.equals(ahVar.a())) {
            com.loc.ah ahVar2 = com.loc.ah.Flyme;
            if (!str.equals(ahVar2.a())) {
                com.loc.ah ahVar3 = com.loc.ah.EMUI;
                if (!str.equals(ahVar3.a())) {
                    com.loc.ah ahVar4 = com.loc.ah.ColorOS;
                    if (!str.equals(ahVar4.a())) {
                        com.loc.ah ahVar5 = com.loc.ah.FuntouchOS;
                        if (!str.equals(ahVar5.a())) {
                            com.loc.ah ahVar6 = com.loc.ah.SmartisanOS;
                            if (!str.equals(ahVar6.a())) {
                                com.loc.ah ahVar7 = com.loc.ah.AmigoOS;
                                if (!str.equals(ahVar7.a())) {
                                    com.loc.ah ahVar8 = com.loc.ah.EUI;
                                    if (!str.equals(ahVar8.a())) {
                                        com.loc.ah ahVar9 = com.loc.ah.Sense;
                                        if (!str.equals(ahVar9.a())) {
                                            com.loc.ah ahVar10 = com.loc.ah.LG;
                                            if (!str.equals(ahVar10.a())) {
                                                com.loc.ah ahVar11 = com.loc.ah.Google;
                                                if (!str.equals(ahVar11.a())) {
                                                    com.loc.ah ahVar12 = com.loc.ah.NubiaUI;
                                                    if (str.equals(ahVar12.a()) && r(ahVar12)) {
                                                        return ahVar12;
                                                    }
                                                } else if (q(ahVar11)) {
                                                    return ahVar11;
                                                }
                                            } else if (p(ahVar10)) {
                                                return ahVar10;
                                            }
                                        } else if (o(ahVar9)) {
                                            return ahVar9;
                                        }
                                    } else if (n(ahVar8)) {
                                        return ahVar8;
                                    }
                                } else if (m(ahVar7)) {
                                    return ahVar7;
                                }
                            } else if (l(ahVar6)) {
                                return ahVar6;
                            }
                        } else if (k(ahVar5)) {
                            return ahVar5;
                        }
                    } else if (j(ahVar4)) {
                        return ahVar4;
                    }
                } else if (i(ahVar3)) {
                    return ahVar3;
                }
            } else if (g(ahVar2)) {
                return ahVar2;
            }
        } else if (d(ahVar)) {
            return ahVar;
        }
        return com.loc.ah.Other;
    }

    private static void c(com.loc.ah ahVar, String str) {
        Matcher matcher = Pattern.compile("([\\d.]+)[^\\d]*").matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group(1);
                ahVar.a(group);
                ahVar.a(Integer.parseInt(group.split("\\.")[0]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean d(com.loc.ah ahVar) {
        if (TextUtils.isEmpty(e("ro.miui.ui.version.name"))) {
            return false;
        }
        String e = e("ro.build.version.incremental");
        c(ahVar, e);
        ahVar.b(e);
        return true;
    }

    private static String e(String str) {
        Properties properties = b;
        String property = properties.getProperty(jn1.ARRAY_START_STR + str + jn1.ARRAY_END_STR, null);
        return TextUtils.isEmpty(property) ? h(str) : property.replace(jn1.ARRAY_START_STR, "").replace(jn1.ARRAY_END_STR, "");
    }

    private static Properties f() {
        Properties properties = new Properties();
        try {
            properties.load(Runtime.getRuntime().exec("getprop").getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    private static boolean g(com.loc.ah ahVar) {
        String e = e("ro.flyme.published");
        String e2 = e("ro.meizu.setupwizard.flyme");
        if (TextUtils.isEmpty(e) && TextUtils.isEmpty(e2)) {
            return false;
        }
        String e3 = e("ro.build.display.id");
        c(ahVar, e3);
        ahVar.b(e3);
        return true;
    }

    private static String h(String str) {
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

    private static boolean i(com.loc.ah ahVar) {
        String e = e(com.alipay.sdk.m.c.a.a);
        if (TextUtils.isEmpty(e)) {
            return false;
        }
        c(ahVar, e);
        ahVar.b(e);
        return true;
    }

    private static boolean j(com.loc.ah ahVar) {
        String e = e("ro.build.version.opporom");
        if (TextUtils.isEmpty(e)) {
            return false;
        }
        c(ahVar, e);
        ahVar.b(e);
        return true;
    }

    private static boolean k(com.loc.ah ahVar) {
        String e = e("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(e)) {
            return false;
        }
        c(ahVar, e);
        ahVar.b(e);
        return true;
    }

    private static boolean l(com.loc.ah ahVar) {
        String e = e("ro.smartisan.version");
        if (TextUtils.isEmpty(e)) {
            return false;
        }
        c(ahVar, e);
        ahVar.b(e);
        return true;
    }

    private static boolean m(com.loc.ah ahVar) {
        String e = e("ro.build.display.id");
        if (TextUtils.isEmpty(e) || !e.matches("amigo([\\d.]+)[a-zA-Z]*")) {
            return false;
        }
        c(ahVar, e);
        ahVar.b(e);
        return true;
    }

    private static boolean n(com.loc.ah ahVar) {
        String e = e("ro.letv.release.version");
        if (TextUtils.isEmpty(e)) {
            return false;
        }
        c(ahVar, e);
        ahVar.b(e);
        return true;
    }

    private static boolean o(com.loc.ah ahVar) {
        String e = e("ro.build.sense.version");
        if (TextUtils.isEmpty(e)) {
            return false;
        }
        c(ahVar, e);
        ahVar.b(e);
        return true;
    }

    private static boolean p(com.loc.ah ahVar) {
        String e = e("sys.lge.lgmdm_version");
        if (TextUtils.isEmpty(e)) {
            return false;
        }
        c(ahVar, e);
        ahVar.b(e);
        return true;
    }

    private static boolean q(com.loc.ah ahVar) {
        if ("android-google".equals(e("ro.com.google.clientidbase"))) {
            String e = e("ro.build.version.release");
            ahVar.a(Build.VERSION.SDK_INT);
            ahVar.b(e);
            return true;
        }
        return false;
    }

    private static boolean r(com.loc.ah ahVar) {
        String e = e("ro.build.nubia.rom.code");
        if (TextUtils.isEmpty(e)) {
            return false;
        }
        c(ahVar, e);
        ahVar.b(e);
        return true;
    }
}

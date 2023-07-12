package com.youku.live.dago.widgetlib.util;

import android.os.Build;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class RomUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
    private static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    private static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
    public static final String ROM_EMUI = "EMUI";
    public static final String ROM_FLYME = "FLYME";
    public static final String ROM_MIUI = "MIUI";
    public static final String ROM_OPPO = "OPPO";
    public static final String ROM_QIKU = "QIKU";
    public static final String ROM_SMARTISAN = "SMARTISAN";
    public static final String ROM_VIVO = "VIVO";
    private static final String TAG = "Rom";
    private static String sName;
    private static String sVersion;

    public static boolean check(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1790318483")) {
            return ((Boolean) ipChange.ipc$dispatch("-1790318483", new Object[]{str})).booleanValue();
        }
        String str2 = sName;
        if (str2 != null) {
            return str2.equals(str);
        }
        String prop = getProp(KEY_VERSION_MIUI);
        sVersion = prop;
        if (!TextUtils.isEmpty(prop)) {
            sName = "MIUI";
        } else {
            String prop2 = getProp("ro.build.version.emui");
            sVersion = prop2;
            if (!TextUtils.isEmpty(prop2)) {
                sName = "EMUI";
            } else {
                String prop3 = getProp(KEY_VERSION_OPPO);
                sVersion = prop3;
                if (!TextUtils.isEmpty(prop3)) {
                    sName = "OPPO";
                } else {
                    String prop4 = getProp(KEY_VERSION_VIVO);
                    sVersion = prop4;
                    if (!TextUtils.isEmpty(prop4)) {
                        sName = "VIVO";
                    } else {
                        String prop5 = getProp(KEY_VERSION_SMARTISAN);
                        sVersion = prop5;
                        if (!TextUtils.isEmpty(prop5)) {
                            sName = "SMARTISAN";
                        } else {
                            String str3 = Build.DISPLAY;
                            sVersion = str3;
                            if (str3.toUpperCase().contains("FLYME")) {
                                sName = "FLYME";
                            } else {
                                sVersion = "unknown";
                                sName = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER().toUpperCase();
                            }
                        }
                    }
                }
            }
        }
        return sName.equals(str);
    }

    public static String getName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "602214938")) {
            return (String) ipChange.ipc$dispatch("602214938", new Object[0]);
        }
        if (sName == null) {
            check("");
        }
        return sName;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getProp(java.lang.String r6) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.dago.widgetlib.util.RomUtil.$ipChange
            java.lang.String r1 = "776770024"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L17
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r6
            java.lang.Object r6 = r0.ipc$dispatch(r1, r2)
            java.lang.String r6 = (java.lang.String) r6
            return r6
        L17:
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            r2.<init>()     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            java.lang.String r3 = "getprop "
            r2.append(r3)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            r2.append(r6)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            java.lang.Process r1 = r1.exec(r2)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            java.io.InputStream r1 = r1.getInputStream()     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            r1 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3, r1)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            java.lang.String r1 = r2.readLine()     // Catch: java.io.IOException -> L51 java.lang.Throwable -> L78
            r2.close()     // Catch: java.io.IOException -> L51 java.lang.Throwable -> L78
            r2.close()     // Catch: java.io.IOException -> L4c
            goto L50
        L4c:
            r6 = move-exception
            r6.printStackTrace()
        L50:
            return r1
        L51:
            r1 = move-exception
            goto L57
        L53:
            r6 = move-exception
            goto L7a
        L55:
            r1 = move-exception
            r2 = r0
        L57:
            java.lang.String r3 = "Rom"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L78
            r4.<init>()     // Catch: java.lang.Throwable -> L78
            java.lang.String r5 = "Unable to read prop "
            r4.append(r5)     // Catch: java.lang.Throwable -> L78
            r4.append(r6)     // Catch: java.lang.Throwable -> L78
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L78
            android.util.Log.e(r3, r6, r1)     // Catch: java.lang.Throwable -> L78
            if (r2 == 0) goto L77
            r2.close()     // Catch: java.io.IOException -> L73
            goto L77
        L73:
            r6 = move-exception
            r6.printStackTrace()
        L77:
            return r0
        L78:
            r6 = move-exception
            r0 = r2
        L7a:
            if (r0 == 0) goto L84
            r0.close()     // Catch: java.io.IOException -> L80
            goto L84
        L80:
            r0 = move-exception
            r0.printStackTrace()
        L84:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgetlib.util.RomUtil.getProp(java.lang.String):java.lang.String");
    }

    public static String getVersion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "522150623")) {
            return (String) ipChange.ipc$dispatch("522150623", new Object[0]);
        }
        if (sVersion == null) {
            check("");
        }
        return sVersion;
    }

    public static boolean is360() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1841090248") ? ((Boolean) ipChange.ipc$dispatch("1841090248", new Object[0])).booleanValue() : check("QIKU") || check("360");
    }

    public static boolean isEmui() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1674680193") ? ((Boolean) ipChange.ipc$dispatch("1674680193", new Object[0])).booleanValue() : check("EMUI");
    }

    public static boolean isFlyme() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1350810634") ? ((Boolean) ipChange.ipc$dispatch("1350810634", new Object[0])).booleanValue() : check("FLYME");
    }

    public static boolean isMiui() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "70258445") ? ((Boolean) ipChange.ipc$dispatch("70258445", new Object[0])).booleanValue() : check("MIUI");
    }

    public static boolean isOppo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2041231005") ? ((Boolean) ipChange.ipc$dispatch("2041231005", new Object[0])).booleanValue() : check("OPPO");
    }

    public static boolean isSmartisan() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1414341867") ? ((Boolean) ipChange.ipc$dispatch("-1414341867", new Object[0])).booleanValue() : check("SMARTISAN");
    }

    public static boolean isVivo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-531040751") ? ((Boolean) ipChange.ipc$dispatch("-531040751", new Object[0])).booleanValue() : check("VIVO");
    }
}

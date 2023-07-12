package com.youku.live.livesdk.wkit.utils;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
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
        if (AndroidInstantRuntime.support(ipChange, "-1528671745")) {
            return ((Boolean) ipChange.ipc$dispatch("-1528671745", new Object[]{str})).booleanValue();
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
        if (AndroidInstantRuntime.support(ipChange, "123329224")) {
            return (String) ipChange.ipc$dispatch("123329224", new Object[0]);
        }
        if (sName == null) {
            check("");
        }
        return sName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public static String getProp(String str) {
        BufferedReader bufferedReader;
        IpChange ipChange = $ipChange;
        Process process = "-2098345194";
        ?? support = AndroidInstantRuntime.support(ipChange, "-2098345194");
        if (support != 0) {
            return (String) ipChange.ipc$dispatch("-2098345194", new Object[]{str});
        }
        BufferedReader bufferedReader2 = null;
        try {
            try {
                process = Runtime.getRuntime().exec("getprop " + str);
            } catch (IOException e) {
                e = e;
                process = 0;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                process = 0;
            }
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()), 1024);
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                if (process != 0) {
                    try {
                        process.destroy();
                    } catch (Throwable unused) {
                    }
                }
                throw th;
            }
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                try {
                    process.destroy();
                } catch (Throwable unused2) {
                }
                return readLine;
            } catch (IOException e5) {
                e = e5;
                Log.e(TAG, "Unable to read prop " + str, e);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                if (process != 0) {
                    try {
                        process.destroy();
                    } catch (Throwable unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = support;
        }
    }

    public static String getVersion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1919202161")) {
            return (String) ipChange.ipc$dispatch("1919202161", new Object[0]);
        }
        if (sVersion == null) {
            check("");
        }
        return sVersion;
    }

    public static boolean is360() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2055788762") ? ((Boolean) ipChange.ipc$dispatch("2055788762", new Object[0])).booleanValue() : check("QIKU") || check("360");
    }

    public static boolean isEmui() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-259600465") ? ((Boolean) ipChange.ipc$dispatch("-259600465", new Object[0])).booleanValue() : check("EMUI");
    }

    public static boolean isFlyme() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1517652380") ? ((Boolean) ipChange.ipc$dispatch("1517652380", new Object[0])).booleanValue() : check("FLYME");
    }

    public static boolean isMiui() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1864022213") ? ((Boolean) ipChange.ipc$dispatch("-1864022213", new Object[0])).booleanValue() : check("MIUI");
    }

    public static boolean isOppo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "106950347") ? ((Boolean) ipChange.ipc$dispatch("106950347", new Object[0])).booleanValue() : check("OPPO");
    }

    public static boolean isSmartisan() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1509978201") ? ((Boolean) ipChange.ipc$dispatch("-1509978201", new Object[0])).booleanValue() : check("SMARTISAN");
    }

    public static boolean isVivo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1829645887") ? ((Boolean) ipChange.ipc$dispatch("1829645887", new Object[0])).booleanValue() : check("VIVO");
    }
}

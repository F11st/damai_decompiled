package com.youku.live.livesdk.wkit.component.common.utils;

import android.os.Build;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class OSUtils {
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
    private static String sName;
    private static String sVersion;

    public static boolean check(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-675072898")) {
            return ((Boolean) ipChange.ipc$dispatch("-675072898", new Object[]{str})).booleanValue();
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
        if (AndroidInstantRuntime.support(ipChange, "815089705")) {
            return (String) ipChange.ipc$dispatch("815089705", new Object[0]);
        }
        if (sName == null) {
            check("");
        }
        return sName;
    }

    public static String getProp(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        Process process;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1821835831")) {
            return (String) ipChange.ipc$dispatch("1821835831", new Object[]{str});
        }
        try {
            process = Runtime.getRuntime().exec("getprop " + str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()), 1024);
            } catch (IOException unused) {
                bufferedReader = null;
            } catch (Throwable th2) {
                bufferedReader = null;
                th = th2;
            }
        } catch (IOException unused2) {
            process = null;
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            process = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                process.destroy();
            } catch (Throwable unused3) {
            }
            return readLine;
        } catch (IOException unused4) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            if (process != null) {
                try {
                    process.destroy();
                } catch (Throwable unused5) {
                }
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            if (process != null) {
                try {
                    process.destroy();
                } catch (Throwable unused6) {
                }
            }
            throw th;
        }
    }

    public static String getVersion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1392361872")) {
            return (String) ipChange.ipc$dispatch("-1392361872", new Object[0]);
        }
        if (sVersion == null) {
            check("");
        }
        return sVersion;
    }

    public static boolean is360() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1991725799") ? ((Boolean) ipChange.ipc$dispatch("-1991725799", new Object[0])).booleanValue() : check("QIKU") || check("360");
    }

    public static boolean isEmui() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1178500272") ? ((Boolean) ipChange.ipc$dispatch("-1178500272", new Object[0])).booleanValue() : check("EMUI");
    }

    public static boolean isFlyme() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1198437861") ? ((Boolean) ipChange.ipc$dispatch("-1198437861", new Object[0])).booleanValue() : check("FLYME");
    }

    public static boolean isMiui() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1512045276") ? ((Boolean) ipChange.ipc$dispatch("1512045276", new Object[0])).booleanValue() : check("MIUI");
    }

    public static boolean isOppo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-811949460") ? ((Boolean) ipChange.ipc$dispatch("-811949460", new Object[0])).booleanValue() : check("OPPO");
    }

    public static boolean isSmartisan() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "389609638") ? ((Boolean) ipChange.ipc$dispatch("389609638", new Object[0])).booleanValue() : check("SMARTISAN");
    }

    public static boolean isVivo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "910746080") ? ((Boolean) ipChange.ipc$dispatch("910746080", new Object[0])).booleanValue() : check("VIVO");
    }
}

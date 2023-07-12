package android.taobao.windvane.extra.uc;

import android.os.Build;
import android.os.Process;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.util.TaoLog;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVUCUtils {
    public static final String CONFIG_KEY = "ISX86";
    public static final String TAG = "WVUCUtils";
    public static final long VAL_ARM = 2;
    public static final long VAL_DEAFAULT = 0;
    public static final long VAL_X86 = 1;
    private static String sAbi;
    private static String sAbi2;
    private static String[] sAbiList;
    private static String sArch;
    private static String sCpuAbi;
    private static String[] sSupportedABIs;

    private static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String getFromSystemProp(String str) {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        try {
            fileInputStream = new FileInputStream(new File("/system/build.prop"));
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            } else if (readLine.contains(str)) {
                                String[] split = readLine.split("=");
                                if (split.length == 2 && split[0].trim().equals(str)) {
                                    return split[1].trim();
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            try {
                                th.printStackTrace();
                                return null;
                            } finally {
                                close(bufferedReader);
                                close(inputStreamReader);
                                close(fileInputStream);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStreamReader = null;
            fileInputStream = null;
            bufferedReader = null;
        }
        return null;
    }

    public static boolean is64Bit() {
        int i = Build.VERSION.SDK_INT;
        if (i < 23) {
            if (i >= 21) {
                return isART64();
            }
            return false;
        }
        boolean is64Bit = Process.is64Bit();
        TaoLog.i(TAG, "is 64 bit = [" + is64Bit + jn1.ARRAY_END_STR);
        return is64Bit;
    }

    private static boolean is64bitCPU() {
        String cpu_abi;
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            cpu_abi = strArr.length > 0 ? strArr[0] : null;
        } else {
            cpu_abi = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getCPU_ABI();
        }
        return cpu_abi != null && cpu_abi.contains("arm64");
    }

    private static boolean isART64() {
        try {
            Object invoke = ClassLoader.class.getDeclaredMethod("findLibrary", String.class).invoke(GlobalConfig.context.getClassLoader(), "art");
            if (invoke != null) {
                return ((String) invoke).contains("lib64");
            }
            return false;
        } catch (Exception unused) {
            return is64bitCPU();
        }
    }

    public static boolean isArchContains(String str) {
        String fromSystemProp;
        if (sArch == null) {
            sArch = System.getProperty("os.arch");
        }
        String str2 = sArch;
        if (str2 == null || !str2.toLowerCase().contains(str)) {
            if (sAbi == null) {
                try {
                    sAbi = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getCPU_ABI();
                    sAbi2 = Build.CPU_ABI2;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            String str3 = sAbi;
            if (str3 == null || !str3.toLowerCase().contains(str)) {
                if (sSupportedABIs == null && Build.VERSION.SDK_INT >= 21) {
                    try {
                        sSupportedABIs = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                String[] strArr = sSupportedABIs;
                if (strArr == null || strArr.length <= 0 || strArr[0] == null || !strArr[0].toLowerCase().contains(str)) {
                    if (sCpuAbi == null) {
                        sCpuAbi = getFromSystemProp("ro.product.cpu.abi");
                    }
                    String str4 = sCpuAbi;
                    if (str4 == null || !str4.toLowerCase().contains(str)) {
                        if (sAbiList == null && (fromSystemProp = getFromSystemProp("ro.product.cpu.abilist")) != null && fromSystemProp.length() != 0) {
                            sAbiList = fromSystemProp.split(",");
                        }
                        String[] strArr2 = sAbiList;
                        return strArr2 != null && strArr2.length > 0 && strArr2[0] != null && strArr2[0].toLowerCase().contains(str);
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
        return true;
    }
}

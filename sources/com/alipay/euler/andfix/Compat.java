package com.alipay.euler.andfix;

import android.os.Build;
import com.alipay.euler.andfix.log.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import tb.gn1;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class Compat {
    private static AndFixVM a;

    static {
        AndFixVM andFixVM = AndFixVM.NotSupport;
        a = andFixVM;
        if (a() && c() && b() && !d()) {
            if (!AndFix.setup()) {
                Log.e("Compat", "AndFix.setup() => false");
                a = andFixVM;
            }
        } else {
            a = andFixVM;
        }
        Log.i("Compat", "AndFix.Compat: sAndFixVM=" + a);
    }

    private static boolean a() {
        return true;
    }

    private static boolean b() {
        if (isYunOS()) {
            if (isAOC()) {
                a = AndFixVM.AOC;
                return true;
            }
            a = AndFixVM.Lemur;
        }
        return true;
    }

    private static boolean c() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 8) {
            if (i < 8 || i >= 21) {
                if (i >= 21 && i <= 25) {
                    a = AndFixVM.ART;
                    return true;
                }
            } else if (!System.getProperty("java.vm.version").startsWith("2")) {
                a = AndFixVM.Dalvik;
                return true;
            }
        }
        return false;
    }

    private static boolean d() {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Throwable th;
        Process process;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            process = Runtime.getRuntime().exec("getprop ro.product.cpu.abi");
            try {
                inputStreamReader = new InputStreamReader(process.getInputStream());
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (Exception unused) {
                } catch (Throwable th2) {
                    bufferedReader = null;
                    th = th2;
                }
            } catch (Exception unused2) {
                inputStreamReader = null;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
                inputStreamReader = null;
            }
            try {
                readLine = bufferedReader.readLine();
            } catch (Exception unused3) {
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused4) {
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (Exception unused5) {
                    }
                }
                if (process == null) {
                    return false;
                }
                try {
                    process.destroy();
                } catch (Exception unused6) {
                    return false;
                }
            } catch (Throwable th4) {
                th = th4;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused7) {
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (Exception unused8) {
                    }
                }
                if (process != null) {
                    try {
                        process.destroy();
                    } catch (Exception unused9) {
                    }
                }
                throw th;
            }
        } catch (Exception unused10) {
            process = null;
            inputStreamReader = null;
        } catch (Throwable th5) {
            inputStreamReader = null;
            bufferedReader = null;
            th = th5;
            process = null;
        }
        if (readLine.contains(DeviceUtils.ABI_X86)) {
            Log.i("Compat", "AndFix.Compat: cpu: " + readLine);
            try {
                bufferedReader.close();
            } catch (Exception unused11) {
            }
            try {
                inputStreamReader.close();
            } catch (Exception unused12) {
            }
            try {
                process.destroy();
            } catch (Exception unused13) {
            }
            return true;
        }
        try {
            bufferedReader.close();
        } catch (Exception unused14) {
        }
        try {
            inputStreamReader.close();
        } catch (Exception unused15) {
        }
        process.destroy();
    }

    public static AndFixVM getAndFixVM() {
        return a;
    }

    public static boolean isAOC() {
        Class<?> cls;
        Method method;
        String str;
        try {
            cls = Class.forName("android.os.SystemProperties");
            method = cls.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class);
            str = (String) method.invoke(cls, "persist.sys.dalvik.vm.lib");
            Log.d("Compat", "runtimeLib is " + str);
        } catch (Exception unused) {
        }
        if (str == null || !"libart.so".equals(str)) {
            String str2 = (String) method.invoke(cls, "persist.sys.dalvik.vm.lib.2");
            Log.d("Compat", "runtimeLib2 is " + str2);
            if (str2 != null) {
                if ("libart.so".equals(str2)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static boolean isSupport() {
        return a.value > AndFixVM.NotSupport.value;
    }

    public static boolean isYunOS() {
        String str;
        String str2 = null;
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class);
            str = (String) method.invoke(null, "ro.yunos.version");
            try {
                str2 = (String) method.invoke(null, "java.vm.name");
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str = null;
        }
        return (str2 != null && str2.toLowerCase().contains("lemur")) || (str != null && str.trim().length() > 0);
    }
}

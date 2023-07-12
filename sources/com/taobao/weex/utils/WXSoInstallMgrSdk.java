package com.taobao.weex.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.weex.IWXStatisticsListener;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.adapter.IWXSoLoaderAdapter;
import com.taobao.weex.adapter.IWXUserTrackAdapter;
import com.taobao.weex.common.WXErrorCode;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.util.Locale;
import tb.oz2;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXSoInstallMgrSdk {
    private static IWXSoLoaderAdapter a;
    private static IWXStatisticsListener b;
    private static String c;

    public static String _cpuType() {
        if (TextUtils.isEmpty(c)) {
            try {
                c = Build.getCPU_ABI();
            } catch (Throwable th) {
                th.printStackTrace();
                c = "armeabi";
            }
            if (TextUtils.isEmpty(c)) {
                c = "armeabi";
            }
            c = c.toLowerCase(Locale.ROOT);
        }
        return c;
    }

    private static File a(String str) {
        String _cpuType = _cpuType();
        String copySoDesDir = WXEnvironment.copySoDesDir();
        if (TextUtils.isEmpty(copySoDesDir)) {
            return null;
        }
        return new File(copySoDesDir, str + "/" + _cpuType);
    }

    public static void copyJssRuntimeSo() {
        boolean checkGreyConfig = WXUtils.checkGreyConfig(oz2.WXAPM_CONFIG_GROUP, "use_runtime_api", "0");
        WXLogUtils.e("weex", "tryUseRunTimeApi ? " + checkGreyConfig);
        if (checkGreyConfig) {
            try {
                WXLogUtils.e("weex", "copyJssRuntimeSo: ");
                File a2 = a(WXEnvironment.CORE_JSS_SO_NAME);
                if (!a2.exists()) {
                    a2.mkdirs();
                }
                File file = new File(a2, "libweexjss.so");
                String defaultSettingValue = WXEnvironment.getDefaultSettingValue("app_version_code_weex", "-1");
                if (file.exists()) {
                    if (!TextUtils.equals(WXEnvironment.getAppVersionName(), defaultSettingValue)) {
                        file.delete();
                    } else {
                        WXEnvironment.CORE_JSS_RUNTIME_SO_PATH = file.getAbsolutePath();
                        WXEnvironment.sUseRunTimeApi = true;
                        WXLogUtils.e("weex", "copyJssRuntimeSo exist:  return");
                        return;
                    }
                }
                String findLibrary = ((PathClassLoader) WXSoInstallMgrSdk.class.getClassLoader()).findLibrary("weexjssr");
                if (TextUtils.isEmpty(findLibrary)) {
                    return;
                }
                file.createNewFile();
                WXFileUtils.copyFileWithException(new File(findLibrary), file);
                WXEnvironment.CORE_JSS_RUNTIME_SO_PATH = file.getAbsolutePath();
                WXEnvironment.writeDefaultSettingsValue("app_version_code_weex", WXEnvironment.getAppVersionName());
                WXEnvironment.sUseRunTimeApi = true;
                WXLogUtils.e("weex", "copyJssRuntimeSo: cp end and return ");
            } catch (Throwable th) {
                th.printStackTrace();
                WXEnvironment.sUseRunTimeApi = false;
                WXLogUtils.e("weex", "copyJssRuntimeSo:  exception" + th);
            }
        }
    }

    @SuppressLint({"SdCardPath"})
    public static void copyStartUpSo() {
        String str;
        File file;
        try {
            String packageName = WXEnvironment.getApplication().getPackageName();
            String path = WXEnvironment.getApplication().getApplicationContext().getCacheDir().getPath();
            boolean z = true;
            String str2 = WXEnvironment.CORE_JSB_SO_NAME;
            if (Build.VERSION.SDK_INT < 16) {
                z = false;
                str2 = WXEnvironment.CORE_JST_SO_NAME;
                str = "/libweexjst.so";
            } else {
                str = "/libweexjsb.so";
            }
            File a2 = a(str2);
            if (!a2.exists()) {
                a2.mkdirs();
            }
            File file2 = new File(a2, str);
            WXEnvironment.CORE_JSB_SO_PATH = file2.getAbsolutePath();
            String defaultSettingValue = WXEnvironment.getDefaultSettingValue(str2, "-1");
            if (file2.exists() && TextUtils.equals(WXEnvironment.getAppVersionName(), defaultSettingValue)) {
                return;
            }
            String str3 = "/data/data/" + packageName + "/lib";
            if (path != null && path.indexOf("/cache") > 0) {
                str3 = path.replace("/cache", "/lib");
            }
            if (z) {
                file = new File(str3, "/libweexjsb.so");
            } else {
                file = new File(str3, "/libweexjst.so");
            }
            if (!file.exists()) {
                try {
                    file = new File(((PathClassLoader) WXSoInstallMgrSdk.class.getClassLoader()).findLibrary(str2));
                } catch (Throwable unused) {
                }
            }
            if (!file.exists()) {
                file = new File(WXEnvironment.extractSo(), "/libweexjsb.so");
            }
            if (file.exists()) {
                WXFileUtils.copyFile(file, file2);
            }
            WXEnvironment.writeDefaultSettingsValue(str2, WXEnvironment.getAppVersionName());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void init(Application application, IWXSoLoaderAdapter iWXSoLoaderAdapter, IWXStatisticsListener iWXStatisticsListener) {
        a = iWXSoLoaderAdapter;
        b = iWXStatisticsListener;
    }

    public static boolean initSo(String str, int i, IWXUserTrackAdapter iWXUserTrackAdapter) {
        String _cpuType = _cpuType();
        if (_cpuType.equalsIgnoreCase(DeviceUtils.ABI_MIPS)) {
            WXExceptionUtils.commitCriticalExceptionRT(null, WXErrorCode.WX_KEY_EXCEPTION_SDK_INIT, "initSo", "[WX_KEY_EXCEPTION_SDK_INIT_CPU_NOT_SUPPORT] for android cpuType is MIPS", null);
            return false;
        }
        if (WXEnvironment.CORE_SO_NAME.equals(str)) {
            copyStartUpSo();
        }
        try {
            IWXSoLoaderAdapter iWXSoLoaderAdapter = a;
            if (iWXSoLoaderAdapter != null) {
                iWXSoLoaderAdapter.doLoadLibrary("c++_shared");
            } else {
                System.loadLibrary("c++_shared");
            }
        } catch (Error | Exception e) {
            WXErrorCode wXErrorCode = WXErrorCode.WX_KEY_EXCEPTION_SDK_INIT;
            WXExceptionUtils.commitCriticalExceptionRT(null, wXErrorCode, "initSo", "load c++_shared failed Detail Error is: " + e.getMessage(), null);
            if (WXEnvironment.isApkDebugable()) {
                throw e;
            }
        }
        try {
            IWXSoLoaderAdapter iWXSoLoaderAdapter2 = a;
            if (iWXSoLoaderAdapter2 != null) {
                iWXSoLoaderAdapter2.doLoadLibrary(str);
            } else {
                System.loadLibrary(str);
            }
            return true;
        } catch (Error | Exception e2) {
            if (_cpuType.contains("armeabi") || _cpuType.contains(DeviceUtils.ABI_X86)) {
                WXErrorCode wXErrorCode2 = WXErrorCode.WX_KEY_EXCEPTION_SDK_INIT;
                WXExceptionUtils.commitCriticalExceptionRT(null, wXErrorCode2, "initSo", str + "[WX_KEY_EXCEPTION_SDK_INIT_CPU_NOT_SUPPORT] for android cpuType is " + _cpuType + "\n Detail Error is: " + e2.getMessage(), null);
            }
            if (WXEnvironment.isApkDebugable()) {
                throw e2;
            }
            return false;
        }
    }

    public static boolean isCPUSupport() {
        return !_cpuType().equalsIgnoreCase(DeviceUtils.ABI_MIPS);
    }

    public static boolean isX86() {
        return _cpuType().equalsIgnoreCase(DeviceUtils.ABI_X86);
    }
}

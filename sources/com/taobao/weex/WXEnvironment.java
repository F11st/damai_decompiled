package com.taobao.weex;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Environment;
import android.system.Os;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.WXConfig;
import com.taobao.weex.utils.FontDO;
import com.taobao.weex.utils.LogLevel;
import com.taobao.weex.utils.TypefaceUtil;
import com.taobao.weex.utils.WXFileUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXSoInstallMgrSdk;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import com.youku.arch.solid.monitor.SolidMonitor;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXEnvironment {
    public static boolean AUTO_ADJUST_ENV_DEVICE_WIDTH = false;
    public static boolean AUTO_UPDATE_APPLICATION_SCREEN_SIZE = false;
    private static String COPY_SO_DES_DIR = null;
    public static final String CORE_JSB_SO_NAME = "weexjsb";
    public static String CORE_JSB_SO_PATH = null;
    public static final String CORE_JSC_SO_NAME = "JavaScriptCore";
    private static String CORE_JSC_SO_PATH = null;
    private static String CORE_JSS_ICU_PATH = null;
    public static String CORE_JSS_RUNTIME_SO_PATH = null;
    public static final String CORE_JSS_SO_NAME = "weexjss";
    private static String CORE_JSS_SO_PATH = null;
    public static final String CORE_JST_SO_NAME = "weexjst";
    public static final String CORE_SO_NAME = "weexcore";
    public static final String DEV_Id;
    public static final String EAGLE = "eagle";
    public static final String ENVIRONMENT = "environment";
    public static String JS_LIB_SDK_VERSION = null;
    public static volatile boolean JsFrameworkInit = false;
    private static String LIB_LD_PATH = null;
    public static final String OS = "android";
    public static final String SETTING_EXCLUDE_X86SUPPORT = "env_exclude_x86";
    public static boolean SETTING_FORCE_VERTICAL_SCREEN = false;
    public static final String SYS_MODEL;
    public static String SYS_VERSION = null;
    public static final String WEEX_CURRENT_KEY = "wx_current_url";
    public static String WXSDK_VERSION = null;
    private static boolean isApkDebug = false;
    public static boolean isPerf = false;
    public static volatile boolean isWsFixMode = false;
    private static a mWXDefaultSettings = null;
    private static boolean openDebugLog = false;
    private static Map<String, String> options = null;
    public static Application sApplication = null;
    public static long sComponentsAndModulesReadyTime = 0;
    private static boolean sDebugFlagInit = false;
    public static boolean sDebugMode = false;
    public static boolean sDebugNetworkEventReporterEnable = false;
    public static boolean sDebugServerConnectable = false;
    public static String sDebugWsUrl = null;
    @Deprecated
    public static int sDefaultWidth = 0;
    public static boolean sDynamicMode = false;
    public static String sDynamicUrl = null;
    public static final boolean sForceEnableDevTool = true;
    private static String sGlobalFontFamily;
    public static boolean sInAliWeex;
    public static long sJSFMStartListenerTime;
    public static long sJSLibInitTime;
    public static LogLevel sLogLevel;
    public static boolean sRemoteDebugMode;
    public static String sRemoteDebugProxyUrl;
    public static long sSDKInitExecuteTime;
    public static long sSDKInitInvokeTime;
    public static long sSDKInitStart;
    public static long sSDKInitTime;
    public static volatile boolean sUseRunTimeApi;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a {
        private String a = "weex_default_settings";
        private SharedPreferences b;

        public a(Application application) {
            this.b = null;
            if (application != null) {
                this.b = application.getSharedPreferences("weex_default_settings", 0);
            }
        }

        public synchronized String a(String str, String str2) {
            if (this.b != null && !TextUtils.isEmpty(str)) {
                String string = this.b.getString(str, str2);
                WXLogUtils.i("get default settings " + str + " : " + string);
                return string;
            }
            WXLogUtils.i("get default settings " + str + " return default value :" + str2);
            return str2;
        }

        public synchronized void b(String str, String str2) {
            if (this.b != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                WXLogUtils.i("save default settings " + str + ":" + str2);
                SharedPreferences.Editor edit = this.b.edit();
                edit.putString(str, str2);
                edit.apply();
            }
        }
    }

    static {
        String release = Build.VERSION.getRELEASE();
        SYS_VERSION = release;
        if (release != null && release.toUpperCase(Locale.ROOT).equals("P")) {
            SYS_VERSION = "9.0.0";
        }
        String str = SYS_VERSION;
        if (str != null && str.toUpperCase(Locale.ROOT).equals("Q")) {
            SYS_VERSION = "10.0.0";
        }
        SYS_MODEL = Build.getMODEL();
        JS_LIB_SDK_VERSION = "null";
        WXSDK_VERSION = "0.26.4.45";
        DEV_Id = getDevId();
        sDefaultWidth = FeatureFactory.PRIORITY_ABOVE_NORMAL;
        JsFrameworkInit = false;
        SETTING_FORCE_VERTICAL_SCREEN = false;
        AUTO_ADJUST_ENV_DEVICE_WIDTH = true;
        AUTO_UPDATE_APPLICATION_SCREEN_SIZE = true;
        sUseRunTimeApi = false;
        sDebugMode = false;
        sDebugWsUrl = "";
        sDebugServerConnectable = false;
        sRemoteDebugMode = false;
        sRemoteDebugProxyUrl = "";
        sDebugNetworkEventReporterEnable = false;
        sJSLibInitTime = 0L;
        sSDKInitStart = 0L;
        sSDKInitInvokeTime = 0L;
        sSDKInitExecuteTime = 0L;
        sSDKInitTime = 0L;
        sJSFMStartListenerTime = 0L;
        isWsFixMode = true;
        sComponentsAndModulesReadyTime = 0L;
        sInAliWeex = false;
        sLogLevel = LogLevel.DEBUG;
        isApkDebug = true;
        isPerf = false;
        sDebugFlagInit = false;
        openDebugLog = true;
        CORE_JSS_SO_PATH = null;
        CORE_JSS_RUNTIME_SO_PATH = null;
        CORE_JSS_ICU_PATH = null;
        CORE_JSC_SO_PATH = null;
        CORE_JSB_SO_PATH = null;
        COPY_SO_DES_DIR = null;
        LIB_LD_PATH = null;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        options = concurrentHashMap;
        concurrentHashMap.put("os", "android");
        options.put(WXConfig.osName, "android");
        sDynamicMode = false;
        sDynamicUrl = "";
    }

    public static void addCustomOptions(String str, String str2) {
        options.put(str, str2);
    }

    @SuppressLint({"SdCardPath"})
    public static String copySoDesDir() {
        File file;
        try {
            if (TextUtils.isEmpty(COPY_SO_DES_DIR)) {
                if (sApplication == null) {
                    WXLogUtils.e("sApplication is null, so copy path will be null");
                    return null;
                }
                String path = getApplication().getApplicationContext().getCacheDir().getPath();
                if (TextUtils.isEmpty(path)) {
                    file = new File(path, "/cache/weex/libs");
                } else {
                    String packageName = sApplication.getPackageName();
                    file = new File("/data/data/" + packageName + "/cache/weex/libs");
                }
                if (!file.exists()) {
                    file.mkdirs();
                }
                COPY_SO_DES_DIR = file.getAbsolutePath();
            }
        } catch (Throwable th) {
            WXLogUtils.e(WXLogUtils.getStackTrace(th));
        }
        return COPY_SO_DES_DIR;
    }

    public static String extractSo() {
        File file = new File(getApplication().getApplicationContext().getApplicationInfo().sourceDir);
        String copySoDesDir = copySoDesDir();
        if (file.exists() && !TextUtils.isEmpty(copySoDesDir)) {
            try {
                WXFileUtils.extractSo(file.getAbsolutePath(), copySoDesDir);
                return copySoDesDir;
            } catch (IOException e) {
                WXLogUtils.e("extractSo error " + e.getMessage());
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:
        if (r2 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String findIcuPath() {
        /*
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "/proc/self/maps"
            r0.<init>(r1)
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
        L12:
            java.lang.String r0 = r2.readLine()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L46
            if (r0 == 0) goto L32
            java.lang.String r3 = "icudt"
            boolean r3 = r0.contains(r3)     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L46
            if (r3 == 0) goto L12
            r3 = 47
            int r3 = r0.indexOf(r3)     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L46
            java.lang.String r0 = r0.substring(r3)     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L46
            java.lang.String r0 = r0.trim()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L46
            r2.close()     // Catch: java.io.IOException -> L31
        L31:
            return r0
        L32:
            r2.close()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L46
        L35:
            r2.close()     // Catch: java.io.IOException -> L45
            goto L45
        L39:
            r0 = move-exception
            goto L3f
        L3b:
            r0 = move-exception
            goto L48
        L3d:
            r0 = move-exception
            r2 = r1
        L3f:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L45
            goto L35
        L45:
            return r1
        L46:
            r0 = move-exception
            r1 = r2
        L48:
            if (r1 == 0) goto L4d
            r1.close()     // Catch: java.io.IOException -> L4d
        L4d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.WXEnvironment.findIcuPath():java.lang.String");
    }

    public static String findSoPath(String str) {
        String findLibrary = ((PathClassLoader) WXEnvironment.class.getClassLoader()).findLibrary(str);
        if (!TextUtils.isEmpty(findLibrary)) {
            File file = new File(findLibrary);
            if (file.exists()) {
                WXLogUtils.e(str + "'s Path is" + findLibrary);
                return file.getAbsolutePath();
            }
            WXLogUtils.e(str + "'s Path is " + findLibrary + " but file does not exist");
        }
        String str2 = SolidMonitor.CHECK_TYPE_LIB + str + ".so";
        String cacheDir = getCacheDir();
        if (TextUtils.isEmpty(cacheDir)) {
            WXLogUtils.e("cache dir is null");
            return "";
        }
        if (cacheDir.indexOf("/cache") > 0) {
            findLibrary = new File(cacheDir.replace("/cache", "/lib"), str2).getAbsolutePath();
        }
        if (new File(findLibrary).exists()) {
            WXLogUtils.e(str + "use lib so");
            return findLibrary;
        }
        String extractSo = extractSo();
        return !TextUtils.isEmpty(extractSo) ? new File(extractSo, str2).getAbsolutePath() : findLibrary;
    }

    private static String getAppCacheFile() {
        try {
            return sApplication.getApplicationContext().getCacheDir().getPath();
        } catch (Exception e) {
            WXLogUtils.e("WXEnvironment getAppCacheFile Exception: ", e);
            return "";
        }
    }

    public static String getAppVersionName() {
        try {
            return sApplication.getPackageManager().getPackageInfo(sApplication.getPackageName(), 0).versionName;
        } catch (Exception e) {
            WXLogUtils.e("WXEnvironment getAppVersionName Exception: ", e);
            return "";
        }
    }

    public static Application getApplication() {
        return sApplication;
    }

    public static String getCacheDir() {
        Application application = getApplication();
        if (application == null || application.getApplicationContext() == null) {
            return null;
        }
        return application.getApplicationContext().getCacheDir().getPath();
    }

    public static Map<String, String> getConfig() {
        Application application;
        HashMap hashMap = new HashMap();
        hashMap.put("os", "android");
        hashMap.put("appVersion", getAppVersionName());
        hashMap.put(WXConfig.cacheDir, getAppCacheFile());
        hashMap.put(WXConfig.devId, DEV_Id);
        hashMap.put(WXConfig.sysVersion, SYS_VERSION);
        hashMap.put(WXConfig.sysModel, SYS_MODEL);
        hashMap.put("weexVersion", String.valueOf(WXSDK_VERSION));
        try {
            hashMap.put(WXConfig.layoutDirection, isLayoutDirectionRTL() ? Constants.Name.RTL : "ltr");
        } catch (Exception unused) {
            hashMap.put(WXConfig.layoutDirection, "ltr");
        }
        try {
            if (isApkDebugable()) {
                addCustomOptions(WXConfig.debugMode, "true");
            }
            addCustomOptions("scale", Float.toString(sApplication.getResources().getDisplayMetrics().density));
            addCustomOptions(WXConfig.androidStatusBarHeight, Float.toString(WXViewUtils.getStatusBarHeight(sApplication)));
        } catch (NullPointerException e) {
            WXLogUtils.e("WXEnvironment scale Exception: ", e);
        }
        hashMap.putAll(getCustomOptions());
        if (hashMap.get("appName") == null && (application = sApplication) != null) {
            hashMap.put("appName", application.getPackageName());
        }
        return hashMap;
    }

    public static String getCrashFilePath(Context context) {
        File dir;
        return (context == null || (dir = context.getDir("crash", 0)) == null) ? "" : dir.getAbsolutePath();
    }

    @Deprecated
    public static Map<String, String> getCustomOptions() {
        return options;
    }

    public static synchronized String getDefaultSettingValue(String str, String str2) {
        synchronized (WXEnvironment.class) {
            a wXDefaultSettings = getWXDefaultSettings();
            if (wXDefaultSettings != null && !TextUtils.isEmpty(str)) {
                return wXDefaultSettings.a(str, str2);
            }
            return str2;
        }
    }

    @SuppressLint({"HardwareIds"})
    private static String getDevId() {
        Application application = sApplication;
        if (application != null) {
            try {
                return TelephonyManager.getDeviceId((android.telephony.TelephonyManager) application.getSystemService("phone"));
            } catch (NullPointerException | SecurityException e) {
                WXLogUtils.e(WXLogUtils.getStackTrace(e));
            }
        }
        return "";
    }

    public static String getDiskCacheDir(Context context) {
        String path;
        if (context == null) {
            return null;
        }
        try {
            if (!"mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
                path = context.getCacheDir().getPath();
                return path;
            }
            path = context.getExternalCacheDir().getPath();
            return path;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getFilesDir(Context context) {
        if (context == null) {
            return "";
        }
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            return filesDir.getPath();
        }
        return (getApplication().getApplicationInfo().dataDir + File.separator) + AVFSCacheConstants.AVFS_FIlE_PATH_NAME;
    }

    public static String getGlobalFontFamilyName() {
        return sGlobalFontFamily;
    }

    public static String getLibJScRealPath() {
        if (TextUtils.isEmpty(CORE_JSC_SO_PATH)) {
            CORE_JSC_SO_PATH = findSoPath(CORE_JSC_SO_NAME);
            WXLogUtils.e("findLibJscRealPath " + CORE_JSC_SO_PATH);
        }
        return CORE_JSC_SO_PATH;
    }

    public static String getLibJssIcuPath() {
        if (TextUtils.isEmpty(CORE_JSS_ICU_PATH)) {
            CORE_JSS_ICU_PATH = findIcuPath();
        }
        return CORE_JSS_ICU_PATH;
    }

    public static String getLibJssRealPath() {
        if (sUseRunTimeApi && !TextUtils.isEmpty(CORE_JSS_RUNTIME_SO_PATH)) {
            WXLogUtils.d("test-> findLibJssRuntimeRealPath " + CORE_JSS_RUNTIME_SO_PATH);
            return CORE_JSS_RUNTIME_SO_PATH;
        }
        if (TextUtils.isEmpty(CORE_JSS_SO_PATH)) {
            CORE_JSS_SO_PATH = findSoPath(CORE_JSS_SO_NAME);
            WXLogUtils.d("test-> findLibJssRealPath " + CORE_JSS_SO_PATH);
        }
        return CORE_JSS_SO_PATH;
    }

    public static String getLibLdPath() {
        if (TextUtils.isEmpty(LIB_LD_PATH)) {
            ClassLoader classLoader = WXEnvironment.class.getClassLoader();
            try {
                LIB_LD_PATH = (String) classLoader.getClass().getMethod("getLdLibraryPath", new Class[0]).invoke(classLoader, new Object[0]);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(LIB_LD_PATH)) {
            try {
                String property = System.getProperty("java.library.path");
                String libJScRealPath = getLibJScRealPath();
                if (!TextUtils.isEmpty(libJScRealPath)) {
                    LIB_LD_PATH = new File(libJScRealPath).getParent() + ":" + property;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        WXLogUtils.d("getLibLdPath is " + LIB_LD_PATH);
        return LIB_LD_PATH;
    }

    public static synchronized a getWXDefaultSettings() {
        a aVar;
        synchronized (WXEnvironment.class) {
            if (mWXDefaultSettings == null && getApplication() != null) {
                mWXDefaultSettings = new a(getApplication());
            }
            aVar = mWXDefaultSettings;
        }
        return aVar;
    }

    public static boolean isApkDebugable() {
        return isApkDebugable(sApplication);
    }

    public static boolean isCPUSupport() {
        boolean z = true;
        boolean z2 = WXSoInstallMgrSdk.isX86() && "true".equals(getCustomOptions().get(SETTING_EXCLUDE_X86SUPPORT));
        z = (!WXSoInstallMgrSdk.isCPUSupport() || z2) ? false : false;
        if (isApkDebugable()) {
            WXLogUtils.d("WXEnvironment.sSupport:" + z + "isX86AndExclueded: " + z2);
        }
        return z;
    }

    @Deprecated
    public static boolean isHardwareSupport() {
        if (isApkDebugable()) {
            WXLogUtils.d("isTableDevice:" + WXUtils.isTabletDevice());
        }
        return isCPUSupport();
    }

    public static boolean isLayoutDirectionRTL() {
        if (Build.VERSION.SDK_INT >= 17) {
            return sApplication.getApplicationContext().getResources().getBoolean(R$bool.weex_is_right_to_left);
        }
        return false;
    }

    public static boolean isOpenDebugLog() {
        return openDebugLog;
    }

    public static boolean isPerf() {
        return isPerf;
    }

    @Deprecated
    public static boolean isSupport() {
        boolean isInitialized = WXSDKEngine.isInitialized();
        if (!isInitialized) {
            WXLogUtils.e("WXSDKEngine.isInitialized():" + isInitialized);
        }
        return isHardwareSupport() && isInitialized;
    }

    public static int memfd_create(String str, int i) {
        if (Build.VERSION.SDK_INT < 28) {
            return 0;
        }
        try {
            Object invoke = Os.class.getMethod("memfd_create", String.class, Integer.TYPE).invoke(null, str, 0);
            if (invoke instanceof FileDescriptor) {
                Field declaredField = FileDescriptor.class.getDeclaredField("descriptor");
                declaredField.setAccessible(true);
                int parseInt = Integer.parseInt(String.valueOf(declaredField.get(invoke)));
                try {
                    declaredField.setAccessible(false);
                    Os.ftruncate((FileDescriptor) invoke, i);
                } catch (Throwable unused) {
                }
                return parseInt;
            }
            return 0;
        } catch (Throwable unused2) {
            return 0;
        }
    }

    public static void setApkDebugable(boolean z) {
        isApkDebug = z;
        if (z) {
            return;
        }
        openDebugLog = false;
    }

    public static void setGlobalFontFamily(String str, Typeface typeface) {
        WXLogUtils.d("GlobalFontFamily", "Set global font family: " + str);
        sGlobalFontFamily = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (typeface == null) {
            TypefaceUtil.removeFontDO(str);
            return;
        }
        TypefaceUtil.putFontDO(new FontDO(str, typeface));
        WXLogUtils.d("TypefaceUtil", "Add new font: " + str);
    }

    public static void setOpenDebugLog(boolean z) {
        openDebugLog = z;
    }

    public static synchronized void writeDefaultSettingsValue(String str, String str2) {
        synchronized (WXEnvironment.class) {
            a wXDefaultSettings = getWXDefaultSettings();
            if (wXDefaultSettings != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                wXDefaultSettings.b(str, str2);
            }
        }
    }

    public void initMetrics() {
    }

    public static String getCustomOptions(String str) {
        return options.get(str);
    }

    public static boolean isApkDebugable(Application application) {
        if (application == null || isPerf) {
            return false;
        }
        if (sDebugFlagInit) {
            return isApkDebug;
        }
        try {
            String str = getCustomOptions().get(WXConfig.debugMode);
            if (TextUtils.isEmpty(str)) {
                isApkDebug = (application.getApplicationInfo().flags & 2) != 0;
            } else {
                isApkDebug = Boolean.valueOf(str).booleanValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
            isApkDebug = false;
        }
        sDebugFlagInit = true;
        return isApkDebug;
    }
}

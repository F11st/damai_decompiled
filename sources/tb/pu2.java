package tb;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.net.ConnectivityManagerCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.sdk.m.k.C4226b;
import com.taobao.update.datasource.UpdateDataSource;
import com.taobao.update.datasource.local.UpdateInfo;
import com.taobao.update.framework.UpdateRuntime;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class pu2 {
    public static int SilentDownloadSpaceSize = 200;
    public static String TAG = "UpdateUtils";
    public static String sCurrentProcessName;

    /* compiled from: Taobao */
    /* renamed from: tb.pu2$a */
    /* loaded from: classes11.dex */
    class C9569a implements FileFilter {
        C9569a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    @TargetApi(16)
    private static boolean a(ConnectivityManager connectivityManager) {
        try {
            if (Build.VERSION.SDK_INT >= 16) {
                return connectivityManager.isActiveNetworkMetered();
            }
            return ConnectivityManagerCompat.isActiveNetworkMetered(connectivityManager);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static UpdateInfo convert2EmasUpdateInfo(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        UpdateInfo updateInfo = new UpdateInfo();
        updateInfo.appVersion = getVersionName();
        String string = jSONObject.containsKey(C4226b.l) ? jSONObject.getString(C4226b.l) : null;
        if (string == null) {
            return null;
        }
        long longValue = jSONObject.containsKey("productId") ? jSONObject.getLongValue("productId") : 0L;
        long longValue2 = jSONObject.containsKey("applicationId") ? jSONObject.getLongValue("applicationId") : 0L;
        long longValue3 = jSONObject.containsKey("batchId") ? jSONObject.getLongValue("batchId") : 0L;
        for (String str2 : jSONObject.keySet()) {
            try {
                Object obj = jSONObject.get(str2);
                if (obj != null && (obj instanceof JSONObject)) {
                    JSONObject jSONObject2 = (JSONObject) obj;
                    jSONObject2.put("productId", (Object) Long.valueOf(longValue));
                    jSONObject2.put("applicationId", (Object) Long.valueOf(longValue2));
                    jSONObject2.put("batchId", (Object) Long.valueOf(longValue3));
                    UpdateInfo.UpdateData updateData = new UpdateInfo.UpdateData();
                    updateData.name = string;
                    updateData.value = jSONObject2;
                    updateData.valid = true;
                    updateData.from = str;
                    updateInfo.updateList.put(string, updateData);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return updateInfo;
    }

    public static UpdateInfo convert2UpdateInfo(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        UpdateInfo updateInfo = new UpdateInfo();
        updateInfo.appVersion = getVersionName();
        for (String str2 : jSONObject.keySet()) {
            Object obj = jSONObject.get(str2);
            if (obj != null && (obj instanceof JSONObject)) {
                Log.e("UpdateSDK", "use mtop update convert");
                UpdateInfo.UpdateData updateData = new UpdateInfo.UpdateData();
                updateData.name = str2;
                updateData.value = (JSONObject) obj;
                updateData.valid = true;
                updateData.from = str;
                updateInfo.updateList.put(str2, updateData);
            }
        }
        return updateInfo;
    }

    public static String getApkPath(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).publicSourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getAppNameString(int i, String str) {
        return UpdateDataSource.sContext.getString(i).replaceAll("\\{app_name\\}", str);
    }

    public static String getFreeSizeRange(long j) {
        return j < 50 ? ">50M" : j < 100 ? "50M<n<100M" : j < 200 ? "100M<n<200M" : j < 500 ? "200M<n<500M" : ">500M";
    }

    public static int getNetworkType() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) UpdateDataSource.sContext.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager)) == null) {
                return 0;
            }
            if (activeNetworkInfo.getType() == 9) {
                return 2;
            }
            if (activeNetworkInfo.getType() == 1) {
                return a(connectivityManager) ? 1 : 2;
            }
            return 3;
        } catch (Throwable unused) {
            return 2;
        }
    }

    public static int getNumCores() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new C9569a());
            Log.d("util", "CPU Count: " + listFiles.length);
            return listFiles.length;
        } catch (Exception e) {
            Log.d("util", "CPU Count: Failed.");
            e.printStackTrace();
            return 1;
        }
    }

    public static String getProcessName(Context context) {
        if (!TextUtils.isEmpty(sCurrentProcessName)) {
            return sCurrentProcessName;
        }
        int myPid = Process.myPid();
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    String str = runningAppProcessInfo.processName;
                    sCurrentProcessName = str;
                    return str;
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getStorePath(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        return externalCacheDir.getAbsolutePath();
    }

    public static long getUsableSpace(File file) {
        if (file == null) {
            return -1L;
        }
        if (Build.VERSION.SDK_INT >= 9) {
            return (file.getUsableSpace() / 1024) / 1024;
        }
        if (file.exists()) {
            StatFs statFs = new StatFs(file.getPath());
            return ((statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1024) / 1024;
        }
        return 0L;
    }

    public static String getVersionName() {
        Application application = UpdateDataSource.sContext;
        if (application != null) {
            try {
                return application.getPackageManager().getPackageInfo(UpdateDataSource.sContext.getPackageName(), 0).versionName;
            } catch (Exception e) {
                e.printStackTrace();
                return "1.0.0";
            }
        }
        throw new RuntimeException("application is null");
    }

    public static boolean greaterThen(String str, String str2) {
        try {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            for (int i = 0; i < split.length; i++) {
                if (i >= split2.length) {
                    return true;
                }
                if (!split[i].equals(split2[i])) {
                    return Integer.valueOf(split[i]).intValue() > Integer.valueOf(split2[i]).intValue();
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean hasEnoughSpace(Context context, long j) {
        return hasEnoughSpace(getStorePath(context), j);
    }

    public static boolean isDebug(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static boolean isNotificationPermissioned() {
        Method declaredMethod;
        Application application = UpdateDataSource.sContext;
        Object systemService = application.getSystemService("appops");
        try {
            Class<?> cls = systemService.getClass();
            Class<?> cls2 = Integer.TYPE;
            declaredMethod = cls.getDeclaredMethod("checkOpNoThrow", cls2, cls2, String.class);
            declaredMethod.setAccessible(true);
        } catch (Exception unused) {
        }
        return ((Integer) declaredMethod.invoke(systemService, 11, Integer.valueOf(application.getApplicationInfo().uid), application.getPackageName())).intValue() == 0;
    }

    public static boolean isProguard() {
        try {
            String str = UpdateRuntime.processName;
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return true;
        }
    }

    public static void killChildProcesses(Context context) {
        try {
            long j = context.getApplicationInfo().uid;
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            for (int i = 0; i < runningAppProcesses.size(); i++) {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i);
                if (runningAppProcessInfo.uid == j && !runningAppProcessInfo.processName.equals(context.getPackageName())) {
                    Process.killProcess(runningAppProcessInfo.pid);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static boolean shouldSilentDownload() {
        try {
            return getUsableSpace(Environment.getDataDirectory()) > ((long) SilentDownloadSpaceSize);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static final <T> T toJavaObject(JSON json, Class<T> cls) {
        try {
            return (T) JSON.toJavaObject(json, cls);
        } catch (Throwable unused) {
            try {
                return (T) JSON.parseObject(json.toJSONString(), cls);
            } catch (Throwable unused2) {
                return null;
            }
        }
    }

    public static boolean hasEnoughSpace(String str, long j) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        StatFs statFs = null;
        try {
            statFs = new StatFs(file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (statFs != null ? ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) : 0L) >= j + PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
    }
}

package com.taobao.accs.utl;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.NetworkInfo;
import android.os.Binder;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.ta.utdid2.device.UTDevice;
import com.taobao.accs.IDevice;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.aranger.utils.IPCUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import org.android.agoo.huawei.HuaWeiRegister;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AdapterUtilityImpl {
    public static String BACK_APP_KEY = "";
    private static final String TAG = "AdapterUtilityImpl";
    public static final String channelService = "com.taobao.accs.ChannelService";
    public static IDevice iDevice = null;
    private static Boolean isChannelProcess = null;
    private static Boolean isMainProcess = null;
    private static Boolean isTB = null;
    public static String mAgooAppSecret = null;
    public static final String msgService = "com.taobao.accs.data.MsgDistributeService";

    public static boolean checkFloatPermission(Context context) {
        int i = Build.VERSION.SDK_INT;
        boolean z = true;
        if (i < 19) {
            ALog.d(TAG, "AssistantUtils === checkFloatPermission === 小于19版本，返回true", new Object[0]);
            return true;
        }
        try {
            if (i < 23) {
                Class<?> cls = Class.forName("android.content.Context");
                Field declaredField = cls.getDeclaredField("APP_OPS_SERVICE");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(cls);
                if (obj instanceof String) {
                    Object invoke = cls.getMethod("getSystemService", String.class).invoke(context, (String) obj);
                    Class<?> cls2 = Class.forName("android.app.AppOpsManager");
                    Field declaredField2 = cls2.getDeclaredField("MODE_ALLOWED");
                    declaredField2.setAccessible(true);
                    Class<?> cls3 = Integer.TYPE;
                    int intValue = ((Integer) cls2.getMethod("checkOp", cls3, cls3, String.class).invoke(invoke, 24, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue();
                    ALog.d(TAG, "LinkUtils === checkFloatPermission === 小于23版本，返回 = " + declaredField2.getInt(cls2), new Object[0]);
                    return intValue == declaredField2.getInt(cls2);
                }
                return false;
            } else if (i >= 26) {
                AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
                if (appOpsManager == null) {
                    return false;
                }
                int checkOpNoThrow = appOpsManager.checkOpNoThrow("android:system_alert_window", Process.myUid(), context.getPackageName());
                if (!Settings.canDrawOverlays(context) && checkOpNoThrow != 0) {
                    z = false;
                }
                ALog.d(TAG, "LinkUtils === checkFloatPermission === 大于26版本，返回" + z, new Object[0]);
                return z;
            } else {
                boolean canDrawOverlays = Settings.canDrawOverlays(context);
                ALog.d(TAG, "LinkUtils === checkFloatPermission === 大于23  小于26版本，返回" + canDrawOverlays, new Object[0]);
                return canDrawOverlays;
            }
        } catch (Throwable th) {
            ALog.e(TAG, "checkFloatPermission", th, new Object[0]);
            return false;
        }
    }

    public static final boolean checkIsWritable(String str, int i) {
        if (str == null) {
            return false;
        }
        StatFs statFs = new StatFs(str);
        int blockSize = statFs.getBlockSize();
        long availableBlocks = statFs.getAvailableBlocks();
        StringBuilder sb = new StringBuilder();
        sb.append("st.getAvailableBlocks()=");
        sb.append(statFs.getAvailableBlocks());
        sb.append(",st.getAvailableBlocks() * blockSize=");
        long j = blockSize;
        sb.append(statFs.getAvailableBlocks() * j);
        Log.d("FileCheckUtils", sb.toString());
        return statFs.getAvailableBlocks() > 10 && availableBlocks * j > ((long) i);
    }

    public static String getDeviceId(Context context) {
        IDevice iDevice2 = iDevice;
        if (iDevice2 == null) {
            return UTDevice.getUtdid(context);
        }
        return iDevice2.getDeviceId(context);
    }

    public static String getStackMsg(Throwable th) {
        return getStackMsg(th.getStackTrace());
    }

    public static long getUsableSpace() {
        try {
            File dataDirectory = Environment.getDataDirectory();
            if (dataDirectory == null) {
                return -1L;
            }
            if (Build.VERSION.SDK_INT >= 9) {
                return dataDirectory.getUsableSpace();
            }
            if (dataDirectory.exists()) {
                StatFs statFs = new StatFs(dataDirectory.getPath());
                return statFs.getBlockSize() * statFs.getAvailableBlocks();
            }
            return -1L;
        } catch (Throwable th) {
            ALog.e(TAG, "getUsableSpace", th, new Object[0]);
            return -1L;
        }
    }

    public static boolean isChannelProcess(Context context) {
        Boolean bool = isChannelProcess;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(UtilityImpl.getChannelProcessName(context).equals(IPCUtils.getCurrentProcessName()));
        isChannelProcess = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean isForeground(Context context) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String packageName = GlobalClientInfo.getInstance(context).getActivityManager().getRunningTasks(1).get(0).topActivity.getPackageName();
            if (TextUtils.isEmpty(packageName) || !packageName.equals(context.getPackageName())) {
                ALog.i(TAG, "isForeground time " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                return false;
            }
            return true;
        } catch (Throwable th) {
            ALog.e(TAG, "isForeground error ", null, th);
            return true;
        }
    }

    public static boolean isMainProcess(Context context) {
        Boolean bool = isMainProcess;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(context.getPackageName().equals(IPCUtils.getCurrentProcessName()));
        isMainProcess = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo(GlobalClientInfo.getInstance(context).getConnectivityManager());
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isConnected();
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static String isNotificationEnabled(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return String.valueOf(((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled());
            } catch (Throwable th) {
                ALog.e(TAG, "Android above 7.0 isNotificationEnabled", th, new Object[0]);
            }
        } else {
            try {
                AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = context.getApplicationContext().getPackageName();
                int i = applicationInfo.uid;
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Class<?> cls2 = Integer.TYPE;
                boolean z = true;
                if (((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(appOpsManager)).intValue()), Integer.valueOf(i), packageName)).intValue() != 0) {
                    z = false;
                }
                return String.valueOf(z);
            } catch (Throwable th2) {
                ALog.e(TAG, "isNotificationEnabled", th2, new Object[0]);
            }
        }
        return "unknown";
    }

    public static boolean isProcessAlive(Context context, String str) {
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = GlobalClientInfo.getInstance(context).getActivityManager().getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (str.equals(runningAppProcessInfo.processName)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            ALog.e(TAG, "isProcessAlive error ", e, new Object[0]);
            return false;
        }
    }

    public static boolean isSupportHMS(Context context) {
        try {
            boolean z = HuaWeiRegister.isChannelRegister;
            Method declaredMethod = HuaWeiRegister.class.getDeclaredMethod("isSupport", Context.class);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(null, context)).booleanValue();
        } catch (Throwable th) {
            ALog.e(TAG, "isSupportHMS err", th, new Object[0]);
            return false;
        }
    }

    public static boolean isTaobao(Context context) {
        if (isTB == null) {
            try {
                isTB = Boolean.valueOf("com.taobao.taobao".equals(context.getPackageName()));
                ALog.e(TAG, "isTaobao=" + isTB, new Object[0]);
            } catch (Exception e) {
                ALog.e(TAG, "isTaobao err", e, new Object[0]);
                return true;
            }
        }
        return isTB.booleanValue();
    }

    public static String getStackMsg(StackTraceElement[] stackTraceElementArr) {
        StringBuffer stringBuffer = new StringBuffer();
        if (stackTraceElementArr != null) {
            try {
                if (stackTraceElementArr.length > 0) {
                    for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                        stringBuffer.append(stackTraceElement.toString());
                        stringBuffer.append(StringUtils.LF);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return stringBuffer.toString();
    }
}

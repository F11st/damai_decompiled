package com.ali.user.open.core.device;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.ReflectionUtils;
import com.taobao.orange.OConstant;
import com.taobao.weex.annotation.JSMethod;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DeviceInfo {
    private static DeviceInfo INSTANCE = null;
    private static final String TAG = "DeviceInfo";
    public static String deviceId;

    public static synchronized DeviceInfo getInstance() {
        DeviceInfo deviceInfo;
        synchronized (DeviceInfo.class) {
            if (INSTANCE == null) {
                INSTANCE = new DeviceInfo();
            }
            deviceInfo = INSTANCE;
        }
        return deviceInfo;
    }

    public static String getLocale(Context context) {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = context.getResources().getConfiguration().getLocales().get(0);
        } else {
            locale = context.getResources().getConfiguration().locale;
        }
        return locale.getLanguage() + JSMethod.NOT_SET + locale.getCountry();
    }

    public static void init(Context context) {
        if (TextUtils.isEmpty(deviceId)) {
            initDeviceId(context);
        }
    }

    private static void initDeviceId(final Context context) {
        Class<?> loadClassQuietly = ReflectionUtils.loadClassQuietly(OConstant.REFLECT_UTDID);
        String str = null;
        if (loadClassQuietly != null) {
            try {
                Object invoke = loadClassQuietly.getMethod("getUtdid", Context.class).invoke(null, context);
                if (invoke == null) {
                    SDKLogger.e(TAG, "get utdid null");
                } else {
                    str = (String) invoke;
                }
            } catch (Exception unused) {
                SDKLogger.e(TAG, "get utdid error");
            }
        }
        if (str == null) {
            KernelContext.executorService.postTask(new Runnable() { // from class: com.ali.user.open.core.device.DeviceInfo.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        DeviceInfo.deviceId = context.getSharedPreferences("auth_sdk_device", 0).getString("deviceId", "");
                        SDKLogger.e(DeviceInfo.TAG, "DeviceInfo.deviceId = " + DeviceInfo.deviceId);
                    } catch (Throwable unused2) {
                    }
                }
            });
            return;
        }
        deviceId = str;
        SDKLogger.e(TAG, "utdid = " + str);
        KernelContext.executorService.postTask(new Runnable() { // from class: com.ali.user.open.core.device.DeviceInfo.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SharedPreferences.Editor edit = context.getSharedPreferences("auth_sdk_device", 0).edit();
                    edit.putString("deviceId", DeviceInfo.deviceId);
                    edit.apply();
                } catch (Throwable unused2) {
                }
            }
        });
    }
}

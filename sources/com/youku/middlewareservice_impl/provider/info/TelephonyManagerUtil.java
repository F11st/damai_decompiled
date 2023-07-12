package com.youku.middlewareservice_impl.provider.info;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class TelephonyManagerUtil {
    public static final String TAG = "DeviceInfoSDK";
    private static boolean isForbidden = false;
    private static boolean isGetAndroidID = false;
    private static boolean isGetMeid = false;
    private static boolean isGetPhoneNumber = false;
    private static boolean isGetSimSN = false;
    private static boolean isGetSystemImei = false;
    private static boolean isGetSystemImsi = false;
    public static boolean isOpen = true;
    public static boolean isPrintStack = false;
    private static String mAndroidID = "";
    private static String mPhoneNumber = "";
    private static String mSimSN = "";
    private static String mSystemImei = "";
    private static String mSystemImsi = "";
    private static String mSystemMeid = "";

    public static void Trace(String str) {
        if (isPrintStack) {
            Log.e(TAG, str, new Throwable());
        }
    }

    private static boolean checkPermission(Context context, String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        try {
            return context.checkPermission(str, Binder.getCallingPid(), Binder.getCallingUid()) == 0;
        } catch (Exception unused) {
            return true;
        }
    }

    public static String getAndroidID(Context context) {
        Trace("getAndroidID");
        if (getForbidden()) {
            return "";
        }
        if (isGetAndroidID && isOpen) {
            return mAndroidID;
        }
        synchronized (TelephonyManagerUtil.class) {
            if (isGetAndroidID && isOpen) {
                return mAndroidID;
            } else if (context == null) {
                return mAndroidID;
            } else {
                try {
                    mAndroidID = Settings.Secure.getString(context.getContentResolver(), "android_id");
                } catch (Throwable unused) {
                    mAndroidID = "";
                }
                isGetAndroidID = true;
                return mAndroidID;
            }
        }
    }

    public static boolean getForbidden() {
        return isForbidden;
    }

    public static String getImei(Context context) {
        Trace("getImei");
        if (getForbidden()) {
            return "";
        }
        if (isGetSystemImei && isOpen) {
            return mSystemImei;
        }
        synchronized (TelephonyManagerUtil.class) {
            if (isGetSystemImei && isOpen) {
                return mSystemImei;
            } else if (context == null) {
                return mSystemImei;
            } else {
                try {
                    if (!checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                        return mSystemImei;
                    }
                } catch (Throwable unused) {
                }
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            String imei = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getImei(telephonyManager);
                            mSystemImei = imei;
                            if (TextUtils.isEmpty(imei)) {
                                mSystemImei = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getDeviceId(telephonyManager);
                            }
                        } else {
                            mSystemImei = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getDeviceId(telephonyManager);
                        }
                    }
                } catch (Throwable unused2) {
                    mSystemImei = "";
                }
                isGetSystemImei = true;
                return mSystemImei;
            }
        }
    }

    public static String getMeid(Context context) {
        Trace("getMeid");
        if (getForbidden()) {
            return "";
        }
        if (isGetMeid && isOpen) {
            return mSystemMeid;
        }
        synchronized (TelephonyManagerUtil.class) {
            if (isGetMeid && isOpen) {
                return mSystemMeid;
            } else if (context == null) {
                return mSystemMeid;
            } else {
                try {
                    if (!checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                        return mSystemMeid;
                    }
                } catch (Throwable unused) {
                }
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        int i = Build.VERSION.SDK_INT;
                        if (i >= 26) {
                            mSystemMeid = (String) telephonyManager.getClass().getMethod("getMeid", Integer.TYPE).invoke(telephonyManager, 0);
                        } else if (i >= 21) {
                            mSystemMeid = getSystemPropertyByReflect("ril.cdma.meid");
                        }
                    }
                } catch (Throwable unused2) {
                    mSystemMeid = "";
                }
                isGetMeid = true;
                return mSystemMeid;
            }
        }
    }

    @SuppressLint({"HardwareIds"})
    public static String getPhoneNumber(Context context) {
        Trace("getLine1Number");
        if (getForbidden()) {
            return "";
        }
        if (isGetPhoneNumber && isOpen) {
            return mPhoneNumber;
        }
        synchronized (TelephonyManagerUtil.class) {
            if (isGetPhoneNumber && isOpen) {
                return mPhoneNumber;
            } else if (context == null) {
                return mPhoneNumber;
            } else {
                try {
                    if (!checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                        return mPhoneNumber;
                    }
                } catch (Throwable unused) {
                }
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        mPhoneNumber = telephonyManager.getLine1Number();
                    }
                } catch (Throwable unused2) {
                    mPhoneNumber = "";
                }
                isGetPhoneNumber = true;
                return mPhoneNumber;
            }
        }
    }

    @SuppressLint({"HardwareIds"})
    public static String getSimSerialNumber(Context context) {
        Trace("getSimSerialNumber");
        if (getForbidden()) {
            return "";
        }
        if (isGetSimSN && isOpen) {
            return mSimSN;
        }
        synchronized (TelephonyManagerUtil.class) {
            if (isGetSimSN && isOpen) {
                return mSimSN;
            } else if (context == null) {
                return mSimSN;
            } else {
                try {
                    if (!checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                        return mSimSN;
                    }
                } catch (Throwable unused) {
                }
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        mSimSN = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getSimSerialNumber(telephonyManager);
                    }
                } catch (Throwable unused2) {
                    mSimSN = "";
                }
                isGetSimSN = true;
                return mSimSN;
            }
        }
    }

    public static String getSubscriberId(Context context) {
        Trace("getSubscriberId");
        if (getForbidden()) {
            return "";
        }
        if (isGetSystemImsi && isOpen) {
            return mSystemImsi;
        }
        synchronized (TelephonyManagerUtil.class) {
            if (isGetSystemImsi && isOpen) {
                return mSystemImsi;
            } else if (context == null) {
                return mSystemImsi;
            } else {
                try {
                    if (!checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                        return mSystemImsi;
                    }
                } catch (Throwable unused) {
                }
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        mSystemImsi = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getSubscriberId(telephonyManager);
                    }
                } catch (Throwable unused2) {
                    mSystemImsi = "";
                }
                isGetSystemImsi = true;
                return mSystemImsi;
            }
        }
    }

    public static String getSystemPropertyByReflect(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class).invoke(cls, str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static void setIsForbidden(boolean z) {
        isForbidden = z;
    }
}

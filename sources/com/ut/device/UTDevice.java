package com.ut.device;

import android.content.Context;
import com.ta.audid.Variables;
import com.ta.utdid2.android.utils.PhoneInfoUtils;
import com.ta.utdid2.device.AppUtdid;
import com.ta.utdid2.device.UTUtdid;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTDevice {
    @Deprecated
    public static String getAid(String str, String str2, Context context) {
        return "";
    }

    @Deprecated
    public static void getAidAsync(String str, String str2, Context context, AidCallback aidCallback) {
    }

    @Deprecated
    public static int getType() {
        return com.ta.utdid2.device.UTDevice.getType();
    }

    public static String getUtdid(Context context) {
        return com.ta.utdid2.device.UTDevice.getUtdid(context);
    }

    @Deprecated
    public static String getUtdidForUpdate(Context context) {
        return getUtdid(context);
    }

    @Deprecated
    public static void setAppChannel(String str) {
    }

    @Deprecated
    public static void setAppKey(String str) {
    }

    @Deprecated
    public static void setCollectDelayTime(long j) {
        AppUtdid.setCollectDelayTime(j);
    }

    @Deprecated
    public static void setDebug(boolean z) {
        Variables.getInstance().setDebug(z);
    }

    public static void setExtendFactor(String str) {
        UTUtdid.setExtendFactor(str);
    }

    @Deprecated
    public static void setOldMode(Context context, boolean z) {
    }

    public static void setPrivacyMode(boolean z) {
        PhoneInfoUtils.setPrivacyMode(z);
    }
}

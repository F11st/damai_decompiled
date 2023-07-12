package com.huawei.secure.android.common;

import android.content.Context;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes10.dex */
public abstract class HiPkgSignManager {
    @Deprecated
    public static boolean doCheckArchiveApk(Context context, String str, String str2, String str3) {
        return com.huawei.secure.android.common.sign.HiPkgSignManager.doCheckArchiveApk(context, str, str2, str3);
    }

    @Deprecated
    public static boolean doCheckInstalled(Context context, String str, String str2) {
        return com.huawei.secure.android.common.sign.HiPkgSignManager.doCheckInstalled(context, str, str2);
    }

    @Deprecated
    public static byte[] getInstalledAPPSignature(Context context, String str) {
        return com.huawei.secure.android.common.sign.HiPkgSignManager.getInstalledAPPSignature(context, str);
    }

    @Deprecated
    public static String getInstalledAppHash(Context context, String str) {
        return com.huawei.secure.android.common.sign.HiPkgSignManager.getInstalledAppHash(context, str);
    }

    @Deprecated
    public static byte[] getUnInstalledAPPSignature(Context context, String str) {
        return com.huawei.secure.android.common.sign.HiPkgSignManager.getUnInstalledAPPSignature(context, str);
    }

    @Deprecated
    public static String getUnInstalledAppHash(Context context, String str) {
        return com.huawei.secure.android.common.sign.HiPkgSignManager.getUnInstalledAppHash(context, str);
    }
}

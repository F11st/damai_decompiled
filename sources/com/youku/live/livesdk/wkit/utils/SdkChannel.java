package com.youku.live.livesdk.wkit.utils;

import android.content.Context;
import com.youku.alixplayer.opensdk.AXPParamsProvider;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public enum SdkChannel {
    UNKNOWN(jn1.MUL, "unknown"),
    LAIFENG(AXPParamsProvider.ClientType.LAIFENG, "lf"),
    LAIFENG_SHORTVIDEO("com.youku.lfvideo", "lfsv"),
    YOUKU(AXPParamsProvider.ClientType.YOUKU, "yk"),
    YOUKU_HUAWEI(AXPParamsProvider.ClientType.YOUKU_HWBAIPAI, "yk"),
    UC("com.UCMobile", "uc"),
    XM("fm.xiami.main", "xm"),
    YKSTREAM("com.youku.starlive", "ykstream"),
    DAMAI("cn.damai", "dm");
    
    private String packageName;
    private String tag;

    SdkChannel(String str, String str2) {
        this.packageName = str;
        this.tag = str2;
    }

    public static String getTag(Context context) {
        if (isLaifeng(context)) {
            return LAIFENG.tag;
        }
        if (isYouku(context)) {
            return YOUKU.tag;
        }
        if (isUC(context)) {
            return UC.tag;
        }
        if (isXiami(context)) {
            return XM.tag;
        }
        if (isYkStream(context)) {
            return YKSTREAM.tag;
        }
        if (isDamai(context)) {
            return YOUKU.tag;
        }
        return UNKNOWN.tag;
    }

    public static boolean isDamai(Context context) {
        if (context != null) {
            return context.getPackageName().equals(DAMAI.packageName);
        }
        return false;
    }

    public static boolean isLaifeng(Context context) {
        if (context != null) {
            return context.getPackageName().equals(LAIFENG.packageName);
        }
        return false;
    }

    public static boolean isUC(Context context) {
        if (context != null) {
            return context.getPackageName().equals(UC.packageName);
        }
        return false;
    }

    public static boolean isXiami(Context context) {
        if (context != null) {
            return context.getPackageName().equals(XM.packageName);
        }
        return false;
    }

    public static boolean isYkStream(Context context) {
        if (context != null) {
            return context.getPackageName().equals(YKSTREAM.packageName);
        }
        return false;
    }

    public static boolean isYouku(Context context) {
        if (context == null) {
            return false;
        }
        return context.getPackageName().equals(YOUKU.packageName) || context.getPackageName().equals(YOUKU_HUAWEI.packageName);
    }

    public String tag() {
        return this.tag;
    }

    public String value() {
        return this.packageName;
    }
}

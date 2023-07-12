package mtopsdk.mtop.global;

import android.content.Context;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.xstate.XState;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SDKUtils {
    private static final String TAG = "mtopsdk.SDKUtils";

    public static long getCorrectionTime() {
        return getTimeOffset() + (System.currentTimeMillis() / 1000);
    }

    public static long getCorrectionTimeMillis() {
        return getCorrectionTime() * 1000;
    }

    public static long getTimeOffset() {
        String timeOffset = XState.getTimeOffset();
        if (StringUtils.isNotBlank(timeOffset)) {
            try {
                return Long.parseLong(timeOffset);
            } catch (NumberFormatException unused) {
                TBSdkLog.e(TAG, "[getTimeOffset]parse t_offset failed");
            }
        } else {
            XState.setValue(XStateConstants.KEY_TIME_OFFSET, "0");
        }
        return 0L;
    }

    @Deprecated
    public static void logOut() {
        Mtop.instance(Mtop.Id.INNER, (Context) null).logout();
    }

    @Deprecated
    public static void registerMtopSdkProperty(String str, String str2) {
        Mtop.instance(Mtop.Id.INNER, (Context) null).getMtopConfig().registerMtopSdkProperty(str, str2);
    }

    @Deprecated
    public static void registerSessionInfo(String str, String str2) {
        Mtop.instance(Mtop.Id.INNER, (Context) null).registerSessionInfo(str, str2);
    }

    @Deprecated
    public static void registerTtid(String str) {
        Mtop.instance(Mtop.Id.INNER, (Context) null).registerTtid(str);
    }

    @Deprecated
    public static boolean removeCacheBlock(String str) {
        return Mtop.instance(Mtop.Id.INNER, (Context) null).removeCacheBlock(str);
    }

    @Deprecated
    public static boolean removeCacheItem(String str, String str2) {
        return Mtop.instance(Mtop.Id.INNER, (Context) null).removeCacheItem(str, str2);
    }

    @Deprecated
    public static boolean unintallCacheBlock(String str) {
        return Mtop.instance(Mtop.Id.INNER, (Context) null).unintallCacheBlock(str);
    }

    @Deprecated
    public static void registerSessionInfo(String str, String str2, String str3) {
        Mtop.instance(Mtop.Id.INNER, (Context) null).registerSessionInfo(str, str3);
    }
}

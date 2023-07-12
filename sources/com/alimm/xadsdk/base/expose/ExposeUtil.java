package com.alimm.xadsdk.base.expose;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alimm.xadsdk.base.model.BidInfo;
import com.alimm.xadsdk.base.model.MonitorInfo;
import com.alimm.xadsdk.base.utils.LogUtils;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ExposeUtil {
    private static final String CACHE_PLACEHOLDER = "__htch__";
    private static final String POSITION_PLACEHOLDER = "##VE##";
    private static final String TAG = "ExposeUtil";
    private static final String TIME_STAMP_PLACEHOLDER = "__TIMESTAMP__";

    public static boolean containsValidSu(BidInfo bidInfo, int i) {
        List<MonitorInfo> list = (bidInfo == null || bidInfo.getAdItem() == null || bidInfo.getAdItem().getMonitorInfo() == null) ? null : bidInfo.getAdItem().getMonitorInfo().get(MonitorType.PLAYING);
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (MonitorInfo monitorInfo : list) {
            if (isValidSu(monitorInfo, i)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static List<MonitorInfo> getAdMonitorInfoList(BidInfo bidInfo, String str) {
        if (bidInfo == null || bidInfo.getAdItem() == null || bidInfo.getAdItem().getMonitorInfo() == null) {
            LogUtils.w(TAG, "getAdMonitorInfoList failed: type = " + str);
            return null;
        }
        return bidInfo.getAdItem().getMonitorInfo().get(str);
    }

    @Nullable
    public static List<MonitorInfo> getInteractionMonitorInfoList(BidInfo bidInfo, String str) {
        if (bidInfo == null || bidInfo.getInteractionInfo() == null || bidInfo.getInteractionInfo().getMonitorInfo() == null) {
            LogUtils.w(TAG, "getInteractionMonitorInfoList failed: type = " + str);
            return null;
        }
        return bidInfo.getInteractionInfo().getMonitorInfo().get(str);
    }

    public static boolean isArriveExposeTime(@NonNull MonitorInfo monitorInfo, int i) {
        return i >= 0 && i == monitorInfo.getTime();
    }

    private static boolean isValidSu(@NonNull MonitorInfo monitorInfo, int i) {
        return i == monitorInfo.getTime();
    }

    public static String replaceMacros(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.contains(TIME_STAMP_PLACEHOLDER)) {
            str = str.replace(TIME_STAMP_PLACEHOLDER, String.valueOf(System.currentTimeMillis() / 1000));
        }
        if (MonitorType.IMPRESSION.equals(str2) && str.contains(CACHE_PLACEHOLDER)) {
            str = str.replace(CACHE_PLACEHOLDER, "2");
        }
        return str.contains(POSITION_PLACEHOLDER) ? str.replace(POSITION_PLACEHOLDER, String.valueOf(i)) : str;
    }
}

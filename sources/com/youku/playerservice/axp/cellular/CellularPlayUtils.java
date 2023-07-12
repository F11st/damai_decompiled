package com.youku.playerservice.axp.cellular;

import com.alibaba.aliweex.adapter.module.net.IWXConnection;
import com.youku.alixplayer.config.FeatureManager;
import com.youku.arch.beast.hostschedule.HostScheduler;
import com.youku.phone.freeflow.utils.LogUtil;
import com.youku.phone.freeflow.utils.NetworkUtils;
import com.youku.phone.freeflow.utils.OrangeUtils;
import java.util.Map;
import tb.mj2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class CellularPlayUtils {
    private static boolean EMPLOY_HOST_SDK = false;
    private static boolean EMPLOY_HOST_SDK_ON_EACH_TS = false;
    private static final String TAG = "CellularPlayUtils";

    static {
        boolean z;
        if (FeatureManager.getInstance().hasFreeFlow()) {
            EMPLOY_HOST_SDK = OrangeUtils.getOrangeTechnicalValueEqual1("EMPLOY_HOST_SDK", true);
            z = OrangeUtils.getOrangeTechnicalValueEqual1("EMPLOY_HOST_SDK_ON_EACH_TS", true);
        } else {
            z = false;
            EMPLOY_HOST_SDK = false;
        }
        EMPLOY_HOST_SDK_ON_EACH_TS = z;
    }

    public static String getHost(String str, Map<String, String> map) {
        String str2 = null;
        if (map != null && EMPLOY_HOST_SDK && EMPLOY_HOST_SDK_ON_EACH_TS) {
            try {
                if (Player3gUtil.getYKFreeFlowResult().isProxyReplaceUrl()) {
                    return null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            boolean isConnectedCellular = NetworkUtils.isConnectedCellular();
            boolean equals = "requireCellularHost".equals(map.get("queryType"));
            boolean z = false;
            if (isConnectedCellular || equals) {
                z = Player3gUtil.getYKFreeFlowResult().isProxyReplaceHost();
            }
            map.put("network", isConnectedCellular ? IWXConnection.TYPE_CELLULAR : "wifi");
            map.put("useAbsoluteFreeFlowDomain", z ? "1" : "0");
            try {
                str2 = HostScheduler.getInstance().getDomain(map);
                LogUtil.d(TAG, "分片级别获取域名:" + str2 + ",原url:" + str);
                return str2;
            } catch (Exception e2) {
                e2.printStackTrace();
                return str2;
            }
        }
        return null;
    }

    public static boolean isDoubleChannelEnable(Map<String, String> map) {
        if (FeatureManager.getInstance().hasFreeFlow() && !NetworkUtils.isConnectedCellular()) {
            return "true".equals(mj2.a("debug.youkuplayer.double_channel")) || Player3gUtil.getYKFreeFlowResult().isFreeFlow();
        }
        return false;
    }
}

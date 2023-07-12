package com.youku.android.liveservice.utils;

import com.taobao.orange.OrangeConfig;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.Quality;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PlayControlV3Util {
    private static boolean sIsEnable = true;
    private static boolean sIsV3EnableInit;

    public static LivePlayControl getControlFromJsonString(String str) {
        Exception e;
        LivePlayControl livePlayControl;
        try {
            livePlayControl = (LivePlayControl) FastJsonTools.deserialize(str, LivePlayControl.class);
            try {
                modifyControlFormDq(livePlayControl);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return livePlayControl;
            }
        } catch (Exception e3) {
            e = e3;
            livePlayControl = null;
        }
        return livePlayControl;
    }

    public static boolean isUseControlV3() {
        if (!sIsV3EnableInit) {
            try {
                sIsEnable = Boolean.parseBoolean(OrangeConfig.getInstance().getConfig(LiveOrangeUtil.LIVE_GROUP_NAME, "playControlV3Enable", "true"));
                sIsV3EnableInit = true;
            } catch (Exception e) {
                sIsEnable = false;
                e.printStackTrace();
            }
        }
        return sIsEnable;
    }

    private static LivePlayControl modifyControlFormDq(LivePlayControl livePlayControl) {
        if (livePlayControl == null) {
            return null;
        }
        List<Quality> list = livePlayControl.qualities;
        if (list != null) {
            for (Quality quality : list) {
                if (quality != null && livePlayControl.dq == quality.quality) {
                    livePlayControl.bizSwitch = quality.bizSwitch;
                    livePlayControl.eRs = quality.eRs;
                    livePlayControl.cRk = quality.cRk;
                    livePlayControl.subtitleUrl = quality.subtitleUrl;
                    livePlayControl.timeShiftOffset = quality.timeShiftOffset;
                    livePlayControl.playType = quality.playType;
                }
                quality.playurl = quality.h264PlayUrl;
            }
        }
        return livePlayControl;
    }
}

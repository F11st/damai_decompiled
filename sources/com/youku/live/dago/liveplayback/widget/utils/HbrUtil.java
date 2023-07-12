package com.youku.live.dago.liveplayback.widget.utils;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.android.liveservice.bean.Quality;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class HbrUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean hasHbr(YoukuVideoInfo youkuVideoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-734920631")) {
            return ((Boolean) ipChange.ipc$dispatch("-734920631", new Object[]{youkuVideoInfo})).booleanValue();
        }
        if (youkuVideoInfo != null && youkuVideoInfo.getLivePlayControl() != null) {
            for (Quality quality : youkuVideoInfo.getLivePlayControl().qualities) {
                if (quality.hbr == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isVideoHbr(YoukuVideoInfo youkuVideoInfo, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2067629639")) {
            return ((Boolean) ipChange.ipc$dispatch("-2067629639", new Object[]{youkuVideoInfo, Integer.valueOf(i)})).booleanValue();
        }
        if (youkuVideoInfo != null && youkuVideoInfo.getLivePlayControl() != null) {
            for (Quality quality : youkuVideoInfo.getLivePlayControl().qualities) {
                if (quality.hbr == 1 && quality.quality == i) {
                    return true;
                }
            }
        }
        return false;
    }
}

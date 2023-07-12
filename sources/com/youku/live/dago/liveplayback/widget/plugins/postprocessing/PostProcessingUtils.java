package com.youku.live.dago.liveplayback.widget.plugins.postprocessing;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PostProcessingUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "PostProcessingUtils";

    public static boolean isNeedCloseProcessing(YoukuVideoInfo youkuVideoInfo, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1608131509")) {
            return ((Boolean) ipChange.ipc$dispatch("1608131509", new Object[]{youkuVideoInfo, str})).booleanValue();
        }
        return false;
    }
}

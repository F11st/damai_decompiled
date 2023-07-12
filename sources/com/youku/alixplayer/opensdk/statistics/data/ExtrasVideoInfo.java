package com.youku.alixplayer.opensdk.statistics.data;

import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.statistics.Track;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ExtrasVideoInfo extends ExtraMap {
    public ExtrasVideoInfo(Track track, PlayVideoInfo playVideoInfo) {
        put("apsOpen265", playVideoInfo.getMonitor("apsOpen265", null));
    }

    public ExtrasVideoInfo(Track track, PlayVideoInfo playVideoInfo, YoukuVideoInfo youkuVideoInfo) {
        put("apsOpen265", playVideoInfo.getMonitor("apsOpen265", null));
        if (youkuVideoInfo != null && youkuVideoInfo.getLiveInfo() != null && youkuVideoInfo.getLiveInfo().videoInfo != null) {
            put("pushStreamType", youkuVideoInfo.getLiveInfo().videoInfo.pushStreamType);
        }
        if (youkuVideoInfo == null || youkuVideoInfo.getLivePlayControl() == null) {
            return;
        }
        put("hbrHit", youkuVideoInfo.getLivePlayControl().hbrHit + "");
    }
}

package com.youku.alixplayer.opensdk.statistics.track;

import com.youku.alixplayer.opensdk.statistics.Track;
import com.youku.alixplayer.opensdk.statistics.TrackUtil;
import com.youku.alixplayer.opensdk.statistics.framework.MSGTABLEID;
import com.youku.alixplayer.opensdk.statistics.framework.table.Table;
import com.youku.alixplayer.opensdk.statistics.proxy.VpmProxy;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class SubtitleEventTrack {
    private static final String TAG = "SubtitleEvent";
    private Track mTrack;

    public SubtitleEventTrack(Track track) {
        this.mTrack = track;
    }

    public void commit() {
        Table table = this.mTrack.mVPM.getTable(MSGTABLEID.SUBTITLE_EVENT);
        Map<String, String> dimensions = table.getDimensions();
        dimensions.put("eventType", "1");
        Map<String, Double> measures = table.getMeasures();
        if (this.mTrack.getPlayerConfig().isExternal()) {
            return;
        }
        VpmProxy.commitSubtitleEventStatistics(dimensions, measures);
        TrackUtil.printlog(TAG, "", dimensions, measures);
    }
}

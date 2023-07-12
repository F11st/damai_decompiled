package com.youku.vpm.track;

import com.youku.vpm.framework.Table;
import com.youku.vpm.framework.TableId;
import com.youku.vpm.proxy.VpmProxy;
import com.youku.vpm.utils.TrackUtil;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SubtitleEventTrack {
    private static final String TAG = "SubtitleEvent";
    private Track mTrack;

    public SubtitleEventTrack(Track track) {
        this.mTrack = track;
    }

    public void commit() {
        Table table = this.mTrack.mTableBuilder.getTable(TableId.SUBTITLE_EVENT);
        Map<String, String> dimensions = table.getDimensions();
        dimensions.put("eventType", "1");
        Map<String, Double> measures = table.getMeasures();
        if (this.mTrack.isExternal()) {
            return;
        }
        VpmProxy.commitSubtitleEventStatistics(dimensions, measures);
        TrackUtil.printlog(this.mTrack.getContext(), TAG, "", dimensions, measures);
    }
}

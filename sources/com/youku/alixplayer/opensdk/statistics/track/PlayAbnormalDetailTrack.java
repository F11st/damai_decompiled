package com.youku.alixplayer.opensdk.statistics.track;

import com.youku.alixplayer.opensdk.statistics.BaseTrack;
import com.youku.alixplayer.opensdk.statistics.Track;
import com.youku.alixplayer.opensdk.statistics.TrackUtil;
import com.youku.alixplayer.opensdk.statistics.framework.MSGTABLEID;
import com.youku.alixplayer.opensdk.statistics.framework.table.Table;
import com.youku.alixplayer.opensdk.statistics.proxy.VpmProxy;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class PlayAbnormalDetailTrack extends BaseTrack {
    public static final String TAG = "PlayAbnormalDetail";

    public PlayAbnormalDetailTrack(Track track) {
        super(track);
    }

    public void commit() {
        Table table = getTrack().getTable(MSGTABLEID.PLAY_ABNORMAL_DETAIL);
        Map<String, String> dimensions = table.getDimensions();
        addBaseDimensions(dimensions);
        Map<String, Double> measures = table.getMeasures();
        addBaseMeasures(measures);
        if (this.mTrack.getPlayerConfig().isExternal()) {
            return;
        }
        VpmProxy.commitPlayAbnormalDetail(dimensions, measures);
        TrackUtil.printlog("PlayAbnormalDetail", "PlayAbnormalDetail", dimensions, measures);
    }
}

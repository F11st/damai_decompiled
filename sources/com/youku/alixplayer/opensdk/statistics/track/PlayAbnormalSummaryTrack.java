package com.youku.alixplayer.opensdk.statistics.track;

import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.statistics.BaseTrack;
import com.youku.alixplayer.opensdk.statistics.Track;
import com.youku.alixplayer.opensdk.statistics.TrackUtil;
import com.youku.alixplayer.opensdk.statistics.framework.monitor.PlayAbnormalSummary;
import com.youku.alixplayer.opensdk.statistics.framework.table.Table;
import com.youku.alixplayer.opensdk.statistics.proxy.VpmProxy;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class PlayAbnormalSummaryTrack extends BaseTrack {
    public static final String TAG = "PlayAbnormalSummary";
    private boolean mHasData;
    private Table mTable;

    public PlayAbnormalSummaryTrack(Track track) {
        super(track);
        this.mTable = new PlayAbnormalSummary();
    }

    public void commit(YoukuVideoInfo youkuVideoInfo) {
        Map<String, String> dimensions = this.mTable.getDimensions();
        addBaseDimensions(dimensions);
        Map<String, Double> measures = this.mTable.getMeasures();
        addBaseMeasures(measures);
        if (this.mTrack.getPlayerConfig().isExternal()) {
            return;
        }
        VpmProxy.commitPlayAbnormalSummary(dimensions, measures);
        TrackUtil.printlog("PlayAbnormalSummary", "PlayAbnormalSummary", dimensions, measures);
    }

    public void getPlayerInfoForVVEnd(String str) {
        if (this.mHasData) {
            return;
        }
        this.mTable.putString(str);
        this.mHasData = true;
    }
}

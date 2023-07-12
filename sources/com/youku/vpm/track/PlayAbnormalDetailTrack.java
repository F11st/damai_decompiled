package com.youku.vpm.track;

import com.youku.vpm.BaseTrack;
import com.youku.vpm.framework.Table;
import com.youku.vpm.framework.TableId;
import com.youku.vpm.proxy.VpmProxy;
import com.youku.vpm.utils.TrackUtil;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayAbnormalDetailTrack extends BaseTrack {
    public static final String TAG = "PlayAbnormalDetail";

    public PlayAbnormalDetailTrack(Track track) {
        super(track);
    }

    public void commit() {
        Table table = getTrack().getTable(TableId.PLAY_ABNORMAL_DETAIL);
        Map<String, String> dimensions = table.getDimensions();
        Map<String, Double> measures = table.getMeasures();
        if (this.mTrack.isExternal()) {
            return;
        }
        VpmProxy.commitPlayAbnormalDetail(dimensions, measures);
        TrackUtil.printlog(this.mTrack.getContext(), "PlayAbnormalDetail", "PlayAbnormalDetail", dimensions, measures);
    }
}

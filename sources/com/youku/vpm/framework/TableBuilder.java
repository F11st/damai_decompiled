package com.youku.vpm.framework;

import com.youku.vpm.framework.monitor.AdError;
import com.youku.vpm.framework.monitor.AdImpairment;
import com.youku.vpm.framework.monitor.AdPlay;
import com.youku.vpm.framework.monitor.BeforePlay;
import com.youku.vpm.framework.monitor.Impairment;
import com.youku.vpm.framework.monitor.OneChange;
import com.youku.vpm.framework.monitor.OneEvent;
import com.youku.vpm.framework.monitor.OnePlay;
import com.youku.vpm.framework.monitor.PlayAbnormalDetail;
import com.youku.vpm.framework.monitor.PlayAbnormalSummary;
import com.youku.vpm.framework.monitor.PlayHeartbeat;
import com.youku.vpm.framework.monitor.Playing;
import com.youku.vpm.framework.monitor.StartLoading;
import com.youku.vpm.framework.monitor.SubtitleEvent;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class TableBuilder {
    private Map<TableId, Table> mTables = new HashMap<TableId, Table>() { // from class: com.youku.vpm.framework.TableBuilder.1
        {
            put(TableId.ONEPLAY, new OnePlay());
            put(TableId.ONECHANGE_QUALITY, new OneChange());
            put(TableId.ONECHANGE_SEEK, new OneChange());
            put(TableId.IMPAIRMENT, new Impairment());
            put(TableId.PLAYHEARTBEAT, new PlayHeartbeat());
            put(TableId.ONEEVENT, new OneEvent());
            put(TableId.BEFORE_PLAY, new BeforePlay());
            put(TableId.PLAYING, new Playing());
            put(TableId.START_LOADING, new StartLoading());
            put(TableId.AD_PLAY, new AdPlay());
            put(TableId.AD_ERROR, new AdError());
            put(TableId.AD_IMPAIRMENT, new AdImpairment());
            put(TableId.SUBTITLE_EVENT, new SubtitleEvent());
            put(TableId.PLAY_ABNORMAL_DETAIL, new PlayAbnormalDetail());
            put(TableId.PLAY_ABNORMAL_SUMMARY, new PlayAbnormalSummary());
        }
    };

    public Table getTable(TableId tableId) {
        return this.mTables.get(tableId);
    }
}

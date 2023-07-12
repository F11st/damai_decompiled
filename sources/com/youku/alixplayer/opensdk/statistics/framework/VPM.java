package com.youku.alixplayer.opensdk.statistics.framework;

import com.youku.alixplayer.opensdk.statistics.framework.monitor.PlayAbnormalDetail;
import com.youku.alixplayer.opensdk.statistics.framework.monitor.PlayAbnormalSummary;
import com.youku.alixplayer.opensdk.statistics.framework.table.Table;
import com.youku.alixplayer.opensdk.statistics.framework.table.TableAdError;
import com.youku.alixplayer.opensdk.statistics.framework.table.TableAdImpairment;
import com.youku.alixplayer.opensdk.statistics.framework.table.TableAdPlay;
import com.youku.alixplayer.opensdk.statistics.framework.table.TableBeforePlay;
import com.youku.alixplayer.opensdk.statistics.framework.table.TableImpairment;
import com.youku.alixplayer.opensdk.statistics.framework.table.TableOneEvent;
import com.youku.alixplayer.opensdk.statistics.framework.table.TableOnePlay;
import com.youku.alixplayer.opensdk.statistics.framework.table.TablePlayHeartBeat;
import com.youku.alixplayer.opensdk.statistics.framework.table.TablePlaying;
import com.youku.alixplayer.opensdk.statistics.framework.table.TableQuality;
import com.youku.alixplayer.opensdk.statistics.framework.table.TableSeek;
import com.youku.alixplayer.opensdk.statistics.framework.table.TableStartLoading;
import com.youku.alixplayer.opensdk.statistics.framework.table.TableSubtitleEvent;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class VPM {
    public static final int VVEND = -1111;
    private Map<MSGTABLEID, Table> mTables = new HashMap<MSGTABLEID, Table>() { // from class: com.youku.alixplayer.opensdk.statistics.framework.VPM.1
        {
            put(MSGTABLEID.ONEPLAY, new TableOnePlay());
            put(MSGTABLEID.ONECHANGE_QUALITY, new TableQuality());
            put(MSGTABLEID.ONECHANGE_SEEK, new TableSeek());
            put(MSGTABLEID.IMPAIRMENT, new TableImpairment());
            put(MSGTABLEID.PLAYHEARTBEAT, new TablePlayHeartBeat());
            put(MSGTABLEID.ONEEVENT, new TableOneEvent());
            put(MSGTABLEID.BEFORE_PLAY, new TableBeforePlay());
            put(MSGTABLEID.PLAYING, new TablePlaying());
            put(MSGTABLEID.AD_PLAY, new TableAdPlay());
            put(MSGTABLEID.AD_ERROR, new TableAdError());
            put(MSGTABLEID.AD_IMPAIRMENT, new TableAdImpairment());
            put(MSGTABLEID.START_LOADING, new TableStartLoading());
            put(MSGTABLEID.SUBTITLE_EVENT, new TableSubtitleEvent());
            put(MSGTABLEID.PLAY_ABNORMAL_DETAIL, new PlayAbnormalDetail());
            put(MSGTABLEID.PLAY_ABNORMAL_SUMMARY, new PlayAbnormalSummary());
        }
    };

    private MSGTABLEID[] getTableIds(int i) {
        switch (i) {
            case VVEND /* -1111 */:
            case 2008:
            case 2009:
                return new MSGTABLEID[]{MSGTABLEID.ONEPLAY};
            case 4:
                return new MSGTABLEID[]{MSGTABLEID.ONECHANGE_SEEK};
            case 950:
                return new MSGTABLEID[]{MSGTABLEID.SUBTITLE_EVENT};
            case 1003:
                return new MSGTABLEID[]{MSGTABLEID.IMPAIRMENT, MSGTABLEID.AD_IMPAIRMENT, MSGTABLEID.START_LOADING};
            case 1004:
                return new MSGTABLEID[]{MSGTABLEID.IMPAIRMENT, MSGTABLEID.AD_IMPAIRMENT};
            case 1011:
                return new MSGTABLEID[]{MSGTABLEID.ONEPLAY, MSGTABLEID.AD_PLAY};
            case 1017:
            case 90000:
                return new MSGTABLEID[]{MSGTABLEID.ONEPLAY, MSGTABLEID.IMPAIRMENT, MSGTABLEID.ONECHANGE_SEEK, MSGTABLEID.ONECHANGE_QUALITY, MSGTABLEID.PLAYHEARTBEAT, MSGTABLEID.ONEEVENT, MSGTABLEID.PLAY_ABNORMAL_SUMMARY};
            case 1021:
                return new MSGTABLEID[]{MSGTABLEID.ONEPLAY, MSGTABLEID.IMPAIRMENT, MSGTABLEID.ONECHANGE_SEEK, MSGTABLEID.ONECHANGE_QUALITY, MSGTABLEID.PLAYHEARTBEAT, MSGTABLEID.ONEEVENT};
            case 1022:
            case 80001:
                return new MSGTABLEID[]{MSGTABLEID.ONECHANGE_QUALITY};
            case 1032:
            case 60001:
            case 60002:
                return new MSGTABLEID[]{MSGTABLEID.PLAYHEARTBEAT};
            case 2303:
            case 80002:
            case 80003:
                return new MSGTABLEID[]{MSGTABLEID.ONEEVENT};
            case 2400:
                return new MSGTABLEID[]{MSGTABLEID.ONEPLAY, MSGTABLEID.ONEEVENT};
            case 2500:
                return new MSGTABLEID[]{MSGTABLEID.ONEPLAY, MSGTABLEID.IMPAIRMENT};
            case 9003:
                return new MSGTABLEID[]{MSGTABLEID.PLAY_ABNORMAL_DETAIL};
            default:
                return null;
        }
    }

    public Table getTable(MSGTABLEID msgtableid) {
        return this.mTables.get(msgtableid);
    }

    public boolean setParams(int i, Object obj) {
        if (obj != null) {
            String valueOf = String.valueOf(obj);
            MSGTABLEID[] tableIds = getTableIds(i);
            if (tableIds != null) {
                for (MSGTABLEID msgtableid : tableIds) {
                    this.mTables.get(msgtableid).putString(valueOf);
                }
                return true;
            }
        }
        return false;
    }
}

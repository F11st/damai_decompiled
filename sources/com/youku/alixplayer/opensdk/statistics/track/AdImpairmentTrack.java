package com.youku.alixplayer.opensdk.statistics.track;

import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.statistics.Track;
import com.youku.alixplayer.opensdk.statistics.TrackUtil;
import com.youku.alixplayer.opensdk.statistics.framework.MSGTABLEID;
import com.youku.alixplayer.opensdk.statistics.framework.table.Table;
import com.youku.alixplayer.opensdk.statistics.proxy.VpmProxy;
import com.youku.vpm.constants.TableField;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class AdImpairmentTrack {
    public static final String TAG = "AdImpairment";
    private int mAdType;
    private Track mTrack;

    public AdImpairmentTrack(Track track, int i) {
        this.mTrack = track;
        this.mAdType = i;
    }

    public void commit() {
        PlayVideoInfo playVideoInfo = this.mTrack.getPlayVideoInfo();
        Table table = this.mTrack.mVPM.getTable(MSGTABLEID.AD_IMPAIRMENT);
        Map<String, String> dimensions = table.getDimensions();
        dimensions.put("vvId", this.mTrack.getVVId());
        dimensions.put(TableField.PLAYER_SOURCE, this.mTrack.getPlayerSource());
        dimensions.put(TableField.MEDIA_TYPE, playVideoInfo.getPlayType().getValue() + "");
        dimensions.put("adType", String.valueOf(this.mAdType));
        Map<String, Double> measures = table.getMeasures();
        String str = dimensions.get("adUrl");
        dimensions.put("adVid", TrackUtil.getValueByKeyFromUrl(str, "adVid"));
        dimensions.put("adFileformat", TrackUtil.getFileFormatByUrl(str));
        if (this.mAdType == 3) {
            Table table2 = this.mTrack.getTable(MSGTABLEID.IMPAIRMENT);
            dimensions.put("adFileformat", TrackUtil.getFileFormatByUrl(table2.getDimensions().get("URL")));
            dimensions.put("adVideoCode", table2.getDimensions().get("videoCode"));
        }
        if (this.mTrack.getPlayerConfig().isExternal()) {
            return;
        }
        VpmProxy.commitAdImpairmentStatistics(dimensions, measures);
    }
}

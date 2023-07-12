package com.youku.alixplayer.opensdk.statistics.track;

import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.statistics.ErrorCodeUtil;
import com.youku.alixplayer.opensdk.statistics.Track;
import com.youku.alixplayer.opensdk.statistics.TrackUtil;
import com.youku.alixplayer.opensdk.statistics.framework.MSGTABLEID;
import com.youku.alixplayer.opensdk.statistics.framework.table.Table;
import com.youku.alixplayer.opensdk.statistics.proxy.VpmProxy;
import com.youku.vpm.constants.TableField;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class AdErrorTrack {
    public static final String TAG = "AdError";
    private Track mTrack;

    public AdErrorTrack(Track track) {
        this.mTrack = track;
    }

    public void commit(int i, int i2, YoukuVideoInfo youkuVideoInfo) {
        PlayVideoInfo playVideoInfo = this.mTrack.getPlayVideoInfo();
        Table table = this.mTrack.mVPM.getTable(MSGTABLEID.AD_ERROR);
        Map<String, String> dimensions = table.getDimensions();
        dimensions.put("vvId", this.mTrack.getVVId());
        dimensions.put(TableField.PLAYER_SOURCE, this.mTrack.getPlayerSource());
        dimensions.put(TableField.PS_ID, TrackUtil.getPsId(youkuVideoInfo));
        dimensions.put(TableField.MEDIA_TYPE, playVideoInfo.getPlayType().getValue() + "");
        dimensions.put(TableField.PLAY_WAY, TrackUtil.getPlayWay(this.mTrack, youkuVideoInfo));
        dimensions.put("adType", String.valueOf(i));
        dimensions.put("errorCode", String.valueOf(i2));
        dimensions.put("errorMsg", ErrorCodeUtil.getErrorMsg(i2));
        dimensions.put("videoVid", youkuVideoInfo.getVid());
        dimensions.put("videoShowId", youkuVideoInfo.getShowId());
        dimensions.put("videoFileformat", this.mTrack.getOnePlayTrack().getFileFormat(youkuVideoInfo));
        Map<String, Double> measures = table.getMeasures();
        String str = dimensions.get("adUrl");
        dimensions.put("adVid", TrackUtil.getValueByKeyFromUrl(str, "adVid"));
        dimensions.put("adFileformat", TrackUtil.getFileFormatByUrl(str));
        if (this.mTrack.getPlayerConfig().isExternal()) {
            return;
        }
        VpmProxy.commitAdErrorStatistics(dimensions, measures);
    }
}

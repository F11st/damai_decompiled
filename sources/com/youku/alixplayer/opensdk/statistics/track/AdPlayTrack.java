package com.youku.alixplayer.opensdk.statistics.track;

import com.youku.alixplayer.Reporter;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.statistics.Track;
import com.youku.alixplayer.opensdk.statistics.TrackUtil;
import com.youku.alixplayer.opensdk.statistics.framework.MSGTABLEID;
import com.youku.alixplayer.opensdk.statistics.proxy.VpmProxy;
import com.youku.vpm.constants.TableField;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class AdPlayTrack {
    public static final String TAG = "AdPlay";
    private Track mTrack;

    public AdPlayTrack(Track track) {
        this.mTrack = track;
    }

    public void commit(int i, int i2) {
        Map<String, String> allDims;
        PlayVideoInfo playVideoInfo = this.mTrack.getPlayVideoInfo();
        YoukuVideoInfo youkuVideoInfo = this.mTrack.getYoukuVideoInfo();
        Reporter reporter = this.mTrack.getReporter();
        if (reporter == null) {
            allDims = this.mTrack.mVPM.getTable(MSGTABLEID.AD_PLAY).getDimensions();
        } else {
            allDims = reporter.getAllDims(Reporter.MonitorTableName.AD_PLAY);
            if (allDims == null) {
                allDims = new HashMap<>();
            }
        }
        allDims.put("vvId", this.mTrack.getVVId());
        allDims.put(TableField.PLAYER_SOURCE, this.mTrack.getPlayerSource());
        allDims.put(TableField.PS_ID, TrackUtil.getPsId(youkuVideoInfo));
        allDims.put(TableField.MEDIA_TYPE, playVideoInfo.getPlayType().getValue() + "");
        allDims.put(TableField.PLAY_WAY, TrackUtil.getPlayWay(this.mTrack, youkuVideoInfo));
        allDims.put("adType", String.valueOf(i));
        allDims.put("videoVid", youkuVideoInfo.getVid());
        allDims.put("videoShowId", youkuVideoInfo.getShowId());
        allDims.put("videoFileformat", this.mTrack.getOnePlayTrack().getFileFormat(youkuVideoInfo));
        Map<String, Double> hashMap = new HashMap<>();
        if (reporter == null) {
            hashMap = this.mTrack.mVPM.getTable(MSGTABLEID.AD_PLAY).getMeasures();
        } else {
            Map<String, String> allValues = reporter.getAllValues(Reporter.MonitorTableName.AD_PLAY);
            if (allValues != null && allValues.size() > 0) {
                try {
                    for (Map.Entry<String, String> entry : allValues.entrySet()) {
                        hashMap.put(entry.getKey(), Double.valueOf(Double.parseDouble(entry.getValue())));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        allDims.put("adVid", playVideoInfo.getString("pre_adid_" + i2));
        allDims.put("adFileformat", TrackUtil.getFileFormatByUrl(allDims.get("adUrl")));
        if (this.mTrack.getPlayerConfig().isExternal()) {
            return;
        }
        VpmProxy.commitAdPlayStatistics(allDims, hashMap);
        TrackUtil.printlog("AdPlay", "AdPlay", allDims, hashMap);
    }
}

package com.youku.alixplayer.opensdk.statistics;

import com.youku.alixplayer.opensdk.AlixPlayerContainer;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.statistics.framework.MSGTABLEID;
import com.youku.alixplayer.opensdk.statistics.framework.table.Table;
import com.youku.alixplayer.opensdk.statistics.proxy.VpmProxy;
import com.youku.vpm.constants.TableField;
import java.util.Map;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class HeartBeatReporter extends BaseTrack {
    public static final String TAG = "HeartBeatReporter";
    boolean isLogin;
    boolean isVip;
    long lastReportTime;
    private double mIndex;
    private int mLastPositionSecond;
    private double mPlayTime;
    private AlixPlayerContainer mPlayer;
    long reportInterval;

    public HeartBeatReporter(Track track) {
        super(track);
        this.reportInterval = DateUtils.MILLIS_PER_MINUTE;
        this.mPlayer = track.getPlayerContainer();
    }

    public void OnCurrentPositionChangeListener(int i, Track track) {
        if (System.currentTimeMillis() - this.lastReportTime >= this.reportInterval) {
            this.lastReportTime = System.currentTimeMillis();
            sendHeartBeat(track);
        }
        int i2 = i / 1000;
        if (this.mLastPositionSecond != i2) {
            this.mLastPositionSecond = i2;
            this.mPlayTime += 1.0d;
        }
    }

    void sendHeartBeat(Track track) {
        this.isVip = "1.".equals(this.mPlayer.getPlayerConfig().getDynamicProperties().call(TableField.IS_VIP));
        this.isLogin = "1".equals(this.mPlayer.getPlayerConfig().getDynamicProperties().call("isLogin"));
        Table table = track.mVPM.getTable(MSGTABLEID.PLAYHEARTBEAT);
        YoukuVideoInfo youkuVideoInfo = this.mTrack.getYoukuVideoInfo();
        Map<String, String> dimensions = table.getDimensions();
        addBaseDimensions(dimensions);
        dimensions.put("isPlayer", this.mPlayer.isPlaying() ? "1" : "0");
        dimensions.put("memberType", this.isVip ? "vip" : "n/a");
        dimensions.put("isLogin", this.isLogin + "");
        dimensions.put("format", TrackUtil.getVideoFormat(this.mTrack.getCurrentQuality(), youkuVideoInfo != null ? youkuVideoInfo.getDolbyStreamType() : null));
        dimensions.put("index", String.valueOf(this.mIndex));
        dimensions.put("OrangeSession", this.mTrack.getApsVersion());
        dimensions.put(TableField.FILE_FORMAT, this.mTrack.getOnePlayTrack().getFileFormat(youkuVideoInfo));
        Map<String, Double> measures = table.getMeasures();
        addBaseMeasures(measures);
        measures.put("currentPlayDuraion", Double.valueOf(this.mPlayTime));
        this.mIndex += 1.0d;
        if (!this.mPlayer.getPlayerConfig().isExternal()) {
            TrackUtil.printlog("HeartBeatReporter", "", dimensions, measures);
            VpmProxy.commitHeartBeatStatistics(dimensions, measures);
        }
        this.mTrack.onMonitorPoint("playHeartbeat", dimensions, measures);
    }
}

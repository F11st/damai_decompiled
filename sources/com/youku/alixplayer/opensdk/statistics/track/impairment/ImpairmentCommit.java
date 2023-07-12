package com.youku.alixplayer.opensdk.statistics.track.impairment;

import com.ali.user.open.ucc.data.ApiConstants;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.statistics.BaseTrack;
import com.youku.alixplayer.opensdk.statistics.StaticsUtil;
import com.youku.alixplayer.opensdk.statistics.Track;
import com.youku.alixplayer.opensdk.statistics.TrackUtil;
import com.youku.alixplayer.opensdk.statistics.framework.MSGTABLEID;
import com.youku.alixplayer.opensdk.statistics.framework.table.Table;
import com.youku.alixplayer.opensdk.statistics.proxy.VpmProxy;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.vpm.constants.TableField;
import com.youku.vpm.data.ExtrasInfo;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ImpairmentCommit extends BaseTrack implements Track.OnExtrasBuildCallback {
    public static final String TAG = "Impairment";
    private double mConsumedSizeSEnd;
    private double mConsumedSizeStart;
    private double mDownLoadSizeEnd;
    private double mDownLoadSizeStart;
    private double mEndTime;
    private double mImpairmentInterval;
    private double mLoadingTotalTimeFromPlayer;
    private double mPosition;
    private double mStartTime;
    private Table mTable;
    private Track mTrack;

    public ImpairmentCommit(Track track, double d) {
        super(track);
        this.mLoadingTotalTimeFromPlayer = -1.0d;
        this.mDownLoadSizeStart = -1.0d;
        this.mConsumedSizeStart = -1.0d;
        this.mDownLoadSizeEnd = -1.0d;
        this.mConsumedSizeSEnd = -1.0d;
        this.mTrack = track;
        this.mStartTime = System.currentTimeMillis();
        this.mPosition = d;
        this.mTable = this.mTrack.mVPM.getTable(MSGTABLEID.IMPAIRMENT);
    }

    private double getCost(double d, double d2) {
        if (d2 <= 0.0d) {
            return -1.0d;
        }
        return d - d2;
    }

    @Override // com.youku.alixplayer.opensdk.statistics.Track.OnExtrasBuildCallback
    public void buildExtras(String str, Map<String, String> map) {
    }

    public void commit(YoukuVideoInfo youkuVideoInfo, double d, String str, int i, int i2, Object obj) {
        if (youkuVideoInfo == null) {
            return;
        }
        PlayVideoInfo playVideoInfo = this.mTrack.getPlayVideoInfo();
        Table table = getTable(MSGTABLEID.IMPAIRMENT);
        Map<String, String> dimensions = table.getDimensions();
        dimensions.put(ApiConstants.ApiField.USER_ACTION, str);
        dimensions.put("VPMIndex", String.valueOf(this.mTrack.getVPMIndex()));
        dimensions.put("isAuto", TrackUtil.isAuto(playVideoInfo) ? "1" : "0");
        dimensions.put("userId", this.mTrack.getUserId());
        dimensions.put(TableField.VV_SOURCE, playVideoInfo.getString(TableField.VV_SOURCE));
        dimensions.put("sourceIdentity", "优酷");
        dimensions.put("netStatus", StaticsUtil.getNetStatus());
        dimensions.put(TableField.IS_VIP, this.mTrack.isVip() ? "1" : "0");
        dimensions.put("preloadinfo", playVideoInfo.getString(TableField.PRELOAD_INFO));
        dimensions.put("OrangeSession", this.mTrack.getApsVersion());
        Map extras = this.mTrack.getExtras(youkuVideoInfo);
        extras.put("downloadsizeStart", this.mDownLoadSizeStart + "");
        extras.put("consumedsizeStart", this.mConsumedSizeStart + "");
        extras.put("downloadsizeEnd", this.mDownLoadSizeEnd + "");
        extras.put("consumedsizeEnd", this.mConsumedSizeSEnd + "");
        extras.put("netM3sScore", playVideoInfo.getString("netM3sScore", "-5"));
        dimensions.put(ExtrasInfo.EXTRAS, extras.toString());
        this.mTrack.buildExtras(dimensions, playVideoInfo, youkuVideoInfo, this);
        Map<String, Double> measures = table.getMeasures();
        measures.put("impairmentDuration", Double.valueOf(getImpairmentDuration()));
        measures.put("impairmentInterval", Double.valueOf(this.mImpairmentInterval));
        measures.put("impairmentVideoPosition", Double.valueOf(this.mPosition));
        measures.put("impairmentOrder", Double.valueOf(d));
        measures.put("speedX", Double.valueOf(1.0d));
        measures.put("impairmentStartTime", Double.valueOf(this.mStartTime));
        measures.put("impairmentEndTime", Double.valueOf(this.mEndTime));
        measures.put("impairmentStartTimeVV", Double.valueOf(this.mTrack.getOnePlayTrack().getPlayTime()));
        measures.put("durationAfterSeek", Double.valueOf(getCost(System.currentTimeMillis(), this.mTrack.getSeekChangeTrack().getEndTime())));
        measures.put("durationAfterTune", Double.valueOf(getCost(System.currentTimeMillis(), this.mTrack.getQualityChangeTrack().getEndTime())));
        measures.put("loadingTotalTimeFromPlayer", Double.valueOf(this.mLoadingTotalTimeFromPlayer));
        if (str != "waiting" && str != "videostart" && str != "lowspeed") {
            measures.put("currentBufferDuration", Double.valueOf(TrackUtil.getDoubleValue(this.mTrack.getParamsFromCore("currentBufferDuration", "-1"))));
        }
        VpmProxy.commitImpairmentStatistic(dimensions, measures);
        TrackUtil.printlog("Impairment", "impairment", dimensions, measures);
        TLogUtil.vpmLog("Impairment:baseInfo:" + dimensions.toString());
        TLogUtil.vpmLog("Impairment:statisticsInfo:" + measures.toString());
        this.mTrack.onMonitorPoint("impairment", dimensions, measures);
    }

    public String getDimension(String str) {
        return this.mTable.getDimensions().get(str);
    }

    public double getEndTime() {
        return this.mEndTime;
    }

    public double getImpairmentDuration() {
        return this.mLoadingTotalTimeFromPlayer;
    }

    public double getStartTime() {
        return this.mStartTime;
    }

    public void onLoadingEnd() {
        double currentTimeMillis = System.currentTimeMillis();
        this.mEndTime = currentTimeMillis;
        this.mLoadingTotalTimeFromPlayer = currentTimeMillis - this.mStartTime;
    }

    public void setConsumedSizeSEnd(double d) {
        this.mConsumedSizeSEnd = d;
    }

    public void setConsumedSizeStart(double d) {
        this.mConsumedSizeStart = d;
    }

    public void setDownLoadSizeEnd(double d) {
        this.mDownLoadSizeEnd = d;
    }

    public void setDownLoadSizeStart(double d) {
        this.mDownLoadSizeStart = d;
    }

    public void setImpairmentInterval(double d) {
        this.mImpairmentInterval = d;
    }
}

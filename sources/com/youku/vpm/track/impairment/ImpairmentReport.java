package com.youku.vpm.track.impairment;

import com.ali.user.open.ucc.data.ApiConstants;
import com.youku.vpm.BaseTrack;
import com.youku.vpm.IVpmFullInfo;
import com.youku.vpm.data.ExtrasInfo;
import com.youku.vpm.framework.Table;
import com.youku.vpm.framework.TableId;
import com.youku.vpm.proxy.VpmProxy;
import com.youku.vpm.track.Track;
import com.youku.vpm.utils.TLogUtil;
import com.youku.vpm.utils.TrackUtil;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ImpairmentReport extends BaseTrack implements BaseTrack.OnExtrasBuildCallback {
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
    private Track mTrack;

    public ImpairmentReport(Track track, double d) {
        super(track);
        this.mLoadingTotalTimeFromPlayer = -1.0d;
        this.mDownLoadSizeStart = -1.0d;
        this.mConsumedSizeStart = -1.0d;
        this.mDownLoadSizeEnd = -1.0d;
        this.mConsumedSizeSEnd = -1.0d;
        this.mTrack = track;
        this.mStartTime = System.currentTimeMillis();
        this.mPosition = d;
    }

    private double getCost(double d, double d2) {
        if (d2 <= 0.0d) {
            return -1.0d;
        }
        return d - d2;
    }

    @Override // com.youku.vpm.BaseTrack.OnExtrasBuildCallback
    public void buildExtras(String str, Map<String, String> map) {
        if (ExtrasInfo.EXTRAS.equals(str)) {
            map.put("downloadsizeStart", this.mDownLoadSizeStart + "");
            map.put("consumedsizeStart", this.mConsumedSizeStart + "");
            map.put("downloadsizeEnd", this.mDownLoadSizeEnd + "");
            map.put("consumedsizeEnd", this.mConsumedSizeSEnd + "");
            map.put("netM3sScore", this.mTrack.getVpmInfo().getString("netM3sScore", "-5"));
        }
    }

    public void commit(IVpmFullInfo iVpmFullInfo, double d, String str, int i, int i2, Object obj) {
        if (iVpmFullInfo == null) {
            return;
        }
        Table tableWithCreate = getTableWithCreate(TableId.IMPAIRMENT);
        Map<String, String> dimensions = tableWithCreate.getDimensions();
        dimensions.put(ApiConstants.ApiField.USER_ACTION, str);
        this.mTrack.buildExtras("impairment", dimensions, this);
        Map<String, Double> measures = tableWithCreate.getMeasures();
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
        TrackUtil.printlog(this.mTrack.getContext(), "Impairment", "impairment", dimensions, measures);
        TLogUtil.vpmLog("Impairment:baseInfo:" + dimensions.toString());
        TLogUtil.vpmLog("Impairment:statisticsInfo:" + measures.toString());
        this.mTrack.onMonitorPoint("impairment", dimensions, measures);
    }

    public String getDimension(String str) {
        return this.mTrack.getTable(TableId.IMPAIRMENT).getDimensions().get(str);
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

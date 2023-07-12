package com.youku.vpm.track;

import android.text.TextUtils;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.youku.live.dsl.config.IDynamicConfig;
import com.youku.media.arch.instruments.utils.RemoteLogger;
import com.youku.vpm.BaseTrack;
import com.youku.vpm.IPlayer;
import com.youku.vpm.IVpmFullInfo;
import com.youku.vpm.IVpmInfo;
import com.youku.vpm.PlayCostTime;
import com.youku.vpm.PlayTimeTrack;
import com.youku.vpm.PlayerTrack;
import com.youku.vpm.framework.Table;
import com.youku.vpm.framework.TableId;
import com.youku.vpm.proxy.VpmProxy;
import com.youku.vpm.utils.LogUtil;
import com.youku.vpm.utils.StaticsUtil;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class OnePlayTrack extends BaseTrack implements BaseTrack.OnExtrasBuildCallback {
    public static final String TAG = "OnePlay";
    private static boolean sIsFirstPlay = true;
    private long bufferLatency;
    private String isAdLocalPath;
    private int mCpuUsage;
    private int mCpuUsageCount;
    private double mFeelingStartDuration;
    private final boolean mIsFirstPlay;
    private boolean mIsPlay;
    private int mLoopPlayIndex;
    private OnePlayExtrasTrack mOnePlayExtrasTrack;
    private PlayCostTime mPlayCostTime;
    private PlayTimeTrack mPlayTimeTrack;
    private double mSwitchCount;
    private String netStatus;
    private long videoFirstFrameDuration;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private interface PlayType {
        public static final String BEGIN = "begin";
        public static final String END = "end";
    }

    public OnePlayTrack(PlayerTrack playerTrack, Track track) {
        super(track);
        this.videoFirstFrameDuration = 0L;
        this.mFeelingStartDuration = -1.0d;
        this.mPlayTimeTrack = this.mTrack.getPlayTimeTrack();
        this.mPlayCostTime = new PlayCostTime();
        this.mOnePlayExtrasTrack = new OnePlayExtrasTrack(track);
        this.mIsFirstPlay = sIsFirstPlay;
    }

    private double calculateCpuUsage() {
        int i = this.mCpuUsageCount;
        if (i > 0) {
            return this.mCpuUsage / i;
        }
        return -1.0d;
    }

    private void commitPlayKeyStatistics(String str, int i) {
        IVpmInfo vpmInfo = this.mTrack.getVpmInfo();
        IVpmFullInfo vpmFullInfo = this.mTrack.getVpmFullInfo();
        IPlayer player = this.mTrack.getPlayer();
        TableId tableId = TableId.ONEPLAY;
        Table tableWithCreate = getTableWithCreate(tableId);
        Map<String, String> dimensions = "end".equals(str) ? this.mTrack.getTable(tableId).getDimensions() : tableWithCreate.getDimensions();
        dimensions.put("playType", str);
        dimensions.put("VPMIndex", String.valueOf(this.mTrack.getVPMIndex()));
        dimensions.put("userId", this.mTrack.getUserId());
        dimensions.put("isFirstPlay", this.mIsFirstPlay ? "1" : "0");
        dimensions.put("freeFlowType", getFreeFlowType());
        dimensions.put("isAdLocalPath", this.isAdLocalPath);
        dimensions.put("beforeDurationAdtype", this.mTrack.getAdTrack().getBeforeDurationAdtype());
        dimensions.put("vvEndTime", player.getString("vvEndTime", null));
        dimensions.put("loopPlayIndex", this.mLoopPlayIndex + "");
        dimensions.put("playTime", getPlayTime() + "");
        dimensions.put("startClarity", this.mTrack.getDimFromInfo("startClarity", null));
        dimensions.put("netStatus", this.netStatus);
        dimensions.put("OrangeSession", this.mTrack.getApsVersion());
        this.mTrack.buildExtras("onePlay", dimensions, this);
        Map<String, Double> measures = "end".equals(str) ? this.mTrack.mTableBuilder.getTable(tableId).getMeasures() : tableWithCreate.getMeasures();
        measures.put("bufferLatency", Double.valueOf(this.bufferLatency));
        measures.put("videoFirstFrameDuration", Double.valueOf(this.videoFirstFrameDuration));
        measures.put("feelingStartDuration", Double.valueOf(this.mFeelingStartDuration));
        measures.put("impairmentDuration", Double.valueOf(this.mTrack.getImpairmentTrack().getImpairmentDuration()));
        measures.put("impairmentFrequency", Double.valueOf(this.mTrack.getImpairmentTrack().getImpairmentFrequency()));
        measures.put("duration", Double.valueOf(this.mPlayCostTime.getPlayTime()));
        measures.put("videoPlayDuration", Double.valueOf(vpmFullInfo != null ? vpmFullInfo.getDouble("duration", 0.0d) : 0.0d));
        measures.put("FrameLossCount", Double.valueOf(this.mTrack.getImpairmentTrack().getDropCount()));
        measures.put("cpuUsage", Double.valueOf(calculateCpuUsage()));
        measures.put("speedX", Double.valueOf(player.getDouble("speedX", 0.0d)));
        measures.put("switchCount", Double.valueOf(this.mSwitchCount));
        measures.put("beginStage", Double.valueOf(i));
        measures.put("seekDuration", Double.valueOf(this.mTrack.getSeekChangeTrack().getSeekDuration()));
        measures.put("seekCount", Double.valueOf(this.mTrack.getSeekChangeTrack().getSeekCount()));
        measures.put("adPlayDuration", Double.valueOf(this.mTrack.getAdTrack().getEndPreAdTime()));
        measures.put("startPosition", Double.valueOf(vpmInfo.getDouble("startPosition", -1.0d)));
        measures.put("renderMode", Double.valueOf(vpmInfo.getDouble("renderMode", -1.0d)));
        measures.put("p2pCode", Double.valueOf(vpmInfo.getDouble("p2pCode", -1.0d)));
        measures.put("bufferModeStrategy", Double.valueOf(vpmInfo.getDouble("bufferModeStrategy", -1.0d)));
        measures.put("playTime", Double.valueOf(getPlayTime()));
        measures.put("ipChangeTotalCnt", Double.valueOf(this.mTrack.getOneEventTrack().getIpChangeTotalCnt()));
        measures.put("ipChangeSuccCnt", Double.valueOf(this.mTrack.getOneEventTrack().getIpChangeSuccCnt()));
        measures.put("drm_support", Double.valueOf(this.mTrack.getPlayer().getDouble("", 0.0d)));
        measures.putAll(this.mPlayTimeTrack.getFastPlayTimes());
        measures.putAll(this.mPlayTimeTrack.getPlayerCoreTimes());
        VpmProxy.commitOnePlayStatistics(dimensions, measures);
        LogUtil.printLog("OnePlay-" + str, dimensions, measures);
        RemoteLogger.log("OnePlay-" + str, ":baseInfo:" + dimensions.toString());
        RemoteLogger.log("OnePlay-" + str, ":statisticsInfo:" + measures.toString());
        if ("end".equals(str)) {
            this.mOnePlayExtrasTrack.commit();
        }
        this.mTrack.onMonitorPoint("onePlay", dimensions, measures);
    }

    private void onFirstFrame() {
        if (this.mIsPlay) {
            return;
        }
        sIsFirstPlay = false;
        this.mIsPlay = true;
        long currentTimeMillis = System.currentTimeMillis();
        this.mPlayTimeTrack.putTimestamp("adStartTs", currentTimeMillis);
        this.mPlayTimeTrack.putTimestamp("realVideoStartTs", currentTimeMillis);
        long timestamp = this.mPlayTimeTrack.getTimestamp("playTs");
        long timestamp2 = this.mPlayTimeTrack.getTimestamp("clickTs");
        this.mFeelingStartDuration = timestamp2 > 0 ? currentTimeMillis - timestamp2 : currentTimeMillis - this.mPlayTimeTrack.getTimestamp("playTs");
        long j = currentTimeMillis - timestamp;
        this.videoFirstFrameDuration = j;
        if (this.mTrack.getAdTrack().getEndPreAdTime() != 0) {
            this.bufferLatency = currentTimeMillis - this.mTrack.getAdTrack().getEndPreAdTime();
        } else {
            this.bufferLatency = j;
        }
        this.mPlayTimeTrack.finish();
    }

    public void addSwitchCounts() {
        this.mSwitchCount += 1.0d;
    }

    @Override // com.youku.vpm.BaseTrack.OnExtrasBuildCallback
    public void buildExtras(String str, Map<String, String> map) {
        IVpmInfo vpmInfo = this.mTrack.getVpmInfo();
        IVpmFullInfo vpmFullInfo = this.mTrack.getVpmFullInfo();
        map.put("changeOnline", vpmInfo.getString("changeOnline", null));
        map.put("changeOffline", vpmInfo.getString("changeOffline", null));
        if (vpmFullInfo != null) {
            map.put("stSorted", vpmFullInfo.getString("stSorted", null));
        }
        map.put("netCostFrom", vpmInfo.getString("netCostFrom", null));
        map.put("enterType", vpmInfo.getString("enterType", null));
        map.put(IDynamicConfig.KEY_DEVICE_SCORE, vpmInfo.getString(IDynamicConfig.KEY_DEVICE_SCORE, null));
        map.put("adReqTime", vpmInfo.getString("adReqTime", null));
        map.put("subtitleFail", vpmInfo.getString("subtitleFail", null));
        map.put("playtrigger", TextUtils.isEmpty(vpmInfo.getString("LUCSessionID", null)) ? "no" : BQCCameraParam.VALUE_YES);
        map.put("rotateStayTime", (this.mPlayTimeTrack.getRotateStayTime() / 1000) + "");
    }

    public String getFreeFlowType() {
        return this.mTrack.getPlayerTrack().getDynamicProperty("freeFlowType");
    }

    public int getLoopPlayIndex() {
        return this.mLoopPlayIndex;
    }

    public double getPlayTime() {
        return this.mPlayCostTime.getPlayTime();
    }

    public void onAdStart() {
        onFirstFrame();
    }

    public void onCpuUsage(int i) {
        this.mCpuUsage += i;
        this.mCpuUsageCount++;
    }

    public void onCurrentPositionUpdate(int i) {
        this.mPlayCostTime.onCurrentPositionUpdate(i, -1);
    }

    public void onRealVideoStart() {
        onFirstFrame();
    }

    public void onVVBegin(int i) {
        this.netStatus = StaticsUtil.getNetStatus();
        commitPlayKeyStatistics(PlayType.BEGIN, i);
    }

    public void onVVEnd() {
        commitPlayKeyStatistics("end", 0);
    }

    public void setIsADPlayFromCache(int i) {
        if (TextUtils.isEmpty(this.isAdLocalPath)) {
            this.isAdLocalPath = String.valueOf(i);
        }
    }

    public void setLoopPlayIndex(int i) {
        this.mLoopPlayIndex = i;
    }
}

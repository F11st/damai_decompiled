package com.youku.alixplayer.opensdk.statistics;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.youku.alixplayer.instances.Aliplayer;
import com.youku.alixplayer.opensdk.FileFormat;
import com.youku.alixplayer.opensdk.IVideoStream;
import com.youku.alixplayer.opensdk.PlayType;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.live.LiveInfo;
import com.youku.alixplayer.opensdk.statistics.Track;
import com.youku.alixplayer.opensdk.statistics.framework.MSGTABLEID;
import com.youku.alixplayer.opensdk.statistics.framework.table.Table;
import com.youku.alixplayer.opensdk.statistics.proxy.VpmProxy;
import com.youku.alixplayer.opensdk.ups.data.BitStream;
import com.youku.alixplayer.opensdk.ups.data.Quality;
import com.youku.alixplayer.opensdk.ups.data.StreamSegItem;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.alixplayer.opensdk.utils.ProvisionAuthenticator;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.android.liveservice.bean.BypassPlayInfo;
import com.youku.android.liveservice.bean.VideoInfo;
import com.youku.vpm.constants.TableField;
import com.youku.vpm.data.ExtrasInfo;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class VVTrack extends BaseTrack implements Track.OnExtrasBuildCallback {
    public static final String TAG = "OnePlay";
    private static final String VV_BEGIN = "begin";
    private static final String VV_END = "end";
    private long bufferLatency;
    private long dolbyMaxDuration;
    private String isAdLocalPath;
    private double mBeforeNavTime;
    private int mCpuUsage;
    private int mCpuUsageCount;
    private double mFeelingStartDuration;
    private String mFileFormat;
    private boolean mIsPlay;
    private long mLiveControlEndTime;
    private long mLiveControlStartTime;
    private int mLoopPlayIndex;
    private long mNewRequestStartTime;
    private String mParams;
    private PlayCostTime mPlayCostTime;
    private PlayTimeTrack mPlayTimeTrack;
    private long mPrepareStartTime;
    private long mStartedTime;
    private double mSwitchCount;
    protected int mVideoIndex;
    private String netStatus;
    protected long playTime;
    private long videoFirstFrameDuration;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public enum PlayMode {
        ON_WALL,
        ON_SCROLL,
        ON_REFRESH
    }

    public VVTrack(PlayerTrack playerTrack, Track track) {
        super(track);
        this.videoFirstFrameDuration = 0L;
        this.dolbyMaxDuration = 0L;
        this.playTime = 0L;
        this.mFeelingStartDuration = -1.0d;
        this.mVideoIndex = 0;
        this.mPlayTimeTrack = this.mTrack.getPlayTimeTrack();
        this.mPlayCostTime = new PlayCostTime();
    }

    private double calculateCpuUsage() {
        int i = this.mCpuUsageCount;
        if (i > 0) {
            return this.mCpuUsage / i;
        }
        return -1.0d;
    }

    private void commitPlayKeyStatistics(String str, int i) {
        Map<String, String> dimensions;
        Map<String, Double> measures;
        PlayVideoInfo playVideoInfo = this.mTrack.getPlayVideoInfo();
        YoukuVideoInfo youkuVideoInfo = this.mTrack.getYoukuVideoInfo();
        MSGTABLEID msgtableid = MSGTABLEID.ONEPLAY;
        Table table = getTable(msgtableid);
        if ("end".equals(str)) {
            dimensions = this.mTrack.getTable(msgtableid).getDimensions();
        } else {
            dimensions = table.getDimensions();
        }
        dimensions.put("playType", str);
        dimensions.put("VPMIndex", String.valueOf(this.mTrack.getVPMIndex()));
        dimensions.put("userId", this.mTrack.getUserId());
        dimensions.put("isAuto", TrackUtil.isAuto(playVideoInfo) ? "1" : "0");
        dimensions.put(TableField.VV_SOURCE, playVideoInfo.getString(TableField.VV_SOURCE));
        dimensions.put("preloadinfo", this.mTrack.getString(TableField.PRELOAD_INFO));
        dimensions.put("deviceChip", TrackUtil.getCpuName(this.mTrack.getContext()));
        dimensions.put("isFirstPlay", this.mTrack.isFirstPlay() ? "1" : "0");
        dimensions.put("freeFlowType", getFreeFlowType());
        dimensions.put(TableField.IS_VIP, this.mTrack.isVip() ? "1" : "0");
        dimensions.put("sourceIdentity", "优酷");
        dimensions.put("isAdLocalPath", this.isAdLocalPath);
        dimensions.put("beforeDurationAdtype", this.mTrack.getAdTrack().getAdType());
        dimensions.put("vvEndTime", String.valueOf(this.mTrack.getPlayerContainer().getPlayer().getCurrentPosition(Aliplayer.PositionType.NORMAL)));
        dimensions.put("DolbyType", youkuVideoInfo != null ? youkuVideoInfo.getDolbyStreamType() : null);
        dimensions.put("loopPlayIndex", this.mLoopPlayIndex + "");
        dimensions.put("playTime", getPlayTime() + "");
        dimensions.put("startClarity", TrackUtil.getStartClarity(youkuVideoInfo));
        dimensions.put("netStatus", this.netStatus);
        dimensions.put("OrangeSession", this.mTrack.getApsVersion());
        this.mTrack.buildExtras(dimensions, playVideoInfo, youkuVideoInfo, this);
        if ("end".equals(str)) {
            measures = this.mTrack.mVPM.getTable(msgtableid).getMeasures();
        } else {
            measures = table.getMeasures();
        }
        dimensions.put(ExtrasInfo.EXTRAS, getExtras(measures));
        Double d = new Double(this.bufferLatency);
        Double d2 = new Double(this.videoFirstFrameDuration);
        measures.put("bufferLatency", d);
        measures.put("videoFirstFrameDuration", d2);
        measures.put("feelingStartDuration", Double.valueOf(this.mFeelingStartDuration));
        measures.put("impairmentDuration", Double.valueOf(this.mTrack.getImpairmentTrack().getImpairmentDuration()));
        measures.put("impairmentFrequency", Double.valueOf(this.mTrack.getImpairmentTrack().getImpairmentFrequency()));
        measures.put("videoPlayDuration", Double.valueOf(youkuVideoInfo != null ? youkuVideoInfo.getDuration() : 0.0d));
        measures.put("duration", Double.valueOf(this.mPlayCostTime.getPlayTime()));
        measures.put("FrameLossCount", Double.valueOf(this.mTrack.getImpairmentTrack().getDropCount()));
        measures.put("cpuUsage", Double.valueOf(calculateCpuUsage()));
        measures.put("speedX", Double.valueOf(playVideoInfo.getDouble("speedX", 0.0d)));
        measures.put("DolbyTime", Double.valueOf(this.dolbyMaxDuration));
        measures.put("switchCount", Double.valueOf(this.mSwitchCount));
        measures.put("beginStage", Double.valueOf(i));
        measures.put("D_ReadHistory", Double.valueOf(this.mTrack.getPlayVideoInfo().getDouble("D_ReadHistory", 0.0d)));
        measures.put("seekDuration", Double.valueOf(this.mTrack.getSeekChangeTrack().getSeekDuration()));
        measures.put("seekCount", Double.valueOf(this.mTrack.getSeekChangeTrack().getSeekCount()));
        measures.put("adPlayDuration", Double.valueOf(this.mTrack.getAdTrack().getEndPreAdTime()));
        measures.put("startPosition", Double.valueOf(playVideoInfo.getDouble("startPosition", -1.0d)));
        measures.put("renderMode", Double.valueOf(playVideoInfo.getDouble("renderMode", -1.0d)));
        measures.put("p2pCode", Double.valueOf(TrackUtil.getDoubleValue(playVideoInfo.getString("p2pCode", "-1"))));
        measures.put("bufferModeStrategy", Double.valueOf(playVideoInfo.getDouble("bufferModeStrategy", -1.0d)));
        measures.put("playTime", Double.valueOf(getPlayTime()));
        measures.put("ipChangeTotalCnt", Double.valueOf(this.mTrack.getOneEventTrack().getIpChangeTotalCnt()));
        measures.put("ipChangeSuccCnt", Double.valueOf(this.mTrack.getOneEventTrack().getIpChangeSuccCnt()));
        measures.put("drm_support", Double.valueOf(ProvisionAuthenticator.getWidevineStats()));
        measures.putAll(this.mPlayTimeTrack.getFastPlayTimes());
        measures.putAll(this.mPlayTimeTrack.getPlayerCoreTimes());
        if (isEmpty(dimensions.get(TableField.FILE_FORMAT)) && youkuVideoInfo != null) {
            String fileFormat = getFileFormat(youkuVideoInfo);
            this.mFileFormat = fileFormat;
            dimensions.put(TableField.FILE_FORMAT, fileFormat);
        }
        VpmProxy.commitOnePlayStatistics(dimensions, measures);
        TrackUtil.printlog("OnePlay-" + str, "VV " + str, dimensions, measures);
        TLogUtil.vpmLog("OnePlay-" + str + ":baseInfo:" + dimensions.toString());
        TLogUtil.vpmLog("OnePlay-" + str + ":statisticsInfo:" + measures.toString());
        if ("begin".equals(str)) {
            Logger.d("OnePlay-" + str, this.mPlayTimeTrack.getFastPlayTimes().toString());
            Logger.d("OnePlay-" + str, this.mPlayTimeTrack.getTimestamps().toString());
            Logger.d("OnePlay-" + str, this.mPlayTimeTrack.getPlayerCoreTimes().toString());
            Logger.d("OnePlay-" + str, this.mPlayTimeTrack.getPlayerCoreTimestamp().toString());
        }
        this.mTrack.onMonitorPoint("onePlay", dimensions, measures);
    }

    private long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x03ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getExtras(java.util.Map<java.lang.String, java.lang.Double> r19) {
        /*
            Method dump skipped, instructions count: 1046
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.alixplayer.opensdk.statistics.VVTrack.getExtras(java.util.Map):java.lang.String");
    }

    private String getHlsInfoFromUrl(String str) {
        return (str == null || !"1".equals(Uri.parse(str).getQueryParameter("sm"))) ? "0" : "1";
    }

    private void onFirstFrame() {
        if (this.mIsPlay) {
            return;
        }
        this.mIsPlay = true;
        this.mPlayTimeTrack.putTimestamp("adStartTs", System.currentTimeMillis());
        this.mPlayTimeTrack.putTimestamp("realVideoStartTs", System.currentTimeMillis());
        long currentTimeMillis = System.currentTimeMillis();
        this.mStartedTime = currentTimeMillis;
        long playStartTime = this.mPlayTimeTrack.getPlayStartTime();
        long clickStartTime = this.mPlayTimeTrack.getClickStartTime();
        if (clickStartTime > 0) {
            this.mFeelingStartDuration = currentTimeMillis - clickStartTime;
        } else {
            this.mFeelingStartDuration = currentTimeMillis - this.mPlayTimeTrack.getWillAppearTime();
        }
        long j = currentTimeMillis - playStartTime;
        this.videoFirstFrameDuration = j;
        if (this.mTrack.getAdTrack().getEndPreAdTime() != 0) {
            this.bufferLatency = currentTimeMillis - this.mTrack.getAdTrack().getEndPreAdTime();
        } else {
            this.bufferLatency = j;
        }
        this.mLiveControlStartTime = this.mPlayTimeTrack.getLiveControlStartTime();
        this.mLiveControlEndTime = this.mPlayTimeTrack.getLiveControlEndTime();
        this.mNewRequestStartTime = this.mPlayTimeTrack.getNewRequestStartTime();
        this.mPrepareStartTime = this.mPlayTimeTrack.getPrepareStartTime();
        this.mPlayTimeTrack.finish();
    }

    public void addSwitchCounts() {
        this.mSwitchCount += 1.0d;
    }

    @Override // com.youku.alixplayer.opensdk.statistics.Track.OnExtrasBuildCallback
    public void buildExtras(String str, Map<String, String> map) {
    }

    protected double getDoubleValue(String str) {
        try {
            return Double.valueOf(str).doubleValue();
        } catch (Exception unused) {
            VpmProxy.alarmCommitFail("vpm", "commitPlayKeyStatistics", HiAnalyticsConstant.KeyAndValue.NUMBER_01, str);
            return 0.0d;
        }
    }

    public String getFileFormat(YoukuVideoInfo youkuVideoInfo) {
        String str = null;
        if (youkuVideoInfo != null && this.mTrack.getPlayVideoInfo().getPlayType() == PlayType.LIVE) {
            LiveInfo liveInfo = youkuVideoInfo.getLiveInfo();
            if (liveInfo != null) {
                BypassPlayInfo bypassPlayInfo = liveInfo.bypassPlayInfo;
                if (bypassPlayInfo != null) {
                    String str2 = bypassPlayInfo.url;
                    if (!isEmpty(str2)) {
                        str = TrackUtil.getFileFormatByUrl(str2);
                    }
                }
                return (!isEmpty(str) || liveInfo.getFileFormat() == FileFormat.UNKNOWN) ? str : liveInfo.getFileFormat().getStatistics();
            }
            return null;
        }
        if (isEmpty(null) && youkuVideoInfo != null) {
            str = TrackUtil.getFileFormatByUrl(getUrl(youkuVideoInfo));
        }
        if (isEmpty(str)) {
            str = this.mTrack.getPlayVideoInfo().getString(TableField.FILE_FORMAT, "-1");
        }
        return str != null ? str : "-1";
    }

    public String getFreeFlowType() {
        if (this.mTrack.getPlayerConfig().getDynamicProperties() != null) {
            return this.mTrack.getPlayerConfig().getDynamicProperties().call("freeFlowType");
        }
        return null;
    }

    public String getIsPlayFromCache() {
        return this.mTrack.getTable(MSGTABLEID.ONEPLAY).getDimensions().get("isPlayFromCache");
    }

    public int getLoopPlayIndex() {
        return this.mLoopPlayIndex;
    }

    public String getParams() {
        return this.mParams;
    }

    public double getPlayTime() {
        return this.mPlayCostTime.getPlayTime();
    }

    public PlayTimeTrack getPlayTimeTrack() {
        return this.mPlayTimeTrack;
    }

    public String getPlayWay(YoukuVideoInfo youkuVideoInfo) {
        return "net";
    }

    public String getPushStreamType(YoukuVideoInfo youkuVideoInfo) {
        LiveInfo liveInfo;
        VideoInfo videoInfo;
        return (youkuVideoInfo == null || this.mTrack.getPlayVideoInfo().getPlayType() != PlayType.LIVE || (liveInfo = youkuVideoInfo.getLiveInfo()) == null || (videoInfo = liveInfo.videoInfo) == null) ? "" : videoInfo.pushStreamType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getUrl(YoukuVideoInfo youkuVideoInfo) {
        IVideoStream videoStream;
        BitStream currentBitStream;
        int i;
        String str = this.mTrack.getTable(MSGTABLEID.ONEPLAY).getDimensions().get("URL");
        if (isEmpty(str)) {
            if (youkuVideoInfo == null || (videoStream = this.mTrack.getPlayerContainer().getVideoStream()) == null || (currentBitStream = videoStream.getCurrentBitStream()) == null) {
                return null;
            }
            Quality quality = currentBitStream.getQuality();
            String m3u8Text = currentBitStream.getM3u8Text();
            String m3u8Url = currentBitStream.getM3u8Url();
            if (quality != Quality.AUTO || TextUtils.isEmpty(m3u8Text)) {
                if (TextUtils.isEmpty(m3u8Url) || !"1".equals(Uri.parse(m3u8Url).getQueryParameter("sm"))) {
                    List<StreamSegItem> streamSegList = currentBitStream.getStreamSegList();
                    if (streamSegList == null || streamSegList.size() <= 0 || this.mVideoIndex >= streamSegList.size() || (i = this.mVideoIndex) < 0) {
                        return null;
                    }
                    StreamSegItem streamSegItem = streamSegList.get(i);
                    if (streamSegItem != null) {
                        if (TextUtils.isEmpty(streamSegItem.getCDNUrl())) {
                            return !TextUtils.isEmpty(streamSegItem.getRTMPUrl()) ? streamSegItem.getRTMPUrl() : str;
                        }
                        return streamSegItem.getCDNUrl();
                    }
                    return str;
                }
                return m3u8Url;
            }
            return m3u8Text;
        }
        return str;
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
        commitPlayKeyStatistics("begin", i);
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

    public void setPrepareInfo(int i, int i2, Object obj, long j) {
        TLogUtil.loge("OnePlay", "setPrepareInfo:  obj:" + String.valueOf(obj));
        if (obj != null) {
            this.mParams = String.valueOf(obj);
        }
    }
}

package com.youku.alixplayer.opensdk.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.Reporter;
import com.youku.alixplayer.opensdk.AlixPlayerContainer;
import com.youku.alixplayer.opensdk.AlixVideoItem;
import com.youku.alixplayer.opensdk.IVideoStream;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.statistics.OnPlayerTrackListener;
import com.youku.alixplayer.opensdk.statistics.data.ExtraMap;
import com.youku.alixplayer.opensdk.statistics.data.ExtrasNetm3sInfo;
import com.youku.alixplayer.opensdk.statistics.data.ExtrasPlayerInfo;
import com.youku.alixplayer.opensdk.statistics.data.ExtrasVideoInfo;
import com.youku.alixplayer.opensdk.statistics.framework.MSGTABLEID;
import com.youku.alixplayer.opensdk.statistics.framework.VPM;
import com.youku.alixplayer.opensdk.statistics.framework.table.Table;
import com.youku.alixplayer.opensdk.statistics.track.OneChangeTrack;
import com.youku.alixplayer.opensdk.statistics.track.OneEventTrack;
import com.youku.alixplayer.opensdk.statistics.track.PlayAbnormalDetailTrack;
import com.youku.alixplayer.opensdk.statistics.track.PlayAbnormalSummaryTrack;
import com.youku.alixplayer.opensdk.statistics.track.SubtitleEventTrack;
import com.youku.alixplayer.opensdk.statistics.track.impairment.ImpairmentTrack;
import com.youku.alixplayer.opensdk.statistics.track.quality.QualityChangeTrack;
import com.youku.alixplayer.opensdk.statistics.track.seek.SeekChangeTrack;
import com.youku.alixplayer.opensdk.ups.data.BitStream;
import com.youku.alixplayer.opensdk.ups.data.Quality;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.vpm.constants.TableField;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class Track implements ITrack {
    public static final String TAG = "Track";
    public boolean isFromPreload;
    private boolean isRealVideoCompletion;
    private boolean isVVActive;
    private Context mContext;
    private boolean mIsFirstPlay;
    private boolean mIsGetVideoInfoSuccess;
    private List<OnPlayerTrackListener> mOnPlayerTrackListeners;
    private final PlayTimeTrack mPlayTimeTrack;
    private PlayVideoInfo mPlayVideoInfo;
    public final AlixPlayerContainer mPlayerContainer;
    private PlayerTrack mPlayerTrack;
    public double mSpeedX;
    private final VVTrack mVVTrack;
    private YoukuVideoInfo mVideoInfo;
    private boolean isRealVideoStarted = false;
    private Map<String, String> mParamsFromCore = new ConcurrentHashMap();
    private Map<String, String> mStringMap = new ConcurrentHashMap();
    private List<OnExtrasBuildCallback> mOnExtrasBuildCallbacks = new CopyOnWriteArrayList();
    private String[] mTrackKeys = {TableField.PRELOAD_INFO, TableField.PLAY_FROM};
    public VPM mVPM = new VPM();
    private int VPMIndex = -1;
    private final ImpairmentTrack mImpairmentTrack = new ImpairmentTrack(this);
    private final ErrorTrack mErrorTrack = new ErrorTrack(this);
    private final OneChangeTrack mOneChangeTrack = new OneChangeTrack(this);
    private final AdTrack mAdTrack = new AdTrack(this);
    private final OneEventTrack mOneEventTrack = new OneEventTrack(this);
    private final SeekChangeTrack mSeekChangeTrack = new SeekChangeTrack(this);
    private final QualityChangeTrack mQualityChangeTrack = new QualityChangeTrack(this);
    private final PlayAbnormalDetailTrack mPlayAbnormalDetailTrack = new PlayAbnormalDetailTrack(this);
    private final PlayAbnormalSummaryTrack mPlayAbnormalSummaryTrack = new PlayAbnormalSummaryTrack(this);
    private final SubtitleEventTrack mSubtitleEventTrack = new SubtitleEventTrack(this);
    private final AbrPerformTrack mAbrPerformTrack = new AbrPerformTrack(this);
    private final String mVVId = UUID.randomUUID().toString();

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public interface OnExtrasBuildCallback {
        void buildExtras(String str, Map<String, String> map);
    }

    public Track(Context context, PlayVideoInfo playVideoInfo, AlixPlayerContainer alixPlayerContainer, PlayerTrack playerTrack) {
        String[] strArr;
        this.mContext = context;
        this.mPlayTimeTrack = new PlayTimeTrack(playVideoInfo);
        this.mPlayerContainer = alixPlayerContainer;
        this.mPlayerTrack = playerTrack;
        this.mIsFirstPlay = playerTrack.mIsFirstPlay;
        this.mPlayVideoInfo = playVideoInfo;
        this.mOnPlayerTrackListeners = playerTrack.getOnPlayerTrackListeners();
        this.mVVTrack = new VVTrack(playerTrack, this);
        for (String str : this.mTrackKeys) {
            putString(str, playVideoInfo.getString(str));
        }
    }

    private String getCurrentLanguageCode() {
        if (this.mPlayerContainer.getVideoStream() != null && this.mPlayerContainer.getVideoStream().getCurAlixVideoItem() != null) {
            return this.mPlayerContainer.getVideoStream().getCurAlixVideoItem().getLanguageCode();
        }
        return this.mPlayVideoInfo.getRequestLanguageCode();
    }

    public void buildExtras(Map<String, String> map, PlayVideoInfo playVideoInfo, YoukuVideoInfo youkuVideoInfo, OnExtrasBuildCallback onExtrasBuildCallback) {
        map.put("extras_player_info", new ExtrasPlayerInfo(this, playVideoInfo).toString());
        onExtrasBuildCallback.buildExtras("extras_player_info", map);
        map.put("extras_netm3s_info", new ExtrasNetm3sInfo(this, playVideoInfo).toString());
        onExtrasBuildCallback.buildExtras("extras_netm3s_info", map);
        map.put("extras_video_info", new ExtrasVideoInfo(this, playVideoInfo, youkuVideoInfo).toString());
        onExtrasBuildCallback.buildExtras("extras_video_info", map);
    }

    public void firstStart() {
        this.mPlayTimeTrack.onStart(PlayTimeTrack.PREPARED_FIRSTFRAME);
        this.mPlayTimeTrack.putTimestamp("playerPreparedTs", System.currentTimeMillis());
    }

    public AdTrack getAdTrack() {
        return this.mAdTrack;
    }

    public IAlixPlayer getAlixPlayer() {
        if (this.mPlayerContainer.getPlayer() instanceof IAlixPlayer) {
            return (IAlixPlayer) this.mPlayerContainer.getPlayer();
        }
        return null;
    }

    public String getApsVersion() {
        return this.mPlayerTrack.getDynamicProperties("apsVersion");
    }

    public Context getContext() {
        return this.mContext;
    }

    public BitStream getCurrentBitStream() {
        IVideoStream videoStream = this.mPlayerContainer.getVideoStream();
        if (videoStream == null) {
            return null;
        }
        return videoStream.getCurrentBitStream();
    }

    public Quality getCurrentQuality() {
        if (this.mPlayerContainer.getVideoStream() != null && this.mPlayerContainer.getVideoStream().getCurAlixVideoItem() != null) {
            return this.mPlayerContainer.getVideoStream().getCurAlixVideoItem().getQuality();
        }
        return this.mPlayVideoInfo.getRequestQuality();
    }

    public AlixVideoItem getCurrentVideoItem() {
        if (this.mPlayerContainer.getVideoStream() != null) {
            return this.mPlayerContainer.getVideoStream().getCurAlixVideoItem();
        }
        return null;
    }

    public ErrorTrack getErrorTrack() {
        return this.mErrorTrack;
    }

    public Map getExtras(YoukuVideoInfo youkuVideoInfo) {
        ExtraMap extraMap = new ExtraMap();
        PlayVideoInfo playVideoInfo = this.mPlayVideoInfo;
        boolean z = playVideoInfo.getRequestQuality() == Quality.AUTO;
        extraMap.put((ExtraMap) "hasMaster", playVideoInfo.getMonitor("hasMaster", null));
        extraMap.put((ExtraMap) "useMaster", z ? "1" : "0");
        extraMap.put((ExtraMap) "requestQuality", playVideoInfo.getRequestQuality() + "");
        extraMap.put((ExtraMap) "playQuality", getCurrentQuality() + "");
        extraMap.put((ExtraMap) "requestLang", playVideoInfo.getRequestLanguageCode());
        extraMap.put((ExtraMap) "playLang", getCurrentLanguageCode());
        extraMap.put((ExtraMap) "bitStreamChange", playVideoInfo.getMonitor("bitStreamChange", null));
        extraMap.put((ExtraMap) "langChange", playVideoInfo.getMonitor("langChange", null));
        extraMap.put((ExtraMap) "playRetry", playVideoInfo.getMonitor("playRetry", null));
        extraMap.put((ExtraMap) "error", playVideoInfo.getMonitor("error", "0"));
        extraMap.put((ExtraMap) "replay", playVideoInfo.getMonitor("replay", null));
        extraMap.put((ExtraMap) "spm-url", playVideoInfo.getMonitor("spm-url", null));
        extraMap.put((ExtraMap) "scm", playVideoInfo.getMonitor("scm", null));
        extraMap.put((ExtraMap) "pv-spm-pre", playVideoInfo.getMonitor("pv-spm-pre", null));
        extraMap.put((ExtraMap) "feedVpm", playVideoInfo.getMonitor("feedVpm", null));
        extraMap.put((ExtraMap) "ntkInterfere", playVideoInfo.getString("ntkInterfere", null));
        extraMap.put((ExtraMap) "ntkInterfereEnable", playVideoInfo.getString("ntkInterfereEnable", null));
        extraMap.put((ExtraMap) "catonTip", playVideoInfo.getString("catonTip", null));
        extraMap.put((ExtraMap) "wifiInfo", playVideoInfo.getString("wifiInfo", null));
        extraMap.put((ExtraMap) "pcdnVersion", getPlayerConfig().getDynamicProperties() != null ? getPlayerConfig().getDynamicProperties().call("pcdnVersion") : null);
        extraMap.put((ExtraMap) "smartTileError", playVideoInfo.getMonitor("smartTileError", null));
        extraMap.put((ExtraMap) "useSmartTile", playVideoInfo.getMonitor("useSmartTile", "0"));
        if (youkuVideoInfo != null && youkuVideoInfo.getUpsVideoInfo() != null && youkuVideoInfo.getUpsVideoInfo().getUps() != null) {
            extraMap.put((ExtraMap) "upsClientNetIP", youkuVideoInfo.getUpsVideoInfo().getUps().ups_client_netip);
        }
        if (youkuVideoInfo != null) {
            extraMap.put((ExtraMap) "extras-ismcu", youkuVideoInfo.isMcu());
            extraMap.put((ExtraMap) "extras-ispk", youkuVideoInfo.isPK());
        }
        extraMap.put((ExtraMap) "tinywindowNumOfEnter", playVideoInfo.getString("tinywindowNumOfEnter", null));
        extraMap.put((ExtraMap) "tinywindowTimeOfPlay", playVideoInfo.getString("tinywindowTimeOfPlay", null));
        extraMap.put((ExtraMap) "tinywindowNumOfKeep", playVideoInfo.getString("tinywindowNumOfKeep", null));
        extraMap.put((ExtraMap) "tinyWindowType", playVideoInfo.getString("tinyWindowType", null));
        extraMap.put((ExtraMap) "tinywindowRefusePermission", playVideoInfo.getString("tinywindowRefusePermission", null));
        return extraMap;
    }

    public ImpairmentTrack getImpairmentTrack() {
        return this.mImpairmentTrack;
    }

    public OneChangeTrack getOneChangeTrack() {
        return this.mOneChangeTrack;
    }

    public OneEventTrack getOneEventTrack() {
        return this.mOneEventTrack;
    }

    public VVTrack getOnePlayTrack() {
        return this.mVVTrack;
    }

    public String getParamsFromCore(String str, String str2) {
        return this.mParamsFromCore.containsKey(str) ? this.mParamsFromCore.get(str) : str2;
    }

    public PlayAbnormalDetailTrack getPlayAbnormalDetailTrack() {
        return this.mPlayAbnormalDetailTrack;
    }

    public PlayAbnormalSummaryTrack getPlayAbnormalSummaryTrack() {
        return this.mPlayAbnormalSummaryTrack;
    }

    public PlayTimeTrack getPlayTimeTrack() {
        return this.mPlayTimeTrack;
    }

    @Override // com.youku.alixplayer.opensdk.statistics.ITrack
    public PlayVideoInfo getPlayVideoInfo() {
        return this.mPlayVideoInfo;
    }

    public PlayerConfig getPlayerConfig() {
        return this.mPlayerContainer.getPlayerConfig();
    }

    public AlixPlayerContainer getPlayerContainer() {
        return this.mPlayerContainer;
    }

    public String getPlayerInfoByKey(int i) {
        return ((IAlixPlayer) this.mPlayerContainer.getPlayer()).getPlayerInfoByKey(i);
    }

    public void getPlayerInfoForVVEnd(String str) {
        if (this.mParamsFromCore.containsKey(-1) || getAlixPlayer() == null) {
            return;
        }
        String playerInfoByKey = getAlixPlayer().getPlayerInfoByKey(-1);
        if (TextUtils.isEmpty(playerInfoByKey)) {
            return;
        }
        this.mParamsFromCore.put("-1", playerInfoByKey);
        this.mVPM.setParams(VPM.VVEND, playerInfoByKey);
        getPlayAbnormalSummaryTrack().getPlayerInfoForVVEnd(playerInfoByKey);
        TLogUtil.vpmLog(str + " mVVEndInfo: " + playerInfoByKey);
    }

    public String getPlayerSource() {
        return this.mPlayerContainer.getPlayerConfig().getExtras().getString(TableField.PLAYER_SOURCE);
    }

    public QualityChangeTrack getQualityChangeTrack() {
        return this.mQualityChangeTrack;
    }

    public Reporter getReporter() {
        if (getAlixPlayer() != null) {
            return getAlixPlayer().getReporter();
        }
        return null;
    }

    public SeekChangeTrack getSeekChangeTrack() {
        return this.mSeekChangeTrack;
    }

    @Override // com.youku.alixplayer.opensdk.statistics.ITrack
    public String getString(String str) {
        return this.mStringMap.get(str);
    }

    public SubtitleEventTrack getSubtitleEventTrack() {
        return this.mSubtitleEventTrack;
    }

    public Table getTable(MSGTABLEID msgtableid) {
        return this.mVPM.getTable(msgtableid);
    }

    public String getUserId() {
        if (this.mPlayerContainer.getPlayerConfig().getDynamicProperties() == null) {
            return null;
        }
        return this.mPlayerContainer.getPlayerConfig().getDynamicProperties().call("userId");
    }

    public int getVPMIndex() {
        int i = this.VPMIndex + 1;
        this.VPMIndex = i;
        return i;
    }

    public String getVVId() {
        return this.mVVId;
    }

    public String getVideoCodec() {
        Table table = this.mVPM.getTable(MSGTABLEID.ONEPLAY);
        return (table == null || table.getDimensions() == null) ? "-1" : table.getDimensions().get("videoCode");
    }

    public YoukuVideoInfo getYoukuVideoInfo() {
        return this.mVideoInfo;
    }

    @Override // com.youku.alixplayer.opensdk.statistics.ITrack
    public boolean isDataReady() {
        return this.mIsGetVideoInfoSuccess;
    }

    public boolean isFirstPlay() {
        return this.mIsFirstPlay;
    }

    public boolean isLogin() {
        if (this.mPlayerContainer.getPlayerConfig().getDynamicProperties() == null) {
            return false;
        }
        return "1".equalsIgnoreCase(this.mPlayerContainer.getPlayerConfig().getDynamicProperties().call("isLogin"));
    }

    @Override // com.youku.alixplayer.opensdk.statistics.ITrack
    public boolean isRealVideoCompletion() {
        return this.isRealVideoCompletion;
    }

    @Override // com.youku.alixplayer.opensdk.statistics.ITrack
    public boolean isRealVideoStarted() {
        return this.isRealVideoStarted;
    }

    public boolean isVip() {
        if (this.mPlayerContainer.getPlayerConfig().getDynamicProperties() == null) {
            return false;
        }
        return "1".equalsIgnoreCase(this.mPlayerContainer.getPlayerConfig().getDynamicProperties().call(TableField.IS_VIP));
    }

    public void onCompletion() {
        onVVEnd();
        this.isRealVideoCompletion = true;
    }

    public void onDataReady(YoukuVideoInfo youkuVideoInfo) {
        this.mVideoInfo = youkuVideoInfo;
        this.mIsGetVideoInfoSuccess = true;
        this.mPlayTimeTrack.putTimestamp("requestEndTs", System.currentTimeMillis());
    }

    public void onMonitorPoint(String str, Map<String, String> map, Map<String, Double> map2) {
        OnPlayerTrackListener.Result result = new OnPlayerTrackListener.Result(map, map2);
        this.mAbrPerformTrack.onMonitorPoint(this, str, result);
        for (OnPlayerTrackListener onPlayerTrackListener : this.mOnPlayerTrackListeners) {
            if (onPlayerTrackListener != null) {
                onPlayerTrackListener.onMonitorPoint(this, str, result);
            }
        }
    }

    public void onNewRequest() {
        this.mErrorTrack.onStartLoading("newRequest");
        this.mPlayTimeTrack.onStart(PlayTimeTrack.PLAY_SOURCEREADY);
        this.mPlayTimeTrack.putTimestamp("requestStartTs", System.currentTimeMillis());
    }

    public void onRealVideoStart() {
        this.mVVTrack.onRealVideoStart();
        this.mAdTrack.onRealVideoStart();
        this.mErrorTrack.onRealVideoStart();
        this.isRealVideoStarted = true;
    }

    public void onVVBegin(int i) {
        if (this.isVVActive) {
            return;
        }
        this.mPlayerTrack.mIsFirstPlay = false;
        this.mVVTrack.onVVBegin(i);
        if (i == 2) {
            this.isVVActive = true;
        }
    }

    public void onVVEnd() {
        if (!this.isVVActive || this.mVideoInfo == null) {
            return;
        }
        getPlayerInfoForVVEnd("onVVEnd is null");
        this.mVVTrack.onVVEnd();
        getPlayAbnormalSummaryTrack().commit(this.mVideoInfo);
        this.isVVActive = false;
    }

    public void prepareAsync() {
        this.mPlayTimeTrack.onStart(PlayTimeTrack.SOURCEREADY_PREPARED);
        this.mPlayTimeTrack.putTimestamp("playerPrepareTs", System.currentTimeMillis());
    }

    @Override // com.youku.alixplayer.opensdk.statistics.ITrack
    public void putString(String str, String str2) {
        this.mStringMap.put(str, String.valueOf(str2));
    }

    public boolean setParams(int i, Object obj) {
        return this.mVPM.setParams(i, obj);
    }

    public String getString(String str, String str2) {
        String str3 = this.mStringMap.get(str);
        return str3 != null ? str3 : str2;
    }
}

package com.youku.vpm.track;

import android.content.Context;
import android.text.TextUtils;
import com.youku.alixplayer.opensdk.utils.PlayCode;
import com.youku.playerservice.axp.player.ErrorCode;
import com.youku.vpm.BaseTrack;
import com.youku.vpm.IExt;
import com.youku.vpm.IMonitor;
import com.youku.vpm.IPlayer;
import com.youku.vpm.ITrack;
import com.youku.vpm.IVpmFullInfo;
import com.youku.vpm.IVpmInfo;
import com.youku.vpm.OnPlayerTrackListener;
import com.youku.vpm.PlayTimeTrack;
import com.youku.vpm.PlayerTrack;
import com.youku.vpm.constants.TableField;
import com.youku.vpm.data.ExtrasInfo;
import com.youku.vpm.data.ExtrasNetm3sInfo;
import com.youku.vpm.data.ExtrasPlayerInfo;
import com.youku.vpm.data.ExtrasVideoInfo;
import com.youku.vpm.framework.Table;
import com.youku.vpm.framework.TableBuilder;
import com.youku.vpm.framework.TableId;
import com.youku.vpm.track.ad.AdTrack;
import com.youku.vpm.track.impairment.ImpairmentTrack;
import com.youku.vpm.track.quality.QualityChangeTrack;
import com.youku.vpm.track.seek.SeekChangeTrack;
import com.youku.vpm.utils.TLogUtil;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Track implements ITrack {
    public static final String TAG = "Track";
    private boolean isRealVideoCompletion;
    private Context mContext;
    private IVpmFullInfo mFullInfo;
    private IVpmInfo mInfo;
    private volatile boolean mIsBeginSend;
    private boolean mIsDataReady;
    private boolean mIsEndSend;
    private boolean mIsFirstPlay;
    private List<OnPlayerTrackListener> mOnPlayerTrackListeners;
    private final OnePlayTrack mOnePlayTrack;
    private final PlayTimeTrack mPlayTimeTrack;
    private PlayerTrack mPlayerTrack;
    private boolean isRealVideoStarted = false;
    private Map<String, String> mParamsFromCore = new ConcurrentHashMap();
    private Map<String, String> mStringMap = new ConcurrentHashMap();
    private String[] mTrackKeys = {TableField.PRELOAD_INFO, TableField.PLAY_FROM};
    public TableBuilder mTableBuilder = new TableBuilder();
    private int VPMIndex = -1;
    private int mBeginState = -1;
    private final ImpairmentTrack mImpairmentTrack = new ImpairmentTrack(this);
    private final ErrorTrack mErrorTrack = new ErrorTrack(this);
    private HeartBeatReporter mHeartBeatReporter = new HeartBeatReporter(this);
    private final AdTrack mAdTrack = new AdTrack(this);
    private final OneEventTrack mOneEventTrack = new OneEventTrack(this);
    private final SeekChangeTrack mSeekChangeTrack = new SeekChangeTrack(this);
    private final QualityChangeTrack mQualityChangeTrack = new QualityChangeTrack(this);
    private final PlayAbnormalDetailTrack mPlayAbnormalDetailTrack = new PlayAbnormalDetailTrack(this);
    private final PlayAbnormalSummaryTrack mPlayAbnormalSummaryTrack = new PlayAbnormalSummaryTrack(this);
    private final SubtitleEventTrack mSubtitleEventTrack = new SubtitleEventTrack(this);
    private final AbrPerformTrack mAbrPerformTrack = new AbrPerformTrack(this);
    private final String mVVId = UUID.randomUUID().toString();

    public Track(Context context, IVpmInfo iVpmInfo, PlayerTrack playerTrack) {
        String[] strArr;
        this.mContext = context;
        this.mPlayTimeTrack = new PlayTimeTrack(iVpmInfo);
        this.mPlayerTrack = playerTrack;
        this.mIsFirstPlay = playerTrack.mIsFirstPlay;
        this.mInfo = iVpmInfo;
        this.mOnPlayerTrackListeners = playerTrack.getOnPlayerTrackListeners();
        this.mOnePlayTrack = new OnePlayTrack(playerTrack, this);
        for (String str : this.mTrackKeys) {
            putString(str, iVpmInfo.getString(str, null));
        }
    }

    private void getPlayerInfoForVVEnd(String str) {
        IPlayer player = getPlayer();
        if (this.mParamsFromCore.containsKey(-1) || player == null) {
            return;
        }
        String playerInfoByKey = player.getPlayerInfoByKey(-1);
        if (TextUtils.isEmpty(playerInfoByKey)) {
            return;
        }
        this.mParamsFromCore.put("-1", playerInfoByKey);
        TLogUtil.vpmLog(str + " mVVEndInfo: " + playerInfoByKey);
    }

    public void buildExtras(String str, Map<String, String> map, BaseTrack.OnExtrasBuildCallback onExtrasBuildCallback) {
        ExtrasInfo extrasInfo = new ExtrasInfo(this, str);
        if (onExtrasBuildCallback != null) {
            onExtrasBuildCallback.buildExtras(ExtrasInfo.EXTRAS, extrasInfo);
        }
        map.put(ExtrasInfo.EXTRAS, extrasInfo.toString());
        map.put("extras_player_info", new ExtrasPlayerInfo(this, str).toString());
        map.put("extras_netm3s_info", new ExtrasNetm3sInfo(this, str).toString());
        map.put("extras_video_info", new ExtrasVideoInfo(this, str).toString());
    }

    public void buildExtras(Map<String, String> map) {
        buildExtras(map, null);
    }

    public void buildExtras(Map<String, String> map, BaseTrack.OnExtrasBuildCallback onExtrasBuildCallback) {
        buildExtras(null, map, onExtrasBuildCallback);
    }

    public AdTrack getAdTrack() {
        return this.mAdTrack;
    }

    public String getApsVersion() {
        return this.mPlayerTrack.getDynamicProperty("apsVersion");
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getDimFromInfo(String str, String str2) {
        IExt iExt = this.mFullInfo;
        if (iExt == null) {
            iExt = this.mInfo;
        }
        return iExt.getString(str, str2);
    }

    public String getDynamicProperties(String str) {
        return this.mPlayerTrack.getDynamicProperty(str);
    }

    public ErrorTrack getErrorTrack() {
        return this.mErrorTrack;
    }

    public String getFileFormat() {
        return getDimFromInfo(TableField.FILE_FORMAT, null);
    }

    @Override // com.youku.vpm.ITrack
    public String getId() {
        return this.mVVId;
    }

    public ImpairmentTrack getImpairmentTrack() {
        return this.mImpairmentTrack;
    }

    public OneEventTrack getOneEventTrack() {
        return this.mOneEventTrack;
    }

    public OnePlayTrack getOnePlayTrack() {
        return this.mOnePlayTrack;
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

    public double getPlayTime() {
        return this.mOnePlayTrack.getPlayTime();
    }

    public PlayTimeTrack getPlayTimeTrack() {
        return this.mPlayTimeTrack;
    }

    public String getPlayWay() {
        return getDimFromInfo(TableField.PLAY_WAY, "net");
    }

    public IPlayer getPlayer() {
        return this.mPlayerTrack.getPlayer();
    }

    public String getPlayerSource() {
        return this.mPlayerTrack.getDynamicProperty(TableField.PLAYER_SOURCE);
    }

    public PlayerTrack getPlayerTrack() {
        return this.mPlayerTrack;
    }

    public double getProgress() {
        IVpmFullInfo iVpmFullInfo = this.mFullInfo;
        if (iVpmFullInfo != null) {
            iVpmFullInfo.getDouble("progress", 0.0d);
        }
        return 0.0d;
    }

    public QualityChangeTrack getQualityChangeTrack() {
        return this.mQualityChangeTrack;
    }

    public SeekChangeTrack getSeekChangeTrack() {
        return this.mSeekChangeTrack;
    }

    @Override // com.youku.vpm.ITrack
    public String getString(String str) {
        return this.mStringMap.get(str);
    }

    public String getString(String str, String str2) {
        String str3 = this.mStringMap.get(str);
        return str3 != null ? str3 : str2;
    }

    public SubtitleEventTrack getSubtitleEventTrack() {
        return this.mSubtitleEventTrack;
    }

    public Table getTable(TableId tableId) {
        return this.mTableBuilder.getTable(tableId);
    }

    public String getUrl() {
        Map<String, String> allDims;
        IPlayer player = getPlayer();
        String str = (player == null || (allDims = player.getAllDims(TableId.ONEPLAY)) == null) ? null : allDims.get("URL");
        return TextUtils.isEmpty(str) ? getDimFromInfo("url", null) : str;
    }

    public String getUserId() {
        return this.mPlayerTrack.getDynamicProperty("userId");
    }

    public int getVPMIndex() {
        int i = this.VPMIndex + 1;
        this.VPMIndex = i;
        return i;
    }

    public String getVVId() {
        return this.mVVId;
    }

    public double getValFromInfo(String str, double d) {
        IMonitor iMonitor = this.mFullInfo;
        if (iMonitor == null) {
            iMonitor = this.mInfo;
        }
        return iMonitor.getDouble(str, d);
    }

    public String getVideoCodec() {
        Table table = this.mTableBuilder.getTable(TableId.ONEPLAY);
        return (table == null || table.getDimensions() == null) ? "-1" : table.getDimensions().get("videoCode");
    }

    @Override // com.youku.vpm.ITrack
    public IVpmFullInfo getVpmFullInfo() {
        return this.mFullInfo;
    }

    @Override // com.youku.vpm.ITrack
    public IVpmInfo getVpmInfo() {
        return this.mInfo;
    }

    public boolean isDataReady() {
        return this.mIsDataReady;
    }

    public boolean isExternal() {
        return "1".equals(getDynamicProperties("isExternal"));
    }

    public boolean isFirstPlay() {
        return this.mIsFirstPlay;
    }

    public boolean isLogin() {
        return "1".equalsIgnoreCase(this.mPlayerTrack.getDynamicProperty("isLogin"));
    }

    public boolean isRealVideoCompletion() {
        return this.isRealVideoCompletion;
    }

    public boolean isRealVideoStarted() {
        return this.isRealVideoStarted;
    }

    public boolean isVip() {
        return "1".equalsIgnoreCase(getDynamicProperties(TableField.IS_VIP));
    }

    public void onCompletion() {
        putString("errorCode", PlayCode.RETURN_WHEN_VIDEO_REAL_PLAYING);
        onVVEnd("completion");
        this.isRealVideoCompletion = true;
    }

    public void onDataFail(int i) {
        Map<String, String> map = this.mStringMap;
        map.put("errorCode", i + "");
        onVVBegin(0);
        this.mErrorTrack.onDataFail(i);
        onUserActionLoadingEnd("blocked");
        onVVEnd("error");
    }

    public void onDataReady(IVpmFullInfo iVpmFullInfo) {
        this.mFullInfo = iVpmFullInfo;
        this.mIsDataReady = true;
    }

    public void onError(int i, int i2, Object obj) {
        ErrorTrack errorTrack;
        if (this.mPlayerTrack.isActive()) {
            Map<String, String> map = this.mStringMap;
            map.put("errorCode", i2 + "");
            onVVBegin();
            if (i == 400) {
                TLogUtil.vpmLog("what 400，不进行上报");
                errorTrack = this.mErrorTrack;
                i2 = ErrorCode.NO_NETWORK_LOADING;
            } else if (this.mAdTrack.onError(i, i2, obj)) {
                TLogUtil.vpmLog("广告播放出错 what=" + i + " arg1=" + i2 + " obj=" + String.valueOf(obj));
                onUserActionLoadingEnd("blocked");
                onVVEnd("error");
            } else {
                TLogUtil.vpmLog("正片播放出错 what=" + i + " arg1=" + i2 + " obj=" + String.valueOf(obj));
                this.mErrorTrack.setPlayerErrorMsg(obj);
                errorTrack = this.mErrorTrack;
            }
            errorTrack.onError(i2);
            onUserActionLoadingEnd("blocked");
            onVVEnd("error");
        }
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
    }

    public void onRealVideoStart() {
        this.mOnePlayTrack.onRealVideoStart();
        this.mErrorTrack.onRealVideoStart();
        this.isRealVideoStarted = true;
    }

    public void onStop(String str) {
        ErrorTrack errorTrack = getErrorTrack();
        errorTrack.setQuitType(str);
        if (!isDataReady()) {
            putString("errorCode", PlayCode.USER_RETURN);
            errorTrack.onError(-998);
            onVVBegin(0);
        } else if (getAdTrack().isAdShowing()) {
            int i = getAdTrack().isMidAdShowing() ? -992 : -995;
            putString("errorCode", i + "");
            errorTrack.onError(i);
            onVVBegin(1);
        } else if (!isRealVideoStarted()) {
            int i2 = "1".equals(getVpmInfo().getString("isDlna", null)) ? -990 : -997;
            putString("errorCode", i2 + "");
            errorTrack.onError(i2);
            onVVBegin(1);
        } else {
            int i3 = -991;
            String loadingType = errorTrack.getLoadingType();
            if ("seek".equals(loadingType)) {
                i3 = -993;
            } else if ("net".equals(loadingType)) {
                i3 = -994;
            }
            putString("errorCode", i3 + "");
            errorTrack.onError(i3);
            onVVEnd(str);
        }
    }

    public void onUserActionLoadingEnd(String str) {
        this.mImpairmentTrack.onPlayLoadingEnd(str, -1, -1, null);
    }

    public void onVVBegin() {
        onVVBegin(!this.mIsDataReady ? 0 : !this.isRealVideoStarted ? 1 : 2);
    }

    public void onVVBegin(int i) {
        if (this.mPlayerTrack.isActive() && !this.mIsBeginSend) {
            this.mBeginState = i;
            this.mIsBeginSend = true;
            this.mPlayerTrack.mIsFirstPlay = false;
            this.mOnePlayTrack.onVVBegin(i);
        }
    }

    public void onVVEnd(String str) {
        if (this.mIsEndSend || this.mBeginState != 2 || this.mFullInfo == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        getPlayerInfoForVVEnd("onVVEnd is from " + str);
        this.mPlayTimeTrack.putTimestamp("getPlayInfoTs", System.currentTimeMillis() - currentTimeMillis);
        this.mOnePlayTrack.onVVEnd();
        getPlayAbnormalSummaryTrack().commit(this.mParamsFromCore.get("-1"));
        this.mIsEndSend = true;
    }

    public void putParamsFromCode(String str, String str2) {
        this.mParamsFromCore.put(str, str2);
    }

    @Override // com.youku.vpm.ITrack
    public void putString(String str, String str2) {
        if (str2 != null) {
            this.mStringMap.put(str, str2);
        } else {
            this.mStringMap.remove(str);
        }
    }
}

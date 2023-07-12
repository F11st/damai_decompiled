package com.youku.alixplayer.opensdk.statistics;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import com.uc.webview.export.media.MessageID;
import com.youku.alixplayer.opensdk.AlixPlayerContainer;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.ups.data.Quality;
import com.youku.alixplayer.opensdk.utils.Callable;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.alixplayer.opensdk.utils.MsgIdGroup;
import com.youku.alixplayer.opensdk.utils.PlayCode;
import com.youku.alixplayer.opensdk.utils.PlayerUtil;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class PlayerTrack implements IPlayerTrack {
    private static final String TAG = "PlayerTrack";
    private Context mContext;
    private Callable<String> mDynamicProperties;
    private HeartBeatReporter mHeartBeatReporter;
    private AlixPlayerContainer mPlayer;
    private Track mTrack;
    public boolean mIsFirstPlay = true;
    private Map<String, Long> mTimestamps = new ConcurrentHashMap();
    private Map<String, String> mString = new ConcurrentHashMap();
    private List<OnPlayerTrackListener> mOnPlayerTrackListeners = new CopyOnWriteArrayList();

    public PlayerTrack(Context context, AlixPlayerContainer alixPlayerContainer) {
        this.mPlayer = alixPlayerContainer;
        this.mContext = context.getApplicationContext();
    }

    private void copyString(Track track) {
        for (Map.Entry<String, String> entry : this.mString.entrySet()) {
            track.putString(entry.getKey(), entry.getValue());
        }
        this.mString.clear();
    }

    private void copyTimestamp(Track track) {
        for (Map.Entry<String, Long> entry : this.mTimestamps.entrySet()) {
            track.getPlayTimeTrack().putTimestamp(entry.getKey(), entry.getValue().longValue());
        }
        this.mTimestamps.clear();
    }

    private void onRealVideoStart(int i, int i2, Object obj) {
        Track track = this.mTrack;
        if (track != null) {
            track.getOnePlayTrack().setPrepareInfo(i, i2, obj, -1L);
            this.mTrack.getPlayTimeTrack().setPrepareInfo(String.valueOf(obj));
            this.mTrack.onRealVideoStart();
            this.mTrack.onRealVideoStart();
            this.mTrack.onVVBegin(2);
        }
    }

    private void onUserActionLoadingEnd(String str) {
        Track track = this.mTrack;
        if (track != null) {
            track.getImpairmentTrack().onPlayLoadingEnd(str, -1, -1, null);
        }
    }

    private void onVVEnd(boolean z) {
        Track track = this.mTrack;
        if (track == null) {
            return;
        }
        ErrorTrack errorTrack = track.getErrorTrack();
        errorTrack.setQuitType(z ? PurchaseConstants.PART_SUCCESS_CANCEL : "切集");
        if (!this.mTrack.isDataReady()) {
            errorTrack.onError(PlayCode.USER_RETURN);
            this.mTrack.onVVBegin(0);
        } else if (this.mTrack.getAdTrack().isAdShowing()) {
            errorTrack.onError(this.mTrack.getAdTrack().isMidAdShowing() ? PlayCode.RETURN_WHEN_MID_AD : PlayCode.RETURN_WHEN_AD);
            this.mTrack.onVVBegin(1);
        } else if (!this.mTrack.isRealVideoStarted()) {
            if ("1".equals(this.mTrack.getPlayVideoInfo().getString("isDlna"))) {
                errorTrack.onError(PlayCode.USER_DLNA_RETURN);
            } else {
                errorTrack.onError(PlayCode.USER_LOADING_RETURN);
            }
            this.mTrack.onVVBegin(1);
        } else {
            String str = PlayCode.RETURN_WHEN_VIDEO_REAL_PLAYING;
            if (this.mTrack.isRealVideoCompletion()) {
                errorTrack.onError(PlayCode.RETURN_WHEN_VIDEO_REAL_PLAYING);
                return;
            }
            String loadingType = errorTrack.getLoadingType();
            if ("seek".equals(loadingType)) {
                str = PlayCode.RETURN_WHEN_SEEKING;
            } else if ("net".equals(loadingType)) {
                str = PlayCode.RETURN_WHEN_BUFFERING;
            }
            errorTrack.onError(str);
            this.mTrack.onVVEnd();
        }
    }

    private void trackVideoSwitch() {
        Logger.d(TAG, "trackVideoSwitch ");
        onVVEnd(false);
    }

    @Override // com.youku.alixplayer.opensdk.statistics.IPlayerTrack
    public void addPlayerTrackInfoListener(OnPlayerTrackListener onPlayerTrackListener) {
        this.mOnPlayerTrackListeners.add(onPlayerTrackListener);
    }

    public void firstStart() {
        Track track = this.mTrack;
        if (track != null) {
            track.firstStart();
        }
    }

    public String getDynamicProperties(String str) {
        Callable<String> callable = this.mDynamicProperties;
        if (callable != null) {
            return callable.call(str);
        }
        return null;
    }

    public List<OnPlayerTrackListener> getOnPlayerTrackListeners() {
        return this.mOnPlayerTrackListeners;
    }

    @Override // com.youku.alixplayer.opensdk.statistics.IPlayerTrack
    public PlayTimeTrack getPlayTimeTrack() {
        Track track = this.mTrack;
        if (track != null) {
            return track.getPlayTimeTrack();
        }
        return null;
    }

    public AlixPlayerContainer getPlayer() {
        return this.mPlayer;
    }

    @Override // com.youku.alixplayer.opensdk.statistics.IPlayerTrack
    public ITrack getTrack() {
        return this.mTrack;
    }

    @Override // com.youku.alixplayer.opensdk.statistics.IPlayerTrack
    public void onAction(String str, Bundle bundle) {
        if (this.mTrack == null) {
            return;
        }
        TLogUtil.loge(TAG, "onAction:" + str);
        if ("onVVEnd".equals(str)) {
            bundle.getString("from");
            onVVEnd(false);
        }
    }

    public void onChangeVideoQuality(int i, Quality quality, Quality quality2) {
        Track track = this.mTrack;
        if (track != null) {
            track.getOnePlayTrack().addSwitchCounts();
            TLogUtil.vpmLog("onChangeVideoQuality mode:" + i + " fromQuality:" + quality + " toQuality:" + quality2);
            this.mTrack.getQualityChangeTrack().onChangeVideoQualityStart(i, quality, quality2);
        }
    }

    public void onCurrentPositionUpdate(int i, int i2) {
        Track track = this.mTrack;
        if (track == null) {
            TLogUtil.playLog("正片没有起播，onCurrentPositionUpdate就已经执行");
            return;
        }
        HeartBeatReporter heartBeatReporter = this.mHeartBeatReporter;
        if (heartBeatReporter != null) {
            heartBeatReporter.OnCurrentPositionChangeListener(i, track);
        }
        this.mTrack.getOneChangeTrack().onCurrentPositionUpdate(i, i2);
        this.mTrack.getQualityChangeTrack().onCurrentPositionUpdate(i, i2);
        this.mTrack.getOnePlayTrack().onCurrentPositionUpdate(i);
    }

    public void onDataFail(VideoRequestError videoRequestError) {
        Track track = this.mTrack;
        if (track != null) {
            track.getErrorTrack().onError(videoRequestError);
            this.mTrack.onVVBegin(0);
        }
    }

    public void onDataReady(YoukuVideoInfo youkuVideoInfo) {
        this.mTrack.onDataReady(youkuVideoInfo);
    }

    public boolean onError(Message message) {
        Track track = this.mTrack;
        if (track == null) {
            return false;
        }
        YoukuVideoInfo youkuVideoInfo = track.getYoukuVideoInfo();
        if (youkuVideoInfo == null) {
            TLogUtil.vpmLog("videoInfo is null message what=" + message.what + " arg1" + message.arg1);
            return false;
        }
        PlayVideoInfo playVideoInfo = youkuVideoInfo.getPlayVideoInfo();
        int i = message.what;
        int i2 = message.arg1;
        Object obj = message.obj;
        if (MsgIdGroup.isHWEncodeError(i, i2)) {
            PlayerUtil.has265Failed = true;
        }
        if (i == 400) {
            TLogUtil.playErrorLog(this.mContext, "what 400，不进行上报", i, i2, String.valueOf(obj));
            return false;
        }
        if (this.mTrack.getAdTrack().onError(message.what, message.arg1, message.obj, playVideoInfo, youkuVideoInfo)) {
            TLogUtil.playErrorLog(this.mContext, "广告播放出错", i, i2, String.valueOf(obj));
        } else {
            TLogUtil.playErrorLog(this.mContext, "正片播放出错", i, i2, String.valueOf(obj));
            this.mTrack.getErrorTrack().setPlayerErrorMsg(obj);
            playVideoInfo.putString("error", "1");
            this.mTrack.getErrorTrack().onError(i2);
        }
        onUserActionLoadingEnd("blocked");
        this.mTrack.getPlayerInfoForVVEnd("onError what extra msg obj");
        this.mTrack.onVVEnd();
        return false;
    }

    public void onInfo(int i, int i2, int i3, Object obj) {
        Message message = new Message();
        message.what = i;
        message.arg1 = i2;
        message.arg2 = i3;
        message.obj = obj;
        if (i != 949 && i != 950 && i != 1003 && i != 1004 && i != 1011 && i != 1012 && i != 1024 && i != 1025 && i != 1102 && i != 1103 && i != 3011 && i != 3012) {
            switch (i) {
                case -1012:
                case 4:
                case 952:
                case 1015:
                case 1017:
                case 1019:
                case 2008:
                case 2009:
                case 2010:
                case 2011:
                case 2012:
                case 2013:
                case 2014:
                case 2015:
                case 2016:
                case 2110:
                case 2303:
                case 2400:
                case 3015:
                case 3200:
                case 4000:
                case 9001:
                case 9003:
                case 50004:
                case 82000:
                case 90000:
                    break;
                default:
                    switch (i) {
                        case 1032:
                        case 1033:
                        case 1034:
                            break;
                        default:
                            switch (i) {
                                case 80001:
                                case 80002:
                                case 80003:
                                case 80004:
                                case 80005:
                                    break;
                                default:
                                    switch (i) {
                                        case 81001:
                                        case 81002:
                                        case 81003:
                                        case 81004:
                                            break;
                                        default:
                                            return;
                                    }
                            }
                    }
            }
        }
        onMsg(message);
    }

    public void onMsg(Message message) {
        if (this.mTrack == null) {
            return;
        }
        int i = message.what;
        int i2 = message.arg1;
        int i3 = message.arg2;
        Object obj = message.obj;
        Logger.d(TAG, "onMsg:" + i + " arg1:" + i2 + " arg2:" + i3 + " obj:" + obj);
        setParams(i, obj);
        String str = "waiting";
        switch (i) {
            case -1012:
            case 1012:
            case 3012:
                this.mTrack.getAdTrack().onPreAdEnd(i2);
                return;
            case -4:
                this.mTrack.getSeekChangeTrack().onSeekTo(i2);
                return;
            case 4:
                this.mTrack.getSeekChangeTrack().onSeekComplete();
                return;
            case 950:
                this.mTrack.getSubtitleEventTrack().commit();
                return;
            case 1003:
                TLogUtil.loge(TAG, "onStartLoading ----> arg1:" + i2 + " arg2:" + i3 + " obj:" + obj);
                this.mTrack.getErrorTrack().onStartLoading(i2 == 1 ? "seek" : "net");
                if (i2 == 1) {
                    return;
                }
                if (i3 != 0) {
                    TLogUtil.loge(TAG, "adv onStartLoading");
                    this.mTrack.getAdTrack().onStartLoading(i3);
                    return;
                }
                this.mTrack.getImpairmentTrack().onPlayLoadingStart("waiting", i2, i3, obj);
                return;
            case 1004:
                TLogUtil.loge(TAG, "onEndLoading ----> arg1:" + i2 + " arg2:" + i3 + " obj:" + obj);
                this.mTrack.getErrorTrack().onEndLoading();
                if (i2 == 1) {
                    return;
                }
                this.mTrack.getAdTrack().onEndLoading();
                if (i2 == 2) {
                    str = "videostart";
                } else if (i2 == 3) {
                    str = "lowspeed";
                }
                this.mTrack.getImpairmentTrack().onPlayLoadingEnd(str, i2, i3, obj);
                return;
            case 1011:
            case 3011:
                this.mTrack.getOnePlayTrack().setIsADPlayFromCache(i3);
                this.mTrack.getAdTrack().onPreAdStart(i2);
                this.mTrack.getOnePlayTrack().onAdStart();
                return;
            case 1015:
            case 3015:
                this.mTrack.getAdTrack().onStartPlayPostAD(i2);
                return;
            case 1017:
                Log.i("lwj", "on video start");
                onRealVideoStart(i2, i3, obj);
                this.mTrack.getQualityChangeTrack().onChangeVideoQualityFinish(false, true);
                return;
            case 1019:
                this.mTrack.getPlayerInfoForVVEnd("msgid:1019");
                this.mTrack.onCompletion();
                return;
            case 1021:
                TLogUtil.loge(TAG, "onSwitchFinish ----> arg1:" + i2 + " arg2:" + i3 + " obj:" + obj);
                this.mTrack.getQualityChangeTrack().onChangeVideoQualityFinish(false, true);
                return;
            case 1022:
                TLogUtil.loge(TAG, "onSwitchFailed ----> arg1:" + i2 + " arg2:" + i3 + " obj:" + obj);
                this.mTrack.getQualityChangeTrack().onChangeVideoQualityFinish(false, false);
                return;
            case 2010:
                this.mTrack.getAdTrack().onVideoSliceStart(i2, i3, obj);
                return;
            case 2303:
                this.mTrack.getOneEventTrack().commitOneEventStatistics("2");
                return;
            case 3200:
                onNewTrack(this.mTrack.getPlayVideoInfo(), true);
                onRealVideoStart(i2, i3, obj);
                return;
            case 4000:
                this.mTrack.getPlayTimeTrack().putCoreParams(String.valueOf(obj));
                return;
            case 9003:
                this.mTrack.getPlayAbnormalDetailTrack().commit();
                return;
            case 80001:
                TLogUtil.loge(TAG, "onAbrSwitch ----> arg1:" + i2 + " arg2:" + i3 + " obj:" + obj);
                this.mTrack.getOneChangeTrack().abrSwitch();
                return;
            case 80002:
                this.mTrack.getOneEventTrack().commitOneEventStatistics("0");
                return;
            case 80003:
                this.mTrack.getOneEventTrack().commitOneEventStatistics("1");
                return;
            case 81002:
                Logger.d(TAG, "quic:" + obj);
                if (obj == null || !(obj instanceof String)) {
                    return;
                }
                if (((String) obj).contains("eventType=10")) {
                    this.mTrack.getOneEventTrack().commitOneEventStatistics("10");
                    return;
                } else {
                    this.mTrack.getOneEventTrack().commitOneEventStatistics("11");
                    return;
                }
            case 81003:
                Logger.d(TAG, "extreme tcp:" + obj);
                if (obj == null || !(obj instanceof String)) {
                    return;
                }
                if (((String) obj).contains("eventType=12")) {
                    this.mTrack.getOneEventTrack().commitOneEventStatistics("12");
                    return;
                } else {
                    this.mTrack.getOneEventTrack().commitOneEventStatistics("13");
                    return;
                }
            default:
                return;
        }
    }

    public void onNewTrack(PlayVideoInfo playVideoInfo) {
        onNewTrack(playVideoInfo, false);
    }

    public void onPlayerDestroy() {
        Logger.d(TAG, "onPlayerDestroy ");
        onVVEnd(true);
    }

    public void onStop() {
        if (this.mTrack == null) {
            return;
        }
        TLogUtil.loge("Impairment", "stop");
        onUserActionLoadingEnd("tune");
        this.mTrack.getPlayerInfoForVVEnd(MessageID.onStop);
    }

    public void prepareAsync() {
        Track track = this.mTrack;
        if (track != null) {
            track.prepareAsync();
        }
    }

    @Override // com.youku.alixplayer.opensdk.statistics.IPlayerTrack
    public void putString(String str, String str2) {
        Track track = this.mTrack;
        if (track != null) {
            track.putString(str, str2);
        } else if (TextUtils.isEmpty(str2) || this.mString.containsKey(str)) {
        } else {
            this.mString.put(str, str2);
        }
    }

    @Override // com.youku.alixplayer.opensdk.statistics.IPlayerTrack
    public void putTimestamp(String str, long j) {
        if (getPlayTimeTrack() != null) {
            getPlayTimeTrack().putTimestamp(str, j);
        } else if (j == 0 || this.mTimestamps.containsKey(str)) {
        } else {
            this.mTimestamps.put(str, Long.valueOf(j));
        }
    }

    @Override // com.youku.alixplayer.opensdk.statistics.IPlayerTrack
    public void removePlayerTrackInfoListener(OnPlayerTrackListener onPlayerTrackListener) {
        this.mOnPlayerTrackListeners.remove(onPlayerTrackListener);
    }

    @Override // com.youku.alixplayer.opensdk.statistics.IPlayerTrack
    public void setDynamicProperties(Callable<String> callable) {
        this.mDynamicProperties = callable;
    }

    protected void setParams(int i, Object obj) {
        Track track = this.mTrack;
        if (track != null) {
            track.setParams(i, obj);
        }
    }

    private void onNewTrack(PlayVideoInfo playVideoInfo, boolean z) {
        int i;
        Logger.d(TAG, "onNewRequest loopIndex:" + z);
        trackVideoSwitch();
        if (z) {
            Track track = this.mTrack;
            if (track != null) {
                i = track.getOnePlayTrack().getLoopPlayIndex() + 1;
                String str = "isPlayFromCache=" + this.mTrack.getOnePlayTrack().getIsPlayFromCache();
                Logger.d(TAG, "loopPlay isPlayFromCache :" + str);
                this.mTrack.setParams(3200, str);
            } else {
                throw new IllegalStateException("loop循环播放器的时候，Track为空");
            }
        } else {
            i = 0;
        }
        Track track2 = new Track(this.mContext, playVideoInfo, this.mPlayer, this);
        this.mTrack = track2;
        copyString(track2);
        copyTimestamp(this.mTrack);
        this.mTrack.onNewRequest();
        this.mHeartBeatReporter = new HeartBeatReporter(this.mTrack);
        this.mTrack.getOnePlayTrack().setLoopPlayIndex(i);
        for (OnPlayerTrackListener onPlayerTrackListener : this.mOnPlayerTrackListeners) {
            if (onPlayerTrackListener != null) {
                onPlayerTrackListener.onNewTrack(this.mTrack);
            }
        }
    }
}

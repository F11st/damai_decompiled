package com.youku.vpm;

import android.content.Context;
import android.util.Log;
import com.alimm.xadsdk.base.constant.AdConstants;
import com.youku.vpm.track.OneEventTrack;
import com.youku.vpm.track.Track;
import com.youku.vpm.utils.Logger;
import com.youku.vpm.utils.TLogUtil;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayerTrack implements IPlayerTrack {
    private static final String TAG = "PlayerTrack";
    private final Context mContext;
    private Callable mDynamicProperties;
    private final IPlayer mPlayer;
    private volatile Track mTrack;
    public boolean mIsFirstPlay = true;
    private final Map<String, Long> mTimestamps = new ConcurrentHashMap();
    private final Map<String, String> mString = new ConcurrentHashMap();
    private List<OnPlayerTrackListener> mOnPlayerTrackListeners = new CopyOnWriteArrayList();
    private boolean mIsActive = true;

    public PlayerTrack(Context context, IPlayer iPlayer) {
        this.mPlayer = iPlayer;
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

    private void onNewTrack(IVpmInfo iVpmInfo, boolean z) {
        int i;
        if (!z) {
            i = 0;
        } else if (this.mTrack == null) {
            throw new IllegalStateException("loop循环播放器的时候，Track为空");
        } else {
            i = this.mTrack.getOnePlayTrack().getLoopPlayIndex() + 1;
        }
        this.mTrack = new Track(this.mContext, iVpmInfo, this);
        copyString(this.mTrack);
        copyTimestamp(this.mTrack);
        this.mTrack.onNewRequest();
        this.mTrack.getOnePlayTrack().setLoopPlayIndex(i);
        for (OnPlayerTrackListener onPlayerTrackListener : this.mOnPlayerTrackListeners) {
            if (onPlayerTrackListener != null) {
                onPlayerTrackListener.onNewTrack(this.mTrack);
            }
        }
    }

    private void onPlayerCoreMsg(int i, int i2, int i3, Object obj) {
        OneEventTrack oneEventTrack;
        String str;
        Track track = this.mTrack;
        if (track == null) {
            return;
        }
        String str2 = "waiting";
        switch (i) {
            case -1012:
            case 1012:
            case 3012:
                track.getAdTrack().onPreAdEnd(i2);
                return;
            case AdConstants.TEMPLATE_IMAGE_VOTE_INTERACTION /* 365 */:
            case 368:
                track.putParamsFromCode(i + "", String.valueOf(obj));
                return;
            case 950:
                track.getSubtitleEventTrack().commit();
                return;
            case 1003:
                if (!this.mIsActive) {
                    TLogUtil.vpmLog("未激活状态下不进行卡顿上报");
                }
                TLogUtil.loge(TAG, "onStartLoading ----> arg1:" + i2 + " arg2:" + i3 + " obj:" + obj);
                track.getErrorTrack().onStartLoading(i2 == 1 ? "seek" : "net");
                if (i2 == 1) {
                    return;
                }
                if (i3 == 0) {
                    track.getImpairmentTrack().onPlayLoadingStart("waiting", i2, i3, obj);
                    return;
                }
                TLogUtil.loge(TAG, "adv onStartLoading");
                track.getAdTrack().onStartLoading(i3);
                return;
            case 1004:
                TLogUtil.loge(TAG, "onEndLoading ----> arg1:" + i2 + " arg2:" + i3 + " obj:" + obj);
                track.getErrorTrack().onEndLoading();
                if (i2 == 1) {
                    return;
                }
                track.getAdTrack().onEndLoading();
                if (i2 == 2) {
                    str2 = "videostart";
                } else if (i2 == 3) {
                    str2 = "lowspeed";
                }
                track.getImpairmentTrack().onPlayLoadingEnd(str2, i2, i3, obj);
                return;
            case 1011:
            case 3011:
                track.getOnePlayTrack().setIsADPlayFromCache(i3);
                track.getAdTrack().onPreAdStart(i2);
                track.getOnePlayTrack().onAdStart();
                return;
            case 1015:
            case 3015:
                track.getAdTrack().onStartPlayPostAD(i2);
                return;
            case 1017:
                Log.i("lwj", "on video start");
                onRealVideoStart(i2, i3, obj);
                return;
            case 4000:
                track.getPlayTimeTrack().putCoreParams(String.valueOf(obj));
                return;
            case 9003:
                track.getPlayAbnormalDetailTrack().commit();
                return;
            case 80002:
                oneEventTrack = track.getOneEventTrack();
                str = "0";
                break;
            case 80003:
                oneEventTrack = track.getOneEventTrack();
                str = "1";
                break;
            case 81002:
                Logger.d(TAG, "quic:" + obj);
                if (obj != null && (obj instanceof String)) {
                    if (!((String) obj).contains("eventType=10")) {
                        oneEventTrack = track.getOneEventTrack();
                        str = "11";
                        break;
                    } else {
                        oneEventTrack = track.getOneEventTrack();
                        str = "10";
                        break;
                    }
                } else {
                    return;
                }
                break;
            case 81003:
                Logger.d(TAG, "extreme tcp:" + obj);
                if (obj != null && (obj instanceof String)) {
                    if (!((String) obj).contains("eventType=12")) {
                        oneEventTrack = track.getOneEventTrack();
                        str = "13";
                        break;
                    } else {
                        oneEventTrack = track.getOneEventTrack();
                        str = "12";
                        break;
                    }
                } else {
                    return;
                }
                break;
            default:
                return;
        }
        oneEventTrack.commitOneEventStatistics(str);
    }

    private void onRealVideoStart(int i, int i2, Object obj) {
        Track track = this.mTrack;
        if (track != null) {
            track.getPlayTimeTrack().setPrepareInfo(String.valueOf(obj));
            track.onRealVideoStart();
            track.onVVBegin(2);
        }
    }

    @Override // com.youku.vpm.IPlayerTrack
    public void addPlayerTrackListener(OnPlayerTrackListener onPlayerTrackListener) {
        this.mOnPlayerTrackListeners.add(onPlayerTrackListener);
    }

    public String getDynamicProperty(String str) {
        Callable callable = this.mDynamicProperties;
        if (callable != null) {
            return (String) callable.call(str);
        }
        return null;
    }

    public List<OnPlayerTrackListener> getOnPlayerTrackListeners() {
        return this.mOnPlayerTrackListeners;
    }

    public IPlayer getPlayer() {
        return this.mPlayer;
    }

    @Override // com.youku.vpm.IPlayerTrack
    public ITrack getTrack() {
        return this.mTrack;
    }

    public boolean isActive() {
        return this.mIsActive;
    }

    @Override // com.youku.vpm.IPlayerTrack
    public void onActive(boolean z) {
        this.mIsActive = z;
        Track track = this.mTrack;
        if (track == null || !track.isRealVideoStarted()) {
            return;
        }
        track.onVVBegin(2);
    }

    @Override // com.youku.vpm.IPlayerTrack
    public void onCompletion() {
        Track track = this.mTrack;
        if (track != null) {
            track.onCompletion();
        }
    }

    @Override // com.youku.vpm.IPlayerTrack
    public void onDataFail(int i) {
        Track track = this.mTrack;
        if (track != null) {
            track.getPlayTimeTrack().putTimestamp(IPlayTimeTrack.ERROR, System.currentTimeMillis());
            track.onDataFail(i);
        }
    }

    @Override // com.youku.vpm.IPlayerTrack
    public void onDataReady(IVpmFullInfo iVpmFullInfo) {
        Track track = this.mTrack;
        if (track != null) {
            track.onDataReady(iVpmFullInfo);
        }
    }

    @Override // com.youku.vpm.IPlayerTrack
    public void onError(int i, int i2, Object obj) {
        Track track = this.mTrack;
        if (track == null) {
            return;
        }
        track.getPlayTimeTrack().putTimestamp(IPlayTimeTrack.ERROR, System.currentTimeMillis());
        track.onError(i, i2, obj);
    }

    @Override // com.youku.vpm.IPlayerTrack
    public void onInfo(int i, int i2, int i3, Object obj) {
        onPlayerCoreMsg(i, i2, i3, obj);
    }

    @Override // com.youku.vpm.IPlayerTrack
    public void onMsg(String str, Map<String, Object> map) {
        Track track = this.mTrack;
        if (track == null) {
            return;
        }
        TLogUtil.loge(TAG, "onMsg:" + str);
        str.hashCode();
        if (str.equals("onVVEnd")) {
            track.onStop((String) map.get("from"));
            this.mTrack = null;
        }
        if ("onQualityChangeStart".equals(str)) {
            track.getOnePlayTrack().addSwitchCounts();
            track.getQualityChangeTrack().onChangeVideoQualityStart();
        } else if (!"onQualityChangeFinish".equals(str) || map == null) {
        } else {
            track.getOnePlayTrack().addSwitchCounts();
            track.getQualityChangeTrack().onChangeVideoQualityFinish(((Boolean) map.get("isSuccess")).booleanValue(), (String) map.get("fromQuality"), (String) map.get("toQuality"));
        }
    }

    @Override // com.youku.vpm.IPlayerTrack
    public void onNewTrack(IVpmInfo iVpmInfo) {
        onNewTrack(iVpmInfo, false);
    }

    @Override // com.youku.vpm.IPlayerTrack
    public void onPause() {
        Track track = this.mTrack;
        if (track == null) {
            return;
        }
        track.getPlayTimeTrack().putTimestamp(IPlayTimeTrack.PAUSE, System.currentTimeMillis());
    }

    @Override // com.youku.vpm.IPlayerTrack
    public void onPositionChange(int i) {
        Track track = this.mTrack;
        if (track == null) {
            TLogUtil.vpmLog("正片没有起播，onCurrentPositionUpdate就已经执行");
        } else {
            track.getOnePlayTrack().onCurrentPositionUpdate(i);
        }
    }

    @Override // com.youku.vpm.IPlayerTrack
    public void onSeek(int i, int i2) {
        Track track = this.mTrack;
        if (track != null) {
            track.getSeekChangeTrack().onSeekTo(i2, i);
        }
    }

    @Override // com.youku.vpm.IPlayerTrack
    public void onSeekFinish(boolean z, Map<String, String> map) {
        Track track = this.mTrack;
        if (track != null) {
            track.getSeekChangeTrack().onSeekComplete();
        }
    }

    @Override // com.youku.vpm.IPlayerTrack
    public void onSliceBegin(int i, int i2, Object obj) {
        Track track = this.mTrack;
        if (track != null) {
            track.getAdTrack().onVideoSliceStart(i, i2, obj);
        }
    }

    @Override // com.youku.vpm.IPlayerTrack
    public void onSliceEnd(int i, int i2, Object obj) {
    }

    @Override // com.youku.vpm.IPlayerTrack
    public void onStart() {
    }

    @Override // com.youku.vpm.IPlayerTrack
    public void onStop(Map<String, Object> map) {
        if (this.mTrack == null) {
            return;
        }
        String str = (String) map.get("stopFrom");
        this.mTrack.putString("stopFrom", str);
        this.mTrack.getPlayTimeTrack().putTimestamp(IPlayTimeTrack.STOP, System.currentTimeMillis());
        TLogUtil.loge("Impairment", "stop");
        this.mTrack.onUserActionLoadingEnd("tune");
        this.mTrack.onStop(str);
        this.mTrack = null;
    }

    @Override // com.youku.vpm.IPlayerTrack
    public void putTimestamp(String str, long j) {
        Track track = this.mTrack;
        if (track != null) {
            track.getPlayTimeTrack().putTimestamp(str, j);
        } else if (j == 0 || this.mTimestamps.containsKey(str)) {
        } else {
            this.mTimestamps.put(str, Long.valueOf(j));
        }
    }

    @Override // com.youku.vpm.IPlayerTrack
    public void removePlayerTrackListener(OnPlayerTrackListener onPlayerTrackListener) {
        this.mOnPlayerTrackListeners.remove(onPlayerTrackListener);
    }

    @Override // com.youku.vpm.IPlayerTrack
    public void setDynamicProperties(Callable callable) {
        this.mDynamicProperties = callable;
    }
}

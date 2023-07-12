package com.youku.vpm;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IPlayerTrack {
    void addPlayerTrackListener(OnPlayerTrackListener onPlayerTrackListener);

    ITrack getTrack();

    void onActive(boolean z);

    void onCompletion();

    void onDataFail(int i);

    void onDataReady(IVpmFullInfo iVpmFullInfo);

    void onError(int i, int i2, Object obj);

    void onInfo(int i, int i2, int i3, Object obj);

    void onMsg(String str, Map<String, Object> map);

    void onNewTrack(IVpmInfo iVpmInfo);

    void onPause();

    void onPositionChange(int i);

    void onSeek(int i, int i2);

    void onSeekFinish(boolean z, Map<String, String> map);

    void onSliceBegin(int i, int i2, Object obj);

    void onSliceEnd(int i, int i2, Object obj);

    void onStart();

    void onStop(Map<String, Object> map);

    void putTimestamp(String str, long j);

    void removePlayerTrackListener(OnPlayerTrackListener onPlayerTrackListener);

    void setDynamicProperties(Callable callable);
}

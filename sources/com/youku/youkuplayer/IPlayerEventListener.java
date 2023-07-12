package com.youku.youkuplayer;

import com.youku.playerservice.axp.playinfo.PlayInfoResult;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IPlayerEventListener extends IAdEventListener {
    void onComplete();

    void onDataFail(int i, String str, Object obj);

    void onDataReady(PlayInfoResult playInfoResult);

    void onEndLoading();

    void onError(int i);

    void onInfo(int i, int i2, int i3, Object obj);

    void onNewRequest();

    void onPause();

    void onPlayInfoResult(PlayInfoResult playInfoResult);

    void onPositionChange(int i);

    void onPrepared();

    void onQualityChangeFinish(boolean z, Object obj);

    void onRealVideoStart();

    void onRelease();

    void onSeekComplete();

    void onStart();

    void onStartLoading();

    void onVideoSizeChanged(int i, int i2);
}

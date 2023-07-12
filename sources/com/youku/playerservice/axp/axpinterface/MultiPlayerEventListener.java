package com.youku.playerservice.axp.axpinterface;

import com.youku.playerservice.axp.playinfo.PlayInfoResult;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface MultiPlayerEventListener {
    void onComplete(int i);

    void onEndLoading(int i);

    void onError(int i, int i2);

    void onNewRequest();

    void onPause(int i);

    void onPlayInfoResult(PlayInfoResult playInfoResult);

    void onQualityChangeFailed(int i);

    void onQualityChangeSuccess(int i);

    void onRealVideoStart(int i);

    void onRelease(int i);

    void onStart(int i);

    void onStartLoading(int i);
}

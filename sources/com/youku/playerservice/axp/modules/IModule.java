package com.youku.playerservice.axp.modules;

import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.playparams.PlayParams;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IModule {
    void onAdStart();

    void onDataReady(PlayInfo playInfo);

    boolean onError(int i, int i2, Object obj);

    void onInfo(int i, int i2, int i3, Object obj);

    void onPause();

    void onPlay(PlayParams playParams);

    void onPositionChange(int i);

    void onQualityChangeFinish(boolean z, Object obj);

    void onRealVideoStart();

    void onSeekTo(int i);

    void onSliceBegin(int i, int i2, Object obj);

    void onSliceEnd(int i, int i2, Object obj);

    void onStart();

    void onStop();
}

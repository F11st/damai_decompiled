package cn.damai.player.base;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface IVideoController {
    void onLoadingEnd(Object obj);

    void onLoadingStart(Object obj);

    void onNewRequest(Object obj);

    void onPlayerCompletion(Object obj);

    void onPlayerError(Object obj);

    void onPlayerGetVideoInfoFailed(Object obj);

    void onPlayerGetVideoInfoSuccess(Object obj);

    void onPlayerPause(Object obj);

    void onPlayerPlaying(Object obj);

    void onPlayerPositionChange(Object obj);

    void onPlayerPrepared(Object obj);

    void onPlayerPreparing(Object obj);

    void onReloadSo();

    void onReloadSoFailed();

    void onReloadSoSuccess();

    void onScreenModeChanged(boolean z);

    void onSoLoadFailed();
}

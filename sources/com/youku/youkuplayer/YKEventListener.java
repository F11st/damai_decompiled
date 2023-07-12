package com.youku.youkuplayer;

import android.media.MediaPlayer;
import com.alimm.xadsdk.base.model.AdInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoResult;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKEventListener implements IPlayerEventListener {
    @Override // com.youku.youkuplayer.IAdEventListener
    public void onAdClick(int i, String str) {
    }

    @Override // com.youku.youkuplayer.IAdEventListener
    public void onAdCountUpdate(int i) {
    }

    @Override // com.youku.youkuplayer.IAdEventListener
    public void onAdEnd(int i, int i2) {
    }

    @Override // com.youku.youkuplayer.IAdEventListener
    public void onAdInit() {
    }

    @Override // com.youku.youkuplayer.IAdEventListener
    public void onAdPrepared(int i, AdInfo adInfo) {
    }

    @Override // com.youku.youkuplayer.IAdEventListener
    public void onAdReadyToClose(int i, AdInfo adInfo) {
    }

    @Override // com.youku.youkuplayer.IAdEventListener
    public void onAdReadyToShow(int i, AdInfo adInfo) {
    }

    @Override // com.youku.youkuplayer.IAdEventListener
    public void onAdStart(int i, int i2, int i3) {
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener
    public void onComplete() {
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener
    public void onDataFail(int i, String str, Object obj) {
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener
    public void onDataReady(PlayInfoResult playInfoResult) {
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener
    public void onEndLoading() {
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener
    public void onError(int i) {
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener
    public void onInfo(int i, int i2, int i3, Object obj) {
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener
    public void onNewRequest() {
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener
    public void onPause() {
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener
    public void onPlayInfoResult(PlayInfoResult playInfoResult) {
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener
    public void onPositionChange(int i) {
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener
    public void onPrepared() {
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener
    public void onQualityChangeFinish(boolean z, Object obj) {
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener
    public void onRealVideoStart() {
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener
    public void onRelease() {
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener
    public void onSeekComplete() {
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener
    public void onStart() {
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener
    public void onStartLoading() {
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener
    public void onVideoSizeChanged(int i, int i2) {
    }
}

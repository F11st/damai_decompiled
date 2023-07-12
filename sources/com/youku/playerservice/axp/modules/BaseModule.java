package com.youku.playerservice.axp.modules;

import android.content.Context;
import com.youku.playerservice.axp.player.PlayerImpl;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.playparams.PlayParams;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class BaseModule implements IModule {
    protected Context mContext;
    protected boolean mIsAdShowing;
    protected PlayerImpl mPlayer;

    public BaseModule(Context context, PlayerImpl playerImpl) {
        this.mContext = context;
        this.mPlayer = playerImpl;
    }

    public PlayInfo getPlayInfo() {
        return this.mPlayer.getPlayInfo();
    }

    protected boolean isAdShowing() {
        return this.mIsAdShowing;
    }

    @Override // com.youku.playerservice.axp.modules.IModule
    public void onAdStart() {
        this.mIsAdShowing = true;
    }

    @Override // com.youku.playerservice.axp.modules.IModule
    public void onDataReady(PlayInfo playInfo) {
    }

    @Override // com.youku.playerservice.axp.modules.IModule
    public boolean onError(int i, int i2, Object obj) {
        return false;
    }

    @Override // com.youku.playerservice.axp.modules.IModule
    public void onInfo(int i, int i2, int i3, Object obj) {
    }

    @Override // com.youku.playerservice.axp.modules.IModule
    public void onPause() {
    }

    @Override // com.youku.playerservice.axp.modules.IModule
    public void onPlay(PlayParams playParams) {
    }

    @Override // com.youku.playerservice.axp.modules.IModule
    public void onPositionChange(int i) {
    }

    @Override // com.youku.playerservice.axp.modules.IModule
    public void onQualityChangeFinish(boolean z, Object obj) {
    }

    @Override // com.youku.playerservice.axp.modules.IModule
    public void onRealVideoStart() {
        this.mIsAdShowing = false;
    }

    @Override // com.youku.playerservice.axp.modules.IModule
    public void onSeekTo(int i) {
    }

    @Override // com.youku.playerservice.axp.modules.IModule
    public void onSliceBegin(int i, int i2, Object obj) {
    }

    @Override // com.youku.playerservice.axp.modules.IModule
    public void onSliceEnd(int i, int i2, Object obj) {
    }

    @Override // com.youku.playerservice.axp.modules.IModule
    public void onStart() {
    }

    @Override // com.youku.playerservice.axp.modules.IModule
    public void onStop() {
    }
}

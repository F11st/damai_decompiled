package com.alimm.xadsdk.business.playerad;

import android.content.Context;
import androidx.annotation.NonNull;
import com.alimm.xadsdk.AdSdkManager;
import com.alimm.xadsdk.base.model.AdInfo;
import com.alimm.xadsdk.base.model.BidInfo;
import com.alimm.xadsdk.base.utils.AdUtUtils;
import com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler;
import com.alimm.xadsdk.business.playerad.interfaces.IAdPlayerInterface;
import com.alimm.xadsdk.business.playerad.interfaces.IPlayerEventListener;
import com.alimm.xadsdk.business.playerad.model.AdEvent;
import com.alimm.xadsdk.business.playerad.model.PlayerVideoInfo;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class BasePlayerAdController implements IAdEventHandler, IPlayerEventListener {
    protected AdInfo mAdvInfo;
    protected Context mContext;
    protected BidInfo mCurrentAdvItem;
    protected PlayerAdEventDispatcher mMediator;
    protected IAdPlayerInterface mPlayerImpl;
    protected PlayerVideoInfo mVideoInfo;

    public BasePlayerAdController(@NonNull Context context, @NonNull PlayerAdEventDispatcher playerAdEventDispatcher, @NonNull IAdPlayerInterface iAdPlayerInterface) {
        this.mContext = context;
        this.mPlayerImpl = iAdPlayerInterface;
        this.mMediator = playerAdEventDispatcher;
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler
    public AdInfo getAdvInfo(int i) {
        return this.mAdvInfo;
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler
    public BidInfo onAdClick(int i) {
        BidInfo bidInfo = this.mCurrentAdvItem;
        if (bidInfo != null) {
            AdUtUtils.recordAdClick(bidInfo, i, null);
            AdSdkManager.getInstance().getExposeManager().exposeCum(this.mCurrentAdvItem, false, false);
        }
        return this.mCurrentAdvItem;
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler
    public void onAdCountDown(int i, int i2) {
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler
    public void onAdEnd(int i, int i2) {
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler
    public void onAdError(int i, int i2, int i3) {
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler
    public void onAdEvent(int i, AdEvent adEvent) {
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler
    public int onAdSkip(int i) {
        return 0;
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler
    public void onAdStart(int i, int i2) {
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IPlayerEventListener
    public void onAllVideoEnd() {
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IPlayerEventListener
    public void onCurrentPositionChanged(int i) {
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IPlayerEventListener
    public void onFullscreenChange(boolean z) {
        PlayerVideoInfo playerVideoInfo = this.mVideoInfo;
        if (playerVideoInfo != null) {
            playerVideoInfo.setFullscreen(z);
        }
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IPlayerEventListener
    public void onPlayerStateChange(String str, Object obj) {
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IPlayerEventListener
    public void onRealVideoEnd() {
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IPlayerEventListener
    public void onRealVideoPause() {
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IPlayerEventListener
    public void onRealVideoResume() {
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IPlayerEventListener
    public void onRealVideoStart() {
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IPlayerEventListener
    public void onVideoPrepared(PlayerVideoInfo playerVideoInfo, AdInfo adInfo, String str, String str2) {
        this.mVideoInfo = playerVideoInfo;
        this.mAdvInfo = null;
        this.mCurrentAdvItem = null;
    }
}

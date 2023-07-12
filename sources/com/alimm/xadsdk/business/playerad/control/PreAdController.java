package com.alimm.xadsdk.business.playerad.control;

import android.content.Context;
import androidx.annotation.NonNull;
import com.alimm.xadsdk.AdSdkManager;
import com.alimm.xadsdk.base.expose.ExposeUtil;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.alimm.xadsdk.base.model.AdInfo;
import com.alimm.xadsdk.base.model.BidInfo;
import com.alimm.xadsdk.base.model.MonitorInfo;
import com.alimm.xadsdk.base.utils.AdUtUtils;
import com.alimm.xadsdk.base.utils.LogUtils;
import com.alimm.xadsdk.business.playerad.BasePlayerAdController;
import com.alimm.xadsdk.business.playerad.PlayerAdEventDispatcher;
import com.alimm.xadsdk.business.playerad.interfaces.IAdPlayerInterface;
import com.alimm.xadsdk.business.playerad.model.PlayerVideoInfo;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class PreAdController extends BasePlayerAdController {
    private static final String TAG = "PreAdController";
    private boolean mCanSkip;
    private int mCurrentIndex;
    private int mCurrentPosition;
    private int mHasPlayedDuration;
    private int mLastCountDown;
    private int mPlayingMonitorPosition;
    private int mSkipPosition;
    private int mTotalDuration;

    public PreAdController(@NonNull Context context, @NonNull PlayerAdEventDispatcher playerAdEventDispatcher, @NonNull IAdPlayerInterface iAdPlayerInterface) {
        super(context, playerAdEventDispatcher, iAdPlayerInterface);
        this.mCurrentIndex = -1;
        this.mLastCountDown = 0;
        this.mTotalDuration = 0;
        this.mHasPlayedDuration = 0;
        this.mCurrentPosition = 0;
        this.mSkipPosition = -1;
        this.mCanSkip = false;
    }

    private int getSkipPosition(BidInfo bidInfo) {
        if (bidInfo == null || bidInfo.getAllMonitorInfo() == null || bidInfo.getAllMonitorInfo().get(MonitorType.SKIP) == null) {
            return -1;
        }
        return ((MonitorInfo) bidInfo.getAllMonitorInfo().get(MonitorType.SKIP)).getTime();
    }

    private int getTotalDuration(AdInfo adInfo) {
        int i = 0;
        if (adInfo != null && adInfo.getBidInfoList() != null) {
            for (BidInfo bidInfo : adInfo.getBidInfoList()) {
                i += bidInfo.getDuration();
            }
        }
        return i;
    }

    private void reset() {
        this.mAdvInfo = null;
        this.mCurrentAdvItem = null;
        this.mCurrentIndex = -1;
        this.mLastCountDown = 0;
        this.mTotalDuration = 0;
        this.mHasPlayedDuration = 0;
        this.mCurrentPosition = 0;
        this.mSkipPosition = -1;
        this.mCanSkip = false;
    }

    @Override // com.alimm.xadsdk.business.playerad.BasePlayerAdController, com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler
    public void onAdCountDown(int i, int i2) {
        BidInfo bidInfo;
        super.onAdCountDown(i, i2);
        if (this.mLastCountDown == i2 || (bidInfo = this.mCurrentAdvItem) == null) {
            return;
        }
        this.mLastCountDown = i2;
        int i3 = (this.mTotalDuration - i2) - this.mHasPlayedDuration;
        this.mCurrentPosition = i3;
        if (i3 < 0) {
            this.mCurrentPosition = 0;
        }
        int i4 = this.mPlayingMonitorPosition;
        int i5 = this.mCurrentPosition;
        if (i4 != i5 && ExposeUtil.containsValidSu(bidInfo, i5)) {
            AdSdkManager.getInstance().getExposeManager().expose(this.mCurrentAdvItem, MonitorType.PLAYING, this.mCurrentPosition, true, this.mVideoInfo.isOffline());
            this.mPlayingMonitorPosition = this.mCurrentPosition;
        }
        int i6 = this.mSkipPosition;
        if (i6 <= -1 || this.mCurrentPosition < i6) {
            return;
        }
        this.mCanSkip = true;
    }

    @Override // com.alimm.xadsdk.business.playerad.BasePlayerAdController, com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler
    public void onAdEnd(int i, int i2) {
        super.onAdEnd(i, i2);
        BidInfo bidInfo = this.mCurrentAdvItem;
        if (bidInfo != null) {
            AdUtUtils.recordAdFinish(bidInfo, 7, null);
            AdSdkManager.getInstance().getExposeManager().expose(this.mCurrentAdvItem, MonitorType.PLAY_END, true, this.mVideoInfo.isOffline());
            this.mHasPlayedDuration += this.mCurrentAdvItem.getDuration();
        }
        AdInfo adInfo = this.mAdvInfo;
        if (adInfo == null || adInfo.getBidInfoList() == null || this.mAdvInfo.getBidInfoList().size() - 1 != i2) {
            return;
        }
        LogUtils.d(TAG, "onAdEnd: all ad end.");
    }

    @Override // com.alimm.xadsdk.business.playerad.BasePlayerAdController, com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler
    public void onAdError(int i, int i2, int i3) {
        super.onAdError(i, i2, i3);
        BidInfo bidInfo = this.mCurrentAdvItem;
        if (bidInfo != null) {
            AdUtUtils.recordAdError(bidInfo, 7, i3, null);
        }
    }

    @Override // com.alimm.xadsdk.business.playerad.BasePlayerAdController, com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler
    public int onAdSkip(int i) {
        BidInfo bidInfo = this.mCurrentAdvItem;
        if (bidInfo == null || !this.mCanSkip) {
            return -1;
        }
        AdUtUtils.recordAdClosed(bidInfo, 7, null);
        AdSdkManager.getInstance().getExposeManager().expose(this.mCurrentAdvItem, MonitorType.SKIP, false, this.mVideoInfo.isOffline());
        return 0;
    }

    @Override // com.alimm.xadsdk.business.playerad.BasePlayerAdController, com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler
    public void onAdStart(int i, int i2) {
        super.onAdStart(i, i2);
        this.mPlayingMonitorPosition = 0;
        AdInfo adInfo = this.mAdvInfo;
        if (adInfo == null || adInfo.getBidInfoList() == null || this.mAdvInfo.getBidInfoList().size() <= i2 || i2 < 0) {
            return;
        }
        this.mCurrentIndex = i2;
        BidInfo bidInfo = this.mAdvInfo.getBidInfoList().get(i2);
        this.mCurrentAdvItem = bidInfo;
        AdUtUtils.recordAdStart(bidInfo, 7, null);
        AdSdkManager.getInstance().getExposeManager().exposeSus(this.mCurrentAdvItem, true, this.mVideoInfo.isOffline());
        this.mSkipPosition = getSkipPosition(this.mCurrentAdvItem);
    }

    @Override // com.alimm.xadsdk.business.playerad.BasePlayerAdController, com.alimm.xadsdk.business.playerad.interfaces.IPlayerEventListener
    public void onRealVideoStart() {
        LogUtils.d(TAG, "onRealVideoStart.");
        reset();
    }

    @Override // com.alimm.xadsdk.business.playerad.BasePlayerAdController, com.alimm.xadsdk.business.playerad.interfaces.IPlayerEventListener
    public void onVideoPrepared(PlayerVideoInfo playerVideoInfo, AdInfo adInfo, String str, String str2) {
        super.onVideoPrepared(playerVideoInfo, adInfo, str, str2);
        this.mAdvInfo = adInfo;
        this.mCurrentIndex = -1;
        this.mLastCountDown = 0;
        this.mTotalDuration = getTotalDuration(adInfo);
        this.mHasPlayedDuration = 0;
        this.mCurrentPosition = 0;
        this.mSkipPosition = -1;
        this.mCanSkip = false;
    }
}

package com.youku.youkuplayer.plugin.ad;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.alimm.xadsdk.AdSdkConfig;
import com.alimm.xadsdk.AdSdkManager;
import com.alimm.xadsdk.base.model.AdInfo;
import com.alimm.xadsdk.base.model.BidInfo;
import com.alimm.xadsdk.business.playerad.PlayerAdManager;
import com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler;
import com.alimm.xadsdk.business.playerad.interfaces.IPlayerEventListener;
import com.alimm.xadsdk.business.playerad.interfaces.OnAdEventListener;
import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.axpinterface.IPlayerService;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.interceptor.Chain;
import com.youku.playerservice.axp.interceptor.Interceptor;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoResult;
import com.youku.youkuplayer.YKEventListener;
import com.youku.youkuplayer.YoukuPlayer;
import com.youku.youkuplayer.util.PlayerLog;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class AdPlugin extends YKEventListener implements Interceptor, IAdAction {
    private static final String TAG = "AdPlugin";
    private static boolean mAdHasInit;
    private IAdEventHandler mAdEventHandler;
    private volatile AdInfo mAdInfo;
    private AdPlayerInterface mAdPlayerInterface;
    private YoukuPlayer.PlayerCallBack mCallBack;
    private Context mContext;
    private boolean mIsRealVideoStarted;
    private PlayInfo mPlayVideoInfo;
    private PlayerAdManager mPlayerAdManager;
    private PlayerConfig mPlayerConfig;
    private IPlayerEventListener mPlayerEventListener;
    private IPlayerService mPlayerService;
    private volatile int mCurrentAdIndex = -1;
    private Handler mUiHandler = new Handler(Looper.getMainLooper());

    public AdPlugin(Context context, IPlayerService iPlayerService, PlayerConfig playerConfig) {
        this.mContext = context;
        this.mPlayerService = iPlayerService;
        this.mPlayerConfig = playerConfig;
        initAdConfig();
    }

    private void initAdEventListener() {
        this.mPlayerAdManager.setOnAdEventListener(new OnAdEventListener() { // from class: com.youku.youkuplayer.plugin.ad.AdPlugin.1
            @Override // com.alimm.xadsdk.business.playerad.interfaces.OnAdEventListener
            public void onDataPrepared(int i, AdInfo adInfo) {
                PlayerLog.d(AdPlugin.TAG, "onDataPrepared ...");
                AdPlugin.this.onAdPrepared(i, adInfo);
            }

            @Override // com.alimm.xadsdk.business.playerad.interfaces.OnAdEventListener
            public void onReadyToClose(int i, AdInfo adInfo) {
                PlayerLog.d(AdPlugin.TAG, "onReadyToClose ...");
                AdPlugin.this.onAdReadyToClose(i, adInfo);
            }

            @Override // com.alimm.xadsdk.business.playerad.interfaces.OnAdEventListener
            public void onReadyToShow(int i, AdInfo adInfo) {
                PlayerLog.d(AdPlugin.TAG, "onReadyToShow ...");
                AdPlugin.this.onAdReadyToShow(i, adInfo);
            }
        });
    }

    @Override // com.youku.youkuplayer.plugin.ad.IAdAction
    public void clickAd(int i) {
        BidInfo onAdClick;
        YoukuPlayer.PlayerCallBack playerCallBack;
        IAdEventHandler iAdEventHandler = this.mAdEventHandler;
        if (iAdEventHandler == null || (onAdClick = iAdEventHandler.onAdClick(i)) == null || (playerCallBack = this.mCallBack) == null) {
            return;
        }
        playerCallBack.onAdClick(i, onAdClick.getCreativeUrl());
    }

    public void initAdConfig() {
        AdPlayerInterface adPlayerInterface = new AdPlayerInterface(this.mContext, this.mPlayerService, this);
        this.mAdPlayerInterface = adPlayerInterface;
        PlayerAdManager playerAdManager = new PlayerAdManager(this.mContext, adPlayerInterface);
        this.mPlayerAdManager = playerAdManager;
        playerAdManager.setAdEnabled(7, true);
        this.mAdEventHandler = this.mPlayerAdManager.getAdEventHandler();
        this.mPlayerEventListener = this.mPlayerAdManager.getPlayerEventListener();
        if (!mAdHasInit) {
            AdSdkManager.getInstance().init((Application) this.mContext.getApplicationContext(), new AdSdkConfig());
            onAdInit();
        }
        initAdEventListener();
    }

    @Override // com.youku.playerservice.axp.interceptor.Interceptor
    public void intercept(Chain chain) {
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IAdEventListener
    public void onAdClick(int i, String str) {
        super.onAdClick(i, str);
        PlayerLog.d(TAG, "adType ...adType " + i + " , url : " + str);
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IAdEventListener
    public void onAdCountUpdate(int i) {
        super.onAdCountUpdate(i);
        PlayerLog.d(TAG, "onAdCountUpdate ...onAdCountUpdate count : " + i);
        this.mAdEventHandler.onAdCountDown(7, i);
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IAdEventListener
    public void onAdEnd(int i, int i2) {
        super.onAdEnd(i, i2);
        PlayerLog.d(TAG, "onAdEnd ...adType " + i + " , index : " + i2);
        this.mAdEventHandler.onAdEnd(7, i2);
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IAdEventListener
    public void onAdPrepared(int i, AdInfo adInfo) {
        super.onAdPrepared(i, adInfo);
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IAdEventListener
    public void onAdStart(int i, int i2, int i3) {
        super.onAdStart(i, i2, i3);
        PlayerLog.d(TAG, "onAdStart ...adType " + i + " , index : " + i2);
        this.mAdEventHandler.onAdStart(7, i2);
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onComplete() {
        super.onComplete();
        IPlayerEventListener iPlayerEventListener = this.mPlayerEventListener;
        if (iPlayerEventListener != null) {
            iPlayerEventListener.onRealVideoEnd();
        }
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onDataFail(int i, String str, Object obj) {
        super.onDataFail(i, str, obj);
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onDataReady(PlayInfoResult playInfoResult) {
        PlayInfo playInfo;
        super.onDataReady(playInfoResult);
        if (playInfoResult == null || (playInfo = playInfoResult.getPlayInfo()) == null || playInfo.getAdInfo() == null) {
            return;
        }
        this.mCurrentAdIndex = -1;
        this.mAdInfo = playInfo.getAdInfo();
        this.mPlayerEventListener.onVideoPrepared(AdUtil.getAdRequestParams(this.mContext, playInfo), this.mAdInfo, null, null);
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onError(int i) {
        super.onError(i);
    }

    public void onFullscreenChange(boolean z) {
        IPlayerEventListener iPlayerEventListener = this.mPlayerEventListener;
        if (iPlayerEventListener != null) {
            iPlayerEventListener.onFullscreenChange(z);
        }
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onNewRequest() {
        super.onNewRequest();
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onPause() {
        super.onPause();
        IPlayerEventListener iPlayerEventListener = this.mPlayerEventListener;
        if (iPlayerEventListener != null) {
            iPlayerEventListener.onRealVideoPause();
        }
    }

    public void onPlayerStateChange(String str, Object obj) {
        IPlayerEventListener iPlayerEventListener = this.mPlayerEventListener;
        if (iPlayerEventListener != null) {
            iPlayerEventListener.onPlayerStateChange(str, obj);
        }
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onPositionChange(int i) {
        super.onPositionChange(i);
        IPlayerEventListener iPlayerEventListener = this.mPlayerEventListener;
        if (iPlayerEventListener != null) {
            iPlayerEventListener.onCurrentPositionChanged(i);
        }
    }

    public void onRealVideoResume() {
        IPlayerEventListener iPlayerEventListener = this.mPlayerEventListener;
        if (iPlayerEventListener != null) {
            iPlayerEventListener.onRealVideoResume();
        }
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onRealVideoStart() {
        super.onRealVideoStart();
        PlayInfo playInfo = this.mPlayVideoInfo;
        if (playInfo != null && playInfo.getPlayType() == PlayDefinition.PlayType.LIVE) {
            this.mIsRealVideoStarted = true;
        }
        new HashMap().put("isAdPlaying", Boolean.FALSE);
        runOnUiThread(new Runnable() { // from class: com.youku.youkuplayer.plugin.ad.AdPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                if (AdPlugin.this.mPlayerEventListener != null) {
                    AdPlugin.this.mPlayerEventListener.onRealVideoStart();
                }
            }
        });
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onStart() {
        super.onStart();
        IPlayerEventListener iPlayerEventListener = this.mPlayerEventListener;
        if (iPlayerEventListener != null) {
            iPlayerEventListener.onRealVideoStart();
        }
    }

    public final void runOnUiThread(Runnable runnable) {
        if (Thread.currentThread() == this.mUiHandler.getLooper().getThread()) {
            runnable.run();
        } else {
            this.mUiHandler.post(runnable);
        }
    }

    public void setCallback(YoukuPlayer.PlayerCallBack playerCallBack) {
        this.mCallBack = playerCallBack;
    }

    @Override // com.youku.youkuplayer.plugin.ad.IAdAction
    public int skipAd(int i) {
        IPlayerService iPlayerService = this.mPlayerService;
        if (iPlayerService != null) {
            iPlayerService.skipAD(-1);
        }
        IAdEventHandler iAdEventHandler = this.mAdEventHandler;
        if (iAdEventHandler != null) {
            iAdEventHandler.onAdSkip(i);
            return 0;
        }
        return 0;
    }
}

package com.alimm.xadsdk.business.playerad;

import android.content.Context;
import androidx.annotation.NonNull;
import com.alimm.xadsdk.base.model.AdInfo;
import com.alimm.xadsdk.base.model.BidInfo;
import com.alimm.xadsdk.base.utils.LogUtils;
import com.alimm.xadsdk.business.playerad.control.PreAdController;
import com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler;
import com.alimm.xadsdk.business.playerad.interfaces.IAdPlayerInterface;
import com.alimm.xadsdk.business.playerad.interfaces.IPlayerEventListener;
import com.alimm.xadsdk.business.playerad.interfaces.OnAdEventListener;
import com.alimm.xadsdk.business.playerad.model.AdEvent;
import com.alimm.xadsdk.business.playerad.model.PlayerVideoInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class PlayerAdEventDispatcher implements IAdEventHandler, IPlayerEventListener {
    private Context mContext;
    private OnAdEventListener mOnAdEventListener;
    private IAdPlayerInterface mPlayerImpl;
    private final String TAG = "PlayerAdEventDispatcher";
    private Map<Integer, BasePlayerAdController> mControllerMap = new ConcurrentHashMap(16);

    public PlayerAdEventDispatcher(@NonNull Context context, @NonNull IAdPlayerInterface iAdPlayerInterface) {
        LogUtils.d("PlayerAdEventDispatcher", "PlayerAdEventDispatcher: context = " + context + ", playerImpl = " + iAdPlayerInterface);
        this.mContext = context;
        this.mPlayerImpl = iAdPlayerInterface;
    }

    private void registerController(int i) {
        PreAdController preAdController = i != 7 ? null : new PreAdController(this.mContext, this, this.mPlayerImpl);
        if (preAdController != null) {
            this.mControllerMap.put(Integer.valueOf(i), preAdController);
        }
    }

    private void unregisterController(int i) {
        this.mControllerMap.remove(Integer.valueOf(i));
    }

    public void destroy() {
        LogUtils.d("PlayerAdEventDispatcher", "destroy: mControllerMap = " + this.mControllerMap);
        Map<Integer, BasePlayerAdController> map = this.mControllerMap;
        if (map != null) {
            map.clear();
            this.mControllerMap = null;
        }
        this.mPlayerImpl = null;
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler
    public AdInfo getAdvInfo(int i) {
        BasePlayerAdController basePlayerAdController = this.mControllerMap.get(Integer.valueOf(i));
        LogUtils.d("PlayerAdEventDispatcher", "getAdvInfo: adType = " + i + ", controller = " + basePlayerAdController);
        if (basePlayerAdController != null) {
            return basePlayerAdController.getAdvInfo(i);
        }
        return null;
    }

    public BasePlayerAdController getController(int i) {
        return this.mControllerMap.get(Integer.valueOf(i));
    }

    public void notifyAdDataPrepared(int i, AdInfo adInfo) {
        OnAdEventListener onAdEventListener = this.mOnAdEventListener;
        if (onAdEventListener != null) {
            onAdEventListener.onDataPrepared(i, adInfo);
        }
    }

    public void notifyAdReadyToClose(int i, AdInfo adInfo) {
        OnAdEventListener onAdEventListener = this.mOnAdEventListener;
        if (onAdEventListener != null) {
            onAdEventListener.onReadyToClose(i, adInfo);
        }
    }

    public void notifyAdReadyToShow(int i, AdInfo adInfo) {
        OnAdEventListener onAdEventListener = this.mOnAdEventListener;
        if (onAdEventListener != null) {
            onAdEventListener.onReadyToShow(i, adInfo);
        }
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler
    public BidInfo onAdClick(int i) {
        BasePlayerAdController basePlayerAdController = this.mControllerMap.get(Integer.valueOf(i));
        LogUtils.d("PlayerAdEventDispatcher", "onAdClick: adType = " + i + ", controller = " + basePlayerAdController);
        if (basePlayerAdController != null) {
            return basePlayerAdController.onAdClick(i);
        }
        return null;
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler
    public void onAdCountDown(int i, int i2) {
        BasePlayerAdController basePlayerAdController = this.mControllerMap.get(Integer.valueOf(i));
        LogUtils.d("PlayerAdEventDispatcher", "onAdCountDown: adType = " + i + ", countDown = " + i2 + ", controller = " + basePlayerAdController);
        if (basePlayerAdController != null) {
            basePlayerAdController.onAdCountDown(i, i2);
        }
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler
    public void onAdEnd(int i, int i2) {
        BasePlayerAdController basePlayerAdController = this.mControllerMap.get(Integer.valueOf(i));
        LogUtils.d("PlayerAdEventDispatcher", "onAdEnd: adType = " + i + ", id = " + i2 + ", controller = " + basePlayerAdController);
        if (basePlayerAdController != null) {
            basePlayerAdController.onAdEnd(i, i2);
        }
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler
    public void onAdError(int i, int i2, int i3) {
        BasePlayerAdController basePlayerAdController = this.mControllerMap.get(Integer.valueOf(i));
        LogUtils.d("PlayerAdEventDispatcher", "onAdError: adType = " + i + ", id = " + i2 + ", errCode = " + i3 + ", controller = " + basePlayerAdController);
        if (basePlayerAdController != null) {
            basePlayerAdController.onAdError(i, i2, i3);
        }
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler
    public void onAdEvent(int i, AdEvent adEvent) {
        BasePlayerAdController basePlayerAdController = this.mControllerMap.get(Integer.valueOf(i));
        LogUtils.d("PlayerAdEventDispatcher", "onAdEvent: adType = " + i + ", controller = " + basePlayerAdController);
        if (basePlayerAdController != null) {
            basePlayerAdController.onAdEvent(i, adEvent);
        }
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler
    public int onAdSkip(int i) {
        BasePlayerAdController basePlayerAdController = this.mControllerMap.get(Integer.valueOf(i));
        LogUtils.d("PlayerAdEventDispatcher", "onAdSkip: adType = " + i + ", controller = " + basePlayerAdController);
        if (basePlayerAdController != null) {
            return basePlayerAdController.onAdSkip(i);
        }
        return 0;
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler
    public void onAdStart(int i, int i2) {
        BasePlayerAdController basePlayerAdController = this.mControllerMap.get(Integer.valueOf(i));
        LogUtils.d("PlayerAdEventDispatcher", "onAdStart: adType = " + i + ", id = " + i2 + ", controller = " + basePlayerAdController);
        if (basePlayerAdController != null) {
            basePlayerAdController.onAdStart(i, i2);
        }
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IPlayerEventListener
    public void onAllVideoEnd() {
        LogUtils.d("PlayerAdEventDispatcher", "onAllVideoEnd.");
        for (Integer num : this.mControllerMap.keySet()) {
            BasePlayerAdController basePlayerAdController = this.mControllerMap.get(num);
            if (basePlayerAdController != null) {
                basePlayerAdController.onAllVideoEnd();
            }
        }
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IPlayerEventListener
    public void onCurrentPositionChanged(int i) {
        LogUtils.d("PlayerAdEventDispatcher", "onCurrentPositionChanged: pos = " + i);
        for (Integer num : this.mControllerMap.keySet()) {
            BasePlayerAdController basePlayerAdController = this.mControllerMap.get(num);
            if (basePlayerAdController != null) {
                basePlayerAdController.onCurrentPositionChanged(i);
            }
        }
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IPlayerEventListener
    public void onFullscreenChange(boolean z) {
        LogUtils.d("PlayerAdEventDispatcher", "onFullscreenChange: isFullscreen = " + z);
        for (Integer num : this.mControllerMap.keySet()) {
            BasePlayerAdController basePlayerAdController = this.mControllerMap.get(num);
            if (basePlayerAdController != null) {
                basePlayerAdController.onFullscreenChange(z);
            }
        }
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IPlayerEventListener
    public void onPlayerStateChange(String str, Object obj) {
        LogUtils.d("PlayerAdEventDispatcher", "onPlayerStateChange: key = " + str + ", value = " + obj);
        for (Integer num : this.mControllerMap.keySet()) {
            BasePlayerAdController basePlayerAdController = this.mControllerMap.get(num);
            if (basePlayerAdController != null) {
                basePlayerAdController.onPlayerStateChange(str, obj);
            }
        }
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IPlayerEventListener
    public void onRealVideoEnd() {
        LogUtils.d("PlayerAdEventDispatcher", "onRealVideoEnd.");
        for (Integer num : this.mControllerMap.keySet()) {
            BasePlayerAdController basePlayerAdController = this.mControllerMap.get(num);
            if (basePlayerAdController != null) {
                basePlayerAdController.onRealVideoEnd();
            }
        }
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IPlayerEventListener
    public void onRealVideoPause() {
        LogUtils.d("PlayerAdEventDispatcher", "onRealVideoPause.");
        for (Integer num : this.mControllerMap.keySet()) {
            BasePlayerAdController basePlayerAdController = this.mControllerMap.get(num);
            if (basePlayerAdController != null) {
                basePlayerAdController.onRealVideoPause();
            }
        }
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IPlayerEventListener
    public void onRealVideoResume() {
        LogUtils.d("PlayerAdEventDispatcher", "onRealVideoResume.");
        for (Integer num : this.mControllerMap.keySet()) {
            BasePlayerAdController basePlayerAdController = this.mControllerMap.get(num);
            if (basePlayerAdController != null) {
                basePlayerAdController.onRealVideoResume();
            }
        }
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IPlayerEventListener
    public void onRealVideoStart() {
        LogUtils.d("PlayerAdEventDispatcher", "onRealVideoStart.");
        for (Integer num : this.mControllerMap.keySet()) {
            BasePlayerAdController basePlayerAdController = this.mControllerMap.get(num);
            if (basePlayerAdController != null) {
                basePlayerAdController.onRealVideoStart();
            }
        }
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IPlayerEventListener
    public void onVideoPrepared(PlayerVideoInfo playerVideoInfo, AdInfo adInfo, String str, String str2) {
        LogUtils.d("PlayerAdEventDispatcher", "onVideoPrepared: videoInfo = " + playerVideoInfo + ", preAdvInfo = " + adInfo + ", midAdPoint = " + str + ", streamAdPoint = " + str2);
        for (Integer num : this.mControllerMap.keySet()) {
            BasePlayerAdController basePlayerAdController = this.mControllerMap.get(num);
            if (basePlayerAdController != null) {
                basePlayerAdController.onVideoPrepared(playerVideoInfo, adInfo, str, str2);
            }
        }
    }

    public void setAdEnabled(int i, boolean z) {
        LogUtils.d("PlayerAdEventDispatcher", "setAdEnabled: adType = " + i + ", enabled = " + z);
        if (!z) {
            unregisterController(i);
        } else if (this.mControllerMap.get(Integer.valueOf(i)) == null) {
            registerController(i);
        }
    }

    public void setOnAdEventListener(OnAdEventListener onAdEventListener) {
        LogUtils.d("PlayerAdEventDispatcher", "setOnAdEventListener: listener = " + onAdEventListener);
        this.mOnAdEventListener = onAdEventListener;
    }
}

package com.alimm.xadsdk.business.playerad;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alimm.xadsdk.base.model.AdInfo;
import com.alimm.xadsdk.base.model.BidInfo;
import com.alimm.xadsdk.base.utils.AdUtUtils;
import com.alimm.xadsdk.business.common.utils.AdUtils;
import com.alimm.xadsdk.business.playerad.interfaces.IAdEventHandler;
import com.alimm.xadsdk.business.playerad.interfaces.IAdPlayerInterface;
import com.alimm.xadsdk.business.playerad.interfaces.IPlayerEventListener;
import com.alimm.xadsdk.business.playerad.interfaces.OnAdEventListener;
import com.alimm.xadsdk.request.RequestUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class PlayerAdManager {
    private PlayerAdEventDispatcher mPlayerAdEventDispatcher;

    public PlayerAdManager(Context context, IAdPlayerInterface iAdPlayerInterface) {
        if (context == null || iAdPlayerInterface == null) {
            throw new RuntimeException("Constructor should set context and player instance!");
        }
        this.mPlayerAdEventDispatcher = new PlayerAdEventDispatcher(context, iAdPlayerInterface);
    }

    public static Map<String, String> getAdRequestParams(Context context, int i) {
        if (i == 7) {
            AdUtUtils.recordAdRequestStart(i, null);
            return RequestUtils.getAdQueryParams(7, new HashMap(32));
        }
        return new HashMap(16);
    }

    public static AdInfo parseAd(String str) {
        AdInfo adInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            adInfo = (AdInfo) JSON.parseObject(str, AdInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
            adInfo = null;
        }
        int i = 0;
        AdUtUtils.recordAdRequestEnd(7, 200, 0L, adInfo != null ? adInfo.getAdCount() : 0, null);
        if (AdUtils.hasAdvInfo(adInfo)) {
            for (int size = adInfo.getBidInfoList().size() - 1; size >= 0; size--) {
                BidInfo bidInfo = adInfo.getBidInfoList().get(size);
                if (TextUtils.isEmpty(bidInfo.getCreativeUrl())) {
                    adInfo.getBidInfoList().remove(bidInfo);
                }
            }
            int size2 = adInfo.getBidInfoList().size();
            while (i < size2) {
                BidInfo bidInfo2 = adInfo.getBidInfoList().get(i);
                bidInfo2.setType(7);
                i++;
                bidInfo2.setIndex(i);
                bidInfo2.putExtend("reqid", adInfo.getRequestId());
            }
            AdUtUtils.recordAdNode(adInfo, 7, null);
        }
        return adInfo;
    }

    public void destroy() {
        PlayerAdEventDispatcher playerAdEventDispatcher = this.mPlayerAdEventDispatcher;
        if (playerAdEventDispatcher != null) {
            playerAdEventDispatcher.setOnAdEventListener(null);
            this.mPlayerAdEventDispatcher.destroy();
            this.mPlayerAdEventDispatcher = null;
        }
    }

    public IAdEventHandler getAdEventHandler() {
        return this.mPlayerAdEventDispatcher;
    }

    public IPlayerEventListener getPlayerEventListener() {
        return this.mPlayerAdEventDispatcher;
    }

    public void setAdEnabled(int i, boolean z) {
        PlayerAdEventDispatcher playerAdEventDispatcher = this.mPlayerAdEventDispatcher;
        if (playerAdEventDispatcher != null) {
            playerAdEventDispatcher.setAdEnabled(i, z);
        }
    }

    public void setOnAdEventListener(OnAdEventListener onAdEventListener) {
        PlayerAdEventDispatcher playerAdEventDispatcher = this.mPlayerAdEventDispatcher;
        if (playerAdEventDispatcher != null) {
            playerAdEventDispatcher.setOnAdEventListener(onAdEventListener);
        }
    }
}

package com.alimm.xadsdk.business.playerad.interfaces;

import com.alimm.xadsdk.base.model.AdInfo;
import com.alimm.xadsdk.base.model.BidInfo;
import com.alimm.xadsdk.business.playerad.model.AdEvent;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IAdEventHandler {
    public static final int SKIP_AD_FAILED = -1;
    public static final int SKIP_AD_SUCCESS = 0;

    AdInfo getAdvInfo(int i);

    BidInfo onAdClick(int i);

    void onAdCountDown(int i, int i2);

    void onAdEnd(int i, int i2);

    void onAdError(int i, int i2, int i3);

    void onAdEvent(int i, AdEvent adEvent);

    int onAdSkip(int i);

    void onAdStart(int i, int i2);
}

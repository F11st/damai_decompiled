package com.youku.youkuplayer;

import com.alimm.xadsdk.base.model.AdInfo;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IAdEventListener {
    void onAdClick(int i, String str);

    void onAdCountUpdate(int i);

    void onAdEnd(int i, int i2);

    void onAdInit();

    void onAdPrepared(int i, AdInfo adInfo);

    void onAdReadyToClose(int i, AdInfo adInfo);

    void onAdReadyToShow(int i, AdInfo adInfo);

    void onAdStart(int i, int i2, int i3);
}

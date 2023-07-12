package com.alimm.xadsdk.business.playerad.interfaces;

import com.alimm.xadsdk.base.model.AdInfo;
import com.alimm.xadsdk.business.playerad.model.PlayerVideoInfo;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IPlayerEventListener {
    void onAllVideoEnd();

    void onCurrentPositionChanged(int i);

    void onFullscreenChange(boolean z);

    void onPlayerStateChange(String str, Object obj);

    void onRealVideoEnd();

    void onRealVideoPause();

    void onRealVideoResume();

    void onRealVideoStart();

    void onVideoPrepared(PlayerVideoInfo playerVideoInfo, AdInfo adInfo, String str, String str2);
}

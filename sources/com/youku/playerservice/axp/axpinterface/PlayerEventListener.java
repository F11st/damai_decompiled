package com.youku.playerservice.axp.axpinterface;

import com.youku.playerservice.axp.playinfo.PlayInfoResult;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface PlayerEventListener extends InternalPlayerEventListener {
    void onNewRequest();

    void onPlayInfoResult(PlayInfoResult playInfoResult);
}

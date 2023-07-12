package com.youku.playerservice.axp.playinfo;

import com.youku.android.liveservice.bean.LivePlayControl;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class LiveInfo {
    private boolean mIsTrail;
    private LivePlayControl mLivePlayControl;

    public LiveInfo(LivePlayControl livePlayControl) {
        this.mLivePlayControl = livePlayControl;
    }

    public LivePlayControl getLivePlayControl() {
        return this.mLivePlayControl;
    }

    public boolean isTrail() {
        return this.mIsTrail;
    }

    public void setTrail(boolean z) {
        this.mIsTrail = z;
    }
}

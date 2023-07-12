package com.youku.alixplayer.opensdk.fast;

import com.youku.alixplayer.opensdk.FileFormat;
import com.youku.alixplayer.opensdk.live.LiveInfo;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class FastData {
    private boolean mIsRequestVideoInfo;
    private LiveInfo mLiveInfo;

    public FastData() {
    }

    public LiveInfo getLiveInfo() {
        return this.mLiveInfo;
    }

    public boolean isRequestVideoInfo() {
        return this.mIsRequestVideoInfo;
    }

    public void setLiveInfo(LiveInfo liveInfo) {
        this.mLiveInfo = liveInfo;
    }

    public FastData(FileFormat fileFormat, String str, boolean z) {
        this.mLiveInfo = new LiveInfo(fileFormat, str);
        this.mIsRequestVideoInfo = z;
    }
}

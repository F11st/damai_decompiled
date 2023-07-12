package com.youku.alixplayer.opensdk;

import com.youku.alixplayer.opensdk.live.LiveMediaSource;
import com.youku.android.liveservice.bean.BypassPlayInfo;
import com.youku.android.liveservice.bean.LivePlayControl;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface OnMediaSourceGeneratedListener {
    void onMediaSourceGeneratFailed(BypassPlayInfo bypassPlayInfo, LivePlayControl livePlayControl, String str, int i, String str2);

    void onMediaSourceGenerated(LiveMediaSource liveMediaSource, List<LiveMediaSource> list);
}

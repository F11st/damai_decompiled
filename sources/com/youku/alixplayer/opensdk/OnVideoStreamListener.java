package com.youku.alixplayer.opensdk;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface OnVideoStreamListener {
    void onDataFail(VideoRequestError videoRequestError);

    void onDataReady(YoukuVideoInfo youkuVideoInfo);

    void onNewRequest(PlayVideoInfo playVideoInfo);
}

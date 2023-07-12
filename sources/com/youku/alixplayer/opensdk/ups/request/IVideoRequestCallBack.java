package com.youku.alixplayer.opensdk.ups.request;

import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.upsplayer.data.ConnectStat;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public interface IVideoRequestCallBack {
    void onFailed(VideoRequestError videoRequestError);

    void onStat(ConnectStat connectStat);

    void onSuccess(YoukuVideoInfo youkuVideoInfo);
}

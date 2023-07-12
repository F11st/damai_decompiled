package com.youku.upsplayer;

import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.module.SimpleVideoInfo;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IMultiVideoInfoCallBack {
    void onGetVideoInfoResult(List<SimpleVideoInfo> list, ConnectStat connectStat);
}

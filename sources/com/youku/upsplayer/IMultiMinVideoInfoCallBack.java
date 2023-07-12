package com.youku.upsplayer;

import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.module.MinVideoInfo;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IMultiMinVideoInfoCallBack {
    void onGetVideoInfoResult(List<MinVideoInfo> list, ConnectStat connectStat);
}

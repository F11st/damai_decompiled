package com.youku.ups.request;

import com.youku.upsplayer.data.ConnectStat;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface a<T> {
    void onFailure(com.youku.ups.data.a aVar);

    void onSuccess(com.youku.ups.data.b<T> bVar, ConnectStat connectStat);
}

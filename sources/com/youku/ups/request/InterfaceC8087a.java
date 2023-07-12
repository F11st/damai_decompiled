package com.youku.ups.request;

import com.youku.ups.data.C8085a;
import com.youku.ups.data.C8086b;
import com.youku.upsplayer.data.ConnectStat;

/* compiled from: Taobao */
/* renamed from: com.youku.ups.request.a */
/* loaded from: classes3.dex */
public interface InterfaceC8087a<T> {
    void onFailure(C8085a c8085a);

    void onSuccess(C8086b<T> c8086b, ConnectStat connectStat);
}

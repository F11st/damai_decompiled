package com.youku.live.dsl.network;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface INetClient {
    INetRequest createRequestWithHttp(String str, Map<String, String> map, boolean z);

    INetRequest createRequestWithMTop(String str, String str2, Map<String, String> map, boolean z, boolean z2);

    String getMtopId();
}

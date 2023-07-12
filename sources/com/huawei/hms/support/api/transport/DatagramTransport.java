package com.huawei.hms.support.api.transport;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface DatagramTransport {

    /* compiled from: Taobao */
    /* renamed from: com.huawei.hms.support.api.transport.DatagramTransport$a */
    /* loaded from: classes10.dex */
    public interface InterfaceC5723a {
        void a(int i, IMessageEntity iMessageEntity);
    }

    void post(ApiClient apiClient, InterfaceC5723a interfaceC5723a);

    void send(ApiClient apiClient, InterfaceC5723a interfaceC5723a);
}

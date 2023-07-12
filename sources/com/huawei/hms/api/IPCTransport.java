package com.huawei.hms.api;

import android.os.Bundle;
import com.huawei.hms.core.aidl.C5545a;
import com.huawei.hms.core.aidl.C5546b;
import com.huawei.hms.core.aidl.C5554e;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.InterfaceC5548c;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class IPCTransport implements DatagramTransport {
    private final String a;
    private final IMessageEntity b;
    private final Class<? extends IMessageEntity> c;
    private int d;

    public IPCTransport(String str, IMessageEntity iMessageEntity, Class<? extends IMessageEntity> cls) {
        this.a = str;
        this.b = iMessageEntity;
        this.c = cls;
    }

    private int a(ApiClient apiClient, InterfaceC5548c interfaceC5548c) {
        if (apiClient instanceof HuaweiApiClientImpl) {
            C5546b c5546b = new C5546b(this.a, ProtocolNegotiate.getInstance().getVersion());
            C5554e a = C5545a.a(c5546b.c());
            c5546b.a(a.a(this.b, new Bundle()));
            RequestHeader requestHeader = new RequestHeader();
            requestHeader.setAppID(apiClient.getAppID());
            requestHeader.setPackageName(apiClient.getPackageName());
            requestHeader.setSdkVersion(60400302);
            requestHeader.setApiNameList(((HuaweiApiClientImpl) apiClient).getApiNameList());
            requestHeader.setSessionId(apiClient.getSessionId());
            requestHeader.setApiLevel(this.d);
            c5546b.b = a.a(requestHeader, new Bundle());
            try {
                HuaweiApiClientImpl huaweiApiClientImpl = (HuaweiApiClientImpl) apiClient;
                if (huaweiApiClientImpl.getService() == null) {
                    HMSLog.e("IPCTransport", "HuaweiApiClient is not binded to service yet.");
                    return CommonCode.ErrorCode.INTERNAL_ERROR;
                }
                huaweiApiClientImpl.getService().a(c5546b, interfaceC5548c);
                return 0;
            } catch (Exception e) {
                HMSLog.e("IPCTransport", "sync call ex:" + e);
                return CommonCode.ErrorCode.INTERNAL_ERROR;
            }
        }
        if (apiClient instanceof AidlApiClient) {
            AidlApiClient aidlApiClient = (AidlApiClient) apiClient;
            C5546b c5546b2 = new C5546b(this.a, ProtocolNegotiate.getInstance().getVersion());
            c5546b2.a(C5545a.a(c5546b2.c()).a(this.b, new Bundle()));
            try {
                aidlApiClient.getService().a(c5546b2, interfaceC5548c);
                return 0;
            } catch (Exception e2) {
                HMSLog.e("IPCTransport", "sync call ex:" + e2);
            }
        }
        return CommonCode.ErrorCode.INTERNAL_ERROR;
    }

    @Override // com.huawei.hms.support.api.transport.DatagramTransport
    public final void post(ApiClient apiClient, DatagramTransport.InterfaceC5723a interfaceC5723a) {
        send(apiClient, interfaceC5723a);
    }

    @Override // com.huawei.hms.support.api.transport.DatagramTransport
    public final void send(ApiClient apiClient, DatagramTransport.InterfaceC5723a interfaceC5723a) {
        int a = a(apiClient, new IPCCallback(this.c, interfaceC5723a));
        if (a != 0) {
            interfaceC5723a.a(a, null);
        }
    }

    public IPCTransport(String str, IMessageEntity iMessageEntity, Class<? extends IMessageEntity> cls, int i) {
        this.a = str;
        this.b = iMessageEntity;
        this.c = cls;
        this.d = i;
    }
}

package com.huawei.hms.api;

import android.os.Bundle;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.core.aidl.c;
import com.huawei.hms.core.aidl.e;
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

    private int a(ApiClient apiClient, c cVar) {
        if (apiClient instanceof HuaweiApiClientImpl) {
            com.huawei.hms.core.aidl.b bVar = new com.huawei.hms.core.aidl.b(this.a, ProtocolNegotiate.getInstance().getVersion());
            e a = com.huawei.hms.core.aidl.a.a(bVar.c());
            bVar.a(a.a(this.b, new Bundle()));
            RequestHeader requestHeader = new RequestHeader();
            requestHeader.setAppID(apiClient.getAppID());
            requestHeader.setPackageName(apiClient.getPackageName());
            requestHeader.setSdkVersion(60400302);
            requestHeader.setApiNameList(((HuaweiApiClientImpl) apiClient).getApiNameList());
            requestHeader.setSessionId(apiClient.getSessionId());
            requestHeader.setApiLevel(this.d);
            bVar.b = a.a(requestHeader, new Bundle());
            try {
                HuaweiApiClientImpl huaweiApiClientImpl = (HuaweiApiClientImpl) apiClient;
                if (huaweiApiClientImpl.getService() == null) {
                    HMSLog.e("IPCTransport", "HuaweiApiClient is not binded to service yet.");
                    return CommonCode.ErrorCode.INTERNAL_ERROR;
                }
                huaweiApiClientImpl.getService().a(bVar, cVar);
                return 0;
            } catch (Exception e) {
                HMSLog.e("IPCTransport", "sync call ex:" + e);
                return CommonCode.ErrorCode.INTERNAL_ERROR;
            }
        }
        if (apiClient instanceof AidlApiClient) {
            AidlApiClient aidlApiClient = (AidlApiClient) apiClient;
            com.huawei.hms.core.aidl.b bVar2 = new com.huawei.hms.core.aidl.b(this.a, ProtocolNegotiate.getInstance().getVersion());
            bVar2.a(com.huawei.hms.core.aidl.a.a(bVar2.c()).a(this.b, new Bundle()));
            try {
                aidlApiClient.getService().a(bVar2, cVar);
                return 0;
            } catch (Exception e2) {
                HMSLog.e("IPCTransport", "sync call ex:" + e2);
            }
        }
        return CommonCode.ErrorCode.INTERNAL_ERROR;
    }

    @Override // com.huawei.hms.support.api.transport.DatagramTransport
    public final void post(ApiClient apiClient, DatagramTransport.a aVar) {
        send(apiClient, aVar);
    }

    @Override // com.huawei.hms.support.api.transport.DatagramTransport
    public final void send(ApiClient apiClient, DatagramTransport.a aVar) {
        int a = a(apiClient, new IPCCallback(this.c, aVar));
        if (a != 0) {
            aVar.a(a, null);
        }
    }

    public IPCTransport(String str, IMessageEntity iMessageEntity, Class<? extends IMessageEntity> cls, int i) {
        this.a = str;
        this.b = iMessageEntity;
        this.c = cls;
        this.d = i;
    }
}

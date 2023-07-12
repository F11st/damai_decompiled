package com.huawei.hms.api;

import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.core.aidl.C5545a;
import com.huawei.hms.core.aidl.C5546b;
import com.huawei.hms.core.aidl.C5554e;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.InterfaceC5548c;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class IPCCallback extends InterfaceC5548c.AbstractBinderC5549a {
    private final Class<? extends IMessageEntity> a;
    private final DatagramTransport.InterfaceC5723a b;

    public IPCCallback(Class<? extends IMessageEntity> cls, DatagramTransport.InterfaceC5723a interfaceC5723a) {
        this.a = cls;
        this.b = interfaceC5723a;
    }

    @Override // com.huawei.hms.core.aidl.InterfaceC5548c
    public void call(C5546b c5546b) throws RemoteException {
        if (c5546b != null && !TextUtils.isEmpty(c5546b.a)) {
            C5554e a = C5545a.a(c5546b.c());
            IMessageEntity iMessageEntity = null;
            if (c5546b.b() > 0 && (iMessageEntity = newResponseInstance()) != null) {
                a.a(c5546b.a(), iMessageEntity);
            }
            if (c5546b.b != null) {
                ResponseHeader responseHeader = new ResponseHeader();
                a.a(c5546b.b, responseHeader);
                this.b.a(responseHeader.getStatusCode(), iMessageEntity);
                return;
            }
            this.b.a(0, iMessageEntity);
            return;
        }
        HMSLog.e("IPCCallback", "In call, URI cannot be empty.");
        throw new RemoteException();
    }

    protected IMessageEntity newResponseInstance() {
        Class<? extends IMessageEntity> cls = this.a;
        if (cls != null) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException | InstantiationException e) {
                HMSLog.e("IPCCallback", "In newResponseInstance, instancing exception." + e.getMessage());
                return null;
            }
        }
        return null;
    }
}

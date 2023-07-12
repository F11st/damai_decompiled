package com.taobao.aranger.core.ipc.channel;

import android.os.IBinder;
import android.os.RemoteException;
import com.taobao.aranger.core.entity.Callback;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.core.ipc.proxy.ClientServiceProxy;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IClientService;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.taobao.aranger.core.ipc.channel.c */
/* loaded from: classes11.dex */
public class C6694c extends AbstractC6692a {
    private final IClientService a;

    public C6694c(IBinder iBinder) {
        this.a = ClientServiceProxy.getProxy(iBinder);
    }

    @Override // com.taobao.aranger.core.ipc.channel.AbstractC6692a
    public Reply a(Callback callback) throws IPCException {
        try {
            return this.a.sendCallback(callback);
        } catch (Exception e) {
            if (!(e instanceof IPCException)) {
                if (e instanceof RemoteException) {
                    throw new IPCException(2, e);
                }
                throw new IPCException(9, e);
            }
            throw ((IPCException) e);
        }
    }

    @Override // com.taobao.aranger.core.ipc.channel.IChannel
    public void internalRecycle(List<String> list) throws IPCException {
        try {
            this.a.recycle(list);
        } catch (Exception e) {
            if (!(e instanceof IPCException)) {
                if (e instanceof RemoteException) {
                    throw new IPCException(27, e);
                }
                throw new IPCException(9, e);
            }
            throw ((IPCException) e);
        }
    }
}

package com.taobao.aranger.core.ipc.channel;

import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.mit.IPCMonitor;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class b implements IChannel {
    private void a(IPCMonitor.IpcState ipcState, IPCException iPCException, long j, long j2) throws IPCException {
        ipcState.q(iPCException != null ? iPCException.getErrorCode() : 0);
        ipcState.n(d.c);
        ipcState.l(System.currentTimeMillis() - (j + j2));
        ipcState.o(j2);
        ipcState.j();
        if (iPCException != null) {
            throw iPCException;
        }
    }

    public final void b() throws IPCException {
        IPCMonitor.IpcState ipcState = new IPCMonitor.IpcState(6);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            c();
            e = null;
        } catch (IPCException e) {
            e = e;
        }
        a(ipcState, e, currentTimeMillis, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c() throws IPCException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Reply d(Call call) throws IPCException;

    public final void e(List<String> list) throws IPCException {
        IPCMonitor.IpcState ipcState = new IPCMonitor.IpcState(4);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            internalRecycle(list);
            e = null;
        } catch (IPCException e) {
            e = e;
        }
        a(ipcState, e, currentTimeMillis, 0L);
    }

    public final Reply f(Call call) throws IPCException {
        IPCMonitor.IpcState ipcState;
        IPCException iPCException;
        long j;
        Reply reply;
        int type = call.getServiceWrapper().getType();
        if (type == 0) {
            ipcState = new IPCMonitor.IpcState(0);
        } else if (type != 1) {
            ipcState = new IPCMonitor.IpcState(2);
            ipcState.p(call.getMethodWrapper().getName());
        } else {
            ipcState = new IPCMonitor.IpcState(1);
            ipcState.p(call.getMethodWrapper().getName());
        }
        IPCMonitor.IpcState ipcState2 = ipcState;
        ipcState2.r(call.getServiceWrapper().getName());
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = 0;
        try {
            Reply d = d(call);
            try {
                ipcState2.m(call.getDataSize());
                j2 = d.getInvokeTime();
                j = j2;
                reply = d;
                iPCException = d.isError() ? new IPCException(d.getErrorCode(), d.getErrorMessage()) : null;
            } catch (IPCException e) {
                e = e;
                r2 = d;
                iPCException = e;
                j = j2;
                reply = r2;
                a(ipcState2, iPCException, currentTimeMillis, j);
                return reply;
            }
        } catch (IPCException e2) {
            e = e2;
        }
        a(ipcState2, iPCException, currentTimeMillis, j);
        return reply;
    }
}

package com.taobao.aranger.core.ipc.channel;

import com.taobao.aranger.core.entity.Callback;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.mit.IPCMonitor;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class a implements IChannel {
    abstract Reply a(Callback callback) throws IPCException;

    public final void b(List<String> list) throws IPCException {
        IPCMonitor.IpcState ipcState = new IPCMonitor.IpcState(5);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            internalRecycle(list);
            ipcState.q(0);
            e = null;
        } catch (IPCException e) {
            e = e;
        }
        if (e != null) {
            ipcState.q(e.getErrorCode());
        }
        ipcState.l(System.currentTimeMillis() - currentTimeMillis);
        ipcState.j();
        if (e != null) {
            throw e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0054 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0055  */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.taobao.aranger.core.entity.Reply c(com.taobao.aranger.core.entity.Callback r10) throws com.taobao.aranger.exception.IPCException {
        /*
            r9 = this;
            com.taobao.aranger.mit.IPCMonitor$IpcState r0 = new com.taobao.aranger.mit.IPCMonitor$IpcState
            r1 = 3
            r0.<init>(r1)
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 0
            r4 = 0
            com.taobao.aranger.core.entity.Reply r6 = r9.a(r10)     // Catch: com.taobao.aranger.exception.IPCException -> L3a
            long r7 = r10.getDataSize()     // Catch: com.taobao.aranger.exception.IPCException -> L37
            r0.m(r7)     // Catch: com.taobao.aranger.exception.IPCException -> L37
            int r10 = r6.getErrorCode()     // Catch: com.taobao.aranger.exception.IPCException -> L37
            r0.q(r10)     // Catch: com.taobao.aranger.exception.IPCException -> L37
            long r4 = r6.getInvokeTime()     // Catch: com.taobao.aranger.exception.IPCException -> L37
            boolean r10 = r6.isError()     // Catch: com.taobao.aranger.exception.IPCException -> L37
            if (r10 == 0) goto L3d
            com.taobao.aranger.exception.IPCException r3 = new com.taobao.aranger.exception.IPCException     // Catch: com.taobao.aranger.exception.IPCException -> L37
            int r10 = r6.getErrorCode()     // Catch: com.taobao.aranger.exception.IPCException -> L37
            java.lang.String r7 = r6.getErrorMessage()     // Catch: com.taobao.aranger.exception.IPCException -> L37
            r3.<init>(r10, r7)     // Catch: com.taobao.aranger.exception.IPCException -> L37
            goto L3d
        L37:
            r10 = move-exception
            r3 = r6
            goto L3b
        L3a:
            r10 = move-exception
        L3b:
            r6 = r3
            r3 = r10
        L3d:
            if (r3 == 0) goto L46
            int r10 = r3.getErrorCode()
            r0.q(r10)
        L46:
            long r7 = java.lang.System.currentTimeMillis()
            long r7 = r7 - r1
            long r7 = r7 - r4
            r0.l(r7)
            r0.j()
            if (r3 != 0) goto L55
            return r6
        L55:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.aranger.core.ipc.channel.a.c(com.taobao.aranger.core.entity.Callback):com.taobao.aranger.core.entity.Reply");
    }
}

package com.taobao.aranger.core.ipc.proxy;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.Keep;
import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.core.entity.Callback;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IClientService;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ClientServiceProxy extends Binder implements IClientService {
    private final IBinder mRemote;

    private ClientServiceProxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public static IClientService getProxy(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(Constants.CLIENT_SERVICE_DESCRIPTOR);
        if (queryLocalInterface instanceof IClientService) {
            return (IClientService) queryLocalInterface;
        }
        return new ClientServiceProxy(iBinder);
    }

    @Override // android.os.IInterface
    @Keep
    public IBinder asBinder() {
        return this.mRemote;
    }

    @Override // com.taobao.aranger.intf.IService
    public void recycle(List<String> list) throws Exception {
        if (this.mRemote.isBinderAlive()) {
            Parcel obtain = Parcel.obtain();
            try {
                obtain.writeStringList(list);
                this.mRemote.transact(4, obtain, null, 1);
                return;
            } finally {
                obtain.recycle();
            }
        }
        throw new IPCException(5, "the remote binder is not alive");
    }

    @Override // com.taobao.aranger.intf.IClientService
    public Reply sendCallback(Callback callback) throws Exception {
        Parcel obtain;
        int i;
        if (this.mRemote.isBinderAlive()) {
            Parcel obtain2 = Parcel.obtain();
            Parcel parcel = null;
            try {
                obtain = !callback.isVoid() ? Parcel.obtain() : null;
                i = 0;
            } catch (Throwable th) {
                th = th;
            }
            try {
                callback.writeToParcel(obtain2, 0);
                IBinder iBinder = this.mRemote;
                if (callback.isOneWay() && callback.isVoid()) {
                    i = 1;
                }
                iBinder.transact(3, obtain2, obtain, i);
                if (callback.isVoid()) {
                    Reply result = Reply.obtain().setResult(null);
                    obtain2.recycle();
                    if (obtain != null) {
                        obtain.recycle();
                    }
                    return result;
                } else if (obtain != null && obtain.dataSize() != 0) {
                    Reply createFromParcel = Reply.CREATOR.createFromParcel(obtain);
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } else {
                    throw new IPCException(33, "reply data decode error from client channel!");
                }
            } catch (Throwable th2) {
                th = th2;
                parcel = obtain;
                obtain2.recycle();
                if (parcel != null) {
                    parcel.recycle();
                }
                throw th;
            }
        }
        throw new IPCException(5, "the remote binder is not alive");
    }
}

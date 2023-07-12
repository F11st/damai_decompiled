package com.taobao.aranger.core.ipc.proxy;

import android.os.IBinder;
import android.os.Parcel;
import androidx.annotation.Keep;
import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.core.ipc.provider.ARangerProvider;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IRemoteService;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class RemoteServiceProxy implements IRemoteService {
    private static volatile IRemoteService b;
    private final IBinder a;

    private RemoteServiceProxy(IBinder iBinder) {
        this.a = iBinder;
    }

    public static IRemoteService a(IBinder iBinder) {
        if (iBinder.queryLocalInterface(Constants.DEFAULT_CONTENT_DESCRIPTOR) != null) {
            if (b == null) {
                synchronized (RemoteServiceProxy.class) {
                    if (b == null) {
                        b = new ARangerProvider();
                    }
                }
            }
            return b;
        }
        return new RemoteServiceProxy(iBinder);
    }

    @Override // android.os.IInterface
    @Keep
    public IBinder asBinder() {
        return this.a;
    }

    @Override // com.taobao.aranger.intf.IRemoteService
    public void connect() throws Exception {
        Parcel obtain = Parcel.obtain();
        try {
            this.a.transact(2, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    @Override // com.taobao.aranger.intf.IRemoteService
    public boolean isRemote() {
        return this.a.queryLocalInterface(Constants.DEFAULT_CONTENT_DESCRIPTOR) == null;
    }

    @Override // com.taobao.aranger.intf.IService
    public void recycle(List<String> list) throws Exception {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeStringList(list);
            this.a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    @Override // com.taobao.aranger.intf.IRemoteService
    public Reply sendCall(Call call) throws Exception {
        Parcel obtain;
        Parcel obtain2 = Parcel.obtain();
        Parcel parcel = null;
        try {
            obtain = !call.isVoid() ? Parcel.obtain() : null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            call.writeToParcel(obtain2, 0);
            this.a.transact(0, obtain2, obtain, (call.isOneWay() && call.isVoid()) ? 1 : 0);
            if (call.isVoid()) {
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
                throw new IPCException(34, "reply data decode error from hook remote channel!");
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
}

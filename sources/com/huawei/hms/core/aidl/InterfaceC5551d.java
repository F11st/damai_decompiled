package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.core.aidl.d */
/* loaded from: classes10.dex */
public interface InterfaceC5551d extends IInterface {
    void a(C5546b c5546b, InterfaceC5548c interfaceC5548c) throws RemoteException;

    /* compiled from: Taobao */
    /* renamed from: com.huawei.hms.core.aidl.d$a */
    /* loaded from: classes10.dex */
    public static abstract class AbstractBinderC5552a extends Binder implements InterfaceC5551d {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: Taobao */
        /* renamed from: com.huawei.hms.core.aidl.d$a$a */
        /* loaded from: classes10.dex */
        public static class C5553a implements InterfaceC5551d {
            public static InterfaceC5551d b;
            private IBinder a;

            C5553a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.huawei.hms.core.aidl.InterfaceC5551d
            public void a(C5546b c5546b, InterfaceC5548c interfaceC5548c) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.core.aidl.IAIDLInvoke");
                    if (c5546b != null) {
                        obtain.writeInt(1);
                        c5546b.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(interfaceC5548c != null ? interfaceC5548c.asBinder() : null);
                    if (this.a.transact(2, obtain, null, 1) || AbstractBinderC5552a.a() == null) {
                        return;
                    }
                    AbstractBinderC5552a.a().a(c5546b, interfaceC5548c);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public static InterfaceC5551d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.core.aidl.IAIDLInvoke");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC5551d)) {
                return (InterfaceC5551d) queryLocalInterface;
            }
            return new C5553a(iBinder);
        }

        public static InterfaceC5551d a() {
            return C5553a.b;
        }
    }
}

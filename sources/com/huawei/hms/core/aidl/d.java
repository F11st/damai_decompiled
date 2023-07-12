package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface d extends IInterface {
    void a(b bVar, c cVar) throws RemoteException;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class a extends Binder implements d {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: Taobao */
        /* renamed from: com.huawei.hms.core.aidl.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C0250a implements d {
            public static d b;
            private IBinder a;

            C0250a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.huawei.hms.core.aidl.d
            public void a(b bVar, c cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.core.aidl.IAIDLInvoke");
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    if (this.a.transact(2, obtain, null, 1) || a.a() == null) {
                        return;
                    }
                    a.a().a(bVar, cVar);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.core.aidl.IAIDLInvoke");
            if (queryLocalInterface != null && (queryLocalInterface instanceof d)) {
                return (d) queryLocalInterface;
            }
            return new C0250a(iBinder);
        }

        public static d a() {
            return C0250a.b;
        }
    }
}

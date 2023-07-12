package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface c extends IInterface {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class a extends Binder implements c {

        /* compiled from: Taobao */
        /* renamed from: com.huawei.hms.core.aidl.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        private static class C0249a implements c {
            public static c b;
            private IBinder a;

            C0249a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public a() {
            attachInterface(this, "com.huawei.hms.core.aidl.IAIDLCallback");
        }

        public static c asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.core.aidl.IAIDLCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                return (c) queryLocalInterface;
            }
            return new C0249a(iBinder);
        }

        public static c getDefaultImpl() {
            return C0249a.b;
        }

        public static boolean setDefaultImpl(c cVar) {
            if (C0249a.b != null || cVar == null) {
                return false;
            }
            C0249a.b = cVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.huawei.hms.core.aidl.IAIDLCallback");
                call(parcel.readInt() != 0 ? b.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.huawei.hms.core.aidl.IAIDLCallback");
                return true;
            }
        }
    }

    void call(b bVar) throws RemoteException;
}

package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.core.aidl.c */
/* loaded from: classes10.dex */
public interface InterfaceC5548c extends IInterface {

    /* compiled from: Taobao */
    /* renamed from: com.huawei.hms.core.aidl.c$a */
    /* loaded from: classes10.dex */
    public static abstract class AbstractBinderC5549a extends Binder implements InterfaceC5548c {

        /* compiled from: Taobao */
        /* renamed from: com.huawei.hms.core.aidl.c$a$a */
        /* loaded from: classes10.dex */
        private static class C5550a implements InterfaceC5548c {
            public static InterfaceC5548c b;
            private IBinder a;

            C5550a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public AbstractBinderC5549a() {
            attachInterface(this, "com.huawei.hms.core.aidl.IAIDLCallback");
        }

        public static InterfaceC5548c asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.core.aidl.IAIDLCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC5548c)) {
                return (InterfaceC5548c) queryLocalInterface;
            }
            return new C5550a(iBinder);
        }

        public static InterfaceC5548c getDefaultImpl() {
            return C5550a.b;
        }

        public static boolean setDefaultImpl(InterfaceC5548c interfaceC5548c) {
            if (C5550a.b != null || interfaceC5548c == null) {
                return false;
            }
            C5550a.b = interfaceC5548c;
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
                call(parcel.readInt() != 0 ? C5546b.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.huawei.hms.core.aidl.IAIDLCallback");
                return true;
            }
        }
    }

    void call(C5546b c5546b) throws RemoteException;
}

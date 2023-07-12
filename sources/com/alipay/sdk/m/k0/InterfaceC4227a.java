package com.alipay.sdk.m.k0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.k0.a */
/* loaded from: classes12.dex */
public interface InterfaceC4227a extends IInterface {
    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b(String str) throws RemoteException;

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.k0.a$a */
    /* loaded from: classes10.dex */
    public static abstract class AbstractBinderC4228a extends Binder implements InterfaceC4227a {
        public static final String a = "com.samsung.android.deviceidservice.IDeviceIdService";
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;

        public AbstractBinderC4228a() {
            attachInterface(this, a);
        }

        public static InterfaceC4227a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a);
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC4227a)) {
                return (InterfaceC4227a) queryLocalInterface;
            }
            return new C4229a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(a);
                String a2 = a();
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(a);
                String b2 = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(b2);
                return true;
            } else if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(a);
                return true;
            } else {
                parcel.enforceInterface(a);
                String a3 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a3);
                return true;
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.alipay.sdk.m.k0.a$a$a */
        /* loaded from: classes10.dex */
        public static class C4229a implements InterfaceC4227a {
            public IBinder a;

            public C4229a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.alipay.sdk.m.k0.InterfaceC4227a
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC4228a.a);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.alipay.sdk.m.k0.InterfaceC4227a
            public String b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC4228a.a);
                    obtain.writeString(str);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String d() {
                return AbstractBinderC4228a.a;
            }

            @Override // com.alipay.sdk.m.k0.InterfaceC4227a
            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC4228a.a);
                    obtain.writeString(str);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

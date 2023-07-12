package com.alibaba.security.rp.service.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.alibaba.security.rp.service.aidl.IRPCompletedListener;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface IRPService extends IInterface {

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static abstract class Stub extends Binder implements IRPService {
        private static final String DESCRIPTOR = "com.alibaba.security.rp.service.aidl.IRPService";
        static final int TRANSACTION_start = 1;
        static final int TRANSACTION_startVerifyByNative = 2;
        static final int TRANSACTION_startVerifyByUrl = 3;

        /* compiled from: Taobao */
        /* loaded from: classes8.dex */
        static class Proxy implements IRPService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.alibaba.security.rp.service.aidl.IRPService
            public void start(String str, IRPCompletedListener iRPCompletedListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iRPCompletedListener != null ? iRPCompletedListener.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.security.rp.service.aidl.IRPService
            public void startVerifyByNative(String str, String str2, IRPCompletedListener iRPCompletedListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(iRPCompletedListener != null ? iRPCompletedListener.asBinder() : null);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.security.rp.service.aidl.IRPService
            public void startVerifyByUrl(String str, IRPCompletedListener iRPCompletedListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iRPCompletedListener != null ? iRPCompletedListener.asBinder() : null);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRPService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IRPService)) {
                return (IRPService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                start(parcel.readString(), IRPCompletedListener.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                startVerifyByNative(parcel.readString(), parcel.readString(), IRPCompletedListener.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            } else {
                parcel.enforceInterface(DESCRIPTOR);
                startVerifyByUrl(parcel.readString(), IRPCompletedListener.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
        }
    }

    void start(String str, IRPCompletedListener iRPCompletedListener) throws RemoteException;

    void startVerifyByNative(String str, String str2, IRPCompletedListener iRPCompletedListener) throws RemoteException;

    void startVerifyByUrl(String str, IRPCompletedListener iRPCompletedListener) throws RemoteException;
}

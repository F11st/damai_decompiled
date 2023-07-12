package mtopsdk.xstate.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IXState extends IInterface {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static abstract class Stub extends Binder implements IXState {
        private static final String DESCRIPTOR = "mtopsdk.xstate.aidl.IXState";
        static final int TRANSACTION_getValue = 1;
        static final int TRANSACTION_init = 4;
        static final int TRANSACTION_removeKey = 2;
        static final int TRANSACTION_setValue = 3;
        static final int TRANSACTION_unInit = 5;

        /* compiled from: Taobao */
        /* loaded from: classes11.dex */
        private static class Proxy implements IXState {
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

            @Override // mtopsdk.xstate.aidl.IXState
            public String getValue(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // mtopsdk.xstate.aidl.IXState
            public void init() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // mtopsdk.xstate.aidl.IXState
            public String removeKey(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // mtopsdk.xstate.aidl.IXState
            public void setValue(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // mtopsdk.xstate.aidl.IXState
            public void unInit() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(5, obtain, obtain2, 0);
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

        public static IXState asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IXState)) {
                return (IXState) queryLocalInterface;
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
                String value = getValue(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(value);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                String removeKey = removeKey(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(removeKey);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                setValue(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                init();
                parcel2.writeNoException();
                return true;
            } else if (i != 5) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            } else {
                parcel.enforceInterface(DESCRIPTOR);
                unInit();
                parcel2.writeNoException();
                return true;
            }
        }
    }

    String getValue(String str) throws RemoteException;

    void init() throws RemoteException;

    String removeKey(String str) throws RemoteException;

    void setValue(String str, String str2) throws RemoteException;

    void unInit() throws RemoteException;
}

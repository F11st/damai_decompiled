package com.taobao.orange.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface ParcelableCandidateCompare extends IInterface {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static abstract class Stub extends Binder implements ParcelableCandidateCompare {
        private static final String DESCRIPTOR = "com.taobao.orange.aidl.ParcelableCandidateCompare";
        static final int TRANSACTION_equals = 1;
        static final int TRANSACTION_equalsNot = 2;
        static final int TRANSACTION_fuzzy = 7;
        static final int TRANSACTION_fuzzyNot = 8;
        static final int TRANSACTION_greater = 3;
        static final int TRANSACTION_greaterEquals = 4;
        static final int TRANSACTION_less = 5;
        static final int TRANSACTION_lessEquals = 6;

        /* compiled from: Taobao */
        /* loaded from: classes11.dex */
        private static class Proxy implements ParcelableCandidateCompare {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.taobao.orange.aidl.ParcelableCandidateCompare
            public boolean equals(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.taobao.orange.aidl.ParcelableCandidateCompare
            public boolean equalsNot(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.taobao.orange.aidl.ParcelableCandidateCompare
            public boolean fuzzy(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.taobao.orange.aidl.ParcelableCandidateCompare
            public boolean fuzzyNot(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.taobao.orange.aidl.ParcelableCandidateCompare
            public boolean greater(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.taobao.orange.aidl.ParcelableCandidateCompare
            public boolean greaterEquals(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.taobao.orange.aidl.ParcelableCandidateCompare
            public boolean less(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.taobao.orange.aidl.ParcelableCandidateCompare
            public boolean lessEquals(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ParcelableCandidateCompare asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ParcelableCandidateCompare)) {
                return (ParcelableCandidateCompare) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean equals = equals(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(equals ? 1 : 0);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean equalsNot = equalsNot(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(equalsNot ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean greater = greater(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(greater ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean greaterEquals = greaterEquals(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(greaterEquals ? 1 : 0);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean less = less(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(less ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean lessEquals = lessEquals(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(lessEquals ? 1 : 0);
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean fuzzy = fuzzy(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(fuzzy ? 1 : 0);
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean fuzzyNot = fuzzyNot(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(fuzzyNot ? 1 : 0);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }

    boolean equals(String str, String str2) throws RemoteException;

    boolean equalsNot(String str, String str2) throws RemoteException;

    boolean fuzzy(String str, String str2) throws RemoteException;

    boolean fuzzyNot(String str, String str2) throws RemoteException;

    boolean greater(String str, String str2) throws RemoteException;

    boolean greaterEquals(String str, String str2) throws RemoteException;

    boolean less(String str, String str2) throws RemoteException;

    boolean lessEquals(String str, String str2) throws RemoteException;
}

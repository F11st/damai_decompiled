package com.taobao.orange.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.taobao.orange.OConfig;
import com.taobao.orange.aidl.ParcelableCandidateCompare;
import com.taobao.orange.aidl.ParcelableConfigListener;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IOrangeApiService extends IInterface {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static abstract class Stub extends Binder implements IOrangeApiService {
        private static final String DESCRIPTOR = "com.taobao.orange.aidl.IOrangeApiService";
        static final int TRANSACTION_addCandidate = 11;
        static final int TRANSACTION_addFails = 9;
        static final int TRANSACTION_forceCheckUpdate = 8;
        static final int TRANSACTION_getConfig = 2;
        static final int TRANSACTION_getConfigs = 3;
        static final int TRANSACTION_getCustomConfig = 4;
        static final int TRANSACTION_init = 1;
        static final int TRANSACTION_registerListener = 5;
        static final int TRANSACTION_setUserId = 10;
        static final int TRANSACTION_unregisterListener = 6;
        static final int TRANSACTION_unregisterListeners = 7;

        /* compiled from: Taobao */
        /* loaded from: classes11.dex */
        private static class Proxy implements IOrangeApiService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.taobao.orange.aidl.IOrangeApiService
            public void addCandidate(String str, String str2, ParcelableCandidateCompare parcelableCandidateCompare) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(parcelableCandidateCompare != null ? parcelableCandidateCompare.asBinder() : null);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.taobao.orange.aidl.IOrangeApiService
            public void addFails(String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStringArray(strArr);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.taobao.orange.aidl.IOrangeApiService
            public void forceCheckUpdate() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.taobao.orange.aidl.IOrangeApiService
            public String getConfig(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.taobao.orange.aidl.IOrangeApiService
            public Map getConfigs(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.taobao.orange.aidl.IOrangeApiService
            public String getCustomConfig(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.taobao.orange.aidl.IOrangeApiService
            public void init(OConfig oConfig) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (oConfig != null) {
                        obtain.writeInt(1);
                        oConfig.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.taobao.orange.aidl.IOrangeApiService
            public void registerListener(String str, ParcelableConfigListener parcelableConfigListener, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(parcelableConfigListener != null ? parcelableConfigListener.asBinder() : null);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.taobao.orange.aidl.IOrangeApiService
            public void setUserId(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.taobao.orange.aidl.IOrangeApiService
            public void unregisterListener(String str, ParcelableConfigListener parcelableConfigListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(parcelableConfigListener != null ? parcelableConfigListener.asBinder() : null);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.taobao.orange.aidl.IOrangeApiService
            public void unregisterListeners(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(7, obtain, obtain2, 0);
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

        public static IOrangeApiService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IOrangeApiService)) {
                return (IOrangeApiService) queryLocalInterface;
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
                        init(parcel.readInt() != 0 ? OConfig.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        String config = getConfig(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(config);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        Map configs = getConfigs(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeMap(configs);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        String customConfig = getCustomConfig(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(customConfig);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        registerListener(parcel.readString(), ParcelableConfigListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        unregisterListener(parcel.readString(), ParcelableConfigListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        unregisterListeners(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        forceCheckUpdate();
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        addFails(parcel.createStringArray());
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        setUserId(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        addCandidate(parcel.readString(), parcel.readString(), ParcelableCandidateCompare.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }

    void addCandidate(String str, String str2, ParcelableCandidateCompare parcelableCandidateCompare) throws RemoteException;

    void addFails(String[] strArr) throws RemoteException;

    void forceCheckUpdate() throws RemoteException;

    String getConfig(String str, String str2, String str3) throws RemoteException;

    Map getConfigs(String str) throws RemoteException;

    String getCustomConfig(String str, String str2) throws RemoteException;

    void init(OConfig oConfig) throws RemoteException;

    void registerListener(String str, ParcelableConfigListener parcelableConfigListener, boolean z) throws RemoteException;

    void setUserId(String str) throws RemoteException;

    void unregisterListener(String str, ParcelableConfigListener parcelableConfigListener) throws RemoteException;

    void unregisterListeners(String str) throws RemoteException;
}

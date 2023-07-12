package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import anetwork.channel.aidl.ParcelableInputStream;
import anetwork.channel.statist.StatisticData;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface Connection extends IInterface {

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements Connection {
        private static final String DESCRIPTOR = "anetwork.channel.aidl.Connection";
        static final int TRANSACTION_cancel = 6;
        static final int TRANSACTION_getConnHeadFields = 4;
        static final int TRANSACTION_getDesc = 3;
        static final int TRANSACTION_getInputStream = 1;
        static final int TRANSACTION_getStatisticData = 5;
        static final int TRANSACTION_getStatusCode = 2;

        /* compiled from: Taobao */
        /* loaded from: classes.dex */
        private static class Proxy implements Connection {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // anetwork.channel.aidl.Connection
            public void cancel() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.Connection
            public Map getConnHeadFields() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.Connection
            public String getDesc() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.Connection
            public ParcelableInputStream getInputStream() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return ParcelableInputStream.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // anetwork.channel.aidl.Connection
            public StatisticData getStatisticData() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() == 1 ? (StatisticData) obtain2.readSerializable() : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.Connection
            public int getStatusCode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static Connection asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof Connection)) {
                return (Connection) queryLocalInterface;
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
                        ParcelableInputStream inputStream = getInputStream();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(inputStream != null ? inputStream.asBinder() : null);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        int statusCode = getStatusCode();
                        parcel2.writeNoException();
                        parcel2.writeInt(statusCode);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        String desc = getDesc();
                        parcel2.writeNoException();
                        parcel2.writeString(desc);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        Map connHeadFields = getConnHeadFields();
                        parcel2.writeNoException();
                        parcel2.writeMap(connHeadFields);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        StatisticData statisticData = getStatisticData();
                        parcel2.writeNoException();
                        if (statisticData != null) {
                            parcel2.writeInt(1);
                            parcel2.writeSerializable(statisticData);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        cancel();
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

    void cancel() throws RemoteException;

    Map getConnHeadFields() throws RemoteException;

    String getDesc() throws RemoteException;

    ParcelableInputStream getInputStream() throws RemoteException;

    StatisticData getStatisticData() throws RemoteException;

    int getStatusCode() throws RemoteException;
}

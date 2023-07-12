package com.google.vr.vrcore.library.api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.aidl.BaseProxy;
import com.google.android.aidl.BaseStub;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IVrNativeLibraryLoader extends IInterface {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class Stub extends BaseStub implements IVrNativeLibraryLoader {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.library.api.IVrNativeLibraryLoader";
        static final int TRANSACTION_closeNativeGvrLibrary = 3;
        static final int TRANSACTION_loadNativeDlsymMethod = 4;
        static final int TRANSACTION_loadNativeGvrLibrary = 2;
        static final int TRANSACTION_loadNativeGvrLibraryWithMinVersion = 5;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static class Proxy extends BaseProxy implements IVrNativeLibraryLoader {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            @Override // com.google.vr.vrcore.library.api.IVrNativeLibraryLoader
            public void closeNativeGvrLibrary(long j) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeLong(j);
                transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken);
            }

            @Override // com.google.vr.vrcore.library.api.IVrNativeLibraryLoader
            public long loadNativeDlsymMethod() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken());
                long readLong = transactAndReadException.readLong();
                transactAndReadException.recycle();
                return readLong;
            }

            @Override // com.google.vr.vrcore.library.api.IVrNativeLibraryLoader
            public long loadNativeGvrLibrary(int i, int i2, int i3) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                obtainAndWriteInterfaceToken.writeInt(i2);
                obtainAndWriteInterfaceToken.writeInt(i3);
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken);
                long readLong = transactAndReadException.readLong();
                transactAndReadException.recycle();
                return readLong;
            }

            @Override // com.google.vr.vrcore.library.api.IVrNativeLibraryLoader
            public long loadNativeGvrLibraryWithMinVersion(String str, String str2) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeString(str);
                obtainAndWriteInterfaceToken.writeString(str2);
                Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken);
                long readLong = transactAndReadException.readLong();
                transactAndReadException.recycle();
                return readLong;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IVrNativeLibraryLoader asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IVrNativeLibraryLoader) {
                return (IVrNativeLibraryLoader) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (routeToSuperOrEnforceInterface(i, parcel, parcel2, i2)) {
                return true;
            }
            if (i == 2) {
                long loadNativeGvrLibrary = loadNativeGvrLibrary(parcel.readInt(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeLong(loadNativeGvrLibrary);
            } else if (i == 3) {
                closeNativeGvrLibrary(parcel.readLong());
                parcel2.writeNoException();
            } else if (i == 4) {
                long loadNativeDlsymMethod = loadNativeDlsymMethod();
                parcel2.writeNoException();
                parcel2.writeLong(loadNativeDlsymMethod);
            } else if (i != 5) {
                return false;
            } else {
                long loadNativeGvrLibraryWithMinVersion = loadNativeGvrLibraryWithMinVersion(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(loadNativeGvrLibraryWithMinVersion);
            }
            return true;
        }
    }

    void closeNativeGvrLibrary(long j) throws RemoteException;

    long loadNativeDlsymMethod() throws RemoteException;

    long loadNativeGvrLibrary(int i, int i2, int i3) throws RemoteException;

    long loadNativeGvrLibraryWithMinVersion(String str, String str2) throws RemoteException;
}

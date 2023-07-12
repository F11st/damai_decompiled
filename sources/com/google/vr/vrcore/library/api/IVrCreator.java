package com.google.vr.vrcore.library.api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.aidl.BaseProxy;
import com.google.android.aidl.BaseStub;
import com.google.android.aidl.Codecs;
import com.google.vr.vrcore.library.api.IGvrLayout;
import com.google.vr.vrcore.library.api.IObjectWrapper;
import com.google.vr.vrcore.library.api.IVrNativeLibraryLoader;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IVrCreator extends IInterface {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class Stub extends BaseStub implements IVrCreator {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.library.api.IVrCreator";
        static final int TRANSACTION_DEPRECATED_newNativeLibraryLoader = 3;
        static final int TRANSACTION_newGvrLayout = 5;
        static final int TRANSACTION_newNativeLibraryLoader = 4;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static class Proxy extends BaseProxy implements IVrCreator {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            @Override // com.google.vr.vrcore.library.api.IVrCreator
            public IVrNativeLibraryLoader DEPRECATED_newNativeLibraryLoader(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeStrongBinder(obtainAndWriteInterfaceToken, iObjectWrapper);
                Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken);
                IVrNativeLibraryLoader asInterface = IVrNativeLibraryLoader.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            @Override // com.google.vr.vrcore.library.api.IVrCreator
            public IGvrLayout newGvrLayout(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeStrongBinder(obtainAndWriteInterfaceToken, iObjectWrapper);
                Codecs.writeStrongBinder(obtainAndWriteInterfaceToken, iObjectWrapper2);
                Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken);
                IGvrLayout asInterface = IGvrLayout.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            @Override // com.google.vr.vrcore.library.api.IVrCreator
            public IVrNativeLibraryLoader newNativeLibraryLoader(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeStrongBinder(obtainAndWriteInterfaceToken, iObjectWrapper);
                Codecs.writeStrongBinder(obtainAndWriteInterfaceToken, iObjectWrapper2);
                Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken);
                IVrNativeLibraryLoader asInterface = IVrNativeLibraryLoader.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IVrCreator asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IVrCreator) {
                return (IVrCreator) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (routeToSuperOrEnforceInterface(i, parcel, parcel2, i2)) {
                return true;
            }
            if (i == 3) {
                IVrNativeLibraryLoader DEPRECATED_newNativeLibraryLoader = DEPRECATED_newNativeLibraryLoader(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                Codecs.writeStrongBinder(parcel2, DEPRECATED_newNativeLibraryLoader);
            } else if (i == 4) {
                IVrNativeLibraryLoader newNativeLibraryLoader = newNativeLibraryLoader(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                Codecs.writeStrongBinder(parcel2, newNativeLibraryLoader);
            } else if (i != 5) {
                return false;
            } else {
                IGvrLayout newGvrLayout = newGvrLayout(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                Codecs.writeStrongBinder(parcel2, newGvrLayout);
            }
            return true;
        }
    }

    IVrNativeLibraryLoader DEPRECATED_newNativeLibraryLoader(IObjectWrapper iObjectWrapper) throws RemoteException;

    IGvrLayout newGvrLayout(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    IVrNativeLibraryLoader newNativeLibraryLoader(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;
}

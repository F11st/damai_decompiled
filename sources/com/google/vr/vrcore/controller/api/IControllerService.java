package com.google.vr.vrcore.controller.api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.aidl.BaseProxy;
import com.google.android.aidl.BaseStub;
import com.google.android.aidl.Codecs;
import com.google.vr.vrcore.controller.api.IControllerListener;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IControllerService extends IInterface {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class Stub extends BaseStub implements IControllerService {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.controller.api.IControllerService";
        static final int TRANSACTION_initialize = 1;
        static final int TRANSACTION_registerListener = 5;
        static final int TRANSACTION_unregisterListener = 6;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static class Proxy extends BaseProxy implements IControllerService {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            @Override // com.google.vr.vrcore.controller.api.IControllerService
            public int initialize(int i) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
                int readInt = transactAndReadException.readInt();
                transactAndReadException.recycle();
                return readInt;
            }

            @Override // com.google.vr.vrcore.controller.api.IControllerService
            public boolean registerListener(int i, String str, IControllerListener iControllerListener) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                obtainAndWriteInterfaceToken.writeString(str);
                Codecs.writeStrongBinder(obtainAndWriteInterfaceToken, iControllerListener);
                Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken);
                boolean createBoolean = Codecs.createBoolean(transactAndReadException);
                transactAndReadException.recycle();
                return createBoolean;
            }

            @Override // com.google.vr.vrcore.controller.api.IControllerService
            public boolean unregisterListener(String str) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeString(str);
                Parcel transactAndReadException = transactAndReadException(6, obtainAndWriteInterfaceToken);
                boolean createBoolean = Codecs.createBoolean(transactAndReadException);
                transactAndReadException.recycle();
                return createBoolean;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IControllerService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IControllerService) {
                return (IControllerService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (routeToSuperOrEnforceInterface(i, parcel, parcel2, i2)) {
                return true;
            }
            if (i == 1) {
                int initialize = initialize(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(initialize);
            } else if (i == 5) {
                boolean registerListener = registerListener(parcel.readInt(), parcel.readString(), IControllerListener.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                Codecs.writeBoolean(parcel2, registerListener);
            } else if (i != 6) {
                return false;
            } else {
                boolean unregisterListener = unregisterListener(parcel.readString());
                parcel2.writeNoException();
                Codecs.writeBoolean(parcel2, unregisterListener);
            }
            return true;
        }
    }

    int initialize(int i) throws RemoteException;

    boolean registerListener(int i, String str, IControllerListener iControllerListener) throws RemoteException;

    boolean unregisterListener(String str) throws RemoteException;
}
